package com.linjun.java.springMvcWeb.webServer.controller;

import com.linjun.java.springMvcWeb.webServer.bo.*;
import com.linjun.java.springMvcWeb.dal.bo.Employee;
import com.linjun.java.springMvcWeb.dal.helpers.EmployeeHelper;
import com.linjun.java.springMvcWeb.webServer.helpers.RabbitmqHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

/**
 * Created by linjun on 16/4/7.
 */
@Controller
public class MyRestController {
    private static Logger logger = LogManager.getLogger(MyRestController.class);

    /*
    @RequestMapping(value = "/adminRestBatchRegister/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Cat getCat(@PathVariable int id) {
        logger.info("getCat");
        return CatDal.getCatById(id);
    }
    */

    @RequestMapping(value = "/rest/adminRestBatchRegister", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    JsonResult batchRegister(@RequestBody String modelJSON) {
        logger.info("adminRestBatchRegister");
        logger.info(modelJSON);
        ObjectMapper mapper = new ObjectMapper();
        try{
            BatchRegisterEmployeeRequest[] es = mapper.readValue(modelJSON, BatchRegisterEmployeeRequest[].class);

            for(BatchRegisterEmployeeRequest e: es){
                logger.info(e.getName());
                Employee t = new Employee();

                Date d = new Date();
                String ds = d.getYear()+"-"+d.getMonth()+"-"+d.getDate();
                EmployeeHelper.create(
                    e.getName(),
                    e.getPassword(),
                    e.getIdCard(),
                    e.getGender(),
                    ds,
                    "ROLE_ADMIN");
            }
        }catch (Exception ex){

        }
        return new JsonResult("OK", "success");
    }

    @RequestMapping(value = "/rest/adminSendCmd", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    JsonResult sendCmd(@RequestBody String modelJSON) {
        logger.info(modelJSON);
        ObjectMapper mapper = new ObjectMapper();
        // TODO&FIXME: Beware: it's synchronization call, need consider the performance issue.
        StringBuilder sb = new StringBuilder();
        try {
            SendCmdRequest cmdBo = mapper.readValue(modelJSON, SendCmdRequest.class);
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(cmdBo.getCmd());
            logger.info("Cmd: " + cmdBo.getCmd());
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String s = null;
            while((s=bufferedReader.readLine()) != null) {
                logger.info("Cmd output: " + s);
                sb.append(s);
            }
            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        return new JsonResult("OK", sb.toString());
    }

    @RequestMapping(value = "/rest/adminSendMsg", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    JsonResult sendMsg(@RequestBody String modelJSON) {
        logger.info(modelJSON);
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder sb = new StringBuilder();
        try {
            SendMsgRequest requestBo = mapper.readValue(modelJSON, SendMsgRequest.class);
            logger.info("Msg: " + requestBo.getMsg());
            RabbitmqHelper.send(requestBo.getMsg());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JsonResult("OK", sb.toString());
    }

    @RequestMapping(value = "/rest/adminSave2Redis", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    JsonResult save2Redis(@RequestBody String modelJSON) {
        logger.info(modelJSON);
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder sb = new StringBuilder();
        try {
            Save2RedisRequest requestBo = mapper.readValue(modelJSON, Save2RedisRequest.class);
            logger.info("Key: " + requestBo.getKey());
            logger.info("Value: " + requestBo.getValue());
            Jedis jedis = new Jedis("localhost");
            jedis.set(requestBo.getKey(), requestBo.getValue());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JsonResult("OK", sb.toString());
    }

    @RequestMapping(value = "/rest/adminGetFromRedis", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    JsonResult getFromRedis(@RequestBody String modelJSON) {
        logger.info(modelJSON);
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder sb = new StringBuilder();
        try {
            Save2RedisRequest requestBo = mapper.readValue(modelJSON, Save2RedisRequest.class);
            logger.info("Key: " + requestBo.getKey());
            Jedis jedis = new Jedis("localhost");
            sb.append(jedis.get(requestBo.getKey()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JsonResult("OK", sb.toString());
    }
}

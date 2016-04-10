package com.linjun.java.springMvcWeb.controller;

import com.linjun.java.springMvcWeb.bo.Cat;
import com.linjun.java.springMvcWeb.bo.Employee;
import com.linjun.java.springMvcWeb.bo.JsonResult;
import com.linjun.java.springMvcWeb.dal.CatDal;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.ArrayList;

//import org.apache.commons.lang.StringEscapeUtils;

/**
 * Created by linjun on 16/4/7.
 */
@Controller
public class MyRestController {
    private static Logger logger = LogManager.getLogger(MyRestController.class);

    @RequestMapping(value = "/adminRestBatchRegister/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Cat getCat(@PathVariable int id) {
        logger.info("getCat");
        return CatDal.getCatById(id);
    }

    @RequestMapping(value = "/rest/adminRestBatchRegister", method = RequestMethod.POST)
    public @ResponseBody
    JsonResult batchRegister(@RequestBody String modelJSON) {
        logger.info("adminRestBatchRegister");
        /*
        String realJSON = StringEscapeUtils.unescapeHtml(modelJSON);
        String linjun = "{\"name\":\"linjun\",\"pw\":pw,\"idCard\":\"123444321\"}";
        logger.info(modelJSON);
        logger.info(realJSON);
        ObjectMapper mapper = new ObjectMapper();
        try{
            Employee es = mapper.readValue(linjun, Employee.class);
            logger.info(es.getName());
        }catch (Exception ex){

        }
        */
        //return list;
        return new JsonResult("OK", "success");
    }
}

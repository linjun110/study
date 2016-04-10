package com.linjun.java.springMvcWeb.controller;

import com.linjun.java.springMvcWeb.bo.BatchEmployeeBO;
import com.linjun.java.springMvcWeb.bo.Cat;
import com.linjun.java.springMvcWeb.bo.Employee;
import com.linjun.java.springMvcWeb.bo.JsonResult;
import com.linjun.java.springMvcWeb.dal.CatDal;
import com.linjun.java.springMvcWeb.dal.EmployeeDal;
import com.linjun.java.springMvcWeb.utils.CommonUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

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

    @RequestMapping(value = "/rest/adminRestBatchRegister", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    JsonResult batchRegister(@RequestBody String modelJSON) {
        logger.info("adminRestBatchRegister");
        logger.info(modelJSON);
        ObjectMapper mapper = new ObjectMapper();
        try{
            BatchEmployeeBO[] es = mapper.readValue(modelJSON, BatchEmployeeBO[].class);

            for(BatchEmployeeBO e: es){
                logger.info(e.getName());
                Employee t = new Employee();

                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                t.setId(CommonUtil.genUUID());
                t.setName(e.getName());
                t.setPassword(passwordEncoder.encode(e.getPw()));
                t.setIdCard(e.getIdCard());
                t.setGender(1);
                t.setBirthday(new Date().getTime());
                t.setRole("ROLE_ADMIN");
                t.setEnabled(1);
                EmployeeDal.create(t);
            }
        }catch (Exception ex){

        }
        return new JsonResult("OK", "success");
    }
}

package com.linjun.java.springMvcWeb.controller;

import com.linjun.java.springMvcWeb.bo.BatchRegisterEmployee;
import com.linjun.java.springMvcWeb.bo.Employee;
import com.linjun.java.springMvcWeb.bo.JsonResult;
import com.linjun.java.springMvcWeb.dal.EmployeeDal;
import com.linjun.java.springMvcWeb.helpers.EmployeeHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
            BatchRegisterEmployee[] es = mapper.readValue(modelJSON, BatchRegisterEmployee[].class);

            for(BatchRegisterEmployee e: es){
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
                EmployeeDal.create(t);
            }
        }catch (Exception ex){

        }
        return new JsonResult("OK", "success");
    }
}

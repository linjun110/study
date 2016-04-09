package com.linjun.java.springMvcWeb.controller;

import com.linjun.java.springMvcWeb.bo.Employee;
import com.linjun.java.springMvcWeb.dal.EmployeeDal;
import com.linjun.java.springMvcWeb.utils.DateUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by linjun on 16/4/7.
 */
@Controller
public class MyController {
    private static Logger logger = LogManager.getLogger(MyController.class);

    @RequestMapping("/")
    private String home(){
        return "forward:/index";
    }

    @RequestMapping("/index")
    private String index(){
        return "index";
    }

    @RequestMapping("/cat")
    private String cat(ModelMap modelMap){
        logger.info("Cat meow");
        modelMap.addAttribute("myBoolean1", true);
        modelMap.addAttribute("myBoolean2", false);
        modelMap.addAttribute("myInt", 5);
        modelMap.addAttribute("message", "hi I am message");
        return "cat";
    }

    @RequestMapping("/login")
    private String login(){
        logger.info("login");
        return "login";
    }

    @RequestMapping("/register")
    private String register(){
        logger.info("register");
        return "register";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    private String addUser(@RequestParam(value="username", required=true) String username,
                           @RequestParam(value="password", required=true) String password,
                           @RequestParam(value="idCard", required=true) String idCard,
                           @RequestParam(value="gender", required=true) Integer gender,
                           @RequestParam(value="birthday", required=true) String birthday){
        logger.info("addUser");
        logger.info(username);
        logger.info(password);
        logger.info(idCard);
        logger.info(gender);
        logger.info(birthday);

        Employee e = new Employee(username, password, idCard, gender, DateUtil.parseDateFromString(birthday).getTime());
        EmployeeDal.create(e);

        return "redirect:/index";
    }
}

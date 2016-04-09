package com.linjun.java.springMvcWeb.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    private String addUser(){
        logger.info("addUser");
        return "redirect:/index";
    }
}

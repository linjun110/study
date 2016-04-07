package com.linjun.java.springMvcWeb.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by linjun on 16/4/7.
 */
@Controller
public class MyController {
    private static Logger logger = LogManager.getLogger(MyController.class);

    @RequestMapping("/")
    private String hello(){
        return "index";

    }

    @RequestMapping("/cat")
    private String cat(){
        logger.info("Cat meow");
        return "cat";

    }

    @RequestMapping("/dog")
    private String dog(){
        logger.info("Dog bark");
        return "dog";

    }
}

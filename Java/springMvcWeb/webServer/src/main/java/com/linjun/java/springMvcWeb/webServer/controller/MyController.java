package com.linjun.java.springMvcWeb.webServer.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Cookie;

/**
 * Created by linjun on 16/4/7.
 */
@Controller
public class MyController {
    private static Logger logger = LogManager.getLogger(MyController.class);

    @RequestMapping("/")
    private String home(){
        //TODO: research, why access / doesn't go here.
        return "forward:/index";
    }

    @RequestMapping("/index")
    private String index(HttpServletRequest request, ModelMap modelMap){
        Cookie[] cookies = request.getCookies();
        for (int i=0; i<cookies.length; i++) {
            if(cookies[i].getName().equals("name")){
                modelMap.addAttribute("name", cookies[i].getValue());
            }
        }

        return "index";
    }

    @RequestMapping("/adminSap")
    private String sapPage(){
        logger.info("access adminSap page");
        return "adminSap";
    }
}

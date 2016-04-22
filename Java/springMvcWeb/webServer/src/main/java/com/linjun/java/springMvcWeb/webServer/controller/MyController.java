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

    @RequestMapping("/css3animate")
    private String css3animatePage(){
        logger.info("access css3animate page");
        return "css3animate";
    }

    @RequestMapping("/simLayout")
    private String simLayoutPage(){
        logger.info("access simLayout page");
        return "simLayout";
    }

    @RequestMapping("/3dbutton")
    private String threedbuttonPage(){
        logger.info("access 3dbutton page");
        return "3dbutton";
    }
}

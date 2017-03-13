package com.linjun.java.springMvcWeb.webServer.controller;

import com.linjun.java.springMvcWeb.webServer.annotations.AspectHandle;
import com.linjun.java.springMvcWeb.webServer.localBeans.LocalBeanFoo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private LocalBeanFoo localBeanFoo;

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

    @AspectHandle
    @RequestMapping("/adminSap")
    public String sapPage(){
        logger.info("access adminSap page");
        return "adminSap";
    }

    @RequestMapping("/adminReact")
    private String reactPage(){
        logger.info("access adminReact page");
        return "adminReact";
    }

    @AspectHandle
    @RequestMapping("/css3animate")
    public String css3animatePage(){
        logger.info("access css3animate page");
        return "css3animate";
    }

    @RequestMapping("/simLayout")
    private String simLayoutPage(){
        logger.info("access simLayout page");
        return "simLayout";
    }

    @AspectHandle
    @RequestMapping("/3dbutton")
    public String threedbuttonPage(){
        logger.info("access 3dbutton page");
        return "3dbutton";
    }

    @RequestMapping("/d3")
    private String d3Page(){
        localBeanFoo.say();
        logger.info("access d3 page");
        return "d3";
    }

    @RequestMapping("/highChart")
    private String highChartPage(){
        logger.info("access highChart page");
        return "highChart";
    }

    @RequestMapping("/svg")
    private String svgPage(){
        logger.info("access svg page");
        return "svg";
    }

    public void setLocalBeanFoo(LocalBeanFoo localBeanFoo) {
        this.localBeanFoo = localBeanFoo;
    }

}

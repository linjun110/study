package com.linjun.java.springMvcWeb.webServer.controller;

import com.linjun.java.springMvcWeb.dal.bo.Employee;
import com.linjun.java.springMvcWeb.dal.dal.EmployeeDal;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by linjun on 16/4/7.
 */
@Controller
public class DeprecatedController {
    private static Logger logger = LogManager.getLogger(DeprecatedController.class);

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Password Encoder");
        model.addObject("message", "This page is for ROLE_ADMIN only!");
        model.setViewName("admin");

        return model;

    }

    @RequestMapping(value = "/myLogin", method = RequestMethod.POST)
    private String login(HttpServletResponse response, ModelMap modelMap, @RequestParam(value="username", required=true) String username,
                         @RequestParam(value="password", required=true) String password){
        logger.info("login");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Employee employee = EmployeeDal.getByName(username);
        if(null != employee && passwordEncoder.matches(password, employee.getPassword())){
            logger.info("login success");
            response.addCookie(new Cookie("id", employee.getId()));
            response.addCookie(new Cookie("name", employee.getName()));
            Cookie token = new Cookie("token", "bbb");
            token.setMaxAge(60);
            response.addCookie(token);
        }else{
            logger.info("login fail");
            response.addCookie(new Cookie("token", ""));
        }

        return "redirect:/index";
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
}

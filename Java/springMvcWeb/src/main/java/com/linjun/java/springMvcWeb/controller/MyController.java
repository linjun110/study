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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import org.springframework.web.bind.annotation.CookieValue;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
    private String index(HttpServletRequest request, ModelMap modelMap){
        Cookie[] cookies = request.getCookies();
        for (int i=0; i<cookies.length; i++) {
            if(cookies[i].getName().equals("name")){
                modelMap.addAttribute("name", cookies[i].getValue());
            }
        }
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private String login(HttpServletResponse response, ModelMap modelMap, @RequestParam(value="username", required=true) String username,
            @RequestParam(value="password", required=true) String password){
        logger.info("login");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Employee employee = EmployeeDal.getByNameAndPassword(username, passwordEncoder.encode(password));
        if(null != employee){
            logger.info("login success");
            response.addCookie(new Cookie("id", employee.getUuid()));
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

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Employee e = new Employee(username, passwordEncoder.encode(password), idCard, gender, DateUtil.parseDateFromString(birthday).getTime());
        EmployeeDal.create(e);

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

package com.linjun.java.springMvcWeb.controller;

import com.linjun.java.springMvcWeb.bo.Employee;
import com.linjun.java.springMvcWeb.dal.EmployeeDal;
import com.linjun.java.springMvcWeb.utils.DateUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by linjun on 16/4/7.
 */
@Controller
public class SecurityController {
    private static Logger logger = LogManager.getLogger(SecurityController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "无效的姓名或密码!");
        }

        if (logout != null) {
            model.addObject("msg", "成功登出.");
        }
        model.setViewName("index");

        return model;

    }

    @RequestMapping("/register")
    private String register(){
        logger.info("register");
        return "register";
    }

    @RequestMapping("/batchRegister")
    private String batchRegister(){
        logger.info("batchRegister");
        //TODO: add function to batch Register employee
        return "batchRegister";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    private String addUser(@RequestParam(value="username", required=true) String username,
                           @RequestParam(value="password", required=true) String password,
                           @RequestParam(value="idCard", required=true) String idCard,
                           @RequestParam(value="gender", required=true) Integer gender,
                           @RequestParam(value="birthday", required=true) String birthday){
        logger.info("addUser");

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Employee e = new Employee(username,
                passwordEncoder.encode(password),
                idCard,
                gender,
                DateUtil.parseDateFromString(birthday).getTime(),
                "ROLE_ADMIN", 1);
        EmployeeDal.create(e);

        return "redirect:/index";
    }
}

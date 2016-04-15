package com.linjun.java.springMvcWeb.webServer.controller;

import com.linjun.java.springMvcWeb.dal.helpers.EmployeeHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
        model.setViewName("login");

        return model;
    }

    @RequestMapping("/register")
    private String registerPage(){
        logger.info("access register page");
        return "register";
    }

    @RequestMapping("/adminBatchRegister")
    private String batchRegisterPage() {
        return "batchRegister";
    }

    @RequestMapping(value = "/registerEmployee", method = RequestMethod.POST)
    private String registerEmployee(@RequestParam(value="username", required=true) String username,
                           @RequestParam(value="password", required=true) String password,
                           @RequestParam(value="idCard", required=true) String idCard,
                           @RequestParam(value="gender", required=true) Integer gender,
                           @RequestParam(value="birthday", required=true) String birthday){

        EmployeeHelper.create(username,
                password,
                idCard,
                gender,
                birthday,
                "ROLE_ADMIN");

        return "redirect:/login";
    }
}

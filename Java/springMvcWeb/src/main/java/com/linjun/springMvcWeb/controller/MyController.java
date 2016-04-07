package com.linjun.java.springMvcWeb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by linjun on 16/4/7.
 */
@Controller
public class MyController {
    @RequestMapping("/")
    private String hello(){
        return "index";

    }
}

package com.linjun.java.springRestfulWS.controller;

import com.linjun.java.springRestfulWS.helpers.HelperDemo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    @RequestMapping("/page")
    public String whatEver(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        HelperDemo.test();
        model.addAttribute("name", name);
        // pageTemplate is the file name of the template used
        return "pageTemplate";
    }

}

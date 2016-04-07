package com.linjun.java.springMvcWeb.controller;

import com.linjun.java.springMvcWeb.bo.Cat;
import com.linjun.java.springMvcWeb.dal.CatDal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by linjun on 16/4/7.
 */
@Controller
@RequestMapping("/cats")
public class MyRestController {
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public @ResponseBody
    Cat getCat(@PathVariable int id) {
        return CatDal.getCatById(id);
        //return new Cat(1, "kitty");
    }

}

package com.shuiyou.myspringboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @Value("${mall.config.name}")
    private String name;
    @Value("${mall.config.age}")
    private String age;

    @RequestMapping("/out")
    @ResponseBody
    public String out(){
        return "success" + name + age;
    }
}

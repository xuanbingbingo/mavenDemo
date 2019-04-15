package com.shuiyou.myspringboot.controller;

import com.shuiyou.myspringboot.entity.User;
import com.shuiyou.myspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@EnableAutoConfiguration
public class MyController {
    @Resource
    private UserService userService;
    @Value("${mall.config.name}")
    private String name;
    @Value("${mall.config.age}")
    private String age;

    @RequestMapping("/out")
    @ResponseBody
    public String out(){
        return "success" + name + age;
    }

    @RequestMapping("/showUser")
    @ResponseBody
    public User toIndex(HttpServletRequest request){
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        return user;
    }

    @RequestMapping(value = "/params/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User toIndex(@PathVariable String id){
        int userId = Integer.parseInt(id);
        User user = this.userService.getUserById(userId);
        return user;
    }

}

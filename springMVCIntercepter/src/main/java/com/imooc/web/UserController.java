package com.imooc.web;

import com.imooc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    //查询用户
    @RequestMapping("/search")
    public String search(HttpSession session){
        System.out.println("2:----keketip====---search---");
        return  "user/search";
    }


    //查询用户
    @RequestMapping("/updatepwd")
    public String updatepwd(HttpSession session){
        System.out.println("2:keketip====---updatepwd---");
        return  "user/updatepwd";
    }


    //查询用户
    @RequestMapping("/updateheaderPic")
    public String updateheaderPic(HttpSession session){
        System.out.println("2:keketip====---updateheaderPic");
        return  "user/updateheaderPic";
    }

    //查询用户
    @RequestMapping("/updatebackground/{id}")
    public String updatebackground(HttpSession session){
        System.out.println("2:keketip====---updatebackground");
        return  "user/test";
    }

}

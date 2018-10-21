package com.bingo.handler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class AnnotationHandler {

    /**
     * 第一种业务方法（ModelAndView完成逻辑视图到物理视图的解析）
     */

    @RequestMapping("/movelAndViewTest1")
    public ModelAndView modelAndViewTest(){
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //填充数据
        modelAndView.addObject("name","tom1");
        //设置逻辑试图
        modelAndView.setViewName("myView");
        return modelAndView;
    }

    /**
     * 第二种业务方法（Model传值，String进行视图解析）
     */
    @RequestMapping("/modelAndViewTest2")
    public String ModelTest(Model model){
        //填充模型数据
        model.addAttribute("name","heheda2");
        //设置逻辑视图
        return "myView";

    }

    /**
     * 第三种业务方法（Map进行传值，String进行视图解析）
     *
     */
    @RequestMapping("/modelAndViewTest3")
    public String MapTest(Map<String,String> map){
        //填充模型数据
        map.put("name","hehedada3");
        //设置逻辑视图
        return "myView";

    }

    @RequestMapping("/modelAndViewTest4")
    public ModelAndView modelAndViewTest4(Goods goods){
        System.out.println(goods.getName()+"-------"+goods.getPrice());
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //填充数据
        modelAndView.addObject("name","tom1");
        //设置逻辑试图
        modelAndView.setViewName("myView");
        return modelAndView;

    }

}

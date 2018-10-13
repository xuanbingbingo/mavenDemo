package com.bingo.ioc.demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo1 {
    @Test
    /**
     * 传统方式开发
     */
    public void demo1(){
        UserService userService = new UserServiceImpl();
        userService.sayHello();
    }

    @Test
    /**
     * 使用spring的方式（工厂模式+反射+配置文件）
     */
    public void demo2(){
        //创建spring的工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过工厂获得bean
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.sayHello();
    }
}

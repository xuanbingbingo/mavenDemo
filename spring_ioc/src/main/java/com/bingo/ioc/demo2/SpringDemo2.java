package com.bingo.ioc.demo2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试bean实例化的三种方式
 */
public class SpringDemo2 {
    @Test
    /**
     * 测试使用无参构造器的方式进行bean实例化(默认方式)
     */
    public void bean1(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Bean1 bean1 = (Bean1) applicationContext.getBean("bean1");
        bean1.runTest();
//        关闭工厂，销毁bean；
        applicationContext.close();
    }

    @Test
    /**
     * 测试使用静态工厂的方式进行bean实例化
     */
    public void bean2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Bean2 bean2 = (Bean2) applicationContext.getBean("bean2");
    }

    @Test
    /**
     * 测试使用静态工厂的方式进行bean实例化
     */
    public void bean3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Bean3 bean3 = (Bean3) applicationContext.getBean("bean3");
    }
}

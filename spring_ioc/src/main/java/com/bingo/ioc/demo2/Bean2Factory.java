package com.bingo.ioc.demo2;

/**
 * Bean2的静态工厂
 * @return Bean2的实例
 */
public class Bean2Factory {
    public static Bean2 createBean2(){
        System.out.println("通过静态工厂的方式进行bean2的实例化");
        return new Bean2();
    }
}

package com.bingo.ioc.demo2;

public class Bean3Factory {
    public Bean3 createBean3(){
        System.out.println("通过实例工厂的方式进行bean3的实例化");
        return new Bean3();
    }
}

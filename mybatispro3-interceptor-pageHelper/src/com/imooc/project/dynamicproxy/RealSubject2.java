package com.imooc.project.dynamicproxy;

/**
 * Created by imooc
 */
public class RealSubject2 implements  Subject {

    @Override
    public void request()
    {
        System.out.println("From real Subject2");
    }
}

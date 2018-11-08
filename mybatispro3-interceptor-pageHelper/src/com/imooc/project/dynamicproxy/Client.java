package com.imooc.project.dynamicproxy;

import com.imooc.project.proxy.RealBusiness;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by imooc
 */
public class Client {

    public static void main(String[] args) {

        RealSubject2 rs=new RealSubject2();

        InvocationHandler handler=new DynamicSubject(rs);

        Subject subject= (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(),rs.getClass().getInterfaces(),handler);

       // System.out.println(subject.getClass());

        subject.request();

    }
}

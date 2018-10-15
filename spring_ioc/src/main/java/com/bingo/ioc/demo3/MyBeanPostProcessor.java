package com.bingo.ioc.demo3;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("第五步: 初始化bean之前调用此方法");
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(final Object o, String s) throws BeansException {
        System.out.println("第八步: 初始化bean之后调用此方法");
        System.out.println("开始代理UserDao,在save方法之前执行某些操作");
        if("myBean".equals(s)){
            Object proxy = Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if("save".equals(method.getName())){
                        System.out.println("权限校验========");
                        return method.invoke(o,args);
                    }
                    return method.invoke(o,args);
                }
            });
            return proxy;
        }
        return o;
    }
}

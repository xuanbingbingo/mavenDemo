package com.bingo.aop.demo4;

import org.aopalliance.intercept.MethodInvocation;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyAroundAdvice implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("环绕前增强。。。");
        Object obj = invocation.proceed();
        System.out.println("环绕后增强。。。");
        return obj;
    }
}

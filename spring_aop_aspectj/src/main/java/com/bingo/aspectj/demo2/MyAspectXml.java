package com.bingo.aspectj.demo2;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 定义切面
 */
public class MyAspectXml {

    //前置通知
    public void before(){
        System.out.println("xml方式的前置通知");
    }

    //后置通知
    public void afterReturn(Object result){
        System.out.println("xml方式的后置通知");
        System.out.println(result);
    }

    //环绕通知
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("xml方式的环绕前通知");
        //执行目标方法
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("xml方式的环绕后通知");
        return obj;
    }

    //异常抛出通知
    public void afterThrowing(Throwable e){
        System.out.println("xml的异常抛出通知,异常信息如下：");
        System.out.println(e);
    }

    //最终通知（无论是否有异常，都会在目标方法执行之后执行这个最终通知）
    public void after(){
        System.out.println("xml的抛出最终通知");
    }
}

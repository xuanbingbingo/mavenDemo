package com.bingo.aspectj.demo1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

/**
 * 切面类
 */
@Aspect
@Component
public class MyAspectjAnno {
    //定义一个前置通知
    @Before(value="myPointCut1()")
    public void before(JoinPoint joinPoint){
        System.out.println("前置通知...");
        //joinPoint是获得切入点的信息
        System.out.println(joinPoint);
    }

    //定义一个后置通知，并在通知中获取切点（方法）的返回值
    @AfterReturning(value="execution(* com.bingo.aspectj.demo1.ProductDao.update(..))",returning = "result")
    public void afterReturn(Object result){
        System.out.println("后置通知...");
        System.out.println("打印后置通知获取到的方法返回的结果是：");
        System.out.println(result);
    }

    //定义一个环绕通知(可阻止目标方法的执行)
    @Around(value="execution(* com.bingo.aspectj.demo1.ProductDao.delete(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //环绕前通知
        System.out.println("环绕前通知。。。");
        //执行目标方法（如果不调用，原有的目标方法不会执行）
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("环绕后通知。。。");
        return obj;
    }

    //定义一个异常抛出通知（当目标方法抛出异常的时候，会执行这个通知）
    @AfterThrowing(value="execution(* com.bingo.aspectj.demo1.ProductDao.findOne(..))",throwing = "e")
    public void afterThrowing(Throwable e){
        System.out.println("异常抛出通知。。。，异常信息显示如下：");
        System.out.println(e);
    }

    //定义一个after通知（最终通知，指的是无论目标方法中是否发生异常,在目标方法执行后都会执行这个通知）
    @After(value="execution(* com.bingo.aspectj.demo1.ProductDao.findAll(..))")
    public void after(){
        System.out.println("无论如何都会执行这段代码");
    }

    //自定义切点的名称
    @Pointcut(value="execution(* com.bingo.aspectj.demo1.ProductDao.save(..))")
    private void myPointCut1(){}
}

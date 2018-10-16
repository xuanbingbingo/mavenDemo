package com.bingo.aop.demo1;

import org.junit.Test;

public class SpringDemo1 {

    /**
     * 此demo是手动代理，主要用来展示底层实现原理，实际开发中会使用spring配置的方式
     * 不使用spring的方式实现jdk动态代理
     * jdk动态代理只能针对实现了接口的实现类进行动态代理
     */
    @Test
    public void demo1(){
        UserDao userDao = new UserDaoImpl();
        UserDao proxy = (UserDao)new MyJdkProxy(userDao).createProxy();
        proxy.save();
        userDao.delete();
        userDao.find();
        userDao.update();
    }
}

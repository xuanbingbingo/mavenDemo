package com.bingo.aop.demo2;

import org.junit.Test;

public class SpringDemo2 {
    @Test
    /**
     * 此demo是手动代理，主要用来展示底层实现原理，实际开发中会使用spring配置的方式
     * 不使用spring的方式实现cglib动态代理
     * cglib动态代理（可以实现非接口实现类的动态代理，补充了jdk动态代理的不足）
     */
    public void demo1(){
        ProductDao productDao = new ProductDao();
        ProductDao proxy = (ProductDao) new MyCglibDao(productDao).createProxy();
        proxy.save();
        productDao.delete();
        productDao.find();
        productDao.update();
    }
}

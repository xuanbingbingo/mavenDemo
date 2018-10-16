package com.bingo.aop.demo4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class SpringDemo4 {
    @Resource(name = "customDaoProxy")
    private CustomDao customDao;

    @Test
    public void demo1(){
        customDao.find();
        customDao.save();
        customDao.update();
        customDao.delete();
    }
}

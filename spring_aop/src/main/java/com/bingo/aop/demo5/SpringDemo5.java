package com.bingo.aop.demo5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext3.xml")
public class SpringDemo5 {

    @Resource(name="customDao")
    private CustomDao customDao;
    @Resource(name="studentDao")
    private StudentDao studentDao;

    @Test
    public void bean1(){

        studentDao.delete();
        studentDao.find();
        studentDao.save();

        customDao.delete();
        customDao.find();
        customDao.save();
        customDao.update();

    }
}

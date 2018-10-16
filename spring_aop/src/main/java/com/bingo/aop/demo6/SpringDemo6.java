package com.bingo.aop.demo6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext4.xml")
public class SpringDemo6 {

    @Resource(name="customDao")
    private CustomDao customDao;
    @Resource(name="studentDao")
    private StudentDao studentDao;

    @Test
    public void bean1(){

        studentDao.find();
        studentDao.delete();
        studentDao.save();

        customDao.delete();
        customDao.find();
        customDao.save();
        customDao.update();

    }
}

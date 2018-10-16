package com.bingo.aspectj.demo2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class SpringDemo2 {
    @Resource(name = "customDao")
    private CustomDao customDao;

    @Test
    public void bean1(){
        customDao.add();
        customDao.delete();
        customDao.find();
        customDao.update();
    }

}

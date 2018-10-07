package com.bingo.listener;

import com.bingo.utils.SqlSessionFactoryUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class initSqlSessionListener implements ServletContextListener{

    public void contextInitialized(ServletContextEvent sce) {
      /* 初始化SqlSessionFactory对象
      */
        SqlSessionFactoryUtils.initSqlSessionFactory();
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* 关闭SqlSession对象
      */
      SqlSessionFactoryUtils.close();
    }
}

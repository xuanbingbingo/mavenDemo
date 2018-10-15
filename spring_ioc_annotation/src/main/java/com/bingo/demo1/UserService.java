package com.bingo.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Spring bean管理的注解方式(@Component,@Repository,@Controller,@Service)
 * 传统的xml配置方式是：<bean id="" class=""></bean>
 *
 */
@Service("userService")
public class UserService {
    @Value("米饭")
    private String something;

//    @Autowried是默认按类型注入
//      @Autowired
//      private UserDao userDao;
//    @Autowried注入可以指定成员变量或set方法（通过required属性，设置一定要找到的bean，通过@Qualifer指定注入bean的名称）
//    @Autowired
//    @Qualifier("userDao")
    @Resource(name="userDao")
    private UserDao userDao;
    public void sayHello(String name){
        System.out.println("hello " + name);
    }

    public void eat(){
        System.out.println("eat " + something);
    }

    public void save(){
        System.out.println("Service中的保存用户的方法");
        userDao.save();
    }
}

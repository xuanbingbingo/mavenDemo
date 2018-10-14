package com.bingo.ioc.demo2;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * spring中bean生成的三种方式中第一种方式：采用无参构造器的方式生成bean
 */
public class Bean1 implements BeanNameAware,ApplicationContextAware,InitializingBean,DisposableBean {
    private String name;

    public void setName(String name) {
        System.out.println("第二步：设置属性");
        this.name = name;
    }

    public Bean1(){
        System.out.println("第一步：Bean1被实例化（通过无参构造器的方式）");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("第三步: 设置bean的名称");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("第四步: 了解工厂的信息");
    }

    public void init(){
        System.out.println("第七步：初始化bean...");
    }
    public void destroy(){
        System.out.println("第十步：执行bean自己的销毁方法");
    }
    public void customDestroy(){
        System.out.println("第十一步：执行spring配置中bean的destroy的销毁方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("第六步：初始化备案之前，设置属性之后执行");
    }

    public void runTest(){
        System.out.println("第九步：执行bean自己的方法。。。");
    }
}

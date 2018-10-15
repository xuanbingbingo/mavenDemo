package com.bingo.demo2;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("bean1")
@Scope("singleton")
public class Bean1 {
    @PostConstruct
    public void init(){
        System.out.println("init bean...");
    }
    public void say(){
        System.out.println("say...");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("destroy bean...");
    }
}

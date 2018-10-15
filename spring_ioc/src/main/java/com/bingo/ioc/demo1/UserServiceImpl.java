package com.bingo.ioc.demo1;

public class UserServiceImpl implements UserService {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void sayHello() {
        System.out.println("Hello " + this.name);
    }
}

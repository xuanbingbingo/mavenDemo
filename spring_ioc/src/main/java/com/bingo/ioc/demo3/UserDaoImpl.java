package com.bingo.ioc.demo3;

public class UserDaoImpl implements UserDao {

    @Override
    public void findAll() {
        System.out.println("findAll...");
    }

    @Override
    public void save() {
        System.out.println("save...");
    }
}

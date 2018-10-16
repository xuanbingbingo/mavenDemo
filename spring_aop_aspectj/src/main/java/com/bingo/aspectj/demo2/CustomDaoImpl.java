package com.bingo.aspectj.demo2;

public class CustomDaoImpl implements CustomDao {
    @Override
    public void add() {
        System.out.println("增");
    }

    @Override
    public String delete() {
        System.out.println("删");
        return "hehedada";
    }

    @Override
    public void update() {
        System.out.println("改");
    }

    @Override
    public void find() {
        System.out.println("查");
    }
}

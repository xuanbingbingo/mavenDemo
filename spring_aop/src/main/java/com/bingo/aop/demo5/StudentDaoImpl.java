package com.bingo.aop.demo5;

public class StudentDaoImpl implements StudentDao {
    @Override
    public void find() {
        System.out.println("查询");
    }

    @Override
    public void save() {
        System.out.println("保存");
    }

    @Override
    public void delete() {
        System.out.println("删除");
    }
}

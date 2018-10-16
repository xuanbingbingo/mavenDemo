package com.bingo.aop.demo2;

public class ProductDao {
    public void save() {
        System.out.println("保存用户");
    }

    public void update() {
        System.out.println("修改");
    }

    public void delete() {
        System.out.println("删除");
    }

    public void find() {
        System.out.println("查询");
    }
}

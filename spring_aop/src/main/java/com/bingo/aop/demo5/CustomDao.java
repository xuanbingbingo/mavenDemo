package com.bingo.aop.demo5;

public class CustomDao {
    public void find(){
        System.out.println("查询");
    }
    public void save(){
        System.out.println("保存");
    }
    public void update(){
        System.out.println("修改");
    }
    public void delete(){
        System.out.println("删除");
    }
}

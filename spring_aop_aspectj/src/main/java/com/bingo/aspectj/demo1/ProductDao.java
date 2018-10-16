package com.bingo.aspectj.demo1;

import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {

    public void save(){
        System.out.println("保存商品");
    }
    public String update(){
        System.out.println("修改商品");
        return "hello bingo";
    }
    public void delete(){
        System.out.println("删除商品");
    }
    public void findOne(){
//        int a =  1/0;
        System.out.println("查询一个商品");
    }
    public void findAll(){
        System.out.println("查询所有商品");
    }


}

package com.bingo.demo3;

public class ProductService {
    private CategoryDao categoryDao;
    private ProductDao productDao;
    public void save(){
        System.out.println("ProductService的save方法...");
        categoryDao.save();
        productDao.save();
    }
}

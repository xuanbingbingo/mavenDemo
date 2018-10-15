package com.bingo.demo1;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDao {
    public void save(){
        System.out.println("Dao中的的保存用户");
    }
}

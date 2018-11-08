package com.mooc.mybatis.bean;

/**
 * Created by imooc
 */
public class User {

    private  Integer id;

    private String username;

    private String address;

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

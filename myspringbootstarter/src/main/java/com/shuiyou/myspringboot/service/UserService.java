package com.shuiyou.myspringboot.service;

import com.shuiyou.myspringboot.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    public User getUserById(int userId);

    boolean addUser(User record);

}
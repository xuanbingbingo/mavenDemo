package com.imooc.project.dao;

import com.imooc.project.entity.User;

import java.util.List;

/**
 * Created by imooc
 */
public interface UserDao {

    List<User> getAllUsers(int startIndex,int pageSize) throws  Exception;//limit ?,?

    int totalRecords() throws  Exception;

}

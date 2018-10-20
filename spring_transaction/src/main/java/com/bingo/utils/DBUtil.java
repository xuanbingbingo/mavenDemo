package com.bingo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    static  final String dbDriver = "com.mysql.jdbc.Driver" ;
    static final String dbUrl = "jdbc:mysql://localhost:3306/test" ;
    static final String userName = "root" ;
    static final String password = "root" ;

    static {
        try{//加载MySql的驱动类
            Class.forName(dbDriver) ;
        }catch(ClassNotFoundException e){
            System.out.println("找不到驱动程序类 ，加载驱动失败！");
            e.printStackTrace() ;
        }
    }
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(dbUrl , userName , password ) ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null ;
    }
}

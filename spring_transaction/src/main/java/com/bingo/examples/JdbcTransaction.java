package com.bingo.examples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * JDBC事务简单演示案例,操作步骤：
 * 1、创建事务对象
 * 2、启动JDBC事务；
 * 3、进行数据库操作；
 * 4、提交事务
 * @author Solo Cui
 *
 */
public class JdbcTransaction {
	//事务操作的数据库连接对象
	private Connection connection = null ;
	//保存数据库连接初始事务模式：自动模式或手动模式
	private boolean autoCommit = false ;
	//构造Jdbc事务对象
	public JdbcTransaction(Connection conn){
		this.connection = conn ;
	}
	//获取当前事务的数据库连接对象
	public Connection getConnection(){
		return this.connection;
	}
	//启动手动事务
	public void beginJdbcTransaction() throws SQLException{
		autoCommit = this.connection.getAutoCommit();
		this.connection.setAutoCommit(false);
	}
	//提交Jdbc操作事务
	public void commitJdbcTransaction() throws SQLException{
		getConnection().commit();
		//恢复数据库的初识事务处理模式
		getConnection().setAutoCommit(autoCommit);
		//默认事务提交后，关闭连接
		if(this.connection!=null){
			this.connection.close();
		}
	}
	public void rollback() throws SQLException{
		System.out.println("操作失败，回滚事务~");
		this.connection.rollback();
	}
	
	
	//数据库的JDBC操作：增删改,true 表示成功
	public void insertData(PreparedStatement pst) throws SQLException{
		pst.execute() ;		
	}
	public void updateDate(String sql,Statement stmt) throws SQLException{
		stmt.executeUpdate(sql);
	}
	//其它数据库操作：略
	
}

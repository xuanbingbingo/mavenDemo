package com.bingo.examples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.bingo.utils.DBUtil;
import com.bingo.utils.TemplateUtils;
/**
 * JDBC事务操作演示
 * @author Solo
 *
 */
public class MainTest {

	public static void main(String[] args) {
		JdbcTransaction jt = null ;
		Connection conn  ;
		String sql = "insert books(isbn,name,price,pubdate) values"
				        +"('191-39-PRC','大唐盛世2',23.4,'2017-10-21')" ;
		String usql = "update books set name='贞观之治' where isbn='190-33-PRC' ";
		PreparedStatement pst   ;
		Statement st  ;
		try {
			//获取数据库连接，或建立数据库关联
			conn = DBUtil.getConnection();
			jt = new JdbcTransaction(conn);
			//启动事务
			jt.beginJdbcTransaction();
			pst = conn.prepareStatement(sql);
			st = conn.createStatement();
			//同一事务中完成2类操作
			jt.updateDate(usql, st);
			//数据库操作：插入数据
			jt.insertData(pst);
			//提交事务
			jt.commitJdbcTransaction();			
		} catch (SQLException e) {
			try {//出现异常回滚
				jt.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

}

package com.bingo.springtransactions;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.bingo.utils.TemplateUtils;

public class TransManagerExample {

	public static void main(String[] args) {
		DataSourceTransactionManager dtm = TemplateUtils.getDataSourceTransactionManager();
		// 创建事务管理器属性对象
		DefaultTransactionDefinition transDef = new DefaultTransactionDefinition(); // 定义事务属性
		// 根据需要，设置事务管理器的相关属性
		transDef.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED); // 设置传播行为属性
		// 获得事务状态对象
		TransactionStatus ts = dtm.getTransaction(transDef); 
		//基于当前事务管理器，获取操作数据库的JDBC模板对象
		JdbcTemplate jt = new JdbcTemplate(  dtm.getDataSource());  
	try{
		jt.update("update books set price=112.5,name='炎黄传奇'  where isbn='128-166-890-China' ");
		//其它数据操作如增删
		dtm.commit(ts); //如果不commit，则更新无效果
	} catch (Exception e) {  
        dtm.rollback(ts);  
        e.printStackTrace();  
    } 
		
	}

}

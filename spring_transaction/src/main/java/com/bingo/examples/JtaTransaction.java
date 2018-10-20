package com.bingo.examples;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.*;

/**
 * 演示性代码
 * Java分布式事务：主要应用在Java EE服务器环境中
 */
public class JtaTransaction {
    UserTransaction tx = null;
    //初始化应用上下文
    static Context ctx = null;

    static {
        try {
            ctx = new InitialContext();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public JtaTransaction() {
        //创建JTA事务对象
        try {
            tx = (UserTransaction) ctx.lookup("javax.transaction.UserTransaction");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取事务对象
    public UserTransaction getUserTransaction() {
        return tx;
    }

    //事务处理A
    public void doTransactionA() {
        //事务代码：数据源、业务逻辑以及持久化等操作
    }

    //事务处理B
    public void doTransactionB() {
        //事务代码：数据源、业务逻辑以及持久化等操作
    }

    //没有进一步包装启动事务和提交事务，交由调用者更灵活的处理
    public static void main(String[] args) {
        JtaTransaction jta = new JtaTransaction();
        UserTransaction ut = jta.getUserTransaction();
        try {
            ut.begin();
            jta.doTransactionA();
            jta.doTransactionB();
            ut.commit();
        } catch (Exception e) {
            try {
                ut.rollback();
            } catch (SystemException e1) {
                e1.printStackTrace();
            }
        }
    }

}

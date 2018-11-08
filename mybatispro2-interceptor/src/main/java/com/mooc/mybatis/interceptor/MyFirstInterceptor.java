package com.mooc.mybatis.interceptor;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Statement;
import java.util.Properties;

/**
 * Created by imooc
 * 插件签名，告诉mybatis单钱插件用来拦截那个对象的哪个方法
 */
@Intercepts({
        @Signature(type = ResultSetHandler.class,method ="handleResultSets",args = Statement.class)

})
public class MyFirstInterceptor implements Interceptor {

    //拦截目标对象的目标方法的
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("拦截的目标对象:"+invocation.getTarget());
        System.out.println(invocation.getMethod());
        System.out.println(invocation.getArgs());

        Object object=invocation.proceed();
        return object;
    }

    //包装目标对象 为目标对象创建代理对象的
    public Object plugin(Object o) {
        System.out.println("将要包装的目标对象:"+o);
        return Plugin.wrap(o,this);
    }

    public void setProperties(Properties properties) {
        System.out.println("插件配置的初始化参数:"+properties);

    }
}

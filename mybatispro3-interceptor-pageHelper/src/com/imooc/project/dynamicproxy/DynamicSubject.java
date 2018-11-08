package com.imooc.project.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by imooc
 */
public class DynamicSubject  implements InvocationHandler{


    private Object sub;

    public DynamicSubject(Object object)
    {
        this.sub=object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("invoked method:"+method);
        System.out.println("pre subject");
        method.invoke(sub,args);
        System.out.println("after subject");
        return null;
    }
}

package com.imooc.project.proxy;

/**
 * Created by imooc
 */
public class RealBusiness extends  Business {

    @Override
    public void business()
    {
        System.out.println("From real business");
    }
}

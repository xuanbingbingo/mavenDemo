package com.imooc.project.proxy;

/**
 * Created by imooc
 */
public class Client {

    public static void main(String[] args) {

        Business business=new ProxyBusiness();

        business.business();


    }
}

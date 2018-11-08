package com.imooc.project.proxy;

import com.sun.media.sound.RealTimeSequencerProvider;

/**
 * Created by imooc
 */
public class ProxyBusiness extends  Business {

    private RealBusiness realBusiness=new RealBusiness();

    @Override
    public void business()
    {
        this.preBusiness();
        realBusiness.business();
        this.afterBusiness();
    }

    private void preBusiness()
    {
        System.out.println("pre business");
    }

    private void afterBusiness()
    {
        System.out.println("after business");
    }


}

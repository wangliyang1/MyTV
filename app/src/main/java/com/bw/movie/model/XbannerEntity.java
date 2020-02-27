package com.bw.movie.model;

import com.stx.xhb.androidx.entity.SimpleBannerInfo;

public class XbannerEntity extends SimpleBannerInfo {
    public XbannerEntity(int souce) {
        this.souce = souce;
    }

    public int getSouce() {
        return souce;
    }

    public void setSouce(int souce) {
        this.souce = souce;
    }

    private int souce;


    @Override
    public Object getXBannerUrl() {
        return null;
    }
}

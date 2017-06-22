package com.centa.centacore.interfaces;

/**
 * Created by yanwenqiang on 17/6/22.
 * <p>
 * 描述:View中有且只有一个网络请求的规范
 */
public interface ISingleRequest {

    /**
     * 网络请求
     */
    void request();
}

package com.centa.aplusframework;

/**
 * Created by yanwenqiang on 2017/6/24.
 * <p>
 * 描述:待描述
 */
public abstract class AA {
    private static String sss = "sss";
    static {
        sss = "static created";
    }

    public static String getString(){
        return sss;
    }
}

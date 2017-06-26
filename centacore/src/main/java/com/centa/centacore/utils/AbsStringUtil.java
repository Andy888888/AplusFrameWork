package com.centa.centacore.utils;

import android.text.TextUtils;

/**
 * Created by yanwenqiang on 2017/6/19.
 * <p>
 * 描述:字符串处理工具，字符串处理基础类，使用 {@link Empty}来表示空字符串
 */
public abstract class AbsStringUtil {

    /**
     * 空字符串,为避免不必要的创建空字符串对象.
     */
    public static final String Empty = "";

    /**
     * 字符串使用请使用该方法
     *
     * @param value 参数
     * @return Empty
     */
    public static String nullToEmpty(String value) {
        if (value == null) {
            value = Empty;
        }
        return value;
    }

    /**
     * 是否为null或者是空
     *
     * @param value 参数
     */
    public static boolean isNullOrEmpty(String value) {
        return TextUtils.isEmpty(value);
    }
}

package com.centa.centacore.utils;

import android.util.Log;

import com.orhanobut.logger.Logger;
import com.orhanobut.logger.Printer;

/**
 * Created by yanwenqiang on 2017/6/18
 * description 打印工具
 */
public class WLog {

    private static final String DEBUG_TAG = "CentanetLog";
    private static boolean mDebug = false;

    static {
        Logger.init(DEBUG_TAG).methodCount(1).hideThreadInfo();
    }

    /**
     * set debug
     */
    public static void setDebug(boolean debug) {
        mDebug = debug;
    }

    /**
     * isDebug
     */
    public static boolean debug() {
        return mDebug;
    }


    /**
     * 普通debug日志
     *
     * @param obj 打印内容
     */
    public static void p(Object obj) {
        if (checkLogAble() && obj != null)
            Logger.d(obj.toString());
    }

    /**
     * 普通debug日志
     *
     * @param tag 标记
     * @param obj 打印内容
     */
    public static void p(String tag, Object obj) {
        if (checkLogAble() && obj != null)
            setPrinter(tag, -1).d(obj.toString());
    }

    /**
     * 普通debug日志
     *
     * @param tag         标记
     * @param obj         打印内容
     * @param methodCount 堆栈方法数量
     */
    public static void p(String tag, Object obj, int methodCount) {
        if (checkLogAble() && obj != null)
            setPrinter(tag, methodCount).d(obj.toString());
    }


    /**
     * 格式化打印json串
     *
     * @param json
     */
    public static void json(Object json) {
        if (checkLogAble() && json != null)
            Logger.json(json.toString());
    }

    /**
     * 格式化打印json串
     *
     * @param tag  标记
     * @param json 打印json内容
     */
    public static void json(String tag, Object json) {
        if (checkLogAble() && json != null)
            setPrinter(tag, -1).json(json.toString());
    }

    /**
     * 格式化打印json串
     *
     * @param tag         标记
     * @param json        打印json内容
     * @param methodCount 堆栈方法数量
     */
    public static void json(String tag, Object json, int methodCount) {
        if (checkLogAble() && json != null)
            setPrinter(tag, methodCount).json(json.toString());
    }

    /**
     * 原生打印
     * @param obj
     */
    public static void nativeLog(Object obj) {
        if (checkLogAble() && obj != null)
            Log.d(DEBUG_TAG, obj.toString());
    }

    /**
     * 原生打印
     * @param obj
     */
    public static void nativeLog(String tag,Object obj) {
        if (checkLogAble() && obj != null)
            Log.d(tag, obj.toString());
    }


    protected static Printer setPrinter(String tag, int methodCount) {
        if (methodCount > 0)
            return Logger.t(tag, methodCount);
        else
            return Logger.t(tag);
    }

    protected static boolean checkLogAble() {
        return mDebug;
    }
}

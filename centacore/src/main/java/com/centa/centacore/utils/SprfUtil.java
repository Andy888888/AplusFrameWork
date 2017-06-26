package com.centa.centacore.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by yanwenqiang on 2017/6/19.
 * <p>
 * 描述:{@link SharedPreferences}工具类
 */
public class SprfUtil {

    private final static String FILE_NAME = "appShareprefrence";

    private SprfUtil() {

    }

    private static SharedPreferences preferences(Context context) {
        return context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }

    private static SharedPreferences.Editor editor(Context context) {
        return preferences(context).edit();
    }

    public static void setInt(Context context, String key, int value) {
        editor(context).putInt(key, value).commit();
    }

    public static int getInt(Context context, String key, int defVale) {
        return preferences(context).getInt(key, defVale);
    }

    public static void setString(Context context, String key, String value) {
        editor(context).putString(key, value).commit();
    }

    public static String getString(Context context, String key, String defVale) {
        return preferences(context).getString(key, defVale);
    }

    public static void setBoolean(Context context, String key, boolean value) {
        editor(context).putBoolean(key, value).commit();
    }

    public static boolean getBoolean(Context context, String key, boolean defVale) {
        return preferences(context).getBoolean(key, defVale);
    }

    public static void setLong(Context context, String key, long value) {
        editor(context).putLong(key, value).commit();
    }

    public static long getLong(Context context, String key, long value) {
        return preferences(context).getLong(key, value);
    }

    public static long getString(Context context, String key, long defVale) {
        return preferences(context).getLong(key, defVale);
    }

    public static void setFloat(Context context, String key, float value) {
        editor(context).putFloat(key, value).commit();
    }

    public static float getFloat(Context context, String key, float defVale) {
        return preferences(context).getFloat(key, defVale);
    }
}

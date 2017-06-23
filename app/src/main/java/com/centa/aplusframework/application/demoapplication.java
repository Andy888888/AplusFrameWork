package com.centa.aplusframework.application;

import android.app.Application;

import com.centa.centacore.http.LoggerInterceptor;
import com.centa.centacore.http.okhttpclient.OkHttpClient4Api;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 * Created by yanwenqiang on 2017/6/22.
 * <p>
 * 描述:项目application总入口
 */
public class demoapplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initRetrofit();
    }

    /**
     * 初始化Retrofit
     */
    private void initRetrofit() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000, TimeUnit.MILLISECONDS)
                .readTimeout(10000, TimeUnit.MILLISECONDS)
                .addInterceptor(new AplusHeadersInterceptor())
                .addInterceptor(new LoggerInterceptor(LoggerInterceptor.Level.HEADERS))
                .cache(new Cache(new File(getCacheDir(), "http"), 10 * 1024 * 1024))
                .build();
        OkHttpClient4Api.initClient(okHttpClient);
    }
}

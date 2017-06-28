package com.centa.aplusframework.application;

import com.centa.aplusframework.api.APlusHeadersInterceptor;
import com.centa.centacore.http.LoggerInterceptor;
import com.centa.centacore.http.okhttpclient.OkHttpClient4Api;
import com.centa.centacore.utils.WLog;

import org.litepal.LitePal;
import org.litepal.LitePalApplication;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 * Created by yanwenqiang on 2017/6/22.
 * <p>
 * 描述:项目application总入口
 */
public class DemoApplication extends LitePalApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        WLog.setDebug(true);
        LitePal.initialize(this);
        initRetrofit();
    }

    /**
     * 初始化Retrofit
     */
    private void initRetrofit() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000, TimeUnit.MILLISECONDS)
                .readTimeout(10000, TimeUnit.MILLISECONDS)
                .addInterceptor(new APlusHeadersInterceptor())
//                .addInterceptor(new FakeInterceptor())
                .addInterceptor(new LoggerInterceptor(LoggerInterceptor.Level.BASIC))
                .cache(new Cache(new File(getCacheDir(), "http"), 10 * 1024 * 1024))
                .build();
        OkHttpClient4Api.initClient(okHttpClient);
    }
}

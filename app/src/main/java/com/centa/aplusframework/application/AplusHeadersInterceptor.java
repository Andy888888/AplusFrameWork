package com.centa.aplusframework.application;

import com.centa.aplusframework.BuildConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by yanwenqiang on 2017/6/23.
 * <p>
 * 描述:A+接口的Header
 */
public class AplusHeadersInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        // token:       A+的身份信息
        // platform:    android
        // Udid:        设备唯一识别码
        // ClientVer:   当前版本号 eg:2.2.9
        // staffno:     员工编号
        // number:      时间戳
        // sign:        加密信息 = md5( key + company + unixTime + userNo)

        Request.Builder requestBuilder = chain.request().newBuilder();
        requestBuilder.addHeader("token", "@token")
                .addHeader("platform", "android")
                .addHeader("Udid", "@Udid")
                .addHeader("ClientVer", BuildConfig.VERSION_NAME)
                .addHeader("staffno", "@staffno")
                .addHeader("number", "@number")
                .addHeader("sign", "@sign");

        return chain.proceed(requestBuilder.build());
    }
}

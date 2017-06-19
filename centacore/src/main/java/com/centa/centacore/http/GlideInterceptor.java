package com.centa.centacore.http;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by yanwenqiang on 17/6/19.
 * <p>
 * 描述:Glide网络图片加载拦截器
 */

public abstract class GlideInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        if (cancelRequest()) {
            //取消请求
            Request.Builder requestBuilder = chain.request().newBuilder();
            requestBuilder.url("");
            return chain.proceed(requestBuilder.build());
        } else {
            return chain.proceed(chain.request());
        }
    }

    /**
     * 取消图片的网络请求
     *
     * @return true表示取消
     */
    protected abstract boolean cancelRequest();
}

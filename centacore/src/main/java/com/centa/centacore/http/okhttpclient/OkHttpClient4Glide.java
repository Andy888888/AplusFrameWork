package com.centa.centacore.http.okhttpclient;

import okhttp3.OkHttpClient;

/**
 * Created by yanwenqiang on 17/6/19.
 * <p>
 * 描述:Glide使用的{@link OkHttpClient}实例
 */

public final class OkHttpClient4Glide {

    private static volatile OkHttpClient4Glide sOkHttpClient4Api;
    private OkHttpClient mOkHttpClient;

    private OkHttpClient4Glide(OkHttpClient okHttpClient) {
        if (okHttpClient == null) {
            mOkHttpClient = new OkHttpClient();
        } else {
            mOkHttpClient = okHttpClient;
        }
    }

    /**
     * 初始化
     *
     * @param okHttpClient {@link OkHttpClient}
     * @return OkHttpClientUtil
     */
    public static OkHttpClient4Glide initClient(OkHttpClient okHttpClient) {
        if (sOkHttpClient4Api == null) {
            synchronized (OkHttpClient4Glide.class) {
                if (sOkHttpClient4Api == null) {
                    sOkHttpClient4Api = new OkHttpClient4Glide(okHttpClient);
                }
            }
        }
        return sOkHttpClient4Api;
    }

    public static OkHttpClient4Glide getInstance() {
        return initClient(null);
    }

    public OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }
}

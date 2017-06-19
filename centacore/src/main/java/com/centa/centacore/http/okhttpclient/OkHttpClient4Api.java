package com.centa.centacore.http.okhttpclient;

import okhttp3.OkHttpClient;

/**
 * Created by yanwenqiang on 17/6/19.
 * <p>
 * 描述:API使用的{@link OkHttpClient}实例
 */

public final class OkHttpClient4Api {

    private static volatile OkHttpClient4Api sOkHttpClient4Api;
    private OkHttpClient mOkHttpClient;

    private OkHttpClient4Api(OkHttpClient okHttpClient) {
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
    public static OkHttpClient4Api initClient(OkHttpClient okHttpClient) {
        if (sOkHttpClient4Api == null) {
            synchronized (OkHttpClient4Api.class) {
                if (sOkHttpClient4Api == null) {
                    sOkHttpClient4Api = new OkHttpClient4Api(okHttpClient);
                }
            }
        }
        return sOkHttpClient4Api;
    }

    public static OkHttpClient4Api getInstance() {
        return initClient(null);
    }

    public OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }
}

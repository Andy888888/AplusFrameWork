package com.centa.aplusframework.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by yanwenqiang on 2017/6/26.
 * <p>
 * 描述:待描述
 */
public class FakeInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = null;
        if(chain.request().url().toString()
                .equals("http://news-at.zhihu.com/api/4/news/latest")) {
            String json = "{\"PermisstionUserInfo\": [{ \"Identify\": {\"UId\": \"122\",\"UName\": \"燕文强\",\"DepartId\": \"www\",\"DepartName\": \"系统管理组\",\"UserNo\": \"Ceshigzywq\",\"RuleKeyId\": \"999\",\"RoleCode\": \"99\"},\"Permisstions\": {\"MenuPermisstion\": \"没有\",\"Rights\": \"最大权限\",\"OperatorValPermisstion\": {\"Property.SearchPropertyNo.Other\": \"-1\"},\"DepartmentKeyIds\": \"888\",\"RightUpdateTime\": \"2017-06-21T11:42:09.287\"},\"AccountInfo\": \"sss\"}],\"Flag\": true,\"ErrorMsg\": null,\"RunTime\":null}";
            response = new Response.Builder()
                    .code(200)
                    .addHeader("Content-Type", "application/json")
                    .body(ResponseBody.create(MediaType.parse("application/json"), json))
                    .message(json)
                    .request(chain.request())
                    .protocol(Protocol.HTTP_2)
                    .build();
        }
        // do nothing
        else {
            response = chain.proceed(chain.request());
        }
        return response;
    }
}

package com.centa.aplusframework.api;

import com.centa.aplusframework.model.respdo.APlusRespDo;
import com.centa.aplusframework.model.respdo.PermUserInfoDo;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by yanwenqiang on 2017/6/25.
 * <p>
 * 描述:A+权限模块Api
 */
public interface PermissionApi {

    @POST("permission/user-permisstion")
    @FormUrlEncoded
    Observable<APlusRespDo<ArrayList<PermUserInfoDo>>> userPermission(@FieldMap Map<String, Object> map);
}

package com.centa.aplusframework.repository;

import com.centa.aplusframework.api.ApiCreator;
import com.centa.aplusframework.contracts.MainContract;
import com.centa.aplusframework.model.respdo.APlusRespDo;
import com.centa.aplusframework.model.respdo.PermUserInfoDo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import rx.Observable;

/**
 * Created by yanwenqiang on 2017/6/28.
 * <p>
 * 描述:首页需要的Model
 */
public class MainModel implements MainContract.Model {

    @Override
    public Observable<APlusRespDo<ArrayList<PermUserInfoDo>>> userPermission(String staffNo) {
        Map<String, Object> map = new HashMap<>();
        map.put("UserNumbers", staffNo);
        return ApiCreator.userPermission().userPermission(map);
    }
}

package com.centa.aplusframework.model.respdo;

import com.centa.aplusframework.model.respdo.entity.APlusIdentifyEntity;
import com.centa.aplusframework.model.respdo.entity.APlusPermisstionEntity;

/**
 * Created by yanwenqiang on 2017/6/25.
 * <p>
 * 描述:A+用户权限信息实体
 */
public class PermUserInfoDo {
    private APlusIdentifyEntity Identify;
    private APlusPermisstionEntity Permisstions;
    private String AccountInfo;

    public APlusIdentifyEntity getIdentify() {
        return Identify;
    }

    public void setIdentify(APlusIdentifyEntity identify) {
        Identify = identify;
    }

    public APlusPermisstionEntity getPermisstions() {
        return Permisstions;
    }

    public void setPermisstions(APlusPermisstionEntity permisstions) {
        Permisstions = permisstions;
    }

    public String getAccountInfo() {
        return AccountInfo;
    }

    public void setAccountInfo(String accountInfo) {
        AccountInfo = accountInfo;
    }
}

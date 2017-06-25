package com.centa.aplusframework.model.respdo.entity;

/**
 * Created by yanwenqiang on 2017/6/25.
 * <p>
 * 描述:A+用户身份信息实体
 */
public class APlusIdentifyEntity {
    private String UId;
    private String UName;
    private String DepartId;
    private String DepartName;
    private String UserNo;

    public String getUId() {
        return UId;
    }

    public void setUId(String UId) {
        this.UId = UId;
    }

    public String getUName() {
        return UName;
    }

    public void setUName(String UName) {
        this.UName = UName;
    }

    public String getDepartId() {
        return DepartId;
    }

    public void setDepartId(String departId) {
        DepartId = departId;
    }

    public String getDepartName() {
        return DepartName;
    }

    public void setDepartName(String departName) {
        DepartName = departName;
    }

    public String getUserNo() {
        return UserNo;
    }

    public void setUserNo(String userNo) {
        UserNo = userNo;
    }
}

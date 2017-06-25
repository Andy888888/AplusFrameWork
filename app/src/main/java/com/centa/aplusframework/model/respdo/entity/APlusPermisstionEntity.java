package com.centa.aplusframework.model.respdo.entity;

import java.util.HashMap;

/**
 * Created by yanwenqiang on 2017/6/25.
 * <p>
 * 描述:A+权限
 */
public class APlusPermisstionEntity {
    private String MenuPermisstion;
    private String Rights;
    private String DepartmentKeyIds;
    private String RightUpdateTime;
    /**
     * 带有value值的操作权限
     */
    private HashMap<String, String> OperatorValPermisstion;

    public String getMenuPermisstion() {
        return MenuPermisstion;
    }

    public void setMenuPermisstion(String menuPermisstion) {
        MenuPermisstion = menuPermisstion;
    }

    public String getRights() {
        return Rights;
    }

    public void setRights(String rights) {
        Rights = rights;
    }

    public String getDepartmentKeyIds() {
        return DepartmentKeyIds;
    }

    public void setDepartmentKeyIds(String departmentKeyIds) {
        DepartmentKeyIds = departmentKeyIds;
    }

    public String getRightUpdateTime() {
        return RightUpdateTime;
    }

    public void setRightUpdateTime(String rightUpdateTime) {
        RightUpdateTime = rightUpdateTime;
    }

    public HashMap<String, String> getOperatorValPermisstion() {
        return OperatorValPermisstion;
    }

    public void setOperatorValPermisstion(HashMap<String, String> operatorValPermisstion) {
        OperatorValPermisstion = operatorValPermisstion;
    }
}

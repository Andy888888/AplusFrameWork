package com.centa.aplusframework.model.respdo;

import com.google.gson.annotations.SerializedName;

/**
 * 描述:A+响应实体模版
 * <p>
 * Created by yanwenqiang on 2017/1/5
 */
public class APlusRespDo<T> {

    @SerializedName("Flag")
    private boolean flag;
    @SerializedName("ErrorMsg")
    private String errorMsg;
    @SerializedName("RunTime")
    private String runTime;
    @SerializedName(value = "result", alternate = {"PermUserInfos", "PermisstionUserInfo"})
    private T result;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}

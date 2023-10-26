package com.kuaishou.vod.openapi.model.request.vod;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProcessSet {
    /**
     * 模板参数的集合
     */
    @SerializedName("OperationSets")
    @Expose
    private List<OperationSet> operationSets;
    /**
     * 回调URL
     */
    @SerializedName("CallbackUrl")
    @Expose
    private String callbackUrl;
    /**
     * 回到方法默认HTTP
     */
    @SerializedName("CallbackMethod")
    @Expose
    private String callbackMethod;
    /**
     * 透传参数
     */
    @SerializedName("UserData")
    @Expose
    private String userData;

    /**
     * 模板参数的集合
     */
    public List<OperationSet> getOperationSets() {
        return this.operationSets;
    }

    /**
     * 模板参数的集合
     */
    public void setOperationSets(List<OperationSet> operationSets) {
        this.operationSets = operationSets;
    }

    /**
     * 回调URL
     */
    public String getCallbackUrl() {
        return this.callbackUrl;
    }

    /**
     * 回调URL
     */
    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    /**
     * 回到方法默认HTTP
     */
    public String getCallbackMethod() {
        return this.callbackMethod;
    }

    /**
     * 回到方法默认HTTP
     */
    public void setCallbackMethod(String callbackMethod) {
        this.callbackMethod = callbackMethod;
    }

    /**
     * 透传参数
     */
    public String getUserData() {
        return this.userData;
    }

    /**
     * 透传参数
     */
    public void setUserData(String userData) {
        this.userData = userData;
    }

}

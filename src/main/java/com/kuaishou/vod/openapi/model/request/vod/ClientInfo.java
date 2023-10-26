package com.kuaishou.vod.openapi.model.request.vod;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientInfo {

    @SerializedName("TaskId")
    @Expose
    private String taskId;
    @SerializedName("TokenName")
    @Expose
    private String tokenName;
    @SerializedName("Token")
    @Expose
    private String token;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTokenName() {
        return tokenName;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

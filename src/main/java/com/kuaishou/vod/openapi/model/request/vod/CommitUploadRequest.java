package com.kuaishou.vod.openapi.model.request.vod;

import java.util.HashMap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractRequest;

public class CommitUploadRequest extends AbstractRequest {

    @SerializedName("SessionKey")
    @Expose
    private String sessionKey;

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    @Override
    public HashMap<String, String> toMap() {
        HashMap<String, String> map = new HashMap<>();
        map.computeIfAbsent("SessionKey", key -> this.sessionKey);
        return map;
    }
}

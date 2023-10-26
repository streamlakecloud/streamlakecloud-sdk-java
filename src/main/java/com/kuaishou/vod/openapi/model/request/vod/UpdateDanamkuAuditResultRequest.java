package com.kuaishou.vod.openapi.model.request.vod;

import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractRequest;

public class UpdateDanamkuAuditResultRequest extends AbstractRequest {
    @SerializedName("DanmakuId")
    @Expose
    public Long danmakuId;

    @SerializedName("Status")
    @Expose
    public String status;

    public Long getDanmakuId() {
        return danmakuId;
    }

    public void setDanmakuId(Long danmakuId) {
        this.danmakuId = danmakuId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public HashMap<String, String> toMap() {
        HashMap<String, String> map = new HashMap<>();
        map.computeIfAbsent("DanmakuId", key -> new Gson().toJson(this.danmakuId));
        map.computeIfAbsent("Status", key -> new Gson().toJson(this.status));
        return map;
    }
}

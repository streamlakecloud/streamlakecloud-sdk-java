package com.kuaishou.vod.openapi.model.request.vod;

import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractRequest;

public class ListDanmakuPreAuditRequest extends AbstractRequest {
    @SerializedName("StartTime")
    @Expose
    public Long startTime;

    @SerializedName("EndTime")
    @Expose
    public Long endTime;

    @SerializedName("ResourceId")
    @Expose
    public String resourceId;

    @SerializedName("PrimaryKey")
    @Expose
    public String primaryKey;

    @SerializedName("Limit")
    @Expose
    public Integer limit;

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }


    @Override
    public HashMap<String, String> toMap() {
        HashMap<String, String> map = new HashMap<>();
        map.computeIfAbsent("StartTime", key -> new Gson().toJson(this.startTime));
        map.computeIfAbsent("EndTime", key -> new Gson().toJson(this.endTime));
        map.computeIfAbsent("ResourceId", key -> new Gson().toJson(this.resourceId));
        map.computeIfAbsent("PrimaryKey", key -> new Gson().toJson(this.primaryKey));
        map.computeIfAbsent("Limit", key -> new Gson().toJson(this.limit));
        return map;
    }
}

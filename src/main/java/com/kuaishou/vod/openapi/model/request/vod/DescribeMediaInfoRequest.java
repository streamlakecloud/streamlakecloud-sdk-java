package com.kuaishou.vod.openapi.model.request.vod;

import java.util.HashMap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractRequest;

public class DescribeMediaInfoRequest extends AbstractRequest {
    @SerializedName("MediaId")
    @Expose
    public String mediaId;

    @SerializedName("PrimaryKey")
    @Expose
    public String primaryKey;

    @SerializedName("Filters")
    @Expose
    public String filters;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Override
    public HashMap<String, String> toMap() {
        HashMap<String, String> map = new HashMap<>();
        map.computeIfAbsent("MediaId", key -> this.mediaId);
        map.computeIfAbsent("PrimaryKey", key -> this.primaryKey);
        map.computeIfAbsent("Filters", key -> this.filters);
        return map;
    }
}

package com.kuaishou.vod.openapi.model.request.vod;

import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractRequest;

/**
 * @author fubaiqiang <fubaiqiang@kuaishou.com>
 * Created on 2023-12-13
 */
public class ListMediaProcessJobRequest extends AbstractRequest {
    @SerializedName("ProcessType")
    @Expose
    private String processType;

    @SerializedName("Offset")
    @Expose
    private Integer offset;

    @SerializedName("Limit")
    @Expose
    private Integer limit;

    @SerializedName("SpaceName")
    @Expose
    private String spaceName;

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    @Override
    public HashMap<String, String> toMap() {
        HashMap<String, String> map = new HashMap<>();
        map.computeIfAbsent("ProcessType", key -> new Gson().toJson(this.processType));
        map.computeIfAbsent("Offset", key -> new Gson().toJson(this.offset));
        map.computeIfAbsent("Limit", key -> new Gson().toJson(this.limit));
        map.computeIfAbsent("SpaceName", key -> new Gson().toJson(this.spaceName));
        return map;
    }
}

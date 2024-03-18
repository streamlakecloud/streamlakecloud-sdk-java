package com.kuaishou.vod.openapi.model.request.vod;

import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractRequest;

public class FetchUploadRequest extends AbstractRequest {
    @SerializedName("URLSets")
    @Expose
    public List<URLSet> urlSets;
    @SerializedName("SpaceName")
    @Expose
    public String spaceName;

    public List<URLSet> getUrlSets() {
        return urlSets;
    }

    public void setUrlSets(List<URLSet> urlSets) {
        this.urlSets = urlSets;
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
        map.computeIfAbsent("URLSets", key -> new Gson().toJson(this.urlSets));
        map.computeIfAbsent("SpaceName", key -> this.spaceName);
        return map;
    }
}

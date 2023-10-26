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

    public List<URLSet> getUrlSets() {
        return urlSets;
    }

    public void setUrlSets(List<URLSet> urlSets) {
        this.urlSets = urlSets;
    }

    @Override
    public HashMap<String, String> toMap() {
        HashMap<String, String> map = new HashMap<>();
        map.computeIfAbsent("URLSets", key -> new Gson().toJson(this.urlSets));
        return map;
    }
}

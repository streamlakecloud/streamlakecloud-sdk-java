package com.kuaishou.vod.openapi.model.request.cdn;

import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractRequest;

public class PushPCDNObjectCacheRequest extends AbstractRequest {

    @SerializedName("FileSets")
    @Expose
    public List<PCDNFileSet> fileSets;

    public List<PCDNFileSet> getFileSets() {
        return fileSets;
    }

    public void setFileSets(List<PCDNFileSet> fileSets) {
        this.fileSets = fileSets;
    }

    @Override
    public HashMap<String, String> toMap() {
        HashMap<String, String> map = new HashMap<>();
        map.computeIfAbsent("FileSets", key -> new Gson().toJson(this.fileSets));
        return map;
    }
}

package com.kuaishou.vod.openapi.model.request.vod;

import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractRequest;

public class SubmitMediaProcessJobsRequest extends AbstractRequest {
    @SerializedName("MediaId")
    @Expose
    public String mediaId;

    @SerializedName("ProcessSet")
    @Expose
    public ProcessSet processSet;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public ProcessSet getProcessSet() {
        return processSet;
    }

    public void setProcessSet(ProcessSet processSet) {
        this.processSet = processSet;
    }

    @Override
    public HashMap<String, String> toMap() {
        HashMap<String, String> map = new HashMap<>();
        map.computeIfAbsent("MediaId", key -> new Gson().toJson(this.mediaId));
        map.computeIfAbsent("ProcessSet", key -> new Gson().toJson(this.processSet));
        return map;
    }
}

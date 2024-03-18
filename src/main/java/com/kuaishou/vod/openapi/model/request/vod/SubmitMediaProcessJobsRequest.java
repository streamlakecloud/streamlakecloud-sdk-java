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

    @SerializedName("SpaceName")
    @Expose
    public String spaceName;

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

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    @Override
    public HashMap<String, String> toMap() {
        HashMap<String, String> map = new HashMap<>();
        map.computeIfAbsent("MediaId", key -> this.mediaId);
        map.computeIfAbsent("ProcessSet", key -> new Gson().toJson(this.processSet));
        map.computeIfAbsent("SpaceName", key -> this.spaceName);
        return map;
    }
}

package com.kuaishou.vod.openapi.model.request.vod;

import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractRequest;

public class ProcessMediaRequest extends AbstractRequest {
    @SerializedName("MediaId")
    @Expose
    public String mediaId;
    @SerializedName("TranscodeSets")
    @Expose
    public List<TranscodeSet> transcodeSets;
    @SerializedName("SpaceName")
    @Expose
    public String spaceName;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public List<TranscodeSet> getTranscodeSets() {
        return transcodeSets;
    }

    public void setTranscodeSets(List<TranscodeSet> transcodeSets) {
        this.transcodeSets = transcodeSets;
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
        map.computeIfAbsent("TranscodeSets", key -> new Gson().toJson(this.transcodeSets));
        map.computeIfAbsent("SpaceName", key -> this.spaceName);
        return map;
    }
}

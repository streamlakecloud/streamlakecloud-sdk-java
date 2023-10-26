package com.kuaishou.vod.openapi.model.request.vod;

import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractRequest;

public class EnhanceMediaRequest extends AbstractRequest {

    @SerializedName("CallbackLink")
    @Expose
    private String callbackLink;
    @SerializedName("MediaItemSet")
    @Expose
    private MediaItemSet mediaItemSet;

    public String getCallbackLink() {
        return callbackLink;
    }

    public void setCallbackLink(String callbackLink) {
        this.callbackLink = callbackLink;
    }

    public MediaItemSet getMediaItemSet() {
        return mediaItemSet;
    }

    public void setMediaItemSet(MediaItemSet mediaItemSet) {
        this.mediaItemSet = mediaItemSet;
    }

    @Override
    public HashMap<String, String> toMap() {
        HashMap<String, String> map = new HashMap<>();
        map.computeIfAbsent("MediaId", key -> this.callbackLink);
        map.computeIfAbsent("MediaItemSet", key -> new Gson().toJson(this.mediaItemSet));
        return map;
    }
}

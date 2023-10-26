package com.kuaishou.vod.openapi.model.request.vod;

import java.util.HashMap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractRequest;

public class ApplyUploadInfoRequest extends AbstractRequest {

    @SerializedName("SessionKey")
    @Expose
    private String sessionKey;
    @SerializedName("MediaSort")
    @Expose
    private String mediaSort;
    @SerializedName("FilePath")
    @Expose
    private String filePath;
    @SerializedName("Format")
    @Expose
    private String format;

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getMediaSort() {
        return mediaSort;
    }

    public void setMediaSort(String mediaSort) {
        this.mediaSort = mediaSort;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }


    @Override
    public HashMap<String, String> toMap() {
        HashMap<String, String> map = new HashMap<>();
        map.computeIfAbsent("SessionKey", key -> this.sessionKey);
        map.computeIfAbsent("MediaSort", key -> this.mediaSort);
        map.computeIfAbsent("FilePath", key -> this.filePath);
        map.computeIfAbsent("Format", key -> this.format);
        return map;
    }
}

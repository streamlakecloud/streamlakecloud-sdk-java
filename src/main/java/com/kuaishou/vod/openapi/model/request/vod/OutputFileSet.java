package com.kuaishou.vod.openapi.model.request.vod;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OutputFileSet {
    @SerializedName("Bucket")
    @Expose
    private String bucket;
    @SerializedName("Object")
    @Expose
    private String object;

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }
}

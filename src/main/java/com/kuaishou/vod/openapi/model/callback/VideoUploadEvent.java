package com.kuaishou.vod.openapi.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractEvent;

/**
 *
 * Created on 2021-07-13
 */
public class VideoUploadEvent extends AbstractEvent {

    @SerializedName("FileSize")
    @Expose
    public long fileSize;

    @SerializedName("URLPath")
    @Expose
    public String URLPath;

    public String getURLPath() {
        return URLPath;
    }

    public void setURLPath(String URLPath) {
        this.URLPath = URLPath;
    }

    public VideoUploadEvent(Class aClass) {
        super(aClass);
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
}

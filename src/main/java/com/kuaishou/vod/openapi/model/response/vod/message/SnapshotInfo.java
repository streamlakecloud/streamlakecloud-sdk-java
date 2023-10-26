package com.kuaishou.vod.openapi.model.response.vod.message;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SnapshotInfo {

    @SerializedName("SnapshotName")
    @Expose
    public String snapshotName;

    @SerializedName("Format")
    @Expose
    public String format;

    @SerializedName("UrlPath")
    @Expose
    public String urlPath;

    @SerializedName("Width")
    @Expose
    public String width;

    @SerializedName("Height")
    @Expose
    public String height;

    public String getSnapshotName() {
        return snapshotName;
    }

    public void setSnapshotName(String snapshotName) {
        this.snapshotName = snapshotName;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}

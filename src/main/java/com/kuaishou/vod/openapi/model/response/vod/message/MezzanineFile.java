package com.kuaishou.vod.openapi.model.response.vod.message;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MezzanineFile {

    @SerializedName("RrlPath")
    @Expose
    public String urlPath;
    @SerializedName("Format")
    @Expose
    public String format;
    @SerializedName("Duration")
    @Expose
    public double duration;
    @SerializedName("CreateTime")
    @Expose
    public String createTime;
    @SerializedName("Width")
    @Expose
    public String width;
    @SerializedName("Height")
    @Expose
    public String height;
    @SerializedName("Fps")
    @Expose
    public double fps;
    @SerializedName("Bitrate")
    @Expose
    public int bitrate;
    @SerializedName("FileSize")
    @Expose
    public long fileSize;

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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

    public double getFps() {
        return fps;
    }

    public void setFps(double fps) {
        this.fps = fps;
    }

    public int getBitrate() {
        return bitrate;
    }

    public void setBitrate(int bitrate) {
        this.bitrate = bitrate;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
}

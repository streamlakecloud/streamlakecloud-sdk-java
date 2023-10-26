package com.kuaishou.vod.openapi.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractEvent;

/**
 *
 * Created on 2021-07-13
 */
public class VideoMetaEvent extends AbstractEvent {
    @SerializedName("Format")
    @Expose
    public String format;

    @SerializedName("Duration")
    @Expose
    public double duration;

    @SerializedName("Width")
    @Expose
    public int width;

    @SerializedName("Height")
    @Expose
    public int height;

    @SerializedName("Bitrate")
    @Expose
    public double bitrate;

    @SerializedName("Fps")
    @Expose
    public double fps;

    @SerializedName("FileSize")
    @Expose
    public long fileSize;

    public VideoMetaEvent(Class aClass) {
        super(aClass);
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getBitrate() {
        return bitrate;
    }

    public void setBitrate(int bitrate) {
        this.bitrate = bitrate;
    }

    public double getFps() {
        return fps;
    }

    public void setFps(double fps) {
        this.fps = fps;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
}

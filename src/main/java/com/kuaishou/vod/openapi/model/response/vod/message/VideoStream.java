package com.kuaishou.vod.openapi.model.response.vod.message;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VideoStream {

    @SerializedName("Duration")
    @Expose
    public double duration;


    @SerializedName("Width")
    @Expose
    public int width;

    @SerializedName("Height")
    @Expose
    public int height;

    @SerializedName("Fps")
    @Expose
    public double fps;

    @SerializedName("Bitrate")
    @Expose
    public int bitrate;

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
}

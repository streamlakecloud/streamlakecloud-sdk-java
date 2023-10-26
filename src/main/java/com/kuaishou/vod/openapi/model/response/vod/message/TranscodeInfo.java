package com.kuaishou.vod.openapi.model.response.vod.message;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TranscodeInfo {

    @SerializedName("TranscodeName")
    @Expose
    public String transcodeName;

    @SerializedName("UrlPath")
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
    public int width;

    @SerializedName("Height")
    @Expose
    public int height;

    @SerializedName("Fps")
    @Expose
    public double fps;

    @SerializedName("BitRate")
    @Expose
    public int bitrate;

    @SerializedName("FileSize")
    @Expose
    public long fileSize;

    @SerializedName("VideoMaxBitrate")
    @Expose
    public int videoMaxBitrate;

    @SerializedName("VideoStream")
    @Expose
    public List<VideoStream> videoStreams;

    @SerializedName("AudioStream")
    @Expose
    public List<AudioStream> audioStreams;

    public String getTranscodeName() {
        return transcodeName;
    }

    public void setTranscodeName(String transcodeName) {
        this.transcodeName = transcodeName;
    }

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

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public int getVideoMaxBitrate() {
        return videoMaxBitrate;
    }

    public void setVideoMaxBitrate(int videoMaxBitrate) {
        this.videoMaxBitrate = videoMaxBitrate;
    }

    public List<VideoStream> getVideoStreams() {
        return videoStreams;
    }

    public void setVideoStreams(
        List<VideoStream> videoStreams) {
        this.videoStreams = videoStreams;
    }

    public List<AudioStream> getAudioStreams() {
        return audioStreams;
    }

    public void setAudioStreams(
        List<AudioStream> audioStreams) {
        this.audioStreams = audioStreams;
    }
}

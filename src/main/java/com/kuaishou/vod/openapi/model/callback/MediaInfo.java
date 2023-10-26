package com.kuaishou.vod.openapi.model.callback;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MediaInfo {
    /**
     * 失败时的错误码
     */
    @SerializedName("ErrorCode")
    @Expose
    public String errorCode;
    /**
     * 失败时的错误信息
     */
    @SerializedName("ErrorMessage")
    @Expose
    public String errorMessage;
    @SerializedName("UrlPath")
    @Expose
    public String urlPath;
    /**
     * 视频流信息
     */
    @SerializedName("VideoStreams")
    @Expose
    public List<VideoStreamInfo> videoStreams;
    /**
     * 音频流信息
     */
    @SerializedName("AudioStreams")
    @Expose
    public List<AudioStreamInfo> audioStreams;
    /**
     * 封装格式等信息
     */
    @SerializedName("Format")
    @Expose
    public Format format;

    /**
     * 失败时的错误码
     */
    public String getErrorCode() {
        return this.errorCode;
    }

    /**
     * 失败时的错误码
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * 失败时的错误信息
     */
    public String getErrorMessage() {
        return this.errorMessage;
    }

    /**
     * 失败时的错误信息
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public List<VideoStreamInfo> getVideoStreams() {
        return videoStreams;
    }

    public void setVideoStreams(List<VideoStreamInfo> videoStreams) {
        this.videoStreams = videoStreams;
    }

    public List<AudioStreamInfo> getAudioStreams() {
        return audioStreams;
    }

    public void setAudioStreams(List<AudioStreamInfo> audioStreams) {
        this.audioStreams = audioStreams;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }
}

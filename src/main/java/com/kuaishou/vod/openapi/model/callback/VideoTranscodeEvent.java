package com.kuaishou.vod.openapi.model.callback;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractEvent;
import com.kuaishou.vod.openapi.model.response.vod.message.AudioStream;
import com.kuaishou.vod.openapi.model.response.vod.message.VideoStream;

/**
 *
 * Created on 2021-07-13
 */
public class VideoTranscodeEvent extends AbstractEvent {
    @SerializedName("TranscodeTemplateId")
    @Expose
    public String transcodeTemplateId;

    @SerializedName("QualityType")
    @Expose
    public String qualityType;

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
    public int bitrate;

    @SerializedName("Fps")
    @Expose
    public double fps;

    @SerializedName("FileSize")
    @Expose
    public long fileSize;

    @SerializedName("VideoMaxBitrate")
    @Expose
    public int videoMaxBitrate;

    @SerializedName("VideoStreams")
    @Expose
    public List<VideoStream> videoStreams;

    @SerializedName("AudioStreams")
    @Expose
    public List<AudioStream> audioStreams;

    @SerializedName("HdrType")
    @Expose
    public String hdrType;

    @SerializedName("URLPath")
    @Expose
    public String URLPath;

    public String getURLPath() {
        return URLPath;
    }

    public void setURLPath(String URLPath) {
        this.URLPath = URLPath;
    }

    public String getHdrType() {
        return hdrType;
    }

    public void setHdrType(String hdrType) {
        this.hdrType = hdrType;
    }

    public VideoTranscodeEvent(Class aClass) {
        super(aClass);
    }

    public String getTranscodeTemplateId() {
        return transcodeTemplateId;
    }

    public void setTranscodeTemplateId(String transcodeTemplateId) {
        this.transcodeTemplateId = transcodeTemplateId;
    }

    public String getQualityType() {
        return qualityType;
    }

    public void setQualityType(String qualityType) {
        this.qualityType = qualityType;
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

    public int getBitrate() {
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

    public int getVideoMaxBitrate() {
        return videoMaxBitrate;
    }

    public void setVideoMaxBitrate(int videoMaxBitrate) {
        this.videoMaxBitrate = videoMaxBitrate;
    }

    public List<VideoStream> getVideoStreams() {
        return videoStreams;
    }

    public void setVideoStreams(List<VideoStream> videoStreams) {
        this.videoStreams = videoStreams;
    }

    public List<AudioStream> getAudioStreams() {
        return audioStreams;
    }

    public void setAudioStreams(List<AudioStream> audioStreams) {
        this.audioStreams = audioStreams;
    }
}

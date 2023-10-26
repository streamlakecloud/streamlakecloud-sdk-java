package com.kuaishou.vod.openapi.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractEvent;

/**
 *
 * Created on 2021-07-13
 */
public class AudioTranscodeEvent extends AbstractEvent {
    @SerializedName("TranscodeTemplateId")
    @Expose
    public String transcodeTemplateId;

    @SerializedName("Format")
    @Expose
    public String format;

    @SerializedName("Duration")
    @Expose
    public double duration;

    @SerializedName("Bitrate")
    @Expose
    public int bitrate;

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

    public AudioTranscodeEvent(Class aClass) {
        super(aClass);
    }

    public String getTranscodeTemplateId() {
        return transcodeTemplateId;
    }

    public void setTranscodeTemplateId(String transcodeTemplateId) {
        this.transcodeTemplateId = transcodeTemplateId;
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

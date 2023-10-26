package com.kuaishou.vod.openapi.model.request.vod;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TranscodeSet {
    @SerializedName("TranscodeTemplateId")
    @Expose
    public String transcodeTemplateId;
    @SerializedName("URLPath")
    @Expose
    public String urlPath;
    @SerializedName("Container")
    @Expose
    public String container;
    @SerializedName("Codec")
    @Expose
    public String codec;
    @SerializedName("Fps")
    @Expose
    public String fps;
    @SerializedName("Width")
    @Expose
    public String width;
    @SerializedName("Height")
    @Expose
    public String height;
    @SerializedName("Gop")
    @Expose
    public String gop;
    @SerializedName("MaxRate")
    @Expose
    public String maxRate;
    @SerializedName("LongShortMode")
    @Expose
    public String longShortMode;
    @SerializedName("WatermarkSets")
    @Expose
    public List<WatermarkSet> watermarkSets;

    public String getTranscodeTemplateId() {
        return transcodeTemplateId;
    }

    public void setTranscodeTemplateId(String transcodeTemplateId) {
        this.transcodeTemplateId = transcodeTemplateId;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getCodec() {
        return codec;
    }

    public void setCodec(String codec) {
        this.codec = codec;
    }

    public String getFps() {
        return fps;
    }

    public void setFps(String fps) {
        this.fps = fps;
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

    public String getGop() {
        return gop;
    }

    public void setGop(String gop) {
        this.gop = gop;
    }

    public String getMaxRate() {
        return maxRate;
    }

    public void setMaxRate(String maxRate) {
        this.maxRate = maxRate;
    }

    public String getLongShortMode() {
        return longShortMode;
    }

    public void setLongShortMode(String longShortMode) {
        this.longShortMode = longShortMode;
    }

    public List<WatermarkSet> getWatermarkSets() {
        return watermarkSets;
    }

    public void setWatermarkSets(List<WatermarkSet> watermarkSets) {
        this.watermarkSets = watermarkSets;
    }
}

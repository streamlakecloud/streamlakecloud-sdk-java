package com.kuaishou.vod.openapi.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Format {
    /**
     * 文件封装格式
     */
    @SerializedName("FormatName")
    @Expose
    public String formatName;
    /**
     * 文件大小, 单位: byte
     */
    @SerializedName("Size")
    @Expose
    public Long size;
    /**
     * 总时长,单位:s
     */
    @SerializedName("Duration")
    @Expose
    public Double duration;
    /**
     * 码率
     */
    @SerializedName("Bitrate")
    @Expose
    public Long bitrate;
    @SerializedName("ListSize")
    @Expose
    public Long listSize;
    /**
     * 编码器名称
     */
    @SerializedName("CodecName")
    @Expose
    public String codecName;
    /**
     * 宽
     */
    @SerializedName("Width")
    @Expose
    public Integer width;
    /**
     * 高
     */
    @SerializedName("Height")
    @Expose
    public Integer height;

    /**
     * 文件封装格式
     */
    public String getFormatName() {
        return this.formatName;
    }

    /**
     * 文件封装格式
     */
    public void setFormatName(String formatName) {
        this.formatName = formatName;
    }


    /**
     * 文件大小, 单位: byte
     */
    public Long getSize() {
        return this.size;
    }

    /**
     * 文件大小, 单位: byte
     */
    public void setSize(Long size) {
        this.size = size;
    }

    /**
     * 总时长,单位:s
     */
    public Double getDuration() {
        return this.duration;
    }

    /**
     * 总时长,单位:s
     */
    public void setDuration(Double duration) {
        this.duration = duration;
    }

    /**
     * 码率
     */
    public Long getBitrate() {
        return this.bitrate;
    }

    public Long getListSize() {
        return listSize;
    }

    public void setListSize(Long listSize) {
        this.listSize = listSize;
    }

    /**
     * 码率
     */
    public void setBitrate(Long bitrate) {
        this.bitrate = bitrate;
    }

    /**
     * 编码器名称
     */
    public String getCodecName() {
        return this.codecName;
    }

    /**
     * 编码器名称
     */
    public void setCodecName(String codecName) {
        this.codecName = codecName;
    }

    /**
     * 宽
     */
    public Integer getWidth() {
        return this.width;
    }

    /**
     * 宽
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * 高
     */
    public Integer getHeight() {
        return this.height;
    }

    /**
     * 高
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

}

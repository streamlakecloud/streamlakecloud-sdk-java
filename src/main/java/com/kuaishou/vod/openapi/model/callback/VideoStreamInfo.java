package com.kuaishou.vod.openapi.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VideoStreamInfo {
    /**
     * 编码器类型
     */
    @SerializedName("CodecType")
    @Expose
    public String codecType;
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
     * 平均帧率
     */
    @SerializedName("AvgFrameRate")
    @Expose
    public String avgFrameRate;
    /**
     * 帧率
     */
    @SerializedName("RFrameRate")
    @Expose
    public String rFrameRate;
    /**
     * 码率
     */
    @SerializedName("Bitrate")
    @Expose
    public Long bitrate;
    /**
     * 开始时间
     */
    @SerializedName("StartTime")
    @Expose
    public Double startTime;
    /**
     * PixelFormat像素格式
     */
    @SerializedName("PixFmt")
    @Expose
    public String pixFmt;
    /**
     * hdr类型
     */
    @SerializedName("HdrType")
    @Expose
    public String hdrType;
    /**
     * 时长,单位:秒
     */
    @SerializedName("Duration")
    @Expose
    public Double duration;

    /**
     * 文件类型
     */
    public String getCodecType() {
        return this.codecType;
    }

    /**
     * 文件类型
     */
    public void setCodecType(String codecType) {
        this.codecType = codecType;
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

    /**
     * 平均帧率
     */
    public String getAvgFrameRate() {
        return this.avgFrameRate;
    }

    /**
     * 平均帧率
     */
    public void setAvgFrameRate(String avgFrameRate) {
        this.avgFrameRate = avgFrameRate;
    }

    /**
     * 帧率
     */
    public String getRFrameRate() {
        return this.rFrameRate;
    }

    /**
     * 帧率
     */
    public void setRFrameRate(String rFrameRate) {
        this.rFrameRate = rFrameRate;
    }

    /**
     * 码率
     */
    public Long getBitrate() {
        return this.bitrate;
    }

    /**
     * 码率
     */
    public void setBitrate(Long bitrate) {
        this.bitrate = bitrate;
    }

    /**
     * 开始时间
     */
    public Double getStartTime() {
        return this.startTime;
    }

    /**
     * 开始时间
     */
    public void setStartTime(Double startTime) {
        this.startTime = startTime;
    }

    /**
     * PixelFormat像素格式
     */
    public String getPixFmt() {
        return this.pixFmt;
    }

    /**
     * PixelFormat像素格式
     */
    public void setPixFmt(String pixFmt) {
        this.pixFmt = pixFmt;
    }

    /**
     * hdr类型
     */
    public String getHdrType() {
        return this.hdrType;
    }

    /**
     * hdr类型
     */
    public void setHdrType(String hdrType) {
        this.hdrType = hdrType;
    }

    /**
     * 时长,单位:秒
     */
    public Double getDuration() {
        return this.duration;
    }

    /**
     * 时长,单位:秒
     */
    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public static final class VideoStreamInfoBuilder {
        /**
         * 文件类型
         */
        public String codecType;
        /**
         * 编码器名称
         */
        public String codecName;
        /**
         * 宽
         */
        public Integer width;
        /**
         * 高
         */
        public Integer height;
        /**
         * 平均帧率
         */
        public String avgFrameRate;
        /**
         * 帧率
         */
        public String rFrameRate;
        /**
         * 码率
         */
        public Long bitrate;
        /**
         * 开始时间
         */
        public Double startTime;
        /**
         * PixelFormat像素格式
         */
        public String pixFmt;
        /**
         * hdr类型
         */
        public String hdrType;
        /**
         * 时长,单位:秒
         */
        public Double duration;

        public VideoStreamInfoBuilder() {
        }

        public static VideoStreamInfoBuilder builder() {
            return new VideoStreamInfoBuilder();
        }

        /**
         * 文件类型
         */
        public VideoStreamInfoBuilder codeType(String codeType) {
            this.codecType = codeType;
            return this;
        }

        /**
         * 编码器名称
         */
        public VideoStreamInfoBuilder codecName(String codecName) {
            this.codecName = codecName;
            return this;
        }

        /**
         * 宽
         */
        public VideoStreamInfoBuilder width(Integer width) {
            this.width = width;
            return this;
        }

        /**
         * 高
         */
        public VideoStreamInfoBuilder height(Integer height) {
            this.height = height;
            return this;
        }

        /**
         * 平均帧率
         */
        public VideoStreamInfoBuilder avgFrameRate(String avgFrameRate) {
            this.avgFrameRate = avgFrameRate;
            return this;
        }

        /**
         * 帧率
         */
        public VideoStreamInfoBuilder rFrameRate(String rFrameRate) {
            this.rFrameRate = rFrameRate;
            return this;
        }

        /**
         * 码率
         */
        public VideoStreamInfoBuilder bitrate(Long bitrate) {
            this.bitrate = bitrate;
            return this;
        }

        /**
         * 开始时间
         */
        public VideoStreamInfoBuilder startTime(Double startTime) {
            this.startTime = startTime;
            return this;
        }

        /**
         * PixelFormat像素格式
         */
        public VideoStreamInfoBuilder pixFmt(String pixFmt) {
            this.pixFmt = pixFmt;
            return this;
        }

        /**
         * hdr类型
         */
        public VideoStreamInfoBuilder hdrType(String hdrType) {
            this.hdrType = hdrType;
            return this;
        }

        /**
         * 时长,单位:秒
         */
        public VideoStreamInfoBuilder duration(Double duration) {
            this.duration = duration;
            return this;
        }

        public VideoStreamInfoBuilder but() {
            return builder()
                    .codeType(codecType)
                    .codecName(codecName)
                    .width(width)
                    .height(height)
                    .avgFrameRate(avgFrameRate)
                    .rFrameRate(rFrameRate)
                    .bitrate(bitrate)
                    .startTime(startTime)
                    .pixFmt(pixFmt)
                    .hdrType(hdrType)
                    .duration(duration);
        }

        public VideoStreamInfo build() {
            VideoStreamInfo videostreaminfo = new VideoStreamInfo();
            videostreaminfo.setCodecType(codecType);
            videostreaminfo.setCodecName(codecName);
            videostreaminfo.setWidth(width);
            videostreaminfo.setHeight(height);
            videostreaminfo.setAvgFrameRate(avgFrameRate);
            videostreaminfo.setRFrameRate(rFrameRate);
            videostreaminfo.setBitrate(bitrate);
            videostreaminfo.setStartTime(startTime);
            videostreaminfo.setPixFmt(pixFmt);
            videostreaminfo.setHdrType(hdrType);
            videostreaminfo.setDuration(duration);
            return videostreaminfo;
        }
    }
}

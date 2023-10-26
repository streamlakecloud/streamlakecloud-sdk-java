package com.kuaishou.vod.openapi.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AudioStreamInfo {
    /**
     * 文件类型
     */
    @SerializedName("CodecType")
    @Expose
    public String codecType;
    /**
     * 开始时间
     */
    @SerializedName("StartTime")
    @Expose
    public Double startTime;
    /**
     * 时长,单位:秒
     */
    @SerializedName("Duration")
    @Expose
    public Double duration;
    /**
     * 编码器名称
     */
    @SerializedName("CodecName")
    @Expose
    public String codecName;
    /**
     * 宽
     */
    @SerializedName("Channels")
    @Expose
    public Integer channels;
    /**
     * 平均帧率
     */
    @SerializedName("SampleRate")
    @Expose
    public Long sampleRate;
    /**
     * 码率
     */
    @SerializedName("Bitrate")
    @Expose
    public Long bitrate;

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
    public Integer getChannels() {
        return this.channels;
    }

    /**
     * 宽
     */
    public void setChannels(Integer channels) {
        this.channels = channels;
    }

    /**
     * 平均帧率
     */
    public Long getSampleRate() {
        return this.sampleRate;
    }

    /**
     * 平均帧率
     */
    public void setSampleRate(Long sampleRate) {
        this.sampleRate = sampleRate;
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

    public static final class AudioStreamInfoBuilder {
        /**
         * 文件类型
         */
        public String codeType;
        /**
         * 开始时间
         */
        public Double startTime;
        /**
         * 时长,单位:秒
         */
        public Double duration;
        /**
         * 编码器名称
         */
        public String codecName;
        /**
         * 宽
         */
        public Integer channels;
        /**
         * 平均帧率
         */
        public Long sampleRate;
        /**
         * 码率
         */
        public Long bitrate;

        public AudioStreamInfoBuilder() {
        }

        public static AudioStreamInfoBuilder builder() {
            return new AudioStreamInfoBuilder();
        }

        /**
         * 文件类型
         */
        public AudioStreamInfoBuilder codeType(String codeType) {
            this.codeType = codeType;
            return this;
        }

        /**
         * 开始时间
         */
        public AudioStreamInfoBuilder startTime(Double startTime) {
            this.startTime = startTime;
            return this;
        }

        /**
         * 时长,单位:秒
         */
        public AudioStreamInfoBuilder duration(Double duration) {
            this.duration = duration;
            return this;
        }

        /**
         * 编码器名称
         */
        public AudioStreamInfoBuilder codecName(String codecName) {
            this.codecName = codecName;
            return this;
        }

        /**
         * 宽
         */
        public AudioStreamInfoBuilder channels(Integer channels) {
            this.channels = channels;
            return this;
        }

        /**
         * 平均帧率
         */
        public AudioStreamInfoBuilder sampleRate(Long sampleRate) {
            this.sampleRate = sampleRate;
            return this;
        }

        /**
         * 码率
         */
        public AudioStreamInfoBuilder bitrate(Long bitrate) {
            this.bitrate = bitrate;
            return this;
        }

        public AudioStreamInfoBuilder but() {
            return builder()
                    .codeType(codeType)
                    .startTime(startTime)
                    .duration(duration)
                    .codecName(codecName)
                    .channels(channels)
                    .sampleRate(sampleRate)
                    .bitrate(bitrate);
        }

        public AudioStreamInfo build() {
            AudioStreamInfo audiostreaminfo = new AudioStreamInfo();
            audiostreaminfo.setCodecType(codeType);
            audiostreaminfo.setStartTime(startTime);
            audiostreaminfo.setDuration(duration);
            audiostreaminfo.setCodecName(codecName);
            audiostreaminfo.setChannels(channels);
            audiostreaminfo.setSampleRate(sampleRate);
            audiostreaminfo.setBitrate(bitrate);
            return audiostreaminfo;
        }
    }
}

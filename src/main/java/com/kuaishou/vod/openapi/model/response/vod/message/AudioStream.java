package com.kuaishou.vod.openapi.model.response.vod.message;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AudioStream {

    @SerializedName("Duration")
    @Expose
    public double duration;

    @SerializedName("Bitrate")
    @Expose
    public int bitRate;

    @SerializedName("Channels")
    @Expose
    public int channels;

    @SerializedName("SampleRate")
    @Expose
    public int sampleRate;

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getBitRate() {
        return bitRate;
    }

    public void setBitRate(int bitRate) {
        this.bitRate = bitRate;
    }

    public int getChannels() {
        return channels;
    }

    public void setChannels(int channels) {
        this.channels = channels;
    }

    public int getSampleRate() {
        return sampleRate;
    }

    public void setSampleRate(int sampleRate) {
        this.sampleRate = sampleRate;
    }
}

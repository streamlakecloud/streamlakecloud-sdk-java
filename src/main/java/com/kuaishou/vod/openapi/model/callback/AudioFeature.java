package com.kuaishou.vod.openapi.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AudioFeature {
    @SerializedName("AudioQuality")
    @Expose
    private Double audioQuality;
    @SerializedName("MusicProbability")
    @Expose
    private Double musicProbability;
    @SerializedName("DialogProbability")
    @Expose
    private Double dialogProbability;
    @SerializedName("BackgroundSoundProbability")
    @Expose
    private Double backgroundSoundProbability;
    @SerializedName("MutePercentage")
    @Expose
    private Double mutePercentage;

    public Double getAudioQuality() {
        return audioQuality;
    }

    public void setAudioQuality(Double audioQuality) {
        this.audioQuality = audioQuality;
    }

    public Double getMusicProbability() {
        return musicProbability;
    }

    public void setMusicProbability(Double musicProbability) {
        this.musicProbability = musicProbability;
    }

    public Double getDialogProbability() {
        return dialogProbability;
    }

    public void setDialogProbability(Double dialogProbability) {
        this.dialogProbability = dialogProbability;
    }

    public Double getBackgroundSoundProbability() {
        return backgroundSoundProbability;
    }

    public void setBackgroundSoundProbability(Double backgroundSoundProbability) {
        this.backgroundSoundProbability = backgroundSoundProbability;
    }

    public Double getMutePercentage() {
        return mutePercentage;
    }

    public void setMutePercentage(Double mutePercentage) {
        this.mutePercentage = mutePercentage;
    }
}

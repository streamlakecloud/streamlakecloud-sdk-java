package com.kuaishou.vod.openapi.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AestheticsFeature {
    @SerializedName("DefocusProbability")
    @Expose
    private Double defocusProbability;
    @SerializedName("Colorfulness")
    @Expose
    private Double colorfulness;
    @SerializedName("UnderexposedProbability")
    @Expose
    private Double underexposedProbability;
    @SerializedName("OverexposedProbability")
    @Expose
    private Double overexposedProbability;
    @SerializedName("LowContrastProbability")
    @Expose
    private Double lowContrastProbability;
    @SerializedName("AestheticsScore")
    @Expose
    private Double aestheticsScore;

    public Double getDefocusProbability() {
        return defocusProbability;
    }

    public void setDefocusProbability(Double defocusProbability) {
        this.defocusProbability = defocusProbability;
    }

    public Double getColorfulness() {
        return colorfulness;
    }

    public void setColorfulness(Double colorfulness) {
        this.colorfulness = colorfulness;
    }

    public Double getUnderexposedProbability() {
        return underexposedProbability;
    }

    public void setUnderexposedProbability(Double underexposedProbability) {
        this.underexposedProbability = underexposedProbability;
    }

    public Double getOverexposedProbability() {
        return overexposedProbability;
    }

    public void setOverexposedProbability(Double overexposedProbability) {
        this.overexposedProbability = overexposedProbability;
    }

    public Double getLowContrastProbability() {
        return lowContrastProbability;
    }

    public void setLowContrastProbability(Double lowContrastProbability) {
        this.lowContrastProbability = lowContrastProbability;
    }

    public Double getAestheticsScore() {
        return aestheticsScore;
    }

    public void setAestheticsScore(Double aestheticsScore) {
        this.aestheticsScore = aestheticsScore;
    }
}

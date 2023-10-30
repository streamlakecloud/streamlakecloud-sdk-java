package com.kuaishou.vod.openapi.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QualityFeature {

    @SerializedName("NrQualityAvgScore")
    @Expose
    private Double nrQualityAvgScore;
    @SerializedName("BlurProbability")
    @Expose
    private Double blurProbability;
    @SerializedName("BlockyProbability")
    @Expose
    private Double blockyProbability;
    @SerializedName("NoiseProbability")
    @Expose
    private Double noiseProbability;
    @SerializedName("InterlaceRatio")
    @Expose
    private Double interlaceRatio;
    @SerializedName("DirtylensProbability")
    @Expose
    private Double dirtylensProbability;

    public Double getNrQualityAvgScore() {
        return nrQualityAvgScore;
    }

    public void setNrQualityAvgScore(Double nrQualityAvgScore) {
        this.nrQualityAvgScore = nrQualityAvgScore;
    }

    public Double getBlurProbability() {
        return blurProbability;
    }

    public void setBlurProbability(Double blurProbability) {
        this.blurProbability = blurProbability;
    }

    public Double getBlockyProbability() {
        return blockyProbability;
    }

    public void setBlockyProbability(Double blockyProbability) {
        this.blockyProbability = blockyProbability;
    }

    public Double getNoiseProbability() {
        return noiseProbability;
    }

    public void setNoiseProbability(Double noiseProbability) {
        this.noiseProbability = noiseProbability;
    }

    public Double getInterlaceRatio() {
        return interlaceRatio;
    }

    public void setInterlaceRatio(Double interlaceRatio) {
        this.interlaceRatio = interlaceRatio;
    }

    public Double getDirtylensProbability() {
        return dirtylensProbability;
    }

    public void setDirtylensProbability(Double dirtylensProbability) {
        this.dirtylensProbability = dirtylensProbability;
    }
}

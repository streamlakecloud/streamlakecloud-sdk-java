package com.kuaishou.vod.openapi.model.callback;

import java.util.List;

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
    @SerializedName("BlurProbabilityNew")
    @Expose
    private Double blurProbabilityNew;
    @SerializedName("BlockyProbabilityNew")
    @Expose
    private Double blockyProbabilityNew;
    @SerializedName("LowLightPercentage")
    @Expose
    private Double lowLightPercentage;
    @SerializedName("CorruptionProbability")
    @Expose
    private Double corruptionProbability;
    @SerializedName("NoiseProbabilityNew")
    @Expose
    private Double noiseProbabilityNew;
    @SerializedName("InterlaceScaleClass")
    @Expose
    private Double interlaceScaleClass;
    @SerializedName("NrQualityScoreNN")
    @Expose
    private List<Double> nrQualityScoreNN;

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

    public Double getBlurProbabilityNew() {
        return blurProbabilityNew;
    }

    public void setBlurProbabilityNew(Double blurProbabilityNew) {
        this.blurProbabilityNew = blurProbabilityNew;
    }

    public Double getBlockyProbabilityNew() {
        return blockyProbabilityNew;
    }

    public void setBlockyProbabilityNew(Double blockyProbabilityNew) {
        this.blockyProbabilityNew = blockyProbabilityNew;
    }

    public Double getLowLightPercentage() {
        return lowLightPercentage;
    }

    public void setLowLightPercentage(Double lowLightPercentage) {
        this.lowLightPercentage = lowLightPercentage;
    }

    public Double getCorruptionProbability() {
        return corruptionProbability;
    }

    public void setCorruptionProbability(Double corruptionProbability) {
        this.corruptionProbability = corruptionProbability;
    }

    public Double getNoiseProbabilityNew() {
        return noiseProbabilityNew;
    }

    public void setNoiseProbabilityNew(Double noiseProbabilityNew) {
        this.noiseProbabilityNew = noiseProbabilityNew;
    }

    public Double getInterlaceScaleClass() {
        return interlaceScaleClass;
    }

    public void setInterlaceScaleClass(Double interlaceScaleClass) {
        this.interlaceScaleClass = interlaceScaleClass;
    }

    public List<Double> getNrQualityScoreNN() {
        return nrQualityScoreNN;
    }

    public void setNrQualityScoreNN(List<Double> nrQualityScoreNN) {
        this.nrQualityScoreNN = nrQualityScoreNN;
    }
}

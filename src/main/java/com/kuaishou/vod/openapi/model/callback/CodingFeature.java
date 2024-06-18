package com.kuaishou.vod.openapi.model.callback;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author fubaiqiang <fubaiqiang@kuaishou.com>
 * Created on 2024-05-27
 */
public class CodingFeature {
    @SerializedName("EntropyAvg")
    @Expose
    private Double entropyAvg;

    @SerializedName("EntropyVar")
    @Expose
    //帧内复杂度的方差
    private Double entropyVar;

    @SerializedName("IntraComplexity")
    @Expose
    //帧内复杂度
    private Double intraComplexity;

    @SerializedName("InterComplexity")
    @Expose
    //帧间复杂度
    private Double interComplexity;

    @SerializedName("TopIntraComplexity")
    @Expose
    //多帧帧内复杂度top部分
    private Double topIntraComplexity;

    @SerializedName("TopInterComplexity")
    @Expose
    //多帧帧间复杂度top部分
    private Double topInterComplexity;

    @SerializedName("MaxIntraComplexity")
    @Expose
    //多帧帧内复杂度最大值
    private Double maxIntraComplexity;

    @SerializedName("MaxInterComplexity")
    @Expose
    //多帧帧间复杂度最大值
    private Double maxInterComplexity;

    @SerializedName("MinIntraComplexity")
    @Expose
    //多帧帧内复杂度最小值
    private Double minIntraComplexity;

    @SerializedName("MinInterComplexity")
    @Expose
    //多帧帧内复杂度最小值
    private Double minInterComplexity;

    @SerializedName("YMean")
    @Expose
    //Y通道均值
    private Double yMean;

    @SerializedName("YMeanMax")
    @Expose
    //多帧Y通道均值最大值
    private Double yMeanMax;

    @SerializedName("YMeanMin")
    @Expose
    //多帧Y通道均值最大值
    private Double yMeanMin;

    @SerializedName("YDiffStd")
    @Expose
    //Y通道差异标准差
    private Double yDiffStd;

    @SerializedName("YDiffStdMax")
    @Expose
    //多帧Y通道差异标准差最大值
    private Double yDiffStdMax;

    @SerializedName("YDiffStdMin")
    @Expose
    //多帧Y通道差异标准差最大值
    private Double yDiffStdMin;

    @SerializedName("CapeMotionVertical")
    @Expose
    //垂直运动量
    private Double capeMotionVertical;

    @SerializedName("CapeMotionHorizon")
    @Expose
    //水平运动量
    private Double capeMotionHorizon;

    @SerializedName("Embedding")
    @Expose
    //编码特征向量
    private List<Double> embedding;

    public Double getEntropyAvg() {
        return entropyAvg;
    }

    public void setEntropyAvg(Double entropyAvg) {
        this.entropyAvg = entropyAvg;
    }

    public Double getEntropyVar() {
        return entropyVar;
    }

    public void setEntropyVar(Double entropyVar) {
        this.entropyVar = entropyVar;
    }

    public Double getIntraComplexity() {
        return intraComplexity;
    }

    public void setIntraComplexity(Double intraComplexity) {
        this.intraComplexity = intraComplexity;
    }

    public Double getInterComplexity() {
        return interComplexity;
    }

    public void setInterComplexity(Double interComplexity) {
        this.interComplexity = interComplexity;
    }

    public Double getTopIntraComplexity() {
        return topIntraComplexity;
    }

    public void setTopIntraComplexity(Double topIntraComplexity) {
        this.topIntraComplexity = topIntraComplexity;
    }

    public Double getTopInterComplexity() {
        return topInterComplexity;
    }

    public void setTopInterComplexity(Double topInterComplexity) {
        this.topInterComplexity = topInterComplexity;
    }

    public Double getMaxIntraComplexity() {
        return maxIntraComplexity;
    }

    public void setMaxIntraComplexity(Double maxIntraComplexity) {
        this.maxIntraComplexity = maxIntraComplexity;
    }

    public Double getMaxInterComplexity() {
        return maxInterComplexity;
    }

    public void setMaxInterComplexity(Double maxInterComplexity) {
        this.maxInterComplexity = maxInterComplexity;
    }

    public Double getMinIntraComplexity() {
        return minIntraComplexity;
    }

    public void setMinIntraComplexity(Double minIntraComplexity) {
        this.minIntraComplexity = minIntraComplexity;
    }

    public Double getMinInterComplexity() {
        return minInterComplexity;
    }

    public void setMinInterComplexity(Double minInterComplexity) {
        this.minInterComplexity = minInterComplexity;
    }

    public Double getyMean() {
        return yMean;
    }

    public void setyMean(Double yMean) {
        this.yMean = yMean;
    }

    public Double getyMeanMax() {
        return yMeanMax;
    }

    public void setyMeanMax(Double yMeanMax) {
        this.yMeanMax = yMeanMax;
    }

    public Double getyMeanMin() {
        return yMeanMin;
    }

    public void setyMeanMin(Double yMeanMin) {
        this.yMeanMin = yMeanMin;
    }

    public Double getyDiffStd() {
        return yDiffStd;
    }

    public void setyDiffStd(Double yDiffStd) {
        this.yDiffStd = yDiffStd;
    }

    public Double getyDiffStdMax() {
        return yDiffStdMax;
    }

    public void setyDiffStdMax(Double yDiffStdMax) {
        this.yDiffStdMax = yDiffStdMax;
    }

    public Double getyDiffStdMin() {
        return yDiffStdMin;
    }

    public void setyDiffStdMin(Double yDiffStdMin) {
        this.yDiffStdMin = yDiffStdMin;
    }

    public Double getCapeMotionVertical() {
        return capeMotionVertical;
    }

    public void setCapeMotionVertical(Double capeMotionVertical) {
        this.capeMotionVertical = capeMotionVertical;
    }

    public Double getCapeMotionHorizon() {
        return capeMotionHorizon;
    }

    public void setCapeMotionHorizon(Double capeMotionHorizon) {
        this.capeMotionHorizon = capeMotionHorizon;
    }

    public List<Double> getEmbedding() {
        return embedding;
    }

    public void setEmbedding(List<Double> embedding) {
        this.embedding = embedding;
    }
}

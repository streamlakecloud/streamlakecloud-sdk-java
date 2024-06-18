package com.kuaishou.vod.openapi.model.callback;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContentFeature {
    @SerializedName("JunkVideoProbability")
    @Expose
    private Double junkVideoProbability;
    @SerializedName("LetterboxProbability")
    @Expose
    private Double letterboxProbability;
    @SerializedName("OritationProbability")
    @Expose
    private Double oritationProbability;
    @SerializedName("R0Probability")
    @Expose
    private Double r0Probability;
    @SerializedName("R90Probability")
    @Expose
    private Double r90Probability;
    @SerializedName("R270Probability")
    @Expose
    private Double r270Probability;
    @SerializedName("NormalProbability")
    @Expose
    private Double normalProbability;
    @SerializedName("PureProbability")
    @Expose
    private Double pureProbability;
    @SerializedName("TextProbability")
    @Expose
    private Double textProbability;
    @SerializedName("CartoonProbability")
    @Expose
    private Double cartoonProbability;
    @SerializedName("QrcodeProbability")
    @Expose
    private Double qrcodeProbability;
    @SerializedName("LetterboxTop")
    @Expose
    private List<Double> letterboxTop;
    @SerializedName("LetterboxBottom")
    @Expose
    private List<Double> letterboxBottom;
    @SerializedName("FaceRatio")
    @Expose
    private Double faceRatio;
    @SerializedName("VrVideo")
    @Expose
    private Double vrVideo;
    @SerializedName("PhotoFilmProbability")
    @Expose
    private Double photoFilmProbability;

    public Double getJunkVideoProbability() {
        return junkVideoProbability;
    }

    public void setJunkVideoProbability(Double junkVideoProbability) {
        this.junkVideoProbability = junkVideoProbability;
    }

    public Double getLetterboxProbability() {
        return letterboxProbability;
    }

    public void setLetterboxProbability(Double letterboxProbability) {
        this.letterboxProbability = letterboxProbability;
    }

    public Double getOritationProbability() {
        return oritationProbability;
    }

    public void setOritationProbability(Double oritationProbability) {
        this.oritationProbability = oritationProbability;
    }

    public Double getR0Probability() {
        return r0Probability;
    }

    public void setR0Probability(Double r0Probability) {
        this.r0Probability = r0Probability;
    }

    public Double getR90Probability() {
        return r90Probability;
    }

    public void setR90Probability(Double r90Probability) {
        this.r90Probability = r90Probability;
    }

    public Double getR270Probability() {
        return r270Probability;
    }

    public void setR270Probability(Double r270Probability) {
        this.r270Probability = r270Probability;
    }

    public Double getNormalProbability() {
        return normalProbability;
    }

    public void setNormalProbability(Double normalProbability) {
        this.normalProbability = normalProbability;
    }

    public Double getPureProbability() {
        return pureProbability;
    }

    public void setPureProbability(Double pureProbability) {
        this.pureProbability = pureProbability;
    }

    public Double getTextProbability() {
        return textProbability;
    }

    public void setTextProbability(Double textProbability) {
        this.textProbability = textProbability;
    }

    public Double getCartoonProbability() {
        return cartoonProbability;
    }

    public void setCartoonProbability(Double cartoonProbability) {
        this.cartoonProbability = cartoonProbability;
    }

    public Double getQrcodeProbability() {
        return qrcodeProbability;
    }

    public void setQrcodeProbability(Double qrcodeProbability) {
        this.qrcodeProbability = qrcodeProbability;
    }

    public List<Double> getLetterboxTop() {
        return letterboxTop;
    }

    public void setLetterboxTop(List<Double> letterboxTop) {
        this.letterboxTop = letterboxTop;
    }

    public List<Double> getLetterboxBottom() {
        return letterboxBottom;
    }

    public void setLetterboxBottom(List<Double> letterboxBottom) {
        this.letterboxBottom = letterboxBottom;
    }

    public Double getFaceRatio() {
        return faceRatio;
    }

    public void setFaceRatio(Double faceRatio) {
        this.faceRatio = faceRatio;
    }

    public Double getVrVideo() {
        return vrVideo;
    }

    public void setVrVideo(Double vrVideo) {
        this.vrVideo = vrVideo;
    }

    public Double getPhotoFilmProbability() {
        return photoFilmProbability;
    }

    public void setPhotoFilmProbability(Double photoFilmProbability) {
        this.photoFilmProbability = photoFilmProbability;
    }
}

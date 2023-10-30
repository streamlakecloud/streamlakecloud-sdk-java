package com.kuaishou.vod.openapi.model.callback;

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
}

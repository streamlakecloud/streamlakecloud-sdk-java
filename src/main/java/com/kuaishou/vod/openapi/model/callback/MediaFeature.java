package com.kuaishou.vod.openapi.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MediaFeature {
    @SerializedName("QualityFeature")
    @Expose
    private QualityFeature qualityFeature;
    @SerializedName("AestheticsFeature")
    @Expose
    private AestheticsFeature aestheticsFeature;
    @SerializedName("ContentFeature")
    @Expose
    private ContentFeature contentFeature;
    @SerializedName("AudioFeature")
    @Expose
    private AudioFeature audioFeature;
    @SerializedName("CodingFeature")
    @Expose
    private CodingFeature codingFeature;
    @SerializedName("SceneFeature")
    @Expose
    private SceneFeature sceneFeature;
    @SerializedName("Version")
    @Expose
    private String version;

    public QualityFeature getQualityFeature() {
        return qualityFeature;
    }

    public void setQualityFeature(QualityFeature qualityFeature) {
        this.qualityFeature = qualityFeature;
    }

    public AestheticsFeature getAestheticsFeature() {
        return aestheticsFeature;
    }

    public void setAestheticsFeature(AestheticsFeature aestheticsFeature) {
        this.aestheticsFeature = aestheticsFeature;
    }

    public ContentFeature getContentFeature() {
        return contentFeature;
    }

    public void setContentFeature(ContentFeature contentFeature) {
        this.contentFeature = contentFeature;
    }

    public AudioFeature getAudioFeature() {
        return audioFeature;
    }

    public void setAudioFeature(AudioFeature audioFeature) {
        this.audioFeature = audioFeature;
    }

    public CodingFeature getCodingFeature() {
        return codingFeature;
    }

    public void setCodingFeature(CodingFeature codingFeature) {
        this.codingFeature = codingFeature;
    }

    public SceneFeature getSceneFeature() {
        return sceneFeature;
    }

    public void setSceneFeature(SceneFeature sceneFeature) {
        this.sceneFeature = sceneFeature;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}

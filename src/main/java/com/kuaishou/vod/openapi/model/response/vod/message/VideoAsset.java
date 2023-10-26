package com.kuaishou.vod.openapi.model.response.vod.message;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VideoAsset {

    @SerializedName("VideoId")
    @Expose
    public String videoId;

    @SerializedName("PrimaryKey")
    @Expose
    public String primaryKey;

    @SerializedName("CoverUrlPath")
    @Expose
    public String coverUrlPath;

    @SerializedName("CreateTime")
    @Expose
    public String createTime;

    @SerializedName("SourceInfo")
    @Expose
    public MezzanineFile sourceInfo;

    @SerializedName("TranscodeInfo")
    @Expose
    public List<TranscodeInfo> transcodeInfos;

    @SerializedName("SnapshotInfo")
    @Expose
    public List<SnapshotInfo> snapshotInfos;

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getCoverUrlPath() {
        return coverUrlPath;
    }

    public void setCoverUrlPath(String coverUrlPath) {
        this.coverUrlPath = coverUrlPath;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public MezzanineFile getSourceInfo() {
        return sourceInfo;
    }

    public void setSourceInfo(MezzanineFile sourceInfo) {
        this.sourceInfo = sourceInfo;
    }

    public List<TranscodeInfo> getTranscodeInfos() {
        return transcodeInfos;
    }

    public void setTranscodeInfos(
        List<TranscodeInfo> transcodeInfos) {
        this.transcodeInfos = transcodeInfos;
    }

    public List<SnapshotInfo> getSnapshotInfos() {
        return snapshotInfos;
    }

    public void setSnapshotInfos(
        List<SnapshotInfo> snapshotInfos) {
        this.snapshotInfos = snapshotInfos;
    }
}

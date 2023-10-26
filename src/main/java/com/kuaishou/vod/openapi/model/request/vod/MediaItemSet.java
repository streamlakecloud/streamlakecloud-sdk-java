package com.kuaishou.vod.openapi.model.request.vod;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MediaItemSet {

    @SerializedName("Bucket")
    @Expose
    public String bucket;
    @SerializedName("StoreKey")
    @Expose
    public String storeKey;
    @SerializedName("ProcessTypes")
    @Expose
    public List<String> processTypes;
    @SerializedName("MediaType")
    @Expose
    public String mediaType;

    @SerializedName("CodecName")
    @Expose
    public String codecName;
    @SerializedName("Resolution")
    @Expose
    public String resolution;
    @SerializedName("Format")
    @Expose
    public String format;

    @SerializedName("ClientInfo")
    @Expose
    private ClientInfo clientInfo;
    @SerializedName("KeyInfo")
    @Expose
    private KeyInfo keyInfo;

    @SerializedName("PrimaryKey")
    @Expose
    private String primaryKey;
    @SerializedName("SourceURL")
    @Expose
    private String sourceURL;
    @SerializedName("MediaId")
    @Expose
    private String mediaId;
    @SerializedName("Text")
    @Expose
    private String text;

    public String getCodecName() {
        return codecName;
    }

    public void setCodecName(String codecName) {
        this.codecName = codecName;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getStoreKey() {
        return storeKey;
    }

    public void setStoreKey(String storeKey) {
        this.storeKey = storeKey;
    }

    public List<String> getProcessTypes() {
        return processTypes;
    }

    public void setProcessTypes(List<String> processTypes) {
        this.processTypes = processTypes;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

    public KeyInfo getKeyInfo() {
        return keyInfo;
    }

    public void setKeyInfo(KeyInfo keyInfo) {
        this.keyInfo = keyInfo;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getSourceURL() {
        return sourceURL;
    }

    public void setSourceURL(String sourceURL) {
        this.sourceURL = sourceURL;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

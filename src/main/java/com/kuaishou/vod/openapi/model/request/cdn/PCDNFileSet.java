package com.kuaishou.vod.openapi.model.request.cdn;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PCDNFileSet {

    @SerializedName("URLPath")
    @Expose
    public String urlPath;
    @SerializedName("FileSize")
    @Expose
    public Long fileSize;
    @SerializedName("Crc32")
    @Expose
    public String crc32;
    @SerializedName("BlockCrc32")
    @Expose
    public List<String> blockCrc32;
    @SerializedName("Qps")
    @Expose
    public Long qps;

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getCrc32() {
        return crc32;
    }

    public void setCrc32(String crc32) {
        this.crc32 = crc32;
    }

    public List<String> getBlockCrc32() {
        return blockCrc32;
    }

    public void setBlockCrc32(List<String> blockCrc32) {
        this.blockCrc32 = blockCrc32;
    }

    public Long getQps() {
        return qps;
    }

    public void setQps(Long qps) {
        this.qps = qps;
    }
}

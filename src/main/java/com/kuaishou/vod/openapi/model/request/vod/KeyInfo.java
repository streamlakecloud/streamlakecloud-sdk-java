package com.kuaishou.vod.openapi.model.request.vod;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KeyInfo {

    @SerializedName("EncryptionKey")
    @Expose
    private String encryptionKey;

    public String getEncryptionKey() {
        return encryptionKey;
    }

    public void setEncryptionKey(String encryptionKey) {
        this.encryptionKey = encryptionKey;
    }
}

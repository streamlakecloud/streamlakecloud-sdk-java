package com.kuaishou.vod.openapi.model.request.vod;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class URLSet {
    @SerializedName("SourceURL")
    @Expose
    public String sourceUrl;

    @SerializedName("StoreBucket")
    @Expose
    public String storeBucket;

    @SerializedName("StoreKey")
    @Expose
    public String storeKey;

    @SerializedName("Overwrite")
    @Expose
    public String overwrite;

    @SerializedName("CallbackURL")
    @Expose
    public String callbackUrl;

    @SerializedName("CallbackArgs")
    @Expose
    public String callbackArgs;

    @SerializedName("WorkflowId")
    @Expose
    public String workflowId;

    @SerializedName("PrimaryKey")
    @Expose
    public String primaryKey;

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getStoreBucket() {
        return storeBucket;
    }

    public void setStoreBucket(String storeBucket) {
        this.storeBucket = storeBucket;
    }

    public String getStoreKey() {
        return storeKey;
    }

    public void setStoreKey(String storeKey) {
        this.storeKey = storeKey;
    }

    public String getOverwrite() {
        return overwrite;
    }

    public void setOverwrite(String overwrite) {
        this.overwrite = overwrite;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getCallbackArgs() {
        return callbackArgs;
    }

    public void setCallbackArgs(String callbackArgs) {
        this.callbackArgs = callbackArgs;
    }

    public String getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(String workflowId) {
        this.workflowId = workflowId;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }
}

package com.kuaishou.vod.openapi.model.request.vod;

import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractRequest;

public class ProcessingFlowRequest extends AbstractRequest {
    @SerializedName("MediaId")
    @Expose
    public String mediaId;
    @SerializedName("PrimaryKey")
    @Expose
    public String primaryKey;
    @SerializedName("WorkflowId")
    @Expose
    public String workflowId;
    @SerializedName("OverrideParams")
    @Expose
    public String overrideParams;
    @SerializedName("CallbackArgs")
    @Expose
    public String callbackArgs;
    @SerializedName("SpaceName")
    @Expose
    public String spaceName;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(String workflowId) {
        this.workflowId = workflowId;
    }

    public String getOverrideParams() {
        return overrideParams;
    }

    public void setOverrideParams(String overrideParams) {
        this.overrideParams = overrideParams;
    }

    public String getCallbackArgs() {
        return callbackArgs;
    }

    public void setCallbackArgs(String callbackArgs) {
        this.callbackArgs = callbackArgs;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    @Override
    public HashMap<String, String> toMap() {
        HashMap<String, String> map = new HashMap<>();
        map.computeIfAbsent("MediaId", key -> this.mediaId);
        map.computeIfAbsent("PrimaryKey", key -> this.primaryKey);
        map.computeIfAbsent("WorkflowId", key -> this.workflowId);
        map.computeIfAbsent("OverrideParams", key -> this.overrideParams);
        map.computeIfAbsent("CallbackArgs", key -> this.callbackArgs);
        map.computeIfAbsent("SpaceName", key -> this.spaceName);
        return map;
    }
}

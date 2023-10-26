package com.kuaishou.vod.openapi.model.response.ai;

import com.google.gson.JsonElement;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractResponse;
import com.kuaishou.vod.openapi.model.response.cdn.PreloadResponse;
import com.kuaishou.vod.openapi.model.response.cdn.PreloadResponse.ResponseData;

public class ComposeVideoResponse extends AbstractResponse {
    @SerializedName("ResponseData")
    @Expose
    JsonElement responseData;

    public ComposeVideoResponse(Class aClass) {
        super(aClass);
    }

    public JsonElement getResponseData() {
        return responseData;
    }

    public void setResponseData(JsonElement responseData) {
        this.responseData = responseData;
    }
}

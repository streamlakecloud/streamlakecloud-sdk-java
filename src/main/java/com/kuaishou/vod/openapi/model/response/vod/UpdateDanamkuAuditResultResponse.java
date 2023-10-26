package com.kuaishou.vod.openapi.model.response.vod;

import com.google.gson.JsonElement;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractResponse;

public class UpdateDanamkuAuditResultResponse extends AbstractResponse {
    public UpdateDanamkuAuditResultResponse(Class aClass) {
        super(aClass);
    }

    @SerializedName("ResponseData")
    @Expose
    JsonElement responseData;

    public JsonElement getResponseData() {
        return responseData;
    }

    public void setResponseData(JsonElement responseData) {
        this.responseData = responseData;
    }
}

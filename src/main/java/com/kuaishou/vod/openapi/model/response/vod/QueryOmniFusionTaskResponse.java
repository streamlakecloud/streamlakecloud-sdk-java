package com.kuaishou.vod.openapi.model.response.vod;

import com.google.gson.JsonElement;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractResponse;

/**
 * QueryOmniFusionTask 响应类
 * 
 * @author wanghaobo
 */
public class QueryOmniFusionTaskResponse extends AbstractResponse {

    @SerializedName("ResponseData")
    @Expose
    private JsonElement responseData;

    public QueryOmniFusionTaskResponse(Class aClass) {
        super(aClass);
    }

    public JsonElement getResponseData() {
        return responseData;
    }

    public void setResponseData(JsonElement responseData) {
        this.responseData = responseData;
    }
}


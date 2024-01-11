package com.kuaishou.vod.openapi.model.response.vod;

import com.google.gson.JsonElement;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractResponse;

/**
 * @author fubaiqiang <fubaiqiang@kuaishou.com>
 * Created on 2023-12-08
 */
public class DescribeMediaProcessJobResponse extends AbstractResponse {

    @SerializedName("ResponseData")
    @Expose
    JsonElement responseData;

    public DescribeMediaProcessJobResponse(Class aClass) {
        super(aClass);
    }

    public JsonElement getResponseData() {
        return responseData;
    }

    public void setResponseData(JsonElement responseData) {
        this.responseData = responseData;
    }
}

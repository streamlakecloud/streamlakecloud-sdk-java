package com.kuaishou.vod.openapi.model.response.ai;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractResponse;

public class BlendFaceResponse extends AbstractResponse {
    @SerializedName("ResponseData")
    @Expose
    public ResponseData responseData;

    public ResponseData getResponseData() {
        return responseData;
    }

    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }

    public BlendFaceResponse(Class aClass) {
        super(aClass);
    }

    public static class ResponseData {
        @SerializedName("Data")
        @Expose
        private String data;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
}

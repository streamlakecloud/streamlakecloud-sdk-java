package com.kuaishou.vod.openapi.model.response.cdn;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractResponse;

/**
 *
 * Created on 2021-12-13
 */
public class PreloadResponse extends AbstractResponse {
    @SerializedName("ResponseData")
    @Expose
    public ResponseData responseData;

    public ResponseData getResponseData() {
        return responseData;
    }

    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }

    public PreloadResponse(Class aClass) {
        super(aClass);
    }

    public static class ResponseData {
        @SerializedName("PreloadTaskId")
        @Expose
        String preloadTaskId;

        public String getPreloadTaskId() {
            return preloadTaskId;
        }

        public void setPreloadTaskId(String preloadTaskId) {
            this.preloadTaskId = preloadTaskId;
        }
    }
}

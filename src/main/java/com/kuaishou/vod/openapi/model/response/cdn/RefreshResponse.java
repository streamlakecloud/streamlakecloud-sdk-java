package com.kuaishou.vod.openapi.model.response.cdn;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractResponse;
import com.kuaishou.vod.openapi.model.response.cdn.PreloadResponse.ResponseData;

/**
 *
 * Created on 2021-12-13
 */
public class RefreshResponse extends AbstractResponse {
    @SerializedName("ResponseData")
    @Expose
    public ResponseData responseData;

    public ResponseData getResponseData() {
        return responseData;
    }

    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }

    public RefreshResponse(Class aClass) {
        super(aClass);
    }

    public static class ResponseData {
        @SerializedName("RefreshTaskId")
        @Expose
        String refreshTaskId;

        public String getRefreshTaskId() {
            return refreshTaskId;
        }

        public void setRefreshTaskId(String refreshTaskId) {
            this.refreshTaskId = refreshTaskId;
        }
    }
}

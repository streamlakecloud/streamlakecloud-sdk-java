package com.kuaishou.vod.openapi.model.response.vod;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractResponse;

/**
 * FetchUpload 响应类
 * 
 * @author wanghaobo
 */
public class FetchUploadResponse extends AbstractResponse {

    @SerializedName("ResponseData")
    @Expose
    private ResponseData responseData;

    public FetchUploadResponse(Class aClass) {
        super(aClass);
    }

    public ResponseData getResponseData() {
        return responseData;
    }

    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }

    /**
     * 响应数据
     */
    public static class ResponseData {
        /**
         * 媒体ID列表
         */
        @SerializedName("MediaIds")
        @Expose
        private List<String> mediaIds;

        public List<String> getMediaIds() {
            return mediaIds;
        }

        public void setMediaIds(List<String> mediaIds) {
            this.mediaIds = mediaIds;
        }
    }
}

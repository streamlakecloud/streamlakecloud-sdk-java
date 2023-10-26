package com.kuaishou.vod.openapi.model.response.iam;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractResponse;

public class AssumeRoleResponse extends AbstractResponse {

    @SerializedName("ResponseData")
    @Expose
    ResponseData responseData;

    public AssumeRoleResponse(Class aClass) {
        super(aClass);
    }

    public ResponseData getResponseData() {
        return responseData;
    }

    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }

    public static class ResponseData {

        @SerializedName("AccessKeyId")
        @Expose
        public String accessKeyId;

        @SerializedName("AccessKeySecret")
        @Expose
        public String accessKeySecret;

        @SerializedName("SessionToken")
        @Expose
        public String sessionToken;

        @SerializedName("Expiration")
        @Expose
        public Long expiration;

        public String getAccessKeyId() {
            return accessKeyId;
        }

        public void setAccessKeyId(String accessKeyId) {
            this.accessKeyId = accessKeyId;
        }

        public String getAccessKeySecret() {
            return accessKeySecret;
        }

        public void setAccessKeySecret(String accessKeySecret) {
            this.accessKeySecret = accessKeySecret;
        }

        public String getSessionToken() {
            return sessionToken;
        }

        public void setSessionToken(String sessionToken) {
            this.sessionToken = sessionToken;
        }

        public Long getExpiration() {
            return expiration;
        }

        public void setExpiration(Long expiration) {
            this.expiration = expiration;
        }
    }
}

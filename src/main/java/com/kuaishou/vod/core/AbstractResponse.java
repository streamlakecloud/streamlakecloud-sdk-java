package com.kuaishou.vod.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.openapi.model.response.cdn.ListUserDomainsResponse;
import com.kuaishou.vod.openapi.model.response.cdn.PreloadResponse;
import com.kuaishou.vod.openapi.model.response.cdn.PushPCDNObjectCacheResponse;
import com.kuaishou.vod.openapi.model.response.cdn.QueryStatusResponse;
import com.kuaishou.vod.openapi.model.response.cdn.RefreshResponse;
import com.kuaishou.vod.openapi.model.response.iam.AssumeRoleResponse;
import com.kuaishou.vod.openapi.model.response.vod.ApplyUploadInfoResponse;
import com.kuaishou.vod.openapi.model.response.vod.CommitUploadResponse;
import com.kuaishou.vod.openapi.model.response.vod.DeleteMediaResponse;
import com.kuaishou.vod.openapi.model.response.vod.DescribeFetchJobsResponse;
import com.kuaishou.vod.openapi.model.response.vod.DescribeMediaInfoResponse;
import com.kuaishou.vod.openapi.model.response.vod.DescribeMediaProcessJobResponse;
import com.kuaishou.vod.openapi.model.response.vod.DetectMediaResponse;
import com.kuaishou.vod.openapi.model.response.vod.EnhanceMediaResponse;
import com.kuaishou.vod.openapi.model.response.vod.FetchStoreResponse;
import com.kuaishou.vod.openapi.model.response.vod.FetchUploadResponse;
import com.kuaishou.vod.openapi.model.response.vod.ListDanmakuPreAuditResponse;
import com.kuaishou.vod.openapi.model.response.vod.ListMediaProcessJobResponse;
import com.kuaishou.vod.openapi.model.response.vod.ProcessMediaResponse;
import com.kuaishou.vod.openapi.model.response.vod.ProcessingFlowResponse;
import com.kuaishou.vod.openapi.model.response.vod.SubmitMediaProcessJobsResponse;
import com.kuaishou.vod.openapi.model.response.vod.SubmitOmniFusionTaskResponse;
import com.kuaishou.vod.openapi.model.response.vod.UpdateDanamkuAuditResultResponse;

public abstract class AbstractResponse<T extends AbstractResponse> {


    private static final Gson GSON = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    @SerializedName("ResponseMeta")
    @Expose
    public ResponseMeta responseMeta;

    public ResponseMeta getResponseMeta() {
        return responseMeta;
    }

    public void setResponseMeta(ResponseMeta responseMeta) {
        this.responseMeta = responseMeta;
    }

    protected Class<T> type;

    protected AbstractResponse(Class<T> tClass) {
        this.type = tClass;
    }

    public static ApplyUploadInfoResponse applyUploadInfoResponse() {
        return new ApplyUploadInfoResponse(ApplyUploadInfoResponse.class);
    }

    public static CommitUploadResponse commitUploadResponse() {
        return new CommitUploadResponse(CommitUploadResponse.class);
    }

    public static DetectMediaResponse detectMediaResponse() {
        return new DetectMediaResponse(DetectMediaResponse.class);
    }

    public static EnhanceMediaResponse enhanceMediaResponse() {
        return new EnhanceMediaResponse(EnhanceMediaResponse.class);
    }

    public static DescribeFetchJobsResponse describeFetchJobsResponse() {
        return new DescribeFetchJobsResponse(DescribeFetchJobsResponse.class);
    }

    public static FetchStoreResponse fetchStoreResponse() {
        return new FetchStoreResponse(FetchStoreResponse.class);
    }

    public static FetchUploadResponse fetchUploadResponse() {
        return new FetchUploadResponse(FetchUploadResponse.class);
    }

    public static ProcessingFlowResponse processingFlowResponse() {
        return new ProcessingFlowResponse(ProcessingFlowResponse.class);
    }

    public static PreloadResponse preloadResponse() {
        return new PreloadResponse(PreloadResponse.class);
    }

    public static RefreshResponse refreshResponse() {
        return new RefreshResponse(RefreshResponse.class);
    }

    public static QueryStatusResponse queryStatusResponse() {
        return new QueryStatusResponse(QueryStatusResponse.class);
    }

    public static ListUserDomainsResponse listUserDomainsResponse() {
        return new ListUserDomainsResponse(ListUserDomainsResponse.class);
    }

    public static PushPCDNObjectCacheResponse pushPCDNObjectCacheResponse() {
        return new PushPCDNObjectCacheResponse(PushPCDNObjectCacheResponse.class);
    }

    public static AssumeRoleResponse assumeRoleResponse() {
        return new AssumeRoleResponse(AssumeRoleResponse.class);
    }

    public static DescribeMediaInfoResponse describeMediaInfoResponse() {
        return new DescribeMediaInfoResponse(DescribeMediaInfoResponse.class);
    }

    public static ProcessMediaResponse processMediaResponse() {
        return new ProcessMediaResponse(ProcessMediaResponse.class);
    }

    public static DeleteMediaResponse deleteMediaResponse() {
        return new DeleteMediaResponse(DeleteMediaResponse.class);
    }

    public static SubmitMediaProcessJobsResponse submitMediaProcessJobsResponse() {
        return new SubmitMediaProcessJobsResponse(SubmitMediaProcessJobsResponse.class);
    }

    public static ListDanmakuPreAuditResponse listDanmakuPreAuditResponse() {
        return new ListDanmakuPreAuditResponse(ListDanmakuPreAuditResponse.class);
    }

    public static UpdateDanamkuAuditResultResponse updateDanamkuAuditResultResponse() {
        return new UpdateDanamkuAuditResultResponse(UpdateDanamkuAuditResultResponse.class);
    }

    public static DescribeMediaProcessJobResponse describeMediaProcessJobResponse() {
        return new DescribeMediaProcessJobResponse(DescribeMediaProcessJobResponse.class);
    }

    public static ListMediaProcessJobResponse listMediaProcessJobResponse() {
        return new ListMediaProcessJobResponse(ListMediaProcessJobResponse.class);
    }

    public static SubmitOmniFusionTaskResponse submitOmniFusionTaskResponse() {
        return new SubmitOmniFusionTaskResponse(SubmitOmniFusionTaskResponse.class);
    }

    public T fromJson(String json) {
        return GSON.fromJson(json, this.type);
    }

    public static <D> D fromJson(String json, Class<D> type) {
        return GSON.fromJson(json, type);
    }

    public String toJson() {
        return GSON.toJson(this);
    }


    public static class ResponseMeta {
        @SerializedName("RequestId")
        @Expose
        public String requestId;
        @SerializedName("ErrorCode")
        @Expose
        public String errorCode;
        @SerializedName("ErrorMessage")
        @Expose
        public String errorMessage;

        public String getRequestId() {
            return requestId;
        }

        public void setRequestId(String requestId) {
            this.requestId = requestId;
        }

        public String getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }
    }
}

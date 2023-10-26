package com.kuaishou.vod.openapi.client;

import static com.kuaishou.vod.core.AbstractResponse.applyUploadInfoResponse;
import static com.kuaishou.vod.core.AbstractResponse.commitUploadResponse;
import static com.kuaishou.vod.core.AbstractResponse.deleteMediaResponse;
import static com.kuaishou.vod.core.AbstractResponse.describeFetchJobsResponse;
import static com.kuaishou.vod.core.AbstractResponse.describeMediaInfoResponse;
import static com.kuaishou.vod.core.AbstractResponse.detectMediaResponse;
import static com.kuaishou.vod.core.AbstractResponse.enhanceMediaResponse;
import static com.kuaishou.vod.core.AbstractResponse.fetchStoreResponse;
import static com.kuaishou.vod.core.AbstractResponse.fetchUploadResponse;
import static com.kuaishou.vod.core.AbstractResponse.listDanmakuPreAuditResponse;
import static com.kuaishou.vod.core.AbstractResponse.processMediaResponse;
import static com.kuaishou.vod.core.AbstractResponse.processingFlowResponse;
import static com.kuaishou.vod.core.AbstractResponse.submitMediaProcessJobsResponse;
import static com.kuaishou.vod.core.AbstractResponse.updateDanamkuAuditResultResponse;

import java.io.IOException;
import java.util.Map;

import com.kuaishou.vod.core.AbstractClient;
import com.kuaishou.vod.core.Credential;
import com.kuaishou.vod.core.HttpProfile;
import com.kuaishou.vod.core.exception.KuaishouVodSdkException;
import com.kuaishou.vod.openapi.model.request.vod.ApplyUploadInfoRequest;
import com.kuaishou.vod.openapi.model.request.vod.CommitUploadRequest;
import com.kuaishou.vod.openapi.model.request.vod.DeleteMediaRequest;
import com.kuaishou.vod.openapi.model.request.vod.DescribeFetchJobsRequest;
import com.kuaishou.vod.openapi.model.request.vod.DescribeMediaInfoRequest;
import com.kuaishou.vod.openapi.model.request.vod.DetectMediaRequest;
import com.kuaishou.vod.openapi.model.request.vod.EnhanceMediaRequest;
import com.kuaishou.vod.openapi.model.request.vod.FetchStoreRequest;
import com.kuaishou.vod.openapi.model.request.vod.FetchUploadRequest;
import com.kuaishou.vod.openapi.model.request.vod.ListDanmakuPreAuditRequest;
import com.kuaishou.vod.openapi.model.request.vod.ProcessMediaRequest;
import com.kuaishou.vod.openapi.model.request.vod.ProcessingFlowRequest;
import com.kuaishou.vod.openapi.model.request.vod.SubmitMediaProcessJobsRequest;
import com.kuaishou.vod.openapi.model.request.vod.UpdateDanamkuAuditResultRequest;
import com.kuaishou.vod.openapi.model.response.vod.ApplyUploadInfoResponse;
import com.kuaishou.vod.openapi.model.response.vod.CommitUploadResponse;
import com.kuaishou.vod.openapi.model.response.vod.DeleteMediaResponse;
import com.kuaishou.vod.openapi.model.response.vod.DescribeFetchJobsResponse;
import com.kuaishou.vod.openapi.model.response.vod.DescribeMediaInfoResponse;
import com.kuaishou.vod.openapi.model.response.vod.DetectMediaResponse;
import com.kuaishou.vod.openapi.model.response.vod.EnhanceMediaResponse;
import com.kuaishou.vod.openapi.model.response.vod.FetchStoreResponse;
import com.kuaishou.vod.openapi.model.response.vod.FetchUploadResponse;
import com.kuaishou.vod.openapi.model.response.vod.ListDanmakuPreAuditResponse;
import com.kuaishou.vod.openapi.model.response.vod.ProcessMediaResponse;
import com.kuaishou.vod.openapi.model.response.vod.ProcessingFlowResponse;
import com.kuaishou.vod.openapi.model.response.vod.SubmitMediaProcessJobsResponse;
import com.kuaishou.vod.openapi.model.response.vod.UpdateDanamkuAuditResultResponse;

public class VodClient extends AbstractClient {

    public VodClient(HttpProfile httpProfile, Credential credential) {
        super(httpProfile, credential);
    }

    public ApplyUploadInfoResponse applyUploadInfo(ApplyUploadInfoRequest request, Map<String, String> headerInfo)
            throws KuaishouVodSdkException, IOException {
        String resp = this.callByJsonV2(request, "ApplyUploadInfo", "POST", headerInfo);
        return (ApplyUploadInfoResponse) applyUploadInfoResponse().fromJson(resp);
    }

    public CommitUploadResponse commitUpload(CommitUploadRequest request, Map<String, String> headerInfo)
            throws KuaishouVodSdkException, IOException {
        String resp = this.callByJsonV2(request, "CommitUpload", "POST", headerInfo);
        return (CommitUploadResponse) commitUploadResponse().fromJson(resp);
    }

    public DetectMediaResponse detectMedia(DetectMediaRequest request)
            throws KuaishouVodSdkException, IOException {
        String resp = this.callByJson(request, "DetectMedia", "POST");
        return (DetectMediaResponse) detectMediaResponse().fromJson(resp);
    }

    public DetectMediaResponse detectMediaWorkflow(DetectMediaRequest request)
            throws KuaishouVodSdkException, IOException {
        String resp = this.callByJson(request, "DetectMediaWorkflow", "POST");
        return (DetectMediaResponse) detectMediaResponse().fromJson(resp);
    }

    public EnhanceMediaResponse enhanceMedia(EnhanceMediaRequest request)
            throws KuaishouVodSdkException, IOException {
        String resp = this.callByJson(request, "EnhanceMedia", "POST");
        return (EnhanceMediaResponse) enhanceMediaResponse().fromJson(resp);
    }

    public ProcessingFlowResponse submitProcessingFlow(ProcessingFlowRequest request)
        throws KuaishouVodSdkException, IOException {
        String resp = this.call(request, "SubmitWorkflow", "POST");
        return (ProcessingFlowResponse) processingFlowResponse().fromJson(resp);
    }

    public FetchUploadResponse fetchUpload(FetchUploadRequest request) throws KuaishouVodSdkException, IOException {
        String resp = this.call(request, "FetchUpload", "POST");
        return (FetchUploadResponse) fetchUploadResponse().fromJson(resp);
    }

    public FetchStoreResponse fetchStore(FetchStoreRequest request) throws KuaishouVodSdkException, IOException {
        String resp = this.call(request, "FetchStore", "POST");
        return (FetchStoreResponse) fetchStoreResponse().fromJson(resp);
    }

    public DescribeFetchJobsResponse describeFetchJobs(DescribeFetchJobsRequest request) throws KuaishouVodSdkException, IOException {
        String resp = this.call(request, "DescribeFetchJobs", "POST");
        return (DescribeFetchJobsResponse) describeFetchJobsResponse().fromJson(resp);
    }

    public DescribeMediaInfoResponse describeMediaInfo(DescribeMediaInfoRequest request)throws KuaishouVodSdkException, IOException {
        String resp = this.call(request, "DescribeMediaInfo", "POST");
        return (DescribeMediaInfoResponse) describeMediaInfoResponse().fromJson(resp);
    }

    public ProcessMediaResponse processMedia(ProcessMediaRequest request)throws KuaishouVodSdkException, IOException {
        String resp = this.call(request, "ProcessMedia", "POST");
        return (ProcessMediaResponse) processMediaResponse().fromJson(resp);
    }

    public DeleteMediaResponse deleteMedia(DeleteMediaRequest request)throws KuaishouVodSdkException, IOException {
        String resp = this.callByJson(request, "DeleteMedia", "POST");
        return (DeleteMediaResponse) deleteMediaResponse().fromJson(resp);
    }

    public SubmitMediaProcessJobsResponse submitMediaProcessJobs(SubmitMediaProcessJobsRequest request)throws KuaishouVodSdkException, IOException {
        String resp = this.call(request, "SubmitMediaProcessJobs", "POST");
        return (SubmitMediaProcessJobsResponse) submitMediaProcessJobsResponse().fromJson(resp);
    }

    public ListDanmakuPreAuditResponse listDanmakuPreAudit(ListDanmakuPreAuditRequest request) throws KuaishouVodSdkException, IOException {
        String resp = this.callByJson(request, "ListDanmakuPreAudit", "POST");
        return (ListDanmakuPreAuditResponse) listDanmakuPreAuditResponse().fromJson(resp);
    }

    public UpdateDanamkuAuditResultResponse updateDanamkuAuditResult(UpdateDanamkuAuditResultRequest request) throws KuaishouVodSdkException, IOException {
        String resp = this.callByJson(request, "UpdateDanamkuAuditResult", "POST");
        return (UpdateDanamkuAuditResultResponse) updateDanamkuAuditResultResponse().fromJson(resp);
    }
}

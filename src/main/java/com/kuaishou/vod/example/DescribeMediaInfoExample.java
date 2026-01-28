package com.kuaishou.vod.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.kuaishou.vod.core.Credential;
import com.kuaishou.vod.core.HttpProfile;
import com.kuaishou.vod.core.exception.KuaishouVodSdkException;
import com.kuaishou.vod.openapi.client.VodClient;
import com.kuaishou.vod.openapi.model.request.vod.DescribeMediaInfoRequest;
import com.kuaishou.vod.openapi.model.request.vod.FetchUploadRequest;
import com.kuaishou.vod.openapi.model.request.vod.URLSet;
import com.kuaishou.vod.openapi.model.response.vod.DescribeMediaInfoResponse;
import com.kuaishou.vod.openapi.model.response.vod.FetchUploadResponse;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * DescribeMediaInfo 使用示例
 * <p>
 * 演示如何通过 FetchUpload 上传媒体后，使用 DescribeMediaInfo 查询媒体详情
 * </p>
 * 
 * @author wanghaobo
 */
public class DescribeMediaInfoExample {

    public static void main(String[] args) {
        // 选择要运行的示例
        // fetchUploadAndDescribe();  // 先上传再查询
        describeMediaInfoOnly();      // 直接查询已有的 MediaId
    }

    /**
     * 示例1：先通过 FetchUpload 上传媒体，再查询媒体信息
     */
    public static void fetchUploadAndDescribe() {
        VodClient vodClient = createVodClient();
        if (vodClient == null) return;
        
        // Step 1: 调用 FetchUpload 上传媒体
        System.out.println("========================================");
        System.out.println("Step 1: 调用 FetchUpload 上传媒体...");
        System.out.println("========================================");
        
        FetchUploadRequest fetchRequest = new FetchUploadRequest();
        List<URLSet> urlSetList = new ArrayList<>();
        URLSet urlSet = new URLSet();
        urlSet.setSourceUrl("https://example.com/video.mp4");
        urlSet.setCallbackArgs("custom-callback-args");
        urlSetList.add(urlSet);
        fetchRequest.setUrlSets(urlSetList);
        
        try {
            FetchUploadResponse fetchResponse = vodClient.fetchUpload(fetchRequest);
            
            System.out.println("FetchUpload 调用成功！");
            System.out.println("完整响应: " + fetchResponse.toJson());
            
            // 获取 MediaIds
            if (fetchResponse.getResponseData() != null && 
                fetchResponse.getResponseData().getMediaIds() != null &&
                !fetchResponse.getResponseData().getMediaIds().isEmpty()) {
                
                List<String> mediaIds = fetchResponse.getResponseData().getMediaIds();
                System.out.println("获取到 MediaIds: " + mediaIds);
                
                // Step 2: 使用 MediaId 查询媒体信息
                System.out.println("========================================");
                System.out.println("Step 2: 查询媒体信息...");
                System.out.println("========================================");
                
                for (String mediaId : mediaIds) {
                    describeMediaInfo(vodClient, mediaId);
                }
            }
            
        } catch (KuaishouVodSdkException | IOException e) {
            System.err.println("异常: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 示例2：直接查询已有的 MediaId
     */
    public static void describeMediaInfoOnly() {
        VodClient vodClient = createVodClient();
        if (vodClient == null) return;
        
        // 直接使用已知的 MediaId 查询
        String mediaId = "bc318f3381968be2111";
        
        System.out.println("========================================");
        System.out.println("查询 MediaId: " + mediaId);
        System.out.println("========================================");
        
        describeMediaInfo(vodClient, mediaId);
    }

    /**
     * 查询媒体信息
     */
    private static void describeMediaInfo(VodClient vodClient, String mediaId) {
        DescribeMediaInfoRequest request = new DescribeMediaInfoRequest();
        request.setMediaId(mediaId);
        // 可选：设置过滤器，指定返回哪些信息
        // request.setFilters("basicInfo,sourceInfo,transCodeInfo");
        
        try {
            System.out.println("开始调用 DescribeMediaInfo API...");
            DescribeMediaInfoResponse response = vodClient.describeMediaInfo(request);
            
            System.out.println("API 调用成功！");
            System.out.println("========================================");
            
            // 打印完整的 JSON 响应
            System.out.println("完整响应 JSON:");
            System.out.println(response.toJson());
            System.out.println("========================================");
            
            // 打印响应元数据
            if (response.getResponseMeta() != null) {
                System.out.println("响应元数据:");
                System.out.println("  RequestId: " + response.getResponseMeta().getRequestId());
                System.out.println("  ErrorCode: " + response.getResponseMeta().getErrorCode());
                System.out.println("  ErrorMessage: " + response.getResponseMeta().getErrorMessage());
                System.out.println("========================================");
            }
            
            // 打印响应数据
            if (response.getResponseData() != null) {
                System.out.println("响应数据:");
                System.out.println(response.getResponseData());
                System.out.println("========================================");
            }
            
        } catch (KuaishouVodSdkException e) {
            System.err.println("SDK 异常: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("IO 异常: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 创建 VodClient
     */
    private static VodClient createVodClient() {
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()
                .load();
        
        String accessKeyId = dotenv.get("ACCESS_KEY_ID");
        String secretKey = dotenv.get("SECRET_KEY");
        
        if (accessKeyId == null || accessKeyId.isEmpty()) {
            System.err.println("错误: ACCESS_KEY_ID 未配置，请在 .env 文件中设置");
            return null;
        }
        if (secretKey == null || secretKey.isEmpty()) {
            System.err.println("错误: SECRET_KEY 未配置，请在 .env 文件中设置");
            return null;
        }
        
        Credential credential = new Credential(accessKeyId, secretKey);
        HttpProfile httpProfile = HttpProfile.getDefault();
        return new VodClient(httpProfile, credential);
    }
}


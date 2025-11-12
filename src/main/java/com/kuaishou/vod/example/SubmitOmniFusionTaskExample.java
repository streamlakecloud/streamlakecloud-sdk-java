package com.kuaishou.vod.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.kuaishou.vod.core.Credential;
import com.kuaishou.vod.core.HttpProfile;
import com.kuaishou.vod.core.exception.KuaishouVodSdkException;
import com.kuaishou.vod.openapi.client.VodClient;
import com.kuaishou.vod.openapi.model.request.vod.SubmitOmniFusionTaskRequest;
import com.kuaishou.vod.openapi.model.request.vod.SubmitOmniFusionTaskRequest.MediaSource;
import com.kuaishou.vod.openapi.model.request.vod.SubmitOmniFusionTaskRequest.OutputConfig;
import com.kuaishou.vod.openapi.model.request.vod.SubmitOmniFusionTaskRequest.VideoGenerationRequest;
import com.kuaishou.vod.openapi.model.response.vod.SubmitOmniFusionTaskResponse;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * SubmitOmniFusionTask 使用示例
 * 
 * @author wanghaobo
 */
public class SubmitOmniFusionTaskExample {

    public static void main(String[] args) {
        // 1. 从 .env 文件加载配置
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing() // 如果 .env 文件不存在则忽略
                .load();
        
        // 2. 读取认证信息
        String accessKeyId = dotenv.get("ACCESS_KEY_ID");
        String secretKey = dotenv.get("SECRET_KEY");
        
        // 校验必需的配置
        if (accessKeyId == null || accessKeyId.isEmpty()) {
            System.err.println("错误: ACCESS_KEY_ID 未配置，请在 .env 文件中设置");
            return;
        }
        if (secretKey == null || secretKey.isEmpty()) {
            System.err.println("错误: SECRET_KEY 未配置，请在 .env 文件中设置");
            return;
        }
        
        Credential credential = new Credential(accessKeyId, secretKey);
        
        // 3. 配置 HTTP 配置（可选，使用默认配置）
        HttpProfile httpProfile = HttpProfile.getDefault();
        
        // 4. 创建 VodClient
        VodClient vodClient = new VodClient(httpProfile, credential);
        
        // 5. 创建 SubmitOmniFusionTaskRequest 并设置参数
        SubmitOmniFusionTaskRequest request = new SubmitOmniFusionTaskRequest();
        
        // 设置业务 key
        request.setBizKey("CYBERCUT_TEST_TOB");
        
        // 设置回调 URL
        request.setCallbackUrl("https://cybercut-api.streamlake.com/api/v1/utils/task-callback");
        
        // 设置回调参数
        request.setCallbackArgs("{\"user_id\":\"123\",\"order_id\":\"456\"}");
        
        // 设置模板 ID
        request.setTemplateId("template1");
        
        // 创建媒体源列表
        List<MediaSource> mediaSourceList = new ArrayList<>();
        
        MediaSource media1 = new MediaSource();
        media1.setMediaType("video");
        media1.setMediaId("4b146980a457bac2");
        mediaSourceList.add(media1);
        
        MediaSource media2 = new MediaSource();
        media2.setMediaType("video");
        media2.setMediaId("f794d2afffd252d7");
        mediaSourceList.add(media2);
        
        MediaSource media3 = new MediaSource();
        media3.setMediaType("video");
        media3.setMediaId("0a730c47726accb0");
        mediaSourceList.add(media3);
        
        request.setMediaSource(mediaSourceList);
        
        // 设置输出配置
        OutputConfig outputConfig = new OutputConfig();
        outputConfig.setExtraParams("{\"resolution\":\"1080p\"}");
        outputConfig.setFilenamePrefix("my_video_");
        outputConfig.setOutputFormat("mp4");
        outputConfig.setQuality("high");
        request.setOutputConfig(outputConfig);
        
        // 设置视频生成请求
        VideoGenerationRequest videoGenRequest = new VideoGenerationRequest();
        videoGenRequest.setCustomConstraint("推荐大家下单付款放在最后！结尾有清晰指令，引导点赞、评论、购买或私信。");
        videoGenRequest.setExpectedDuration(30);
        videoGenRequest.setProductDescription("这是一款高品质的智能手机，具有出色的摄影功能和长续航能力");
        videoGenRequest.setProductTitle("X300智能手机");
        request.setVideoGenerationRequest(videoGenRequest);
        
        // 6. 调用 API
        try {
            System.out.println("开始调用 SubmitOmniFusionTask API...");
            
            // 调用 API
            SubmitOmniFusionTaskResponse response = vodClient.submitOmniFusionTask(request);
            
            // 7. 处理响应结果
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
}


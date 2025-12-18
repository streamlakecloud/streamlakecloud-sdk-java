package com.kuaishou.vod.example;

import java.io.IOException;

import com.kuaishou.vod.core.Credential;
import com.kuaishou.vod.core.HttpProfile;
import com.kuaishou.vod.core.exception.KuaishouVodSdkException;
import com.kuaishou.vod.openapi.client.VodClient;
import com.kuaishou.vod.openapi.model.request.vod.QueryOmniFusionTaskRequest;
import com.kuaishou.vod.openapi.model.response.vod.QueryOmniFusionTaskResponse;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * QueryOmniFusionTask 使用示例
 * 
 * @author wanghaobo
 */
public class QueryOmniFusionTaskExample {

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
        
        // 5. 创建 QueryOmniFusionTaskRequest 并设置参数
        QueryOmniFusionTaskRequest request = new QueryOmniFusionTaskRequest();
        
        // 设置任务 ID（从 SubmitOmniFusionTask 返回的 task_id）
        request.setTaskId("bb907d4198882814890cb5347b6fc9f4");
        
        // 6. 调用 API
        try {
            System.out.println("开始调用 QueryOmniFusionTask API...");
            System.out.println("查询任务 ID: " + request.getTaskId());
            System.out.println("========================================");
            
            // 调用 API
            QueryOmniFusionTaskResponse response = vodClient.queryOmniFusionTask(request);
            
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


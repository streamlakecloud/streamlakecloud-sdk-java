package com.kuaishou.vod.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.kuaishou.vod.core.Credential;
import com.kuaishou.vod.core.HttpProfile;
import com.kuaishou.vod.core.exception.KuaishouVodSdkException;
import com.kuaishou.vod.openapi.client.VodClient;
import com.kuaishou.vod.openapi.model.request.vod.SubmitOmniFusionTaskRequest;
import com.kuaishou.vod.openapi.model.request.vod.SubmitOmniFusionTaskRequest.GenerationType;
import com.kuaishou.vod.openapi.model.request.vod.SubmitOmniFusionTaskRequest.MediaSource;
import com.kuaishou.vod.openapi.model.request.vod.SubmitOmniFusionTaskRequest.MediaType;
import com.kuaishou.vod.openapi.model.request.vod.SubmitOmniFusionTaskRequest.OutputConfig;
import com.kuaishou.vod.openapi.model.request.vod.SubmitOmniFusionTaskRequest.Quality;
import com.kuaishou.vod.openapi.model.request.vod.SubmitOmniFusionTaskRequest.VideoGenerationRequest;
import com.kuaishou.vod.openapi.model.response.vod.SubmitOmniFusionTaskResponse;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * SubmitOmniFusionTask 使用示例
 * <p>
 * 演示两种生成模式：
 * - AUTO_GENERATE：自动生成文案模式
 * - USER_SCRIPT：用户脚本模式
 * </p>
 * 
 * @author wanghaobo
 */
public class SubmitOmniFusionTaskExample {

    public static void main(String[] args) {
        // 选择要运行的示例
        // autoGenerateExample();   // AUTO_GENERATE 模式（自动生成文案）
        userScriptExample();  // USER_SCRIPT 模式（用户脚本）
    }

    /**
     * AUTO_GENERATE 模式示例 - 自动生成文案
     * <p>
     * 系统自动根据 product_title 和 product_description 生成文案和TTS音频
     * 注意：此模式下 media_source 中不允许传入音频素材
     * </p>
     */
    public static void autoGenerateExample() {
        VodClient vodClient = createVodClient();
        if (vodClient == null) return;
        
        // 创建请求
        SubmitOmniFusionTaskRequest request = new SubmitOmniFusionTaskRequest();
        
        // 设置必填参数
        request.setBizKey("CYBERCUT_TEST_TOB");
        request.setCallbackUrl("https://your-domain.com/callback");
        request.setCallbackArgs("{\"user_id\":\"123\",\"order_id\":\"456\"}");
        request.setTemplateId("template1");
        
        // 创建媒体源列表（AUTO_GENERATE 模式不允许传入音频）
        List<MediaSource> mediaSourceList = new ArrayList<>();
        
        MediaSource video1 = new MediaSource();
        video1.setMediaType(MediaType.VIDEO);
        video1.setMediaId("4b146980a457bac2");
        mediaSourceList.add(video1);
        
        MediaSource video2 = new MediaSource();
        video2.setMediaType(MediaType.VIDEO);
        video2.setMediaId("f794d2afffd252d7");
        mediaSourceList.add(video2);
        
        MediaSource video3 = new MediaSource();
        video3.setMediaType(MediaType.VIDEO);
        video3.setMediaId("0a730c47726accb0");
        mediaSourceList.add(video3);
        
        request.setMediaSource(mediaSourceList);
        
        // 设置输出配置
        OutputConfig outputConfig = new OutputConfig();
        outputConfig.setFilenamePrefix("my_video_");
        outputConfig.setOutputFormat("mp4");
        outputConfig.setQuality(Quality.HIGH);
        outputConfig.setExtraParams("{\"resolution\":\"1080p\"}");
        request.setOutputConfig(outputConfig);
        
        // 设置视频生成请求（AUTO_GENERATE 模式）
        VideoGenerationRequest videoGenRequest = new VideoGenerationRequest();
        videoGenRequest.setGenerationType(GenerationType.AUTO_GENERATE);
        videoGenRequest.setExpectedDuration(30);  // AUTO_GENERATE 模式必填
        videoGenRequest.setProductTitle("X300智能手机");  // AUTO_GENERATE 模式必填
        videoGenRequest.setProductDescription("这是一款高品质的智能手机，具有出色的摄影功能和长续航能力");  // AUTO_GENERATE 模式必填
        videoGenRequest.setCustomConstraint("推荐大家下单付款放在最后！结尾有清晰指令，引导点赞、评论、购买或私信。");
        request.setVideoGenerationRequest(videoGenRequest);
        
        // 调用 API
        executeRequest(vodClient, request, "AUTO_GENERATE");
    }

    /**
     * USER_SCRIPT 模式示例 - 用户脚本
     * <p>
     * 使用用户提供的 source_script 脚本
     * 注意：此模式下 media_source 中必须传入音频素材（且最多1个）
     * </p>
     */
    public static void userScriptExample() {
        VodClient vodClient = createVodClient();
        if (vodClient == null) return;
        
        // 创建请求
        SubmitOmniFusionTaskRequest request = new SubmitOmniFusionTaskRequest();
        
        // 设置必填参数
        request.setBizKey("CYBERCUT_TEST_TOB");
        request.setCallbackUrl("https://your-domain.com/callback");
        request.setCallbackArgs("{\"user_id\":\"123\",\"order_id\":\"456\"}");
        request.setTemplateId("template1");
        
        // 创建媒体源列表（USER_SCRIPT 模式必须传入音频）
        List<MediaSource> mediaSourceList = new ArrayList<>();
        
        // 视频素材
        MediaSource video1 = new MediaSource();
        video1.setMediaType(MediaType.VIDEO);
        video1.setMediaId("359500944d30dde2");
        mediaSourceList.add(video1);
        
        MediaSource video2 = new MediaSource();
        video2.setMediaType(MediaType.VIDEO);
        video2.setMediaId("19e84536a45b7d8c");
        mediaSourceList.add(video2);
        
        MediaSource video3 = new MediaSource();
        video3.setMediaType(MediaType.VIDEO);
        video3.setMediaId("e3a9d1adcebb8935");
        mediaSourceList.add(video3);
        
        // 音频素材（USER_SCRIPT 模式必填，最多1个）
        MediaSource audio = new MediaSource();
        audio.setMediaType(MediaType.AUDIO);
        audio.setMediaId("c3cce6b91d382c09");
        mediaSourceList.add(audio);
        
        request.setMediaSource(mediaSourceList);
        
        // 设置输出配置
        OutputConfig outputConfig = new OutputConfig();
        outputConfig.setFilenamePrefix("user_script_video_");
        outputConfig.setOutputFormat("mp4");
        outputConfig.setQuality(Quality.HIGH);
        request.setOutputConfig(outputConfig);
        
        // 设置视频生成请求（USER_SCRIPT 模式）
        VideoGenerationRequest videoGenRequest = new VideoGenerationRequest();
        videoGenRequest.setGenerationType(GenerationType.USER_SCRIPT);
        // USER_SCRIPT 模式必填：用户脚本（与音频内容一致）
        videoGenRequest.setSourceScript("开会还要扛电脑？X Fold5直接搞定！原子工作台五窗口并行，" +
                "手指一划秒切界面，信息处理快到飞起～支持Mac键鼠协同拖文件，手机就是扩展屏！" +
                "轻薄机身三色可选，分屏回消息超顺手。深夜要报表？直搜Mac文件秒发邮件，" +
                "葛优躺三分钟搞定！职场多线程救星，无痛办公就靠它～");
        videoGenRequest.setCustomConstraint("视频风格要活泼有趣");
        request.setVideoGenerationRequest(videoGenRequest);
        
        // 调用 API
        executeRequest(vodClient, request, "USER_SCRIPT");
    }

    /**
     * 创建 VodClient
     */
    private static VodClient createVodClient() {
        // 从 .env 文件加载配置
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

    /**
     * 执行请求并打印响应
     */
    private static void executeRequest(VodClient vodClient, SubmitOmniFusionTaskRequest request, String mode) {
        try {
            System.out.println("========================================");
            System.out.println("开始调用 SubmitOmniFusionTask API (" + mode + " 模式)...");
            System.out.println("========================================");
            
            SubmitOmniFusionTaskResponse response = vodClient.submitOmniFusionTask(request);
            
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

package com.kuaishou.vod.openapi.model.request.vod;

import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractRequest;

/**
 * SubmitOmniFusionTask 请求类
 * <p>
 * CyberCut多模态融合工作流任务提交接口，支持视频和图片素材的智能融合处理
 * </p>
 * 
 * @author wanghaobo
 * @version 1.2.0
 * @since 2025-09-25
 */
public class SubmitOmniFusionTaskRequest extends AbstractRequest {
    
    /**
     * 业务线标识（必填）
     */
    @SerializedName("biz_key")
    @Expose
    private String bizKey;
    
    /**
     * 回调URL，任务完成后将结果推送到此URL（必填）
     */
    @SerializedName("callback_url")
    @Expose
    private String callbackUrl;
    
    /**
     * 回调时需要传递的参数，JSON字符串（可选）
     */
    @SerializedName("callback_args")
    @Expose
    private String callbackArgs;
    
    /**
     * 媒体素材列表（必填）
     */
    @SerializedName("media_source")
    @Expose
    private List<MediaSource> mediaSource;
    
    /**
     * 模板ID，默认为"template1"（可选）
     */
    @SerializedName("template_id")
    @Expose
    private String templateId;
    
    /**
     * 自定义输出配置（可选）
     */
    @SerializedName("output_config")
    @Expose
    private OutputConfig outputConfig;
    
    /**
     * 视频生成要求（可选）
     */
    @SerializedName("video_generation_request")
    @Expose
    private VideoGenerationRequest videoGenerationRequest;
    
    /**
     * 数字人配置（可选）
     */
    @SerializedName("vhuman_config")
    @Expose
    private VHumanConfig vhumanConfig;

    // ==================== Getters and Setters ====================

    public String getBizKey() {
        return bizKey;
    }

    public void setBizKey(String bizKey) {
        this.bizKey = bizKey;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getCallbackArgs() {
        return callbackArgs;
    }

    public void setCallbackArgs(String callbackArgs) {
        this.callbackArgs = callbackArgs;
    }

    public List<MediaSource> getMediaSource() {
        return mediaSource;
    }

    public void setMediaSource(List<MediaSource> mediaSource) {
        this.mediaSource = mediaSource;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public OutputConfig getOutputConfig() {
        return outputConfig;
    }

    public void setOutputConfig(OutputConfig outputConfig) {
        this.outputConfig = outputConfig;
    }

    public VideoGenerationRequest getVideoGenerationRequest() {
        return videoGenerationRequest;
    }

    public void setVideoGenerationRequest(VideoGenerationRequest videoGenerationRequest) {
        this.videoGenerationRequest = videoGenerationRequest;
    }

    public VHumanConfig getVhumanConfig() {
        return vhumanConfig;
    }

    public void setVhumanConfig(VHumanConfig vhumanConfig) {
        this.vhumanConfig = vhumanConfig;
    }

    @Override
    public HashMap<String, String> toMap() {
        HashMap<String, String> map = new HashMap<>();
        Gson gson = new Gson();
        if (this.bizKey != null) {
            map.put("biz_key", this.bizKey);
        }
        if (this.callbackUrl != null) {
            map.put("callback_url", this.callbackUrl);
        }
        if (this.callbackArgs != null) {
            map.put("callback_args", this.callbackArgs);
        }
        if (this.mediaSource != null) {
            map.put("media_source", gson.toJson(this.mediaSource));
        }
        if (this.templateId != null) {
            map.put("template_id", this.templateId);
        }
        if (this.outputConfig != null) {
            map.put("output_config", gson.toJson(this.outputConfig));
        }
        if (this.videoGenerationRequest != null) {
            map.put("video_generation_request", gson.toJson(this.videoGenerationRequest));
        }
        if (this.vhumanConfig != null) {
            map.put("vhuman_config", gson.toJson(this.vhumanConfig));
        }
        return map;
    }

    // ==================== 内部类定义 ====================

    /**
     * 媒体源
     * <p>
     * 注意：
     * - audio 类型素材最多只能有1个
     * - AUTO_GENERATE 模式下不允许传入音频素材
     * - USER_SCRIPT 模式下必须传入音频素材
     * </p>
     */
    public static class MediaSource {
        /**
         * 媒体类型（必填）
         * 可选值：video, image, audio
         */
        @SerializedName("media_type")
        @Expose
        private String mediaType;
        
        /**
         * 媒体资源ID，StreamLake点播云媒资管理系统中的唯一标识符（必填）
         */
        @SerializedName("media_id")
        @Expose
        private String mediaId;

        public String getMediaType() {
            return mediaType;
        }

        public void setMediaType(String mediaType) {
            this.mediaType = mediaType;
        }

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }

    /**
     * 输出配置
     */
    public static class OutputConfig {
        /**
         * 输出文件名前缀（可选）
         */
        @SerializedName("filename_prefix")
        @Expose
        private String filenamePrefix;
        
        /**
         * 输出格式（可选）
         * 可选值：mp4, avi, mov
         */
        @SerializedName("output_format")
        @Expose
        private String outputFormat;
        
        /**
         * 输出质量（可选）
         * 可选值：low, medium, high
         */
        @SerializedName("quality")
        @Expose
        private String quality;
        
        /**
         * 额外的输出参数，JSON字符串（可选）
         * <p>
         * 支持的参数：
         * - resolution: 输出分辨率（如 720, 1080）
         * - aspect_ratio: 宽高比（如 "16:9", "9:16", "1:1"）
         * </p>
         */
        @SerializedName("extra_params")
        @Expose
        private String extraParams;

        public String getFilenamePrefix() {
            return filenamePrefix;
        }

        public void setFilenamePrefix(String filenamePrefix) {
            this.filenamePrefix = filenamePrefix;
        }

        public String getOutputFormat() {
            return outputFormat;
        }

        public void setOutputFormat(String outputFormat) {
            this.outputFormat = outputFormat;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getExtraParams() {
            return extraParams;
        }

        /**
         * 设置额外参数（JSON字符串形式）
         * <p>
         * 兼容旧版本，直接传入JSON字符串
         * </p>
         * 
         * @param extraParams JSON字符串，如 "{\"resolution\":720,\"aspect_ratio\":\"1:1\"}"
         */
        public void setExtraParams(String extraParams) {
            this.extraParams = extraParams;
        }
        
        /**
         * 设置额外参数（对象形式，推荐）
         * <p>
         * 使用 ExtraParams 对象设置参数，SDK会自动序列化为JSON字符串
         * </p>
         * 
         * @param extraParams ExtraParams对象
         */
        public void setExtraParams(ExtraParams extraParams) {
            if (extraParams != null) {
                this.extraParams = new Gson().toJson(extraParams);
            } else {
                this.extraParams = null;
            }
        }
    }
    
    /**
     * 额外输出参数
     * <p>
     * 用于配置输出视频的分辨率和宽高比等参数
     * </p>
     */
    public static class ExtraParams {
        /**
         * 输出分辨率（可选）
         * <p>
         * 推荐使用 Resolution 枚举设置
         * </p>
         */
        @SerializedName("resolution")
        @Expose
        private Integer resolution;
        
        /**
         * 宽高比（可选）
         * <p>
         * 推荐使用 AspectRatio 枚举设置
         * </p>
         */
        @SerializedName("aspect_ratio")
        @Expose
        private String aspectRatio;
        
        /**
         * 默认构造函数
         */
        public ExtraParams() {
        }
        
        /**
         * 带参数的构造函数（使用枚举，推荐）
         * 
         * @param resolution 分辨率枚举
         * @param aspectRatio 宽高比枚举
         */
        public ExtraParams(Resolution resolution, AspectRatio aspectRatio) {
            this.resolution = resolution != null ? resolution.getValue() : null;
            this.aspectRatio = aspectRatio != null ? aspectRatio.getValue() : null;
        }
        
        /**
         * 带参数的构造函数（兼容旧版，直接传值）
         * 
         * @param resolution 输出分辨率数值
         * @param aspectRatio 宽高比字符串
         */
        public ExtraParams(Integer resolution, String aspectRatio) {
            this.resolution = resolution;
            this.aspectRatio = aspectRatio;
        }

        public Integer getResolution() {
            return resolution;
        }

        /**
         * 设置分辨率（直接传数值，兼容旧版）
         */
        public void setResolution(Integer resolution) {
            this.resolution = resolution;
        }
        
        /**
         * 设置分辨率（使用枚举，推荐）
         */
        public void setResolution(Resolution resolution) {
            this.resolution = resolution != null ? resolution.getValue() : null;
        }

        public String getAspectRatio() {
            return aspectRatio;
        }

        /**
         * 设置宽高比（直接传字符串，兼容旧版）
         */
        public void setAspectRatio(String aspectRatio) {
            this.aspectRatio = aspectRatio;
        }
        
        /**
         * 设置宽高比（使用枚举，推荐）
         */
        public void setAspectRatio(AspectRatio aspectRatio) {
            this.aspectRatio = aspectRatio != null ? aspectRatio.getValue() : null;
        }
        
        /**
         * Builder模式（直接传数值，兼容旧版）
         */
        public ExtraParams withResolution(Integer resolution) {
            this.resolution = resolution;
            return this;
        }
        
        /**
         * Builder模式（使用枚举，推荐）
         */
        public ExtraParams withResolution(Resolution resolution) {
            this.resolution = resolution != null ? resolution.getValue() : null;
            return this;
        }
        
        /**
         * Builder模式（直接传字符串，兼容旧版）
         */
        public ExtraParams withAspectRatio(String aspectRatio) {
            this.aspectRatio = aspectRatio;
            return this;
        }
        
        /**
         * Builder模式（使用枚举，推荐）
         */
        public ExtraParams withAspectRatio(AspectRatio aspectRatio) {
            this.aspectRatio = aspectRatio != null ? aspectRatio.getValue() : null;
            return this;
        }
    }

    /**
     * 视频生成请求
     * <p>
     * 生成类型说明：
     * - AUTO_GENERATE（默认）: 系统自动根据 product_title 和 product_description 生成文案和TTS音频，media_source 中不允许传入音频
     * - USER_SCRIPT: 使用用户提供的 source_script 脚本，media_source 中必须传入对应的音频素材
     * </p>
     */
    public static class VideoGenerationRequest {
        /**
         * 生成类型（可选）
         * 可选值：AUTO_GENERATE（自动生成文案，默认）、USER_SCRIPT（使用用户脚本）
         */
        @SerializedName("generation_type")
        @Expose
        private String generationType;
        
        /**
         * 期望生成的视频时长（秒）
         * AUTO_GENERATE 模式必填
         */
        @SerializedName("expected_duration")
        @Expose
        private Integer expectedDuration;
        
        /**
         * 商品名称
         * AUTO_GENERATE 模式必填
         */
        @SerializedName("product_title")
        @Expose
        private String productTitle;
        
        /**
         * 商品描述
         * AUTO_GENERATE 模式必填
         */
        @SerializedName("product_description")
        @Expose
        private String productDescription;
        
        /**
         * 用户提供的脚本文本（与音频内容一致）
         * USER_SCRIPT 模式必填
         */
        @SerializedName("source_script")
        @Expose
        private String sourceScript;
        
        /**
         * 自定义约束条件（可选）
         */
        @SerializedName("custom_constraint")
        @Expose
        private String customConstraint;

        public String getGenerationType() {
            return generationType;
        }

        public void setGenerationType(String generationType) {
            this.generationType = generationType;
        }

        public Integer getExpectedDuration() {
            return expectedDuration;
        }

        public void setExpectedDuration(Integer expectedDuration) {
            this.expectedDuration = expectedDuration;
        }

        public String getProductTitle() {
            return productTitle;
        }

        public void setProductTitle(String productTitle) {
            this.productTitle = productTitle;
        }

        public String getProductDescription() {
            return productDescription;
        }

        public void setProductDescription(String productDescription) {
            this.productDescription = productDescription;
        }

        public String getSourceScript() {
            return sourceScript;
        }

        public void setSourceScript(String sourceScript) {
            this.sourceScript = sourceScript;
        }

        public String getCustomConstraint() {
            return customConstraint;
        }

        public void setCustomConstraint(String customConstraint) {
            this.customConstraint = customConstraint;
        }
    }

    /**
     * 数字人配置
     */
    public static class VHumanConfig {
        /**
         * 数字人ID（可选）
         */
        @SerializedName("vhuman_id")
        @Expose
        private String vhumanId;

        public String getVhumanId() {
            return vhumanId;
        }

        public void setVhumanId(String vhumanId) {
            this.vhumanId = vhumanId;
        }
    }

    // ==================== 常量定义 ====================

    /**
     * 生成类型常量
     */
    public static final class GenerationType {
        /**
         * 自动生成文案
         * 系统自动根据 product_title 和 product_description 生成文案和TTS音频
         * media_source 中不允许传入音频
         */
        public static final String AUTO_GENERATE = "AUTO_GENERATE";
        
        /**
         * 使用用户脚本
         * 使用用户提供的 source_script 脚本
         * media_source 中必须传入对应的音频素材
         */
        public static final String USER_SCRIPT = "USER_SCRIPT";
        
        private GenerationType() {}
    }

    /**
     * 媒体类型常量
     */
    public static final class MediaType {
        /** 视频 */
        public static final String VIDEO = "video";
        /** 图片 */
        public static final String IMAGE = "image";
        /** 音频（最多只能有1个） */
        public static final String AUDIO = "audio";
        
        private MediaType() {}
    }

    /**
     * 输出格式常量
     */
    public static final class OutputFormat {
        public static final String MP4 = "mp4";
        public static final String AVI = "avi";
        public static final String MOV = "mov";
        
        private OutputFormat() {}
    }

    /**
     * 输出质量常量
     */
    public static final class Quality {
        public static final String LOW = "low";
        public static final String MEDIUM = "medium";
        public static final String HIGH = "high";
        
        private Quality() {}
    }
    
    /**
     * 宽高比枚举
     */
    public enum AspectRatio {
        /** 横屏 16:9 */
        RATIO_16_9("16:9"),
        /** 竖屏 9:16 */
        RATIO_9_16("9:16"),
        /** 方形 1:1 */
        RATIO_1_1("1:1");
        
        private final String value;
        
        AspectRatio(String value) {
            this.value = value;
        }
        
        public String getValue() {
            return value;
        }
        
        @Override
        public String toString() {
            return value;
        }
    }
    
    /**
     * 分辨率枚举
     */
    public enum Resolution {
        /** 480p */
        RES_480P(480),
        /** 720p HD */
        RES_720P(720),
        /** 1080p Full HD */
        RES_1080P(1080),
        /** 1440p 2K */
        RES_1440P(1440),
        /** 2160p 4K / UHD */
        RES_4K(2160);
        
        private final int value;
        
        Resolution(int value) {
            this.value = value;
        }
        
        public int getValue() {
            return value;
        }
        
        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
}

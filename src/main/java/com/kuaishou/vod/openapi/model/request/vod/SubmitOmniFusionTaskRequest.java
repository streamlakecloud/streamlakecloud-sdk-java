package com.kuaishou.vod.openapi.model.request.vod;

import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractRequest;

/**
 * SubmitOmniFusionTask 请求类
 * 
 * @author wanghaobo
 */
public class SubmitOmniFusionTaskRequest extends AbstractRequest {
    
    @SerializedName("biz_key")
    @Expose
    private String bizKey;
    
    @SerializedName("callback_url")
    @Expose
    private String callbackUrl;
    
    @SerializedName("callback_args")
    @Expose
    private String callbackArgs;
    
    @SerializedName("media_source")
    @Expose
    private List<MediaSource> mediaSource;
    
    @SerializedName("output_config")
    @Expose
    private OutputConfig outputConfig;
    
    @SerializedName("template_id")
    @Expose
    private String templateId;
    
    @SerializedName("video_generation_request")
    @Expose
    private VideoGenerationRequest videoGenerationRequest;

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

    public OutputConfig getOutputConfig() {
        return outputConfig;
    }

    public void setOutputConfig(OutputConfig outputConfig) {
        this.outputConfig = outputConfig;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public VideoGenerationRequest getVideoGenerationRequest() {
        return videoGenerationRequest;
    }

    public void setVideoGenerationRequest(VideoGenerationRequest videoGenerationRequest) {
        this.videoGenerationRequest = videoGenerationRequest;
    }

    @Override
    public HashMap<String, String> toMap() {
        HashMap<String, String> map = new HashMap<>();
        Gson gson = new Gson();
        map.put("biz_key", this.bizKey);
        if (this.callbackUrl != null) {
            map.put("callback_url", this.callbackUrl);
        }
        if (this.callbackArgs != null) {
            map.put("callback_args", this.callbackArgs);
        }
        if (this.mediaSource != null) {
            map.put("media_source", gson.toJson(this.mediaSource));
        }
        if (this.outputConfig != null) {
            map.put("output_config", gson.toJson(this.outputConfig));
        }
        if (this.templateId != null) {
            map.put("template_id", this.templateId);
        }
        if (this.videoGenerationRequest != null) {
            map.put("video_generation_request", gson.toJson(this.videoGenerationRequest));
        }
        return map;
    }

    /**
     * 媒体源
     */
    public static class MediaSource {
        @SerializedName("media_type")
        @Expose
        private String mediaType;
        
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
        @SerializedName("extra_params")
        @Expose
        private String extraParams;
        
        @SerializedName("filename_prefix")
        @Expose
        private String filenamePrefix;
        
        @SerializedName("output_format")
        @Expose
        private String outputFormat;
        
        @SerializedName("quality")
        @Expose
        private String quality;

        public String getExtraParams() {
            return extraParams;
        }

        public void setExtraParams(String extraParams) {
            this.extraParams = extraParams;
        }

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
    }

    /**
     * 视频生成请求
     */
    public static class VideoGenerationRequest {
        @SerializedName("custom_constraint")
        @Expose
        private String customConstraint;
        
        @SerializedName("expected_duration")
        @Expose
        private Integer expectedDuration;
        
        @SerializedName("product_description")
        @Expose
        private String productDescription;
        
        @SerializedName("product_title")
        @Expose
        private String productTitle;

        public String getCustomConstraint() {
            return customConstraint;
        }

        public void setCustomConstraint(String customConstraint) {
            this.customConstraint = customConstraint;
        }

        public Integer getExpectedDuration() {
            return expectedDuration;
        }

        public void setExpectedDuration(Integer expectedDuration) {
            this.expectedDuration = expectedDuration;
        }

        public String getProductDescription() {
            return productDescription;
        }

        public void setProductDescription(String productDescription) {
            this.productDescription = productDescription;
        }

        public String getProductTitle() {
            return productTitle;
        }

        public void setProductTitle(String productTitle) {
            this.productTitle = productTitle;
        }
    }
}


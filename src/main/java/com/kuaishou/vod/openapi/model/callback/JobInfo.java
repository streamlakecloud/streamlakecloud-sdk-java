package com.kuaishou.vod.openapi.model.callback;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobInfo {
    /**
     * 任务ID
     */
    @SerializedName("JobId")
    @Expose
    public String jobId;
    /**
     * 模板ID
     */
    @SerializedName("TemplateId")
    @Expose
    public String templateId;
    /**
     * 转出文件的url或者目录,多个逗号分割
     */
    @SerializedName("UrlPaths")
    @Expose
    public String urlPaths;
    /**
     * 失败时的错误码
     */
    @SerializedName("ErrorCode")
    @Expose
    public String errorCode;
    /**
     * 失败时的错误信息
     */
    @SerializedName("ErrorMessage")
    @Expose
    public String errorMessage;
    /**
     * 媒体文件信息
     */
    @SerializedName("MediaInfos")
    @Expose
    public List<MediaInfo> mediaInfos;

    /**
     * 任务ID
     */
    public String getJobId() {
        return this.jobId;
    }

    /**
     * 任务ID
     */
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    /**
     * 模板ID
     */
    public String getTemplateId() {
        return this.templateId;
    }

    /**
     * 模板ID
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    /**
     * 转出文件的url或者目录,多个逗号分割
     */
    public String getUrlPaths() {
        return this.urlPaths;
    }

    /**
     * 转出文件的url或者目录,多个逗号分割
     */
    public void setUrlPaths(String urlPaths) {
        this.urlPaths = urlPaths;
    }

    public List<MediaInfo> getMediaInfos() {
        return mediaInfos;
    }

    public void setMediaInfos(List<MediaInfo> mediaInfos) {
        this.mediaInfos = mediaInfos;
    }

    /**
     * 失败时的错误码
     */
    public String getErrorCode() {
        return this.errorCode;
    }

    /**
     * 失败时的错误码
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * 失败时的错误信息
     */
    public String getErrorMessage() {
        return this.errorMessage;
    }

    /**
     * 失败时的错误信息
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}

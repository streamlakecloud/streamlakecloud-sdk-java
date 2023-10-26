package com.kuaishou.vod.openapi.model.callback;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractEvent;

public class MediaProcessEvent extends AbstractEvent {
    /**
     * 分类, 可选值：transcode：转码watermark：水印snapshot：指定时间截图sample：采样截图animation：转动图
     */
    @SerializedName("ProcessType")
    @Expose
    public String processType;
    /**
     * 任务的信息列表
     */
    @SerializedName("JobInfos")
    @Expose
    public List<JobInfo> jobInfos;
    /**
     * 用户透传信息
     */
    @SerializedName("UserData")
    @Expose
    public String userData;

    public MediaProcessEvent(Class aClass) {
        super(aClass);
    }

    /**
     * 分类, 可选值：transcode：转码watermark：水印snapshot：指定时间截图sample：采样截图animation：转动图
     */
    public String getProcessType() {
        return this.processType;
    }

    /**
     * 分类, 可选值：transcode：转码watermark：水印snapshot：指定时间截图sample：采样截图animation：转动图
     */
    public void setProcessType(String processType) {
        this.processType = processType;
    }

    /**
     * 任务的信息列表
     */
    public List<JobInfo> getJobInfos() {
        return this.jobInfos;
    }

    /**
     * 任务的信息列表
     */
    public void setJobInfos(List<JobInfo> jobInfos) {
        this.jobInfos = jobInfos;
    }

    /**
     * 用户透传信息
     */
    public String getUserData() {
        return this.userData;
    }

    /**
     * 用户透传信息
     */
    public void setUserData(String userData) {
        this.userData = userData;
    }

}

package com.kuaishou.vod.openapi.model.request.vod;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MediaDeleteItem {
    @SerializedName("Type")
    @Expose
    public String type;
    @SerializedName("TemplateId")
    @Expose
    public String templateId;
    @SerializedName("JobId")
    @Expose
    public String jobId;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
}

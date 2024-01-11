package com.kuaishou.vod.openapi.model.request.vod;

import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractRequest;

/**
 * @author fubaiqiang <fubaiqiang@kuaishou.com>
 * Created on 2023-12-08
 */
public class DescribeMediaProcessJobRequest extends AbstractRequest {

    @SerializedName("ProcessType")
    @Expose
    private String processType;

    @SerializedName("JobId")
    @Expose
    private String jobId;

    @SerializedName("SpaceName")
    @Expose
    private String spaceName;

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    @Override
    public HashMap<String, String> toMap() {
        HashMap<String, String> map = new HashMap<>();
        map.computeIfAbsent("ProcessType", key -> new Gson().toJson(this.processType));
        map.computeIfAbsent("JobId", key -> new Gson().toJson(this.jobId));
        map.computeIfAbsent("SpaceName", key -> new Gson().toJson(this.spaceName));
        return map;
    }
}

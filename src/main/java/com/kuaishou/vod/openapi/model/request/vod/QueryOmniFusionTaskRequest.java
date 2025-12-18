package com.kuaishou.vod.openapi.model.request.vod;

import java.util.HashMap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractRequest;

/**
 * QueryOmniFusionTask 请求类
 * 
 * @author wanghaobo
 */
public class QueryOmniFusionTaskRequest extends AbstractRequest {
    
    @SerializedName("task_id")
    @Expose
    private String taskId;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public HashMap<String, String> toMap() {
        HashMap<String, String> map = new HashMap<>();
        if (this.taskId != null) {
            map.put("task_id", this.taskId);
        }
        return map;
    }
}


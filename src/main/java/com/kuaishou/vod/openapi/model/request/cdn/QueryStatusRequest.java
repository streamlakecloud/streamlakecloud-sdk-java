package com.kuaishou.vod.openapi.model.request.cdn;

import java.util.HashMap;

import com.kuaishou.vod.core.AbstractRequest;

/**
 *
 * Created on 2021-12-15
 */
public class QueryStatusRequest extends AbstractRequest {

    public String taskId;

    public String taskType;

    public Integer offset;

    public Integer limit;

    @Override
    public HashMap<String, String> toMap() {
        HashMap<String, String> map = new HashMap<>();
        map.computeIfAbsent("TaskId", key -> this.taskId);
        map.computeIfAbsent("TaskType", key -> this.taskType);
        if (offset != null) {
            map.computeIfAbsent("Offset", key -> String.valueOf(this.offset));
        }
        if (limit != null) {
            map.computeIfAbsent("Limit", key -> String.valueOf(this.limit));
        }

        return map;
    }
}

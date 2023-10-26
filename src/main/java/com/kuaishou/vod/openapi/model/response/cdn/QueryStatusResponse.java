package com.kuaishou.vod.openapi.model.response.cdn;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractResponse;
import com.kuaishou.vod.openapi.model.response.cdn.PreloadResponse.ResponseData;

/**
 *
 * Created on 2021-12-15
 */
public class QueryStatusResponse extends AbstractResponse {
    @SerializedName("ResponseData")
    @Expose
    public ResponseData responseData;

    public ResponseData getResponseData() {
        return responseData;
    }

    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }

    public QueryStatusResponse(Class aClass) {
        super(aClass);
    }

    public static class ResponseData {
        @SerializedName("Offset")
        @Expose
        public int offset;

        @SerializedName("Limit")
        @Expose
        public int limit;

        @SerializedName("TotalCount")
        @Expose
        public int totalCount;

        @SerializedName("Tasks")
        @Expose
        public List<Task> tasks;

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public List<Task> getTasks() {
            return tasks;
        }

        public void setTasks(List<Task> tasks) {
            this.tasks = tasks;
        }

        public static class Task {
            @SerializedName("CreationTime")
            @Expose
            public String creationTime;

            @SerializedName("ObjectPath")
            @Expose
            public String objectPath;

            @SerializedName("ObjectType")
            @Expose
            public String objectType;

            @SerializedName("Status")
            @Expose
            public String status;

            @SerializedName("TaskId")
            @Expose
            public String taskId;

            @SerializedName("TaskType")
            @Expose
            public String taskType;

            public String getCreationTime() {
                return creationTime;
            }

            public void setCreationTime(String creationTime) {
                this.creationTime = creationTime;
            }

            public String getObjectPath() {
                return objectPath;
            }

            public void setObjectPath(String objectPath) {
                this.objectPath = objectPath;
            }

            public String getObjectType() {
                return objectType;
            }

            public void setObjectType(String objectType) {
                this.objectType = objectType;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getTaskId() {
                return taskId;
            }

            public void setTaskId(String taskId) {
                this.taskId = taskId;
            }

            public String getTaskType() {
                return taskType;
            }

            public void setTaskType(String taskType) {
                this.taskType = taskType;
            }
        }
    }
}

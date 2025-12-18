package com.kuaishou.vod.openapi.model.response.vod;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractResponse;

/**
 * QueryOmniFusionTask 响应类
 * 
 * @author wanghaobo
 */
public class QueryOmniFusionTaskResponse extends AbstractResponse {

    @SerializedName("ResponseData")
    @Expose
    private ResponseData responseData;

    public QueryOmniFusionTaskResponse(Class aClass) {
        super(aClass);
    }

    public ResponseData getResponseData() {
        return responseData;
    }

    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }

    /**
     * 响应数据
     */
    public static class ResponseData {
        /**
         * 任务ID
         */
        @SerializedName("task_id")
        @Expose
        private String taskId;

        /**
         * 工作流状态
         * 可能的值：PENDING, PROCESSING, COMPLETED, FAILED
         */
        @SerializedName("workflow_status")
        @Expose
        private String workflowStatus;

        /**
         * 进度（0-100）
         */
        @SerializedName("progress")
        @Expose
        private Integer progress;

        /**
         * 结果数据（任务完成后返回）
         */
        @SerializedName("result_data")
        @Expose
        private ResultData resultData;

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public String getWorkflowStatus() {
            return workflowStatus;
        }

        public void setWorkflowStatus(String workflowStatus) {
            this.workflowStatus = workflowStatus;
        }

        public Integer getProgress() {
            return progress;
        }

        public void setProgress(Integer progress) {
            this.progress = progress;
        }

        public ResultData getResultData() {
            return resultData;
        }

        public void setResultData(ResultData resultData) {
            this.resultData = resultData;
        }
    }

    /**
     * 结果数据
     */
    public static class ResultData {
        /**
         * 视频结果
         */
        @SerializedName("video")
        @Expose
        private VideoResult video;

        public VideoResult getVideo() {
            return video;
        }

        public void setVideo(VideoResult video) {
            this.video = video;
        }
    }

    /**
     * 视频结果
     */
    public static class VideoResult {
        /**
         * 视频URL
         */
        @SerializedName("url")
        @Expose
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    /**
     * 工作流状态常量
     */
    public static final class WorkflowStatus {
        /** 未开始 */
        public static final String NOT_STARTED = "NOT_STARTED";
        /** 运行中 */
        public static final String RUNNING = "RUNNING";
        /** 已完成 */
        public static final String COMPLETED = "COMPLETED";
        /** 错误 */
        public static final String ERROR = "ERROR";
        /** 失败 */
        public static final String FAILED = "FAILED";

        private WorkflowStatus() {}
    }
}

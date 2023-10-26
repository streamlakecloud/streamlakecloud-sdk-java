package com.kuaishou.vod.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.openapi.model.callback.AudioTranscodeEvent;
import com.kuaishou.vod.openapi.model.callback.FetchStoreEvent;
import com.kuaishou.vod.openapi.model.callback.FetchUploadEvent;
import com.kuaishou.vod.openapi.model.callback.MediaProcessEvent;
import com.kuaishou.vod.openapi.model.callback.ProcessingFlowEvent;
import com.kuaishou.vod.openapi.model.callback.SegmentBodyEvent;
import com.kuaishou.vod.openapi.model.callback.VideoCoverEvent;
import com.kuaishou.vod.openapi.model.callback.VideoHotEvent;
import com.kuaishou.vod.openapi.model.callback.VideoMetaEvent;
import com.kuaishou.vod.openapi.model.callback.VideoSpriteEvent;
import com.kuaishou.vod.openapi.model.callback.VideoTranscodeEvent;
import com.kuaishou.vod.openapi.model.callback.VideoUploadEvent;

/**
 *
 * Created on 2021-07-13
 */
public abstract class AbstractEvent<T extends AbstractEvent> {

    private static final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    @SerializedName("EventType")
    @Expose
    public String eventType;

    @SerializedName("MediaId")
    @Expose
    public String mediaId;

    @SerializedName("PrimaryKey")
    @Expose
    public String primaryKey;

    @SerializedName("RequestId")
    @Expose
    public String requestId;

    @SerializedName("ErrorCode")
    @Expose
    public String errorCode;

    @SerializedName("ErrorMessage")
    @Expose
    public String errorMessage;

    @SerializedName("CallbackArgs")
    @Expose
    public String callbackArgs;

    public String getCallbackArgs() {
        return callbackArgs;
    }

    public void setCallbackArgs(String callbackArgs) {
        this.callbackArgs = callbackArgs;
    }

    protected Class<T> type;

    protected AbstractEvent(Class<T> tClass) {
        this.type = tClass;
    }

    public static AudioTranscodeEvent audioTranscodeEvent() {
        return new AudioTranscodeEvent(AudioTranscodeEvent.class);
    }

    public static FetchUploadEvent fetchUploadEvent() {
        return new FetchUploadEvent(FetchUploadEvent.class);
    }

    public static FetchStoreEvent fetchStoreEvent() {
        return new FetchStoreEvent(FetchStoreEvent.class);
    }

    public static ProcessingFlowEvent processingFlowEvent() {
        return new ProcessingFlowEvent(ProcessingFlowEvent.class);
    }

    public static SegmentBodyEvent segmentBodyEvent() {
        return new SegmentBodyEvent(SegmentBodyEvent.class);
    }

    public static VideoCoverEvent videoCoverEvent() {
        return new VideoCoverEvent(VideoCoverEvent.class);
    }

    public static VideoHotEvent videoHotEvent() {
        return new VideoHotEvent(VideoHotEvent.class);
    }

    public static VideoMetaEvent videoMetaEvent() {
        return new VideoMetaEvent(VideoMetaEvent.class);
    }

    public static VideoSpriteEvent videoSpriteEvent() {
        return new VideoSpriteEvent(VideoSpriteEvent.class);
    }

    public static VideoTranscodeEvent videoTranscodeEvent() {
        return new VideoTranscodeEvent(VideoTranscodeEvent.class);
    }

    public static VideoUploadEvent videoUploadEvent() {
        return new VideoUploadEvent(VideoUploadEvent.class);
    }

    public static MediaProcessEvent mediaProcessEvent() {
        return new MediaProcessEvent(MediaProcessEvent.class);
    }

    public T fromJson(String json) {
        return gson.fromJson(json, this.type);
    }

    public T fromJson(JsonObject json) {
        return gson.fromJson(json.toString(), this.type);
    }

    public String toJson() {
        return gson.toJson(this);
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

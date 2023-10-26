package com.kuaishou.vod.openapi.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractEvent;

/**
 *
 * Created on 2021-07-13
 */
public class FetchStoreEvent extends AbstractEvent {
    @SerializedName("SourceURL")
    @Expose
    public String sourceURL;

    @SerializedName("MediaKey")
    @Expose
    public String mediaKey;

    public FetchStoreEvent(Class aClass) {
        super(aClass);
    }

    public String getSourceURL() {
        return sourceURL;
    }

    public void setSourceURL(String sourceURL) {
        this.sourceURL = sourceURL;
    }

    public String getMediaKey() {
        return mediaKey;
    }

    public void setMediaKey(String mediaKey) {
        this.mediaKey = mediaKey;
    }
}

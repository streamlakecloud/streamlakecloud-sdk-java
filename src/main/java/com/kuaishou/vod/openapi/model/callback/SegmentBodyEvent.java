package com.kuaishou.vod.openapi.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractEvent;

/**
 *
 * Created on 2021-07-13
 */
public class SegmentBodyEvent extends AbstractEvent {
    @SerializedName("SegmentName")
    @Expose
    public String segmentName;

    @SerializedName("URLPath")
    @Expose
    public String URLPath;

    public String getURLPath() {
        return URLPath;
    }

    public void setURLPath(String URLPath) {
        this.URLPath = URLPath;
    }

    public SegmentBodyEvent(Class aClass) {
        super(aClass);
    }
}

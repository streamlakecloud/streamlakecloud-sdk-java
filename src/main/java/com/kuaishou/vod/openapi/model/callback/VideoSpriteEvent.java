package com.kuaishou.vod.openapi.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractEvent;

/**
 *
 * Created on 2021-07-13
 */
public class VideoSpriteEvent extends AbstractEvent {
    @SerializedName("SpriteName")
    @Expose
    public String spriteName;

    @SerializedName("URLPath")
    @Expose
    public String URLPath;

    public String getURLPath() {
        return URLPath;
    }

    public void setURLPath(String URLPath) {
        this.URLPath = URLPath;
    }

    public VideoSpriteEvent(Class aClass) {
        super(aClass);
    }

    public String getSpriteName() {
        return spriteName;
    }

    public void setSpriteName(String spriteName) {
        this.spriteName = spriteName;
    }
}

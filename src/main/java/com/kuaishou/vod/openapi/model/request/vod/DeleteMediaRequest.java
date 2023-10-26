package com.kuaishou.vod.openapi.model.request.vod;

import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuaishou.vod.core.AbstractRequest;

public class DeleteMediaRequest extends AbstractRequest {
    @SerializedName("MediaId")
    @Expose
    public String mediaId;

    @SerializedName("DeleteItems")
    @Expose
    public List<MediaDeleteItem> deleteItems;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public List<MediaDeleteItem> getDeleteItems() {
        return deleteItems;
    }

    public void setDeleteItems(List<MediaDeleteItem> deleteItems) {
        this.deleteItems = deleteItems;
    }

    @Override
    public HashMap<String, String> toMap() {
        HashMap<String, String> map = new HashMap<>();
        map.computeIfAbsent("MediaId", key -> new Gson().toJson(this.mediaId));
        map.computeIfAbsent("DeleteItems", key -> new Gson().toJson(this.deleteItems));
        return map;
    }
}

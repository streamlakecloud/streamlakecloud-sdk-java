package com.kuaishou.vod.openapi.model.request.ai;

import java.util.HashMap;

import com.kuaishou.vod.core.AbstractRequest;


public class BlendFaceRequest extends AbstractRequest {
    public String template;

    public String data;

    public String extraInfo;

    @Override
    public HashMap<String, String> toMap() {
        HashMap<String, String> map = new HashMap<>();
        map.computeIfAbsent("Template", key -> this.template);
        map.computeIfAbsent("Data", key -> this.data);
        map.computeIfAbsent("ExtraInfo", key -> this.extraInfo);
        return map;
    }
}

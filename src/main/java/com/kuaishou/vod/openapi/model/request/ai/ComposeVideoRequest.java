package com.kuaishou.vod.openapi.model.request.ai;

import java.util.HashMap;

import com.kuaishou.vod.core.AbstractRequest;

public class ComposeVideoRequest extends AbstractRequest {
    public String template;

    public String inputURLSet;

    public String callbackURL;

    public String extraInfo;

    @Override
    public HashMap<String, String> toMap() {
        HashMap<String, String> map = new HashMap<>();
        map.computeIfAbsent("Template", key -> this.template);
        map.computeIfAbsent("InputURLSet", key -> this.inputURLSet);
        map.computeIfAbsent("CallbackURL", key -> this.callbackURL);
        map.computeIfAbsent("ExtraInfo", key -> this.extraInfo);
        return map;
    }
}

package com.kuaishou.vod.openapi.model.request.cdn;

import java.util.HashMap;

import com.kuaishou.vod.core.AbstractRequest;

/**
 *
 * Created on 2021-12-13
 */
public class PreloadRequest extends AbstractRequest {

    public String objectPath;

    @Override
    public HashMap<String, String> toMap() {
        HashMap<String, String> map = new HashMap<>();
        map.computeIfAbsent("ObjectPath", key -> this.objectPath);
        return map;
    }
}

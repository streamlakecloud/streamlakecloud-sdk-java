package com.kuaishou.vod.openapi.model.request.cdn;

import java.util.HashMap;

import com.kuaishou.vod.core.AbstractRequest;

public class ListUserDomainsRequest extends AbstractRequest {

    public Integer offset;

    public Integer limit;

    @Override
    public HashMap<String, String> toMap() {
        HashMap<String, String> map = new HashMap<>();
        if (offset != null) {
            map.computeIfAbsent("Offset", key -> String.valueOf(this.offset));
        }
        if (limit != null) {
            map.computeIfAbsent("Limit", key -> String.valueOf(this.limit));
        }
        return map;
    }
}
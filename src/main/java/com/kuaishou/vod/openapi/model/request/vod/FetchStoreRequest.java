package com.kuaishou.vod.openapi.model.request.vod;

import java.util.HashMap;

import com.kuaishou.vod.core.AbstractRequest;

public class FetchStoreRequest extends AbstractRequest {

    public String urlSets;

    @Override
    public HashMap<String, String> toMap() {
        HashMap<String, String> map = new HashMap<>();
        map.computeIfAbsent("URLSets", key -> this.urlSets);
        return map;
    }
}

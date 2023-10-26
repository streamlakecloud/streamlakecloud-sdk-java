package com.kuaishou.vod.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public abstract class AbstractRequest {

    public abstract HashMap<String, String> toMap();

    protected Map<String, String> getPrefixMap(String prefix, Map<String, String> map) {
        HashMap<String, String> newMap = new HashMap<>();
        for (String key: map.keySet()) {
            newMap.put(prefix + "." + key, map.get(key));
        }
        return newMap;
    }

}

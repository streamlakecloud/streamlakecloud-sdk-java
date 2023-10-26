package com.kuaishou.vod.core.cdn;

import java.util.LinkedHashMap;
import java.util.Map;

public class PkeyToolkit {
    private static final String PKEY = "pkey";

    public static Map<String, String> buildPkeyParameter(PkeyRequest request) {
        try {
            Map<String, String> parameters = new LinkedHashMap<>();
            String pkey = DefaultPkeyFormat.getInstance().format(request);
            parameters.put(PKEY, pkey);
            return parameters;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

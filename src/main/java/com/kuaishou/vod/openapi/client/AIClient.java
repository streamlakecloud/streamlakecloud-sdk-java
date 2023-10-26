package com.kuaishou.vod.openapi.client;

import java.io.IOException;

import com.kuaishou.vod.core.AbstractClient;
import com.kuaishou.vod.core.AbstractResponse;
import com.kuaishou.vod.core.Credential;
import com.kuaishou.vod.core.HttpProfile;
import com.kuaishou.vod.core.exception.KuaishouVodSdkException;
import com.kuaishou.vod.openapi.model.request.ai.BlendFaceRequest;
import com.kuaishou.vod.openapi.model.request.ai.ComposeVideoRequest;
import com.kuaishou.vod.openapi.model.response.ai.BlendFaceResponse;
import com.kuaishou.vod.openapi.model.response.ai.ComposeVideoResponse;

public class AIClient extends AbstractClient {
    public AIClient(HttpProfile httpProfile, Credential credential) {
        super(httpProfile, credential);
    }

    public AIClient(HttpProfile httpProfile) {
        super(httpProfile);
    }

    public ComposeVideoResponse composeVideo(ComposeVideoRequest request)
        throws KuaishouVodSdkException, IOException {
        String resp = this.call(request, "ComposeVideo", "POST");
        return AbstractResponse.fromJson(resp, ComposeVideoResponse.class);
    }

    public BlendFaceResponse blendFace(BlendFaceRequest request)
        throws KuaishouVodSdkException, IOException {
        String resp = this.call(request, "BlendFace", "POST");
        return AbstractResponse.fromJson(resp, BlendFaceResponse.class);
    }
}

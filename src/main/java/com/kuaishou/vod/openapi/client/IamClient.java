package com.kuaishou.vod.openapi.client;

import static com.kuaishou.vod.core.AbstractResponse.assumeRoleResponse;

import java.io.IOException;

import com.kuaishou.vod.core.AbstractClient;
import com.kuaishou.vod.core.Credential;
import com.kuaishou.vod.core.HttpProfile;
import com.kuaishou.vod.core.exception.KuaishouVodSdkException;
import com.kuaishou.vod.openapi.model.request.iam.AssumeRoleRequest;
import com.kuaishou.vod.openapi.model.response.iam.AssumeRoleResponse;

public class IamClient extends AbstractClient {
    public IamClient(HttpProfile httpProfile, Credential credential) {
        super(httpProfile, credential);
    }

    public IamClient(HttpProfile httpProfile) {
        super(httpProfile);
    }

    public AssumeRoleResponse assumeRole(AssumeRoleRequest request) throws KuaishouVodSdkException,
            IOException {
        String resp = this.callByJson(request, "AssumeRole", "POST");
        return ((AssumeRoleResponse)assumeRoleResponse().fromJson(resp));
    }
}

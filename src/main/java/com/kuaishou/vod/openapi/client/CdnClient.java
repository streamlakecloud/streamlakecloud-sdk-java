package com.kuaishou.vod.openapi.client;

import static com.kuaishou.vod.core.AbstractResponse.listUserDomainsResponse;
import static com.kuaishou.vod.core.AbstractResponse.preloadResponse;
import static com.kuaishou.vod.core.AbstractResponse.pushPCDNObjectCacheResponse;
import static com.kuaishou.vod.core.AbstractResponse.queryStatusResponse;
import static com.kuaishou.vod.core.AbstractResponse.refreshResponse;

import java.io.IOException;

import com.kuaishou.vod.core.AbstractClient;
import com.kuaishou.vod.core.Credential;
import com.kuaishou.vod.core.HttpProfile;
import com.kuaishou.vod.core.exception.KuaishouVodSdkException;
import com.kuaishou.vod.openapi.model.request.cdn.ListUserDomainsRequest;
import com.kuaishou.vod.openapi.model.request.cdn.PreloadRequest;
import com.kuaishou.vod.openapi.model.request.cdn.PushPCDNObjectCacheRequest;
import com.kuaishou.vod.openapi.model.request.cdn.QueryStatusRequest;
import com.kuaishou.vod.openapi.model.request.cdn.RefreshRequest;
import com.kuaishou.vod.openapi.model.response.cdn.ListUserDomainsResponse;
import com.kuaishou.vod.openapi.model.response.cdn.PreloadResponse;
import com.kuaishou.vod.openapi.model.response.cdn.PushPCDNObjectCacheResponse;
import com.kuaishou.vod.openapi.model.response.cdn.QueryStatusResponse;
import com.kuaishou.vod.openapi.model.response.cdn.RefreshResponse;

/**
 *
 * Created on 2021-12-13
 */
public class CdnClient extends AbstractClient {
    public CdnClient(HttpProfile httpProfile, Credential credential) {
        super(httpProfile, credential);
    }

    public CdnClient(HttpProfile httpProfile) {
        super(httpProfile);
    }

    public PreloadResponse preload(PreloadRequest request)
        throws KuaishouVodSdkException, IOException {
        String resp = this.call(request, "PreloadObjectCaches", "POST");
        return (PreloadResponse) preloadResponse().fromJson(resp);
    }

    public RefreshResponse refresh(RefreshRequest request) throws KuaishouVodSdkException, IOException {
        String resp = this.call(request, "RefreshObjectCaches", "POST");
        return (RefreshResponse) refreshResponse().fromJson(resp);
    }

    public QueryStatusResponse queryStatus(QueryStatusRequest request) throws KuaishouVodSdkException, IOException {
        String resp = this.call(request, "DescribeRefreshTasks", "POST");
        return (QueryStatusResponse) queryStatusResponse().fromJson(resp);
    }

    public ListUserDomainsResponse listUserDomains(ListUserDomainsRequest request) throws KuaishouVodSdkException, IOException {
        String resp = this.call(request, "ListUserDomains", "POST");
        return ((ListUserDomainsResponse) listUserDomainsResponse().fromJson(resp));
    }

    public PushPCDNObjectCacheResponse pushPCDNCache(PushPCDNObjectCacheRequest request) throws KuaishouVodSdkException, IOException {
        String resp = this.callByJson(request, "PushPCDNObjectCache", "POST");
        return ((PushPCDNObjectCacheResponse) pushPCDNObjectCacheResponse().fromJson(resp));
    }
}

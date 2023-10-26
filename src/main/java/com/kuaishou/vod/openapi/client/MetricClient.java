package com.kuaishou.vod.openapi.client;

import java.io.IOException;

import com.kuaishou.vod.core.AbstractClient;
import com.kuaishou.vod.core.AbstractResponse;
import com.kuaishou.vod.core.Credential;
import com.kuaishou.vod.core.HttpProfile;
import com.kuaishou.vod.core.exception.KuaishouVodSdkException;
import com.kuaishou.vod.openapi.model.request.vod.DescribeDomainUsageDataRequest;
import com.kuaishou.vod.openapi.model.request.vod.DescribeMpsUsageDataRequest;
import com.kuaishou.vod.openapi.model.request.vod.DescribeStorageUsageDataRequest;
import com.kuaishou.vod.openapi.model.response.vod.DescribeDomainUsageDataResponse;
import com.kuaishou.vod.openapi.model.response.vod.DescribeMpsUsageDataResponse;
import com.kuaishou.vod.openapi.model.response.vod.DescribeStorageUsageDataResponse;

public class MetricClient extends AbstractClient {

    public MetricClient(HttpProfile httpProfile, Credential credential) {
        super(httpProfile, credential);
    }

    public DescribeStorageUsageDataResponse describeStorageUsageData(DescribeStorageUsageDataRequest request) throws KuaishouVodSdkException, IOException {
        String resp = this.call(request, "DescribeStorageUsageData", "POST");
        return AbstractResponse.fromJson(resp, DescribeStorageUsageDataResponse.class);
    }

    public DescribeDomainUsageDataResponse describeDomainUsageData(DescribeDomainUsageDataRequest request) throws KuaishouVodSdkException, IOException {
        String resp = this.call(request, "DescribeDomainUsageData", "POST");
        return AbstractResponse.fromJson(resp, DescribeDomainUsageDataResponse.class);
    }

    public DescribeMpsUsageDataResponse describeMpsUsageData(DescribeMpsUsageDataRequest request) throws KuaishouVodSdkException, IOException {
        String resp = this.call(request, "DescribeMpsUsageData", "POST");
        return AbstractResponse.fromJson(resp, DescribeMpsUsageDataResponse.class);
    }

}

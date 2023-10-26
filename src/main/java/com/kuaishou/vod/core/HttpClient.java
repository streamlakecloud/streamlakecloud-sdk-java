package com.kuaishou.vod.core;

import java.io.IOException;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import com.kuaishou.vod.core.exception.KuaishouVodSdkException;

public class HttpClient {

    private CloseableHttpClient client;

    private PoolingHttpClientConnectionManager connectionManager;

    private HttpProfile httpProfile;

    public HttpClient() {
        init(HttpProfile.getDefault());
    }

    public HttpClient(HttpProfile httpProfile) {
        init(httpProfile);
    }

    public void init(final HttpProfile httpProfile) {
        if (httpProfile == null) {
            this.httpProfile = HttpProfile.getDefault();
        }
        this.httpProfile = httpProfile;
        HttpClientBuilder clientBuilder = HttpClientBuilder.create();
        RequestConfig config = RequestConfig.custom()
            .setConnectTimeout((int) httpProfile.getConnectionTimeout())
            .setConnectionRequestTimeout((int) httpProfile.getConnectionRequestTimeout())
            .setSocketTimeout((int) httpProfile.getSocketTimeout())
            .build();
        clientBuilder.setDefaultRequestConfig(config);

        //init connection manager
        initConnectionManager();
        clientBuilder.setConnectionManager(connectionManager);

        //retry
        if (httpProfile.isRequestRetryEnabled()) {
            clientBuilder.setRetryHandler(new DefaultHttpRequestRetryHandler(httpProfile.getRequestRetryTimes(), true));
        } else {
            clientBuilder.setRetryHandler(new DefaultHttpRequestRetryHandler(0, false));
        }


        // keepAlive
        if (httpProfile.getKeepAliveDurationMillis() > 0) {
            clientBuilder.setKeepAliveStrategy((response, context) -> {
                long duration = DefaultConnectionKeepAliveStrategy.INSTANCE.getKeepAliveDuration(response, context);

                if (duration > 0 && duration < httpProfile.getKeepAliveDurationMillis()) {
                    return duration;
                } else {
                    return httpProfile.getKeepAliveDurationMillis();
                }
            });
        }

        client = clientBuilder.build();
    }

    public void initConnectionManager() {
        connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(httpProfile.getMaxRequests());
        connectionManager.setDefaultMaxPerRoute(httpProfile.getMaxRequestsPerHost());
    }

    public CloseableHttpResponse getRequest(HttpGet request) throws KuaishouVodSdkException, IOException {
        try {
            return this.client.execute(request);
        } catch (Exception e) {
            throw new KuaishouVodSdkException(e.getClass().getName() + "-" + e.getMessage());
        }
    }

    public CloseableHttpResponse postRequest(HttpPost request)
        throws KuaishouVodSdkException {
        try {
            return this.client.execute(request);
        } catch (Exception e) {
            throw new KuaishouVodSdkException(e.getClass().getName() + "-" + e.getMessage());
        }
    }
}

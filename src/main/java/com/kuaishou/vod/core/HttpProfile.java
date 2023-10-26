package com.kuaishou.vod.core;

public class HttpProfile {
    /**
     * endpoint
     */
    private String endPoint = "vod.streamlakeapi.com";

    /**
     * connectionPool
     **/
    private int maxIdleConnections = 128;
    private long maxIdleTimeMillis = 60 * 1000L;

    /**
     * dispatcher
     **/
    private int maxRequests = 128;
    private int maxRequestsPerHost = 128;
    /**
     * keepAlive timeout
     */
    private long keepAliveDurationMillis = 5000L;
    /**
     * timeout
     **/
    private long connectionTimeout = 5000;
    private long socketTimeout = 10000;
    private long connectionRequestTimeout = 60 * 1000L;
    /**
     * retry
     * */
    private boolean requestRetryEnabled = false;
    private int requestRetryTimes = 0;


    public static HttpProfile getDefault() {
        return new HttpProfile();
    }

    public int getMaxRequests() {
        return maxRequests;
    }

    public void setMaxRequests(int maxRequests) {
        this.maxRequests = maxRequests;
    }

    public int getMaxRequestsPerHost() {
        return maxRequestsPerHost;
    }

    public void setMaxRequestsPerHost(int maxRequestsPerHost) {
        this.maxRequestsPerHost = maxRequestsPerHost;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public int getMaxIdleConnections() {
        return maxIdleConnections;
    }

    public void setMaxIdleConnections(int maxIdleConnections) {
        this.maxIdleConnections = maxIdleConnections;
    }

    public long getMaxIdleTimeMillis() {
        return maxIdleTimeMillis;
    }

    public void setMaxIdleTimeMillis(long maxIdleTimeMillis) {
        this.maxIdleTimeMillis = maxIdleTimeMillis;
    }

    public long getKeepAliveDurationMillis() {
        return keepAliveDurationMillis;
    }

    public void setKeepAliveDurationMillis(long keepAliveDurationMillis) {
        this.keepAliveDurationMillis = keepAliveDurationMillis;
    }

    public long getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(long connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public long getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(long socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public long getConnectionRequestTimeout() {
        return connectionRequestTimeout;
    }

    public void setConnectionRequestTimeout(long connectionRequestTimeout) {
        this.connectionRequestTimeout = connectionRequestTimeout;
    }

    public boolean isRequestRetryEnabled() {
        return requestRetryEnabled;
    }

    public void setRequestRetryEnabled(boolean requestRetryEnabled) {
        this.requestRetryEnabled = requestRetryEnabled;
    }

    public int getRequestRetryTimes() {
        return requestRetryTimes;
    }

    public void setRequestRetryTimes(int requestRetryTimes) {
        this.requestRetryTimes = requestRetryTimes;
    }
}

package com.kuaishou.vod.base;

public class SignatureVO {
    /**
     * StreamLake密钥ak
     */
    private String accessKeyId;
    /**
     * StreamLake密钥sk
     */
    private String accessKeySecret;
    /**
     * StreamLake加签算法
     */
    private String algorithm;
    /**
     * StreamLake 服务编码
     */
    private String service;
    /**
     * StreamLake request host
     */
    private String host;
    /**
     * StreamLake request content-type
     */
    private String contentType;
    /**
     * StreamLake request region
     */
    private String region;
    /**
     * StreamLake request action
     */
    private String action;
    /**
     * StreamLake request version
     */
    private String version;

    /**
     * HTTP 请求方法（GET、POST ）
     */
    private String httpRequestMethod;
    /**
     * 发起 HTTP 请求 URL 中的查询字符串，
     * 对于 POST 请求，固定为空字符串""，
     * 对于 GET 请求，则为 URL 中问号（?）后面的字符串内容，例如：Limit=10&Offset=0。
     */
    private String canonicalQueryString;

    /**
     * 参与签名的头部信息，
     * 至少包含 host 和 content-type 两个头部，
     * 也可加入自定义的头部参与签名以提高自身请求的唯一性和安全性。
     */
    private String canonicalHeaders;
    /**
     * 参与签名的头部信息，说明此次请求有哪些头部参与了签名，
     * 和 CanonicalHeaders 包含的头部内容是一一对应的。
     * content-type 和 host 为必选头部。
     */
    private String signedHeaders;

    /**
     * 请求正文
     */
    private String payload;

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getHttpRequestMethod() {
        return httpRequestMethod;
    }

    public void setHttpRequestMethod(String httpRequestMethod) {
        this.httpRequestMethod = httpRequestMethod;
    }

    public String getCanonicalQueryString() {
        return canonicalQueryString;
    }

    public void setCanonicalQueryString(String canonicalQueryString) {
        this.canonicalQueryString = canonicalQueryString;
    }

    public String getCanonicalHeaders() {
        return canonicalHeaders;
    }

    public void setCanonicalHeaders(String canonicalHeaders) {
        this.canonicalHeaders = canonicalHeaders;
    }

    public String getSignedHeaders() {
        return signedHeaders;
    }

    public void setSignedHeaders(String signedHeaders) {
        this.signedHeaders = signedHeaders;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public SignatureVO() {
    }
}

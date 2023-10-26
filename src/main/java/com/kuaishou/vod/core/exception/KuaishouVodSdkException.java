package com.kuaishou.vod.core.exception;

public class KuaishouVodSdkException extends Exception {

    private String code;

    private String requestId;

    public KuaishouVodSdkException(String message) {
        this(message, "");
    }

    public KuaishouVodSdkException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public KuaishouVodSdkException(String message, String requestId) {
        this(message, requestId, "");
    }

    public KuaishouVodSdkException(String message, String requestId, Throwable throwable) {
        super(message, throwable);
        this.requestId = requestId;
    }

    public KuaishouVodSdkException(String message, String requestId, String code) {
        super(message);
        this.requestId = requestId;
        this.code = code;
    }

    public KuaishouVodSdkException(String message, String requestId, String code, Throwable throwable) {
        super(message, throwable);
        this.requestId = requestId;
        this.code = code;
    }

    public KuaishouVodSdkException(Throwable throwable) {
        super(throwable);
    }

    public String getCode() {
        return code;
    }

    public String getRequestId() {
        return requestId;
    }

    public String toString() {
        return "[KuaishouVodSdkException]code: "
            + this.code
            + " message: "
            + this.getMessage()
            + " requestId: "
            + this.requestId;
    }
}

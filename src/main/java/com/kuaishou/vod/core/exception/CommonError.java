package com.kuaishou.vod.core.exception;

public enum CommonError {
    INVALID_HTTP_METHOD("InvalidParameter.Method", "Method parameters are invalid.");

    public final String code;
    public final String message;

    CommonError(String code, String message) {
        this.code = code;
        this.message = message;
    }
}

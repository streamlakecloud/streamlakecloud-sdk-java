package com.kuaishou.vod.core.cdn;

/**
 *
 * Created on 2021-07-09
 */
public class ExtraInfo {

    private String clientIp;

    private int ttl;

    public ExtraInfo(Builder builder) {
        this.clientIp = builder.clientIp;
        this.ttl = builder.ttl;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public static Builder toBuilder() {
        return new Builder();
    }

    public static class Builder {
        private String clientIp = "0.0.0.0";
        private int ttl = 24 * 3600;
        public Builder setClientIp(String clientIp) {
            this.clientIp = clientIp;
            return this;
        }

        public Builder setTtl(int ttl) {
            this.ttl = ttl;
            return this;
        }

        public ExtraInfo build() {
            return new ExtraInfo(this);
        }
    }
}

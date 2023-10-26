package com.kuaishou.vod.core.play;

/**
 *
 * Created on 2022-02-15
 */

public class UrlAuthInfo {
    private long expireTime;
    private long previewTime;

    public long getExpireTime() {
        return expireTime;
    }

    public long getPreviewTime() {
        return previewTime;
    }

    public static Builder toBuilder() {
        return new Builder();
    }
    
    public static final class Builder {
        private long expireTime;
        private long previewTime;

        private Builder() {
        }

        public static Builder anUrlAuthInfo() {
            return new Builder();
        }

        public Builder setExpireTime(long expireTime) {
            this.expireTime = expireTime;
            return this;
        }

        public Builder setPreviewTime(long previewTime) {
            this.previewTime = previewTime;
            return this;
        }

        public UrlAuthInfo build() {
            UrlAuthInfo urlAuthInfo = new UrlAuthInfo();
            urlAuthInfo.expireTime = this.expireTime;
            urlAuthInfo.previewTime = this.previewTime;
            return urlAuthInfo;
        }
    }
}

package com.kuaishou.vod.core.play;

/**
 *
 * Created on 2022-02-14
 */
public class PlayTokenReq {
    private String domain;
    private String domainKey;
    private String mediaId;
    private long duration;
    private UrlAuthInfo urlAuthInfo;

    public String getDomain() {
        return domain;
    }

    public String getDomainKey() {
        return domainKey;
    }

    public String getMediaId() {
        return mediaId;
    }

    public long getDuration() {
        return duration;
    }

    public UrlAuthInfo getUrlAuthInfo() {
        return urlAuthInfo;
    }

    public static Builder toBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private String domain;
        private String domainKey;
        private String mediaId;
        private long duration;
        private UrlAuthInfo urlAuthInfo;

        private Builder() {
        }

        public static Builder aPlayTokenReq() {
            return new Builder();
        }

        public Builder setDomain(String domain) {
            this.domain = domain;
            return this;
        }

        public Builder setDomainKey(String domainKey) {
            this.domainKey = domainKey;
            return this;
        }

        public Builder setMediaId(String mediaId) {
            this.mediaId = mediaId;
            return this;
        }

        public Builder setDuration(long duration) {
            this.duration = duration;
            return this;
        }

        public Builder setUrlAuthInfo(UrlAuthInfo urlAuthInfo) {
            this.urlAuthInfo = urlAuthInfo;
            return this;
        }

        public PlayTokenReq build() {
            PlayTokenReq playTokenReq = new PlayTokenReq();
            playTokenReq.domain = this.domain;
            playTokenReq.urlAuthInfo = this.urlAuthInfo;
            playTokenReq.domainKey = this.domainKey;
            playTokenReq.mediaId = this.mediaId;
            playTokenReq.duration = this.duration;
            return playTokenReq;
        }
    }

}

package com.kuaishou.vod.core.cdn;

import java.net.InetAddress;
import java.net.URI;
import java.util.Objects;

public class PkeyRequest {
    private URI uri;
    /** 密钥信息 */
    private CryptoKey cryptoKey;
    /** 服务ID */
    private short serviceId;
    /** 平台类型，Android or IOS... */
    private short platformId;
    /** 加密的ID要求能够关联客户端的行为数据或者风控类信息, length <= Short.MAX_VALUE */
    private String gid;
    /** IPv4 or IPv6 */
    private InetAddress ipAddress;
    /** 加密key有效期(单位 秒) */
    private int ttl;
    /** 播放限制的速度(单位 KB)，0 表示不限速 */
    private short limitSpeeds;
    /** 播放限制的时长(单位 秒)，0 表示不限时 */
    private short limitTimeSeconds;
    /** HLS可播放分片的上限，0 表示不限制 */
    private short limitTSIdx;

    public static Builder newBuilder() {
        return new Builder();
    }

    private PkeyRequest(Builder builder) {
        Objects.requireNonNull(builder.uri, "uri must not be null");
        Objects.requireNonNull(builder.cryptoKey, "cryptoKey must not be null");
        this.uri = builder.uri;
        this.cryptoKey = builder.cryptoKey;
        this.serviceId = builder.serviceId;
        this.platformId = builder.platformId;
        this.gid = builder.gid;
        this.ipAddress = builder.ipAddress;
        this.ttl = builder.ttl;
        this.limitSpeeds = builder.limitSpeeds;
        this.limitTimeSeconds = builder.limitTimeSeconds;
        this.limitTSIdx = builder.limitTSIdx;
    }

    public URI getUri() {
        return uri;
    }

    public CryptoKey getCryptoKey() {
        return cryptoKey;
    }

    public short getServiceId() {
        return serviceId;
    }

    public short getPlatformId() {
        return platformId;
    }

    public String getGid() {
        return gid;
    }

    public InetAddress getIpAddress() {
        return ipAddress;
    }

    public int getTtl() {
        return ttl;
    }

    public short getLimitSpeeds() {
        return limitSpeeds;
    }

    public short getLimitTimeSeconds() {
        return limitTimeSeconds;
    }

    public short getLimitTSIdx() {
        return limitTSIdx;
    }

    public static class CryptoKey {
        private final String aesKey;
        private final String aesIv;

        public CryptoKey(String aesKey, String aesIv) {
            this.aesKey = aesKey;
            this.aesIv = aesIv;
        }

        public static CryptoKey of(String aesKey, String aesIv) {
            return new CryptoKey(aesKey, aesIv);
        }

        public String getAesKey() {
            return aesKey;
        }

        public String getAesIv() {
            return aesIv;
        }
    }

    public static final class Builder {
        private URI uri;
        private CryptoKey cryptoKey;
        private short serviceId;
        private short platformId;
        private String gid;
        private InetAddress ipAddress;
        private int ttl;
        private short limitSpeeds;
        private short limitTimeSeconds;
        private short limitTSIdx;

        private Builder() {
        }

        public Builder withUri(URI uri) {
            this.uri = uri;
            return this;
        }

        public Builder withCryptoKey(CryptoKey cryptoKey) {
            this.cryptoKey = cryptoKey;
            return this;
        }

        public Builder withServiceId(short serviceId) {
            this.serviceId = serviceId;
            return this;
        }

        public Builder withPlatformId(short platformId) {
            this.platformId = platformId;
            return this;
        }

        public Builder withGid(String gid) {
            this.gid = gid;
            return this;
        }

        public Builder withIpAddress(InetAddress ipAddress) {
            this.ipAddress = ipAddress;
            return this;
        }

        public Builder withTtl(int ttl) {
            this.ttl = ttl;
            return this;
        }

        public Builder withLimitSpeeds(short limitSpeeds) {
            this.limitSpeeds = limitSpeeds;
            return this;
        }

        public Builder withLimitTimeSeconds(short limitTimeSeconds) {
            this.limitTimeSeconds = limitTimeSeconds;
            return this;
        }

        public Builder withLimitTSIdx(short limitTSIdx) {
            this.limitTSIdx = limitTSIdx;
            return this;
        }

        public PkeyRequest build() {
            return new PkeyRequest(this);
        }
    }
}

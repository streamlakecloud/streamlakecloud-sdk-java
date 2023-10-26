package com.kuaishou.vod.core.cdn;

import static com.kuaishou.vod.core.cdn.PkeyToolkit.buildPkeyParameter;

import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.kuaishou.vod.core.cdn.PkeyRequest.CryptoKey;

public class CdnClient {
    public String key;
    public String iv;

    public CdnClient(String key, String iv) {
        this.key = key;
        this.iv = iv;
    }

    public String signCdnUrl(String originalUrl, ExtraInfo extraInfo) throws UnknownHostException {
        PkeyRequest request = PkeyRequest.newBuilder()
            .withUri(URI.create(originalUrl))
            .withCryptoKey(CryptoKey.of(this.key, this.iv))
            .withTtl(extraInfo.getTtl())
            .withIpAddress(InetAddress.getByName(extraInfo.getClientIp()))
            .build();
        Map<String, String> parameters = buildPkeyParameter(request);
        String pkey = parameters.get("pkey");
        return originalUrl + "?pkey=" + pkey;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

}

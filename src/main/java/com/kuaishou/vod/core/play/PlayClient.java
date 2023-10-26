package com.kuaishou.vod.core.play;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.kuaishou.vod.core.Credential;
import com.kuaishou.vod.core.exception.KuaishouVodSdkException;

/**
 * Created on 2022-02-14
 */
public class PlayClient {
    //v1
    public String generatePlayToken(PlayTokenReq req, Credential credential)
        throws KuaishouVodSdkException {
        String domainKey = req.getDomainKey();
        Algorithm algorithm = Algorithm.HMAC256(domainKey);
        //get accessKey from kta

        Map<String, Object> credentialMap = credential.generateStsToken(req.getDuration());
        String stsToken = (String) credentialMap.get("sessionToken");
        double expireTime = (double) credentialMap.get("expiration");
        String tmpAccessKey = (String) credentialMap.get("accessKeyId");
        String tmpSecretKey = (String) credentialMap.get("accessKeySecret");
        Map<String, Object> stsMap = new HashMap<>();
        stsMap.put("TempAccessKey", tmpAccessKey);
        stsMap.put("TempSecretKey", tmpSecretKey);
        stsMap.put("SecurityToken", stsToken);
        stsMap.put("CreateTime", System.currentTimeMillis() / 1000);
        stsMap.put("ExpireTime", (long) expireTime / 1000);
        stsMap.put("StsTokenVer", 2);
        Map<String, Object> urlAuthMap = new HashMap<>();
        UrlAuthInfo authInfo = req.getUrlAuthInfo();
        if (authInfo != null) {
            if (authInfo.getExpireTime() > 0) {
                urlAuthMap.put("ExpireTime", authInfo.getExpireTime());
            }
            if (authInfo.getPreviewTime() > 0) {
                urlAuthMap.put("PreviewTime", authInfo.getPreviewTime());
            }
        }

        JWTCreator.Builder builder = JWT.create().withClaim("StsToken", stsMap)
            .withClaim("Domain", req.getDomain()).withClaim("UrlAuthInfo", urlAuthMap);
        if (StringUtils.isNotEmpty(req.getMediaId())) {
            builder.withClaim("MediaId", req.getMediaId());
        }
        return builder.sign(algorithm);
    }
}

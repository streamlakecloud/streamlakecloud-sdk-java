package com.kuaishou.vod.core;

import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.kuaishou.vod.core.exception.KuaishouVodSdkException;

public class Credential {

    private static final Gson gson = new Gson();
    protected int offset;
    protected String accessKeyId;
    protected String secretKey;
    protected String accessToken;
    protected long expireTime;
    protected String ktaEndPoint;
    protected HttpClient httpClient;
    protected String accessTokenUrl;

    public Credential(String accessKeyId, String secretKey) {
        this.accessKeyId = accessKeyId;
        this.secretKey = secretKey;
        this.offset = 30;
        this.ktaEndPoint = "is-gateway.corp.kuaishou.com";
        this.httpClient = new HttpClient();
    }

    public Credential(String accessKeyId, String secretKey, long expireTime) {
        this.accessKeyId = accessKeyId;
        this.secretKey = secretKey;
        this.ktaEndPoint = "is-gateway.corp.kuaishou.com";
        this.expireTime = expireTime;
        this.httpClient = new HttpClient();
    }

    public String getKtaEndPoint() {
        return this.ktaEndPoint;
    }

    public void setKtaEndPoint(String ktaEndPoint) {
        this.ktaEndPoint = ktaEndPoint;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getAccessTokenUrl() {
        return this.accessTokenUrl;
    }

    public void setAccessTokenUrl(String accessTokenUrl) {
        this.accessTokenUrl = accessTokenUrl;
    }

    public String getStsTokenUrl() {
        return "https://" + this.ktaEndPoint + "/saas-proxy/api/v1/session-token/generate";
    }

    public boolean needRefresh() {
        if (this.expireTime < System.currentTimeMillis()) {
            return true;
        } else {
            return false;
        }
    }

    public Pair<String, Long> updateAccessToken() throws KuaishouVodSdkException {
        if (needRefresh()) {
            try {
                HttpGet httpPost = new HttpGet(this.getAccessTokenUrl());
                CloseableHttpResponse response = httpClient.getRequest(httpPost);

                String responseInStr = EntityUtils.toString(response.getEntity());
                Map<String, Object> objectMap = gson.fromJson(responseInStr, Map.class);
                Map<String, Object> resultMap = (Map<String, Object>) objectMap.get("result");
                this.accessToken = (String) resultMap.get("accessToken");
                double expireTime = (double) resultMap.get("expireTime");
                this.expireTime = System.currentTimeMillis() / 1000 - offset + (int) expireTime;
            } catch (Exception ex) {
                throw new KuaishouVodSdkException(ex.getMessage(), ex);
            }
        }
        return Pair.of(this.accessToken, this.expireTime);

    }


    public Map<String, Object> generateStsToken(long duration) throws KuaishouVodSdkException {
        try {
            //获取accessToken
            Pair<String, Long> accessTokenPair = updateAccessToken();
            HttpPost httpPost = new HttpPost(getStsTokenUrl());
            httpPost.addHeader("Authorization", "Bearer " + accessTokenPair.getLeft());
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("accessKeyId", this.accessKeyId);
            if (duration > 0) {
                jsonObject.addProperty("duration", duration);
            }
            httpPost.setEntity(new StringEntity(jsonObject.toString(), ContentType.APPLICATION_JSON));
            CloseableHttpResponse response = httpClient.postRequest(httpPost);

            String responseInStr = EntityUtils.toString(response.getEntity());
            Map<String, Object> objectMap = gson.fromJson(responseInStr, Map.class);
            return (Map<String, Object>) objectMap.get("result");
        } catch (Exception ex) {
            throw new KuaishouVodSdkException(ex.getMessage(), ex);
        }

    }

}

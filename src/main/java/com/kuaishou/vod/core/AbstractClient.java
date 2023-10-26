package com.kuaishou.vod.core;

import static com.kuaishou.vod.base.Constant.CONTENT_TYPE_FORM;
import static com.kuaishou.vod.base.Constant.CONTENT_TYPE_JSON;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

import com.google.gson.Gson;
import com.kuaishou.vod.base.SignatureHelper;
import com.kuaishou.vod.base.SignatureVO;
import com.kuaishou.vod.core.exception.CommonError;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.kuaishou.vod.core.exception.KuaishouVodSdkException;

public abstract class AbstractClient {

    private HttpClient httpClient;
    private HttpProfile httpProfile;
    private Credential credential;

    public AbstractClient(HttpProfile httpProfile, Credential credential) {
        this.httpProfile = httpProfile;
        this.credential = credential;
        httpClient = new HttpClient(httpProfile);
    }

    public AbstractClient(HttpProfile httpProfile) {
        this.httpProfile = httpProfile;
        httpClient = new HttpClient();
    }

    private String getServiceUrl(String serviceName) {
        return "https://" + this.httpProfile.getEndPoint() + "/?Action=" + serviceName;
    }

    private void sign(AbstractHttpMessage httpMessage, String action, String method, String contentType,
            String payload, String query) throws KuaishouVodSdkException {
        SignatureVO signatureVO = new SignatureVO();
        signatureVO.setAccessKeyId(this.credential.getAccessKeyId());
        signatureVO.setAccessKeySecret(this.credential.getSecretKey());
        signatureVO.setAlgorithm("SL-HMAC-SHA256");
        signatureVO.setAction(action);
        signatureVO.setHost(this.httpProfile.getEndPoint());
        signatureVO.setContentType(contentType);
        signatureVO.setRegion("beijing");
        signatureVO.setVersion("2022-06-23");
        signatureVO.setService("vod");
        signatureVO.setCanonicalHeaders("content-type:" + contentType + "\nhost:" + this.httpProfile.getEndPoint());
        signatureVO.setCanonicalQueryString(query);
        signatureVO.setHttpRequestMethod(method);
        signatureVO.setSignedHeaders("content-type;host");
        signatureVO.setPayload(payload);
        try {
            Map<String, String> header = SignatureHelper.sign(signatureVO);
            for (String key : header.keySet()) {
                httpMessage.setHeader(key, header.get(key));
            }
        } catch (Exception e) {
            throw new KuaishouVodSdkException("InternalError", e);
        }
    }

    public String call(AbstractRequest request, String action, String method)
            throws KuaishouVodSdkException, IOException {
        return call(request, action, method, CONTENT_TYPE_FORM, null);
    }

    public String callByJson(AbstractRequest request, String action, String method)
            throws KuaishouVodSdkException, IOException {
        return call(request, action, method, CONTENT_TYPE_JSON, null);
    }

    public String callByJsonV2(AbstractRequest request, String action, String method, Map<String, String> headerInfo)
            throws KuaishouVodSdkException, IOException {
        return call(request, action, method, CONTENT_TYPE_JSON, headerInfo);
    }

    public String call(AbstractRequest request, String action, String method, String contentType, Map<String, String> headerInfo)
        throws KuaishouVodSdkException, IOException {
        CloseableHttpResponse resp;
        String url = getServiceUrl(action);
        HashMap<String, String> map = request.toMap();
        String requestData = formatGetRequestData(map);
        if (method.equals("GET")) {
            HttpGet httpGet = new HttpGet(url + "&" + requestData);
            sign(httpGet, action, method, contentType, "", "Action=" + action + "&" + requestData);
            if (headerInfo != null && !headerInfo.isEmpty()) {
                for (Map.Entry<String, String> entry : headerInfo.entrySet()) {
                    httpGet.setHeader(entry.getKey(), entry.getValue());
                }
            }
            resp = httpClient.getRequest(httpGet);
        } else if (method.equals("POST")) {
            HttpPost httpPost = new HttpPost(url);
            if (contentType.equals(CONTENT_TYPE_JSON)) {
                String payload = new Gson().toJson(request);
                httpPost.setEntity(new StringEntity(payload, ContentType.APPLICATION_JSON));
                sign(httpPost, action, method, contentType, payload, "Action=" + action);
            } else if (contentType.equals(CONTENT_TYPE_FORM)) {
                List<NameValuePair> params = formatPostRequestData(map);
                httpPost.setEntity(new UrlEncodedFormEntity(params));
                sign(httpPost, action, method, contentType, requestData, "Action=" + action);
            }
            if (headerInfo != null && !headerInfo.isEmpty()) {
                for (Map.Entry<String, String> entry : headerInfo.entrySet()) {
                    httpPost.setHeader(entry.getKey(), entry.getValue());
                }
            }
            resp = httpClient.postRequest(httpPost);
        } else {
            throw new KuaishouVodSdkException(CommonError.INVALID_HTTP_METHOD.code, CommonError.INVALID_HTTP_METHOD.message);
        }
        return
            EntityUtils.toString(resp.getEntity(), "UTF-8");
    }

    private String formatGetRequestData(Map<String, String> param)
        throws KuaishouVodSdkException {
        List<String> list = new LinkedList<>();
        try {
            for (Map.Entry<String, String> entry : param.entrySet()) {
                String value = URLEncoder.encode(entry.getKey(), "utf-8") + "=" + URLEncoder.encode(entry.getValue(), "utf-8");
                list.add(value);
            }
        } catch (Exception e) {
            throw new KuaishouVodSdkException(e.getClass().getName() + "-" + e.getMessage());
        }

        return StringUtils.join(list, "&");
    }

    private List<NameValuePair> formatPostRequestData(Map<String, String> params) {
        List<NameValuePair> result = new ArrayList<>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            result.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        return result;
    }


}

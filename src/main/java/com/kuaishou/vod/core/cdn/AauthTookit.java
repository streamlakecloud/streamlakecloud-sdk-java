package com.kuaishou.vod.core.cdn;

import java.math.BigInteger;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * Created on 2022-02-07
 */
public class AauthTookit {

    public static String aAuth(String uri, String key, long exp, String rand, String uid) {
        String pattern = "^(http://|https://)?([^/?]+)(/[^?]*)?(\\\\?.*)?$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(uri);
        String scheme = "", host = "", path = "", args = "";
        if (m.find()) {
            scheme = m.group(1) == null ? "http://" : m.group(1);
            host = m.group(2) == null ? "" : m.group(2);
            path = m.group(3) == null ? "/" : m.group(3);
            args = m.group(4) == null ? "" : m.group(4);
        }

        String sString = String.format("%s-%s-%s-%s-%s", path, exp, rand, uid, key);
        String hashValue = md5Sum(sString);
        String authKey = String.format("%s-%s-%s-%s", exp, rand, uid, hashValue);
        if (args.isEmpty()) {
            return String.format("%s%s%s%s?auth_key=%s", scheme, host, path, args, authKey);
        } else {
            return String.format("%s%s%s%s&auth_key=%s", scheme, host, path, args, authKey);
        }
    }

    public static String aAuthWithPreviewTime(String uri, String key, long exp, String rand, String uid, long previewTime) {
        String pattern = "^(http://|https://)?([^/?]+)(/[^?]*)?(\\\\?.*)?$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(uri);
        String scheme = "", host = "", path = "", args = "";
        if (m.find()) {
            scheme = m.group(1) == null ? "http://" : m.group(1);
            host = m.group(2) == null ? "" : m.group(2);
            path = m.group(3) == null ? "/" : m.group(3);
            args = m.group(4) == null ? "" : m.group(4);
        }

        String sString = String.format("%s-%s-%s-%s-%s", path, exp, rand, uid, key);
        if (previewTime != 0L) {
            sString += "-" + previewTime;
        }
        String hashValue = md5Sum(sString);
        String authKey = String.format("%s-%s-%s-%s", exp, rand, uid, hashValue);
        if (args.isEmpty()) {
            return String.format("%s%s%s%s?auth_key=%s", scheme, host, path, args, authKey);
        } else {
            return String.format("%s%s%s%s&auth_key=%s", scheme, host, path, args, authKey);
        }
    }



    private static String md5Sum(String src) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md5.update(StandardCharsets.UTF_8.encode(src));
        return String.format("%032x", new BigInteger(1, md5.digest()));
    }
}

package com.ng.alsolang.domain.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 各种格式编码解码工具类
 * Created by zhangxuegang on 2016/2/4.
 */
public class EncodeUtil {

    /**
     * URL encode the string
     *
     * @param s
     * @return
     */
    public static String urlEncode(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * encoding similiar to JavaScript encodeURIComponent
     *
     * @param component
     * @return
     */
    public static String encodeURIComponent(String component) {
        String result = null;
        try {
            result = URLEncoder.encode(component, "UTF-8")
                    .replaceAll("\\%28", "(")
                    .replaceAll("\\%29", ")")
                    .replaceAll("\\+", "%20")
                    .replaceAll("\\%27", "'")
                    .replaceAll("\\%21", "!")
                    .replaceAll("\\%7E", "~");
        } catch (UnsupportedEncodingException e) {
            result = component;
        }
        return result;
    }
}

package com.ng.alsolang.domain.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * httpClinet工具类
 * User: zhangxuegang
 * Date: 2015-11-09
 * Time: 10:57:49
 */
public class HttpUtil {
    private static final Logger LOG = LoggerFactory.getLogger(HttpUtil.class);

    /**
     * 发送 http post请求
     *
     * @param targetURL
     * @param urlParameters
     * @return
     */
    public static String postURL(String targetURL, String urlParameters) {
        return postURL(targetURL, urlParameters, "text/xml");
    }

    /**
     * 发送请求
     *
     * @param targetURL
     * @param urlParameters
     * @param contentType
     * @return
     */
    public static String postURL(String targetURL, String urlParameters, String contentType) {
        URL url;
        HttpURLConnection connection = null;
        int responseCode = 0;
        try {
            //Create connection
            url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", contentType);

            connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer();
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        } finally {

            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    /**
     * 获取url
     *
     * @param url
     * @return
     */
    public static String getURL(String url) {
        StringBuffer response = null;

        try {
            URL u = new URL(url);
            HttpURLConnection httpConnection = (HttpURLConnection) u.openConnection();

            httpConnection.setUseCaches(false);
            httpConnection.setDoOutput(true);
            httpConnection.setRequestMethod("GET");

            httpConnection.connect();
            int responseCode = httpConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream input = httpConnection.getInputStream();

                // Read server's response.
                response = new StringBuffer();
                Reader reader = new InputStreamReader(input, "UTF-8");
                reader = new BufferedReader(reader);
                char[] buffer = new char[1024];
                for (int n = 0; n >= 0; ) {
                    n = reader.read(buffer, 0, buffer.length);
                    if (n > 0)
                        response.append(buffer, 0, n);
                }

                input.close();
                httpConnection.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (response != null) {
            return response.toString();
        } else {
            return "";
        }
    }
}

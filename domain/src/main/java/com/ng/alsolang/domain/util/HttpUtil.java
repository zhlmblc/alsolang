package com.ng.alsolang.domain.util;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

/**
 * httpClinet工具类
 * User: zhangxuegang
 * Date: 2015-11-09
 * Time: 10:57:49
 */
public class HttpUtil {
    private static final Logger LOG = LoggerFactory.getLogger(HttpUtil.class);

    public static DefaultHttpClient getHttpsClient() {
        try {
            SSLContext ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {

                public void checkClientTrusted(
                        java.security.cert.X509Certificate[] chain,
                        String authType)
                        throws java.security.cert.CertificateException {
                }

                public void checkServerTrusted(
                        java.security.cert.X509Certificate[] chain,
                        String authType)
                        throws java.security.cert.CertificateException {
                }

                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

            };
            DefaultHttpClient client = new DefaultHttpClient();
            ctx.init(null, new TrustManager[]{tm}, null);
            SSLSocketFactory ssf = new SSLSocketFactory(ctx);

            ClientConnectionManager ccm = client.getConnectionManager();
            SchemeRegistry sr = ccm.getSchemeRegistry();
            //设置要使用的端口，默认是443
            sr.register(new Scheme("https", 443, ssf));
            return client;
        } catch (Exception ex) {
            LOG.error("", ex);
            return null;
        }
    }

    /**
     * 需要调用的url和参数
     *
     * @param url
     * @param params
     * @return
     */
    public static String post(String url, Map<String, String> params) {
        DefaultHttpClient httpClient = getHttpsClient();
        HttpPost post = new HttpPost(url);
        HttpEntity entity = map2UrlEncodedFormEntity(params);
        if (entity != null) {
            post.setEntity(entity);
        }
        LOG.info("http post---{}", getUrlRequestInfo(url, params));
        HttpResponse response;
        try {
            response = httpClient.execute(post);
            String result = EntityUtils.toString(response.getEntity());
            return result;
        } catch (ClientProtocolException e) {
            LOG.error("", e);
        } catch (IOException e) {
            LOG.error("", e);
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        return null;
    }

    /**
     * 生成post请求时的记录
     *
     * @param url
     * @param params
     * @return
     */
    public static String getUrlRequestInfo(String url, Map<String, String> params) {

        StringBuilder paramStr = new StringBuilder();
        if (params != null) {
            Iterator<Entry<String, String>> iterator = params.entrySet().iterator();
            Joiner.on("&").appendTo(paramStr, iterator);
        }
        return String.format("curl -d '%s' '%s'", StringUtils.trimToEmpty(paramStr.toString()), StringUtils.trimToEmpty(url));
    }

    /**
     * 参数转换
     *
     * @param params
     * @return
     */
    public static HttpEntity map2UrlEncodedFormEntity(Map<String, String> params) {
        if (params != null) {
            Iterator<Entry<String, String>> iterator = params.entrySet().iterator();
            List<NameValuePair> nvps = Lists.newArrayList();
            while (iterator.hasNext()) {
                Entry<String, String> entry = iterator.next();
                nvps.add(new BasicNameValuePair(StringUtils.trimToEmpty(entry.getKey()), StringUtils.trimToEmpty(entry.getValue())));
            }
            try {
                return new UrlEncodedFormEntity(nvps);
            } catch (UnsupportedEncodingException e) {
                LOG.error("", e);
            }
        }
        return null;
    }

    public static void main(String[] args) {

        // 创建会议测试
//        String base_url_create = "http://10.0.17.44/bigbluebutton/api/create?";
//        String base_url_join = "http://10.0.17.44/bigbluebutton/api/join?";
//        String create_parameters = "name=test"+"&meetingID=test"+"&attendeePW=ap&moderatorPW=mp";
//        String salt = "6c254af008de372d81d73d844417efea";
//        String url = base_url_create + create_parameters + "&checksum="
//                + checksum("create" + create_parameters + salt);
//        String join_parameters = "meetingID=test"
//                + "&fullName=test" + "&password=mp";
//        String urlFinal =  base_url_join + join_parameters + "&checksum="
//                + checksum("join" + join_parameters + salt);
//        System.out.println("==>>"+urlFinal);

     /*   Map<String, String> params = Maps.newHashMapWithExpectedSize(8);
        params.put("name", "test");
        params.put("meetingID", "000001");
        params.put("attendeePW", "123");
        params.put("moderatorPW", "123");
        StringBuilder paramStr = new StringBuilder();
        if (params != null) {
            Iterator<Entry<String, String>> iterator = params.entrySet().iterator();
            Joiner.on("&").appendTo(paramStr, iterator);
        }

        String checksum = EncryptUtil.SHA1(paramStr.toString()+"6c254af008de372d81d73d844417efea");
//        checksum = EncryptUtil.SHA1("createname=Test+Meeting&meetingID=abc123&attendeePW=111222&moderatorPW=333444639259d4-9dd8-4b25-bf01-95f9567eaf4b");
        System.out.println(checksum);
        params.put("checksum", checksum);
        System.out.println(getUrlRequestInfo("", params));
        System.out.println(post("http://10.0.17.44/bigbluebutton/api/create", params));*/

        // 会议地址
         String BIG_BLUE_BUTTON_URL = "http://10.0.17.44/bigbluebutton/";
        String SALT = "6c254af008de372d81d73d844417efea";
        String meetingParameters = "random=" + new Random().nextInt(9999);
        String url = BIG_BLUE_BUTTON_URL + "api/getMeetings?" + meetingParameters
                + "&checksum="
                + EncryptUtil.checksum("getMeetings" + meetingParameters + SALT);
        System.out.println("the url getMettings is ==>>" +url);






    }

    public static String checksum(String s) {
        String checksum = "";
        try {
            checksum = org.apache.commons.codec.digest.DigestUtils.shaHex(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checksum;
    }

}

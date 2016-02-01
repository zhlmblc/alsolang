package com.ng.alsolang.rpc.conference.impl;

import com.ng.alsolang.domain.util.EncryptUtil;
import com.ng.alsolang.rpc.conference.ConferenceService;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Random;

/**
 * User: zhangxuegang
 * Date: 2016/1/31
 * Time: 17:40
 */
@Service("conferenceServiceImpl")
public class ConferenceServiceImpl implements ConferenceService {
    // todo 后续要放到配置文件中
    public static final String BASE_URL_CREATE = "http://192.168.1.103/bigbluebutton/api/create?";
    public static final String BASE_URL_JOIN = "http://192.168.1.103/bigbluebutton/api/join?";
    public static final String SALT = "6c254af008de372d81d73d844417efea";
    public static final String BIG_BLUE_BUTTON_URL = "http://192.168.1.103/bigbluebutton/";

    /**
     * 返回会议列表地址
     *
     * @return
     */
    @Override
    public String getMeetingsURL() {
        String meetingParameters = "random=" + new Random().nextInt(9999);
        return BIG_BLUE_BUTTON_URL + "api/getMeetings?" + meetingParameters
                + "&checksum="
                + EncryptUtil.checksum("getMeetings" + meetingParameters + SALT);
    }

    /**
     * 返回该服务器的所有会议
     *
     * @return
     */
    @Override
    public String getMeetings() {
        try {
            Document doc = parseXml( getURL( getMeetingsURL() ));

            // tags needed for parsing xml documents
            final String startTag = "<meetings>";
            final String endTag = "</meetings>";
            final String startResponse = "<response>";
            final String endResponse = "</response>";

            // if the request succeeded, then calculate the checksum of each meeting and insert it into the document
            NodeList meetingsList = doc.getElementsByTagName("meeting");

            String newXMldocument = startTag;
            for (int i = 0; i < meetingsList.getLength(); i++) {
                Element meeting = (Element) meetingsList.item(i);
                String meetingID = meeting.getElementsByTagName("meetingID").item(0).getTextContent();
                String password = meeting.getElementsByTagName("moderatorPW").item(0).getTextContent();

                String data = getURL( getMeetingInfoURL(meetingID, password) );

                if (data.indexOf("<response>") != -1) {
                    int startIndex = data.indexOf(startResponse) + startTag.length();
                    int endIndex = data.indexOf(endResponse);
                    newXMldocument +=  "<meeting>" + data.substring(startIndex, endIndex) + "</meeting>";
                }
            }
            newXMldocument += endTag;

            return newXMldocument;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }


    public String getURL(String url) {
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
                for (int n = 0; n >= 0;) {
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


    //
// parseXml() -- return a DOM of the XML
//
    public static Document parseXml(String xml)
            throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(new InputSource(new StringReader(xml)));
        return doc;
    }

    public String getMeetingInfoURL(String meetingID, String password) {
        String meetingParameters = "meetingID=" + urlEncode(meetingID)
                + "&password=" + password;
        return BIG_BLUE_BUTTON_URL + "api/getMeetingInfo?" + meetingParameters
                + "&checksum="
                + EncryptUtil.checksum("getMeetingInfo" + meetingParameters + SALT);
    }


    //
// urlEncode() -- URL encode the string
//
    public static String urlEncode(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}

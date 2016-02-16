package com.ng.alsolang.rpc.conference.impl;

import static com.ng.alsolang.domain.util.EncodeUtil.urlEncode;
import static com.ng.alsolang.domain.util.ParseXmlUtil.parseXml;
import static com.ng.alsolang.domain.util.HttpUtil.getURL;
import static com.ng.alsolang.domain.conference.constants.BaseApiUrl.*;

import com.ng.alsolang.domain.util.EncryptUtil;
import com.ng.alsolang.rpc.conference.ConferenceService;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.Random;

/**
 * User: zhangxuegang
 * Date: 2016/1/31
 * Time: 17:40
 */
@Service("conferenceServiceImpl")
public class ConferenceServiceImpl implements ConferenceService {

    /**
     * 返回会议列表地址
     *
     * @return
     */
    @Override
    public String getMeetingsURL() {
        String meetingParameters = "random=" + new Random().nextInt(9999);
        return BASE_URL_BBB + "api/getMeetings?" + meetingParameters
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
            Document doc = parseXml(getURL(getMeetingsURL()));
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
                String data = getURL(getMeetingInfoURL(meetingID, password));
                if (data.indexOf("<response>") != -1) {
                    int startIndex = data.indexOf(startResponse) + startTag.length();
                    int endIndex = data.indexOf(endResponse);
                    newXMldocument += "<meeting>" + data.substring(startIndex, endIndex) + "</meeting>";
                }
            }
            newXMldocument += endTag;
            return newXMldocument;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }

    /**
     * 获取会议地址信息
     *
     * @param meetingID
     * @param password
     * @return
     */
    public String getMeetingInfoURL(String meetingID, String password) {
        String meetingParameters = "meetingID=" + urlEncode(meetingID)
                + "&password=" + password;
        return BASE_URL_BBB + "api/getMeetingInfo?" + meetingParameters
                + "&checksum="
                + EncryptUtil.checksum("getMeetingInfo" + meetingParameters + SALT);
    }

}

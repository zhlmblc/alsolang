package com.ng.alsolang.rpc.conference.impl;

import static com.ng.alsolang.domain.conference.constants.BaseApiUrl.*;

import com.ng.alsolang.rpc.conference.RecordService;
import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.ng.alsolang.domain.util.EncodeUtil.urlEncode;
import static com.ng.alsolang.domain.util.EncryptUtil.checksum;
import static com.ng.alsolang.domain.util.HttpUtil.getURL;
import static com.ng.alsolang.domain.util.ParseXmlUtil.parseXml;

/**
 * 会议记录服务接口
 * Created by zhangxuegang on 2016/2/5.
 */
@Service("recordServiceImpl")
public class RecordServiceImpl implements RecordService {

    private static final Logger logger = LoggerFactory.getLogger(RecordServiceImpl.class);

    /**
     * 根据会议ID获取会议录像地址，如果meetingID是null返回全部录像
     *
     * @param meetingID
     * @return
     */
    @Override
    public String getRecordingsURL(String meetingID) {
        String record_parameters = "";
        if (meetingID != null) {
            record_parameters = "meetingID=" + urlEncode(meetingID);
        }
        return BASE_URL_BBB + "api/getRecordings?" + record_parameters + "&checksum="
                + checksum("getRecordings" + record_parameters + SALT);
    }

    /**
     * 根据会议ID获取记录信息,记录信息是对url返回报文的简单拼接
     *
     * @param meetingID
     * @return
     */
    @Override
    public String getRecordings(String meetingID) {
// 会议ID
        String newXMLdoc = "<recordings>";
        try {
            Document doc = null;
            String url = getRecordingsURL(meetingID);
            doc = parseXml(getURL(url));

            // if the request succeeded, then calculate the checksum of each meeting and insert it into the document
            NodeList recordingList = doc.getElementsByTagName("recording");


            for (int i = 0; i < recordingList.getLength(); i++) {
                Element recording = (Element) recordingList.item(i);

                if (recording.getElementsByTagName("recordID").getLength() > 0) {

                    String recordID = recording.getElementsByTagName("recordID").item(0).getTextContent();
                    String name = recording.getElementsByTagName("name").item(0).getTextContent();
                    String description = "";
                    NodeList metadata = recording.getElementsByTagName("metadata");
                    if (metadata.getLength() > 0) {
                        Element metadataElem = (Element) metadata.item(0);
                        if (metadataElem.getElementsByTagName("description").getLength() > 0) {
                            description = metadataElem.getElementsByTagName("description").item(0).getTextContent();
                        }
                    }

                    String starttime = recording.getElementsByTagName("startTime").item(0).getTextContent();
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                        Date resultdate = new Date(Long.parseLong(starttime));
                        starttime = sdf.format(resultdate);
                    } catch (Exception e) {

                    }
                    String published = recording.getElementsByTagName("published").item(0).getTextContent();
                    String playback = "";
                    String length = "";
                    NodeList formats = recording.getElementsByTagName("format");
                    for (int j = 0; j < formats.getLength(); j++) {
                        Element format = (Element) formats.item(j);

                        String typeP = format.getElementsByTagName("type").item(0).getTextContent();
                        String urlP = format.getElementsByTagName("url").item(0).getTextContent();
                        String lengthP = format.getElementsByTagName("length").item(0).getTextContent();

                        if (j != 0) {
                            playback += ", ";
                        }
                        playback += StringEscapeUtils.escapeXml("<a href='" + urlP + "' target='_blank'>" + typeP + "</a>");

                        if (typeP.equalsIgnoreCase("slides") || typeP.equalsIgnoreCase("presentation")) {
                            length = lengthP;
                        }
                    }

                    newXMLdoc += "<recording>";

                    newXMLdoc += "<recordID>" + recordID + "</recordID>";
                    newXMLdoc += "<name><![CDATA[" + name + "]]></name>";
                    newXMLdoc += "<description><![CDATA[" + description + "]]></description>";
                    newXMLdoc += "<startTime>" + starttime + "</startTime>";
                    newXMLdoc += "<published>" + published + "</published>";
                    newXMLdoc += "<playback>" + playback + "</playback>";
                    newXMLdoc += "<length>" + length + "</length>";

                    newXMLdoc += "</recording>";
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return "error: " + e.getMessage();
        }
        newXMLdoc += "</recordings>";
        logger.info("the recordings is ==> {}" ,newXMLdoc);
        return newXMLdoc;
    }
}

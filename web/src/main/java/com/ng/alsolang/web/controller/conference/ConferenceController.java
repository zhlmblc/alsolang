package com.ng.alsolang.web.controller.conference;

import static com.ng.alsolang.domain.util.EncodeUtil.urlEncode;
import com.ng.alsolang.domain.conference.Meetings;
import static com.ng.alsolang.domain.conference.constants.BaseApiUrl.*;
import static com.ng.alsolang.domain.util.HttpUtil.postURL;
import static com.ng.alsolang.domain.util.ParseXmlUtil.parseXml;

import com.ng.alsolang.domain.util.EncryptUtil;
import com.ng.alsolang.domain.util.JaxbUtil;
import com.ng.alsolang.rpc.conference.ConferenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * 会议控制类
 * User: zhangxuegang
 * Date: 2016/1/31
 * Time: 12:47
 */
@Controller
@RequestMapping("/conference")
public class ConferenceController {

    private static final Logger logger = LoggerFactory.getLogger(ConferenceController.class);

    @Resource(name = "conferenceServiceImpl")
    private ConferenceService conferenceService;

    /**
     * 创建一个新的会议
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/createConference.do")
    public String createConference(HttpServletRequest request, Model model) {
        // 会议名称
        String name = request.getParameter("meetingName");
        // 用户名称
        String userName = request.getParameter("userName");
        // 会议密码
        String password = request.getParameter("password");
        // 会议ID
        String meetingID = UUID.randomUUID().toString();
        // xml参数
        String xml_param = "";
        // 创建会议参数
        String create_parameters = "record=true&name=" + urlEncode(name) + "&meetingID=" + meetingID + "&attendeePW=" + password + "&moderatorPW=" + password;
        // 请求服务地址
        String url = BASE_URL_CREATE + create_parameters + "&checksum=" + EncryptUtil.checksum("create" + create_parameters + SALT);

        // 调用接口
        Document doc = null;
        try {
            doc = parseXml(postURL(url, xml_param));
        } catch (Exception e) {
            logger.error("parseXml error ==>>", e);
            e.printStackTrace();
        }

        // 解析返回报文返回会议地址
        if (doc.getElementsByTagName("returncode").item(0).getTextContent().trim().equals("SUCCESS")) {
            String join_parameters = "meetingID=" + urlEncode(meetingID) + "&fullName=" + urlEncode(userName) + "&password=" + password;
            logger.info(" the join_url is ==>> {}", BASE_URL_JOIN + join_parameters + "&checksum="
                    + EncryptUtil.checksum("join" + join_parameters + SALT));
            return BASE_URL_JOIN + join_parameters + "&checksum=" + EncryptUtil.checksum("join" + join_parameters + SALT);
        }

        // 返回错误信息
        return doc.getElementsByTagName("messageKey").item(0).getTextContent().trim()
                + ": "
                + doc.getElementsByTagName("message").item(0).getTextContent()
                .trim();
    }

    /**
     * 加入已存在的会议
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/joinConference.do")
    public String joinConference(HttpServletRequest request, Model model) {
        // 会议ID
        String meetingID = request.getParameter("meetingID");
        // 加入密码
        String password = request.getParameter("password");
        // todo 用户模块
        // 如果用户登录了，优先从cookie中获取
        String fullName = request.getParameter("fullName");
        String join_parameters = "fullName=" + urlEncode(fullName) + "&meetingID=" + meetingID + "&password=" + password;
        // 请求服务地址
        String url = BASE_URL_JOIN + join_parameters + "&checksum=" + EncryptUtil.checksum("join" + join_parameters + SALT);
        logger.info("get the  BASE_URL_JOIN is  ==>> {}", url);
        return url;
    }

    /**
     * 获取所有会议
     *
     * @return
     */
    @RequestMapping(value = "/getMeetings.do")
    public String getMeetings(HttpServletRequest request, Model model) {
        JaxbUtil resultBinder = new JaxbUtil(Meetings.class, JaxbUtil.CollectionWrapper.class);
        String retXml = conferenceService.getMeetings();
        Meetings meetings = resultBinder.fromXml(retXml);
        model.addAttribute("meetings", meetings);
        return "conference/getMeetings";
    }

}

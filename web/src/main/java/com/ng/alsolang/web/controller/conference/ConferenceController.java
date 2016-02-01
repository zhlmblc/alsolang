package com.ng.alsolang.web.controller.conference;

import com.ng.alsolang.domain.user.User;
import com.ng.alsolang.domain.util.EncryptUtil;
import com.ng.alsolang.rpc.conference.ConferenceService;
import com.ng.alsolang.service.user.UserService;
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
import javax.servlet.http.HttpServletResponse;
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

    // todo 后续要放到配置文件中
    public static final String BASE_URL_CREATE = "http://192.168.1.103/bigbluebutton/api/create?";
    public static final String BASE_URL_JOIN = "http://192.168.1.103/bigbluebutton/api/join?";
    public static final String SALT = "6c254af008de372d81d73d844417efea";


    /**
     * 创建会议
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/createConference.do")
    public String createConference(HttpServletRequest request, Model model) {
        String name = request.getParameter("userName");
        String password = request.getParameter("password");
        String meetingID = UUID.randomUUID().toString();
        String xml_param = "";
        String create_parameters = "name=" + urlEncode(name) + "&meetingID=" + meetingID + "&attendeePW=ap&moderatorPW=" + password;
        // 请求服务地址
        String url = BASE_URL_CREATE + create_parameters + "&checksum="
                + EncryptUtil.checksum("create" + create_parameters + SALT);

        //调用接口
        Document doc = null;
        try {
            doc = parseXml(postURL(url, xml_param));
        } catch (Exception e) {
            logger.error("parseXml error ==>>",e);
            e.printStackTrace();
        }

        // 解析返回报文返回会议地址
        if (doc.getElementsByTagName("returncode").item(0).getTextContent()
                .trim().equals("SUCCESS")) {
            //
            // Looks good, now return a URL to join that meeting
            //
            String join_parameters = "meetingID=" + urlEncode(meetingID)
                    + "&fullName=" + urlEncode(name) + "&password=" + password;
            logger.info(" the join_url is ==>> {}",BASE_URL_JOIN + join_parameters + "&checksum="
                    + EncryptUtil.checksum("join" + join_parameters + SALT ));
            return BASE_URL_JOIN + join_parameters + "&checksum="
                    + EncryptUtil.checksum("join" + join_parameters + SALT);

        }


        return doc.getElementsByTagName("messageKey").item(0).getTextContent()
                .trim()
                + ": "
                + doc.getElementsByTagName("message").item(0).getTextContent()
                .trim();
    }

    /**
     * 获取所有会议
     * @return
     */
    @RequestMapping(value = "/getMeetings.do")
    public String getMeetings() {
        conferenceService.getMeetingsURL();
        return "";
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


    public static String postURL(String targetURL, String urlParameters) {
        return postURL(targetURL, urlParameters, "text/xml");
    }

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

            connection.setRequestProperty("Content-Length", "" +
                    Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream(
                    connection.getOutputStream());
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

    //
//encodeURIComponent() -- Java encoding similiar to JavaScript encodeURIComponent
//
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

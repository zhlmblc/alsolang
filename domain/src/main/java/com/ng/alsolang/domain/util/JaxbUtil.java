package com.ng.alsolang.domain.util;

import com.ng.alsolang.domain.conference.Attendee;
import com.ng.alsolang.domain.conference.Meeting;
import com.ng.alsolang.domain.conference.Meetings;
import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.*;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.namespace.QName;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Collection;

/**
 * 使用Jaxb2.0实现XML<->Java Object的Binder.
 * 特别支持Root对象是List的情形.
 * User: zhangxuegang
 * Date: 2016/2/2
 * Time: 12:30
 */
public class JaxbUtil {


    // 多线程安全的Context.
    private JAXBContext jaxbContext;

    /**
     * 所有需要序列化的Root对象的类型.
     *
     * @param types
     */
    public JaxbUtil(Class<?>... types) {
        try {
            jaxbContext = JAXBContext.newInstance(types);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Java Object->Xml.
     *
     * @param root
     * @param encoding
     * @return
     */
    public String toXml(Object root, String encoding) {
        try {
            StringWriter writer = new StringWriter();
            createMarshaller(encoding).marshal(root, writer);
            return writer.toString();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Java Object->Xml, 特别支持对Root Element是Collection的情形.
     *
     * @param root
     * @param rootName
     * @param encoding
     * @return
     */
    @SuppressWarnings("unchecked")
    public String toXml(Collection root, String rootName, String encoding) {
        try {
            CollectionWrapper wrapper = new CollectionWrapper();
            wrapper.collection = root;

            JAXBElement<CollectionWrapper> wrapperElement = new JAXBElement<CollectionWrapper>(
                    new QName(rootName), CollectionWrapper.class, wrapper);

            StringWriter writer = new StringWriter();
            createMarshaller(encoding).marshal(wrapperElement, writer);

            return writer.toString();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Xml->Java Object.
     *
     * @param xml
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T fromXml(String xml) {
        try {
            StringReader reader = new StringReader(xml);
            return (T) createUnmarshaller().unmarshal(reader);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Xml->Java Object, 支持大小写敏感或不敏感.
     *
     * @param xml
     * @param caseSensitive
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T fromXml(String xml, boolean caseSensitive) {
        try {
            String fromXml = xml;
            if (!caseSensitive)
                fromXml = xml.toLowerCase();
            StringReader reader = new StringReader(fromXml);
            return (T) createUnmarshaller().unmarshal(reader);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 创建Marshaller, 设定encoding(可为Null).
     *
     * @param encoding
     * @return
     */
    public Marshaller createMarshaller(String encoding) {
        try {
            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            if (StringUtils.isNotBlank(encoding)) {
                marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
            }
            return marshaller;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 创建UnMarshaller.
     */
    public Unmarshaller createUnmarshaller() {
        try {
            return jaxbContext.createUnmarshaller();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 封装Root Element 是 Collection的情况.
     */
    public static class CollectionWrapper {
        @SuppressWarnings("unchecked")
        @XmlAnyElement
        protected Collection collection;
    }


    public static void main(String[] args) {
        String retXml =
                "<meetings>\n" +
                "\t<meeting>\n" +
                "\t\t<returncode>SUCCESS</returncode>\n" +
                "\t\t<meetingName>zhangxuegang</meetingName>\n" +
                "\t\t<meetingID>3a11be58-cd79-4026-9fcd-e12ad44bfa4c</meetingID>\n" +
                "\t\t<createTime>1454383511950</createTime>\n" +
                "\t\t<createDate>Tue Feb 02 11:25:11 CST 2016</createDate>\n" +
                "\t\t<voiceBridge>72288</voiceBridge>\n" +
                "\t\t<dialNumber>613-555-1234</dialNumber>\n" +
                "\t\t<attendeePW>ap</attendeePW>\n" +
                "\t\t<moderatorPW>123</moderatorPW>\n" +
                "\t\t<running>true</running>\n" +
                "\t\t<duration>0</duration>\n" +
                "\t\t<hasUserJoined>true</hasUserJoined>\n" +
                "\t\t<recording>false</recording>\n" +
                "\t\t<hasBeenForciblyEnded>false</hasBeenForciblyEnded>\n" +
                "\t\t<startTime>1454383511958</startTime>\n" +
                "\t\t<endTime>0</endTime>\n" +
                "\t\t<participantCount>1</participantCount>\n" +
                "\t\t<maxUsers>20</maxUsers>\n" +
                "\t\t<moderatorCount>1</moderatorCount>\n" +
                "\t\t<attendees>\n" +
                "\t\t\t<attendee>\n" +
                "\t\t\t\t<userID>wdzbbdp9u2eb</userID>\n" +
                "\t\t\t\t<fullName>zhangxuegang</fullName>\n" +
                "\t\t\t\t<role>MODERATOR</role>\n" +
                "\t\t\t\t<customdata/>\n" +
                "\t\t\t</attendee>\n" +
                "\t\t</attendees>\n" +
                "\t\t<metadata/>\n" +
                "\t\t<messageKey/>\n" +
                "\t\t<message/>\n" +
                "\t</meeting>\n" +
                "\t<meeting>\n" +
                "\t\t<returncode>SUCCESS</returncode>\n" +
                "\t\t<meetingName>一起开发</meetingName>\n" +
                "\t\t<meetingID>aa2c5117-32c1-4538-a151-a6ccddf2951e</meetingID>\n" +
                "\t\t<createTime>1454383545226</createTime>\n" +
                "\t\t<createDate>Tue Feb 02 11:25:45 CST 2016</createDate>\n" +
                "\t\t<voiceBridge>86815</voiceBridge>\n" +
                "\t\t<dialNumber>613-555-1234</dialNumber>\n" +
                "\t\t<attendeePW>ap</attendeePW>\n" +
                "\t\t<moderatorPW>123</moderatorPW>\n" +
                "\t\t<running>true</running>\n" +
                "\t\t<duration>0</duration>\n" +
                "\t\t<hasUserJoined>true</hasUserJoined>\n" +
                "\t\t<recording>false</recording>\n" +
                "\t\t<hasBeenForciblyEnded>false</hasBeenForciblyEnded>\n" +
                "\t\t<startTime>1454383545234</startTime>\n" +
                "\t\t<endTime>0</endTime>\n" +
                "\t\t<participantCount>1</participantCount>\n" +
                "\t\t<maxUsers>20</maxUsers>\n" +
                "\t\t<moderatorCount>1</moderatorCount>\n" +
                "\t\t<attendees>\n" +
                "\t\t\t<attendee>\n" +
                "\t\t\t\t<userID>pyshahu04vd6</userID>\n" +
                "\t\t\t\t<fullName>一起开发</fullName>\n" +
                "\t\t\t\t<role>MODERATOR</role>\n" +
                "\t\t\t\t<customdata/>\n" +
                "\t\t\t</attendee>\n" +
                "\t\t</attendees>\n" +
                "\t\t<metadata/>\n" +
                "\t\t<messageKey/>\n" +
                "\t\t<message/>\n" +
                "\t</meeting>\n" +
                "</meetings>";

        //将java对象转换为XML字符串
        JaxbUtil requestBinder = new JaxbUtil(Meetings.class,
                CollectionWrapper.class);
        retXml = requestBinder.toXml(requestBinder, "utf-8");
        System.out.println("xml:"+retXml);

        //将xml字符串转换为java对象
        JaxbUtil resultBinder = new JaxbUtil(Meetings.class,
                CollectionWrapper.class);
        Meetings meetings = resultBinder.fromXml(retXml);
        for (Meeting meeting: meetings.getMeetings()) {
            for (Attendee attendee : meeting.getAttendees()) {
                System.out.println("attendee name is ==>>"  +attendee.getFullName());
            }
        }
    }
}

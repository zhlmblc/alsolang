package com.ng.alsolang.domain.util;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;


/**
 * XML解析的工具类
 * Created by zhangxuegang on 2016/2/5.
 */
public class ParseXmlUtil {

    /**
     * 解析xml为文档对象
     *
     * @param xml
     * @return doc
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public static Document parseXml(String xml)
            throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(new InputSource(new StringReader(xml)));
        return doc;
    }


}

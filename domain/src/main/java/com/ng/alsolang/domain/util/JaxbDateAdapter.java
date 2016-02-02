package com.ng.alsolang.domain.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 特殊类型bean对象转换xml的适配器
 * User: zhangxuegang
 * Date: 2016/2/2
 * Time: 14:25
 */
public class JaxbDateAdapter extends XmlAdapter<String, Date> {


//    static final String STANDARM_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    static  final String LOCALE_UK_DATE_FORMAT = "EEE MMM dd HH:mm:ss zzz yyyy";
    @Override
    public Date unmarshal(String v) throws Exception {
        if (v == null) {
            return null;
        }

        DateFormat format = new SimpleDateFormat(LOCALE_UK_DATE_FORMAT, Locale.ENGLISH);
        return format.parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        DateFormat format = new SimpleDateFormat(LOCALE_UK_DATE_FORMAT);
        return format.format(v);
    }

}

package com.ng.alsolang.domain.conference;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * 会议录像集合
 * Created by zhangxuegang on 2016/2/5.
 */
@SuppressWarnings("serial")
@XmlRootElement(name = "recordings")
@XmlAccessorType(XmlAccessType.FIELD)
public class Recordings extends ArrayList<Recording> {

    @XmlElement(name = "recording")
    public List<Recording> getRecordings() {
        return this;
    }
}
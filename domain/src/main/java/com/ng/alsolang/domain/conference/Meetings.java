package com.ng.alsolang.domain.conference;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 会议集合
 * User: zhangxuegang
 * Date: 2016/2/2
 * Time: 11:36
 */
@SuppressWarnings("serial")
@XmlRootElement(name = "meetings")
@XmlAccessorType(XmlAccessType.FIELD)
public class Meetings extends ArrayList<Meeting> { //泛化聚合

    @XmlElement(name = "meeting")
    public List<Meeting> getMeetings () {
        return this;
    }

}

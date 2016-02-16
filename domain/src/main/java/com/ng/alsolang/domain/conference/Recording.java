package com.ng.alsolang.domain.conference;

import com.ng.alsolang.domain.util.JaxbDateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 * 会议录像
 * Created by zhangxuegang on 2016/2/5.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Recording {
    private String recordID;
    private String name;
    private String description;
    @XmlJavaTypeAdapter(JaxbDateAdapter.class)
    private Date startTime;
    private Boolean published;
    public String playback;
    public Integer length;

    public String getRecordID() {
        return recordID;
    }

    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public String getPlayback() {
        return playback;
    }

    public void setPlayback(String playback) {
        this.playback = playback;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Recording{" +
                "recordID='" + recordID + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startTime=" + startTime +
                ", published=" + published +
                ", playback='" + playback + '\'' +
                ", length=" + length +
                '}';
    }
}

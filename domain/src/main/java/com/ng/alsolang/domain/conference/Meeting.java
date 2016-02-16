package com.ng.alsolang.domain.conference;

import com.ng.alsolang.domain.util.JaxbDateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

/**
 * 会议实体
 * User: zhangxuegang
 * Date: 2016/2/2
 * Time: 10:12
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Meeting {
    // 返回码
    private String returncode;
    // 会议名称
    private String meetingName;
    // 会议ID
    private String meetingID;
    // 创建时间
    private Long createTime;
    // 创建日期
    @XmlJavaTypeAdapter(JaxbDateAdapter.class)
    private Date createDate;
    // 音桥
    private String voiceBridge;
    private String dialNumber;
    private String attendeePW;
    private String moderatorPW;
    private Boolean running;
    private Integer duration;
    private Boolean hasUserJoined;
    private Boolean recording;
    private Boolean hasBeenForciblyEnded;
    private Long startTime;
    private Long endTime;
    private Long participantCount;
    private Integer maxUsers;
    private Integer moderatorCount;
    // 与会人员
    @XmlElementWrapper(name = "attendees")
    @XmlElement(name = "attendee")
    private List<Attendee> attendees;

    public String getReturncode() {
        return returncode;
    }

    public void setReturncode(String returncode) {
        this.returncode = returncode;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public String getMeetingID() {
        return meetingID;
    }

    public void setMeetingID(String meetingID) {
        this.meetingID = meetingID;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getVoiceBridge() {
        return voiceBridge;
    }

    public void setVoiceBridge(String voiceBridge) {
        this.voiceBridge = voiceBridge;
    }

    public String getDialNumber() {
        return dialNumber;
    }

    public void setDialNumber(String dialNumber) {
        this.dialNumber = dialNumber;
    }

    public String getAttendeePW() {
        return attendeePW;
    }

    public void setAttendeePW(String attendeePW) {
        this.attendeePW = attendeePW;
    }

    public String getModeratorPW() {
        return moderatorPW;
    }

    public void setModeratorPW(String moderatorPW) {
        this.moderatorPW = moderatorPW;
    }

    public Boolean getRunning() {
        return running;
    }

    public void setRunning(Boolean running) {
        this.running = running;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Boolean getHasUserJoined() {
        return hasUserJoined;
    }

    public void setHasUserJoined(Boolean hasUserJoined) {
        this.hasUserJoined = hasUserJoined;
    }

    public Boolean getRecording() {
        return recording;
    }

    public void setRecording(Boolean recording) {
        this.recording = recording;
    }

    public Boolean getHasBeenForciblyEnded() {
        return hasBeenForciblyEnded;
    }

    public void setHasBeenForciblyEnded(Boolean hasBeenForciblyEnded) {
        this.hasBeenForciblyEnded = hasBeenForciblyEnded;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getParticipantCount() {
        return participantCount;
    }

    public void setParticipantCount(Long participantCount) {
        this.participantCount = participantCount;
    }

    public Integer getMaxUsers() {
        return maxUsers;
    }

    public void setMaxUsers(Integer maxUsers) {
        this.maxUsers = maxUsers;
    }

    public Integer getModeratorCount() {
        return moderatorCount;
    }

    public void setModeratorCount(Integer moderatorCount) {
        this.moderatorCount = moderatorCount;
    }

    public List<Attendee> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Attendee> attendees) {
        this.attendees = attendees;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "returncode='" + returncode + '\'' +
                ", meetingName='" + meetingName + '\'' +
                ", meetingID='" + meetingID + '\'' +
                ", createTime=" + createTime +
                ", createDate=" + createDate +
                ", voiceBridge='" + voiceBridge + '\'' +
                ", dialNumber='" + dialNumber + '\'' +
                ", attendeePW='" + attendeePW + '\'' +
                ", moderatorPW='" + moderatorPW + '\'' +
                ", running=" + running +
                ", duration=" + duration +
                ", hasUserJoined=" + hasUserJoined +
                ", recording=" + recording +
                ", hasBeenForciblyEnded=" + hasBeenForciblyEnded +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", participantCount=" + participantCount +
                ", maxUsers=" + maxUsers +
                ", moderatorCount=" + moderatorCount +
                ", attendees=" + attendees +
                '}';
    }
}

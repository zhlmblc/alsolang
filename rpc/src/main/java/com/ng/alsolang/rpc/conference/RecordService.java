package com.ng.alsolang.rpc.conference;

/**
 * 会议录像服务接口
 * Created by zhangxuegang on 2016/2/5.
 */
public interface RecordService {
    /**
     * 根据会议ID获取会议录像地址，如果meetingID是null返回全部录像
     *
     * @param meetingID
     * @return
     */
    public String getRecordingsURL(String meetingID);

    /**
     * 根据会议ID获取记录信息,记录信息是对url返回报文的简单拼接
     *
     * @param meetingID
     * @return
     */
    public String getRecordings(String meetingID);

}

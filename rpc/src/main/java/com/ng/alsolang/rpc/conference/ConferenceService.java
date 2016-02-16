package com.ng.alsolang.rpc.conference;


/**
 * 在线会议服务类
 * User: zhangxuegang
 * Date: 2016/1/31
 * Time: 17:39
 */
public interface ConferenceService {

    /**
     * 返回会议列表地址
     *
     * @return
     */
    public String getMeetingsURL();

    /**
     * 返回该服务器的所有会议
     *
     * @return
     */
    public String getMeetings();


}

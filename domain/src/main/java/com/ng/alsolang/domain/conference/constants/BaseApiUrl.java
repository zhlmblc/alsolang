package com.ng.alsolang.domain.conference.constants;

/**
 * API接口地址
 * User: zhangxuegang
 * Date: 2016/2/2
 * Time: 10:16
 */
public class BaseApiUrl {

    // 数字签名
    public static final String SALT = "6c254af008de372d81d73d844417efea";
    // 创建API
    public static final String BASE_URL_CREATE = "http://192.168.1.104/bigbluebutton/api/create?";
    // 加入API
    public static final String BASE_URL_JOIN = "http://192.168.1.104/bigbluebutton/api/join?";
    // 获取所有录像
    public static final String BASE_URL_GET_RECORDS = "http://192.168.1.104/bigbluebutton/api/getRecordings?";
    // 获取基本地址
    public static final String BASE_URL_BBB = "http://192.168.1.104/bigbluebutton/";

    // todo 后续从配置文件读取
}

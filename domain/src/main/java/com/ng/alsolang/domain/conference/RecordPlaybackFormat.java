package com.ng.alsolang.domain.conference;

/**
 *
 * Created by zhangxuegang on 2016/2/5.
 */
@Deprecated
public class RecordPlaybackFormat {
    private String type;
    private String url;
    private Integer length;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "RecordPlaybackFormat{" +
                "type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", length=" + length +
                '}';
    }
}

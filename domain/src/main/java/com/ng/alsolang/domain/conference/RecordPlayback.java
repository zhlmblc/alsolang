package com.ng.alsolang.domain.conference;

/**
 * 会议记录的回放信息
 * Created by zhangxuegang on 2016/2/5.
 */
@Deprecated
public class RecordPlayback {
    public RecordPlaybackFormat recordPlaybackFormat;

    public RecordPlaybackFormat getRecordPlaybackFormat() {
        return recordPlaybackFormat;
    }

    public void setRecordPlaybackFormat(RecordPlaybackFormat recordPlaybackFormat) {
        this.recordPlaybackFormat = recordPlaybackFormat;
    }

    @Override
    public String toString() {
        return "RecordPlayback{" +
                "recordPlaybackFormat=" + recordPlaybackFormat +
                '}';
    }
}

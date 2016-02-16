package com.ng.alsolang.domain.conference;

/**
 * 会议录像元数据
 * Created by zhangxuegang on 2016/2/5.
 */
@Deprecated
public class RecordingMetadata {
    private String title;
    private String subject;
    private String description;
    private String creator;
    private String contributor;
    private String language;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getContributor() {
        return contributor;
    }

    public void setContributor(String contributor) {
        this.contributor = contributor;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "RecordingMetadata{" +
                "title='" + title + '\'' +
                ", subject='" + subject + '\'' +
                ", description='" + description + '\'' +
                ", creator='" + creator + '\'' +
                ", contributor='" + contributor + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}

package com.ng.alsolang.domain.conference;

/**
 * 参加人员
 * User: zhangxuegang
 * Date: 2016/2/2
 * Time: 10:16
 */
public class Attendee {

    private String userID;
    private String fullName;
    private String role;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Attendee{" +
                "userID='" + userID + '\'' +
                ", fullName='" + fullName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

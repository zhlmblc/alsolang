package com.ng.alsolang.domain.user;

import java.util.Date;

/**
 * 用户实体
 * User: zhangxuegang
 * Date: 2016/1/21
 * Time: 18:04
 */
public class User {

    // 主键
    public Long id;
    // 用户唯一标识
    public String userId;
    // 用户名称
    public String userName;
    // 用户密码
    public String password;
    // 邮箱
    public String email;
    // 手机
    public String mobile;
    // 用户状态(0：禁用；1：可用)
    public Integer status;
    // 创建时间
    public Date created;
    // 修改时间
    public Date modified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", status=" + status +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
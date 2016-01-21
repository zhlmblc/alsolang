package com.ng.alsolang.service.user;


import com.ng.alsolang.domain.user.User;

/**
 * User: zhangxuegang
 * Date: 2016/1/20
 * Time: 14:47
 */
public interface UserService {

    public User user(User user);

    public User selectLogin(String username);

    public User getUserById(int i);

    public User selectByPrimaryKey(int i);

    public User getUserByusername(String username);

    public int inster(User user);

    public Boolean getLoginUser(User user);

}
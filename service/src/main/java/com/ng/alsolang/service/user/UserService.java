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

    /**
     * 根据主键查询用户
     *
     * @param id 主键
     * @return
     */
    public User getUserById(Long id);

    public User selectByPrimaryKey(int i);

    public User getUserByUserId(String userId);

    /**
     * 用户插入
     * @param user
     * @return
     */
    public Boolean insert(User user);

    public Boolean getLoginUser(User user);

}
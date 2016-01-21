package com.ng.alsolang.dao.user;


import com.ng.alsolang.domain.user.User;

/**
 * User: zhangxuegang
 * Date: 2016/1/21
 * Time: 18:09
 */
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectId(int id);

    User selectLogin(String username);

}
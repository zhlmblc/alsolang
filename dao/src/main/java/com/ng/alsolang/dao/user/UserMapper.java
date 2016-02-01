package com.ng.alsolang.dao.user;


import com.ng.alsolang.domain.user.User;

/**
 * 用户操作类
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

    /**
     * 根据主键查询用户
     *
     * @param id 主键
     * @return
     */
    User selectId(Long id);

    User selectLogin(String userId);

}
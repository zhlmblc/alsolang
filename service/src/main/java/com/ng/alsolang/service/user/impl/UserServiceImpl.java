package com.ng.alsolang.service.user.impl;


import com.ng.alsolang.dao.user.UserMapper;
import com.ng.alsolang.domain.user.User;
import com.ng.alsolang.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务类
 * User: zhangxuegang
 * Date: 2016/1/20
 * Time: 14:48
 */

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userDao;

    /**
     * 根据主键查询用户
     *
     * @param id 主键
     * @return
     */
    public User getUserById(Long id) {
        // TODO Auto-generated method stub
        System.out.println(id + this.userDao.selectId(id).getUserName());
        return this.userDao.selectId(id);
    }


    public Boolean getLoginUser(User userLogin) {
        // TODO Auto-generated method stub
        if (userLogin.getUserId().equals("") || (userLogin.getPassword().equals(""))) {
            return false;
        } else {
            User user = new User();
            if (this.userDao.selectLogin(userLogin.getUserId()) != null) {

                user = userDao.selectLogin(userLogin.getUserId());

                if (user.toString().isEmpty()) {

                    return false;
                } else {

                    if (user.getPassword().equals(userLogin.getPassword())) {
                        return true;
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
    }


    public User user(User user) {
        // TODO Auto-generated method stub
        return null;
    }


    public User selectLogin(String username) {
        // TODO Auto-generated method stub
        return this.userDao.selectLogin(username);
    }


    public User selectByPrimaryKey(int i) {
        // TODO Auto-generated method stub
        return this.userDao.selectByPrimaryKey(i);
    }


    public User getUserByUserId(String userId) {
        // TODO Auto-generated method stub
        return this.userDao.selectLogin(userId);
    }


    /**
     * 用户插入
     * @param user
     * @return
     */
    public Boolean insert(User user) {
        Boolean flag = false;
        try {
            int i = this.userDao.insert(user);
            if (i == 1) {
                flag = true;
            }
        } catch (Exception e) {
            logger.error("insert User wrong -->", e);
        }
        return flag;
    }


}

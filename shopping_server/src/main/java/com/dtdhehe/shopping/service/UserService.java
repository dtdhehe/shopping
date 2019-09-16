package com.dtdhehe.shopping.service;

import com.dtdhehe.shopping.entity.User;

/**
 * @author Xie_东
 * @version 1.0
 * @date 2019/9/14 17:09
 * @description
 **/
public interface UserService {

    /**
     * 根据用户名查找用户
     * @param userName
     * @return
     */
    User findByUserName(String userName);

    /**
     * 保存用户(注册)
     * @param user
     * @return
     */
    Integer saveOrUpdateUser(User user);
}

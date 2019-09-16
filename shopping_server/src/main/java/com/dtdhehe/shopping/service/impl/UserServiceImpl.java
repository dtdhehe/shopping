package com.dtdhehe.shopping.service.impl;

import com.dtdhehe.shopping.entity.User;
import com.dtdhehe.shopping.mapper.UserMapper;
import com.dtdhehe.shopping.service.UserService;
import com.dtdhehe.shopping.util.ConstantUtils;
import com.dtdhehe.shopping.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @author Xie_东
 * @version 1.0
 * @date 2019/9/14 17:10
 * @description
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }

    @Override
    public Integer saveOrUpdateUser(User user) {
        if (StringUtils.isEmpty(user.getId())){
            //id为空，新增用户
            user.setId(ConstantUtils.getUniqueKey());
            //取用户名作为加密盐
            user.setPassword(UserUtils.getPWD(user.getPassword(),user.getUserName()));
            user.setValid(ConstantUtils.NOTACTIVE);
            user.setCreateTime("111");
            return userMapper.save(user);
        }else {
            //TODO 修改用户
            return null;
        }
    }
}

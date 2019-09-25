package com.dtdhehe.shopping.controller;

import com.dtdhehe.shopping.entity.User;
import com.dtdhehe.shopping.service.UserService;
import com.dtdhehe.shopping.util.ConstantUtils;
import com.dtdhehe.shopping.util.ResultUtils;
import com.dtdhehe.shopping.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xie_东
 * @version 1.0
 * @date 2019/8/7 11:31
 * @description
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResultVO registeUser(User user){
        User dbUser = userService.findByUserName(user.getUserName());
        if (dbUser != null){
            return ResultUtils.failed("该用户名已被使用");
        }
        Integer result = userService.saveOrUpdateUser(user);
        return result.equals(ConstantUtils.SUCCESS)?ResultUtils.success("注册成功",user):ResultUtils.failed("注册失败,请重新注册");
    }
}

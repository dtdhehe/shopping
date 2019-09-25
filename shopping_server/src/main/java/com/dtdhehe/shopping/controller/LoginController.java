package com.dtdhehe.shopping.controller;

import com.dtdhehe.shopping.entity.User;
import com.dtdhehe.shopping.util.ResultUtils;
import com.dtdhehe.shopping.vo.ResultVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

/**
 * @author Xie_东
 * @version 1.0
 * @date 2019/9/12 17:58
 * @description
 **/
@RestController
public class LoginController {

    @RequestMapping(value = "/unLogin",method = RequestMethod.POST)
    @CrossOrigin
    public ResultVO unLogin(){
        return ResultUtils.failed("未登录");
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @CrossOrigin
    public ResultVO login(@RequestBody User user){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getPassword());
        try {
            subject.login(token);
            return ResultUtils.success("login");
        }catch (UnknownAccountException e){
            e.printStackTrace();
            return ResultUtils.failed("用户名不存在");
        }catch (DisabledAccountException e){
            e.printStackTrace();
            return ResultUtils.failed("该用户未激活");
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            return ResultUtils.failed("密码错误");
        }
    }
}

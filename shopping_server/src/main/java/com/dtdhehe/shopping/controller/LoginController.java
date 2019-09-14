package com.dtdhehe.shopping.controller;

import com.dtdhehe.shopping.entity.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xie_东
 * @version 1.0
 * @date 2019/9/12 17:58
 * @description
 **/
@RestController
public class LoginController {

    @RequestMapping("/login")
    @CrossOrigin
    public String login(@RequestBody User user){
        String userName = user.getUserName();
        return "200";
    }
}

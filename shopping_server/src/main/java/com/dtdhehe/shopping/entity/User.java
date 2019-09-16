package com.dtdhehe.shopping.entity;

import lombok.Data;

/**
 * @author Xie_东
 * @version 1.0
 * @date 2019/9/12 17:56
 * @description
 **/
@Data
public class User {
    private String id;

    private String userName;

    private String password;

    private String gender;

    private String nickName;

    private String phone;

    private String email;

    private String motto;

    private String valid;

    private String createTime;
}

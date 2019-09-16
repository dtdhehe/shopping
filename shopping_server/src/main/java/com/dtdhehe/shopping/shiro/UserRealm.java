package com.dtdhehe.shopping.shiro;

import com.dtdhehe.shopping.entity.User;
import com.dtdhehe.shopping.service.UserService;
import com.dtdhehe.shopping.util.ConstantUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Xie_东
 * @version 1.0
 * @date 2019/8/1 20:49
 * @description
 **/
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("进行授权");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principalCollection.getPrimaryPrincipal();
        return authorizationInfo;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("进行认证");
        String userName = (String) authenticationToken.getPrincipal();
        User dbUser = userService.findByUserName(userName);
        if (dbUser == null){
            //用户不存在
            throw new UnknownAccountException();
        }
        if (ConstantUtils.NOTACTIVE.equals(dbUser.getValid())){
            throw new DisabledAccountException();
        }
        if (ConstantUtils.LOCKED.equals(dbUser.getValid())){
            throw new LockedAccountException();
        }
        return new SimpleAuthenticationInfo(dbUser,dbUser.getPassword(),ByteSource.Util.bytes(dbUser.getUserName()),getName());
    }
}

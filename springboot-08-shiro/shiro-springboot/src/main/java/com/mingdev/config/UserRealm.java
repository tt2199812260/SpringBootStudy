package com.mingdev.config;


import com.mingdev.pojo.User;
import com.mingdev.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

//自定义UserRealm   extends AuthorizingRealm
public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行=> 授权 doGetAuthorizationInfo");
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User)subject.getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.addStringPermission("user:add");
        info.addStringPermission(currentUser.getPerms());

        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行=> 认证 doGetAuthenticationInfo");

//        //用户名，密码 取数据
//        String name ="root";
//        String pwd = "123456";



        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        //连接数据库
        User user = userService.queryUserByName(userToken.getUsername());
//        if(!userToken.getUsername().equals(name)){
//            return null;//抛出异常 UnknownAccountException
//        }
        if(user == null){
            //美哟有这个人
            return null;
        }
        Subject currentSubject = SecurityUtils.getSubject();
        Session session =  currentSubject.getSession();
        session.setAttribute("loginUser",user);

        //密码认证，，shiro做了~~

        return new SimpleAuthenticationInfo(user,user.getPwd(),"");
    }
}

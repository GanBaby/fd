package com.fdbill.manage.config.shiro;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.fdbill.manage.entity.sys.User;
import com.fdbill.manage.service.sys.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 甘小涛哇 on 2019/8/17
 */
public class FdRealm extends AuthorizingRealm {

    private static final Logger log = LoggerFactory.getLogger(AuthorizingRealm.class);

    @Autowired
    private IUserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        String name = (String) principalCollection.getPrimaryPrincipal();
        //根据用户名去数据库查询用户信息
        User user = userService.selectOne(new EntityWrapper<User>().eq("name", name));
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        for (Role role : user.getRoles()) {
//            //添加角色
//            simpleAuthorizationInfo.addRole(role.getRoleName());
//            //添加权限
//            for (Permissions permissions : role.getPermissions()) {
//                simpleAuthorizationInfo.addStringPermission(permissions.getPermissionsName());
//            }
//        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("Shiro开始登录认证");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //获取用户信息
        String name = token.getUsername();
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (token.getUsername() == null) {
            throw new UnknownAccountException();
        }
        User user = userService.selectOne(new EntityWrapper<User>().eq("name", name));
        // 账号不存在时，抛出异常让AccountController处理
        if (user == null || null == user.getId()) {
            //这里返回后会报出对应异常
            throw new UnknownAccountException();
        } else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(),ShiroByteSource.of(user.getSalt()), getName());
            return simpleAuthenticationInfo;
        }
    }



}

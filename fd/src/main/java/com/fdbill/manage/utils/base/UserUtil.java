package com.fdbill.manage.utils.base;

import com.fdbill.manage.entity.sys.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by 甘银涛 on 2019/5/2 23:28
 */
public class UserUtil{
    public static final String LOGIN_USER = "user";

    public static void setUser(User user){
        getSession().setAttribute(LOGIN_USER, user);
    }

    public static User getUser(HttpSession session){
        return (User)session.getAttribute(LOGIN_USER);
    }

    public static User getUser(){
        return (User)getSession().getAttribute(LOGIN_USER);
    }

    public static HttpSession getSession(){
        return getRequest().getSession();
    }

    public static HttpServletRequest getRequest(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        return request;
    }

}
package com.fdbill.manage.controller.sys;

import com.fdbill.manage.entity.sys.User;
import com.fdbill.manage.service.sys.IUserService;
import com.fdbill.manage.utils.base.BaseController;
import com.fdbill.manage.utils.base.Message;
import com.fdbill.manage.utils.base.MessageCode;
import com.fdbill.manage.utils.util.RequestUtil;
import com.fdbill.manage.utils.util.Utils;
import com.google.common.collect.Maps;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by 甘银涛 on 2019/5/3 20:24
 * 账号Controller
 */
@RequestMapping(value = "/account")
@RestController
public class AccountController extends BaseController {

    @Autowired
    private IUserService userService;

    /**
     * 账号登录
     *
     * @param param
     * @return
     */
    @PostMapping(value = "/login")
    public Message selectListObj(HttpServletRequest request, @RequestParam Map<String, String> param) {
        String name = param.get("userName");
        String password = param.get("password");
        String ip = param.get("ip");
        try {
            Map<String, Object> map = new ConcurrentHashMap();
            if (StringUtils.isEmpty(name) && StringUtils.isEmpty(password)
                    && StringUtils.isEmpty(ip)) {
                map.put("status", "error");
                map.put("roleType", -1);
                return renderError(MessageCode.FAIL_LOGIN, map);
            }
            //添加用户认证信息
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                    name,
                    password
            );
//            usernamePasswordToken.setRememberMe(true);
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
//            User user = userService.login(name,password);
            //获取天气信息
//            Map<String, Object> weatherData = RequestUtil.getWeatherData(ip);
//            setUser(user);
//            map.put("weatherData", weatherData);
            map.put("status", "ok");
//            map.put("roleType", user.getRoleType());
//            map.put("user", user);
            return renderSuccess(map);
        } catch (UnknownAccountException e) {
            Map<String, Object> map = Maps.newHashMap();
            map.put("status", "error");
            map.put("roleType", -1);
            return renderError(MessageCode.FAIL_LOGIN, map);
        }catch (Exception e){
            e.printStackTrace();
            return renderException(e);
        }

    }

    /**
     * 退出登录
     *
     * @param param
     * @return
     */
    @PostMapping(value = "/loginOut")
    public Message loginOut(@RequestParam Map<String, String> param) {
        try {
            //清空session中的user
            setUser(null);
            return renderSuccess();
        } catch (Exception e) {
            return renderException(e);
        }
    }

}

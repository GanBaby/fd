package com.fdbill.manage.controller.sys;

import com.fdbill.manage.entity.sys.User;
import com.fdbill.manage.service.sys.IUserService;
import com.fdbill.manage.utils.base.BaseController;
import com.fdbill.manage.utils.base.MessageCode;
import com.fdbill.manage.utils.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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
     * @param param
     * @return
     */
    @PostMapping(value="/login")
    public Object selectListObj(@RequestParam Map<String,String> param){
        try{
            String name = param.get("userName");
            String password = param.get("password");
            Map<String,Object> map = new ConcurrentHashMap();
            if (StringUtils.isEmpty(name)&&StringUtils.isEmpty(password)){
                map.put("status","error");
                map.put("roleType",-1);
                return renderError(MessageCode.FAIL_LOGIN,map);
            }
            User user = userService.login(name,password);
            //判断是否登录成功
            if(Utils.isObjEmpty(user)){
                map.put("status","error");
                map.put("roleType",-1);
                return renderError(MessageCode.FAIL_LOGIN,map);
            }
            setUser(user);
            map.put("status","ok");
            map.put("roleType",user.getRoleType());
            map.put("user",user);
            return renderSuccess(map);
        }catch(Exception e){
            return renderException(e);
        }
    }

}

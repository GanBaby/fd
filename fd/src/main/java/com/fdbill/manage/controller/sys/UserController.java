package com.fdbill.manage.controller.sys;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.fdbill.manage.entity.sys.User;
import com.fdbill.manage.service.shiro.PasswordHash;
import com.fdbill.manage.service.sys.IUserService;
import com.fdbill.manage.utils.base.BaseController;
import com.fdbill.manage.utils.base.MessageCode;
import com.fdbill.manage.utils.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author 甘银涛
 * @since 2019-05-01
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @Autowired
    private PasswordHash passwordHash;


    /**
     * 查询所有的用户列表
     * @param param
     * @return
     */
    @PostMapping(value="/selectListObj")
    public Object selectListObj(@RequestParam Map<String,String> param){
        List<User> users = userService.selectListObj(param);
        return users;
    }

    /**
     * 查询所有的用户列表
     * @param param
     * @return
     */
    @PostMapping(value="/selectListByMap")
    public Object selectListMap(@RequestParam Map<String,Object> param){
        List<User> users = userService.selectByMap(param);
        return users;
    }

    /**
     * 查询所有的用户列表Page
     * @param param
     * @return
     */
    @PostMapping(value="/selectListPage")
    public Object selectListPage(@RequestParam Map<String,String> param){
        Integer current = Integer.parseInt(param.get("current"));
        Page<User> userPage = userService.selectPage(new Page<>(current, 2), new EntityWrapper<>());
        return userPage;
    }

    /**
     * 添加用户
     * @param param
     * @return
     */
    @PostMapping(value="/addUser")
    public Object addUser(@RequestParam Map<String,String> param){
        String name = param.get("name");
        String password = param.get("password");
        String phone = param.get("phone");
        if(StringUtils.isEmpty(name)||StringUtils.isEmpty(password)||StringUtils.isEmpty(phone)){
            return renderError(MessageCode.PARAMS_ERROR);
        }
        try {
            String salt = Utils.genUUID();
            password = passwordHash.toHex(password,salt);
            User user = new User();
            user.setInit();
            user.setPhone(phone);
            user.setPassword(password);
            user.setHeadPhone("https://gw.alipayobjects.com/zos/antfincdn/XAosXuNZyF/BiazfanxmamNRoxxVxka.png");
            user.setName(name);
            user.setSalt(salt);
            userService.insert(user);
            return renderSuccess(MessageCode.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return renderException(e);
        }

    }





}

package com.fdbill.manage.controller.sys;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.fdbill.manage.entity.sys.User;
import com.fdbill.manage.service.sys.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
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
public class UserController {

    @Autowired
    private IUserService userService;

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
    @PostMapping(value="/selectListMap")
    public Object selectListMap(@RequestParam Map<String,String> param){
        List<Map<String,Object>> users = userService.selectListMap(param);
        return users;
    }

    /**
     * 查询所有的用户列表
     * @param param
     * @return
     */
    @PostMapping(value="/selectList")
    public Object selectList(@RequestParam Map<String,String> param){
        List<User> users = userService.selectList(new EntityWrapper<User>().eq("name", "小红"));
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



}

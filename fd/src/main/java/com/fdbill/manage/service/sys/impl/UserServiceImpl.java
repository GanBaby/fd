package com.fdbill.manage.service.sys.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.fdbill.manage.entity.sys.User;
import com.fdbill.manage.mapper.sys.UserMapper;
import com.fdbill.manage.service.sys.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author 甘银涛
 * @since 2019-05-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 用户登陆
     * @param name
     * @param password
     * @return
     */
    public User login(String name,String password){
        return userMapper.login(name,password);
    };

    public List<User> selectListObj(Map map){
        return userMapper.selectListObj(map);
    };

    public List<Map<String,Object>> selectListMap(Map map){
        return userMapper.selectListMap(map);
    };

}

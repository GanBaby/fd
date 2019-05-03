package com.fdbill.manage.service.sys;

import com.baomidou.mybatisplus.service.IService;
import com.fdbill.manage.entity.sys.User;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author 甘银涛
 * @since 2019-05-01
 */
public interface IUserService extends IService<User> {

    /**
     * 用户登陆
     * @param name
     * @param password
     * @return
     */
    User login(String name,String password);

    List<User>  selectListObj(Map map);

    List<Map<String,Object>> selectListMap(Map map);

}

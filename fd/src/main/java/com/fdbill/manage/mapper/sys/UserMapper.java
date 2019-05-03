package com.fdbill.manage.mapper.sys;

import com.fdbill.manage.entity.sys.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
  * 用户信息表 Mapper 接口
 * </p>
 *
 * @author 甘银涛
 * @since 2019-05-01
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 用户登陆
     * @param name
     * @param password
     * @return
     */
    User login(@Param(value="name") String name,@Param(value="password")String password);

    List<User> selectListObj(Map map);

    List<Map<String,Object>> selectListMap(Map map);

}
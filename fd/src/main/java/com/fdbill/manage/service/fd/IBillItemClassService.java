package com.fdbill.manage.service.fd;

import com.baomidou.mybatisplus.service.IService;
import com.fdbill.manage.entity.fd.BillItemClass;

import java.util.Map;

/**
 * <p>
 * 子账单类别表 服务类
 * </p>
 *
 * @author 甘银涛
 * @since 2019-05-01
 */
public interface IBillItemClassService extends IService<BillItemClass> {

    /**
     * 获取收入和支出类别列表
     * @param map
     * @return
     */
    Map<String,Object> selectList(Map map);

}

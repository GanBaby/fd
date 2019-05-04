package com.fdbill.manage.service.fd;

import com.baomidou.mybatisplus.service.IService;
import com.fdbill.manage.entity.fd.Bill;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 账单表 服务类
 * </p>
 *
 * @author 甘银涛
 * @since 2019-05-01
 */
public interface IBillService extends IService<Bill> {

    /**
     * 查询最近一年的收入
     * @param beginDate
     * @param endDate
     * @param userId
     * @return
     */
    List<Map<String,Object>> selectLastYearIncome(String beginDate,String endDate,String userId);

    List<Bill> selectList(Map map);
}

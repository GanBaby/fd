package com.fdbill.manage.service.fd.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.fdbill.manage.config.dataSourceConfig.DataSource;
import com.fdbill.manage.config.dataSourceConfig.DataSourceEnum;
import com.fdbill.manage.entity.fd.Bill;
import com.fdbill.manage.mapper.fd.BillMapper;
import com.fdbill.manage.service.fd.IBillService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 账单表 服务实现类
 * </p>
 *
 * @author 甘银涛
 * @since 2019-05-01
 */
@Service
public class BillServiceImpl extends ServiceImpl<BillMapper, Bill> implements IBillService {

    @Resource
    private BillMapper billMapper;

    /**
     * 查询最近一年的收入
     * @param beginDate
     * @param endDate
     * @param userId
     * @return
     */
    @DataSource(DataSourceEnum.FD)
    public List<Map<String,Object>> selectLastYearIncome(String beginDate, String endDate, String userId){
        return billMapper.selectLastYearIncome(beginDate,endDate,userId);
    };

    /**
     * 获取当前用户的所有账单列表
     * @param map
     * @return
     */
    @DataSource(DataSourceEnum.FD)
    public List<Bill> selectList(Map map){
        return billMapper.selectByMap(map);
    };
}

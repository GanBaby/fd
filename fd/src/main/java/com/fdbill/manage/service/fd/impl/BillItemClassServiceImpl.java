package com.fdbill.manage.service.fd.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.fdbill.manage.config.dataSourceConfig.DataSource;
import com.fdbill.manage.config.dataSourceConfig.DataSourceEnum;
import com.fdbill.manage.entity.fd.BillItemClass;
import com.fdbill.manage.mapper.fd.BillItemClassMapper;
import com.fdbill.manage.service.fd.IBillItemClassService;
import com.fdbill.manage.utils.global.Global;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 子账单类别表 服务实现类
 * </p>
 *
 * @author 甘银涛
 * @since 2019-05-01
 */
@Service
public class BillItemClassServiceImpl extends ServiceImpl<BillItemClassMapper, BillItemClass> implements IBillItemClassService {

    @Resource
    private BillItemClassMapper billItemClassMapper;

    /**
     * 获取收入和支出类别列表
     * @param map
     * @return
     */
    @DataSource(DataSourceEnum.FD)
    public Map<String,Object> selectList(Map map){
        //获取支出的分类列表
        map.put("type", Global.OUTCOME_TYPE);
        List outList = billItemClassMapper.selectByMap(map);
        //获取收入的分类列表
        map.put("type", Global.INCOME_TYPE);
        List inList = billItemClassMapper.selectByMap(map);
        map.remove("type");
        map.put("outList",outList);
        map.put("inList",inList);
        return  map;
    };

}

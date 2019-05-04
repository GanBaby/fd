package com.fdbill.manage.mapper.fd;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.fdbill.manage.entity.fd.Bill;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
  * 账单表 Mapper 接口
 * </p>
 *
 * @author 甘银涛
 * @since 2019-05-01
 */
public interface BillMapper extends BaseMapper<Bill> {

    /**
     * 查询最近一年的收入
     * @param beginDate
     * @param endDate
     * @param userId
     * @return
     */
    List<Map<String,Object>> selectLastYearIncome(@Param(value="beginDate") String beginDate,
                                                  @Param(value="endDate")String endDate,
                                                  @Param(value="userId")String userId);

    List<Bill> selectByMap(Map map);

}
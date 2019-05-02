package com.fdbill.manage.mapper.fd;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.fdbill.manage.entity.fd.Bill;
import org.mapstruct.Mapper;

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

    List<Bill> selectByMap(Map map);

}
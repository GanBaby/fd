package com.fdbill.manage.service.fd.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.fdbill.manage.entity.fd.BillItemClass;
import com.fdbill.manage.mapper.fd.BillItemClassMapper;
import com.fdbill.manage.service.fd.IBillItemClassService;
import org.springframework.stereotype.Service;

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
	
}

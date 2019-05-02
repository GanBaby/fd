package com.fdbill.manage.service.fd.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.fdbill.manage.entity.fd.BillItem;
import com.fdbill.manage.mapper.fd.BillItemMapper;
import com.fdbill.manage.service.fd.IBillItemService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账单子表 服务实现类
 * </p>
 *
 * @author 甘银涛
 * @since 2019-05-01
 */
@Service
public class BillItemServiceImpl extends ServiceImpl<BillItemMapper, BillItem> implements IBillItemService {
	
}

package com.fdbill.manage.controller.fd;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.fdbill.manage.entity.fd.Bill;
import com.fdbill.manage.service.fd.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 账单表 前端控制器
 * </p>
 *
 * @author 甘银涛
 * @since 2019-05-01
 */
@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private IBillService billService;

    /**
     * 查询所有的账单列表
     * @param param
     * @return 实体类列表
     */
    @PostMapping(value="/selectList")
    public Object selectList(@RequestParam Map<String,String> param){
        List<Bill> list = billService.selectList(param);
        return list;
    }

}

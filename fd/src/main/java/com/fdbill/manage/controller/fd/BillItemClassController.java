package com.fdbill.manage.controller.fd;

import com.fdbill.manage.entity.fd.Bill;
import com.fdbill.manage.service.fd.IBillItemClassService;
import com.fdbill.manage.utils.base.BaseController;
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
 * 子账单类别表 前端控制器
 * </p>
 *
 * @author 甘银涛
 * @since 2019-05-01
 */
@RestController
@RequestMapping("/billItemClass")
public class BillItemClassController extends BaseController {

    @Autowired
    private IBillItemClassService billItemClassService;

    /**
     * 获取支出和收入类别列表
     * @param param
     * @return 实体类列表
     */
    @PostMapping(value="/selectList")
    public Object selectList(@RequestParam Map<String,Object> param){
        try{
            Map<String, Object> resultMap = billItemClassService.selectList(param);
            return renderSuccess(resultMap);
        }catch(Exception e){
            return renderException(e);
        }
    }


}

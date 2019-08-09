package com.fdbill.manage.controller.fd;

import com.fdbill.manage.entity.fd.Bill;
import com.fdbill.manage.entity.sys.User;
import com.fdbill.manage.service.fd.IBillService;
import com.fdbill.manage.utils.base.BaseController;
import com.fdbill.manage.utils.base.Message;
import com.fdbill.manage.utils.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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
public class BillController extends BaseController {

    @Autowired
    private IBillService billService;

    /**
     * 获取当前用户的所有账单信息
     * @param param
     * @return 实体类列表
     */
    @PostMapping(value="/selectList")
    public Object selectList(@RequestParam Map<String,Object> param){
        try{
            param.put("create_user_id",getUser().getId());
            List<Bill> list = billService.selectList(param);
            return renderSuccess(list);
        }catch(Exception e){
            return renderException(e);
        }
    }

    /**
     * 查询最近一年的收入
     * @param param
     * @return
     */
    @PostMapping(value="/selectLastYearStatDate")
    public Message selectLastYearStatDate(@RequestParam Map<String,String> param){
        try{
            Date date = new Date();
            //获取当前月的最后一天最后一秒的Date
            String endDate = DateUtils.formatDateTime(DateUtils.getDayEnd(DateUtils.getLastDayOfMonth(date)));
            //获取去年下个月的第一天的第一秒的Date
            String beginDate = DateUtils.formatDateTime(DateUtils.getDayStart(DateUtils.getFirstDayOfMonth(DateUtils.addMonth(date, -11))));
            User user = getUser();
            List<Map<String,Object>> list = billService.selectLastYearStatDate(beginDate,endDate,user.getId());
            return renderSuccess(list);
        }catch(Exception e){
            return renderException(e);
        }
    }



}

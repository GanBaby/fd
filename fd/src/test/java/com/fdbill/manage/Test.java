package com.fdbill.manage;

import com.fdbill.manage.entity.sys.User;
import com.fdbill.manage.utils.util.DateUtils;
import com.fdbill.manage.utils.util.JsonUtil;
import com.fdbill.manage.utils.util.Utils;

import java.util.*;

/**
 * Created by 甘银涛 on 2019/5/3 21:57
 */
public class Test {

    public static void main(String[] args){
        Date date = new Date();
        Date lastDayOfMonth = DateUtils.getDayEnd(DateUtils.getLastDayOfMonth(date));
        Date date1 = DateUtils.getDayStart(DateUtils.getFirstDayOfMonth(DateUtils.addMonth(date, -11)));
        System.out.printf(lastDayOfMonth.toString());
    }

}

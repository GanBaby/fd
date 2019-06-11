package com.fdbill.manage;

import com.fdbill.manage.app.Application;
import com.fdbill.manage.entity.sys.User;
import com.fdbill.manage.service.fd.IBillItemClassService;
import com.fdbill.manage.utils.util.DateUtils;
import com.fdbill.manage.utils.util.JsonUtil;
import com.fdbill.manage.utils.util.RequestUtil;
import com.fdbill.manage.utils.util.Utils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.*;

/**
 * Created by 甘银涛 on 2019/5/3 21:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Test {

    @Autowired
    private IBillItemClassService billItemClassService;

    @org.junit.Test
    public void test(){
        Map<String, Object> stringObjectMap = billItemClassService.selectList(new HashMap());
        System.out.printf("123");
    }

}

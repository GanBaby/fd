package com.fdbill.manage.controller.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by 甘小涛哇 on 2019/8/18
 */
@RestController
public class ApiController {

    /**
     * 查询所有的用户列表Page
     * @param param
     * @return
     */
    @PostMapping(value="/api/test")
    public Object test1(@RequestParam Map<String,String> param){
        return "hello world1";
    }

    /**
     * 查询所有的用户列表Page
     * @param param
     * @return
     */
    @PostMapping(value="/api/test/test")
    public Object test2(@RequestParam Map<String,String> param){
        return "hello world2";
    }


}

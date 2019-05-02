package com.fdbill.manage.utils.util;

import java.util.Collection;
import java.util.UUID;

/**
 * Created by 甘银涛 on 2019/5/2 23:11
 */
public class Utils{

    /**
     * 生成UUID
     * @return
     */
    public static String genUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 判断集合是否为空
     * @param list
     * @return
     */
    public static boolean isNotEmptyList(Collection list){
        if ((list != null) && (list.size() > 0)) {
            return true;
        }
        return false;
    }
}
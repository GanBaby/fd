package com.fdbill.manage.utils.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
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
     * 判断对象是否为空或者数据是非为空
     * list:null时返回true，list.size()=0时返回true 有数据返回false
     * map和object:null时返回true, 没数据时返回true,有数据时返回false
     * @param obj
     * @return
     */
    public static boolean isObjEmpty(Object obj) {
         if (obj == null){
             return true;
         }else if (obj instanceof CharSequence){
             return ((CharSequence) obj).length() == 0;
         }else if (obj instanceof Collection){
             return ((Collection) obj).isEmpty();
         }else if (obj.getClass().isArray()){
             return Array.getLength(obj) == 0;
         }else{
             Map objMap = JsonUtil.ObjectToMap(obj);
             return objMap.isEmpty()&&objMap.size()==0;
         }
    }



}
package com.fdbill.manage.utils.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;
import java.util.Map;

/**
 * Created by 甘银涛 on 2019/5/2 21:26
 */

public class JsonUtil{

    /**
     * map转json
     * @param map
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T mapToObject(Map map, Class<T> clazz){
        String objStr = ObjectTojson(map);
        return (T) JSON.parseObject(objStr, clazz);
    }

    /**
     * 对象转map
     * @param obj
     * @return
     */
    public static Map ObjectToMap(Object obj){
        String objStr = ObjectTojson(obj);
        return jsonToObject(objStr,Map.class);
    }

    /**
     * json转对象
     * @param str
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T jsonToObject(String str, Class<T> clazz){
        return (T)JSON.parseObject(str, clazz);
    }

    /**
     * 对象转json
     * @param obj
     * @return
     */
    public static String ObjectTojson(Object obj){
        return ObjectTojson(obj, false);
    }

    /**
     * 对象转json
     * @param obj
     * @param useDateFormat 是否带时间格式
     * @return
     */
    public static String ObjectTojson(Object obj, boolean useDateFormat){
        return ObjectTojson(obj, useDateFormat, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 对象转json自定义时间格式
     * @param obj
     * @param dateFormat
     * @return
     */
    public static String ObjectTojson(Object obj, String dateFormat){
        return ObjectTojson(obj, true, dateFormat);
    }

    private static String ObjectTojson(Object obj, boolean useDateFormat, String dateFormat){
        if (useDateFormat){
            return JSON.toJSONStringWithDateFormat(obj, dateFormat, new SerializerFeature[0]);
        }
        return JSON.toJSONString(obj);
    }

    /**
     * json转集合
     * @param str
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> jsonTolist(String str, Class<T> clazz){
        return JSON.parseArray(str, clazz);
    }
}
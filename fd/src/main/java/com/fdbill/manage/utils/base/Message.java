package com.fdbill.manage.utils.base;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by 甘银涛 on 2019/5/3 2:47
 */
public class Message {
    //返回的消息状态对象
    private String code;
    //结果信息
    private String msg;
    //结果内容
    private Object data;

    /**
     * 自定义消息时使用的构造
     * @param messageCode
     * @param msg
     * @param data
     */
    public Message(MessageCode messageCode, Object data, String msg) {
        this.code = messageCode.val();
        this.data = data;
        this.msg = msg;
    }

    /**
     * 自定义消息时使用的构造
     * @param messageCode
     * @param msg
     */
    public Message(MessageCode messageCode, String msg) {
        this.code = messageCode.val();
        this.msg = msg;
    }

    /**
     * 默认使用MessageCode的消息时使用的构造
     * @param messageCode
     */
    public Message(MessageCode messageCode, Object data) {
        this.code = messageCode.val();
        this.msg = messageCode.msg();
        this.data = data;
    }

    /**
     * 默认使用MessageCode的消息时使用的构造
     * @param messageCode
     */
    public Message(MessageCode messageCode) {
        this.code = messageCode.val();
        this.msg = messageCode.msg();
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}

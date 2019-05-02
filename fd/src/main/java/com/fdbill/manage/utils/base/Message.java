package com.fdbill.manage.utils.base;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by 甘银涛 on 2019/5/3 2:47
 */
public class Message {
    //返回的消息状态对象
    private String code;
    //结果信息
    private String message;
    //结果内容
    private Object data;

    /**
     * 自定义消息时使用的构造
     * @param messageCode
     * @param message
     * @param data
     */
    public Message(MessageCode messageCode, Object data, String message) {
        this.code = messageCode.val();
        this.data = data;
        this.message = message;
    }

    /**
     * 自定义消息时使用的构造
     * @param messageCode
     * @param message
     */
    public Message(MessageCode messageCode, String message) {
        this.code = messageCode.val();
        this.message = message;
    }

    /**
     * 默认使用MessageCode的消息时使用的构造
     * @param messageCode
     */
    public Message(MessageCode messageCode, Object data) {
        this.code = messageCode.val();
        this.message = messageCode.msg();
        this.data = data;
    }

    /**
     * 默认使用MessageCode的消息时使用的构造
     * @param messageCode
     */
    public Message(MessageCode messageCode) {
        this.code = messageCode.val();
        this.message = messageCode.msg();
    }


    /**
     * 错误时返回默认信息
     * @param messageCode
     * @return
     */
    public Message renderError(MessageCode messageCode)
    {
        return new Message(messageCode);
    }

    /**
     * 错误时返回自定义的消息
     * @param messageCode
     * @param message
     * @return
     */
    public Message renderError(MessageCode messageCode,String message)
    {
        return new Message(messageCode, message);
    }

    /**
     * 异常时返回的消息
     * @param e
     * @return
     */
    public Message renderException(Exception e)
    {
        e.printStackTrace();
        return new Message(MessageCode.EXCEPTION, e.getMessage());

    }

    /**
     * 成功，默认消息无数据
     * @return
     */
    public Message renderSuccess(){
        return new Message(MessageCode.SUCCESS);
    }

    /**
     * 成功，默认消息有数据
     * @return
     */
    public Message renderSuccess(Object data){
        return new Message(MessageCode.SUCCESS,data);
    }

    /**
     * 成功，自定义消息有数据
     * @return
     */
    public Message renderSuccess(Object data,String message){
        return new Message(MessageCode.SUCCESS,data,message);
    }

    /**
     * 成功，自定义消息无数据
     * @return
     */
    public Message renderSuccess(String message){
        return new Message(MessageCode.SUCCESS,message);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}

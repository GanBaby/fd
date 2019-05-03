package com.fdbill.manage.utils.base;

/**
 * Created by 甘银涛 on 2019/5/3 2:51
 * 基础Controller
 */
public class BaseController extends UserUtil {

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
     * 错误时返回自定义的消息对象和数据
     * @param messageCode
     * @param data
     * @return
     */
    public Message renderError(MessageCode messageCode,Object data)
    {
        return new Message(messageCode, data);
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

}

package com.fdbill.manage.utils.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdbill.manage.utils.base.Message;
import org.springframework.util.StringUtils;

/**
 * Created by 甘银涛 on 2019/5/5 21:43
 */
public class RequestUtil{
    public static void commonOut(HttpServletResponse response, String msg)throws IOException{
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = null;
        out = response.getWriter();
        out.print(msg);
        out.flush();
        out.close();
    }

    public static void commonOut(HttpServletResponse response, Message message)
            throws IOException
    {
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = null;
        out = response.getWriter();
        out.print(JSONObject.toJSON(message).toString());
        out.flush();
        out.close();
    }



    private static String xssEncode(String s){
        if ((s == null) || (s.isEmpty())) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            switch (c){
                case '\'':
                    break;
                default:
                    sb.append(c);
            }
        }
        return sb.toString();
    }


    public static String getIpAddr(HttpServletRequest request)
    {
        String ip = request.getHeader("X-Forwarded-For");
        if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
            ip = request.getHeader("X-real-ip");
        }
        if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
            ip = request.getRemoteAddr();
        }
        if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
            ip = request.getHeader("Host");
        }
        if ((ip != null) && (ip.indexOf(",") > -1)) {
            ip = ip.split(",")[1];
        }
        return ip;
    }
}

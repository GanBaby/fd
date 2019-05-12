package com.fdbill.manage.utils.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdbill.manage.utils.base.Message;
import org.springframework.util.StringUtils;

/**
 * Created by 甘银涛 on 2019/5/5 21:43
 */
public class RequestUtil{

    /**
     * 获取用户所在地的天气
     * @param ip 用户ip
     * @return
     */
    public static Map<String,Object> getWeatherData(String ip)throws Exception{
        //用淘宝获取城市编码
        String cityUrl = "http://ip.taobao.com/service/getIpInfo.php?ip="+ip;
        Map<String, Object> cityData = getData(cityUrl);
        //获取城市信息
        cityData = (Map<String, Object>)cityData.get("data");

        //获取地区编码
        String regionId = (String) cityData.get("region_id");
        //当地区编码为空时获取城市编码
        String searchArea = StringUtils.isEmpty(regionId)?(String) cityData.get("city_id"):regionId;
        String url="https://restapi.amap.com/v3/weather/weatherInfo?key=acf9ec011bc29f3ea6f58c34a1fbbe25&city="+searchArea;
        Map<String, Object> weatherData = getData(url);
        return weatherData;
    }

    /**
     * 联网获取数据
     * @param urlString 要访问的url
     * @return 返回获取json数据
     * @throws Exception 异常
     */
    public static Map<String,Object> getData(String urlString) throws Exception {
        String res = "";
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            URLConnection conn = (URLConnection)url.openConnection();
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            System.out.println("创建url!");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("分别获取每行内容！："+line);
                res += line;
            }
        } catch (Exception e) {
            e.getMessage();
        }finally {
            if (null!=reader){
                reader.close();
            }
        }
        return JsonUtil.jsonToObject(res,Map.class);
    }


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

    private final static String UNKNOWN = "unknown";
    private final static String LOCALHOST_IPV4 = "127.0.0.1";
    private final static String LOCALHOST_IPV6 = "0:0:0:0:0:0:0:1";

    /**
     * 获取登录用户的IP地址
     *
     * @param request request
     * @return IP地址
     */
    public static String getIpAddress(final HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (LOCALHOST_IPV6.equals(ip)) {
            ip = LOCALHOST_IPV4;
        }
        if (ip.split(",").length > 1) {
            ip = ip.split(",")[0];
        }
        return ip;
    }

    /**
     * 通过IP获取地址(需要联网，调用淘宝的IP库)
     *
     * @param ip ip
     * @return 地址
     */
    public static String getIpInfo(final String ip) {
        String info = "";
        try {
            final URL url = new URL("http://ip.taobao.com/service/getIpInfo.php?ip=" + ip);
            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);

            final InputStream in = connection.getInputStream();
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            final StringBuilder temp = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                temp.append(line).append("\r\n");
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            final JSONObject obj = (JSONObject) JSON.parse(temp.toString());
            if (obj.getIntValue("code") == 0) {
                final JSONObject data = obj.getJSONObject("data");
                info += data.getString("country") + " ";
                info += data.getString("region") + " ";
                info += data.getString("city") + " ";
                info += data.getString("isp");
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return info;
    }
}

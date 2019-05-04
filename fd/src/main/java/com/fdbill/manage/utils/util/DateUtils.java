package com.fdbill.manage.utils.util;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * Created by 甘银涛 on 2019/5/2 21:44
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils{

	private static String[] parsePatterns = {
			"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
			"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
			"yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 * @return String
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 * @param pattern pattern
	 * @return String
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}

	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 * @param date date
	 * @param pattern pattern
	 * @return String
	 */
	public static String formatDate(Date date, Object... pattern) {
		if (date == null) {
			return null;
		}
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}

	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 * @param date date
	 * @return String
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 * @return String
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 * @return String
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 * @return String
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 * @return String
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * 得到当天字符串 格式（dd）
	 * @return String
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 * @return String
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}

	/**
	 * 日期型字符串转化为日期 格式
	 * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
	 * "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
	 * "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
	 * @param str str
	 * @return Date
	 */
	public static Date parseDate(Object str) {
		if (str == null) {
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 获取过去的天数
	 * @param date date
	 * @return long
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (24 * 60 * 60 * 1000);
	}

	/**
	 * 获取过去的小时
	 * @param date date
	 * @return long
	 */
	public static long pastHour(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (60 * 60 * 1000);
	}

	/**
	 * 获取过去的分钟
	 * @param date date
	 * @return long
	 */
	public static long pastMinutes(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (60 * 1000);
	}

	/**
	 * 转换为时间（天,时:分:秒.毫秒）
	 * @param timeMillis timeMillis
	 * @return String
	 */
	public static String formatDateTime(long timeMillis) {
		long day = timeMillis / (24 * 60 * 60 * 1000);
		long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
		long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		long sss = (timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
		return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
	}

	/**
	 * 获取两个日期之间的天数
	 * @param before before
	 * @param after after
	 * @return double
	 */
	public static double getDistanceOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
	}

	/**
	 * 获取当前月第一天
	 * @return String
	 */
	public static String getFirstDayOfMonth() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//获取当前月第一天：
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
		String first = format.format(c.getTime());
		return first;
	}

	/**
	 * 获取输入日期的当月第一天
	 * @param date 输入日期
	 * @return Date
	 */
	public static Date getFirstDayOfMonth(Date date) {
		Calendar cd = Calendar.getInstance();
		cd.setTime(date);
		cd.set(Calendar.DAY_OF_MONTH, 1);
		return cd.getTime();
	}

	/**
	 * 获得输入日期的当月最后一天
	 * @param date date
	 * @return Date
	 */
	public static Date getLastDayOfMonth(Date date) {
		return DateUtils.addDay(DateUtils.getFirstDayOfMonth(DateUtils.addMonth(date, 1)), -1);
	}

	/**
	 * 在输入日期上增加（+）或减去（-）天数
	 * @param date 输入日期
	 * @param iday 要增加或减少的天数
	 * @return Date
	 */
	public static Date addDay(Date date, int iday) {
		Calendar cd = Calendar.getInstance();
		cd.setTime(date);
		cd.add(Calendar.DAY_OF_MONTH, iday);
		return cd.getTime();
	}

	/**
	 * 在输入日期上增加（+）或减去（-）月份
	 * @param date 输入日期
	 * @param imonth 要增加或减少的月分数
	 * @return Date
	 */
	public static Date addMonth(Date date, int imonth) {
		Calendar cd = Calendar.getInstance();
		cd.setTime(date);
		cd.add(Calendar.MONTH, imonth);
		return cd.getTime();
	}

	/**
	 * 在输入日期上增加（+）或减去（-）年份
	 * @param date 输入日期
	 * @param iyear 要增加或减少的年数
	 * @return Date
	 */
	public static Date addYear(Date date, int iyear) {
		Calendar cd = Calendar.getInstance();
		cd.setTime(date);
		cd.add(Calendar.YEAR, iyear);
		return cd.getTime();
	}

	/**
	 * 得到day的起始时间点。
	 * @param date date
	 * @return Date
	 */
	public static Date getDayStart(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 得到day的终止时间点.
	 * @param date date
	 * @return Date
	 */
	public static Date getDayEnd(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.MILLISECOND, -1);
		return calendar.getTime();
	}

	//日期格式类
	private static SimpleDateFormat basic = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat Y_M_D = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat YMD = new SimpleDateFormat("yyyyMMdd");

	private static SimpleDateFormat yearFormatter = new SimpleDateFormat("yyyy");
	private static SimpleDateFormat monthFormatter = new SimpleDateFormat("MM");
	private static SimpleDateFormat dayFormatter = new SimpleDateFormat("dd");

	/**
	 * 转化成年月日时分秒字符串形式
	 * @param date date
	 * @return String
	 */
	public static String formatBasic( Date date ){
		return basic.format(date);
	}

	/**
	 * 转化成年月日字符串形式（yyyyMMdd）
	 * @param date date
	 * @return String
	 */
	public static String formatYMD( Date date ){
		return YMD.format(date);
	}

	/**
	 * 转化成年月日字符串形式（yyyy-MM-dd）
	 * @param date date
	 * @return String
	 */
	public static String formatY_M_D( Date date ){
		return Y_M_D.format(date);
	}

	/**
	 * 转化成年字符串形式（yyyy）
	 * @param date date
	 * @return String
	 */
	public static String getYear(Date date){
		return yearFormatter.format(date);
	}

	/**
	 * 转化成月字符串形式（MM）
	 * @param date date
	 * @return String
	 */
	public static String getMonth(Date date){
		return monthFormatter.format(date);
	}

	/**
	 * 转化成日字符串形式（dd）
	 * @param date date
	 * @return String
	 */
	public static String getDay(Date date){
		return dayFormatter.format(date);
	}

	public static Calendar calendar = Calendar.getInstance();

	/**
	 * 获取明年的开始时间
	 * @param millis millis
	 * @return long
	 */
	public static long getBeginTimeOfNextYear(long millis) {
		calendar.setTimeInMillis(millis);
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + 1);
		// 注意,第0月就是第1个月
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTimeInMillis();
	}
	/**
	 * 获取今年的剩余秒数
	 * @return long
	 */
	public static long getYearSeconds(){
		final long nowTime = System.currentTimeMillis();
		final long timeEndOfThisYear = getBeginTimeOfNextYear(nowTime);
		System.out.println((timeEndOfThisYear - nowTime)/(1000*60*60*24));
		return (timeEndOfThisYear - nowTime)/1000;
	}
}

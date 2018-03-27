package com.computerdesign.whutHouseMgmt.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式转化工具类
 * @author Administrator
 *
 */
public class DateConversionUtils {

	/**
	 * 字符串根据指定模式转换为日期类型
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static Date stringToDate(String dateStr, String pattern){
		
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 日期类型转换为指定模式的字符串
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String dateToString(Date date, String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		return sdf.format(date);
	}
}

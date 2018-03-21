package com.computerdesign.whutHouseMgmt.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.computerdesign.whutHouseMgmt.utils.StringUtil;

/**
 *
 * @author wanhaoran
 * @date 2018年3月17日 下午2:22:37
 * 
 */
public class ResponseUtil {

	public static <T> Map<String, Object> getResultMap(T t, String[] fileds) {

		Map<String, Object> map = new HashMap<>();
		Class<?> clazz = t.getClass();
		for (int i = 0; i < fileds.length; i++) {
			String filed = fileds[i];
			try {
				Method mf = clazz.getMethod("get" + StringUtil.upperHeadChar(filed));
				if (filed.contains("time") || filed.contains("Time")) {// 时间参数的处理
					Date time = (Date) mf.invoke(t);
					map.put(filed, DateUtil.getCurrentSimpleDate(time));
				} else {
					map.put(filed, mf.invoke(t));
				}
			} catch (NoSuchMethodException e) {
				System.out.println("字段" + filed + "不存在");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	public static <T> List<Map<String, Object>> getResultMap(List<T> ts, String[] fileds) {
		List<Map<String, Object>> rs = new ArrayList<>();
		for (int i = 0; i < ts.size(); i++) {
			rs.add(getResultMap(ts.get(i), fileds));
		}
		return rs;
	}

	//
	// public static List<Map<String,Integer>> getKeyValueMap(String[] names) {
	// Map<String, Integer> map = new HashMap<>();
	// for (String string : names) {
	// map.put(string,0);
	// }
	// }
}

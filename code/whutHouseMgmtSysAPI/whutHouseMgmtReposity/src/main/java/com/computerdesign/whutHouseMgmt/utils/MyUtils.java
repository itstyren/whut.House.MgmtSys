package com.computerdesign.whutHouseMgmt.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MyUtils {
	
	
//	解析管理员权限的管理校区字段
	public static List<Integer> roleIdToMP(String manageCampus){
		String[] campusStr = manageCampus.split("-");
		List<Integer> campusList = new ArrayList<>();
		for (String campus : campusStr){
			campusList.add(Integer.valueOf(campus));
		}
		return campusList;
	}
	
//	租金生成中，计算天数，三个参数
	public static long calculateDays(Date bookTime, Date startTime, Date endTime){
		// 先以预定时间计算，实际应该是签订合同时间
		Calendar c1 = Calendar.getInstance();
		c1.setTime(bookTime);

		// 开始时间
		Calendar c2 = Calendar.getInstance();
		c2.setTime(startTime);

		// 结束时间
		Calendar c3 = Calendar.getInstance();
		c3.setTime(endTime);
		
		long days = 0;

		if (c1.getTimeInMillis() <= c2.getTimeInMillis()) {
			// 预定入住时间在查询范围之前，则以查询范围为准
			days = (c3.getTimeInMillis() - c2.getTimeInMillis()) / (1000 * 60 * 60 * 24);
		} else if (c1.getTimeInMillis() < c3.getTimeInMillis()) {
			// 预定入住时间在查询范围之间，则以入住时间到结束时间为准
			days = (c3.getTimeInMillis() - c1.getTimeInMillis()) / (1000 * 60 * 60 * 24);
		} else {
			// 预定入住时间在查询结束时间之后，则该职工无租金

		}
		
		return days;
	}
	
//	租金生成中，计算天数，两个参数
	public static long calculateDays(Date startTime, Date endTime){
		Calendar c1 = Calendar.getInstance();
		 c1.setTime(startTime);
		
		 Calendar c2 = Calendar.getInstance();
		 c2.setTime(endTime);
		 
		 return (c2.getTimeInMillis() - c1.getTimeInMillis()) / (1000 * 60 *
				 60 * 24);
	}
	
	
}

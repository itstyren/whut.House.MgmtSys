package com.computerdesign.whutHouseMgmt.utils;

import java.util.ArrayList;
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
	
}

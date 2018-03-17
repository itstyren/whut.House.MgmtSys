package com.computerdesign.whutHouseMgmt.utils;

/**
 * 字符工具类
 * @author wanhaoran
 * @date 2018年3月17日
 */
public class StringUtil {
	
	/**
	 * 是否为空
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str){
		if(str==null||str.isEmpty()||str.replaceAll(" ", "").isEmpty()){
			return true;
		}
		return false;
	}
	
	public static boolean isBlank(String... strs){
		for(int i=0; i<strs.length; i++){
			if(isBlank(strs[i])){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 首字母大写
	 * @param in
	 * @return
	 */
	public static String upperHeadChar(String in){  
	    String head=in.substring(0,1);  
	    String out=head.toUpperCase()+in.substring(1,in.length());  
	    return out;  
	}
	
}

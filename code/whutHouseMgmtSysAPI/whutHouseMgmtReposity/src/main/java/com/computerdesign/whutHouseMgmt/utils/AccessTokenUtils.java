package com.computerdesign.whutHouseMgmt.utils;

import com.computerdesign.whutHouseMgmt.bean.Msg;

public class AccessTokenUtils {
	
	/**
	 * 令牌验证
	 * 验证是否存在该令牌
	 * 验证该令牌是否具有该操作权限
	 * @param accessToken 令牌参数
	 * @param path  通过RESTful风格的路径验证权限
	 * @return
	 */
	public static Msg check(String accessToken, String path){
		Msg result = new Msg();
		
		return result;
	}
	
}

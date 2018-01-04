package com.computerdesign.whutHouseMgmt.bean.user;

public class UserReturnToken {

	private UserLoginReturn userLoginReturn;
	
	private Integer tokenAccess;

	public UserLoginReturn getUserLoginReturn() {
		return userLoginReturn;
	}

	public void setUserLoginReturn(UserLoginReturn userLoginReturn) {
		this.userLoginReturn = userLoginReturn;
	}

	public Integer getTokenAccess() {
		return tokenAccess;
	}

	public void setTokenAccess(Integer tokenAccess) {
		this.tokenAccess = tokenAccess;
	}
}

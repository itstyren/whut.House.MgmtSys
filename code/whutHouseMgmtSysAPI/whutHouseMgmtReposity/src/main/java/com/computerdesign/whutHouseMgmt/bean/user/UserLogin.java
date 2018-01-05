package com.computerdesign.whutHouseMgmt.bean.user;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserLogin {

	private String no;

    private String password;
    
    private Integer roleId;

    private String token;
    
    private Date LastLoginTime;
    
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Date getLastLoginTime() {
		return LastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		LastLoginTime = lastLoginTime;
	}
    
    
}

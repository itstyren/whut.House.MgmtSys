package com.computerdesign.whutHouseMgmt.bean.user;


import io.swagger.annotations.ApiModelProperty;

public class UserLogin {

	@ApiModelProperty(example = "3")
	private String no;

	@ApiModelProperty(example = "123")
	private String password;

	@ApiModelProperty(example = "3")
	private Integer roleId;

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

}

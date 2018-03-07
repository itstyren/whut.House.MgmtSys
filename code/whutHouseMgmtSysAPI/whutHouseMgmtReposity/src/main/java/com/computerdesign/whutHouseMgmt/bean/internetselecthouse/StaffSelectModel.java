package com.computerdesign.whutHouseMgmt.bean.internetselecthouse;

import com.computerdesign.whutHouseMgmt.bean.hire.rentgenerate.GoUniversityTimeRange;

public class StaffSelectModel {

	private String dept;

	private String post;

	private String title;

	private String type;

	private String status;

	// 住房类型，用于租金生成部分的查询
	private String houseTypeName;

	private String marriageState;

	private JoinTime joinTime;

	// 用上大学时间，于租金生成部分的查询
	private GoUniversityTimeRange goUniversityTimeRange;

	private String sex;

	// 是否到期，用于租金生成部分的查询
	private Boolean isExpire;

	// 所属区域，用于租金生成部分的查询
	private String regionName;

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHouseTypeName() {
		return houseTypeName;
	}

	public void setHouseTypeName(String houseTypeName) {
		this.houseTypeName = houseTypeName;
	}

	public String getMarriageState() {
		return marriageState;
	}

	public void setMarriageState(String marriageState) {
		this.marriageState = marriageState;
	}

	public JoinTime getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(JoinTime joinTime) {
		this.joinTime = joinTime;
	}

	public GoUniversityTimeRange getGoUniversityTimeRange() {
		return goUniversityTimeRange;
	}

	public void setGoUniversityTimeRange(GoUniversityTimeRange goUniversityTimeRange) {
		this.goUniversityTimeRange = goUniversityTimeRange;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Boolean getIsExpire() {
		return isExpire;
	}

	public void setIsExpire(Boolean isExpire) {
		this.isExpire = isExpire;
	}
}

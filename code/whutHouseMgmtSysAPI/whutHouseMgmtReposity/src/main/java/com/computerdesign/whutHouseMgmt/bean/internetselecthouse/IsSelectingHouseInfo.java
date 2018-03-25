package com.computerdesign.whutHouseMgmt.bean.internetselecthouse;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class IsSelectingHouseInfo {
	
	//当前登陆系统职工选房开始时间
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date staffStartTimeNow;
	
	//当前登陆系统职工选房结束时间
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date staffEndTimeNow;
	
	//当前选房员工
	private String isSelectingStaffName;
	
	//正在选房职工选房结束时间
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date isSelectingStaffEndTime;
	
	//下一位选房员工
	private String nextSelectingStaffName;
	
	//当前规则下每位员工选房时间
	private int selectTime;
	
	//系统当前时间时间戳
	private Date systemNowTime;

	public Date getSystemNowTime() {
		return systemNowTime;
	}

	public void setSystemNowTime(Date systemNowTime) {
		this.systemNowTime = systemNowTime;
	}

	public int getSelectTime() {
		return selectTime;
	}

	public void setSelectTime(int selectTime) {
		this.selectTime = selectTime;
	}

	public Date getStaffStartTimeNow() {
		return staffStartTimeNow;
	}

	public void setStaffStartTimeNow(Date staffStartTimeNow) {
		this.staffStartTimeNow = staffStartTimeNow;
	}

	public Date getStaffEndTimeNow() {
		return staffEndTimeNow;
	}

	public void setStaffEndTimeNow(Date staffEndTimeNow) {
		this.staffEndTimeNow = staffEndTimeNow;
	}

	public String getIsSelectingStaffName() {
		return isSelectingStaffName;
	}

	public void setIsSelectingStaffName(String isSelectingStaffName) {
		this.isSelectingStaffName = isSelectingStaffName;
	}

	public Date getIsSelectingStaffEndTime() {
		return isSelectingStaffEndTime;
	}

	public void setIsSelectingStaffEndTime(Date isSelectingStaffEndTime) {
		this.isSelectingStaffEndTime = isSelectingStaffEndTime;
	}

	public String getNextSelectingStaffName() {
		return nextSelectingStaffName;
	}

	public void setNextSelectingStaffName(String nextSelectingStaffName) {
		this.nextSelectingStaffName = nextSelectingStaffName;
	}
	
	
	
}

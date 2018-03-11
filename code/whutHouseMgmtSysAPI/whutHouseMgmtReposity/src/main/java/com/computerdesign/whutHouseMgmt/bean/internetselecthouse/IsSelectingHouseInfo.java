package com.computerdesign.whutHouseMgmt.bean.internetselecthouse;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class IsSelectingHouseInfo {
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date staffStartTimeNow;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date staffEndTimeNow;
	
	private String isSelectingStaffName;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date isSelectingStaffEndTime;
	
	private String nextSelectingStaffName;

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

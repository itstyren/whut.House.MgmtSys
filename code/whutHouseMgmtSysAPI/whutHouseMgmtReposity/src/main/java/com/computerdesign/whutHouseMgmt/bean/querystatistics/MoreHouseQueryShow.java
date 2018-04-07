package com.computerdesign.whutHouseMgmt.bean.querystatistics;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MoreHouseQueryShow {
	
	private String staffNo;
	
	private String staffName;
	
	private String staffDeptName;
	
	private String staffSpouseName;
	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date bookTime;
	
	private String houseRel;
	
	private String address;
	
	private String staffTypeName;
	
	private String houseTypeName;

	public String getStaffNo() {
		return staffNo;
	}

	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffDeptName() {
		return staffDeptName;
	}

	public void setStaffDeptName(String staffDeptName) {
		this.staffDeptName = staffDeptName;
	}

	public String getStaffSpouseName() {
		return staffSpouseName;
	}

	public void setStaffSpouseName(String staffSpouseName) {
		this.staffSpouseName = staffSpouseName;
	}

	public Date getBookTime() {
		return bookTime;
	}

	public void setBookTime(Date bookTime) {
		this.bookTime = bookTime;
	}

	public String getHouseRel() {
		return houseRel;
	}

	public void setHouseRel(String houseRel) {
		this.houseRel = houseRel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStaffTypeName() {
		return staffTypeName;
	}

	public void setStaffTypeName(String staffTypeName) {
		this.staffTypeName = staffTypeName;
	}

	public String getHouseTypeName() {
		return houseTypeName;
	}

	public void setHouseTypeName(String houseTypeName) {
		this.houseTypeName = houseTypeName;
	}
	
	
	
}

package com.computerdesign.whutHouseMgmt.bean.hire;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PersonalHireRecord {
	
	//申请理由
	private String reason;
	
	//房屋地址
	private String address;
	
	//租赁处理状态
	private String hireState;
	
	//申请时间
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date applyTime;

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHireState() {
		return hireState;
	}

	public void setHireState(String hireState) {
		this.hireState = hireState;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	
	
	
}

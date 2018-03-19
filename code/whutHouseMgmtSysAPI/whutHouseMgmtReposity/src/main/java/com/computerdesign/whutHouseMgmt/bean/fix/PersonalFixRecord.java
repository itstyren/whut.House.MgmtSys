package com.computerdesign.whutHouseMgmt.bean.fix;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PersonalFixRecord {
	
	//维修类型
	private String fixType;
	
	//维修描述
	private String description;
	
	//处理状态
	private String fixState;
	
	//处理说明
	private String processReason;
	
	//申请时间
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date applyTime;

	public String getFixType() {
		return fixType;
	}

	public void setFixType(String fixType) {
		this.fixType = fixType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFixState() {
		return fixState;
	}

	public void setFixState(String fixState) {
		this.fixState = fixState;
	}

	public String getProcessReason() {
		return processReason;
	}

	public void setProcessReason(String processReason) {
		this.processReason = processReason;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	
	
	
	
}

package com.computerdesign.whutHouseMgmt.bean.fix;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PersonalFixRecord {
	
	//维修ID
	private Integer fixId;
	
	//维修类型
	private String fixType;
	
	//维修描述
	private String description;
	
	//处理状态
	private String fixState;
	
	//处理说明
	private String processReason;
	
    private Boolean isOver;

    private Boolean isCheck;
    
    private String ratings;
	
	//申请时间
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date applyTime;

	public Integer getFixId() {
		return fixId;
	}

	public void setFixId(Integer fixId) {
		this.fixId = fixId;
	}

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

	
	
	public Boolean getIsOver() {
		return isOver;
	}

	public void setIsOver(Boolean isOver) {
		this.isOver = isOver;
	}

	public Boolean getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(Boolean isCheck) {
		this.isCheck = isCheck;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public String getRatings() {
		return ratings;
	}

	public void setRatings(String ratings) {
		this.ratings = ratings;
	}
	
	
	
	
}

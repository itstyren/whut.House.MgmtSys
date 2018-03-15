package com.computerdesign.whutHouseMgmt.bean.hire.common;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

public class Hire {
	@ApiModelProperty(hidden = true)
	private Integer id;

	@ApiModelProperty(example = "1")
	private Integer staffId;

	@ApiModelProperty(hidden = true)
	private Integer houseId;

	@ApiModelProperty(hidden = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date applyTime;

	@ApiModelProperty(example = "照桥心美")
	private String reason;

	@ApiModelProperty(example = "17765432111")
	private String phone;

	@ApiModelProperty(hidden = true)
	private String hireState;

	@ApiModelProperty(hidden = true)
	private Double totalVal;
	
	@ApiModelProperty(hidden = true)
	private Double titleVal;
	
	@ApiModelProperty(hidden = true)
	private Double timeVal;
	
	@ApiModelProperty(hidden = true)
	private Double spouseVal;
	
	@ApiModelProperty(hidden = true)
	private Double otherVal;
	
	@ApiModelProperty(hidden = true)
	private String acceptNote;
	
	@ApiModelProperty(hidden = true)
	private String acceptState;
	
	@ApiModelProperty(hidden = true)
	private String acceptMan;
	
	@ApiModelProperty(hidden = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date acceptTime;
	
	@ApiModelProperty(hidden = true)
	private String agreeNote;
	
	@ApiModelProperty(hidden = true)
	private String agreeState;
	
	@ApiModelProperty(hidden = true)
	private String agreeMan;
	
	@ApiModelProperty(hidden = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date agreeTime;
	
	@ApiModelProperty(hidden = true)
	private String approveNote;
	
	@ApiModelProperty(hidden = true)
	private String approveState;
	
	@ApiModelProperty(hidden = true)
	private String approveMan;
	
	@ApiModelProperty(hidden = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date approveTime;
	
	@ApiModelProperty(hidden = true)
	private Boolean isOver;
	
	@ApiModelProperty(hidden = true)
	private String feedBack;

	private String email;

	@ApiModelProperty(hidden = true)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason == null ? null : reason.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getHireState() {
		return hireState;
	}

	public void setHireState(String hireState) {
		this.hireState = hireState == null ? null : hireState.trim();
	}

	public Double getTotalVal() {
		return totalVal;
	}

	public void setTotalVal(Double totalVal) {
		this.totalVal = totalVal;
	}

	public Double getTitleVal() {
		return titleVal;
	}

	public void setTitleVal(Double titleVal) {
		this.titleVal = titleVal;
	}

	public Double getTimeVal() {
		return timeVal;
	}

	public void setTimeVal(Double timeVal) {
		this.timeVal = timeVal;
	}

	public Double getSpouseVal() {
		return spouseVal;
	}

	public void setSpouseVal(Double spouseVal) {
		this.spouseVal = spouseVal;
	}

	public Double getOtherVal() {
		return otherVal;
	}

	public void setOtherVal(Double otherVal) {
		this.otherVal = otherVal;
	}

	public String getAcceptNote() {
		return acceptNote;
	}

	public void setAcceptNote(String acceptNote) {
		this.acceptNote = acceptNote == null ? null : acceptNote.trim();
	}

	public String getAcceptState() {
		return acceptState;
	}

	public void setAcceptState(String acceptState) {
		this.acceptState = acceptState == null ? null : acceptState.trim();
	}

	public String getAcceptMan() {
		return acceptMan;
	}

	public void setAcceptMan(String acceptMan) {
		this.acceptMan = acceptMan == null ? null : acceptMan.trim();
	}

	public Date getAcceptTime() {
		return acceptTime;
	}

	public void setAcceptTime(Date acceptTime) {
		this.acceptTime = acceptTime;
	}

	public String getAgreeNote() {
		return agreeNote;
	}

	public void setAgreeNote(String agreeNote) {
		this.agreeNote = agreeNote == null ? null : agreeNote.trim();
	}

	public String getAgreeState() {
		return agreeState;
	}

	public void setAgreeState(String agreeState) {
		this.agreeState = agreeState == null ? null : agreeState.trim();
	}

	public String getAgreeMan() {
		return agreeMan;
	}

	public void setAgreeMan(String agreeMan) {
		this.agreeMan = agreeMan == null ? null : agreeMan.trim();
	}

	public Date getAgreeTime() {
		return agreeTime;
	}

	public void setAgreeTime(Date agreeTime) {
		this.agreeTime = agreeTime;
	}

	public String getApproveNote() {
		return approveNote;
	}

	public void setApproveNote(String approveNote) {
		this.approveNote = approveNote == null ? null : approveNote.trim();
	}

	public String getApproveState() {
		return approveState;
	}

	public void setApproveState(String approveState) {
		this.approveState = approveState == null ? null : approveState.trim();
	}

	public String getApproveMan() {
		return approveMan;
	}

	public void setApproveMan(String approveMan) {
		this.approveMan = approveMan == null ? null : approveMan.trim();
	}

	public Date getApproveTime() {
		return approveTime;
	}

	public void setApproveTime(Date approveTime) {
		this.approveTime = approveTime;
	}

	public Boolean getIsOver() {
		return isOver;
	}

	public void setIsOver(Boolean isOver) {
		this.isOver = isOver;
	}

	public String getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack == null ? null : feedBack.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}
}
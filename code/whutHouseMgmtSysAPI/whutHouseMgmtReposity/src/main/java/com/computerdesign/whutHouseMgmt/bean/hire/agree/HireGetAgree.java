package com.computerdesign.whutHouseMgmt.bean.hire.agree;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.computerdesign.whutHouseMgmt.bean.hire.common.ViewHire;
import com.fasterxml.jackson.annotation.JsonFormat;

public class HireGetAgree {

	private Integer id;
	
    private String name;

    private String titleName;

    private String postName;

    private String deptName;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date applyTime;
    
    private String reason;
    
    private String phone;
    
    private String acceptNote;

    private String acceptState;

    private String acceptMan;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date acceptTime;
    
    private String agreeNote;

    private String agreeState;

    private String agreeMan;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date agreeTime;
    
    private Double titleVal;

    private Double timeVal;

    private Double spouseVal;

    private Double otherVal;
        
    private Double totalVal;
    

	public HireGetAgree(ViewHire viewHire) {
		this.id = viewHire.getId();
		this.name = viewHire.getName();
		this.titleName = viewHire.getTitleName();
		this.postName = viewHire.getPostName();
		this.deptName = viewHire.getDeptName();
		this.applyTime = viewHire.getApplyTime();
		this.reason = viewHire.getReason();
		this.phone = viewHire.getPhone();
		this.acceptNote = viewHire.getAcceptNote();
		this.acceptState = viewHire.getAcceptState();
		this.acceptMan = viewHire.getAcceptMan();
		this.acceptTime = viewHire.getAcceptTime();
		this.agreeNote = viewHire.getAgreeNote();
		this.agreeState = viewHire.getAgreeState();
		this.agreeMan = viewHire.getAgreeMan();
		this.agreeTime = viewHire.getAgreeTime();
		this.titleVal = viewHire.getTitleVal();
		this.timeVal = viewHire.getTimeVal();
		this.spouseVal = viewHire.getSpouseVal();
		this.otherVal = viewHire.getOtherVal();
		this.totalVal = viewHire.getTotalVal();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
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
		this.reason = reason;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAcceptNote() {
		return acceptNote;
	}

	public void setAcceptNote(String acceptNote) {
		this.acceptNote = acceptNote;
	}

	public String getAcceptState() {
		return acceptState;
	}

	public void setAcceptState(String acceptState) {
		this.acceptState = acceptState;
	}

	public String getAcceptMan() {
		return acceptMan;
	}

	public void setAcceptMan(String acceptMan) {
		this.acceptMan = acceptMan;
	}

	public Date getAcceptTime() {
		return acceptTime;
	}

	public void setAcceptTime(Date acceptTime) {
		this.acceptTime = acceptTime;
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

	public String getAgreeNote() {
		return agreeNote;
	}

	public void setAgreeNote(String agreeNote) {
		this.agreeNote = agreeNote;
	}

	public String getAgreeState() {
		return agreeState;
	}

	public void setAgreeState(String agreeState) {
		this.agreeState = agreeState;
	}

	public String getAgreeMan() {
		return agreeMan;
	}

	public void setAgreeMan(String agreeMan) {
		this.agreeMan = agreeMan;
	}

	public Date getAgreeTime() {
		return agreeTime;
	}

	public void setAgreeTime(Date agreeTime) {
		this.agreeTime = agreeTime;
	}

	public Double getTotalVal() {
		return totalVal;
	}

	public void setTotalVal(Double totalVal) {
		this.totalVal = totalVal;
	}

	  
    
}

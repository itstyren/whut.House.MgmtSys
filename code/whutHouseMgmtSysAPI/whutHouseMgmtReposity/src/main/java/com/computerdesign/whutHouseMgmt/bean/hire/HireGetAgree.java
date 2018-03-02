package com.computerdesign.whutHouseMgmt.bean.hire;

import java.util.Date;

public class HireGetAgree {

	private Integer id;
	
    private String name;

    private String titleName;

    private String postName;

    private String deptName;
    
    private Date applyTime;
    
    private String reason;
    
    private String phone;
    
    private String acceptNote;

    private String acceptState;

    private String acceptMan;

    private Date acceptTime;
    
    private Double jobLevelVal;

    private Double timeVal;

    private Double multiVal;

    private Double otherVal;
    
    private Integer spouseTitleVal;
    
    

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
		this.jobLevelVal = viewHire.getJobLevelVal();
		this.timeVal = viewHire.getTimeVal();
		this.multiVal = viewHire.getMultiVal();
		this.otherVal = viewHire.getOtherVal();
		this.spouseTitleVal = viewHire.getSpouseTitleVal();
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

	public Double getJobLevelVal() {
		return jobLevelVal;
	}

	public void setJobLevelVal(Double jobLevelVal) {
		this.jobLevelVal = jobLevelVal;
	}

	public Double getTimeVal() {
		return timeVal;
	}

	public void setTimeVal(Double timeVal) {
		this.timeVal = timeVal;
	}

	public Double getMultiVal() {
		return multiVal;
	}

	public void setMultiVal(Double multiVal) {
		this.multiVal = multiVal;
	}

	public Double getOtherVal() {
		return otherVal;
	}

	public void setOtherVal(Double otherVal) {
		this.otherVal = otherVal;
	}

	public Integer getSpouseTitleVal() {
		return spouseTitleVal;
	}

	public void setSpouseTitleVal(Integer spouseTitleVal) {
		this.spouseTitleVal = spouseTitleVal;
	}


	
    
    
}

package com.computerdesign.whutHouseMgmt.bean.fix.accept;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.computerdesign.whutHouseMgmt.bean.fix.common.ViewFix;
import com.fasterxml.jackson.annotation.JsonFormat;

public class FixGetAccept {

	private Integer id;

    private String fixContentId;

    private String fixContentName;

    private String description;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date applyTime;
    
    private String staffName;

    private String titleName;

    private String postName;

    private String deptName;
    
    private String phone;
    
    private String staffAddress;
    
    private String acceptState;

    private String acceptNote;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date acceptTime;

    private String acceptMan;
    
    
    
    public FixGetAccept(ViewFix viewFix){
    	this.id = viewFix.getId();
    	this.fixContentId = viewFix.getFixContentId();
    	this.fixContentName = viewFix.getFixContentName();
    	this.description = viewFix.getDescription();
    	this.applyTime = viewFix.getApplyTime();
    	this.staffName = viewFix.getStaffName();
    	this.titleName = viewFix.getTitleName();
    	this.postName = viewFix.getPostName();
    	this.deptName = viewFix.getDeptName();
    	this.phone = viewFix.getPhone();
    	this.staffAddress = viewFix.getStaffAddress();
    	this.acceptMan= viewFix.getAcceptMan();
    	this.acceptNote = viewFix.getAcceptNote();
    	this.acceptState = viewFix.getAcceptState();
    	this.acceptTime = viewFix.getAcceptTime();
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFixContentId() {
		return fixContentId;
	}

	public void setFixContentId(String fixContentId) {
		this.fixContentId = fixContentId;
	}

	public String getFixContentName() {
		return fixContentName;
	}

	public void setFixContentName(String fixContentName) {
		this.fixContentName = fixContentName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStaffAddress() {
		return staffAddress;
	}

	public void setStaffAddress(String staffAddress) {
		this.staffAddress = staffAddress;
	}

	public String getAcceptState() {
		return acceptState;
	}

	public void setAcceptState(String acceptState) {
		this.acceptState = acceptState;
	}

	public String getAcceptNote() {
		return acceptNote;
	}

	public void setAcceptNote(String acceptNote) {
		this.acceptNote = acceptNote;
	}

	public Date getAcceptTime() {
		return acceptTime;
	}

	public void setAcceptTime(Date acceptTime) {
		this.acceptTime = acceptTime;
	}

	public String getAcceptMan() {
		return acceptMan;
	}

	public void setAcceptMan(String acceptMan) {
		this.acceptMan = acceptMan;
	}
    
    
}

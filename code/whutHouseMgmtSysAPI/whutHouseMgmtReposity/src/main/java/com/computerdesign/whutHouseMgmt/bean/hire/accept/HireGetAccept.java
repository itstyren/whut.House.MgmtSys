package com.computerdesign.whutHouseMgmt.bean.hire.accept;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.computerdesign.whutHouseMgmt.bean.hire.common.ViewHire;
import com.fasterxml.jackson.annotation.JsonFormat;

public class HireGetAccept {

	private Integer id;
	
    private String name;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date applyTime;

    private String reason;
    
    private String phone;
    
    private String titleName;

    private String postName;
    
    private String deptName;

    private Double totalVal;

    private Double titleVal;

    private Double timeVal;

    private Double spouseVal;

    private Double otherVal;
    
    private String acceptNote;

    private String acceptState;

    private String acceptMan;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date acceptTime;

    public HireGetAccept(ViewHire viewHire) {
		this.id = viewHire.getId();
		this.name = viewHire.getName();
		this.applyTime = viewHire.getApplyTime();
		this.reason = viewHire.getReason();
		this.phone = viewHire.getPhone();
		this.titleName = viewHire.getTitleName();
		this.postName = viewHire.getPostName();
		this.deptName = viewHire.getDeptName();
		this.totalVal = viewHire.getTotalVal();
		this.titleVal = viewHire.getTitleVal();
		this.timeVal = viewHire.getTimeVal();
		this.spouseVal = viewHire.getSpouseVal();
		this.otherVal = viewHire.getOtherVal();
		this.acceptNote = viewHire.getAcceptNote();
		this.acceptState = viewHire.getAcceptState();
		this.acceptMan = viewHire.getAcceptMan();
		this.acceptTime = viewHire.getAcceptTime();
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
    
    
}

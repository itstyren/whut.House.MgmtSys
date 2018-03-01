package com.computerdesign.whutHouseMgmt.bean.hire;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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

    private Double staffVal;

    private Double jobLevelVal;

    private Double timeVal;

    private Double multiVal;

    private Double otherVal;

    public HireGetAccept(ViewHire viewHire) {
		this.id = viewHire.getId();
		this.name = viewHire.getName();
		this.applyTime = viewHire.getApplyTime();
		this.reason = viewHire.getReason();
		this.phone = viewHire.getPhone();
		this.titleName = viewHire.getTitleName();
		this.postName = viewHire.getPostName();
		this.deptName = viewHire.getDeptName();
		this.staffVal = viewHire.getStaffVal();
		this.jobLevelVal = viewHire.getJobLevelVal();
		this.timeVal = viewHire.getTimeVal();
		this.multiVal = viewHire.getMultiVal();
		this.otherVal = viewHire.getOtherVal();

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

	public Double getStaffVal() {
		return staffVal;
	}

	public void setStaffVal(Double staffVal) {
		this.staffVal = staffVal;
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
    
    
}

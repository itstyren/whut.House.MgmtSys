package com.computerdesign.whutHouseMgmt.bean.hire;

import java.util.Date;

public class HireGetApprove {

	private Integer id;
	
    private String name;

    private String titleName;

    private String postName;

    private String deptName;
    
    private Date applyTime;
    
    private String reason;
    
    private String phone;
    
    private String houseNo;

    private Double houseBuildArea;

    private Double houseUserArea;

    private String houseAddress;
    
    private String acceptNote;

    private String acceptState;

    private String acceptMan;

    private Date acceptTime;
    
    private String agreeNote;

    private String agreeState;

    private String agreeMan;

    private Date agreeTime;
    
    private Double totalVal;

    private Double titleVal;

    private Double timeVal;

    private Double spouseVal;

    private Double otherVal;
    
    
    public HireGetApprove(ViewHire viewHire) {
    	this.id = viewHire.getId();
		this.name = viewHire.getName();
		this.titleName = viewHire.getTitleName();
		this.postName = viewHire.getPostName();
		this.deptName = viewHire.getDeptName();
		this.applyTime = viewHire.getApplyTime();
		this.reason = viewHire.getReason();
		this.phone = viewHire.getPhone();
		this.houseNo = viewHire.getHouseNo();
		this.houseBuildArea = viewHire.getHouseBuildArea();
		this.houseUserArea = viewHire.getHouseUserArea();
		this.houseAddress = viewHire.getHouseAddress();
		this.acceptNote = viewHire.getAcceptNote();
		this.acceptState = viewHire.getAcceptState();
		this.acceptMan = viewHire.getAcceptMan();
		this.acceptTime = viewHire.getAcceptTime();

		this.agreeNote = viewHire.getAgreeNote();
		this.agreeState = viewHire.getAgreeState();
		this.agreeMan = viewHire.getAgreeMan();
		this.agreeTime = viewHire.getAgreeTime();
		
		this.totalVal = viewHire.getTotalVal();
		this.titleVal = viewHire.getTitleVal();
		this.timeVal = viewHire.getTimeVal();
		this.spouseVal = viewHire.getSpouseVal();
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

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public Double getHouseBuildArea() {
		return houseBuildArea;
	}

	public void setHouseBuildArea(Double houseBuildArea) {
		this.houseBuildArea = houseBuildArea;
	}

	public Double getHouseUserArea() {
		return houseUserArea;
	}

	public void setHouseUserArea(Double houseUserArea) {
		this.houseUserArea = houseUserArea;
	}

	public String getHouseAddress() {
		return houseAddress;
	}

	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
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

	
    
    
    
}

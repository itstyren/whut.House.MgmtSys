package com.computerdesign.whutHouseMgmt.bean.hire.common;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ViewHire {
    private Integer id;

    private Integer staffId;

    private String staffNo;

    private String name;

    private String sex;

    private String titleName;

    private Integer spouseTitleVal;

    private String postName;

    private Integer spousePostVal;

    private String typeName;

    private String deptName;

    private Integer houseId;

    private String houseNo;

    private Double houseBuildArea;

    private Double houseUserArea;

    private String houseAddress;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date applyTime;

    private String reason;

    private String phone;

    private String hireState;

    private Double titleVal;

    private Double totalVal;

    private Double timeVal;

    private Double spouseVal;

    private Double otherVal;

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

    private String approveNote;

    private String approveState;

    private String approveMan;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date approveTime;

    private Boolean isOver;

    private String feedBack;

    private String email;

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

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo == null ? null : staffNo.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName == null ? null : titleName.trim();
    }

    public Integer getSpouseTitleVal() {
        return spouseTitleVal;
    }

    public void setSpouseTitleVal(Integer spouseTitleVal) {
        this.spouseTitleVal = spouseTitleVal;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName == null ? null : postName.trim();
    }

    public Integer getSpousePostVal() {
        return spousePostVal;
    }

    public void setSpousePostVal(Integer spousePostVal) {
        this.spousePostVal = spousePostVal;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo == null ? null : houseNo.trim();
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
        this.houseAddress = houseAddress == null ? null : houseAddress.trim();
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

    public Double getTitleVal() {
        return titleVal;
    }

    public void setTitleVal(Double titleVal) {
        this.titleVal = titleVal;
    }

    public Double getTotalVal() {
        return totalVal;
    }

    public void setTotalVal(Double totalVal) {
        this.totalVal = totalVal;
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
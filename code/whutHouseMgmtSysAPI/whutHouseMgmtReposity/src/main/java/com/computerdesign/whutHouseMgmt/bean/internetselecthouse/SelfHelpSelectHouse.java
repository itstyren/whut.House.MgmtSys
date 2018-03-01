package com.computerdesign.whutHouseMgmt.bean.internetselecthouse;

import java.util.Date;

public class SelfHelpSelectHouse {
    private String staffName;

    private String staffNo;

    private Integer staffTitleId;

    private String staffTitleName;

    private Integer staffPostId;

    private String staffPostName;

    private Integer staffTypeId;

    private String staffTypeName;

    private Integer staffStatusId;

    private String staffStatusName;

    private Integer staffDeptId;

    private String staffDeptName;

    private Integer staffPostVal;

    private Integer staffTitleVal;

    private Integer staffSpousePostVal;

    private Integer staffSpouseTitleVal;

    private Double staffTimeVal;

    private Double staffOtherVal;

    private Double staffTotalVal;

    private Date houseSelectStart;

    private Date houseSelectEnd;

    private String recordStatus;

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo == null ? null : staffNo.trim();
    }

    public Integer getStaffTitleId() {
        return staffTitleId;
    }

    public void setStaffTitleId(Integer staffTitleId) {
        this.staffTitleId = staffTitleId;
    }

    public String getStaffTitleName() {
        return staffTitleName;
    }

    public void setStaffTitleName(String staffTitleName) {
        this.staffTitleName = staffTitleName == null ? null : staffTitleName.trim();
    }

    public Integer getStaffPostId() {
        return staffPostId;
    }

    public void setStaffPostId(Integer staffPostId) {
        this.staffPostId = staffPostId;
    }

    public String getStaffPostName() {
        return staffPostName;
    }

    public void setStaffPostName(String staffPostName) {
        this.staffPostName = staffPostName == null ? null : staffPostName.trim();
    }

    public Integer getStaffTypeId() {
        return staffTypeId;
    }

    public void setStaffTypeId(Integer staffTypeId) {
        this.staffTypeId = staffTypeId;
    }

    public String getStaffTypeName() {
        return staffTypeName;
    }

    public void setStaffTypeName(String staffTypeName) {
        this.staffTypeName = staffTypeName == null ? null : staffTypeName.trim();
    }

    public Integer getStaffStatusId() {
        return staffStatusId;
    }

    public void setStaffStatusId(Integer staffStatusId) {
        this.staffStatusId = staffStatusId;
    }

    public String getStaffStatusName() {
        return staffStatusName;
    }

    public void setStaffStatusName(String staffStatusName) {
        this.staffStatusName = staffStatusName == null ? null : staffStatusName.trim();
    }

    public Integer getStaffDeptId() {
        return staffDeptId;
    }

    public void setStaffDeptId(Integer staffDeptId) {
        this.staffDeptId = staffDeptId;
    }

    public String getStaffDeptName() {
        return staffDeptName;
    }

    public void setStaffDeptName(String staffDeptName) {
        this.staffDeptName = staffDeptName == null ? null : staffDeptName.trim();
    }

    public Integer getStaffPostVal() {
        return staffPostVal;
    }

    public void setStaffPostVal(Integer staffPostVal) {
        this.staffPostVal = staffPostVal;
    }

    public Integer getStaffTitleVal() {
        return staffTitleVal;
    }

    public void setStaffTitleVal(Integer staffTitleVal) {
        this.staffTitleVal = staffTitleVal;
    }

    public Integer getStaffSpousePostVal() {
        return staffSpousePostVal;
    }

    public void setStaffSpousePostVal(Integer staffSpousePostVal) {
        this.staffSpousePostVal = staffSpousePostVal;
    }

    public Integer getStaffSpouseTitleVal() {
        return staffSpouseTitleVal;
    }

    public void setStaffSpouseTitleVal(Integer staffSpouseTitleVal) {
        this.staffSpouseTitleVal = staffSpouseTitleVal;
    }

    public Double getStaffTimeVal() {
        return staffTimeVal;
    }

    public void setStaffTimeVal(Double staffTimeVal) {
        this.staffTimeVal = staffTimeVal;
    }

    public Double getStaffOtherVal() {
        return staffOtherVal;
    }

    public void setStaffOtherVal(Double staffOtherVal) {
        this.staffOtherVal = staffOtherVal;
    }

    public Double getStaffTotalVal() {
        return staffTotalVal;
    }

    public void setStaffTotalVal(Double staffTotalVal) {
        this.staffTotalVal = staffTotalVal;
    }

    public Date getHouseSelectStart() {
        return houseSelectStart;
    }

    public void setHouseSelectStart(Date houseSelectStart) {
        this.houseSelectStart = houseSelectStart;
    }

    public Date getHouseSelectEnd() {
        return houseSelectEnd;
    }

    public void setHouseSelectEnd(Date houseSelectEnd) {
        this.houseSelectEnd = houseSelectEnd;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }
}
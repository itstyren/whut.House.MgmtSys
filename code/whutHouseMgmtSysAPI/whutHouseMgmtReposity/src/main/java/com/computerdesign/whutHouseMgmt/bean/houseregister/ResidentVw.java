package com.computerdesign.whutHouseMgmt.bean.houseregister;

import java.util.Date;

public class ResidentVw {
    private Integer residentId;

    private Integer staffId;

    private Integer houseId;

    private String staffName;

    private String address;

    private String houseRel;

    private Date bookTime;

    private String staffNo;

    private String staffSex;

    private Integer staffDeptId;

    private String staffDeptName;

    private String houseNo;

    private Integer houseType;

    private Double buildArea;

    private Double usedArea;

    private Integer familyCode;

    private Date expireTime;

    private String lastRentType;

    private String rentType;

    private Boolean isDelete;

    public Integer getResidentId() {
        return residentId;
    }

    public void setResidentId(Integer residentId) {
        this.residentId = residentId;
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

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getHouseRel() {
        return houseRel;
    }

    public void setHouseRel(String houseRel) {
        this.houseRel = houseRel == null ? null : houseRel.trim();
    }

    public Date getBookTime() {
        return bookTime;
    }

    public void setBookTime(Date bookTime) {
        this.bookTime = bookTime;
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo == null ? null : staffNo.trim();
    }

    public String getStaffSex() {
        return staffSex;
    }

    public void setStaffSex(String staffSex) {
        this.staffSex = staffSex == null ? null : staffSex.trim();
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

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo == null ? null : houseNo.trim();
    }

    public Integer getHouseType() {
        return houseType;
    }

    public void setHouseType(Integer houseType) {
        this.houseType = houseType;
    }

    public Double getBuildArea() {
        return buildArea;
    }

    public void setBuildArea(Double buildArea) {
        this.buildArea = buildArea;
    }

    public Double getUsedArea() {
        return usedArea;
    }

    public void setUsedArea(Double usedArea) {
        this.usedArea = usedArea;
    }

    public Integer getFamilyCode() {
        return familyCode;
    }

    public void setFamilyCode(Integer familyCode) {
        this.familyCode = familyCode;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public String getLastRentType() {
        return lastRentType;
    }

    public void setLastRentType(String lastRentType) {
        this.lastRentType = lastRentType == null ? null : lastRentType.trim();
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType == null ? null : rentType.trim();
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}
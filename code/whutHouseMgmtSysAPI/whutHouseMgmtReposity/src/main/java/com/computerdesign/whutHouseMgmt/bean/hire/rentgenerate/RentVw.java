package com.computerdesign.whutHouseMgmt.bean.hire.rentgenerate;

import java.util.Date;

public class RentVw {
    private Integer staffId;

    private Integer houseId;

    private String staffName;

    private String address;

    private String staffNo;

    private String houseNo;

    private Integer houseStructId;

    private Double houseBuildArea;

    private Date bookTime;

    private Date expireTime;

    private Date rentBeginTime;

    private Date rentEndTime;

    private String rentDiscountRate;

    private Double rentInitMoney;

    private Byte rentIsGet;

    private Integer rentId;

    private Double rentMoney;

    private String rentType;

    private Integer residentId;

    private String employType;

    private Integer staffDeptId;

    private String staffDeptName;

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

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo == null ? null : staffNo.trim();
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo == null ? null : houseNo.trim();
    }

    public Integer getHouseStructId() {
        return houseStructId;
    }

    public void setHouseStructId(Integer houseStructId) {
        this.houseStructId = houseStructId;
    }

    public Double getHouseBuildArea() {
        return houseBuildArea;
    }

    public void setHouseBuildArea(Double houseBuildArea) {
        this.houseBuildArea = houseBuildArea;
    }

    public Date getBookTime() {
        return bookTime;
    }

    public void setBookTime(Date bookTime) {
        this.bookTime = bookTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Date getRentBeginTime() {
        return rentBeginTime;
    }

    public void setRentBeginTime(Date rentBeginTime) {
        this.rentBeginTime = rentBeginTime;
    }

    public Date getRentEndTime() {
        return rentEndTime;
    }

    public void setRentEndTime(Date rentEndTime) {
        this.rentEndTime = rentEndTime;
    }

    public String getRentDiscountRate() {
        return rentDiscountRate;
    }

    public void setRentDiscountRate(String rentDiscountRate) {
        this.rentDiscountRate = rentDiscountRate == null ? null : rentDiscountRate.trim();
    }

    public Double getRentInitMoney() {
        return rentInitMoney;
    }

    public void setRentInitMoney(Double rentInitMoney) {
        this.rentInitMoney = rentInitMoney;
    }

    public Byte getRentIsGet() {
        return rentIsGet;
    }

    public void setRentIsGet(Byte rentIsGet) {
        this.rentIsGet = rentIsGet;
    }

    public Integer getRentId() {
        return rentId;
    }

    public void setRentId(Integer rentId) {
        this.rentId = rentId;
    }

    public Double getRentMoney() {
        return rentMoney;
    }

    public void setRentMoney(Double rentMoney) {
        this.rentMoney = rentMoney;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType == null ? null : rentType.trim();
    }

    public Integer getResidentId() {
        return residentId;
    }

    public void setResidentId(Integer residentId) {
        this.residentId = residentId;
    }

    public String getEmployType() {
        return employType;
    }

    public void setEmployType(String employType) {
        this.employType = employType == null ? null : employType.trim();
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
}
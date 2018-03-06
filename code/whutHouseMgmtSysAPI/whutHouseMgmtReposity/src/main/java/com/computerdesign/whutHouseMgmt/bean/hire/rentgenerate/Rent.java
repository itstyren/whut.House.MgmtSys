package com.computerdesign.whutHouseMgmt.bean.hire.rentgenerate;

import java.util.Date;

public class Rent {
    private Integer id;

    private Integer residentId;

    private String rentType;

    private Double rentMoney;

    private Byte isGet;

    private Date beginTime;

    private Date endTime;

    private Date employmentDate;

    private String employType;

    private String discountRate;

    private Double initMoney;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResidentId() {
        return residentId;
    }

    public void setResidentId(Integer residentId) {
        this.residentId = residentId;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType == null ? null : rentType.trim();
    }

    public Double getRentMoney() {
        return rentMoney;
    }

    public void setRentMoney(Double rentMoney) {
        this.rentMoney = rentMoney;
    }

    public Byte getIsGet() {
        return isGet;
    }

    public void setIsGet(Byte isGet) {
        this.isGet = isGet;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public String getEmployType() {
        return employType;
    }

    public void setEmployType(String employType) {
        this.employType = employType == null ? null : employType.trim();
    }

    public String getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(String discountRate) {
        this.discountRate = discountRate == null ? null : discountRate.trim();
    }

    public Double getInitMoney() {
        return initMoney;
    }

    public void setInitMoney(Double initMoney) {
        this.initMoney = initMoney;
    }
}
package com.computerdesign.whutHouseMgmt.bean.houseregister;

import java.util.Date;

public class Resident {
    private Integer id;

    private Integer staffId;

    private Integer houseId;

    private Integer houseRel;

    private Date bookTime;

    private Boolean isDelete;

    private Date expireTime;

    private String rentType;

    private String lastRentType;

    private String familyCode;

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

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Integer getHouseRel() {
        return houseRel;
    }

    public void setHouseRel(Integer houseRel) {
        this.houseRel = houseRel;
    }

    public Date getBookTime() {
        return bookTime;
    }

    public void setBookTime(Date bookTime) {
        this.bookTime = bookTime;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType == null ? null : rentType.trim();
    }

    public String getLastRentType() {
        return lastRentType;
    }

    public void setLastRentType(String lastRentType) {
        this.lastRentType = lastRentType == null ? null : lastRentType.trim();
    }

    public String getFamilyCode() {
        return familyCode;
    }

    public void setFamilyCode(String familyCode) {
        this.familyCode = familyCode == null ? null : familyCode.trim();
    }
}
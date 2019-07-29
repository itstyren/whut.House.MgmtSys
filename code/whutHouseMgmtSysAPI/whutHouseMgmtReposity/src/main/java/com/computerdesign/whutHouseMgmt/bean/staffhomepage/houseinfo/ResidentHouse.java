package com.computerdesign.whutHouseMgmt.bean.staffhomepage.houseinfo;

import java.util.Date;

public class ResidentHouse {
    private Integer residentId;

    private Integer staffId;

    private String staffNo;

    private Integer houseId;

    private String address;

    private Integer buildingId;

    private String buildingName;

    private Integer regionId;

    private String regionName;

    private Integer houseStructId;

    private String houseStructName;

    private Integer houseLayoutId;

    private String houseLayoutName;

    private Integer houseRelId;

    private String houseRelName;

    private Date bookTime;

    private Boolean isDelete;

    private Date expireTime;

    private String rentType;

    private Integer payType;

    private Double usedArea;

    private Double buildArea;

    private String houseNo;

    private Integer houseTypeId;

    private String houseTypeName;

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

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo == null ? null : staffNo.trim();
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName == null ? null : buildingName.trim();
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
    }

    public Integer getHouseStructId() {
        return houseStructId;
    }

    public void setHouseStructId(Integer houseStructId) {
        this.houseStructId = houseStructId;
    }

    public String getHouseStructName() {
        return houseStructName;
    }

    public void setHouseStructName(String houseStructName) {
        this.houseStructName = houseStructName == null ? null : houseStructName.trim();
    }

    public Integer getHouseLayoutId() {
        return houseLayoutId;
    }

    public void setHouseLayoutId(Integer houseLayoutId) {
        this.houseLayoutId = houseLayoutId;
    }

    public String getHouseLayoutName() {
        return houseLayoutName;
    }

    public void setHouseLayoutName(String houseLayoutName) {
        this.houseLayoutName = houseLayoutName == null ? null : houseLayoutName.trim();
    }

    public Integer getHouseRelId() {
        return houseRelId;
    }

    public void setHouseRelId(Integer houseRelId) {
        this.houseRelId = houseRelId;
    }

    public String getHouseRelName() {
        return houseRelName;
    }

    public void setHouseRelName(String houseRelName) {
        this.houseRelName = houseRelName == null ? null : houseRelName.trim();
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

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Double getUsedArea() {
        return usedArea;
    }

    public void setUsedArea(Double usedArea) {
        this.usedArea = usedArea;
    }

    public Double getBuildArea() {
        return buildArea;
    }

    public void setBuildArea(Double buildArea) {
        this.buildArea = buildArea;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo == null ? null : houseNo.trim();
    }

    public Integer getHouseTypeId() {
        return houseTypeId;
    }

    public void setHouseTypeId(Integer houseTypeId) {
        this.houseTypeId = houseTypeId;
    }

    public String getHouseTypeName() {
        return houseTypeName;
    }

    public void setHouseTypeName(String houseTypeName) {
        this.houseTypeName = houseTypeName == null ? null : houseTypeName.trim();
    }
}
package com.computerdesign.whutHouseMgmt.bean.staffhomepage.houseinfo;

public class ResidentHouse {
    private Integer residentId;

    private Integer staffId;

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
}
package com.computerdesign.whutHouseMgmt.bean.region;

public class Region {
    private Integer regionId;

    private String regionName;

    private String regionDescription;

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

    public String getRegionDescription() {
        return regionDescription;
    }

    public void setRegionDescription(String regionDescription) {
        this.regionDescription = regionDescription == null ? null : regionDescription.trim();
    }
}
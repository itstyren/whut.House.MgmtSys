package com.computerdesign.whutHouseMgmt.bean.building;

import java.util.Date;

public class Building {
    private Integer buildingId;

    private String buildingName;

    private Date buildingFinishTime;

    private Float buildingFloorArea;

    private Float buildingUsedArea;

    private Integer buildingFloorCount;

    private Integer buildingRegion;

    private String buildingDescription;

    private Long buildingSupportFund;

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

    public Date getBuildingFinishTime() {
        return buildingFinishTime;
    }

    public void setBuildingFinishTime(Date buildingFinishTime) {
        this.buildingFinishTime = buildingFinishTime;
    }

    public Float getBuildingFloorArea() {
        return buildingFloorArea;
    }

    public void setBuildingFloorArea(Float buildingFloorArea) {
        this.buildingFloorArea = buildingFloorArea;
    }

    public Float getBuildingUsedArea() {
        return buildingUsedArea;
    }

    public void setBuildingUsedArea(Float buildingUsedArea) {
        this.buildingUsedArea = buildingUsedArea;
    }

    public Integer getBuildingFloorCount() {
        return buildingFloorCount;
    }

    public void setBuildingFloorCount(Integer buildingFloorCount) {
        this.buildingFloorCount = buildingFloorCount;
    }

    public Integer getBuildingRegion() {
        return buildingRegion;
    }

    public void setBuildingRegion(Integer buildingRegion) {
        this.buildingRegion = buildingRegion;
    }

    public String getBuildingDescription() {
        return buildingDescription;
    }

    public void setBuildingDescription(String buildingDescription) {
        this.buildingDescription = buildingDescription == null ? null : buildingDescription.trim();
    }

    public Long getBuildingSupportFund() {
        return buildingSupportFund;
    }

    public void setBuildingSupportFund(Long buildingSupportFund) {
        this.buildingSupportFund = buildingSupportFund;
    }
}
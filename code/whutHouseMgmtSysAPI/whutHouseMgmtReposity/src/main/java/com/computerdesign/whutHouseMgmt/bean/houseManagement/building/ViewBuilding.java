package com.computerdesign.whutHouseMgmt.bean.houseManagement.building;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ViewBuilding {
    private Integer id;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date finishTime;

    private Float floorArea;

    private Float usedArea;

    private Integer floorCount;

    private Integer regionId;

    private String regionName;

    private Integer campusId;

    private String campusName;

    private String description;

    private BigDecimal supportFund;

    private String manager;

    private Integer unitCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Float getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Float floorArea) {
        this.floorArea = floorArea;
    }

    public Float getUsedArea() {
        return usedArea;
    }

    public void setUsedArea(Float usedArea) {
        this.usedArea = usedArea;
    }

    public Integer getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(Integer floorCount) {
        this.floorCount = floorCount;
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

    public Integer getCampusId() {
        return campusId;
    }

    public void setCampusId(Integer campusId) {
        this.campusId = campusId;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName == null ? null : campusName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public BigDecimal getSupportFund() {
        return supportFund;
    }

    public void setSupportFund(BigDecimal supportFund) {
        this.supportFund = supportFund;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public Integer getUnitCount() {
        return unitCount;
    }

    public void setUnitCount(Integer unitCount) {
        this.unitCount = unitCount;
    }
}
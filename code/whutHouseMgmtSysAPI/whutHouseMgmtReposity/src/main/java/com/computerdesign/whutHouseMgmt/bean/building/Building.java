package com.computerdesign.whutHouseMgmt.bean.building;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Building {
    private Integer id;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date finishTime;

    private Float floorArea;

    private Float usedArea;

    private Integer floorCount;

    private Integer regionId;

    private String description;

    private Long supportFund;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Long getSupportFund() {
        return supportFund;
    }

    public void setSupportFund(Long supportFund) {
        this.supportFund = supportFund;
    }
}
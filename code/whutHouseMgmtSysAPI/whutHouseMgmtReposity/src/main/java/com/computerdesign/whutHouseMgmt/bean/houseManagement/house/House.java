package com.computerdesign.whutHouseMgmt.bean.houseManagement.house;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class House {
    private Integer id;

    private String no;

    private Boolean isOutSchool;

    private Integer type;

    private Integer layout;

    private Integer struct;

    private Integer status;

    private Double buildArea;

    private Double usedArea;

    private Double basementArea;

    private String address;

    private Integer buildingId;

    private String proId;

    private String remark;

    private String image;

    private String files;

    private Double rental;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date finishTime;

    private Integer recordStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    public Boolean getIsOutSchool() {
        return isOutSchool;
    }

    public void setIsOutSchool(Boolean isOutSchool) {
        this.isOutSchool = isOutSchool;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLayout() {
        return layout;
    }

    public void setLayout(Integer layout) {
        this.layout = layout;
    }

    public Integer getStruct() {
        return struct;
    }

    public void setStruct(Integer struct) {
        this.struct = struct;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Double getBasementArea() {
        return basementArea;
    }

    public void setBasementArea(Double basementArea) {
        this.basementArea = basementArea;
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

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId == null ? null : proId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files == null ? null : files.trim();
    }

    public Double getRental() {
        return rental;
    }

    public void setRental(Double rental) {
        this.rental = rental;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Integer getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Integer recordStatus) {
        this.recordStatus = recordStatus;
    }
}
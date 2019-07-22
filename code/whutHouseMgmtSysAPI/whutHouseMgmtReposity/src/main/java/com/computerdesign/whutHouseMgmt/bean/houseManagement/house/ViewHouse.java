package com.computerdesign.whutHouseMgmt.bean.houseManagement.house;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ViewHouse {
    private Integer id;

    private String no;

    private Boolean isOutSchool;

    private Integer type;

    private String typeName;

    private Integer layout;

    private String layoutName;

    private Integer struct;

    private String structName;

    private Integer status;

    private String statusName;

    private Double buildArea;

    private Double usedArea;

    private Double basementArea;

    private String address;

    private Integer buildingId;

    private String buildingName;

    private Integer regionId;

    private String regionName;

    private Integer campusId;

    private String campusName;

    private String proId;

    private String remark;

    private String image;

    private Double rental;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date finishTime;

    private Integer recordStatus;

    private String files;

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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Integer getLayout() {
        return layout;
    }

    public void setLayout(Integer layout) {
        this.layout = layout;
    }

    public String getLayoutName() {
        return layoutName;
    }

    public void setLayoutName(String layoutName) {
        this.layoutName = layoutName == null ? null : layoutName.trim();
    }

    public Integer getStruct() {
        return struct;
    }

    public void setStruct(Integer struct) {
        this.struct = struct;
    }

    public String getStructName() {
        return structName;
    }

    public void setStructName(String structName) {
        this.structName = structName == null ? null : structName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName == null ? null : statusName.trim();
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

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files == null ? null : files.trim();
    }
}
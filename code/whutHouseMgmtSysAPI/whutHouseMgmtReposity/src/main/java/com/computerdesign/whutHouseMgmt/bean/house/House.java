package com.computerdesign.whutHouseMgmt.bean.house;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class House {
	@ApiModelProperty(hidden = true)
	private Integer id;

	@ApiModelProperty(example = "576")
	private String no;

	@ApiModelProperty(example = "false")
	private Boolean isOutSchool;

	@ApiModelProperty(example = "77")
	private Integer type;

	@ApiModelProperty(example = "19")
	private Integer layout;

	@ApiModelProperty(example = "29")
	private Integer struct;

	@ApiModelProperty(hidden = true)
	private Integer status;

	@ApiModelProperty(example = "44.2")
	private Double buildArea;

	@ApiModelProperty(example = "33")
	private Double usedArea;

	@ApiModelProperty(example = "99")
	private Double basementArea;

	@ApiModelProperty(example = "管院大楼")
	private String address;

	@ApiModelProperty(example = "5")
	private Integer buildingId;

	@ApiModelProperty(example = "78")
	private String proId;

	@ApiModelProperty(example = "备注")
	private String remark;

	private String image;

	@ApiModelProperty(hidden = true)
	private Double rental;

	@ApiModelProperty(example = "2017-5-11")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date finishTime;

	@ApiModelProperty(example = "0")
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
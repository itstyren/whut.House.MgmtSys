package com.computerdesign.whutHouseMgmt.bean.internetselecthouse;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class HireRecent {
	private Integer hireId;

	private Integer staffId;

	private String staffName;

	private String staffNo;

	private Integer staffTitleId;

	private String staffTitleName;

	private Integer staffPostId;

	private String staffPostName;

	private Integer staffTypeId;

	private String staffTypeName;

	private Integer staffStatusId;

	private String staffStatusName;

	private Integer staffDeptId;

	private String staffDeptName;

	private Integer staffPostVal;

	private Integer staffTitleVal;

	private Integer staffSpousePostVal;

	private Integer staffSpouseTitleVal;

	private Double staffTimeVal;

	private Double staffOtherVal;

	private Double staffTotalVal;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date staffSelectStart;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date staffSelectEnd;

	private Integer houseId;

	private String houseNo;

	private Double houseBuildArea;

	private Double houseUsedArea;

	private String houseAddress;

	public Integer getHireId() {
		return hireId;
	}

	public void setHireId(Integer hireId) {
		this.hireId = hireId;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName == null ? null : staffName.trim();
	}

	public String getStaffNo() {
		return staffNo;
	}

	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo == null ? null : staffNo.trim();
	}

	public Integer getStaffTitleId() {
		return staffTitleId;
	}

	public void setStaffTitleId(Integer staffTitleId) {
		this.staffTitleId = staffTitleId;
	}

	public String getStaffTitleName() {
		return staffTitleName;
	}

	public void setStaffTitleName(String staffTitleName) {
		this.staffTitleName = staffTitleName == null ? null : staffTitleName.trim();
	}

	public Integer getStaffPostId() {
		return staffPostId;
	}

	public void setStaffPostId(Integer staffPostId) {
		this.staffPostId = staffPostId;
	}

	public String getStaffPostName() {
		return staffPostName;
	}

	public void setStaffPostName(String staffPostName) {
		this.staffPostName = staffPostName == null ? null : staffPostName.trim();
	}

	public Integer getStaffTypeId() {
		return staffTypeId;
	}

	public void setStaffTypeId(Integer staffTypeId) {
		this.staffTypeId = staffTypeId;
	}

	public String getStaffTypeName() {
		return staffTypeName;
	}

	public void setStaffTypeName(String staffTypeName) {
		this.staffTypeName = staffTypeName == null ? null : staffTypeName.trim();
	}

	public Integer getStaffStatusId() {
		return staffStatusId;
	}

	public void setStaffStatusId(Integer staffStatusId) {
		this.staffStatusId = staffStatusId;
	}

	public String getStaffStatusName() {
		return staffStatusName;
	}

	public void setStaffStatusName(String staffStatusName) {
		this.staffStatusName = staffStatusName == null ? null : staffStatusName.trim();
	}

	public Integer getStaffDeptId() {
		return staffDeptId;
	}

	public void setStaffDeptId(Integer staffDeptId) {
		this.staffDeptId = staffDeptId;
	}

	public String getStaffDeptName() {
		return staffDeptName;
	}

	public void setStaffDeptName(String staffDeptName) {
		this.staffDeptName = staffDeptName == null ? null : staffDeptName.trim();
	}

	public Integer getStaffPostVal() {
		return staffPostVal;
	}

	public void setStaffPostVal(Integer staffPostVal) {
		this.staffPostVal = staffPostVal;
	}

	public Integer getStaffTitleVal() {
		return staffTitleVal;
	}

	public void setStaffTitleVal(Integer staffTitleVal) {
		this.staffTitleVal = staffTitleVal;
	}

	public Integer getStaffSpousePostVal() {
		return staffSpousePostVal;
	}

	public void setStaffSpousePostVal(Integer staffSpousePostVal) {
		this.staffSpousePostVal = staffSpousePostVal;
	}

	public Integer getStaffSpouseTitleVal() {
		return staffSpouseTitleVal;
	}

	public void setStaffSpouseTitleVal(Integer staffSpouseTitleVal) {
		this.staffSpouseTitleVal = staffSpouseTitleVal;
	}

	public Double getStaffTimeVal() {
		return staffTimeVal;
	}

	public void setStaffTimeVal(Double staffTimeVal) {
		this.staffTimeVal = staffTimeVal;
	}

	public Double getStaffOtherVal() {
		return staffOtherVal;
	}

	public void setStaffOtherVal(Double staffOtherVal) {
		this.staffOtherVal = staffOtherVal;
	}

	public Double getStaffTotalVal() {
		return staffTotalVal;
	}

	public void setStaffTotalVal(Double staffTotalVal) {
		this.staffTotalVal = staffTotalVal;
	}

	public Date getStaffSelectStart() {
		return staffSelectStart;
	}

	public void setStaffSelectStart(Date staffSelectStart) {
		this.staffSelectStart = staffSelectStart;
	}

	public Date getStaffSelectEnd() {
		return staffSelectEnd;
	}

	public void setStaffSelectEnd(Date staffSelectEnd) {
		this.staffSelectEnd = staffSelectEnd;
	}

	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo == null ? null : houseNo.trim();
	}

	public Double getHouseBuildArea() {
		return houseBuildArea;
	}

	public void setHouseBuildArea(Double houseBuildArea) {
		this.houseBuildArea = houseBuildArea;
	}

	public Double getHouseUsedArea() {
		return houseUsedArea;
	}

	public void setHouseUsedArea(Double houseUsedArea) {
		this.houseUsedArea = houseUsedArea;
	}

	public String getHouseAddress() {
		return houseAddress;
	}

	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress == null ? null : houseAddress.trim();
	}
}
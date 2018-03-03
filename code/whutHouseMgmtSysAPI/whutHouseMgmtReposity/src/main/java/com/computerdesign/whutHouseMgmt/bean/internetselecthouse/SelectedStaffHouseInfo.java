package com.computerdesign.whutHouseMgmt.bean.internetselecthouse;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 自助选房模块已选职工信息显示
 * 
 * @author Administrator
 *
 */
public class SelectedStaffHouseInfo {

	private String staffName;

	private String staffNo;

	private String staffTitleName;

	private String staffPostName;

	private String staffTypeName;

	private String staffStatusName;

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

	private String houseNo;

	private Double houseBuildArea;

	private Double houseUsedArea;

	private String houseAddress;

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffNo() {
		return staffNo;
	}

	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}

	public String getStaffTitleName() {
		return staffTitleName;
	}

	public void setStaffTitleName(String staffTitleName) {
		this.staffTitleName = staffTitleName;
	}

	public String getStaffPostName() {
		return staffPostName;
	}

	public void setStaffPostName(String staffPostName) {
		this.staffPostName = staffPostName;
	}

	public String getStaffTypeName() {
		return staffTypeName;
	}

	public void setStaffTypeName(String staffTypeName) {
		this.staffTypeName = staffTypeName;
	}

	public String getStaffStatusName() {
		return staffStatusName;
	}

	public void setStaffStatusName(String staffStatusName) {
		this.staffStatusName = staffStatusName;
	}

	public String getStaffDeptName() {
		return staffDeptName;
	}

	public void setStaffDeptName(String staffDeptName) {
		this.staffDeptName = staffDeptName;
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

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
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
		this.houseAddress = houseAddress;
	}

}

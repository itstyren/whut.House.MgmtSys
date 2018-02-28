package com.computerdesign.whutHouseMgmt.bean.hire;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffHouse;
import com.fasterxml.jackson.annotation.JsonFormat;

public class HireGetApply {

	private Integer staffId;

    private String staffNo;

    private String staffName;

    private String staffSex;

    private String staffTitleName;

    private String staffPostName;

    private String staffTypeName;

    private String staffStatusName;
    
    private Integer staffPostVal;
    
    private Integer staffSpousePostVal;

    private Integer staffDeptId;

    private String staffDeptName;

    private String staffCode;

    private String staffTel;

    private String staffRemark;

    private String staffSpouseName;

    private String staffSpouseCode;

    private String staffSpouseTitleName;

    private String staffSpousePostName;

    private String staffSpouseDept;

    private Integer staffSpouseKind;

    private String staffSpouseKindName;

    private String houseRelName;

    private Double staffDiscountRate;

    private List<HireHouseGetApply> listHouseGetApply;
    
    private List<HireApplyAlready> listHireApplyAlready;
    
    /**
     * 根据staffHouse的数据封装一个HireGetApply
     * @param staffHouse
     */
    public HireGetApply(StaffHouse staffHouse){
    	this.staffId = staffHouse.getStaffId();
    	this.staffNo = staffHouse.getStaffNo();
    	this.staffName = staffHouse.getStaffName();
    	this.staffSex = staffHouse.getStaffSex();
    	this.staffTitleName = staffHouse.getStaffTitleName();
    	this.staffPostName = staffHouse.getStaffPostName();
    	this.staffTypeName = staffHouse.getStaffTypeName();
    	this.staffStatusName = staffHouse.getStaffStatusName();
    	this.staffPostVal = staffHouse.getStaffPostVal();
    	this.staffSpousePostVal = staffHouse.getStaffSpousePostVal();
    	this.staffDeptId = staffHouse.getStaffDeptId();
    	this.staffDeptName = staffHouse.getStaffDeptName();
    	this.staffCode = staffHouse.getStaffCode();
    	this.staffTel = staffHouse.getStaffTel();
    	this.staffRemark = staffHouse.getStaffRemark();
    	this.staffSpouseName = staffHouse.getStaffSpouseName();
    	this.staffSpouseCode = staffHouse.getStaffSpouseCode();
    	this.staffSpouseTitleName = staffHouse.getStaffTitleName();
    	this.staffSpousePostName = staffHouse.getStaffSpousePostName();
    	this.staffSpouseDept = staffHouse.getStaffSpouseDept();
    	this.staffSpouseKind = staffHouse.getStaffSpouseKind();
    	this.staffSpouseKindName = staffHouse.getStaffSpouseKindName();
    	this.houseRelName = staffHouse.getHouseRelName();
    	this.staffDiscountRate = staffHouse.getStaffDiscountRate();

    }

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public String getStaffNo() {
		return staffNo;
	}

	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffSex() {
		return staffSex;
	}

	public void setStaffSex(String staffSex) {
		this.staffSex = staffSex;
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

	public Integer getStaffPostVal() {
		return staffPostVal;
	}

	public void setStaffPostVal(Integer staffPostVal) {
		this.staffPostVal = staffPostVal;
	}

	public Integer getStaffSpousePostVal() {
		return staffSpousePostVal;
	}

	public void setStaffSpousePostVal(Integer staffSpousePostVal) {
		this.staffSpousePostVal = staffSpousePostVal;
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
		this.staffDeptName = staffDeptName;
	}

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getStaffTel() {
		return staffTel;
	}

	public void setStaffTel(String staffTel) {
		this.staffTel = staffTel;
	}

	public String getStaffRemark() {
		return staffRemark;
	}

	public void setStaffRemark(String staffRemark) {
		this.staffRemark = staffRemark;
	}

	public String getStaffSpouseName() {
		return staffSpouseName;
	}

	public void setStaffSpouseName(String staffSpouseName) {
		this.staffSpouseName = staffSpouseName;
	}

	public String getStaffSpouseCode() {
		return staffSpouseCode;
	}

	public void setStaffSpouseCode(String staffSpouseCode) {
		this.staffSpouseCode = staffSpouseCode;
	}

	public String getStaffSpouseTitleName() {
		return staffSpouseTitleName;
	}

	public void setStaffSpouseTitleName(String staffSpouseTitleName) {
		this.staffSpouseTitleName = staffSpouseTitleName;
	}

	public String getStaffSpousePostName() {
		return staffSpousePostName;
	}

	public void setStaffSpousePostName(String staffSpousePostName) {
		this.staffSpousePostName = staffSpousePostName;
	}

	public String getStaffSpouseDept() {
		return staffSpouseDept;
	}

	public void setStaffSpouseDept(String staffSpouseDept) {
		this.staffSpouseDept = staffSpouseDept;
	}

	public Integer getStaffSpouseKind() {
		return staffSpouseKind;
	}

	public void setStaffSpouseKind(Integer staffSpouseKind) {
		this.staffSpouseKind = staffSpouseKind;
	}

	public String getStaffSpouseKindName() {
		return staffSpouseKindName;
	}

	public void setStaffSpouseKindName(String staffSpouseKindName) {
		this.staffSpouseKindName = staffSpouseKindName;
	}

	public String getHouseRelName() {
		return houseRelName;
	}

	public void setHouseRelName(String houseRelName) {
		this.houseRelName = houseRelName;
	}

	public Double getStaffDiscountRate() {
		return staffDiscountRate;
	}

	public void setStaffDiscountRate(Double staffDiscountRate) {
		this.staffDiscountRate = staffDiscountRate;
	}

	public List<HireHouseGetApply> getListHouseGetApply() {
		return listHouseGetApply;
	}

	public void setListHouseGetApply(List<HireHouseGetApply> listHouseGetApply) {
		this.listHouseGetApply = listHouseGetApply;
	}

	public List<HireApplyAlready> getListHireApplyAlready() {
		return listHireApplyAlready;
	}

	public void setListHireApplyAlready(List<HireApplyAlready> listHireApplyAlready) {
		this.listHireApplyAlready = listHireApplyAlready;
	}


	
    
}

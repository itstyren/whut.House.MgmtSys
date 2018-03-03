package com.computerdesign.whutHouseMgmt.bean.hire.apply;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffHouse;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.ViewStaff;
import com.fasterxml.jackson.annotation.JsonFormat;

public class HireGetApply {

	private Integer staffId;

    private String staffNo;

    private String staffName;

    private String staffSex;

    private String staffTitleName;

    private String staffPostName;

    private String staffTypeName;
    
    private Integer staffPostVal;
    
    private Integer staffSpousePostVal;

    private String staffDeptName;

    private String staffCode;

    private String staffTel;


    private List<HireHouseGetApply> listHouseGetApply;
    
    private HireApplyAlready HireApplyAlready;
    
    /**
     * 根据staffHouse的数据封装一个HireGetApply
     * @param staffHouse
     */
    public HireGetApply(ViewStaff viewStaff){
    	this.staffId = viewStaff.getId();
    	this.staffNo = viewStaff.getNo();
    	this.staffName = viewStaff.getName(); 
    	this.staffSex = viewStaff.getSex();
    	this.staffTitleName = viewStaff.getTitleName();
    	this.staffPostName = viewStaff.getPostName();
    	this.staffTypeName = viewStaff.getTypeName();
//    	this.staffStatusName = viewStaff.getStatusName();
    	this.staffPostVal = viewStaff.getPostVal();
    	this.staffSpousePostVal = viewStaff.getSpousePostVal();
//    	this.staffDeptId = viewStaff.getDept();
    	this.staffDeptName = viewStaff.getDeptName();
    	this.staffCode = viewStaff.getCode();
    	this.staffTel = viewStaff.getTel();
//    	this.staffRemark = viewStaff.getRemark();
//    	this.staffSpouseName = viewStaff.getSpouseName();
//    	this.staffSpouseCode = viewStaff.getSpouseCode();
//    	this.staffSpouseTitleName = viewStaff.getTitleName();
//    	this.staffSpousePostName = viewStaff.getSpousePostName();
//    	this.staffSpouseDept = viewStaff.getSpouseDept();
//    	this.staffSpouseKind = viewStaff.getSpouseKind();
//    	this.staffSpouseKindName = viewStaff.getSpouseKindName();
//    	this.staffDiscountRate = viewStaff.getDiscountRate();

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

//	public String getStaffStatusName() {
//		return staffStatusName;
//	}
//
//	public void setStaffStatusName(String staffStatusName) {
//		this.staffStatusName = staffStatusName;
//	}

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
//
//	public Integer getStaffDeptId() {
//		return staffDeptId;
//	}
//
//	public void setStaffDeptId(Integer staffDeptId) {
//		this.staffDeptId = staffDeptId;
//	}

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

//	public String getStaffRemark() {
//		return staffRemark;
//	}
//
//	public void setStaffRemark(String staffRemark) {
//		this.staffRemark = staffRemark;
//	}
//
//	public String getStaffSpouseName() {
//		return staffSpouseName;
//	}
//
//	public void setStaffSpouseName(String staffSpouseName) {
//		this.staffSpouseName = staffSpouseName;
//	}
//
//	public String getStaffSpouseCode() {
//		return staffSpouseCode;
//	}
//
//	public void setStaffSpouseCode(String staffSpouseCode) {
//		this.staffSpouseCode = staffSpouseCode;
//	}
//
//	public String getStaffSpouseTitleName() {
//		return staffSpouseTitleName;
//	}
//
//	public void setStaffSpouseTitleName(String staffSpouseTitleName) {
//		this.staffSpouseTitleName = staffSpouseTitleName;
//	}
//
//	public String getStaffSpousePostName() {
//		return staffSpousePostName;
//	}
//
//	public void setStaffSpousePostName(String staffSpousePostName) {
//		this.staffSpousePostName = staffSpousePostName;
//	}
//
//	public String getStaffSpouseDept() {
//		return staffSpouseDept;
//	}
//
//	public void setStaffSpouseDept(String staffSpouseDept) {
//		this.staffSpouseDept = staffSpouseDept;
//	}
//
//	public Integer getStaffSpouseKind() {
//		return staffSpouseKind;
//	}
//
//	public void setStaffSpouseKind(Integer staffSpouseKind) {
//		this.staffSpouseKind = staffSpouseKind;
//	}
//
//	public String getStaffSpouseKindName() {
//		return staffSpouseKindName;
//	}
//
//	public void setStaffSpouseKindName(String staffSpouseKindName) {
//		this.staffSpouseKindName = staffSpouseKindName;
//	}
//
//	public Double getStaffDiscountRate() {
//		return staffDiscountRate;
//	}
//
//	public void setStaffDiscountRate(Double staffDiscountRate) {
//		this.staffDiscountRate = staffDiscountRate;
//	}

	public List<HireHouseGetApply> getListHouseGetApply() {
		return listHouseGetApply;
	}

	public void setListHouseGetApply(List<HireHouseGetApply> listHouseGetApply) {
		this.listHouseGetApply = listHouseGetApply;
	}

	public HireApplyAlready getHireApplyAlready() {
		return HireApplyAlready;
	}

	public void setHireApplyAlready(HireApplyAlready hireApplyAlready) {
		HireApplyAlready = hireApplyAlready;
	}





	
    
}

package com.computerdesign.whutHouseMgmt.bean;

public class EmployeeParameter {
	private Integer employeeParamId;

	private String employeeParamName;

	private Integer paramTypeId;

	private String paramTypeName;

	private Integer employeeParamFra;

	private Integer employeeParamSpouseFra;

	private Float employeeParamHouseArea;

	private Boolean isDelete;

	public Integer getEmployeeParamId() {
		return employeeParamId;
	}

	public void setEmployeeParamId(Integer employeeParamId) {
		this.employeeParamId = employeeParamId;
	}

	public String getEmployeeParamName() {
		return employeeParamName;
	}

	public void setEmployeeParamName(String employeeParamName) {
		this.employeeParamName = employeeParamName == null ? null : employeeParamName.trim();
	}

	public Integer getParamTypeId() {
		return paramTypeId;
	}

	public void setParamTypeId(Integer paramTypeId) {
		this.paramTypeId = paramTypeId;
	}

	public String getParamTypeName() {
		return paramTypeName;
	}

	public void setParamTypeName(String paramTypeName) {
		this.paramTypeName = paramTypeName == null ? null : paramTypeName.trim();
	}

	public Integer getEmployeeParamFra() {
		return employeeParamFra;
	}

	public void setEmployeeParamFra(Integer employeeParamFra) {
		this.employeeParamFra = employeeParamFra;
	}

	public Integer getEmployeeParamSpouseFra() {
		return employeeParamSpouseFra;
	}

	public void setEmployeeParamSpouseFra(Integer employeeParamSpouseFra) {
		this.employeeParamSpouseFra = employeeParamSpouseFra;
	}

	public Float getEmployeeParamHouseArea() {
		return employeeParamHouseArea;
	}

	public void setEmployeeParamHouseArea(Float employeeParamHouseArea) {
		this.employeeParamHouseArea = employeeParamHouseArea;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "EmployeeParameter [employeeParamId=" + employeeParamId + ", employeeParamName=" + employeeParamName
				+ ", paramTypeId=" + paramTypeId + ", paramTypeName=" + paramTypeName + ", employeeParamFra="
				+ employeeParamFra + ", employeeParamSpouseFra=" + employeeParamSpouseFra + ", employeeParamHouseArea="
				+ employeeParamHouseArea + ", isDelete=" + isDelete + "]";
	}

}
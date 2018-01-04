package com.computerdesign.whutHouseMgmt.bean.staffparam;

import java.util.List;

import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffModel;

public class StaffParameterModel {
	private Integer staffParamId;

    private String staffParamName;
    
    private List<StaffModel> staffModels;

	public Integer getStaffParamId() {
		return staffParamId;
	}

	public List<StaffModel> getStaffModels() {
		return staffModels;
	}

	public void setStaffModels(List<StaffModel> staffModels) {
		this.staffModels = staffModels;
	}

	public void setStaffParamId(Integer staffParamId) {
		this.staffParamId = staffParamId;
	}

	public String getStaffParamName() {
		return staffParamName;
	}

	public void setStaffParamName(String staffParamName) {
		this.staffParamName = staffParamName;
	}
    
    
}

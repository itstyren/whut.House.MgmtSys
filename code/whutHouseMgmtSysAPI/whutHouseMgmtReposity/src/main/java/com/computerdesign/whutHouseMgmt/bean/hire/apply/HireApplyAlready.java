package com.computerdesign.whutHouseMgmt.bean.hire.apply;

import com.computerdesign.whutHouseMgmt.bean.hire.common.ViewHire;

public class HireApplyAlready {

    private String staffNo;

    private Integer id;

    private Double totalVal;

    private String hireState;
    
    public HireApplyAlready(ViewHire viewHire){
    	this.staffNo = viewHire.getStaffNo();
    	this.id = viewHire.getId();
    	this.totalVal = viewHire.getTotalVal();
    	this.hireState = viewHire.getHireState();
    } 

	public String getStaffNo() {
		return staffNo;
	}

	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getTotalVal() {
		return totalVal;
	}

	public void setTotalVal(Double totalVal) {
		this.totalVal = totalVal;
	}


	public String getHireState() {
		return hireState;
	}

	public void setHireState(String hireState) {
		this.hireState = hireState;
	}

    
}

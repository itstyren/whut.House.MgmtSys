package com.computerdesign.whutHouseMgmt.bean.hire;

public class HireApplyAlready {

    private String staffNo;

    private Integer id;

    private Double staffVal;

    private String hireState;
    
    public HireApplyAlready(ViewHire viewHire){
    	this.staffNo = viewHire.getStaffNo();
    	this.id = viewHire.getId();
    	this.staffVal = viewHire.getStaffVal();
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

	public Double getStaffVal() {
		return staffVal;
	}

	public void setStaffVal(Double staffVal) {
		this.staffVal = staffVal;
	}

	public String getHireState() {
		return hireState;
	}

	public void setHireState(String hireState) {
		this.hireState = hireState;
	}

    
}

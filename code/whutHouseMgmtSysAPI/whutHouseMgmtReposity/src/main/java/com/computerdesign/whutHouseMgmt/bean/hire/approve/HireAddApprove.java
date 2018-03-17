package com.computerdesign.whutHouseMgmt.bean.hire.approve;

import io.swagger.annotations.ApiModelProperty;

public class HireAddApprove {

	@ApiModelProperty(example="109")
	private Integer id;

	@ApiModelProperty(example="可以同意")
	private String approveNote;

	@ApiModelProperty(example="通过",value= "只能为通过或拒绝")
	private String approveState;

	@ApiModelProperty(example="杨幂")
	private String approveMan;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApproveNote() {
		return approveNote;
	}

	public void setApproveNote(String approveNote) {
		this.approveNote = approveNote;
	}

	public String getApproveState() {
		return approveState;
	}

	public void setApproveState(String approveState) {
		this.approveState = approveState;
	}

	public String getApproveMan() {
		return approveMan;
	}

	public void setApproveMan(String approveMan) {
		this.approveMan = approveMan;
	}
	
	
}

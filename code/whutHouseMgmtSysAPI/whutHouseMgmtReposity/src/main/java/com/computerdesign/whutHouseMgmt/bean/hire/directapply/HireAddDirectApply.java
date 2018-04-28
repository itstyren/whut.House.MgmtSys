package com.computerdesign.whutHouseMgmt.bean.hire.directapply;

import io.swagger.annotations.ApiModelProperty;

public class HireAddDirectApply {

	@ApiModelProperty(example ="1",value="员工id")
    private Integer staffId;

	@ApiModelProperty(example="1")
    private Integer houseId;

	@ApiModelProperty(example="直批直批")
    private String directApplyNote;

	@ApiModelProperty(example="乔布斯")
    private String directApplyMan;

	

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	public String getDirectApplyNote() {
		return directApplyNote;
	}

	public void setDirectApplyNote(String directApplyNote) {
		this.directApplyNote = directApplyNote;
	}

	public String getDirectApplyMan() {
		return directApplyMan;
	}

	public void setDirectApplyMan(String directApplyMan) {
		this.directApplyMan = directApplyMan;
	}

	
    
    
}

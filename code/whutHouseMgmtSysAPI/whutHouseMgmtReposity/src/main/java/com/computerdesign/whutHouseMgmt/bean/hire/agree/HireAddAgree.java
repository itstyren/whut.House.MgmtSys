package com.computerdesign.whutHouseMgmt.bean.hire.agree;

import io.swagger.annotations.ApiModelProperty;

public class HireAddAgree {

	@ApiModelProperty(example = "111")
    private Integer id;

	@ApiModelProperty(example = "2")
    private Integer houseId;

	@ApiModelProperty(example = "麻生周一")
    private String agreeNote;

	@ApiModelProperty(example="通过",value="只能为通过或拒绝")
    private String agreeState;

	@ApiModelProperty(example="古力娜扎")
    private String agreeMan;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	public String getAgreeNote() {
		return agreeNote;
	}

	public void setAgreeNote(String agreeNote) {
		this.agreeNote = agreeNote;
	}

	public String getAgreeState() {
		return agreeState;
	}

	public void setAgreeState(String agreeState) {
		this.agreeState = agreeState;
	}

	public String getAgreeMan() {
		return agreeMan;
	}

	public void setAgreeMan(String agreeMan) {
		this.agreeMan = agreeMan;
	}
    
    
}

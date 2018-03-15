package com.computerdesign.whutHouseMgmt.bean.hire.accept;

import io.swagger.annotations.ApiModelProperty;

public class HireAddAccept {

	@ApiModelProperty(example = "101")
    private Integer id;

	@ApiModelProperty(example = "23333")
    private Double totalVal;

	@ApiModelProperty(example = "101")
    private Double timeVal;

	@ApiModelProperty(example = "101")
    private Double spouseVal;

	@ApiModelProperty(example = "101")
    private Double otherVal;
    
	@ApiModelProperty(example = "照桥心美")
    private String acceptNote;
    
	@ApiModelProperty(example = "齐木楠雄")
    private String acceptMan;

	@ApiModelProperty(example = "通过",value="只能为通过或者拒绝")
    private String acceptState;

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


	public Double getTimeVal() {
		return timeVal;
	}

	public void setTimeVal(Double timeVal) {
		this.timeVal = timeVal;
	}

	public Double getSpouseVal() {
		return spouseVal;
	}

	public void setSpouseVal(Double spouseVal) {
		this.spouseVal = spouseVal;
	}

	public Double getOtherVal() {
		return otherVal;
	}

	public void setOtherVal(Double otherVal) {
		this.otherVal = otherVal;
	}

	public String getAcceptNote() {
		return acceptNote;
	}

	public void setAcceptNote(String acceptNote) {
		this.acceptNote = acceptNote;
	}

	public String getAcceptMan() {
		return acceptMan;
	}

	public void setAcceptMan(String acceptMan) {
		this.acceptMan = acceptMan;
	}

	public String getAcceptState() {
		return acceptState;
	}

	public void setAcceptState(String acceptState) {
		this.acceptState = acceptState;
	}

    
    
}

package com.computerdesign.whutHouseMgmt.bean.fix.record;
/**
 *
 * @author wanhaoran
 * @date 2018年4月9日 下午2:03:32
 * 
 */

import java.util.Date;

public class FixAllSelectModel {

	private String fixContentId;
	
	private Integer buildingId;

    private Integer regionId;

    private Integer campusId;
    
    private Date startTime;
    
    private Date endTime;

	public String getFixContentId() {
		return fixContentId;
	}

	public void setFixContentId(String fixContentId) {
		this.fixContentId = fixContentId;
	}

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public Integer getCampusId() {
		return campusId;
	}

	public void setCampusId(Integer campusId) {
		this.campusId = campusId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
    
    
}

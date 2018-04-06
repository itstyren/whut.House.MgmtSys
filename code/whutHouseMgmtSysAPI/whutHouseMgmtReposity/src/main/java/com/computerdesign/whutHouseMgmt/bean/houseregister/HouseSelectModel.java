package com.computerdesign.whutHouseMgmt.bean.houseregister;

/**
 * 用于封装模糊查询需要的信息，基于视图查询
 * 
 * @author Administrator
 *
 */
public class HouseSelectModel {

	// 住房类型
	// private String houseType;
	private Integer houseTypeId;

	// 使用状态
	// private String useStatus;
	private Integer useStatusId;

	// 住房校区
	private Integer campusId;

	// 住房区域
	// private String houseZone;
	private Integer regionId;

	// 楼栋
	// private String building;
	private Integer buildingId;

	public Integer getHouseTypeId() {
		return houseTypeId;
	}

	public void setHouseTypeId(Integer houseTypeId) {
		this.houseTypeId = houseTypeId;
	}

	public Integer getUseStatusId() {
		return useStatusId;
	}

	public void setUseStatusId(Integer useStatusId) {
		this.useStatusId = useStatusId;
	}

	public Integer getCampusId() {
		return campusId;
	}

	public void setCampusId(Integer campusId) {
		this.campusId = campusId;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

}

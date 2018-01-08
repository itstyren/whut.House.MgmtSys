package com.computerdesign.whutHouseMgmt.bean.houseregister;

/**
 * 用于封装模糊查询需要的信息，基于视图查询
 * @author Administrator
 *
 */
public class HouseSelectModel {

	//住房类型
	private String houseType;
	
	//使用状态
	private String useStatus;
	
	//住房区域
	private String houseZone;
	
	//楼栋
	private String building;

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public String getUseStatus() {
		return useStatus;
	}

	public void setUseStatus(String useStatus) {
		this.useStatus = useStatus;
	}

	public String getHouseZone() {
		return houseZone;
	}

	public void setHouseZone(String houseZone) {
		this.houseZone = houseZone;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}
	
	
	
}


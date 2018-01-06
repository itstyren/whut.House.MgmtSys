package com.computerdesign.whutHouseMgmt.bean.house;

import java.util.Date;

/**
 * 全面多条件查询
 * 
 * @author Administrator
 *
 */
public class HouseAllSelectModel {
	// 住房类型
	private String houseType;

	// 使用状态
	private String useStatus;

	// 住房区域
	private String houseZone;

	//住房结构
	private String structName;
	
	//户型
	private String layoutName;
	
	// 楼栋
	private String building;

	//面积
	private AreaParameter areaParameter;
	
	//建设时间
	private FinishTime finishTime;

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

	public String getStructName() {
		return structName;
	}

	public void setStructName(String structName) {
		this.structName = structName;
	}

	public String getLayoutName() {
		return layoutName;
	}

	public void setLayoutName(String layoutName) {
		this.layoutName = layoutName;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	

	public AreaParameter getAreaParameter() {
		return areaParameter;
	}

	public void setAreaParameter(AreaParameter areaParameter) {
		this.areaParameter = areaParameter;
	}

	public FinishTime getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(FinishTime finishTime) {
		this.finishTime = finishTime;
	}
	
	
	
}

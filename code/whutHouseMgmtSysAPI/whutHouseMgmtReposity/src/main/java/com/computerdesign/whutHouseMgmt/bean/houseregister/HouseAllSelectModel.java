package com.computerdesign.whutHouseMgmt.bean.houseregister;

import java.util.Date;

import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.RentalScope;

/**
 * 全面多条件查询
 * 
 * @author Administrator
 *
 */
public class HouseAllSelectModel {
	// 住房类型
//	private String houseType;
	private Integer houseTypeId;

	// 使用状态
//	private String useStatus;
	private Integer useStatusId;

	// 住房结构
//	private String structName;
	private Integer structId;

	// 户型
//	private String layoutName;
	private Integer layoutId;

	// 租金
	private RentalScope rentalScope;
	
	//校区
	private Integer campusId;
	
	// 住房区域
//	private String houseZone;
	private Integer regionId;

	// 楼栋
//	private String building;
	private Integer buildingId;

	// 面积
	private AreaParameter areaParameter;

	// 建设时间
	private FinishTime finishTime;

//	//页码
//	private Integer page;
//	
//	//每页数量
//	private Integer size;
	
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

	public Integer getStructId() {
		return structId;
	}

	public void setStructId(Integer structId) {
		this.structId = structId;
	}

	public Integer getLayoutId() {
		return layoutId;
	}

	public void setLayoutId(Integer layoutId) {
		this.layoutId = layoutId;
	}

	public RentalScope getRentalScope() {
		return rentalScope;
	}

	public void setRentalScope(RentalScope rentalScope) {
		this.rentalScope = rentalScope;
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

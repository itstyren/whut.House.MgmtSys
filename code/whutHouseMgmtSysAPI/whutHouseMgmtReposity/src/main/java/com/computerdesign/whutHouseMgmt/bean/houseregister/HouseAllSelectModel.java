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
	private String houseType;

	// 使用状态
	private String useStatus;

	// 住房区域
	private String houseZone;

	// 住房结构
	private String structName;

	// 户型
	private String layoutName;

	// 楼栋
	private String building;

	// 面积
	private AreaParameter areaParameter;

	// 建设时间
	private FinishTime finishTime;

	// 租金
	private RentalScope rentalScope;
	
	//页码
	private Integer page;
	
	//每页数量
	private Integer size;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public RentalScope getRentalScope() {
		return rentalScope;
	}

	public void setRentalScope(RentalScope rentalScope) {
		this.rentalScope = rentalScope;
	}

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

package com.computerdesign.whutHouseMgmt.bean.internetselecthouse;

public class HousingInfo {

	//住房ID
	private Integer id;
	
	// 住房号
	private String no;

	// 户型
	private String layout;

	// 使用面积
	private Double usedArea;

	//住房校区
	private String campusName;
	
	// 所属区域
	private String regionName;

	// 所属楼栋
	private String buildingName;

	// 地址
	private String address;

	// 租金
	private Double rental;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public Double getUsedArea() {
		return usedArea;
	}

	public void setUsedArea(Double usedArea) {
		this.usedArea = usedArea;
	}

	public String getCampusName() {
		return campusName;
	}

	public void setCampusName(String campusName) {
		this.campusName = campusName;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getRental() {
		return rental;
	}

	public void setRental(Double rental) {
		this.rental = rental;
	}

}

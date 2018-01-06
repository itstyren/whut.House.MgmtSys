package com.computerdesign.whutHouseMgmt.bean.house;

/**
 * 用于封装模糊查询查找出来显示的信息,基于视图查询
 * @author Administrator
 *
 */
public class HouseShowModel {

	//住房号
	private String houseNo;
	
	//住房类型
	private String houseSort;
	
	//户型
	private String houseType;
	
	//使用状态
	private String useStatus;
	
	//使用面积
	private double usedArea;
	
	//地址
	private String address;
	
	//所属区域
	private String zoneName;
	
	//所属楼栋
	private String buildingName;

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getHouseSort() {
		return houseSort;
	}

	public void setHouseSort(String houseSort) {
		this.houseSort = houseSort;
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

	public double getUsedArea() {
		return usedArea;
	}

	public void setUsedArea(double usedArea) {
		this.usedArea = usedArea;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	@Override
	public String toString() {
		return "HouseShowModel [houseNo=" + houseNo + ", houseSort=" + houseSort + ", houseType=" + houseType
				+ ", useStatus=" + useStatus + ", usedArea=" + usedArea + ", address=" + address + ", zoneName="
				+ zoneName + ", buildingName=" + buildingName + "]";
	}
	
	
	
}

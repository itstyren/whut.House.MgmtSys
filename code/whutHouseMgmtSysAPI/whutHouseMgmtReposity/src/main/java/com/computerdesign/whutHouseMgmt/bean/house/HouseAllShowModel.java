package com.computerdesign.whutHouseMgmt.bean.house;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 对应全面多条件查询出来的数据显示
 * 
 * @author Administrator
 *
 */
public class HouseAllShowModel {

	// 住房号
	private String houseNo;

	// 住房类型
	private String houseSort;

	// 户型
	private String houseType;

	// 结构
	private String structName;

	// 使用状态
	private String useStatus;

	// 建筑面积
	private double buildArea;

	// 使用面积
	private double usedArea;

	// 地下室面积
	private double basementArea;

	// 地址
	private String address;

	// 竣工时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date finishTime;

	// 所属楼栋
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

	public String getStructName() {
		return structName;
	}

	public void setStructName(String structName) {
		this.structName = structName;
	}

	public String getUseStatus() {
		return useStatus;
	}

	public void setUseStatus(String useStatus) {
		this.useStatus = useStatus;
	}

	public double getBuildArea() {
		return buildArea;
	}

	public void setBuildArea(double buildArea) {
		this.buildArea = buildArea;
	}

	public double getUsedArea() {
		return usedArea;
	}

	public void setUsedArea(double usedArea) {
		this.usedArea = usedArea;
	}

	public double getBasementArea() {
		return basementArea;
	}

	public void setBasementArea(double basementArea) {
		this.basementArea = basementArea;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	@Override
	public String toString() {
		return "HouseAllShowModel [houseNo=" + houseNo + ", houseSort=" + houseSort + ", houseType=" + houseType
				+ ", structName=" + structName + ", useStatus=" + useStatus + ", buildArea=" + buildArea + ", usedArea="
				+ usedArea + ", basementArea=" + basementArea + ", address=" + address + ", finishTime=" + finishTime
				+ ", buildingName=" + buildingName + "]";
	}
	
	

}

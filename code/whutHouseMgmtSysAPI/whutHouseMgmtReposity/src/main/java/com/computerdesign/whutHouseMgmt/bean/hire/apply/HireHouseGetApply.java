package com.computerdesign.whutHouseMgmt.bean.hire.apply;

import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffHouse;

public class HireHouseGetApply {

	private Integer houseId;

    private String houseNo;
    
    private String houseTypeName;
    
    private String houseAddress;

    private Double houseBuildArea;

    private Double houseUsedArea;

    private String houseRelName;

    /**
     * 根据staffHouse封装一个HireHouseGetApply
     * @param staffHouse
     */
    public HireHouseGetApply(StaffHouse staffHouse) {
		this.houseId = staffHouse.getHouseId();
		this.houseNo = staffHouse.getHouseNo();
		this.houseTypeName = staffHouse.getHouseTypeName();
		this.houseAddress = staffHouse.getHouseAddress();
		this.houseBuildArea = staffHouse.getHouseBuildArea();
		this.houseUsedArea = staffHouse.getHouseUsedArea();
		this.houseRelName = staffHouse.getHouseRelName();

	}
    
	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getHouseTypeName() {
		return houseTypeName;
	}

	public void setHouseTypeName(String houseTypeName) {
		this.houseTypeName = houseTypeName;
	}

	public String getHouseAddress() {
		return houseAddress;
	}

	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}

	public Double getHouseBuildArea() {
		return houseBuildArea;
	}

	public void setHouseBuildArea(Double houseBuildArea) {
		this.houseBuildArea = houseBuildArea;
	}

	public Double getHouseUsedArea() {
		return houseUsedArea;
	}

	public void setHouseUsedArea(Double houseUsedArea) {
		this.houseUsedArea = houseUsedArea;
	}

	public String getHouseRelName() {
		return houseRelName;
	}

	public void setHouseRelName(String houseRelName) {
		this.houseRelName = houseRelName;
	}

    
    

}

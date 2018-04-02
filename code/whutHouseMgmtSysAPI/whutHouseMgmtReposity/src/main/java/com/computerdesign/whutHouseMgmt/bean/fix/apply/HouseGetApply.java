package com.computerdesign.whutHouseMgmt.bean.fix.apply;

import com.computerdesign.whutHouseMgmt.bean.houseManagement.house.ViewHouse;

public class HouseGetApply {

	private Integer id;

	private String no;

	private String typeName;
	
	private String address;
	
    private Double buildArea;

    private Double usedArea;
    
    private String statusName;
    
    private String fixContentId;
    
    private String fixContentName;

    public HouseGetApply(ViewHouse viewHouse) {
		this.id = viewHouse.getId();
		this.no = viewHouse.getNo();
		this.typeName = viewHouse.getTypeName();
		this.address = viewHouse.getAddress();
		this.buildArea = viewHouse.getBuildArea();
		this.usedArea = viewHouse.getUsedArea();
		this.statusName = viewHouse.getStatusName();
	}
    
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

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getBuildArea() {
		return buildArea;
	}

	public void setBuildArea(Double buildArea) {
		this.buildArea = buildArea;
	}

	public Double getUsedArea() {
		return usedArea;
	}

	public void setUsedArea(Double usedArea) {
		this.usedArea = usedArea;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getFixContentId() {
		return fixContentId;
	}

	public void setFixContentId(String fixContentId) {
		this.fixContentId = fixContentId;
	}

	public String getFixContentName() {
		return fixContentName;
	}

	public void setFixContentName(String fixContentName) {
		this.fixContentName = fixContentName;
	}
    
}

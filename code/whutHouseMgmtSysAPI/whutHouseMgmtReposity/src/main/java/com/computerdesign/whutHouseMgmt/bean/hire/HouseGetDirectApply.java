package com.computerdesign.whutHouseMgmt.bean.hire;

import java.util.Date;

import javax.xml.crypto.Data;

import org.springframework.format.annotation.DateTimeFormat;

import com.computerdesign.whutHouseMgmt.bean.house.ViewHouse;
import com.fasterxml.jackson.annotation.JsonFormat;

public class HouseGetDirectApply {

	private Integer houseId;
	
	private String address;
	
	private String houseRel;
	
	private String layoutName;
	
	private String typeName;
	
	private Double usedArea;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date bookTime;

	
	
	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHouseRel() {
		return houseRel;
	}

	public void setHouseRel(String houseRel) {
		this.houseRel = houseRel;
	}

	public String getLayoutName() {
		return layoutName;
	}

	public void setLayoutName(String layoutName) {
		this.layoutName = layoutName;
	}
	
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Double getUsedArea() {
		return usedArea;
	}

	public void setUsedArea(Double usedArea) {
		this.usedArea = usedArea;
	}

	public Date getBookTime() {
		return bookTime;
	}

	public void setBookTime(Date bookTime) {
		this.bookTime = bookTime;
	}
	
	
}

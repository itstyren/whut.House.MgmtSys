package com.computerdesign.whutHouseMgmt.bean.houseregister;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ResidentRegister {
	
    private Integer staffId;
    
    private String house;
    
    private Integer houseRel;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date bookTime;
    
    private Integer payType;
    
    private Long buyAccount;

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public Integer getHouseRel() {
		return houseRel;
	}

	public void setHouseRel(Integer houseRel) {
		this.houseRel = houseRel;
	}

	public Date getBookTime() {
		return bookTime;
	}

	public void setBookTime(Date bookTime) {
		this.bookTime = bookTime;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public Long getBuyAccount() {
		return buyAccount;
	}

	public void setBuyAccount(Long buyAccount) {
		this.buyAccount = buyAccount;
	}
    
}

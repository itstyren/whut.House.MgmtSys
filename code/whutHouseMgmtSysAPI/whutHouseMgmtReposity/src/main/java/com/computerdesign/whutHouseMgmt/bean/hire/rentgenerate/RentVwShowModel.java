package com.computerdesign.whutHouseMgmt.bean.hire.rentgenerate;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RentVwShowModel {
	//职工号
	private String staffNo;
	
	//姓名
	private String staffName;
	
	//住房号
	private String houseNo;
	
	//地址
	private String address;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	//开始时间
	private Date rentBeginTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	//结束时间
	private Date rentEndTime;
	
	//缴费方式
	private String rentType;
	
	//原始租金
	private Double rentInitMoney;
	
	//租金
	private Double rentMoney;
	
	//优惠比例
    private String rentDiscountRate;

    //是否结算
    private Byte rentIsGet;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    //入住时间
    private Date bookTime;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    //到期时间
    private Date expireTime;
    
    private String staffDeptName;
    
	public String getStaffDeptName() {
		return staffDeptName;
	}

	public void setStaffDeptName(String staffDeptName) {
		this.staffDeptName = staffDeptName;
	}

	public String getStaffNo() {
		return staffNo;
	}

	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getRentBeginTime() {
		return rentBeginTime;
	}

	public void setRentBeginTime(Date rentBeginTime) {
		this.rentBeginTime = rentBeginTime;
	}

	public Date getRentEndTime() {
		return rentEndTime;
	}

	public void setRentEndTime(Date rentEndTime) {
		this.rentEndTime = rentEndTime;
	}

	public String getRentType() {
		return rentType;
	}

	public void setRentType(String rentType) {
		this.rentType = rentType;
	}

	public Double getRentInitMoney() {
		return rentInitMoney;
	}

	public void setRentInitMoney(Double rentInitMoney) {
		this.rentInitMoney = rentInitMoney;
	}

	public Double getRentMoney() {
		return rentMoney;
	}

	public void setRentMoney(Double rentMoney) {
		this.rentMoney = rentMoney;
	}

	public String getRentDiscountRate() {
		return rentDiscountRate;
	}

	public void setRentDiscountRate(String rentDiscountRate) {
		this.rentDiscountRate = rentDiscountRate;
	}

	public Byte getRentIsGet() {
		return rentIsGet;
	}

	public void setRentIsGet(Byte rentIsGet) {
		this.rentIsGet = rentIsGet;
	}

	public Date getBookTime() {
		return bookTime;
	}

	public void setBookTime(Date bookTime) {
		this.bookTime = bookTime;
	}

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
    
    
}

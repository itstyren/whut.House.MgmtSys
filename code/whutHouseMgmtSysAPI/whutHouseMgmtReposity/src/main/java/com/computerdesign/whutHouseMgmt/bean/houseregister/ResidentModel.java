package com.computerdesign.whutHouseMgmt.bean.houseregister;

import java.util.Date;

public class ResidentModel {
	private Integer staffId;

	private Integer houseId;

	private Integer houseRel;

	private Date bookTime;

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
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
}

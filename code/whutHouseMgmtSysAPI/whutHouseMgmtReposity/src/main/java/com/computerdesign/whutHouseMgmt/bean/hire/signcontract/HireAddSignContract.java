package com.computerdesign.whutHouseMgmt.bean.hire.signcontract;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class HireAddSignContract {

    private Integer id;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date bookTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getBookTime() {
		return bookTime;
	}

	public void setBookTime(Date bookTime) {
		this.bookTime = bookTime;
	}
    
    

}

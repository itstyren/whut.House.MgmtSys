package com.computerdesign.whutHouseMgmt.bean.hire.rentgenerate;

import java.util.Date;

/**
 * 用于租金生成中租金信息查询
 * @author Administrator
 *
 */
public class RentTimeRange {

	private Date startTime;
	
	private Date endTime;

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	
	
}

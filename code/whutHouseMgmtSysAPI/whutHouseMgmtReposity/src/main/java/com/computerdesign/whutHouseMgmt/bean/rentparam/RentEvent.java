package com.computerdesign.whutHouseMgmt.bean.rentparam;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RentEvent {
    private Integer rentEventId;

    private Integer paramTypeId;

    private String paramTypeName;

    private Boolean rentIsOpenSel;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date rentTimeBegin;

    private Integer rentTimeRanges;
    
    private String daySelectTimeRange;

    private String rentSelValReq;

    private String rentSelRules;

    private Boolean isDelete;

    public Integer getRentEventId() {
        return rentEventId;
    }

    public void setRentEventId(Integer rentEventId) {
        this.rentEventId = rentEventId;
    }

    public Integer getParamTypeId() {
        return paramTypeId;
    }

    public void setParamTypeId(Integer paramTypeId) {
        this.paramTypeId = paramTypeId;
    }

    public String getParamTypeName() {
        return paramTypeName;
    }

    public void setParamTypeName(String paramTypeName) {
        this.paramTypeName = paramTypeName == null ? null : paramTypeName.trim();
    }

    public Boolean getRentIsOpenSel() {
        return rentIsOpenSel;
    }

    public void setRentIsOpenSel(Boolean rentIsOpenSel) {
        this.rentIsOpenSel = rentIsOpenSel;
    }

    public Date getRentTimeBegin() {
        return rentTimeBegin;
    }

    public void setRentTimeBegin(Date rentTimeBegin) {
        this.rentTimeBegin = rentTimeBegin;
    }

    public Integer getRentTimeRanges() {
        return rentTimeRanges;
    }

    public void setRentTimeRanges(Integer rentTimeRanges) {
        this.rentTimeRanges = rentTimeRanges;
    }

    public String getDaySelectTimeRange() {
		return daySelectTimeRange;
	}

	public void setDaySelectTimeRange(String daySelectTimeRange) {
		this.daySelectTimeRange = daySelectTimeRange;
	}

	public String getRentSelValReq() {
        return rentSelValReq;
    }

    public void setRentSelValReq(String rentSelValReq) {
        this.rentSelValReq = rentSelValReq == null ? null : rentSelValReq.trim();
    }

    public String getRentSelRules() {
        return rentSelRules;
    }

    public void setRentSelRules(String rentSelRules) {
        this.rentSelRules = rentSelRules == null ? null : rentSelRules.trim();
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
    
    public RentEvent(Integer paramTypeId, String paramTypeName, Boolean rentIsOpenSel, Boolean isDelete) {
		super();
		this.paramTypeId = paramTypeId;
		this.paramTypeName = paramTypeName;
		this.rentIsOpenSel = rentIsOpenSel;
		this.isDelete = isDelete;
	}

	public RentEvent() {
		super();
	}
    
    

}
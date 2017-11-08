package com.computerdesign.whutHouseMgmt.bean.rentparam;

import java.util.Date;

public class RentEvent {
    private Integer rentEventId;

    private Integer paramTypeId;

    private String paramTypeName;

    private Boolean rentIsOpenSel;

    private Date rentTimeBegin;

    private Date rentTimeRanges;

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

    public Date getRentTimeRanges() {
        return rentTimeRanges;
    }

    public void setRentTimeRanges(Date rentTimeRanges) {
        this.rentTimeRanges = rentTimeRanges;
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
}
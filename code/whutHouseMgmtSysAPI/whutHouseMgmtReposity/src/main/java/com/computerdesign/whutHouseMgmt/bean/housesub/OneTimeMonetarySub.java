package com.computerdesign.whutHouseMgmt.bean.housesub;

import java.math.BigDecimal;

public class OneTimeMonetarySub {
    private Integer id;

    private String staffNo;

    private String oneTimeSubYear;

    private BigDecimal oneTimeSubsidy;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo == null ? null : staffNo.trim();
    }

    public String getOneTimeSubYear() {
        return oneTimeSubYear;
    }

    public void setOneTimeSubYear(String oneTimeSubYear) {
        this.oneTimeSubYear = oneTimeSubYear == null ? null : oneTimeSubYear.trim();
    }

    public BigDecimal getOneTimeSubsidy() {
        return oneTimeSubsidy;
    }

    public void setOneTimeSubsidy(BigDecimal oneTimeSubsidy) {
        this.oneTimeSubsidy = oneTimeSubsidy;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
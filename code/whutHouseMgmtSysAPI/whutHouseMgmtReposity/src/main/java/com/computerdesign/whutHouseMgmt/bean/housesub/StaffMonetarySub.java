package com.computerdesign.whutHouseMgmt.bean.housesub;

import java.util.Date;

public class StaffMonetarySub {
    private Integer id;

    private String staffNo;

    private String year;

    private Long annualSal;

    private Long subsidies;

    private String remark;

    private Date createTime;

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public Long getAnnualSal() {
        return annualSal;
    }

    public void setAnnualSal(Long annualSal) {
        this.annualSal = annualSal;
    }

    public Long getSubsidies() {
        return subsidies;
    }

    public void setSubsidies(Long subsidies) {
        this.subsidies = subsidies;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
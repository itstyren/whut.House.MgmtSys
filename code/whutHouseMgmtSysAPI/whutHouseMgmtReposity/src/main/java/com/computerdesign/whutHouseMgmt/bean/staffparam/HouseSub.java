package com.computerdesign.whutHouseMgmt.bean.staffparam;

public class HouseSub {
    private Integer id;

    private String year;

    private Long subsidiesCoe;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public Long getSubsidiesCoe() {
        return subsidiesCoe;
    }

    public void setSubsidiesCoe(Long subsidiesCoe) {
        this.subsidiesCoe = subsidiesCoe;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
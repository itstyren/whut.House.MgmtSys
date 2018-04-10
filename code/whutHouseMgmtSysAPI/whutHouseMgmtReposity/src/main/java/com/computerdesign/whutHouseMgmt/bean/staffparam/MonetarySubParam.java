package com.computerdesign.whutHouseMgmt.bean.staffparam;

public class MonetarySubParam {
    private Integer id;

    private Boolean isUsed;

    private Integer subParam;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Boolean isUsed) {
        this.isUsed = isUsed;
    }

    public Integer getSubParam() {
        return subParam;
    }

    public void setSubParam(Integer subParam) {
        this.subParam = subParam;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
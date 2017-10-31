package com.computerdesign.whutHouseMgmt.bean.houseparam;

public class HouseParameter {
    private Integer houseParamId;

    private String houseParamName;

    private Integer paramTypeId;

    private String paramTypeName;

    private String houseParamRelation;

    private Boolean isDelete;

    public Integer getHouseParamId() {
        return houseParamId;
    }

    public void setHouseParamId(Integer houseParamId) {
        this.houseParamId = houseParamId;
    }

    public String getHouseParamName() {
        return houseParamName;
    }

    public void setHouseParamName(String houseParamName) {
        this.houseParamName = houseParamName == null ? null : houseParamName.trim();
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

    public String getHouseParamRelation() {
        return houseParamRelation;
    }

    public void setHouseParamRelation(String houseParamRelation) {
        this.houseParamRelation = houseParamRelation == null ? null : houseParamRelation.trim();
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}
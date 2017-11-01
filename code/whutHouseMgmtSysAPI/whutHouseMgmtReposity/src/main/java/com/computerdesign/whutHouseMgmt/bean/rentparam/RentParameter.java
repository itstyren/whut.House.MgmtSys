package com.computerdesign.whutHouseMgmt.bean.rentparam;

public class RentParameter {
    private Integer rentParamId;

    private String rentParamName;

    private Integer paramTypeId;

    private String paramTypeName;

    private Boolean isDelete;

    public Integer getRentParamId() {
        return rentParamId;
    }

    public void setRentParamId(Integer rentParamId) {
        this.rentParamId = rentParamId;
    }

    public String getRentParamName() {
        return rentParamName;
    }

    public void setRentParamName(String rentParamName) {
        this.rentParamName = rentParamName == null ? null : rentParamName.trim();
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

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}
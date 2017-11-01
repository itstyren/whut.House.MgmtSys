package com.computerdesign.whutHouseMgmt.bean.rentalparam;

public class RentalParameter {
    private Integer rentalParamId;

    private String rentalParamName;

    private Integer paramTypeId;

    private String paramTypeName;

    private Boolean isDelete;

    public Integer getRentalParamId() {
        return rentalParamId;
    }

    public void setRentalParamId(Integer rentalParamId) {
        this.rentalParamId = rentalParamId;
    }

    public String getRentalParamName() {
        return rentalParamName;
    }

    public void setRentalParamName(String rentalParamName) {
        this.rentalParamName = rentalParamName == null ? null : rentalParamName.trim();
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
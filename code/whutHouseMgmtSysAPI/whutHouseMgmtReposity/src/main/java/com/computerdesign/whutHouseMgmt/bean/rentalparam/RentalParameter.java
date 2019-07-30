package com.computerdesign.whutHouseMgmt.bean.rentalparam;

public class RentalParameter {
    private Integer rentalParamId;

    private Integer rentalTimeDiv;

    private String rentalOldDct;

    private Integer rentalNewDctYear;

    private String rentalNewDct;

    private Integer paramTypeId;

    private String paramTypeName;

    private String rentUpRate;

    private Integer limitYear;

    private Boolean isDelete;

    public Integer getRentalParamId() {
        return rentalParamId;
    }

    public void setRentalParamId(Integer rentalParamId) {
        this.rentalParamId = rentalParamId;
    }

    public Integer getRentalTimeDiv() {
        return rentalTimeDiv;
    }

    public void setRentalTimeDiv(Integer rentalTimeDiv) {
        this.rentalTimeDiv = rentalTimeDiv;
    }

    public String getRentalOldDct() {
        return rentalOldDct;
    }

    public void setRentalOldDct(String rentalOldDct) {
        this.rentalOldDct = rentalOldDct == null ? null : rentalOldDct.trim();
    }

    public Integer getRentalNewDctYear() {
        return rentalNewDctYear;
    }

    public void setRentalNewDctYear(Integer rentalNewDctYear) {
        this.rentalNewDctYear = rentalNewDctYear;
    }

    public String getRentalNewDct() {
        return rentalNewDct;
    }

    public void setRentalNewDct(String rentalNewDct) {
        this.rentalNewDct = rentalNewDct == null ? null : rentalNewDct.trim();
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

    public String getRentUpRate() {
        return rentUpRate;
    }

    public void setRentUpRate(String rentUpRate) {
        this.rentUpRate = rentUpRate == null ? null : rentUpRate.trim();
    }

    public Integer getLimitYear() {
        return limitYear;
    }

    public void setLimitYear(Integer limitYear) {
        this.limitYear = limitYear;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}
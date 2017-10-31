package com.computerdesign.whutHouseMgmt.bean.fixparam;

public class FixParameter {
    private Integer fixParamId;

    private String fixParamName;

    private Integer paramTypeId;

    private String paramTypeName;

    private Boolean isDelete; 

    public Integer getFixParamId() {
        return fixParamId;
    }

    public void setFixParamId(Integer fixParamId) {
        this.fixParamId = fixParamId;
    }

    public String getFixParamName() {
        return fixParamName;
    }

    public void setFixParamName(String fixParamName) {
        this.fixParamName = fixParamName == null ? null : fixParamName.trim();
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
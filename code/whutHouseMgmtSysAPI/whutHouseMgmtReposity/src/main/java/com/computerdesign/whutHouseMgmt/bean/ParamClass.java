package com.computerdesign.whutHouseMgmt.bean;

public class ParamClass {
    private Integer paramTypeId;

    private String paramTypeName;

    private String paramClassId;

    private String paramClassName;

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

    public String getParamClassId() {
        return paramClassId;
    }

    public void setParamClassId(String paramClassId) {
        this.paramClassId = paramClassId == null ? null : paramClassId.trim();
    }

    public String getParamClassName() {
        return paramClassName;
    }

    public void setParamClassName(String paramClassName) {
        this.paramClassName = paramClassName == null ? null : paramClassName.trim();
    }
}
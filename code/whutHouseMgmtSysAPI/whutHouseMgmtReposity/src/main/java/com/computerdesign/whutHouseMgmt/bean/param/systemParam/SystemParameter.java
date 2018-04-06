package com.computerdesign.whutHouseMgmt.bean.param.systemParam;

public class SystemParameter {
    private Integer sysParamId;

    private String sysParamName;

    private Integer paramTypeId;

    private String paramTypeName;

    private String sysParamContent;

    public Integer getSysParamId() {
        return sysParamId;
    }

    public void setSysParamId(Integer sysParamId) {
        this.sysParamId = sysParamId;
    }

    public String getSysParamName() {
        return sysParamName;
    }

    public void setSysParamName(String sysParamName) {
        this.sysParamName = sysParamName == null ? null : sysParamName.trim();
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

    public String getSysParamContent() {
        return sysParamContent;
    }

    public void setSysParamContent(String sysParamContent) {
        this.sysParamContent = sysParamContent == null ? null : sysParamContent.trim();
    }
}
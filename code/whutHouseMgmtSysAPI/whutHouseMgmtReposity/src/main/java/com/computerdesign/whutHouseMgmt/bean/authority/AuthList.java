package com.computerdesign.whutHouseMgmt.bean.authority;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AuthList {
    private Integer id;

    private String groupName;

    private String remark;

    private Boolean state;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date addTime;

    private String property;

    private String manageCampus;

    private String userRouters;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property == null ? null : property.trim();
    }

    public String getManageCampus() {
        return manageCampus;
    }

    public void setManageCampus(String manageCampus) {
        this.manageCampus = manageCampus == null ? null : manageCampus.trim();
    }

    public String getUserRouters() {
        return userRouters;
    }

    public void setUserRouters(String userRouters) {
        this.userRouters = userRouters == null ? null : userRouters.trim();
    }
}
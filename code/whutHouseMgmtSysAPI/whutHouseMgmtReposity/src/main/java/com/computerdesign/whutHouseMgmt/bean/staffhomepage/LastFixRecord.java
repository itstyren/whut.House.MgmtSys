package com.computerdesign.whutHouseMgmt.bean.staffhomepage;

import java.util.Date;

public class LastFixRecord {
    private Integer id;

    private String staffFix;

    private String state;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStaffFix() {
        return staffFix;
    }

    public void setStaffFix(String staffFix) {
        this.staffFix = staffFix == null ? null : staffFix.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
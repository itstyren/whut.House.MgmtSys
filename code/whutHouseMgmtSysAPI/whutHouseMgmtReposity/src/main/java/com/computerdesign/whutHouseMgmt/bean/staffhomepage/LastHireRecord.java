package com.computerdesign.whutHouseMgmt.bean.staffhomepage;

import java.util.Date;

public class LastHireRecord {
    private Integer id;

    private String staffHire;

    private String state;

    private Date updateTime;

    private Boolean isOver;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStaffHire() {
        return staffHire;
    }

    public void setStaffHire(String staffHire) {
        this.staffHire = staffHire == null ? null : staffHire.trim();
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

    public Boolean getIsOver() {
        return isOver;
    }

    public void setIsOver(Boolean isOver) {
        this.isOver = isOver;
    }
}
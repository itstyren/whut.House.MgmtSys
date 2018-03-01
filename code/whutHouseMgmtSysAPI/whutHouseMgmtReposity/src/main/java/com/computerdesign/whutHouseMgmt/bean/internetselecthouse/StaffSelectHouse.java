package com.computerdesign.whutHouseMgmt.bean.internetselecthouse;

import java.util.Date;

public class StaffSelectHouse {
    private Integer selectId;

    private Integer staffId;

    private Date selectStart;

    private Date selectEnd;

    private String recordStatus;

    private Date createDate;

    private Date modifyDate;

    private String createUser;

    private String modifyUser;

    public Integer getSelectId() {
        return selectId;
    }

    public void setSelectId(Integer selectId) {
        this.selectId = selectId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Date getSelectStart() {
        return selectStart;
    }

    public void setSelectStart(Date selectStart) {
        this.selectStart = selectStart;
    }

    public Date getSelectEnd() {
        return selectEnd;
    }

    public void setSelectEnd(Date selectEnd) {
        this.selectEnd = selectEnd;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser == null ? null : modifyUser.trim();
    }
}
package com.computerdesign.whutHouseMgmt.bean.houseregister;

import java.util.Date;

public class OutSchoolHouseVw {
    private Integer id;

    private Integer staffId;

    private String staffName;

    private Integer houseRel;

    private String houseRelName;

    private String address;

    private Date bookTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public Integer getHouseRel() {
        return houseRel;
    }

    public void setHouseRel(Integer houseRel) {
        this.houseRel = houseRel;
    }

    public String getHouseRelName() {
        return houseRelName;
    }

    public void setHouseRelName(String houseRelName) {
        this.houseRelName = houseRelName == null ? null : houseRelName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getBookTime() {
        return bookTime;
    }

    public void setBookTime(Date bookTime) {
        this.bookTime = bookTime;
    }
}
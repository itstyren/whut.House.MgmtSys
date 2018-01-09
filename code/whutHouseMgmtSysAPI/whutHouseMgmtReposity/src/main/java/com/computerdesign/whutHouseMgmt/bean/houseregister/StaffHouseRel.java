package com.computerdesign.whutHouseMgmt.bean.houseregister;

public class StaffHouseRel {
    private String staffNo;

    private String staffName;

    private String houseRel;

    private String address;

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo == null ? null : staffNo.trim();
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public String getHouseRel() {
        return houseRel;
    }

    public void setHouseRel(String houseRel) {
        this.houseRel = houseRel == null ? null : houseRel.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}
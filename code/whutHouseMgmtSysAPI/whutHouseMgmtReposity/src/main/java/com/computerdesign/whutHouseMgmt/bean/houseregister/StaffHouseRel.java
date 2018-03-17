package com.computerdesign.whutHouseMgmt.bean.houseregister;

public class StaffHouseRel {
    private Integer residentId;

    private String staffNo;

    private String staffName;

    private String houseRel;

    private Long staffBuyAccount;

    private Long staffFixFund;

    private String address;

    private Boolean isDelete;

    public Integer getResidentId() {
        return residentId;
    }

    public void setResidentId(Integer residentId) {
        this.residentId = residentId;
    }

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

    public Long getStaffBuyAccount() {
        return staffBuyAccount;
    }

    public void setStaffBuyAccount(Long staffBuyAccount) {
        this.staffBuyAccount = staffBuyAccount;
    }

    public Long getStaffFixFund() {
        return staffFixFund;
    }

    public void setStaffFixFund(Long staffFixFund) {
        this.staffFixFund = staffFixFund;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}
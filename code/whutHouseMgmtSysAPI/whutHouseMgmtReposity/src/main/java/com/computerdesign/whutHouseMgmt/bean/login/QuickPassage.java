package com.computerdesign.whutHouseMgmt.bean.login;

public class QuickPassage {
    private Integer id;

    private Integer staffId;

    private String quickPassageName;

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

    public String getQuickPassageName() {
        return quickPassageName;
    }

    public void setQuickPassageName(String quickPassageName) {
        this.quickPassageName = quickPassageName == null ? null : quickPassageName.trim();
    }
}
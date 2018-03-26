package com.computerdesign.whutHouseMgmt.bean.staffmanagement;

public class StaffValue {
    private Integer id;

    private String no;

    private String name;

    private Integer titleId;

    private String titleName;

    private Integer staffTitleValue;

    private Integer postId;

    private String postName;

    private Integer staffPostValue;

    private Integer spouseTitleId;

    private String spouseTitleName;

    private Integer spouseTitleValue;

    private Integer spousePostId;

    private String spousePostName;

    private Integer spousePostValue;

    private Double otherValue;

    private Double timeValue;

    private Double totalValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getTitleId() {
        return titleId;
    }

    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName == null ? null : titleName.trim();
    }

    public Integer getStaffTitleValue() {
        return staffTitleValue;
    }

    public void setStaffTitleValue(Integer staffTitleValue) {
        this.staffTitleValue = staffTitleValue;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName == null ? null : postName.trim();
    }

    public Integer getStaffPostValue() {
        return staffPostValue;
    }

    public void setStaffPostValue(Integer staffPostValue) {
        this.staffPostValue = staffPostValue;
    }

    public Integer getSpouseTitleId() {
        return spouseTitleId;
    }

    public void setSpouseTitleId(Integer spouseTitleId) {
        this.spouseTitleId = spouseTitleId;
    }

    public String getSpouseTitleName() {
        return spouseTitleName;
    }

    public void setSpouseTitleName(String spouseTitleName) {
        this.spouseTitleName = spouseTitleName == null ? null : spouseTitleName.trim();
    }

    public Integer getSpouseTitleValue() {
        return spouseTitleValue;
    }

    public void setSpouseTitleValue(Integer spouseTitleValue) {
        this.spouseTitleValue = spouseTitleValue;
    }

    public Integer getSpousePostId() {
        return spousePostId;
    }

    public void setSpousePostId(Integer spousePostId) {
        this.spousePostId = spousePostId;
    }

    public String getSpousePostName() {
        return spousePostName;
    }

    public void setSpousePostName(String spousePostName) {
        this.spousePostName = spousePostName == null ? null : spousePostName.trim();
    }

    public Integer getSpousePostValue() {
        return spousePostValue;
    }

    public void setSpousePostValue(Integer spousePostValue) {
        this.spousePostValue = spousePostValue;
    }

    public Double getOtherValue() {
        return otherValue;
    }

    public void setOtherValue(Double otherValue) {
        this.otherValue = otherValue;
    }

    public Double getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(Double timeValue) {
        this.timeValue = timeValue;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }
}
package com.computerdesign.whutHouseMgmt.bean.housesub;

public class StaffForMonSub {
    private Integer staffId;

    private String staffNo;

    private String staffName;

    private Integer titleId;

    private String titleName;

    private Float titleArea;

    private Integer postId;

    private String postName;

    private Float postArea;

    private Double maxEnjoyArea;

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
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

    public Float getTitleArea() {
        return titleArea;
    }

    public void setTitleArea(Float titleArea) {
        this.titleArea = titleArea;
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

    public Float getPostArea() {
        return postArea;
    }

    public void setPostArea(Float postArea) {
        this.postArea = postArea;
    }

    public Double getMaxEnjoyArea() {
        return maxEnjoyArea;
    }

    public void setMaxEnjoyArea(Double maxEnjoyArea) {
        this.maxEnjoyArea = maxEnjoyArea;
    }
}
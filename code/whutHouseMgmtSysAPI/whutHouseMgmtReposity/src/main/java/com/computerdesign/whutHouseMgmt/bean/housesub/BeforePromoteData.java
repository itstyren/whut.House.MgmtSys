package com.computerdesign.whutHouseMgmt.bean.housesub;

public class BeforePromoteData {
    private Integer id;

    private Integer staffId;

    private Integer titleId;

    private String titleName;

    private Integer postId;

    private String postName;

    private Float maxEnjoyArea;

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

    public Float getMaxEnjoyArea() {
        return maxEnjoyArea;
    }

    public void setMaxEnjoyArea(Float maxEnjoyArea) {
        this.maxEnjoyArea = maxEnjoyArea;
    }
}
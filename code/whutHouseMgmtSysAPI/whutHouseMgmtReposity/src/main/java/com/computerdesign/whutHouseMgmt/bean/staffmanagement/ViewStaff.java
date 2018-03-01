package com.computerdesign.whutHouseMgmt.bean.staffmanagement;

import java.util.Date;

public class ViewStaff {
    private Integer id;

    private String no;

    private String name;

    private String sex;

    private String marriageState;

    private Integer title;

    private String titleName;

    private Integer titleVal;

    private Integer spouseTitleVal;

    private Integer post;

    private String postName;

    private Integer postVal;

    private Integer spousePostVal;

    private Integer type;

    private String typeName;

    private Integer status;

    private String statusName;

    private Integer dept;

    private String deptName;

    private String code;

    private Date joinTime;

    private Date goUniversityTime;

    private Date retireTime;

    private String tel;

    private String remark;

    private String spouseName;

    private String spouseCode;

    private Integer spouseTitle;

    private String spouseTitleName;

    private Integer spousePost;

    private String spousePostName;

    private Double otherVal;

    private Double timeVal;

    private Double totalVal;

    private Byte isSuper;

    private String spouseDept;

    private Integer spouseKind;

    private String spouseKindName;

    private Boolean isDeptManage;

    private String staffPassword;

    private Long buyAccount;

    private Long fixFund;

    private Date secondJoinTime;

    private Date secondRetireTime;

    private String staffDual;

    private String relation;

    private Double discountRate;

    private Integer familyCode;

    private Date firstJobTime;

    private String userName;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getMarriageState() {
        return marriageState;
    }

    public void setMarriageState(String marriageState) {
        this.marriageState = marriageState == null ? null : marriageState.trim();
    }

    public Integer getTitle() {
        return title;
    }

    public void setTitle(Integer title) {
        this.title = title;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName == null ? null : titleName.trim();
    }

    public Integer getTitleVal() {
        return titleVal;
    }

    public void setTitleVal(Integer titleVal) {
        this.titleVal = titleVal;
    }

    public Integer getSpouseTitleVal() {
        return spouseTitleVal;
    }

    public void setSpouseTitleVal(Integer spouseTitleVal) {
        this.spouseTitleVal = spouseTitleVal;
    }

    public Integer getPost() {
        return post;
    }

    public void setPost(Integer post) {
        this.post = post;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName == null ? null : postName.trim();
    }

    public Integer getPostVal() {
        return postVal;
    }

    public void setPostVal(Integer postVal) {
        this.postVal = postVal;
    }

    public Integer getSpousePostVal() {
        return spousePostVal;
    }

    public void setSpousePostVal(Integer spousePostVal) {
        this.spousePostVal = spousePostVal;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName == null ? null : statusName.trim();
    }

    public Integer getDept() {
        return dept;
    }

    public void setDept(Integer dept) {
        this.dept = dept;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public Date getGoUniversityTime() {
        return goUniversityTime;
    }

    public void setGoUniversityTime(Date goUniversityTime) {
        this.goUniversityTime = goUniversityTime;
    }

    public Date getRetireTime() {
        return retireTime;
    }

    public void setRetireTime(Date retireTime) {
        this.retireTime = retireTime;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName == null ? null : spouseName.trim();
    }

    public String getSpouseCode() {
        return spouseCode;
    }

    public void setSpouseCode(String spouseCode) {
        this.spouseCode = spouseCode == null ? null : spouseCode.trim();
    }

    public Integer getSpouseTitle() {
        return spouseTitle;
    }

    public void setSpouseTitle(Integer spouseTitle) {
        this.spouseTitle = spouseTitle;
    }

    public String getSpouseTitleName() {
        return spouseTitleName;
    }

    public void setSpouseTitleName(String spouseTitleName) {
        this.spouseTitleName = spouseTitleName == null ? null : spouseTitleName.trim();
    }

    public Integer getSpousePost() {
        return spousePost;
    }

    public void setSpousePost(Integer spousePost) {
        this.spousePost = spousePost;
    }

    public String getSpousePostName() {
        return spousePostName;
    }

    public void setSpousePostName(String spousePostName) {
        this.spousePostName = spousePostName == null ? null : spousePostName.trim();
    }

    public Double getOtherVal() {
        return otherVal;
    }

    public void setOtherVal(Double otherVal) {
        this.otherVal = otherVal;
    }

    public Double getTimeVal() {
        return timeVal;
    }

    public void setTimeVal(Double timeVal) {
        this.timeVal = timeVal;
    }

    public Double getTotalVal() {
        return totalVal;
    }

    public void setTotalVal(Double totalVal) {
        this.totalVal = totalVal;
    }

    public Byte getIsSuper() {
        return isSuper;
    }

    public void setIsSuper(Byte isSuper) {
        this.isSuper = isSuper;
    }

    public String getSpouseDept() {
        return spouseDept;
    }

    public void setSpouseDept(String spouseDept) {
        this.spouseDept = spouseDept == null ? null : spouseDept.trim();
    }

    public Integer getSpouseKind() {
        return spouseKind;
    }

    public void setSpouseKind(Integer spouseKind) {
        this.spouseKind = spouseKind;
    }

    public String getSpouseKindName() {
        return spouseKindName;
    }

    public void setSpouseKindName(String spouseKindName) {
        this.spouseKindName = spouseKindName == null ? null : spouseKindName.trim();
    }

    public Boolean getIsDeptManage() {
        return isDeptManage;
    }

    public void setIsDeptManage(Boolean isDeptManage) {
        this.isDeptManage = isDeptManage;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword == null ? null : staffPassword.trim();
    }

    public Long getBuyAccount() {
        return buyAccount;
    }

    public void setBuyAccount(Long buyAccount) {
        this.buyAccount = buyAccount;
    }

    public Long getFixFund() {
        return fixFund;
    }

    public void setFixFund(Long fixFund) {
        this.fixFund = fixFund;
    }

    public Date getSecondJoinTime() {
        return secondJoinTime;
    }

    public void setSecondJoinTime(Date secondJoinTime) {
        this.secondJoinTime = secondJoinTime;
    }

    public Date getSecondRetireTime() {
        return secondRetireTime;
    }

    public void setSecondRetireTime(Date secondRetireTime) {
        this.secondRetireTime = secondRetireTime;
    }

    public String getStaffDual() {
        return staffDual;
    }

    public void setStaffDual(String staffDual) {
        this.staffDual = staffDual == null ? null : staffDual.trim();
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation == null ? null : relation.trim();
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }

    public Integer getFamilyCode() {
        return familyCode;
    }

    public void setFamilyCode(Integer familyCode) {
        this.familyCode = familyCode;
    }

    public Date getFirstJobTime() {
        return firstJobTime;
    }

    public void setFirstJobTime(Date firstJobTime) {
        this.firstJobTime = firstJobTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
}
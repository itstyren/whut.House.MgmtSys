package com.computerdesign.whutHouseMgmt.bean.staffmanagement;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StaffVw {
    private Integer id;

    private String no;

    private String name;

    private String sex;

    private String marriageState;

    private Integer titleId;

    private String titleName;

    private Integer postId;

    private String postName;

    private Integer typeId;

    private String typeName;

    private Integer statusId;

    private String statusName;

    private Integer deptId;

    private String deptName;

    private String code;

    private String eduQualifications;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
   	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date joinTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
   	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date retireTime;

    private String tel;

    private String email;

    private String remark;

    private String spouseName;

    private String spouseCode;

    private String spouseTitleName;

    private String spousePostName;

    private String spouseDept;

    private Integer spouseKind;

    private Boolean isDeptManage;

    private String staffPassword;

    private Long buyAccount;

    private BigDecimal compensate;

    private Long fixFund;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
   	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date secondJoinTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
   	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date secondRetireTime;

    private String staffDual;

    private String relation;

    private Double discountRate;

    private Integer familyCode;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
   	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date firstJobTime;

    private String userName;

    private Boolean isOwnPriHouse;
    
    private Integer roleId;

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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName == null ? null : statusName.trim();
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
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

    public String getEduQualifications() {
        return eduQualifications;
    }

    public void setEduQualifications(String eduQualifications) {
        this.eduQualifications = eduQualifications == null ? null : eduQualifications.trim();
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
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

    public String getSpouseTitleName() {
        return spouseTitleName;
    }

    public void setSpouseTitleName(String spouseTitleName) {
        this.spouseTitleName = spouseTitleName == null ? null : spouseTitleName.trim();
    }

    public String getSpousePostName() {
        return spousePostName;
    }

    public void setSpousePostName(String spousePostName) {
        this.spousePostName = spousePostName == null ? null : spousePostName.trim();
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

    public BigDecimal getCompensate() {
        return compensate;
    }

    public void setCompensate(BigDecimal compensate) {
        this.compensate = compensate;
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

    public Boolean getIsOwnPriHouse() {
        return isOwnPriHouse;
    }

    public void setIsOwnPriHouse(Boolean isOwnPriHouse) {
        this.isOwnPriHouse = isOwnPriHouse;
    }

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
    
}
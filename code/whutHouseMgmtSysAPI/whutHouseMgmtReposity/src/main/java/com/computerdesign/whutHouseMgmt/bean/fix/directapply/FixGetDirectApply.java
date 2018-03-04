package com.computerdesign.whutHouseMgmt.bean.fix.directapply;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffVw;
import com.fasterxml.jackson.annotation.JsonFormat;

public class FixGetDirectApply {

	private Integer staffId;

    private String no;

    private String name;

    private String sex;

    private String marriageState;

    private String titleName;

    private String postName;

    private String typeName;

    private String statusName;

    private Integer deptId;

    private String deptName;

    private String code;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
   	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date joinTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
   	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date goUniversityTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
   	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date retireTime;

    private String tel;

    private String remark;

    private String spouseName;

    private String spouseCode;

    private String spouseTitleName;

    private String spousePostName;

    private String spouseDept;

    private Integer spouseKind;
    
    private List<HouseGetDirectApply> houseList;
    
    public FixGetDirectApply(StaffVw staffVw){
		this.staffId = staffVw.getId();
		this.no = staffVw.getNo();
		this.name = staffVw.getName();
		this.sex = staffVw.getSex();
		this.marriageState = staffVw.getMarriageState();
		this.postName = staffVw.getPostName();
		this.titleName = staffVw.getTitleName();
		this.typeName = staffVw.getTypeName();
		this.statusName = staffVw.getStatusName();
		this.deptId = staffVw.getDeptId();
		this.deptName = staffVw.getDeptName();
		this.tel = staffVw.getTel();
		this.code = staffVw.getCode();
		this.joinTime= staffVw.getJoinTime();
		this.goUniversityTime = staffVw.getGoUniversityTime();
		this.remark = staffVw.getRemark();
		this.spouseCode = staffVw.getSpouseCode();
		this.spouseDept = staffVw.getSpouseDept();
		this.spouseKind = staffVw.getSpouseKind();
		this.spouseName = staffVw.getSpouseName();
		this.spousePostName = staffVw.getSpousePostName();
		this.spouseTitleName = staffVw.getSpouseTitleName();
	}

	

	public Integer getStaffId() {
		return staffId;
	}



	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}



	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMarriageState() {
		return marriageState;
	}

	public void setMarriageState(String marriageState) {
		this.marriageState = marriageState;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
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
		this.deptName = deptName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
		this.tel = tel;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public String getSpouseCode() {
		return spouseCode;
	}

	public void setSpouseCode(String spouseCode) {
		this.spouseCode = spouseCode;
	}

	public String getSpouseTitleName() {
		return spouseTitleName;
	}

	public void setSpouseTitleName(String spouseTitleName) {
		this.spouseTitleName = spouseTitleName;
	}

	public String getSpousePostName() {
		return spousePostName;
	}

	public void setSpousePostName(String spousePostName) {
		this.spousePostName = spousePostName;
	}

	public String getSpouseDept() {
		return spouseDept;
	}

	public void setSpouseDept(String spouseDept) {
		this.spouseDept = spouseDept;
	}

	public Integer getSpouseKind() {
		return spouseKind;
	}

	public void setSpouseKind(Integer spouseKind) {
		this.spouseKind = spouseKind;
	}

	public List<HouseGetDirectApply> getHouseList() {
		return houseList;
	}

	public void setHouseList(List<HouseGetDirectApply> houseList) {
		this.houseList = houseList;
	}
    
    
}

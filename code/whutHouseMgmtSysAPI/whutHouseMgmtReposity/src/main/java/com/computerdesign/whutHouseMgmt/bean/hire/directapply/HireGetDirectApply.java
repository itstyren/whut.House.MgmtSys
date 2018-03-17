package com.computerdesign.whutHouseMgmt.bean.hire.directapply;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.computerdesign.whutHouseMgmt.bean.staffmanagement.ViewStaff;
import com.fasterxml.jackson.annotation.JsonFormat;

public class HireGetDirectApply {

	private Integer id;

	private String no;

	private String name;

	private String sex;

	private String marriageState;

	private String titleName;

	private String postName;
	
	private String typeName;
	
	private String statusName;
	
	private String deptName;
	
	private String code;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date joinTime;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date retireTime;
    
    private String tel;

    private String remark;

    private String spouseName;
    
    private String spouseTitleName;
    
    private String spousePostName;
    
    private String spouseKindName;
    
    private List<HireHouseGetDirectApply> listHouseGetDirectApply ;
    
    public HireGetDirectApply(ViewStaff viewStaff) {
    	this.id = viewStaff.getId();
    	this.no = viewStaff.getNo();
    	this.name = viewStaff.getName(); 
    	this.sex = viewStaff.getSex();
    	this.marriageState = viewStaff.getMarriageState();
    	this.titleName = viewStaff.getTitleName();
    	this.postName = viewStaff.getPostName();
    	this.typeName = viewStaff.getTypeName();
    	this.statusName = viewStaff.getStatusName();    	
    	this.deptName = viewStaff.getDeptName();
    	this.code = viewStaff.getCode();
    	this.tel = viewStaff.getTel();
    	this.remark = viewStaff.getRemark();
    	this.joinTime = viewStaff.getJoinTime();
    	this.retireTime = viewStaff.getRetireTime();
    	this.spouseName = viewStaff.getSpouseName();
    	this.spouseTitleName = viewStaff.getTitleName();
    	this.spousePostName = viewStaff.getPostName();
    	this.spouseKindName = viewStaff.getSpouseKindName();
    	
	}

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

	public String getSpouseKindName() {
		return spouseKindName;
	}

	public void setSpouseKindName(String spouseKindName) {
		this.spouseKindName = spouseKindName;
	}

	public List<HireHouseGetDirectApply> getListHouseGetDirectApply() {
		return listHouseGetDirectApply;
	}

	public void setListHouseGetDirectApply(List<HireHouseGetDirectApply> listHouseGetDirectApply) {
		this.listHouseGetDirectApply = listHouseGetDirectApply;
	}

	
    
}

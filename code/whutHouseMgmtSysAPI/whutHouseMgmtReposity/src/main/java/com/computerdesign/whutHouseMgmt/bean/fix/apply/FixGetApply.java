package com.computerdesign.whutHouseMgmt.bean.fix.apply;

import java.util.List;

import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffVw;



public class FixGetApply {

	private Integer id;

    private String no;

    private String name;

    private String sex;
    
    private String code;
    
    private String postName;
    
    private String deptName;
    
    private String tel;
    
    private String email;
    
    private List<HouseGetApply> housesList;

    public FixGetApply(StaffVw staffVw) {
		this.id = staffVw.getId();
		this.no = staffVw.getNo();
		this.name = staffVw.getName();
		this.sex = staffVw.getSex();
		this.code = staffVw.getCode();
		this.postName = staffVw.getPostName();
		this.deptName = staffVw.getDeptName();
		this.tel = staffVw.getTel();
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<HouseGetApply> getHousesList() {
		return housesList;
	}

	public void setHousesList(List<HouseGetApply> housesList) {
		this.housesList = housesList;
	}
    
    
}

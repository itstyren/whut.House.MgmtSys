package com.computerdesign.whutHouseMgmt.bean.staffmanagement;

/**
 * 职工管理用于返回前端的类
 * @author Administrator
 *
 */
public class StaffModel {
	private Integer id;

    private String no;
    
    private String name;

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
    
    
}

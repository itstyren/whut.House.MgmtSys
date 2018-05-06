package com.computerdesign.whutHouseMgmt.bean.housesub;

/**
 * 货币化补贴查询参数类
 * @author Administrator
 *
 */

public class MonetarySubSelectModel {
	
	private Integer deptId;
	
	private Integer titleId;
	
	private Integer postId;
	
	private Integer typeId;
	
	private String yearStart;
	
	private String yearEnd;

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getTitleId() {
		return titleId;
	}

	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getYearStart() {
		return yearStart;
	}

	public void setYearStart(String yearStart) {
		this.yearStart = yearStart;
	}

	public String getYearEnd() {
		return yearEnd;
	}

	public void setYearEnd(String yearEnd) {
		this.yearEnd = yearEnd;
	}

	
	
}

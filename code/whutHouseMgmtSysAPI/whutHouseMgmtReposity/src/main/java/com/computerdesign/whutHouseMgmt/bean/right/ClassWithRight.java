package com.computerdesign.whutHouseMgmt.bean.right;

import java.util.List;

public class ClassWithRight {

    private Integer classId;
    
    private String  className;
    
    private List<Right> rights;

    public ClassWithRight(RightClass rightClass,List<Right> rights) {
		this.classId = rightClass.getId();
		this.className = rightClass.getName();
		this.rights = rights;
	}
    
	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<Right> getRights() {
		return rights;
	}

	public void setRights(List<Right> rights) {
		this.rights = rights;
	}
}
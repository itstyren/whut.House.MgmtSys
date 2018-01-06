package com.computerdesign.whutHouseMgmt.bean.role;

import java.util.List;

import com.computerdesign.whutHouseMgmt.bean.right.Right;

public class RoleWithRight {

    private Integer id;

    private String name;

    private String description;
    
    private List<Right> rights;

    public RoleWithRight(Role role,List<Right> rights) {
		this.id = role.getId();
		this.name = role.getName();
		this.description = role.getDescription();
		this.rights = rights;
	}
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Right> getRights() {
		return rights;
	}

	public void setRights(List<Right> rights) {
		this.rights = rights;
	}
}

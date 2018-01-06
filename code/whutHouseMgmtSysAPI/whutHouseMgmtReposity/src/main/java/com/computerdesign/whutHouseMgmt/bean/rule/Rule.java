package com.computerdesign.whutHouseMgmt.bean.rule;

public class Rule {
    private Integer id;

    private Integer rightId;

    private Integer roleId;

    public Rule() {
		
	}
    public Rule(Integer rightId,Integer roleId) {
		this.roleId = roleId;
		this.rightId = rightId;
	}
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRightId() {
        return rightId;
    }

    public void setRightId(Integer rightId) {
        this.rightId = rightId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
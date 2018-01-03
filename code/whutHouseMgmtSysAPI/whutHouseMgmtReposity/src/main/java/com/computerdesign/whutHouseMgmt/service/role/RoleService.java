package com.computerdesign.whutHouseMgmt.service.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.role.Role;
import com.computerdesign.whutHouseMgmt.dao.role.RoleMapper;

@Service
public class RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	public List<Role> get() {
		return roleMapper.selectByExample(null);
	}
}

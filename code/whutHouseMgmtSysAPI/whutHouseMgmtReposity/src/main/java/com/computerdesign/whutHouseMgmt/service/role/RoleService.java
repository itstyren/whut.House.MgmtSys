package com.computerdesign.whutHouseMgmt.service.role;

import java.util.List;import javax.ws.rs.DELETE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.role.Role;
import com.computerdesign.whutHouseMgmt.bean.role.RoleExample;
import com.computerdesign.whutHouseMgmt.bean.role.RoleExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.role.RoleMapper;

@Service
public class RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	/**
	 * 获取全部的role
	 * @return
	 */
	public List<Role> getAll() {
		return roleMapper.selectByExample(null);
	}
	
	/**
	 * 根据name获取全部的role
	 * @param name
	 * @return
	 */
	public List<Role> getRolesByName(String name) {
		RoleExample example = new RoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		return roleMapper.selectByExample(example);
	}
	
	/**
	 * 增加一个role
	 * @param role
	 */
	public void addRole(Role role){
		roleMapper.insert(role);
	}
	
	public void deleteRole(Integer id) {
		roleMapper.deleteByPrimaryKey(id);
	}
}

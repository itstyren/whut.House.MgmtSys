package com.computerdesign.whutHouseMgmt.service.authority;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.authority.Permission;
import com.computerdesign.whutHouseMgmt.bean.authority.Rule;
import com.computerdesign.whutHouseMgmt.bean.authority.RuleExample;
import com.computerdesign.whutHouseMgmt.bean.authority.RuleExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.authority.PermissionMapper;
import com.computerdesign.whutHouseMgmt.dao.authority.RuleMapper;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.StaffService;

/**
 *
 * @author wanhaoran
 * @date 2018年3月11日 下午4:18:02
 * 
 */
@Service
public class PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;

	@Autowired
	private RuleMapper ruleMapper;

	
	/**
	 * 根据roleId获取Permissions
	 * 
	 * @param roleId
	 * @return
	 */
	public List<Permission> getPermissionsByRoleId(Integer roleId) {

		RuleExample ruleExample = new RuleExample();
		Criteria criteria = ruleExample.createCriteria();
		criteria.andRoleIdEqualTo(roleId);
		// 根据roleId来获取全部的该角色对应的rule
		List<Rule> rules = ruleMapper.selectByExample(ruleExample);
		List<Permission> permissions = new ArrayList<Permission>();
		// 根据每一个rule来获取每一个Permission
		for (Rule rule : rules) {
			permissions.add(permissionMapper.selectByPrimaryKey(rule.getPermissionId()));
		}
		return permissions;
	}
}

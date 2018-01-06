package com.computerdesign.whutHouseMgmt.controller.role;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.right.Right;
import com.computerdesign.whutHouseMgmt.bean.role.Role;
import com.computerdesign.whutHouseMgmt.bean.role.RoleWithRight;
import com.computerdesign.whutHouseMgmt.bean.rule.Rule;
import com.computerdesign.whutHouseMgmt.service.right.RightService;
import com.computerdesign.whutHouseMgmt.service.role.RoleService;
import com.computerdesign.whutHouseMgmt.service.rule.RuleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping(value = "/role/")
@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;
	@Autowired
	private RuleService ruleService;
	@Autowired
	private RightService RightService;
	
	
	/**
	 * 获取全部的带有rightid的role数据
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "get",method = RequestMethod.GET)
	@ResponseBody
	public Msg get(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size){

		List<RoleWithRight> list = new ArrayList<RoleWithRight>();
		
		List<Role> roles = roleService.getAll();
		//每一个role
		for (Role role : roles) {
			//根据role获取rules
			List<Rule> rules = ruleService.getRulesByRole(role.getId());
			List<Right> rights = new ArrayList<Right>();
			//根据每一个rule获取right的id			
			for (Rule rule : rules) {
				Right right = RightService.get(rule.getRightId());
				rights.add(right);
			}
			list.add(new RoleWithRight(role, rights));			
		}
		
		PageInfo pageInfo = new PageInfo(list);
		return Msg.success().add("data", pageInfo); 
	}
	
	/**
	 * 增加一个role
	 * @param role
	 * @return
	 */
	@RequestMapping(value = "add",method = RequestMethod.POST)
	@ResponseBody
	public Msg addRoleWithRight(@RequestBody RoleWithRight roleWithRight) {

		//新增role
		Role role = new Role();
		role.setId(roleWithRight.getId());
		role.setName(roleWithRight.getName());
		role.setDescription(roleWithRight.getDescription());
		roleService.addRole(role);
		
		
		return Msg.success().add("data", roleWithRight);
	}
	
	/**
	 * 删除角色
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delete/{id}",method = RequestMethod.DELETE)
	@ResponseBody
	public Msg deleteRole(@PathVariable("id") Integer id){
		try {
			roleService.deleteRole(id);
			return Msg.success();
		} catch (Exception e) {
			// TODO: handle exception
			return Msg.error("删除失败");
		}
	}
	
	
}

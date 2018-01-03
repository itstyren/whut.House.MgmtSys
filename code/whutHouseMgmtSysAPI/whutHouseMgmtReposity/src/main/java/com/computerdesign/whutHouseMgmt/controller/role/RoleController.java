package com.computerdesign.whutHouseMgmt.controller.role;

import java.util.List;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.role.Role;
import com.computerdesign.whutHouseMgmt.service.role.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping(value = "/role/")
@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	/**
	 * 获取全部的role数据
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "get",method = RequestMethod.GET)
	@ResponseBody
	public Msg get(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size){
		
		PageHelper.startPage(page, size);
		List<Role> roles = roleService.get();
		
		PageInfo pageInfo = new PageInfo();
		return Msg.success().add("data", pageInfo);
	}
	
	@RequestMapping(value = "add",method = RequestMethod.POST)
	@ResponseBody
	public Msg get(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size){
		
		PageHelper.startPage(page, size);
		List<Role> roles = roleService.get();
		
		PageInfo pageInfo = new PageInfo();
		return Msg.success().add("data", pageInfo);
	}
}

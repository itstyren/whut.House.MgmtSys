package com.computerdesign.whutHouseMgmt.controller.role;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.role.Role;
import com.computerdesign.whutHouseMgmt.bean.role.RoleLogin;
import com.computerdesign.whutHouseMgmt.service.role.RoleService;

@RequestMapping(value = "/roleLogin/")
@Controller
public class RoleLoginController {

	@Autowired
	private RoleService roleService;
	
	/**
	 * 返回role中的id和name;既RoleLogin
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Msg get(){
		List<Role> roles = roleService.getAll();
		List<RoleLogin> roleLogins = new ArrayList<RoleLogin>();
		for (Role role : roles) {
			RoleLogin roleLogin = new RoleLogin(role.getId(),role.getName());
			roleLogins.add(roleLogin);
		}
		return Msg.success().add("data",roleLogins);
	}
}

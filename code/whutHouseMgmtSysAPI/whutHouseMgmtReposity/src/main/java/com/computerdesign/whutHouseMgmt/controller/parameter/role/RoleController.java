package com.computerdesign.whutHouseMgmt.controller.parameter.role;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.param.role.PermissionTest;

@RequestMapping("/auth/")
@Controller
public class RoleController {
	
	@RequestMapping(value="testGetAuth",method=RequestMethod.GET)
	@ResponseBody
	public Msg testGetAuth(){
		
		List<PermissionTest> roles = new ArrayList<PermissionTest>();
		PermissionTest role1 = new PermissionTest();
		List<String> roles1 = new ArrayList<String>();
		roles1.add("ADMIN");
		roles1.add("OFFICER");
		role1.setId(1);
		role1.setName("sysmanage");
		role1.setRole(roles1);
		roles.add(role1);
		
		PermissionTest role2 = new PermissionTest();
		List<String> roles2 = new ArrayList<String>();
		roles2.add("ADMIN");
		role2.setId(2);
		role2.setName("basic");
		role2.setRole(roles2);
		roles.add(role2);
		
		PermissionTest role3 = new PermissionTest();
		List<String> roles3 = new ArrayList<String>();
		roles3.add("ADMIN");
		roles3.add("OFFICER");
		roles3.add("STAFF");
		role3.setId(3);
		role3.setName("fixManage");
		role3.setRole(roles3);
		roles.add(role3);
		
		PermissionTest role4 = new PermissionTest();
		List<String> roles4 = new ArrayList<String>();
		roles4.add("ADMIN");
		roles4.add("OFFICER");
		role4.setId(4);
		role4.setName("leaseManage");
		role4.setRole(roles4);
		roles.add(role4);
		
		return Msg.success().add("roles", roles);
	}
	
}

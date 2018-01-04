package com.computerdesign.whutHouseMgmt.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.user.User;
import com.computerdesign.whutHouseMgmt.bean.user.UserLogin;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.StaffService;
import com.computerdesign.whutHouseMgmt.service.user.UserLoginService;

@RequestMapping(value = "/login/")
@Controller
public class UserLoginController {

	@Autowired
	private UserLoginService userLoginService;
	@Autowired
	private StaffService staffService;
	
	@ResponseBody
	@RequestMapping()
	public Msg login(@RequestBody UserLogin userLogin){
		Integer no = userLogin.getNo();
		String password = userLogin.getPassword();
		Integer roleId = userLogin.getRoleId();
		if(roleId == 3){
			return Msg.error();
		}else{
			if(!userLoginService.getUser(no,password).isEmpty()){
				User user  = userLoginService.getUser(no,password).get(0);
				return Msg.success("登陆成功").add("data", user);
			}else{
				return Msg.error("账号或密码不正确");
			}
		}
	}
}

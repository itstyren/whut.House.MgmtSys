package com.computerdesign.whutHouseMgmt.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.user.User;
import com.computerdesign.whutHouseMgmt.bean.user.UserLogin;
import com.computerdesign.whutHouseMgmt.bean.user.UserLoginReturn;
import com.computerdesign.whutHouseMgmt.bean.user.UserReturnToken;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.StaffService;
import com.computerdesign.whutHouseMgmt.service.user.UserLoginService;
import com.computerdesign.whutHouseMgmt.service.user.UserReturnTokenService;

@RequestMapping(value = "/login/")
@Controller
public class UserLoginController {

	@Autowired
	private UserLoginService userLoginService;
	@Autowired
	private StaffService staffService;
	@Autowired
	private UserReturnTokenService UserReturnTokenService;
	
	@RequestMapping(value = "user",method = RequestMethod.POST)
	@ResponseBody
	public Msg login(@RequestBody UserLogin userLogin){
		System.out.println("111");
		String no = userLogin.getNo();
		String password = userLogin.getPassword();
		Integer roleId = userLogin.getRoleId();
		if(roleId == 3){
			return Msg.error();
		}else{
			if(!userLoginService.getUser(no,password).isEmpty()){
				UserLoginReturn userLoginReturn = UserReturnTokenService.getByNo(no);
				UserReturnToken userReturnToken = new UserReturnToken();
				userReturnToken.setUserLoginReturn(userLoginReturn);
				userReturnToken.setTokenAccess(1111);
				return Msg.success().add("data", userReturnToken);
			}else{
				return Msg.error("账号或密码不正确");
			}
		}
	}
}

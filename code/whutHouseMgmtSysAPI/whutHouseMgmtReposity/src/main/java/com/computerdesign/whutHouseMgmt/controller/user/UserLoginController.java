package com.computerdesign.whutHouseMgmt.controller.user;

import java.util.List;

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
import com.computerdesign.whutHouseMgmt.service.login.LoginService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.StaffService;
import com.computerdesign.whutHouseMgmt.service.user.UserLoginService;
import com.computerdesign.whutHouseMgmt.service.user.UserReturnTokenService;

@RequestMapping(value = "/login/")
@Controller
public class UserLoginController {

	@Autowired
	private LoginService loginService;
	
	/**
	 * 登陆
	 * @param userLogin
	 * @return 
	 */
	@RequestMapping(value = "user",method = RequestMethod.POST)
	@ResponseBody
	public Msg login(@RequestBody UserLogin userLogin){
		String no = userLogin.getNo();
		String password = userLogin.getPassword();
		Long roleId = Long.valueOf(userLogin.getRoleId()).longValue();
		
		List<UserLoginReturn> users = loginService.getLogin(no, password, roleId);
		//判断登陆信息
		if (users.isEmpty()) {
			//如果信息不正确，返回失败
			return Msg.error("请输入正确的信息");	
		}else{
			UserLoginReturn user = users.get(0);
		
			UserReturnToken userReturnToken = new UserReturnToken();
			//锁定tokenAccess为1111
			userReturnToken.setTokenAccess(1111);
			userReturnToken.setUserLoginReturn(user);
			return Msg.success().add("data", userReturnToken);
		}
		
	}
}

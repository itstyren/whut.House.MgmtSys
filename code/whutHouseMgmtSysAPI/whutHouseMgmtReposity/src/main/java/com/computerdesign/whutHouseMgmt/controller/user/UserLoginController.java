package com.computerdesign.whutHouseMgmt.controller.user;

import java.util.Date;
import java.util.List;

import javax.naming.TimeLimitExceededException;
import javax.servlet.http.HttpServletRequest;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.token.Token;
import com.computerdesign.whutHouseMgmt.bean.user.User;
import com.computerdesign.whutHouseMgmt.bean.user.UserLogin;
import com.computerdesign.whutHouseMgmt.bean.user.UserLoginReturn;
import com.computerdesign.whutHouseMgmt.service.login.LoginService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.StaffService;
import com.computerdesign.whutHouseMgmt.service.token.TokenService;
import com.computerdesign.whutHouseMgmt.service.user.UserLoginService;
import com.computerdesign.whutHouseMgmt.service.user.UserReturnService;

@RequestMapping(value = "/userLogin/")
@Controller
public class UserLoginController {

	//分钟*秒*毫秒
	private Integer TimeLimit = 60*60*1000;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UserReturnService  userReturnService;
	
	/**
	 * 登陆
	 * @param userLogin
	 * @return 
	 */
	@RequestMapping(value = "login",method = RequestMethod.POST)
	@ResponseBody
	public Msg login(@RequestBody UserLogin userLogin,HttpServletRequest request){
		
		String no = userLogin.getNo();
		String password = userLogin.getPassword();
		Long roleId = Long.valueOf(userLogin.getRoleId()).longValue();
		
		userReturnService.getByNo(no);
		List<UserLoginReturn> users = loginService.getLogin(no, password, roleId);
		//判断登陆信息
		if (users.isEmpty()) {
			//如果信息不正确，返回失败
			return Msg.error("请输入正确的信息");	
		}else{
			
			UserLoginReturn user = users.get(0);
			if (!user.getStatus().equals("active")) {
				return Msg.error("该账号已冻结，请联系管理员解冻");
			} else {

				UserLoginReturn userLoginReturn = userReturnService.getByNo(no);

				request.getSession().setAttribute("isLogin", "yes");

				return Msg.success("登陆成功").add("data", userLoginReturn);
			}
		}
		
	}
	
	@RequestMapping(value = "logout",method = RequestMethod.GET)
	@ResponseBody
	public Msg logout(HttpServletRequest request){
		request.getSession().removeAttribute("isLogin");
		return Msg.success("退出登陆");
	}
}

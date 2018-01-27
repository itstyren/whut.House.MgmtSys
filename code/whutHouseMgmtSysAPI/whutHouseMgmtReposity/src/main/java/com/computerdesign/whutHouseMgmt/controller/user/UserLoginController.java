package com.computerdesign.whutHouseMgmt.controller.user;

import java.util.Date;
import java.util.List;

import javax.naming.TimeLimitExceededException;

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

@RequestMapping(value = "/login/")
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
	@RequestMapping(value = "user",method = RequestMethod.POST)
	@ResponseBody
	public Msg login(@RequestBody UserLogin userLogin){
		
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
			String token = "111";
			UserLoginReturn userLoginReturn = userReturnService.getByNo(no);

			
			return Msg.success().add("data", userLoginReturn);

		}
		
//		//判断是否有令牌,判断时效是否已过
//		if(tokenAccess!=null && tokenAccess.length()>0 && lastLoginTime!= null && (new Date().getTime()-lastLoginTime.getTime()<TimeLimit)){
//			//有正确令牌，可直接进入
//			if (!loginService.getNoAndToken(no, tokenAccess).isEmpty()) {
//				Token token =new Token();
//				token.setNo(no);
//				//更新上次登陆时间
//				token.setLastLoginTime(new Date());
//				tokenService.update(token);
//				UserLoginReturn userLoginReturn = userReturnService.getByNo(no);
//				return Msg.success("令牌登陆成功").add("data", userLoginReturn);
//			//有令牌，但是令牌和账号不匹配
//			}else{
//				Token token =new Token();
//				token.setNo(no);
//				token.setToken("");
//				tokenService.update(token);
//				return Msg.error("系统超时，请重新登陆");
//			}
//		}
//		
//		//无令牌，确认账号密码等信息
//		List<UserLoginReturn> users = loginService.getLogin(no, password, roleId);
//		//判断登陆信息
//		if (users.isEmpty()) {
//			//如果信息不正确，返回失败
//			return Msg.error("请输入正确的信息");	
//		}else{
//			
//			UserLoginReturn user = users.get(0);
//			if(!tokenService.get(user.getNo()).isEmpty()){
//				Token token =new Token();
//				token.setNo(user.getNo());
//				token.setToken("111");
//				token.setLastLoginTime(new Date());
//				tokenService.update(token);
//			} else {
//				Token token = new Token();
//				token.setNo(user.getNo());
//				token.setToken("111");
//				token.setLastLoginTime(new Date());
//				tokenService.add(token);
//			}
//			UserLoginReturn userLoginReturn = userReturnService.getByNo(no);
//
//			return Msg.success().add("data", userLoginReturn);
//
//		}
		
	}
}

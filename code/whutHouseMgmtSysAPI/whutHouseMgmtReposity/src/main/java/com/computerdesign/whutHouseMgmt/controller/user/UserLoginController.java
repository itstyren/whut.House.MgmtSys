package com.computerdesign.whutHouseMgmt.controller.user;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.naming.TimeLimitExceededException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
import com.computerdesign.whutHouseMgmt.utils.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat.Value;

import io.jsonwebtoken.Claims;

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
	 * 按照账户密码登陆登陆
	 * @param userLogin
	 * @return 
	 */
	@RequestMapping(value = "login",method = RequestMethod.POST)
	@ResponseBody
	public Msg login(@RequestBody UserLogin userLogin,HttpServletRequest request,HttpServletResponse response){
		
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

//				UserLoginReturn userLoginReturn = userReturnService.getByNo(no);
//
//				request.getSession().setAttribute("isLogin", "yes");
//				response.addHeader("X-token", "222222");
//				return Msg.success("登陆成功").add("data", userLoginReturn);
				Date d = DateUtil.getAppointHour(new Date(), 3);
				String date = DateUtil.formatDate(d);
				String token = no+"_"+password+"_"+roleId+"_"+date;
//				String tokenD = SubjectUtil.getInstance().createToken(no, DateUtil.getAppointDate(new Date(), 1));
	            try {
	            	byte[] sourceBs = token.getBytes("UTF-8");  
		            byte[] targetBs = Base64.encodeBase64(sourceBs); 
					token = new String(targetBs,"UTF-8");
				} catch (UnsupportedEncodingException e) {
				    throw new RuntimeException(e); 
				} 
				
				return Msg.success().add("token", token);
			}
		}
	}
	
	/**
	 * 登陆后获取用户信息
	 * @param token
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "tokenLogin",method = RequestMethod.GET)
	@ResponseBody
	public Msg tokenLogin(@RequestParam(value = "token")String token,HttpServletRequest request,HttpServletResponse response){		
		
		System.out.println(token);
		//将token解码
		byte[] targetBs;
		try {
			targetBs = token.getBytes("UTF-8");
			byte[] sourceBs = Base64.decodeBase64(targetBs);  
	        token = new String(sourceBs,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			 throw new RuntimeException(e); 
		}
		//根据解码后的token获取账户、密码和roleId
		String[] strArr = token.split("_");
		try {
			String no = strArr[0];
			String password = strArr[1];
			Long roleId =  Long.valueOf(strArr[2]).longValue();
			
			List<UserLoginReturn> users = loginService.getLogin(no, password, roleId);
			if (users.isEmpty()) {
				return Msg.error("该令牌已失效，请退出后重新登陆");
			}
			UserLoginReturn userLoginReturn = users.get(0);
			return Msg.success().add("data", userLoginReturn);
			
		} catch (Exception e) {
			return Msg.error("该令牌已失效，请退出后重新登陆");
		}
		
	}
	
	@RequestMapping(value = "logout",method = RequestMethod.GET)
	@ResponseBody
	public Msg logout(HttpServletRequest request){
		String token = (String) request.getHeader("X-token");
		return Msg.success("退出登陆");
	}
}

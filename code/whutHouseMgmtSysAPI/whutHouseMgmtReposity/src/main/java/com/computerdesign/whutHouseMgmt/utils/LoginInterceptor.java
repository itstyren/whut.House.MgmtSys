package com.computerdesign.whutHouseMgmt.utils;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.user.UserLoginReturn;
import com.computerdesign.whutHouseMgmt.service.login.LoginService;

public class LoginInterceptor implements HandlerInterceptor {

	@Autowired
	private LoginService loginService;

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception err)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mav)
			throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		// // 获取session里的登录状态值
		// String str = (String) request.getSession().getAttribute("isLogin");
		//
		// // 如果登录状态不为空则返回true，返回true则会执行相应controller的方法
		// if (str != null) {
		// System.out.println(str);
		// return true;
		// }
		// response.setStatus(401);
		//// 如果登录状态为空则重定向到登录页面，并返回false，不执行原来controller的方法
		//// System.out.println("errrrr");
		//// response.sendRedirect("/whutHouseMgmtReposity/userLogin/login");
		// return false;
		// String str = (String) request.getHeader("X-token");
		// if (str != null) {
		// System.out.println(998);
		// return true;
		// }
		// response.setStatus(401);
		//// 如果登录状态为空则重定向到登录页面，并返回false，不执行原来controller的方法
		//// System.out.println("errrrr");
		//// response.sendRedirect("/whutHouseMgmtReposity/userLogin/login");
		// return false;

		// 从header中获取"X-toke"
		String token = (String) request.getHeader("X-token");
		System.out.println(token);
		// TODO 测试
		// 将token解码为可读取信息
		byte[] targetBs;
		try {
			targetBs = token.getBytes("UTF-8");
			byte[] sourceBs = Base64.decodeBase64(targetBs);
			token = new String(sourceBs, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		// 根据解码后的token获取账户、密码和roleId
		String[] strArr = token.split("_");

		try {
			//错误的token可能会导致无法求出以下三个参数
			String no = strArr[0];
			String password = strArr[1];
			Long roleId = Long.valueOf(strArr[2]).longValue();
			System.out.println(no+"   "+password+"   "+roleId);
			List<UserLoginReturn> users = loginService.getLogin(no, password, roleId);
			if (users.isEmpty()) {
				response.setStatus(401);
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			response.setStatus(401);
			return false;
		}

	}
}

package com.computerdesign.whutHouseMgmt.utils;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.ViewStaff;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.ViewStaffService;

import io.jsonwebtoken.ExpiredJwtException;

public class LoginInterceptor implements HandlerInterceptor {


	@Autowired
	private ViewStaffService viewStaffService;

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

		// 从header中获取"X-toke"
		String token = request.getHeader("X-token");
		if (token == null) {
			token = request.getParameter("X-token");
		}
		// TODO 测试
		System.out.println(token);
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
			// 错误的token可能会导致无法求出以下三个参数
			String no = strArr[0];
			String password = strArr[1];
			int roleId = Integer.parseInt(strArr[2]);
			Date date = DateUtil.parseDate(strArr[3]);
			Long pastHour = DateUtil.pastHour(date);
			// if (pastHour <=2) {
			// response.setStatus(401);
			// return false;
			// }

			List<ViewStaff> viewStaffs = viewStaffService.getByStaffNo(no);
			// 判断登陆信息
			if (viewStaffs.isEmpty()) {
				response.setStatus(401);
				return false;
			}
			ViewStaff viewStaff = viewStaffs.get(0);
			if (viewStaff.getAccountStatus()) {
				response.setStatus(401);
				return false;
			}
			if (!viewStaff.getStaffPassword().equals(password) || viewStaff.getRoleId() != roleId) {
				response.setStatus(401);
				return false;
			}

			System.out.println(no + "   " + password + "   " + roleId + "   " + date + "  " + pastHour);
			return true;
		} catch (Exception e) {
			response.setStatus(401);
			return false;
		}

	}
}

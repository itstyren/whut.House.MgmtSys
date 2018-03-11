package com.computerdesign.whutHouseMgmt.controller.user;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.ViewStaff;
import com.computerdesign.whutHouseMgmt.bean.user.UserLogin;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.ViewStaffService;
import com.computerdesign.whutHouseMgmt.utils.DateUtil;

@RequestMapping(value = "/userLogin/")
@Controller
public class UserLoginController {



	@Autowired
	private ViewStaffService viewStaffService;

	/**
	 * 按照账户密码登陆登陆
	 * 
	 * @param userLogin
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public Msg login(@RequestBody UserLogin userLogin, HttpServletRequest request, HttpServletResponse response) {

		String no = userLogin.getNo();
		String password = userLogin.getPassword();
		int roleId = userLogin.getRoleId();

		List<ViewStaff> viewStaffs = viewStaffService.getByStaffNo(no);
		// 判断登陆信息
		if (viewStaffs.isEmpty()) {
			return Msg.error("账号不存在");
		}
		ViewStaff viewStaff = viewStaffs.get(0);
		if (viewStaff.getAccountStatus()) {
			return Msg.error("该账号已冻结，请联系管理员解冻");
		}
		if (!viewStaff.getStaffPassword().equals(password) || viewStaff.getRoleId() != roleId) {
			return Msg.error("信息有误");
		}
		Date d = DateUtil.getAppointHour(new Date(), 3);
		String date = DateUtil.formatDate(d);
		String token = no + "_" + password + "_" + roleId + "_" + date;
		try {
			byte[] sourceBs = token.getBytes("UTF-8");
			byte[] targetBs = Base64.encodeBase64(sourceBs);
			token = new String(targetBs, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}

		return Msg.success().add("token", token);
		// UserLoginReturn userLoginReturn = userReturnService.getByNo(no);
		//
		// request.getSession().setAttribute("isLogin", "yes");
		// response.addHeader("X-token", "222222");
		//
		// String tokenD = SubjectUtil.getInstance().createToken(no,
		// DateUtil.getAppointDate(new Date(), 1));

	}

	/**
	 * 登陆后获取用户信息
	 * 
	 * @param token
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "tokenLogin", method = RequestMethod.GET)
	@ResponseBody
	public Msg tokenLogin(@RequestParam(value = "token") String token, HttpServletRequest request,
			HttpServletResponse response) {

		System.out.println(token);
		// 将token解码
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
				return Msg.error("该令牌已失效");
			}
			ViewStaff viewStaff = viewStaffs.get(0);
			if (viewStaff.getAccountStatus()) {
				response.setStatus(401);
				return Msg.error("该令牌已失效");
			}
			if (!viewStaff.getStaffPassword().equals(password) || viewStaff.getRoleId() != roleId) {
				response.setStatus(401);
				return Msg.error("该令牌已失效");
			}

			System.out.println(no + "   " + password + "   " + roleId + "   " + date + "  " + pastHour);
			return Msg.success().add("data", viewStaff);
		} catch (Exception e) {
			response.setStatus(401);
			return Msg.error("该令牌已失效");
		}

	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	@ResponseBody
	public Msg logout(HttpServletRequest request) {
		String token = (String) request.getHeader("X-token");
		return Msg.success("退出登陆");
	}
}

package com.computerdesign.whutHouseMgmt.controller.user;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.computerdesign.whutHouseMgmt.controller.BaseController;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.ViewStaffService;
import com.computerdesign.whutHouseMgmt.utils.DateUtil;
import com.wf.etp.authz.SubjectUtil;
import com.wf.etp.authz.exception.ErrorTokenException;
import com.wf.etp.authz.exception.ExpiredTokenException;

import io.jsonwebtoken.ExpiredJwtException;

@RequestMapping(value = "/userLogin/")
@Controller
public class UserLoginController extends BaseController{



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

		String userId = viewStaff.getId().toString();
		String token = SubjectUtil.getInstance().createToken(userId, DateUtil.getAppointHour(new Date(), 1));
		return Msg.success().add("token", token);

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
		String userId = null;

		System.out.println(token);
		try { // 解析token
			userId = SubjectUtil.getInstance().parseToken(token).getSubject();
		} catch (ExpiredJwtException e) {
			SubjectUtil.getInstance().expireToken(userId, token); // 从缓存中移除过期的token
			throw new ExpiredTokenException();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorTokenException();
		}
		// 校验服务器是否存在token
		if (!SubjectUtil.getInstance().isValidToken(userId, token)) {
			throw new ExpiredTokenException();
		}
		
		request.setAttribute("userId", userId);
		Integer staffId = Integer.parseInt(userId);
		viewStaffService.getByStaffId(staffId);
		return Msg.success().add("data", viewStaffService.getByStaffId(staffId));

	}

	/**
	 * 退出登陆
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	@ResponseBody
	public Msg logout(HttpServletRequest request) {
		System.out.println(getUserId(request));
		String token = getToken(request);
		String userId = null;
		try { // 解析token
			userId = SubjectUtil.getInstance().parseToken(token).getSubject();
		} catch (ExpiredJwtException e) {
			SubjectUtil.getInstance().expireToken(userId, token); // 从缓存中移除过期的token
			throw new ExpiredTokenException();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorTokenException();
		}
		SubjectUtil.getInstance().expireToken(userId, token);
		return Msg.success("退出登陆");
	}
}

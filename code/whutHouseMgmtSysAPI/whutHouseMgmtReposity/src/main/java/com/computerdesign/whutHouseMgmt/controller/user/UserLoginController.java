package com.computerdesign.whutHouseMgmt.controller.user;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.InvalidAlgorithmParameterException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.authority.AuthList;
import com.computerdesign.whutHouseMgmt.bean.login.LoginRecord;
import com.computerdesign.whutHouseMgmt.bean.login.WXLogin;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.Staff;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffVw;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.ViewStaff;
import com.computerdesign.whutHouseMgmt.bean.user.LoginByUnionId;
import com.computerdesign.whutHouseMgmt.bean.user.UserLogin;
import com.computerdesign.whutHouseMgmt.bean.user.WXUserInfo;
import com.computerdesign.whutHouseMgmt.controller.BaseController;
import com.computerdesign.whutHouseMgmt.service.authority.AuthListService;
import com.computerdesign.whutHouseMgmt.service.login.LoginRecordService;
import com.computerdesign.whutHouseMgmt.service.login.WXService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.StaffService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.ViewStaffService;
import com.computerdesign.whutHouseMgmt.utils.AES;
import com.computerdesign.whutHouseMgmt.utils.DateUtil;
import com.computerdesign.whutHouseMgmt.utils.JSONUtil;
import com.computerdesign.whutHouseMgmt.utils.UserAgentGetter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wf.etp.authz.SubjectUtil;
import com.wf.etp.authz.exception.ErrorTokenException;
import com.wf.etp.authz.exception.ExpiredTokenException;

import io.jsonwebtoken.ExpiredJwtException;
import io.swagger.annotations.ApiOperation;

@RequestMapping(value = "/userLogin/")
@Controller
public class UserLoginController extends BaseController {


	@Autowired
	private LoginRecordService loginRecordService;

	@Autowired
	private ViewStaffService viewStaffService;

	@Autowired
	private StaffService staffService;

	@Autowired
	private WXService wxService;
	
	@Autowired
	private AuthListService authListService;

	@PostMapping(value="decodeUserInfo")
	@ApiOperation(value="解密用户信息",notes="获取用户openId和unionId数据(如果没绑定微信开放平台，解密数据中不包含unionId)")
	@ResponseBody
	public Msg decodeUserInfo(@RequestBody WXUserInfo wxUserInfo){

		String encryptedData = wxUserInfo.getEncryptedData();
		String sessionKey = wxUserInfo.getSessionKey();
		String iv = wxUserInfo.getIv();
		try {
	        AES aes = new AES();
	        byte[] resultByte = aes.decrypt(Base64.decodeBase64(encryptedData), Base64.decodeBase64(sessionKey), Base64.decodeBase64(iv));
	        if(null != resultByte && resultByte.length > 0){
	            String userInfo = new String(resultByte, "UTF-8");
	            return Msg.success().add("data",JSONUtil.parseObject(userInfo, Map.class)).add("origin", userInfo);
	            
//	            return rtnParam(0, userInfo);
	        }
	    } catch (InvalidAlgorithmParameterException e) {
	        e.printStackTrace();
	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	    }
//	    return rtnParam(50021, null);
	    return Msg.error();
	}
	
	@GetMapping(value = "code")
	@ResponseBody
	public Msg getCode(@RequestParam("code") String code) {
		// 隐私数据存放数据库
		WXLogin wxLogin = wxService.get();
		String urlString = getUrl(wxLogin.getAppid(), wxLogin.getSecret(), code, wxLogin.getGrant_type());
	
		String result = "";
		BufferedReader in = null;
		InputStream is = null;
		InputStreamReader isr = null;
		try {
			URL realUrl = new URL(urlString);
			URLConnection conn = realUrl.openConnection();
			conn.connect();
			is = conn.getInputStream();
			isr = new InputStreamReader(is);
			in = new BufferedReader(isr);
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			Map<String, String> map = new HashMap<String, String>();
			ObjectMapper mapper = new ObjectMapper();

			map = mapper.readValue(result, new TypeReference<HashMap<String, String>>() {
			});
			return Msg.success().add("data", map);

		} catch (Exception e) {
			// 异常记录
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (is != null) {
					is.close();
				}
				if (isr != null) {
					isr.close();
				}
			} catch (Exception e2) {
				// 异常记录
			}
		}
		return Msg.error("系统错误");
	}

	private String getUrl(String appid, String secret, String js_code, String grant_type) {
		return "https://api.weixin.qq.com/sns/jscode2session?"
				+ "appid=" + appid 
				+ "&secret=" + secret 
				+ "&js_code=" + js_code 
				+ "&grant_type=" + grant_type;
	}

	/**
	 * 微信使用unionId登陆
	 * 
	 * @param unionId
	 * @return
	 */
	@PostMapping(value = "loginByUnionId")
	@ResponseBody
	public Msg loginByUnionId(@RequestBody LoginByUnionId loginByUnionId) {
		ViewStaff viewStaff = viewStaffService.getByUnionId(loginByUnionId.getUnionId());
		if (viewStaff == null) {
			return Msg.error();
		}
		String userId = viewStaff.getId().toString();
		String token = SubjectUtil.getInstance().createToken(userId, DateUtil.getAppointHour(new Date(), 10));
		return Msg.success().add("token", token);
	}

	/**
	 * 微信：按照账户密码登陆登陆
	 * 
	 * @param userLogin
	 * @return
	 */
	@RequestMapping(value = "loginWX", method = RequestMethod.POST)
	@ResponseBody
	public Msg loginByWX(@RequestBody HashMap<String, Object> hashMap) {

		String no = (String) hashMap.get("no");
		String password = (String) hashMap.get("password");
		int roleId = (Integer) hashMap.get("roleId");
		String unionId = (String) hashMap.get("unionId");

		List<ViewStaff> viewStaffs = viewStaffService.getByStaffNo(no);
		// 判断登陆信息
		if (viewStaffs.isEmpty()) {
			return Msg.error("账号不存在");
		}
		ViewStaff viewStaff = viewStaffs.get(0);
		if (viewStaff.getAccountStatus()) {
			return Msg.error("该账号已冻结，请联系管理员解冻");
		}
		if (!password.equals(viewStaff.getStaffPassword()) || viewStaff.getRoleId() != roleId) {
			return Msg.error("信息有误");
		}
		// 将unionId存入数据库
		Staff staff = staffService.get(viewStaff.getId());
		staff.setUnionId(unionId);
		staffService.update(staff);

		String userId = viewStaff.getId().toString();
		String token = SubjectUtil.getInstance().createToken(userId, DateUtil.getAppointHour(new Date(), 10));
		return Msg.success().add("token", token);

	}

	/**
	 * 按照账户密码登陆登陆
	 * 
	 * @param userLogin
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public Msg login(@RequestBody UserLogin userLogin, HttpServletRequest request, HttpSession session, HttpServletResponse response) {

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
		if (!password.equals(viewStaff.getStaffPassword()) || viewStaff.getRoleId() != roleId) {
			return Msg.error("信息有误");
		}

		String userId = viewStaff.getId().toString();
		String token = SubjectUtil.getInstance().createToken(userId, DateUtil.getAppointHour(new Date(), 10));

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

		String userId = null;
		try { // 解析token
			userId = SubjectUtil.getInstance().parseToken(token).getSubject();
//			AttributePrincipal principal = (AttributePrincipal)request.getUserPrincipal();
//			userId = principal.getName();
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
		List<ViewStaff> staffVw = viewStaffService.getByStaffId(staffId);
		LoginRecord loginRecord = loginRecordService.getStaffLoginRecord(staffId);
		
//		返回用户组权限
		int roleId = staffVw.get(0).getRoleId();
		AuthList authlist = authListService.getOneAuth(roleId);
		
		// 要返回登陆数据
		addLoginRecord(request, userId);
		return Msg.success().add("data", viewStaffService.getByStaffId(staffId)).add("logindata", loginRecord).add("userRouters", authlist.getUserRouters()).add("property", authlist.getProperty());

	}

	/**
	 * 退出登陆
	 * 
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

	/**
	 * 添加登录日志
	 */
	private void addLoginRecord(HttpServletRequest request, String userId) {
		UserAgentGetter agentGetter = new UserAgentGetter(request);
		// 添加到登录日志
		Integer staffId = Integer.parseInt(userId);
		LoginRecord loginRecord = new LoginRecord();
		loginRecord.setStaffId(staffId);
		loginRecord.setIp(agentGetter.getIpAddr());
		loginRecord.setDevice(agentGetter.getDevice());
		loginRecord.setBrowser(agentGetter.getBrowser());
		loginRecord.setOsName(agentGetter.getOS());
		loginRecord.setLoginTime(new Date());
		loginRecordService.addLoginRecord(loginRecord);
	}
}
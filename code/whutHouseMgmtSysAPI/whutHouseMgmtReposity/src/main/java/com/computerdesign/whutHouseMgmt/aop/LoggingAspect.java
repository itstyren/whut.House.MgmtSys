package com.computerdesign.whutHouseMgmt.aop;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.log.SysLog;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffVw;
import com.computerdesign.whutHouseMgmt.service.log.SysLogService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.StaffVwService;
import com.wf.etp.authz.SubjectUtil;
import com.wf.etp.authz.exception.ErrorTokenException;
import com.wf.etp.authz.exception.ExpiredTokenException;

import io.jsonwebtoken.ExpiredJwtException;

@Aspect
@Component
public class LoggingAspect {
	
	@Autowired
	private StaffVwService staffVwService;
	
	@Autowired
	private SysLogService sysLogService;

//	@Before("execution(* com.computerdesign.whutHouseMgmt.controller..*.*(..))")
//	public void before(JoinPoint joinPoint){
//		System.out.println("------------Before------------");
//		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//		HttpServletRequest request = requestAttributes.getRequest();
//		System.out.println("请求URL：" + request.getRequestURL());
//		System.out.println("请求方法：" + request.getMethod());
//		System.out.println("aaa");
//	}
	
	@After("execution(* com.computerdesign.whutHouseMgmt.controller..*.*(..))")
	public void after(JoinPoint joinPoint){
		System.out.println("------------After------------");
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		
		//增删改日志记录
		SysLog sysLog = new SysLog();
		
//		获取操作人
//		System.out.println("请求URL：" + request.getRequestURL());
//		System.out.println("请求方法：" + request.getMethod());
////		System.out.println("bbb");
//		System.out.println("afterSession:" + request.getSession().getAttribute("userId"));
//		System.out.println("afterRequest:" + request.getAttribute("userId"));
		String methodName = joinPoint.getSignature().getName();
		System.out.println("方法名：" + methodName);
		
		if(request.getAttribute("userId") != null && !request.getMethod().equals("GET") && !methodName.startsWith("get") && !methodName.startsWith("select")){			
			Integer staffId = Integer.valueOf((String) request.getAttribute("userId"));
			StaffVw staffVw = staffVwService.getByID(staffId);
			System.out.println(staffVw.getName());
			sysLog.setStaffId(staffId);
			
			sysLog.setRole(staffVw.getGroupName());
			
			sysLog.setOperateTime(new Date());
			
			sysLog.setOperateUrl(request.getRequestURL().toString());
			
			if(request.getMethod().equals("POST")){				
				sysLog.setOperateType(0);
			}else if(request.getMethod().equals("DELETE")){
				sysLog.setOperateType(1);
			}else if(request.getMethod().equals("PUT")){
				sysLog.setOperateType(2);
			}
			
			sysLogService.insert(sysLog);
		}
	}
	
	//切点为登录接口，用于获取token，方便每个方法获取操作对象
	@AfterReturning(value="execution(* com.computerdesign.whutHouseMgmt.controller.user.UserLoginController.login(..))",
			returning="result")
	public void getToken(Object result){
		Msg msg = (Msg) result;
		String userId = null;
		String token = (String) msg.getData().get("token");
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
		System.out.println(userId);
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		request.setAttribute("userId", userId);
//		HttpSession session = request.getSession();
//		session.setAttribute("userId", userId);
		
		//登录日志记录
		SysLog sysLog = new SysLog();
		Integer staffId = Integer.valueOf((String) request.getAttribute("userId"));
		StaffVw staffVw = staffVwService.getByID(staffId);
		sysLog.setStaffId(staffId);
		
		sysLog.setRole(staffVw.getGroupName());
		
		sysLog.setOperateTime(new Date());
		
		sysLog.setOperateUrl(request.getRequestURL().toString());
		
		sysLog.setOperateType(3);
		
		sysLogService.insert(sysLog);
	}
	
//	@Before("execution(* com.computerdesign.whutHouseMgmt.controller.HelloWorld.hello())")
//	public void test(){
//		System.out.println("test");
//	}
}

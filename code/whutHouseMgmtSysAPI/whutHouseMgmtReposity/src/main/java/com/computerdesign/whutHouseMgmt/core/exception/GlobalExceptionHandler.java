package com.computerdesign.whutHouseMgmt.core.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.wf.etp.authz.exception.ErrorTokenException;
import com.wf.etp.authz.exception.ExpiredTokenException;
import com.wf.etp.authz.exception.UnauthorizedException;

/**
 *
 * @author wanhaoran
 * @date 2018年3月13日 上午9:55:11
 * 
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ExpiredTokenException.class)
	public Msg handleExpiredTokenException(HttpServletResponse response,ExpiredTokenException expiredTokenException){
		response.setStatus(401);
		return Msg.error("登陆已过期");
	}
	
	@ExceptionHandler(ErrorTokenException.class)
	public Msg handleErrorTokenException(HttpServletResponse response,ErrorTokenException errorTokenException){
		response.setStatus(401);
		return Msg.error("身份验证失败");
	}
	
	@ExceptionHandler(UnauthorizedException.class)
	public Msg handleUnauthorizedException(HttpServletResponse response,UnauthorizedException unauthorizedException){
		response.setStatus(403);
		return Msg.error("没有访问权限");
	}
}

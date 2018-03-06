package com.computerdesign.whutHouseMgmt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class ResponseHeaderFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletResponse httpServletResponse = (HttpServletResponse) arg1;
//		httpServletResponse.setHeader("Access-Control-Allow-Headers", "X-Token");
		httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
//		httpServletResponse.setHeader("Access-Control-Allow-Headers", "X-CSRF-Token");
		httpServletResponse.setHeader("Access-Control-Allow-Headers", "X-CSRF-Token, Origin, X-Requested-With, Content-Type, Accept");
		httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE");
		arg2.doFilter(arg0, httpServletResponse);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}


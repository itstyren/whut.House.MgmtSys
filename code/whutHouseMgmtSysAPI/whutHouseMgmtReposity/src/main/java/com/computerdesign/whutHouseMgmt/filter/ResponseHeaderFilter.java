package com.computerdesign.whutHouseMgmt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;

public class ResponseHeaderFilter implements Filter {

	public static final String ACCESS_CONTROL_REQUEST_METHOD = "Access-Control-Request-Method";

	public static final String OPTIONS = "OPTIONS";

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		// httpServletResponse.setHeader("Access-Control-Allow-Headers", "X-Token");
		// httpServletResponse.setHeader("Access-Control-Allow-Headers", "X-CSRF-Token");
//		httpServletResponse.setHeader("Access-Control-Allow-Headers", "X-Token,Content-Type");
		httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
		httpServletResponse.setHeader("Access-Control-Allow-Headers",
				"X-Token, Origin, Content-Type, Accept");
		httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
		if (isPreFlightRequest(httpServletRequest)) {
			return;
		}
		chain.doFilter(request, httpServletResponse);
	}

	public boolean isCorsRequest(HttpServletRequest request) {
		return (request.getHeader(HttpHeaders.ORIGIN) != null);
	}

	public boolean isPreFlightRequest(HttpServletRequest request) {
		return (isCorsRequest(request) && OPTIONS.equals(request.getMethod())
				&& request.getHeader(ACCESS_CONTROL_REQUEST_METHOD) != null);
	}

	@Override
	public void init(FilterConfig request) throws ServletException {
		// TODO Auto-generated method stub

	}

}

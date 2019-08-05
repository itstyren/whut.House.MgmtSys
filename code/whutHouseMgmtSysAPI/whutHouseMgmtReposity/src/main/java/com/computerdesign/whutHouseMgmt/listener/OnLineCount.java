package com.computerdesign.whutHouseMgmt.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class OnLineCount implements HttpSessionListener{

	public int count = 0;
	
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		count ++;
		arg0.getSession().getServletContext().setAttribute("count", count);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		count --;
		arg0.getSession().getServletContext().setAttribute("count", count);
	}
	
}

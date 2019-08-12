package com.computerdesign.whutHouseMgmt.controller.querystatistics;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.computerdesign.whutHouseMgmt.bean.Msg;

@RequestMapping("/online")
@Controller
public class OnLineController {

	@RequestMapping(value = "onLineCount", method = RequestMethod.GET)
	@ResponseBody
	public Msg onLineCount(HttpSession session){
//		Object count = session.getServletContext().getAttribute("count");
		
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
//		放在request中本地和服务器均访问不到
//		Object count = request.getAttribute("count2");
//		像这样直接放在Session中获取在本地测试的时候可以访问到，但是放在服务器上则访问不到
//		Object coun2 = request.getSession().getAttribute("count2");
		Object count = request.getSession().getServletContext().getAttribute("countValue");
		
//		System.out.println("onLineCount:" + count2);
		
		return Msg.success().add("data", count);
	}
	
}

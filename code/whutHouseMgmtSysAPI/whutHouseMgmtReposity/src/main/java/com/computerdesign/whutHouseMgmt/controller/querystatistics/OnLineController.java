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
		Object count = session.getServletContext().getAttribute("count");
		return Msg.success().add("data", count);
	}
	
}

package com.computerdesign.whutHouseMgmt.controller.fix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.fix.Fix;
import com.computerdesign.whutHouseMgmt.service.fix.FixService;

@RequestMapping(value = "/fix/")
@Controller
public class FixController {

	@Autowired
	private FixService fixService;
	
//	@RequestMapping(value = "add",method = RequestMethod.POST)
//	@ResponseBody
//	public Msg addFix(@RequestBody Fix fix){
//		
//	}
}

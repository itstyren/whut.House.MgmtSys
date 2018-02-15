package com.computerdesign.whutHouseMgmt.controller.hire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.service.hire.HireService;

@RequestMapping(value = "/hire/")
@Controller
public class HireController {

	@Autowired
	private HireService hireService;
	
//	@RequestMapping(value = "getApply/{staffId}",method = RequestMethod.GET)
//	@ResponseBody
//	public Msg getHireApply(@PathVariable("staffId")Integer staffId){
//		
//	}
}

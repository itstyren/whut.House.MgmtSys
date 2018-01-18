package com.computerdesign.whutHouseMgmt.controller.fix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.fix.Fix;
import com.computerdesign.whutHouseMgmt.bean.fix.FixGetApply;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffVw;
import com.computerdesign.whutHouseMgmt.service.fix.FixService;
import com.computerdesign.whutHouseMgmt.service.house.ViewHouseService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.StaffVwService;

@RequestMapping(value = "/fix/")
@Controller
public class FixController {

	@Autowired
	private FixService fixService;
	
	@Autowired
	private StaffVwService staffVwService;
	
	@Autowired
	private ViewHouseService  viewHouseService;
	
//	@RequestMapping(value = "add",method = RequestMethod.POST)
//	@ResponseBody
//	public Msg addFix(@RequestBody Fix fix){
//		
//	}
	
	
	@RequestMapping(value = "getApply/{staffId}" , method = RequestMethod.GET)
	@ResponseBody
	public Msg getFixApply(@PathVariable("staffId")Integer staffId){
		StaffVw staffVw = staffVwService.getByID(staffId);
		FixGetApply fixGetApply = new FixGetApply(staffVw);
		
	}
}

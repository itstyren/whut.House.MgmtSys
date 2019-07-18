package com.computerdesign.whutHouseMgmt.controller.cleardata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.service.cleardata.ClearDataService;

@RequestMapping("/cleardata/")
@Controller
public class ClearDataController {
	
	@Autowired
	private ClearDataService clearDataService;
	
	@ResponseBody
	@RequestMapping(value = "clearResidentData", method = RequestMethod.DELETE)
	public Msg clearResidentData(){
		clearDataService.clearResidentData();
		return Msg.success();
	}
	
	@ResponseBody
	@RequestMapping(value = "clearStaffData", method = RequestMethod.DELETE)
	public Msg clearStaffData(){
		clearDataService.clearStaffData();
		return Msg.success();
	}
	
	@ResponseBody
	@RequestMapping(value = "clearHouseData", method = RequestMethod.DELETE)
	public Msg clearHouseData(){
		clearDataService.clearHouseData();
		return Msg.success();
	}
	
}

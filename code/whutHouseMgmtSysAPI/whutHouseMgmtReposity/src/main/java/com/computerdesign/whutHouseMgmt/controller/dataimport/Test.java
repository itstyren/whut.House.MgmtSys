package com.computerdesign.whutHouseMgmt.controller.dataimport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.service.dataimport.DataImportService;

@Controller
public class Test {

	@Autowired
	private DataImportService dataImportService;
	
	@ResponseBody
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Msg get(){
		Integer id = dataImportService.getHouseParamId("未知", 3);
		System.out.println(id);
		return Msg.success();
	}
	
}

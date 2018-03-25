package com.computerdesign.whutHouseMgmt.controller.house;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.service.house.HouseService;
import com.computerdesign.whutHouseMgmt.service.houseparam.HouseParamService;

import io.swagger.annotations.Api;

/**
 *
 * @author wanhaoran
 * @date 2018年3月25日 上午8:49:01
 * 
 */
@RestController
@RequestMapping(value="/houseRecord/")
@Api(value = "房屋记录Controller",description ="房屋记录接口")
public class HouseRecordController {

	@Autowired
	private HouseParamService houseParamService;
	
	@Autowired
	private HouseService houseService;
	
	@GetMapping(value="Content")
	public Msg getHouseRecordContent(@RequestParam("paramTypeId")Integer paramTypeId){
		
	}
}

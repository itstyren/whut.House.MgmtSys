package com.computerdesign.whutHouseMgmt.controller.parameter.systemparam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.param.systemParam.SystemParameter;
import com.computerdesign.whutHouseMgmt.service.systemparam.SystemParamService;

import io.swagger.annotations.ApiOperation;

/**
 *
 * @author wanhaoran
 * @date 2018年4月5日 下午5:40:19
 * 
 */
@RestController
@RequestMapping(value = "/systemParam/")
public class SystemParameterController {

	@Autowired
	private SystemParamService systemParamService;
	
	@GetMapping(value = "get")
	public Msg getSystemParameter(@RequestParam("sysParamId")Integer sysParamId){
		SystemParameter systemParameter = systemParamService.get(sysParamId);
		return Msg.success().add("data", systemParameter);
	}
	
	@PutMapping(value = "update")
	@ApiOperation(value = "修改公告内容",notes="paramTypeId和paramTypeName不用传，SystemId传1，SystemName为系统参数名字，SystemContent为实际内容")
	public Msg updateSystemParameter(@RequestBody SystemParameter systemParameter){
		if (systemParamService.update(systemParameter)>0) {
			return Msg.success();			
		}else {
			return Msg.error();
		}
	}
}

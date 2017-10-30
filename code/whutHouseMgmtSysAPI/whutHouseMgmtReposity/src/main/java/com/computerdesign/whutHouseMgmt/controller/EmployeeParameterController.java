package com.computerdesign.whutHouseMgmt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.EmployeeParameter;
import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.service.EmployeeParameterService;

@Controller
public class EmployeeParameterController {

	@Autowired
	EmployeeParameterService employeeParameterService;
	
	@ResponseBody
	@RequestMapping(value="modifyEmployeeParameter", method=RequestMethod.PUT)
	public Msg modifyEmployeeParameter(@RequestBody EmployeeParameter employeeParameter){
		System.out.println(employeeParameter);
		try{
			employeeParameterService.update(employeeParameter);
			return Msg.success().add("modifiedEmployeeParameter", employeeParameter);
		}catch(Exception e) {
			return Msg.error();
		}
		
	}

	/**
	 * 添加一条职工参数记录
	 * @param employeeParameter
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addEmployeeParameter", method = RequestMethod.POST)
	public Msg addEmployeeParameter(@RequestBody EmployeeParameter employeeParameter) {
//		System.out.println(employeeParameter);
		if(employeeParameter.getEmployeeParamName()!=null && employeeParameter.getParamTypeId() != null && employeeParameter.getParamTypeName()!=null){
			employeeParameterService.add(employeeParameter);
			return Msg.success().add("addedEmpParam", employeeParameter);
		}else{
			return Msg.error("必要信息不完整，添加失败");
		}
		
	}

	/**
	 * 根据employeeParamId删除对应记录
	 * @param employeeParamId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deleteEmployeeParameter/{employeeParamId}", method = RequestMethod.DELETE)
	public Msg deleteEmployeeParameter(@PathVariable("employeeParamId") Integer employeeParamId) {
		EmployeeParameter employeeParameter = employeeParameterService.get(employeeParamId);
		if (employeeParameter == null) {
			return Msg.error("数据库中无该记录");
		} else {
			try {
				employeeParameterService.delete(employeeParamId);
				return Msg.success().add("deletedEmpParam", employeeParameter);
			} catch (Exception e) {
				return Msg.error();
			}
		}

	}

	/**
	 * 根据paramTypeId获取对应类型职工参数
	 * @param paramTypeId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getEmployeeParameter/{paramTypeId}")
	public Msg getEmployeeParameter(@PathVariable("paramTypeId") Integer paramTypeId) {
		// 获取所有参数
		List<EmployeeParameter> empParams = employeeParameterService.getAll();

		// 用于封装结果数据
		List<EmployeeParameter> empParamsResult = new ArrayList<EmployeeParameter>();
		for (EmployeeParameter empParam : empParams) {
			if (empParam.getParamTypeId() == paramTypeId) {
				empParamsResult.add(empParam);
			}
		}

		if (empParamsResult != null) {
			return Msg.success().add("empParamsResult", empParamsResult);
		} else {
			return Msg.error();
		}
	}

}

package com.computerdesign.whutHouseMgmt.controller.rentparam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.rentparam.RentParameter;
import com.computerdesign.whutHouseMgmt.service.rentparam.RentParameterService;
import com.computerdesign.whutHouseMgmt.service.staffparam.StaffParameterService;

@RequestMapping("/rentParam/")
@Controller
public class RentParameterController {

	@Autowired
	private RentParameterService rentParameterService;
	
	@Autowired
	private StaffParameterService staffParameterService;

	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Msg addRentParam(@RequestBody RentParameter rentParameterModel) {
		if (rentParameterModel.getParamTypeName() != null
				&& rentParameterModel.getParamTypeId() != null) {
			try {
				rentParameterService.add(rentParameterModel);
				return Msg.success().add("data", rentParameterModel);
			} catch (Exception e) {
				return Msg.error("出现异常，处理失败");
			}
		} else {
			return Msg.error();
		}

	}

	@ResponseBody
	@RequestMapping(value = "delete/{rentParamId}", method = RequestMethod.DELETE)
	public Msg deleteRentParam(@PathVariable("rentParamId") Integer rentParamId) {
		RentParameter rentParameter = rentParameterService.get(rentParamId);
		if (rentParameter != null) {
			try {
				rentParameterService.delete(rentParamId);
				return Msg.success().add("data", rentParameter);
			} catch (Exception e) {
				return Msg.error("出现异常，处理失败");
			}
		} else {
			return Msg.error();
		}

	}

	@ResponseBody
	@RequestMapping(value = "modify", method = RequestMethod.PUT)
	public Msg modifyRentParam(@RequestBody RentParameter rentParameterModel) {
		RentParameter rentParameter = rentParameterService.get(rentParameterModel.getRentParamId());
		if (rentParameter != null) {
			try {
				rentParameterService.update(rentParameterModel);
				return Msg.success().add("data", rentParameterModel);
			} catch (Exception e) {
				return Msg.error("出现异常，处理失败");
			}
		} else {
			return Msg.error();
		}

	}

	@ResponseBody
	@RequestMapping("get/{paramTypeId}")
	public Msg getRentParam(@PathVariable("paramTypeId") Integer paramTypeId) {
		List<RentParameter> rentParams = rentParameterService.getAllByParamTypeId(paramTypeId);
		if (rentParams != null) {
			try {
				return Msg.success().add("data", rentParams);
			} catch (Exception e) {
				return Msg.error("出现异常，处理失败");
			}
		} else {
			return Msg.error("没有数据");
		}
	}

}

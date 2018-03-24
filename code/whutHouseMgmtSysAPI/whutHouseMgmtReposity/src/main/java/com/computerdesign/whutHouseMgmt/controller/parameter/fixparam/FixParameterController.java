package com.computerdesign.whutHouseMgmt.controller.parameter.fixparam;

import java.util.List;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.fixparam.FixParameter;
import com.computerdesign.whutHouseMgmt.service.fix.FixService;
import com.computerdesign.whutHouseMgmt.service.fixparam.FixParamService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;

@RequestMapping(value = "/fixParam/")
@Controller
@Api(description="维修参数接口")
public class FixParameterController {

	@Autowired
	FixParamService fixParamService;

	@Autowired
	FixService fixService;
	/**
	 * @param paramTypeId
	 * @param page
	 * @param size
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "get/{paramTypeId}", method = RequestMethod.GET)
	public Msg getFixParameters(@PathVariable("paramTypeId") Integer paramTypeId,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {
		PageHelper.startPage(page, size);
		List<FixParameter> fixParameters = fixParamService.getAll(paramTypeId);

		PageInfo pageInfo = new PageInfo(fixParameters);
		if (fixParameters != null) {
			return Msg.success().add("data", pageInfo);
		} else {
			return Msg.error("无法查找");
		}
	}

	/**
	 * @param fixParameter
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Msg addFixParameter(@RequestBody FixParameter fixParameter) {
		if (fixParameter.getFixParamName() == null) {
			return Msg.error("请输入name");
		}
		if (fixParameter.getParamTypeId() == null) {
			return Msg.error("请输入id");
		}
		if (fixParamService.getCountByParamName(fixParameter.getFixParamName()) > 0) {
			return Msg.error("请输入其他名称");
		}
		fixParameter.setParamTypeName("维修内容");
		fixParamService.add(fixParameter);
		return Msg.success().add("data", fixParameter);

	}

	/**
	 * @param fixParamId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "delete/{fixParamId}", method = RequestMethod.DELETE)
	public Msg deleteFixParameter(@PathVariable("fixParamId") Integer fixParamId) {

		FixParameter fixParameter = fixParamService.get(fixParamId);
		if (fixService.getCountByFixParamId(fixParamId)>0) {
			return Msg.error("尚有维修申请是该类型，无法删除");
		}
		if (fixParameter == null) {
			return Msg.error("找不到该ID");
		}
		
		try {
			fixParameter.setIsDelete(true);
			// 更新操作
			fixParamService.delete(fixParameter);
			return Msg.success().add("data", fixParameter);
		} catch (Exception e) {
			// TODO: handle exception
			return Msg.error("删除失败");
		}

	}

	@ResponseBody
	@RequestMapping(value = "modify", method = RequestMethod.PUT)
	public Msg updateFixParameter(@RequestBody FixParameter fixParameter) {
		List<FixParameter> fixParameters = fixParamService.getByParamName(fixParameter.getFixParamName());
		System.out.println(fixParameters);
		for (FixParameter fixParameterAlr : fixParameters) {
			if (fixParameterAlr.getFixParamId() != fixParameter.getFixParamId()) {
				return Msg.error("该名称已存在");
			}
		}

		try {
			fixParamService.update(fixParameter);
			return Msg.success().add("data", fixParameter);
		} catch (Exception e) {
			// TODO: handle exception
			return Msg.error("更新失败");
		}
	}
}

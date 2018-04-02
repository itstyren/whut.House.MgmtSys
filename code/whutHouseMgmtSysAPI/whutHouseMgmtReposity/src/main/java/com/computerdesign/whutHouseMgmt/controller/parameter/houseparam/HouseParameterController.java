package com.computerdesign.whutHouseMgmt.controller.parameter.houseparam;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.house.House;
import com.computerdesign.whutHouseMgmt.bean.param.houseparam.HouseParameter;
import com.computerdesign.whutHouseMgmt.service.house.HouseService;
import com.computerdesign.whutHouseMgmt.service.houseparam.HouseParamService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RequestMapping("/houseParam/")
@Controller
@Api(value = "住房参数Controller", description = "住房参数接口")
public class HouseParameterController {

	@Autowired
	private HouseParamService houseParamService;
	@Autowired
	private HouseService houseService;

	/**
	 * 获取全部的houseParamId
	 * 
	 * @param paramTypeId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getHouseParamId/{paramTypeId}", method = RequestMethod.GET)
	@ApiOperation(value = "获取某一种参数类型的全部id", notes = "根据房屋参数类型的id获取该种类型的所有房屋参数信息的id", response = com.computerdesign.whutHouseMgmt.bean.Msg.class)
	public Msg getHouseTypePar(@PathVariable("paramTypeId") Integer paramTypeId) {
		List<Integer> houseParamIds = houseParamService.getHouseParamId(paramTypeId);
		return Msg.success().add("data", houseParamIds);
	}

	/**
	 * 根据住房参数获取全部的住房参数信息
	 * 
	 * @param paramTypeId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getWithoutPage/{paramTypeId}", method = RequestMethod.GET)
	@ApiOperation(value = "获取某一种类型的房屋参数", notes = "根据paramTypeId获取某一种类型的全部房屋参数,不分页", response = com.computerdesign.whutHouseMgmt.bean.Msg.class)
	public Msg getHouseParameter(@PathVariable("paramTypeId") Integer paramTypeId) {
		List<HouseParameter> houseParams = houseParamService.getbyParamTypeId(paramTypeId);

		if (houseParams != null) {
			return Msg.success().add("data", houseParams);
		} else {
			return Msg.error("不存在对于的住房信息");
		}
	}

	/**
	 * paramTypeId： 1-住房类型 2-户型 3-使用状态 4-住房结构
	 * 
	 * @param paramTypeId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "get/{paramTypeId}", method = RequestMethod.GET)
	@ApiOperation(value = "获取某一种类型的房屋参数", notes = "根据paramTypeId获取某一种类型的全部房屋参数,分页", httpMethod = "GET", response = com.computerdesign.whutHouseMgmt.bean.Msg.class)
	public Msg getHouseParameter(@PathVariable("paramTypeId") Integer paramTypeId,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {
		PageHelper.startPage(page, size);
		List<HouseParameter> houseParams = houseParamService.getbyParamTypeId(paramTypeId);
		//
		PageInfo pageInfo = new PageInfo(houseParams);

		if (houseParams != null) {
			return Msg.success().add("data", pageInfo);
		} else {
			return Msg.error("不存在对于的住房信息");
		}
	}

	/**
	 * @param houseParameter
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ApiOperation(value = "增加一个住房参数信息", notes = "增加一个住房参数信息", httpMethod = "POST", response = com.computerdesign.whutHouseMgmt.bean.Msg.class)
	public Msg addHouseParameter(@RequestBody HouseParameter houseParameter) {
		if (houseParameter.getHouseParamName() == null) {
			return Msg.error("必要信息不完整，添加失败");
		}
		if (houseParameter.getParamTypeId() == null) {
			return Msg.error("必要信息不完整，添加失败");
		}
		if (houseParameter.getParamTypeId() == 4 && houseParameter.getStructRent() == null) {// 住房结构信息
			return Msg.error("住房结构信息必须设置房屋每平米租金参数");
		}
		// 遍历全部已有的房屋参数信息
		List<HouseParameter> listHouseParameter = houseParamService.getbyParamTypeId(houseParameter.getParamTypeId());
		for (HouseParameter houseParamAlready : listHouseParameter) {
			// 检查房屋参数信息的名称是否已经存在
			if (houseParameter.getHouseParamName().equals(houseParamAlready.getHouseParamName())) {
				return Msg.error("该名称已存在，无法添加");
			}
		}
		houseParamService.add(houseParameter);
		return Msg.success().add("data", houseParameter);
	}

	/**
	 * 
	 * @param houseParamId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "delete/{houseParamId}", method = RequestMethod.DELETE)
	@ApiOperation(value = "删除一个房屋信息", notes = "删除一个服务信息", httpMethod = "DELETE", response = com.computerdesign.whutHouseMgmt.bean.Msg.class)
	public Msg deleteHouseParam(@PathVariable("houseParamId") Integer houseParamId) {
		HouseParameter houseParameter = houseParamService.get(houseParamId);
		if (houseParameter == null) {
			return Msg.error("找不到该id，删除出错");
		}
		List<House> houses = houseService.getHousesByParamId(houseParameter.getParamTypeId(), houseParamId);
		if (!houses.isEmpty()) {
			return Msg.error("该住房参数无法删除");
		}
		houseParameter.setIsDelete(true);
		houseParamService.update(houseParameter);
		return Msg.success().add("data", houseParameter);
	}

	/**
	 * @param houseParameter
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "modify", method = RequestMethod.PUT)
	@ApiOperation(value = "修改一个房屋参数信息", httpMethod = "PUT", response = com.computerdesign.whutHouseMgmt.bean.Msg.class)
	public Msg modifyHouseParam(@RequestBody HouseParameter houseParameter) {
		if (houseParameter.getHouseParamName() == null) {
			return Msg.error("必要信息不完整，添加失败");
		}
		if (houseParameter.getParamTypeId() == null) {
			return Msg.error("必要信息不完整，添加失败");
		}
		if (houseParameter.getParamTypeId() == 4 && houseParameter.getStructRent() == null) {// 住房结构信息
			return Msg.error("住房结构信息必须设置房屋每平米租金参数");
		}
		// 遍历全部已有的房屋参数信息
		List<HouseParameter> listHouseParameter = houseParamService.getbyParamTypeId(houseParameter.getParamTypeId());
		// 遍历这些信息
		Iterator iterator = listHouseParameter.iterator();
		while (iterator.hasNext()) {
			HouseParameter houseParamAlready = (HouseParameter) iterator.next();
			if (houseParamAlready.getHouseParamId() != houseParameter.getHouseParamId()
					&& houseParameter.getHouseParamName().equals(houseParamAlready.getHouseParamName())) {
				return Msg.error("该名称已存在，无法修改");
			}
		}

		try {
			houseParamService.update(houseParameter);
			return Msg.success().add("data", houseParameter);
		} catch (Exception e) {
			// TODO: handle exception
			return Msg.error("数据库中没有找到此条记录，修改失败 ");
		}
	}
}

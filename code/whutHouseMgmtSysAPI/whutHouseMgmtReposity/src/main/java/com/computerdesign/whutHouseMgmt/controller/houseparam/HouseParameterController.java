package com.computerdesign.whutHouseMgmt.controller.houseparam;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.houseparam.HouseParameter;
import com.computerdesign.whutHouseMgmt.service.houseparam.HouseParamService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping("/houseParam/")
@Controller
public class HouseParameterController {

	@Autowired
	private HouseParamService houseParamService;

	/**
	 * 
	 * 
	 * @param paramTypeId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "get/{paramTypeId}", method = RequestMethod.GET)

	public Msg getHouseParameter(@PathVariable("paramTypeId") Integer paramTypeId,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {
		PageHelper.startPage(page, size);
		List<HouseParameter> houseParams = houseParamService.getAll(paramTypeId);
		//
		PageInfo pageInfo = new PageInfo(houseParams);

		if (houseParams != null) {
			return Msg.success().add("data", pageInfo);
		} else {
			return Msg.error();
		}
	}

	/**
	 * @param houseParameter
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Msg addHouseParameter(@RequestBody HouseParameter houseParameter) {
		if (houseParameter.getHouseParamName() != null) {
			if (houseParameter.getParamTypeId() != null) {
				
				houseParamService.add(houseParameter);
				
				return Msg.success().add("data", houseParameter);
			} else {
				return Msg.error("找不到ParamTypeId");
			}
		} else {
			return Msg.error("找不到HouseParamName");
		}
	}


	/**
	 * @param houseParamId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "delete/{houseParamId}", method = RequestMethod.DELETE)
	public Msg deleteHouseParam(@PathVariable("houseParamId") Integer houseParamId) {
		HouseParameter houseParameter = houseParamService.get(houseParamId);
		if (houseParameter != null) {
			try {
				houseParameter.setIsDelete(true);
				//更新操作，且不可逆
				houseParamService.delete(houseParameter);
				return Msg.success().add("data", houseParameter);
			} catch (Exception e) {
				// TODO: handle exception
				return Msg.error();
			}
		} else {
			return Msg.error("找不到houseParamId");
		}
	}

	/**
	 * @param houseParameter
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "modify", method = RequestMethod.PUT)
	public Msg modifyHouseParam(@RequestBody HouseParameter houseParameter) {
		try {
			houseParamService.update(houseParameter);
			return Msg.success().add("data", houseParameter);
		} catch (Exception e) {
			// TODO: handle exception
			return Msg.error();
		}
	}
}

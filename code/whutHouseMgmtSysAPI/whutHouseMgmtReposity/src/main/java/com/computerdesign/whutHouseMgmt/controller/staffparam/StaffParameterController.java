package com.computerdesign.whutHouseMgmt.controller.staffparam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.paramclass.ParamClass;
import com.computerdesign.whutHouseMgmt.bean.staffparam.HouseSub;
import com.computerdesign.whutHouseMgmt.bean.staffparam.StaffParameter;
import com.computerdesign.whutHouseMgmt.service.paramclass.ParamClassService;
import com.computerdesign.whutHouseMgmt.service.staffparam.StaffParameterService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping("/staffParam/")
@Controller
public class StaffParameterController {

	@Autowired
	private StaffParameterService staffParameterService;

	@Autowired
	private ParamClassService paramClassService;

	/**
	 * 获取所有住房补贴参数
	 * @param page
	 * @param size
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getAllHouseSub", method = RequestMethod.GET)
	public Msg getAllHouseSub(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {
		PageHelper.startPage(page,size);
		List<HouseSub> houseSubs = staffParameterService.getAllHouseSub();
		PageInfo pageInfo = new PageInfo(houseSubs);
		return Msg.success().add("data", pageInfo);
	}
	
	/**
	 * 添加一条住房补贴参数
	 * @param houseSub
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addHouseSub", method = RequestMethod.POST)
	public Msg addHouseSub(@RequestBody HouseSub houseSub) {
//		System.out.println(houseSub);
		if(houseSub != null){
			staffParameterService.addHouseSub(houseSub);
		}
		return Msg.success().add("data", houseSub);
	}
	
	/**
	 * 删除一条住房补贴参数
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deleteHouseSub/{id}", method = RequestMethod.DELETE)
	public Msg deleteHouseSub(@PathVariable("id") Integer id) {
		if(id != null){
			staffParameterService.deleteHouseSub(id);
		}
		return Msg.success();
	}

	/**
	 * 更新一条住房补贴参数
	 * @param houseSub
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateHouseSub", method = RequestMethod.PUT)
	public Msg updateHouseSub(@RequestBody HouseSub houseSub) {
		if(houseSub != null){
			staffParameterService.updateHouseSub(houseSub);
		}
		return Msg.success().add("data", houseSub);
	}
	
	// /**
	// *
	// * @param paramTypeId
	// */
	// @ModelAttribute
	// public void getParamTypeName(@PathVariable(value = "paramTypeId",
	// required = false) Integer paramTypeId,
	// Map<String, Object> map) {
	// if (paramTypeId != null) {
	// ParamClass paramClass = paramClassService.get(paramTypeId);
	// System.out.println(paramClass.getParamTypeName());
	// map.put("paramClass", paramClass);
	// }
	// }

	@ResponseBody
	@RequestMapping(value = "modify", method = RequestMethod.PUT)
	public Msg modifyStaffParameter(@RequestBody StaffParameter staffParameterModel) {
		// System.out.println(staffParameterModel);
		// 根据传入的id到数据库查找记录
		StaffParameter staffParameter = staffParameterService.get(staffParameterModel.getStaffParamId());
		if (staffParameter == null) {
			return Msg.error("数据库中没有找到此条记录，修改失败 ");
		} else {
			try {
				staffParameterService.update(staffParameterModel);
				return Msg.success().add("data", staffParameterModel);
			} catch (Exception e) {
				return Msg.error();
			}
		}
	}

	/**
	 * 添加职工参数
	 * 
	 * @param StaffParameter
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Msg addStaffParameter(@RequestBody StaffParameter staffParameterModel) {
		// System.out.println(StaffParameter);
		// System.out.println(paramClass.getParamTypeName());
		// 验证
		if (staffParameterModel.getStaffParamName() != null && staffParameterModel.getParamTypeId() != null) {
			staffParameterModel.setIsDelete(false);
			staffParameterService.add(staffParameterModel);
			return Msg.success().add("data", staffParameterModel);
		} else {
			return Msg.error("必要信息不完整，添加失败");
		}

	}

	/**
	 * 删除职工参数
	 * 
	 * @param StaffParamId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "delete/{staffParamId}", method = RequestMethod.DELETE)
	public Msg deleteStaffParameter(@PathVariable("staffParamId") Integer staffParamId) {
		StaffParameter staffParameter = staffParameterService.get(staffParamId);
		if (staffParameter == null) {
			return Msg.error("数据库中无此条记录");
		} else {
			try {
				// staffParameterService.delete(staffParamId);
				staffParameter.setIsDelete(true);
				staffParameterService.update(staffParameter);
				return Msg.success().add("data", staffParameter);
			} catch (Exception e) {
				return Msg.error();
			}
		}

	}

	/**
	 * 获取职工参数
	 * 
	 * @param paramTypeId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "get/{paramTypeId}", method = RequestMethod.GET)
	public Msg getStaffParameter(@PathVariable("paramTypeId") Integer paramTypeId,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {
		// // 从数据库获取所有的记录
		// List<StaffParameter> staffParams = staffParameterService.getAll();
		//
		// // 用于封装特定paramTypeId的所有记录
		// List<StaffParameter> staffParamsResult = new
		// ArrayList<StaffParameter>();
		// for (StaffParameter staffParam : staffParams) {
		// if (staffParam.getParamTypeId() == paramTypeId) {
		// staffParamsResult.add(staffParam);
		// }
		// }

		PageHelper.startPage(page, size);

		// 根据paramTypeId获取对应的没有被删除的职工参数
		List<StaffParameter> staffParams = staffParameterService.getAllByParamTypeId(paramTypeId);

		PageInfo pageInfo = new PageInfo(staffParams);

		if (staffParams != null) {
			return Msg.success().add("data", pageInfo);
		} else {
			return Msg.error("无记录");
		}
	}

}

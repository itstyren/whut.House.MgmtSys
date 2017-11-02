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

	// /**
	// * 闁跨喐鏋婚幏鐑芥晸閺傘倖瀚归柨鐔告灮閹风兘鏁撻弬銈嗗闁跨喐鏋婚幏铚傜閸撳秵澧介柨鐔峰建閿濆繑瀚归柨鐔告灮閹风兘鏁撶徊顪amTypeName
	// * 闁跨喐鏋婚幏鐑芥晸閺傘倖瀚筽aramTypeId闁跨喐鏋婚幏宄板絿ParamClass闁跨喐鏋婚幏鐑芥晸閺傘倖瀚筍pringMVC闁跨喐鏋婚幏鐑芥晸閺傘倖瀚归柨鐔告灮閹风兘鏁撶徊鍒焢闁跨喎褰ㄩ敐蹇斿闁跨喐鏋婚幏鐑芥晸閺傘倖瀚归柨鐔告灮閹风兘鏁撻弬銈嗗娑撹櫣娲伴柨鐔烘灱閺傚綊鏁撻弬銈嗗闁跨喍鑼庣拠褎瀚归柨鐔告灮閹凤拷
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
		// 闁跨喐鏋婚幏鐑芥晸閺傘倖瀚筰d闁跨喐鏋婚幏宄板絿闁跨喐鏋婚幏鐑芥晸閺傘倖瀚圭憰渚�鏁撻惈顐ｆ暭绾板瀚归懕宀勬晸閺傘倖瀚归柨鐔告灮閹风兘鏁撻弬銈嗗
		StaffParameter staffParameter = staffParameterService.get(staffParameterModel.getStaffParamId());
		if (staffParameter == null) {
			return Msg.error("闁跨喐鏋婚幏鐑芥晸閹瑰嘲灏呴幏鐑芥晸閺傘倖瀚归柨鐔稿疆鐠囇勫闁跨喐鏋婚幏鐑芥晸閻偆銆嬮幏宄扮秿");
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
	 * 闁跨喐鏋婚幏鐑芥晸閹活厺绱幏鐑芥晸鐞涙搴滈幏鐑芥晸閺傘倖瀚归柨鐔告灮閹风兘鏁撻弬銈嗗闁跨喖鎽敓锟�
	 * 
	 * @param StaffParameter
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Msg addStaffParameter(@RequestBody StaffParameter staffParameterModel) {
		// System.out.println(StaffParameter);
		// System.out.println(paramClass.getParamTypeName());
		// 闁跨喐鏋婚幏鐑芥晸閺傘倖瀚归柨鐔告灮閹风兘鏁撻弬銈嗗鐟佸懘鏁撻弬銈嗗StaffParameter闁跨喐鏋婚幏鐑芥晸閺傘倖瀚�
		if (staffParameterModel.getStaffParamName() != null && staffParameterModel.getParamTypeId() != null) {
			staffParameterService.add(staffParameterModel);
			return Msg.success().add("data", staffParameterModel);
		} else {
			return Msg.error("必要信息不完整，添加失败");
		}

	}

	/**
	 * 闁跨喐鏋婚幏鐑芥晸閺傘倖瀚筍taffParamId閸掔娀鏁撻弬銈嗗闁跨喐鏋婚幏宄扮安闁跨喐鏋婚幏宄扮秿
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
//				staffParameterService.delete(staffParamId);
				staffParameter.setIsDelete(true);
				staffParameterService.update(staffParameter);
				return Msg.success().add("data", staffParameter);
			} catch (Exception e) {
				return Msg.error();
			}
		}

	}

	/**
	 * 闁跨喐鏋婚幏鐑芥晸閺傘倖瀚筽aramTypeId闁跨喐鏋婚幏宄板絿闁跨喐鏋婚幏宄扮安闁跨喐鏋婚幏鐑芥晸閺傘倖瀚归懕宀勬晸閺傘倖瀚归柨鐔告灮閹风兘鏁撻弬銈嗗
	 * 
	 * @param paramTypeId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "get/{paramTypeId}",method=RequestMethod.GET)
	public Msg getStaffParameter(@PathVariable("paramTypeId") Integer paramTypeId,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {
		// // 闁跨喐鏋婚幏宄板絿闁跨喐鏋婚幏鐑芥晸閸欘偉顕滈幏鐑芥晸閺傘倖瀚�
		// List<StaffParameter> staffParams = staffParameterService.getAll();
		//
		// // 闁跨喐鏋婚幏鐑芥晸閼哄倸鍤栭幏鐤棅闁跨喐鏋婚幏鐑芥晸閺傘倖瀚归柨鐔告灮閹风兘鏁撻敓锟�
		// List<StaffParameter> staffParamsResult = new
		// ArrayList<StaffParameter>();
		// for (StaffParameter staffParam : staffParams) {
		// if (staffParam.getParamTypeId() == paramTypeId) {
		// staffParamsResult.add(staffParam);
		// }
		// }

		PageHelper.startPage(page, size);

		//根据paramTypeId获取对应的没有被删除的职工参数
		List<StaffParameter> staffParams = staffParameterService.getAllByParamTypeId(paramTypeId);

		PageInfo pageInfo = new PageInfo(staffParams);

		if (staffParams != null) {
			return Msg.success().add("data", pageInfo);
		} else {
			return Msg.error("无记录");
		}
	}

}

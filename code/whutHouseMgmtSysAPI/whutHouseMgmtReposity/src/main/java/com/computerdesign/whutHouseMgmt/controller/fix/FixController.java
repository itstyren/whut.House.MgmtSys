package com.computerdesign.whutHouseMgmt.controller.fix;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.fix.FixAddCheck;
import com.computerdesign.whutHouseMgmt.bean.fix.FixAddPrice;
import com.computerdesign.whutHouseMgmt.bean.fix.FixGetCheck;
import com.computerdesign.whutHouseMgmt.bean.fix.PersonalFixRecord;
import com.computerdesign.whutHouseMgmt.bean.fix.common.Fix;
import com.computerdesign.whutHouseMgmt.bean.fix.common.ViewFix;
import com.computerdesign.whutHouseMgmt.bean.fix.directapply.FixAddDirectApply;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.house.ViewHouse;
import com.computerdesign.whutHouseMgmt.bean.houseregister.Resident;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentVw;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.ViewStaff;
import com.computerdesign.whutHouseMgmt.service.fix.FixService;
import com.computerdesign.whutHouseMgmt.service.fix.ViewFixService;
import com.computerdesign.whutHouseMgmt.service.house.ViewHouseService;
import com.computerdesign.whutHouseMgmt.service.houseregister.RegisterService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.ViewStaffService;
import com.computerdesign.whutHouseMgmt.utils.DateUtil;
import com.computerdesign.whutHouseMgmt.utils.ResponseUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping(value = "/fix/")
@RestController
public class FixController {

	@Autowired
	private FixService fixService;

	@Autowired
	private ViewStaffService viewStaffService;

	@Autowired
	private ViewHouseService viewHouseService;

	@Autowired
	private ViewFixService viewFixService;

	@Autowired
	private RegisterService registerService;

	/**
	 * 个人信息页面，通过id获取维修信息
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getByStaffId/{staffId}", method = RequestMethod.GET)
	public Msg getByStaffId(@PathVariable("staffId") Integer staffId) {
		List<ViewFix> fixs = viewFixService.getByStaffId(staffId);
		List<PersonalFixRecord> personalFixRecords = new ArrayList<PersonalFixRecord>();
		for (ViewFix fix : fixs) {
			PersonalFixRecord personalFixRecord = new PersonalFixRecord();
			personalFixRecord.setFixId(fix.getId());
			personalFixRecord.setFixType(fix.getFixContentName());
			personalFixRecord.setDescription(fix.getDescription());
			personalFixRecord.setFixState(fix.getFixState());
			personalFixRecord.setIsCheck(fix.getIsCheck());
			personalFixRecord.setIsOver(fix.getIsOver());
			personalFixRecord.setRatings(fix.getRatings());
			String processReason = null;
			// 判断审核流程进行到了哪一步
			if (fix.getAgreeNote() != null) {
				processReason = fix.getAgreeNote();
			} else if (fix.getAcceptNote() != null) {
				processReason = fix.getAcceptNote();
			} else {
				processReason = "无意见";
			}
			personalFixRecord.setProcessReason(processReason);
			personalFixRecord.setApplyTime(fix.getApplyTime());
			personalFixRecords.add(personalFixRecord);
		}
		return Msg.success().add("data", personalFixRecords);
	}

	/**
	 * 返回申请页面得到的数据
	 * 
	 * @param staffId
	 * @return
	 */
	@RequestMapping(value = "getApply/{staffId}", method = RequestMethod.GET)
	public Msg getFixApply(@PathVariable("staffId") Integer staffId) {

		// 获取员工信息
		if (viewStaffService.getByStaffId(staffId).isEmpty()) {
			return Msg.error("不存在该员工Id");
		}
		ViewStaff viewStaff = viewStaffService.getByStaffId(staffId).get(0);

		// 封装需要的员工信息
		String[] fixFileds = { "id", "no", "name", "sex", "code", "postName", "deptName", "tel","email" };
		Map<String, Object> fixGetApplyResponse = ResponseUtil.getResultMap(viewStaff, fixFileds);

		// 根据staffId获取该员工全部的resident信息
		List<Resident> listResident = registerService.getResidentsByStaffId(staffId);
		if (listResident.isEmpty()) {
			fixGetApplyResponse.put("listHouseGetApply", null);
			return Msg.success("没有房子").add("data", fixGetApplyResponse);
		}

		List<ViewHouse> listViewHouse = new ArrayList<ViewHouse>();
		// 根据每一个房屋登记信息获取每一个house
		for (Resident resident : listResident) {
			listViewHouse.addAll(viewHouseService.get(resident.getHouseId()));
		}

		// 房屋信息封装
		String[] houseFileds = { "id", "no", "typeName", "address", "buildArea", "usedArea", "statusName" };
		List<Map<String, Object>> listHouseGetApply = ResponseUtil.getResultMap(listViewHouse, houseFileds);

		fixGetApplyResponse.put("listHouseGetApply", listHouseGetApply);
		return Msg.success("维修申请页面").add("data", fixGetApplyResponse);
	}

	/**
	 * 维修申请,获取的参数包括
	 * 
	 * @param fix
	 *            封装以下数据
	 * @param fixContentId
	 * @param description
	 * @param staffId
	 * @param houseId
	 * @param phone
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "addApply", method = RequestMethod.POST)
	public Msg addFixApply(@RequestBody Fix fix) {
		if (fix.getHouseId() == null) {
			return Msg.error("维修房屋不能为空");
		}
		if (fix.getFixContentId() == null) {
			return Msg.error("维修类型不能为空");
		}
//		if (!fixService.getByStaffId(fix.getStaffId()).isEmpty()) {
//			return Msg.error("该员工正在进行申请维修，不能重复提交");
//		}
		fix.setApplyTime(new Date());

		fix.setFixState("待受理");
		fix.setIsCheck(false);
		fix.setIsOver(false);
		fixService.add(fix);
		return Msg.success("维修申请成功").add("data", fix);
	}

	/**
	 * 根据员工姓名获取维修直批页面
	 * 
	 * @param staffName
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "getDirectApplyByStaffName", method = RequestMethod.GET)
	public Msg getDirectApplyByName(@RequestParam(value = "staffName") String staffName) {
		// TODO 按照姓名获取页面
		try {
			staffName = new String(staffName.getBytes("8859_1"), "utf8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		// 根据姓名获取全部的ViewStaff
		List<ViewStaff> listViewStaff = viewStaffService.getViewStaffsByName(staffName);

		if (listViewStaff.isEmpty()) {
			return Msg.error("无该员工");
		}
		// 该姓名员工可能不止一个
		List<Map<String, Object>> listFixGetDirectApply = new ArrayList<Map<String, Object>>();

		for (ViewStaff viewStaff : listViewStaff) {

			String[] fileds = { "id", "no", "name", "sex", "marriageState", "titleName", "postName", "typeName",
					"statusName", "dept", "deptName", "tel", "code", "joinTime", "remark", "spouseName", "spouseCode",
					"spouseDept", "spouseKind", "spousePostName", "spouseTitleName", };
			Map<String, Object> viewStaffResponse = ResponseUtil.getResultMap(viewStaff, fileds);

			// 根据staffId获取该员工全部的residentVw信息
			List<ResidentVw> listResidentVw = registerService.getResidentVwByStaffId(viewStaff.getId());
			// 房屋数组信息
			List<Map<String, Object>> listHouse = new ArrayList<Map<String, Object>>();

			if (listResidentVw.isEmpty()) {
				viewStaffResponse.put("houseList", null);
			} else {
				// 根据每一个房屋登记信息获取每一个house
				for (ResidentVw residentVw : listResidentVw) {
					if (viewHouseService.get(residentVw.getHouseId()).isEmpty()) {
						// return Msg.error("没有房子");
					} else {
						ViewHouse viewHouse = viewHouseService.get(residentVw.getHouseId()).get(0);
						Map<String, Object> mapHouse = new HashMap<>();
						mapHouse.put("bookTime", DateUtil.getCurrentSimpleDate(residentVw.getBookTime()));
						mapHouse.put("houseRel", residentVw.getHouseRel());

						mapHouse.put("address", viewHouse.getAddress());
						mapHouse.put("houseId", viewHouse.getId());
						mapHouse.put("layoutName", viewHouse.getLayoutName());
						mapHouse.put("usedArea", viewHouse.getUsedArea());
						mapHouse.put("typeName", viewHouse.getTypeName());

						listHouse.add(mapHouse);
					}
				}
				viewStaffResponse.put("houseList", listHouse);
			}
			listFixGetDirectApply.add(viewStaffResponse);
		}
		return Msg.success("根据员工姓名获取维修直批页面").add("data", listFixGetDirectApply);
	}

	/**
	 * 根据员工Id获取维修直批页面
	 * 
	 * @param staffId
	 * @return
	 */
	@RequestMapping(value = "getDirectApplyByStaffId/{staffId}", method = RequestMethod.GET)
	public Msg getDirectApplyByStaffId(@PathVariable("staffId") Integer staffId) {
		ViewStaff viewStaff = viewStaffService.getByStaffId(staffId).get(0);

		String[] fileds = { "id", "no", "name", "sex", "marriageState", "titleName", "postName", "typeName",
				"statusName", "dept", "deptName", "tel", "code", "joinTime", "remark", "spouseName", "spouseCode",
				"spouseDept", "spouseKind", "spousePostName", "spouseTitleName", };
		Map<String, Object> viewStaffResponse = ResponseUtil.getResultMap(viewStaff, fileds);

		// 根据staffId获取该员工全部的residentVw信息
		List<ResidentVw> listResidentVw = registerService.getResidentVwByStaffId(staffId);

		// 房屋数组信息
		List<Map<String, Object>> listHouse = new ArrayList<Map<String, Object>>();

		if (listResidentVw.isEmpty()) {
			viewStaffResponse.put("houseList", null);
			return Msg.success().add("data", viewStaffResponse);
		} else {
			// 根据每一个房屋登记信息获取每一个house
			for (ResidentVw residentVw : listResidentVw) {
				if (viewHouseService.get(residentVw.getHouseId()).isEmpty()) {
					// return Msg.error("没有房子");
				} else {
					ViewHouse viewHouse = viewHouseService.get(residentVw.getHouseId()).get(0);
					Map<String, Object> mapHouse = new HashMap<>();
					mapHouse.put("bookTime", DateUtil.getCurrentSimpleDate(residentVw.getBookTime()));
					mapHouse.put("houseRel", residentVw.getHouseRel());

					mapHouse.put("address", viewHouse.getAddress());
					mapHouse.put("houseId", viewHouse.getId());
					mapHouse.put("layoutName", viewHouse.getLayoutName());
					mapHouse.put("usedArea", viewHouse.getUsedArea());
					mapHouse.put("typeName", viewHouse.getTypeName());

					listHouse.add(mapHouse);
				}
			}
			viewStaffResponse.put("houseList", listHouse);

			return Msg.success().add("data", viewStaffResponse);
		}
	}

	/**
	 * 维修直批，该功能取消
	 * 
	 * @param fixAddDirectApply
	 * @return
	 */
	@RequestMapping(value = "addDirectApply", method = RequestMethod.POST)
	public Msg addDirectApply(@RequestBody FixAddDirectApply fixAddDirectApply) {
		return Msg.error("无法进行维修直批");
		// Fix fix = new Fix();
		// fix.setFixContentId(fixAddDirectApply.getFixContentId());
		// fix.setApplyTime(new Date());
		// fix.setFixState("已审核");
		// fix.setAcceptState("通过");
		// fix.setAcceptNote("直批");
		// fix.setAcceptMan(fixAddDirectApply.getDirectApplyMan());
		// fix.setAcceptTime(new Date());
		// fix.setAgreeState("通过");
		// fix.setAgreeNote("直批");
		// fix.setAgreeMan(fixAddDirectApply.getDirectApplyMan());
		// fix.setAgreeTime(new Date());
		// fix.setStaffId(fixAddDirectApply.getStaffId());
		// fix.setHouseId(fixAddDirectApply.getHouseId());
		// fix.setMessage("直批");
		// fix.setIsOver(true);
		//
		// fixService.add(fix);
		// return Msg.success("直批成功");
	}

	/**
	 * 获取全部尚未定价的维修信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "getFixManagement", method = RequestMethod.GET)
	public Msg getFixManagement(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size) {

		PageHelper.startPage(page, size);
		List<ViewFix> listViewFix = viewFixService.getManagement();

		String[] fileds = { "id", "fixContentId", "fixContentName", "fixState", "description", "applyTime", "staffName",
				"titleName", "postName", "deptName", "phone", "address", "acceptMan", "acceptNote", "acceptTime",
				"acceptState", "agreeMan", "agreeNote", "agreeTime", "agreeState" };
		List<Map<String, Object>> response = ResponseUtil.getResultMap(listViewFix, fileds);
		// 让listViewFix设置好pageInfo中的各项属性，再替换pageInfo中的list
		PageInfo pageInfo = new PageInfo(listViewFix);
		pageInfo.setList(response);

		return Msg.success("获取全部尚未定价的维修信息").add("data", pageInfo);
		// PageInfo pageInfo = new PageInfo(listViewFix);
		// return Msg.success("获取全部尚未定价的维修信息").add("data", pageInfo);
	}

	/**
	 * 获取结算页面信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "getCheck", method = RequestMethod.GET)
	public Msg getFixCheck(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size) {

		PageHelper.startPage(page, size);
		List<ViewFix> list = viewFixService.getAll();

		PageInfo pageInfo = new PageInfo(list);
		return Msg.success("获取维修结算页面").add("data", pageInfo);
	}

	// @RequestMapping(value = "getCheck",method = RequestMethod.GET)
	// public Msg getFixCheck(@PathVariable FixSetTime fixSetTime){
	//
	// Date startTime = fixSetTime.getStartTime();
	// Date endTime = fixSetTime.getEndTime();
	// List<ViewFix> list = viewFixService.getByTime(startTime, endTime);
	// return Msg.success().add("data", list);
	// }

	/**
	 * 结算页面按条件查询
	 * 
	 * @param fixGetCheck
	 * @return
	 */
	@RequestMapping(value = "getCheckByAllMultiCondition", method = RequestMethod.POST)
	public Msg getFixCheck(@RequestBody FixGetCheck fixGetCheck,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size) {

		PageHelper.startPage(page, size);
		List<ViewFix> list = viewFixService.getByMultiCondition(fixGetCheck);

		PageInfo pageInfo = new PageInfo(list);
		return Msg.success().add("data", pageInfo);
	}

	/**
	 * 维修定价
	 * 
	 * @param fixAddPrice
	 * @return
	 */
	@RequestMapping(value = "addPrice", method = RequestMethod.PUT)
	public Msg addFixPrice(@RequestBody FixAddPrice fixAddPrice) {

		Fix fix = fixService.get(fixAddPrice.getId());
		if (fix.getIsCheck() == true) {
			return Msg.error("已经结算，无法定价");
		}

		fix.setPriceMan(fixAddPrice.getPriceMan());
		fix.setFixMoney(fixAddPrice.getPrice());
		fix.setPriceTime(new Date());
		// 维修状态改变
		fixService.update(fix);
		return Msg.success().add("data", fix);

	}

	/**
	 * 维修结算
	 * 
	 * @param fixAddCheck
	 * @return
	 */
	@RequestMapping(value = "addCheck", method = RequestMethod.PUT)
	public Msg addFixCheck(@RequestBody FixAddCheck fixAddCheck) {

		Fix fix = fixService.get(fixAddCheck.getId());
		if (fix.getPriceMan() == null) {
			return Msg.error("尚未定价，无法结算");
		}
		fix.setCheckMan(fixAddCheck.getCheckMan());
		fix.setCheckTime(new Date());
		fix.setIsCheck(true);
		// 维修状态改变
		fixService.update(fix);
		return Msg.success().add("data", fix);
	}

	/**
	 * 删除维修请求
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "deleteFix/{id}")
	public Msg deleteFix(@PathVariable("id") Integer id) {
		if (fixService.get(id) == null) {
			return Msg.error("不存在");
		}
		fixService.delete(id);
		return Msg.success("成功删除");
	}
}

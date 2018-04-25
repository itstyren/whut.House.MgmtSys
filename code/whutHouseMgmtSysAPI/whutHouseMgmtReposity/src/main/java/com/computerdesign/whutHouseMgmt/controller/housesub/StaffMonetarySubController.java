package com.computerdesign.whutHouseMgmt.controller.housesub;

import java.util.Calendar;
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

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.housesub.MonetarySubVw;
import com.computerdesign.whutHouseMgmt.bean.housesub.StaffForMonSub;
import com.computerdesign.whutHouseMgmt.bean.housesub.StaffMonetarySub;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.Staff;
import com.computerdesign.whutHouseMgmt.bean.staffparam.MonetarySubParam;
import com.computerdesign.whutHouseMgmt.service.housesub.MonetarySubVwService;
import com.computerdesign.whutHouseMgmt.service.housesub.StaffForMonSubService;
import com.computerdesign.whutHouseMgmt.service.housesub.StaffMonetarySubService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.StaffService;
import com.computerdesign.whutHouseMgmt.service.staffparam.MonetarySubParamService;
import com.computerdesign.whutHouseMgmt.utils.ResponseUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/staffMonetarySub/")
public class StaffMonetarySubController {

	@Autowired
	private StaffMonetarySubService staffMonetarySubService;

	@Autowired
	private MonetarySubParamService monetarySubParamService;

	@Autowired
	private StaffService staffService;

	@Autowired
	private MonetarySubVwService monetarySubVwService;

	@Autowired
	private StaffForMonSubService staffForMonSubService;
	
	/**
	 * 获取所有补贴记录
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getAllMonetarySub", method = RequestMethod.GET)
	public Msg getAllMonetarySub(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {

		PageHelper.startPage(page, size);
		List<MonetarySubVw> staffMonetarySubs = staffMonetarySubService.getAllMonetarySub();
		String[] fileds = { "id", "staffId", "staffNo", "staffName", "year", "deptName", "titleName", "postName",
				"postName", "annualSal", "subsidies", "remark" };
		List<Map<String, Object>> response = ResponseUtil.getResultMap(staffMonetarySubs, fileds);
		PageInfo pageInfo = new PageInfo(response);
		return Msg.success().add("data", pageInfo);
	}

	/**
	 * 根据职工编号获取其所有补贴记录
	 * 
	 * @param staffNo
	 * @param page
	 * @param size
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getMonetarySubByStaffNo/{staffNo}", method = RequestMethod.GET)
	public Msg getMonetarySubByStaffNo(@PathVariable("staffNo") String staffNo,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {

		PageHelper.startPage(page, size);
		if (staffNo != null) {
			List<MonetarySubVw> staffMonetarySubs = staffMonetarySubService.getMonetarySubByStaffNo(staffNo);
			String[] fileds = { "id", "staffId", "staffNo", "staffName", "year", "deptName", "titleName", "postName",
					"postName", "annualSal", "subsidies", "remark" };
			List<Map<String, Object>> response = ResponseUtil.getResultMap(staffMonetarySubs, fileds);
			PageInfo pageInfo = new PageInfo(response);
			return Msg.success().add("data", pageInfo);
		} else {
			return Msg.error();
		}
	}

	/**
	 * 根据id删除一条补贴记录
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deleteMonetarySub/{id}", method = RequestMethod.DELETE)
	public Msg deleteMonetarySub(@PathVariable("id") Integer id) {
		if (id != null) {
			staffMonetarySubService.delete(id);
			return Msg.success("删除成功");
		} else {
			return Msg.error();
		}
	}

	/**
	 * 添加一条住房补贴记录
	 * 
	 * @param staffMonetarySub
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addMonetarySub", method = RequestMethod.POST)
	public Msg addMonetarySub(@RequestBody StaffMonetarySub staffMonetarySub) {
		if (staffMonetarySub != null) {
			// 获取补贴比例
			MonetarySubParam monetarySubParam = monetarySubParamService.getIsUsing();
			// 根据职工编号获取职工ID
			Integer staffId = staffService.getStaffIdByStaffNo(staffMonetarySub.getStaffNo());
			Staff staff = staffService.get(staffId);
			Calendar calendar = Calendar.getInstance();
			calendar.set(1998, 11, 31, 0, 0, 0);

			StaffForMonSub staffForMonSub = staffForMonSubService.getByStaffId(staffId);
			double enjoyHouseArea = 80.0;
			// 职务职称享受面积取最大值，获取职工住房补贴标准
			if(staffForMonSub.getMaxEnjoyArea() != null){
				enjoyHouseArea = staffForMonSub.getMaxEnjoyArea();
			}

			// 获取职工家庭已购住房
			// double buyHouseArea = staffForMonSub.getHouseBuildArea();
			double buyHouseArea = staffForMonSub.getHouseUsedArea();

			if (staffMonetarySubService.isOwnHouse(staffId)
					&& (staff.getJoinTime().getTime() < calendar.getTime().getTime())
					&& enjoyHouseArea > buyHouseArea) {
				// 有房且是老职工且未达标
				double subsidies = (staffMonetarySub.getAnnualSal() + staffMonetarySub.getAnnualSal() * 0.2806)
						* monetarySubParam.getSubParam() / 100.0 / enjoyHouseArea * (enjoyHouseArea - buyHouseArea);
				// 没有四舍五入
				staffMonetarySub.setSubsidies((long) subsidies);
			} else {
				// 无房老职工和新职工的补贴标准
				double subsidies = (staffMonetarySub.getAnnualSal() + staffMonetarySub.getAnnualSal() * 0.2806)
						* monetarySubParam.getSubParam() / 100.0;
				staffMonetarySub.setSubsidies((long) subsidies);
			}

			staffMonetarySubService.add(staffMonetarySub);
			return Msg.success("添加成功").add("data", staffMonetarySub);
		} else {
			return Msg.error();
		}
	}

}

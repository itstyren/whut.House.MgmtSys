package com.computerdesign.whutHouseMgmt.controller.querystatistics;

import java.util.ArrayList;
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
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentVw;
import com.computerdesign.whutHouseMgmt.bean.querystatistics.MoreHouseQueryModel;
import com.computerdesign.whutHouseMgmt.bean.querystatistics.MoreHouseQueryShow;
import com.computerdesign.whutHouseMgmt.bean.querystatistics.MoreHouseResult;
import com.computerdesign.whutHouseMgmt.bean.querystatistics.MoreHouseStaShow;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.Staff;
import com.computerdesign.whutHouseMgmt.service.querystatistics.MoreHouseStaService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.StaffService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping("/moreHouseQuery/")
@Controller
public class MoreHouseQueryController {

	@Autowired
	private MoreHouseStaService moreHouseStaService;

	@Autowired
	private StaffService staffService;

	/**
	 * 多住房统计，根据staffId查询个人的多住房
	 * 
	 * @param moreHouseQueryModel
	 * @param page
	 * @param size
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "staffMoreHouseStaByStaffId/{staffId}", method = RequestMethod.POST)
	public Msg staffMoreHouseStaByStaffId(@PathVariable("staffId") Integer staffId, @RequestBody MoreHouseQueryModel moreHouseQueryModel) {

		List<ResidentVw> residentVws = moreHouseStaService.getMoreHouseByStaffId(staffId, moreHouseQueryModel);
		
		return Msg.success().add("data", residentVws);
	}

	/**
	 * 多住房统计
	 * 
	 * @param moreHouseQueryModel
	 * @param page
	 * @param size
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "staffMoreHouseSta", method = RequestMethod.POST)
	public Msg staffMoreHouseSta(@RequestBody MoreHouseQueryModel moreHouseQueryModel,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {

		// 获取拥有多套住房的职工id的list
		List<Integer> staffIds = moreHouseStaService.getMoreHouseStaffId();
		List<MoreHouseStaShow> moreHouseStaShows = new ArrayList<MoreHouseStaShow>();
		for (Integer staffId : staffIds) {
			List<ResidentVw> residentVws = moreHouseStaService.getMoreHouseByStaffId(staffId, moreHouseQueryModel);
			// Staff staff = staffService.get(staffId);
			MoreHouseStaShow moreHouseStaShow = new MoreHouseStaShow();
			moreHouseStaShow.setStaffId(staffId);
			moreHouseStaShow.setStaffNo(residentVws.get(0).getStaffNo());
			moreHouseStaShow.setStaffName(residentVws.get(0).getStaffName());
			moreHouseStaShow.setStaffTypeName(residentVws.get(0).getStaffTypeName());
			moreHouseStaShow.setStaffSpouseName(residentVws.get(0).getStaffSpouseName());
			moreHouseStaShow.setHouseNum(residentVws.size());
			moreHouseStaShows.add(moreHouseStaShow);
		}

		return Msg.success().add("data", moreHouseStaShows);
	}

	/**
	 * 多住房查询
	 * 
	 * @param moreHouseQueryModel
	 * @param page
	 * @param size
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "staffMoreHouseQuery", method = RequestMethod.POST)
	public Msg staffMoreHouseQuery(@RequestBody MoreHouseQueryModel moreHouseQueryModel,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {

		// 获取拥有多套住房的职工id的list
		List<Integer> staffIds = moreHouseStaService.getMoreHouseStaffId();
		// System.out.println(staffIds);

		PageHelper.startPage(page, size);
		List<ResidentVw> residentVws = moreHouseStaService.staffMoreHouseQuery(staffIds, moreHouseQueryModel);

		List<MoreHouseQueryShow> moreHouseQueryShows = new ArrayList<MoreHouseQueryShow>();
		for (ResidentVw residentVw : residentVws) {
			MoreHouseQueryShow moreHouseQueryShow = new MoreHouseQueryShow();
			moreHouseQueryShow.setStaffNo(residentVw.getStaffNo());
			moreHouseQueryShow.setStaffName(residentVw.getStaffName());
			moreHouseQueryShow.setStaffDeptName(residentVw.getStaffDeptName());
			moreHouseQueryShow.setStaffSpouseName(residentVw.getStaffSpouseName());
			moreHouseQueryShow.setBookTime(residentVw.getBookTime());
			moreHouseQueryShow.setHouseRel(residentVw.getHouseRel());
			moreHouseQueryShow.setAddress(residentVw.getAddress());
			moreHouseQueryShow.setStaffTypeName(residentVw.getStaffTypeName());
			moreHouseQueryShow.setHouseTypeName(residentVw.getHouseTypeName());

			moreHouseQueryShows.add(moreHouseQueryShow);
		}

		PageInfo pageInfo = new PageInfo(moreHouseQueryShows);

		// MoreHouseResult moreHouseResult = new MoreHouseResult();
		// moreHouseResult.setMoreHouseResidentNum(staffIds.size());
		// moreHouseResult.setMoreHouseResidentCount(staffIds.size());
		// moreHouseResult.setOccupyHouseNum(moreHouseQueryShows.size());

		return Msg.success().add("data", pageInfo);
	}

}

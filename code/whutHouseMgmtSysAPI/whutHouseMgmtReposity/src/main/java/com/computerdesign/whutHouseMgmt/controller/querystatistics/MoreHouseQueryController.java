package com.computerdesign.whutHouseMgmt.controller.querystatistics;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentVw;
import com.computerdesign.whutHouseMgmt.bean.querystatistics.MoreHouseQueryModel;
import com.computerdesign.whutHouseMgmt.bean.querystatistics.MoreHouseQueryShow;
import com.computerdesign.whutHouseMgmt.service.querystatistics.MoreHouseStaService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping("/moreHouseQuery/")
@Controller
public class MoreHouseQueryController {

	@Autowired
	private MoreHouseStaService moreHouseStaService;

	/**
	 * 多住房统计
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

		//获取拥有多套住房的职工id的list
		List<Integer> staffIds = moreHouseStaService.getMoreHouseStaffId();
//		System.out.println(staffIds);
		
		PageHelper.startPage(page, size);
		List<ResidentVw> residentVws = moreHouseStaService.staffMoreHouseQuery(staffIds,moreHouseQueryModel);

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

		return Msg.success().add("data", pageInfo);
	}

}

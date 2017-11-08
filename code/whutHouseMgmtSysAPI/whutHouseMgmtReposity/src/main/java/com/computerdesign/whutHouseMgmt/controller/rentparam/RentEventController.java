package com.computerdesign.whutHouseMgmt.controller.rentparam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.computerdesign.whutHouseMgmt.bean.rentparam.RentEvent;
import com.computerdesign.whutHouseMgmt.bean.rentparam.RentEventModel;
import com.computerdesign.whutHouseMgmt.bean.staffparam.StaffParameter;
import com.computerdesign.whutHouseMgmt.service.rentparam.RentEventService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping("/rentEvent/")
@Controller
public class RentEventController {

	@Autowired
	private RentEventService rentEventService;

	@ResponseBody
	@RequestMapping(value = "modify", method = RequestMethod.PUT)
	public Msg modifyRentEvent(@RequestBody RentEvent rentEventModel) {
		RentEvent rentEvent = rentEventService.get(rentEventModel.getRentEventId());
		if (rentEvent != null) {
			rentEventService.update(rentEventModel);
			return Msg.success().add("data", rentEventModel);
		} else {
			return Msg.error();
		}
	}

	@ResponseBody
	@RequestMapping(value = "delete/{rentEventId}", method = RequestMethod.DELETE)
	public Msg deleteRentEvent(@PathVariable Integer rentEventId) {
		RentEvent rentEvent = rentEventService.get(rentEventId);
		if (rentEvent != null) {
			rentEvent.setIsDelete(true);
			rentEventService.update(rentEvent);
			return Msg.success();
		} else {
			return Msg.error("无该数据");
		}

	}

	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Msg addRentEvent(@RequestBody RentEvent rentEventModel) {
		rentEventService.add(rentEventModel);
		return Msg.success().add("data", rentEventModel);
	}

	@ResponseBody
	@RequestMapping("get")
	public Msg getRentEvent(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {
		
		PageHelper.startPage(page, size);
		
		List<RentEvent> rentEvents = rentEventService.getAll();
		List<RentEventModel> rentEventModels = new ArrayList<RentEventModel>();
		for (RentEvent rentEvent : rentEvents){
			String beginDate = null;
			String endDate = null;
			if(rentEvent.getRentTimeBegin() != null){				
				beginDate = new SimpleDateFormat("yyyy-MM-dd").format(rentEvent.getRentTimeBegin());
			}
			if(rentEvent.getRentTimeRanges() != null){				
				endDate = new SimpleDateFormat("yyyy-MM-dd").format(rentEvent.getRentTimeRanges());
			}
//			System.out.println(date);
			RentEventModel rentEventModel = new RentEventModel();
			rentEventModel.setRentEventId(rentEvent.getRentEventId());
			rentEventModel.setParamTypeId(rentEvent.getParamTypeId());
			rentEventModel.setParamTypeName(rentEvent.getParamTypeName());
			rentEventModel.setRentIsOpenSel(rentEvent.getRentIsOpenSel());
			rentEventModel.setRentTimeBegin(beginDate);
			rentEventModel.setRentTimeRanges(endDate);
			rentEventModel.setRentSelRules(rentEvent.getRentSelRules());
			rentEventModel.setIsDelete(rentEvent.getIsDelete());
			rentEventModels.add(rentEventModel);
		}
		
		PageInfo pageInfo = new PageInfo(rentEvents);
		//将封装好的数据设置到pageInfo返回
		pageInfo.setList(rentEventModels);
		if (rentEvents != null) {
			return Msg.success().add("data", pageInfo);
		} else {
			return Msg.error("无数据");
		}
	}

}

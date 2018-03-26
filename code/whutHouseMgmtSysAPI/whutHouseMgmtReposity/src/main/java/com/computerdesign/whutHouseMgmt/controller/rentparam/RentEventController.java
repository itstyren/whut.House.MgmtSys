package com.computerdesign.whutHouseMgmt.controller.rentparam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffSelectHouse;
import com.computerdesign.whutHouseMgmt.bean.rentparam.RentEvent;
import com.computerdesign.whutHouseMgmt.bean.rentparam.RentEventModel;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.Staff;
import com.computerdesign.whutHouseMgmt.bean.staffparam.StaffParameter;
import com.computerdesign.whutHouseMgmt.service.internetselecthouse.StaffSelectHouseService;
import com.computerdesign.whutHouseMgmt.service.rentparam.RentEventService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.StaffService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping("/rentEvent/")
@Controller
public class RentEventController {

	@Autowired
	private RentEventService rentEventService;
	
	@Autowired
	private StaffSelectHouseService staffSelectHouseService;
	
	@Autowired
	private StaffService staffService;

	@ResponseBody
	@RequestMapping(value = "modify", method = RequestMethod.PUT)
	public Msg modifyRentEvent(@RequestBody RentEventModel rentEventModel) {
		RentEvent rentEvent = rentEventService.get(rentEventModel.getRentEventId());
		System.out.println(rentEventModel.getRentTimeBegin());
		if (rentEvent != null) {
			rentEvent.setRentSelValReq(rentEventModel.getRentSelValReq());
			rentEvent.setRentSelRules(rentEventModel.getRentSelRules());
			rentEvent.setRentTimeBegin(rentEventModel.getRentTimeBegin());
			rentEvent.setRentTimeRanges(rentEventModel.getRentTimeRanges());
			rentEventService.update(rentEvent);
			
			//获取设置的选房开始时间以及选房时间
			Date rentTimeBegin = rentEvent.getRentTimeBegin();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(rentTimeBegin);
			
			//创建哈希表key为staffId,值为totalValue
			HashMap<Integer, Double> staffScore = new HashMap<Integer, Double>();
			//获取StaffSelectHouse数据库中所有canselect数据
			List<StaffSelectHouse> staffSelectHouses = staffSelectHouseService.getAll();
			//将数据添加至哈希表
			for (StaffSelectHouse staffSelectHouse2 : staffSelectHouses) {
				Staff staff2 = staffService.get(staffSelectHouse2.getStaffId());
				staffScore.put(staff2.getId(), staff2.getTotalVal());
			}
			//根据职工总分对哈希表排序：键为staffId,值为totalValue
			List<Map.Entry<Integer, Double>> list = new ArrayList<Map.Entry<Integer, Double>>(staffScore.entrySet());
			Collections.sort(list, new Comparator<Map.Entry<Integer, Double>>() {
				// 降序排序
				@Override
				public int compare(java.util.Map.Entry<Integer, Double> o1, java.util.Map.Entry<Integer, Double> o2) {
					return o2.getValue().compareTo(o1.getValue());
				}
			});

//			System.out.println(staffScore);
//			System.out.println(list);
			//遍历排序后的数据，并根据其key值获取StaffSelectHouse对象，同时设置其selectStart及selectEnd值
			for (Map.Entry<Integer, Double> mapping : list) {  
//	            System.out.println(mapping.getKey() + ":" + mapping.getValue()); 
	            StaffSelectHouse staffSelectHouse3 = staffSelectHouseService.getByStaffId(mapping.getKey());
	            //设置选房开始时间
	            staffSelectHouse3.setSelectStart(calendar.getTime());
//	            System.out.println(calendar.get(Calendar.YEAR));
//	            System.out.println(calendar.get(Calendar.MONTH));
//	            System.out.println(calendar.get(Calendar.DATE));
	            //设置选房结束时间
	            calendar.add(Calendar.MINUTE, rentEvent.getRentTimeRanges());
//	            System.out.println(calendar.get(Calendar.HOUR));
//	            System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
//	            System.out.println(calendar.get(Calendar.MINUTE));
	            
	            //创建一个新的日历类，用于保存每个人的选房开始时间，判断是否推迟到下一天
	            Calendar calendar2 = Calendar.getInstance();
	            calendar2.setTime(staffSelectHouse3.getSelectStart());
	            if(calendar.get(Calendar.HOUR_OF_DAY) >= 8 && calendar.get(Calendar.HOUR_OF_DAY) <= 17 && calendar2.get(Calendar.HOUR_OF_DAY) < 17){
	            	staffSelectHouse3.setSelectEnd(calendar.getTime());
	            }else{
	            	int year = calendar.get(Calendar.YEAR);
	            	//选房推迟到第二天早上
	            	calendar.add(Calendar.DATE, 1);
	            	int month = calendar.get(Calendar.MONTH);
	            	int date = calendar.get(Calendar.DATE);
	            	int hour = 8;
	            	calendar.set(year, month, date,hour,0);
	            	staffSelectHouse3.setSelectStart(calendar.getTime());
	            	calendar.add(Calendar.MINUTE, rentEvent.getRentTimeRanges());
	            	staffSelectHouse3.setSelectEnd(calendar.getTime());
	            }
	            staffSelectHouseService.update(staffSelectHouse3);
	        }  
			
			return Msg.success().add("data", rentEventModel);
		} else {
			return Msg.error();
		}
//		return Msg.success().add("data", rentEventModel);
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
	public Msg addRentEvent(@RequestBody RentEventModel rentEventModel) {
		if(rentEventService.getOpenRuleCount() > 0){
			return Msg.error("已有选房规则正在进行，添加失败！");
		}else{
			RentEvent rentEvent = new RentEvent(15, "选房选项", true, false);
			exchange(rentEvent, rentEventModel);
			rentEventService.add(rentEvent);
			
			if (rentEvent != null) {		
				//获取设置的选房开始时间以及选房时间
				Date rentTimeBegin = rentEvent.getRentTimeBegin();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(rentTimeBegin);
				
				//创建哈希表key为staffId,值为totalValue
				HashMap<Integer, Double> staffScore = new HashMap<Integer, Double>();
				//获取StaffSelectHouse数据库中所有canselect数据
				List<StaffSelectHouse> staffSelectHouses = staffSelectHouseService.getAll();
				//将数据添加至哈希表
				for (StaffSelectHouse staffSelectHouse2 : staffSelectHouses) {
					Staff staff2 = staffService.get(staffSelectHouse2.getStaffId());
					staffScore.put(staff2.getId(), staff2.getTotalVal());
				}
				//根据职工总分对哈希表排序：键为staffId,值为totalValue
				List<Map.Entry<Integer, Double>> list = new ArrayList<Map.Entry<Integer, Double>>(staffScore.entrySet());
				Collections.sort(list, new Comparator<Map.Entry<Integer, Double>>() {
					// 降序排序
					@Override
					public int compare(java.util.Map.Entry<Integer, Double> o1, java.util.Map.Entry<Integer, Double> o2) {
						return o2.getValue().compareTo(o1.getValue());
					}
				});

//				System.out.println(staffScore);
//				System.out.println(list);
				//遍历排序后的数据，并根据其key值获取StaffSelectHouse对象，同时设置其selectStart及selectEnd值
				for (Map.Entry<Integer, Double> mapping : list) {  
//		            System.out.println(mapping.getKey() + ":" + mapping.getValue()); 
		            StaffSelectHouse staffSelectHouse3 = staffSelectHouseService.getByStaffId(mapping.getKey());
		            //设置选房开始时间
		            staffSelectHouse3.setSelectStart(calendar.getTime());
		            //设置选房结束时间
		            calendar.add(Calendar.MINUTE, rentEvent.getRentTimeRanges());
		            
		          //创建一个新的日历类，用于保存每个人的选房开始时间，判断是否推迟到下一天
		            Calendar calendar2 = Calendar.getInstance();
		            calendar2.setTime(staffSelectHouse3.getSelectStart());
		            if(calendar.get(Calendar.HOUR_OF_DAY) >= 8 && calendar.get(Calendar.HOUR_OF_DAY) <= 17 && calendar2.get(Calendar.HOUR_OF_DAY) < 17){
		            	staffSelectHouse3.setSelectEnd(calendar.getTime());
		            }else{
		            	int year = calendar.get(Calendar.YEAR);
		            	//选房推迟到第二天早上
		            	calendar.add(Calendar.DATE, 1);
		            	int month = calendar.get(Calendar.MONTH);
		            	int date = calendar.get(Calendar.DATE);
		            	int hour = 8;
		            	calendar.set(year, month, date,hour,0);
		            	staffSelectHouse3.setSelectStart(calendar.getTime());
		            	calendar.add(Calendar.MINUTE, rentEvent.getRentTimeRanges());
		            	staffSelectHouse3.setSelectEnd(calendar.getTime());
		            }
		            staffSelectHouseService.update(staffSelectHouse3);
		        }
			}
			
			return Msg.success().add("data", rentEvent);
		}
		
	}

	public void exchange(RentEvent rentEvent, RentEventModel rentEventModel) {
		rentEvent.setRentSelValReq(rentEventModel.getRentSelValReq());
		rentEvent.setRentSelRules(rentEventModel.getRentSelRules());
		rentEvent.setRentTimeBegin(rentEventModel.getRentTimeBegin());
		rentEvent.setRentTimeRanges(rentEventModel.getRentTimeRanges());
	}

	@ResponseBody
	@RequestMapping("get")
	public Msg getRentEvent(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {

		PageHelper.startPage(page, size);

		List<RentEvent> rentEvents = rentEventService.getAll();
		// 格式化日期后封装在另一个bean的list
		// List<RentEventModel> rentEventModels = dateFormat(rentEvents);
//		 isBegin(rentEvents);
//		List<RentEventModel> rentEventModels = isBegin(rentEvents);
		
		PageInfo pageInfo = new PageInfo(rentEvents);
		// 将封装好的数据设置到pageInfo返回
//		pageInfo.setList(rentEventModels);
		if (rentEvents != null) {
			return Msg.success().add("data", pageInfo);
		} else {
			return Msg.error("无数据");
		}
	}

	// 判断当前日期是否在开始时间和结束时间之间(待修改，选房结束时间需要根据选房人数确定)
	public void isBegin(List<RentEvent> rentEvents) {
//		List<RentEventModel> rentEventModels = new ArrayList<RentEventModel>();
		for (RentEvent rentEvent : rentEvents) {
			// 获取当前时间
			Date now = new Date();
			// System.out.println(now.getTime());
			// 获取开始时间
			Date rentTimeBegin = rentEvent.getRentTimeBegin();
			// System.out.println(rentTimeBegin.getTime());
			
			// 获取结束时间
			//Date rentTimeEnd = rentEvent.getRentTimeRanges();
			// System.out.println(rentTimeEnd.getTime());
			// System.out.println("--------");
			//if (now.getTime() >= rentTimeBegin.getTime() && now.getTime() <= rentTimeEnd.getTime()) {
			if (now.getTime() >= rentTimeBegin.getTime()) {
				rentEvent.setRentIsOpenSel(true);
				// 更新数据库数据
				rentEventService.update(rentEvent);
			}
//			RentEventModel rentEventModel = new RentEventModel();
//			System.out.println(rentEvent.getRentTimeBegin());
//			System.out.println(rentEvent.getRentTimeRanges());
//			rentEventModel.setRentEventId(rentEvent.getRentEventId());
//			rentEventModel.setRentSelRules(rentEvent.getRentSelRules());
//			rentEventModel.setRentSelValReq(rentEvent.getRentSelValReq());
//			rentEventModel.setRentTimeBegin(rentEvent.getRentTimeBegin());
//			rentEventModel.setRentTimeRanges(rentEvent.getRentTimeRanges());
//			rentEventModels.add(rentEventModel);
		}
//		return rentEventModels;
	}

	// //日期格式化: 日期→字符串 并与当前时间进行比较
	// public List<RentEventModel> dateFormat(List<RentEvent> rentEvents){
	// List<RentEventModel> rentEventModels = new ArrayList<RentEventModel>();
	// for (RentEvent rentEvent : rentEvents){
	// //获取当前时间
	// Date now = new Date();
	//// System.out.println(now.getTime());
	// Date rentTimeBegin = rentEvent.getRentTimeBegin();
	// Date rentTimeEnd = rentEvent.getRentTimeRanges();
	// if(now.getTime() >= rentTimeBegin.getTime() && now.getTime() <=
	// rentTimeEnd.getTime()){
	// rentEvent.setRentIsOpenSel(true);
	// //更新数据库数据
	// rentEventService.update(rentEvent);
	// }
	// String beginDate = null;
	// String endDate = null;
	// if(rentTimeBegin != null){
	// beginDate = new SimpleDateFormat("yyyy-MM-dd").format(rentTimeBegin);
	// }
	// if(rentTimeEnd != null){
	// endDate = new SimpleDateFormat("yyyy-MM-dd").format(rentTimeEnd);
	// }
	//// System.out.println(date);
	// RentEventModel rentEventModel = new RentEventModel();
	// rentEventModel.setRentEventId(rentEvent.getRentEventId());
	// rentEventModel.setParamTypeId(rentEvent.getParamTypeId());
	// rentEventModel.setParamTypeName(rentEvent.getParamTypeName());
	// rentEventModel.setRentIsOpenSel(rentEvent.getRentIsOpenSel());
	// rentEventModel.setRentTimeBegin(beginDate);
	// rentEventModel.setRentTimeRanges(endDate);
	// rentEventModel.setRentSelRules(rentEvent.getRentSelRules());
	// rentEventModel.setIsDelete(rentEvent.getIsDelete());
	// rentEventModels.add(rentEventModel);
	// }
	//
	// return rentEventModels;
	// }
	//

}

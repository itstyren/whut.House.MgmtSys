package com.computerdesign.whutHouseMgmt.controller.hire;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.hire.rentgenerate.Rent;
import com.computerdesign.whutHouseMgmt.bean.hire.rentgenerate.RentStaffShowModel;
import com.computerdesign.whutHouseMgmt.bean.hire.rentgenerate.RentTimeRange;
import com.computerdesign.whutHouseMgmt.bean.hire.rentgenerate.RentVw;
import com.computerdesign.whutHouseMgmt.bean.hire.rentgenerate.RentVwShowModel;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.house.ViewHouse;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentVw;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffHouse;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffSelectModel;
import com.computerdesign.whutHouseMgmt.bean.rentalparam.RentalParameter;
import com.computerdesign.whutHouseMgmt.service.hire.RentGenerateService;
import com.computerdesign.whutHouseMgmt.service.houseparam.HouseParamService;
import com.computerdesign.whutHouseMgmt.service.houseregister.ResidentVwService;
import com.computerdesign.whutHouseMgmt.service.rentalparam.RentalParamService;
import com.computerdesign.whutHouseMgmt.utils.Arith;
import com.computerdesign.whutHouseMgmt.utils.MyUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping("/rentGenerate/")
@Controller
public class RentGenerateController {

	@Autowired
	private RentGenerateService rentGenerateService;

	@Autowired
	private HouseParamService houseParamService;
	
	@Autowired
	private ResidentVwService residentVwService;
	
	@Autowired
	private RentalParamService rentalParamService;

	/**
	 * 根据职工号或姓名模糊查询
	 * 
	 * @param conditionValue
	 * @param page
	 * @param size
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "selectRentByStaffNoOrName", method = RequestMethod.GET)
	public Msg selectRentByStaffNoOrName(@RequestParam String conditionValue,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "5") Integer size) {
		try {
			conditionValue = new String(conditionValue.getBytes("8859_1"), "utf8");
			System.out.println(conditionValue);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		PageHelper.startPage(page, size);
		List<StaffHouse> staffHouses = rentGenerateService.selectByNoOrName(conditionValue);
		List<RentStaffShowModel> rentStaffShowModels = new ArrayList<RentStaffShowModel>();
		for (StaffHouse staffHouse : staffHouses) {
			RentStaffShowModel rentStaffShowModel = new RentStaffShowModel();
			rentStaffShowModel.setStaffNo(staffHouse.getStaffNo());
			rentStaffShowModel.setStaffName(staffHouse.getStaffName());
			rentStaffShowModel.setBookTime(staffHouse.getBookTime());
			rentStaffShowModel.setExpireTime(staffHouse.getExpireTime());
			rentStaffShowModel.setJoinTime(staffHouse.getStaffJoinTime());
			rentStaffShowModel.setSex(staffHouse.getStaffSex());
			rentStaffShowModel.setMarriageState(staffHouse.getStaffMarriageState());
			rentStaffShowModel.setTitleName(staffHouse.getStaffTitleName());
			rentStaffShowModel.setPostName(staffHouse.getStaffPostName());
			rentStaffShowModel.setTypeName(staffHouse.getStaffTypeName());
			rentStaffShowModel.setStatusName(staffHouse.getStaffStatusName());
			rentStaffShowModel.setDeptName(staffHouse.getStaffDeptName());
			rentStaffShowModel.setCode(staffHouse.getStaffCode());
			rentStaffShowModel.setFirstJobTime(staffHouse.getStaffFirstJobTime());
			rentStaffShowModel.setRetireTime(staffHouse.getStaffRetireTime());
			rentStaffShowModel.setTel(staffHouse.getStaffTel());
			rentStaffShowModel.setRemark(staffHouse.getStaffRemark());
			rentStaffShowModel.setSpouseName(staffHouse.getStaffSpouseName());
			rentStaffShowModel.setSpouseCode(staffHouse.getStaffSpouseCode());
			rentStaffShowModel.setSpouseTitleName(staffHouse.getStaffSpouseTitleName());
			rentStaffShowModel.setSpousePostName(staffHouse.getStaffSpousePostName());
			rentStaffShowModel.setSpouseDeptName(staffHouse.getStaffSpouseDept());
			rentStaffShowModel.setSpouseKindName(staffHouse.getStaffSpouseKindName());
			rentStaffShowModel.setHouseNo(staffHouse.getHouseNo());
			rentStaffShowModel.setHouseTypeName(staffHouse.getHouseTypeName());
			rentStaffShowModel.setHouseLayoutName(staffHouse.getHouseLayoutName());
			rentStaffShowModel.setHouseStructName(staffHouse.getHouseStructName());
			// 房屋状态
			// rentStaffShowModel.setHouseStatusName(staffHouse.getHouseStatusName());
			rentStaffShowModel.setHouseStatusName(staffHouse.getHouseRelName());
			rentStaffShowModel.setHouseBulidArea(staffHouse.getHouseBuildArea());
			rentStaffShowModel.setHouseUsedArea(staffHouse.getHouseUsedArea());
			rentStaffShowModel.setHouseBasementArea(staffHouse.getHouseBasementArea());
			rentStaffShowModel.setHouseAddress(staffHouse.getHouseAddress());
			rentStaffShowModel.setHouseFinishTime(staffHouse.getHouseFinishTime());
			rentStaffShowModel.setBuildingName(staffHouse.getBuildingName());
			rentStaffShowModels.add(rentStaffShowModel);
		}
		PageInfo pageInfo = new PageInfo(staffHouses);
		pageInfo.setList(rentStaffShowModels);
		return Msg.success().add("data", pageInfo);
	}

	/**
	 * 租金查询 2018.04.25 修改
	 * 
	 * @param rentTimeRange
	 * @param page
	 * @param size
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "queryRent", method = RequestMethod.POST)
	public Msg queryRent(@RequestBody RentTimeRange rentTimeRange,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {
		PageHelper.startPage(page, size);
		List<StaffHouse> staffHouses = rentGenerateService.selectAllRent();
		List<RentVwShowModel> rentVwShowModels = new ArrayList<RentVwShowModel>();
		for (StaffHouse staffHouse : staffHouses) {
			RentVwShowModel rentVwShowModel = new RentVwShowModel();
			// 职工号
			rentVwShowModel.setStaffNo(staffHouse.getStaffNo());
			// // 姓名
			rentVwShowModel.setStaffName(staffHouse.getStaffName());
			// // 住房号
			rentVwShowModel.setHouseNo(staffHouse.getHouseNo());
			// // 地址
			rentVwShowModel.setAddress(staffHouse.getHouseAddress());
			// 缴费方式
			rentVwShowModel.setRentType(staffHouse.getRentType());
			// 入住时间
			rentVwShowModel.setBookTime(staffHouse.getBookTime());
			// 工作部门
			rentVwShowModel.setStaffDeptName(staffHouse.getStaffDeptName());
			
			//缴费方式
			rentVwShowModel.setPayType(staffHouse.getPayType());
			
			double rentMoney = 0.0;
			
			//99年以前入职的使用老的计算方法
			Calendar calendar = Calendar.getInstance();
			calendar.set(1998, 11, 31, 0, 0, 0);
			if(staffHouse.getStaffJoinTime().getTime() < calendar.getTime().getTime()){
				if(rentTimeRange.getStartTime() != null && rentTimeRange.getEndTime() != null){
					rentMoney = oldCalculateRentValue(staffHouse, rentTimeRange.getStartTime(), rentTimeRange.getEndTime());
				}else{
					rentMoney = oldCalculateRentValue(staffHouse, staffHouse.getBookTime(), new Date());
				}
			}else{
//				99年以后入职的使用新的计算方法
				if(rentTimeRange.getStartTime() != null && rentTimeRange.getEndTime() != null){
					rentMoney = calculateRentValue(staffHouse, rentTimeRange.getStartTime(), rentTimeRange.getEndTime());
				}else{
					rentMoney = calculateRentValue(staffHouse, staffHouse.getBookTime(), new Date());
				}	
			}
			
			rentVwShowModel.setRentInitMoney(rentMoney);
			rentVwShowModels.add(rentVwShowModel);
		}
		PageInfo pageInfo = new PageInfo(staffHouses);
		pageInfo.setList(rentVwShowModels);
		return Msg.success().add("data", pageInfo);
	}

//	原来的计算方法
	public double oldCalculateRentValue(StaffHouse staffHouse, Date startTime, Date endTime){
		double rentMoney = 0.0;
		if(startTime != null && endTime != null){
			// 租金
			// 先以预定时间计算，实际应该是签订合同时间
			Calendar c1 = Calendar.getInstance();
			c1.setTime(staffHouse.getBookTime());

			// 开始时间
			Calendar c2 = Calendar.getInstance();
			c2.setTime(startTime);

			// 结束时间
			Calendar c3 = Calendar.getInstance();
			c3.setTime(endTime);

			// 每平方米的租金
			double rentPer = houseParamService.getRentalByStruce(staffHouse.getHouseStruct());

			long days = 0;

			if (c1.getTimeInMillis() <= c2.getTimeInMillis()) {
				// 预定入住时间在查询范围之前，则以查询范围为准
				days = (c3.getTimeInMillis() - c2.getTimeInMillis()) / (1000 * 60 * 60 * 24);
			} else if (c1.getTimeInMillis() < c3.getTimeInMillis()) {
				// 预定入住时间在查询范围之间，则以入住时间到结束时间为准
				days = (c3.getTimeInMillis() - c1.getTimeInMillis()) / (1000 * 60 * 60 * 24);
			} else {
				// 预定入住时间在查询结束时间之后，则该职工无租金

			}
			
			// 每平方米的价格*面积*天数
			rentMoney = Double.parseDouble(new DecimalFormat("#.00")
					.format(Arith.mulVariableParam(rentPer / 30, staffHouse.getHouseBuildArea(), days)));
			
		}else{
			 // 若不传查询时间区间，则显示从入住到当前时间的租金
			 // 预定时间（入住时间先以预定时间为主）
			 Calendar c1 = Calendar.getInstance();
			 c1.setTime(staffHouse.getBookTime());
			
			 // 当前时间
			 Calendar c2 = Calendar.getInstance();
			 c2.setTime(new Date());
			 
			// 每平方米的租金
			double rentPer = houseParamService.getRentalByStruce(staffHouse.getHouseStruct());
			 
			 long days = (c2.getTimeInMillis() - c1.getTimeInMillis()) / (1000 * 60 *
			 60 * 24);
			
			 // 每平方米的价格*面积
			 rentMoney = Double.parseDouble(new DecimalFormat("#.00").format(Arith.mulVariableParam(rentPer / 30, staffHouse.getHouseBuildArea(),days)));
			}
		return rentMoney;
	}
	
	//20190727 新的计算方法
	public double calculateRentValue(StaffHouse staffHouse, Date startTime, Date endTime){
//		职工以前的租赁天数
		long staffOldDays = 0;
		List<ResidentVw> staffResidentVws = residentVwService.getRentHouseByStaffNo(staffHouse.getStaffNo());
		if(staffResidentVws != null){
			for(ResidentVw residentVw : staffResidentVws){
				if(residentVw.getIsDelete()){
					 Calendar c1 = Calendar.getInstance();
					 c1.setTime(residentVw.getBookTime());
					
					 Calendar c2 = Calendar.getInstance();
					 c2.setTime(residentVw.getExpireTime());
					 
					 long oldDay = (c2.getTimeInMillis() - c1.getTimeInMillis()) / (1000 * 60 *
							 60 * 24);
					 staffOldDays += oldDay;
				}
			}
		}
		
		//当前的天数
		long staffNowDays = MyUtils.calculateDays(staffHouse.getBookTime(), endTime);
		
//		查询范围有效天数
		long staffDays = MyUtils.calculateDays(staffHouse.getBookTime(), startTime, endTime);
		
		// 每平方米的租金
		double rentPer = houseParamService.getRentalByStruce(staffHouse.getHouseStruct());
		
		//20190727添加租金新政策
//		获取员工配偶工作单位
		String spouseKind = staffHouse.getStaffSpouseKindName();
//		Staff表的FamilyCode值为int类型
		Integer spouseNo = staffHouse.getStaffSpouseNo();
//		配偶是否是校内
//		boolean isInSchool = spouseKind.equals("校内");
//		配偶是否租房
//		boolean isRentHouse = false;
		
//		获取递增比例及递增年限
		RentalParameter rentalParameter = rentalParamService.getPresentOne().get(0);
//		try {					
//			rentalParameter = rentalParamService.getPresentOne().get(0);
//		} catch (Exception e) {
//			return Msg.error("没有设置可用的租金参数");
//		}
		double rentUpRate = Double.valueOf(rentalParameter.getRentUpRate());
		int limitYear = rentalParameter.getLimitYear();
		
//		租金
		double rentMoney = 0.0;
		
//		如果是校内且租房
//		if(isInSchool && spouseNo != null){
			
//			若配偶有历史租房
			//计算配偶之前租过的天数，配偶现在肯定没有租房
			long spouseDays = 0;
			if (spouseNo != null){
				String no = spouseNo.toString();
				List<ResidentVw> residentVws = residentVwService.getRentHouseByStaffNo(no);
				if(residentVws != null){
					for(ResidentVw residentVw : residentVws){
						if(residentVw.getIsDelete()){
							 long spouseDay = MyUtils.calculateDays(residentVw.getBookTime(), residentVw.getExpireTime());
							 spouseDays += spouseDay;
						}
					}
				}
			}
			
//			没有历史租房则spouseDays值为0（和单身计算相同）
//			获取租赁天数最大值
			long maxDays = Math.max(staffOldDays + staffNowDays, spouseDays + staffNowDays);
			if(maxDays <= 365 * limitYear){
				rentMoney = Double.parseDouble(new DecimalFormat("#.00")
						.format(Arith.mulVariableParam(rentPer / 30, staffHouse.getHouseBuildArea(), staffDays)));
			}else{
				//多出来的天数
				long leftDays = maxDays - 365 * limitYear;
				System.out.println("leftDays:" + leftDays);
//				多出来的天数需要与查询范围的天数进行比较
				if(leftDays < staffDays){
					long leftYear = leftDays / 365;
					long leftLeftDay = leftDays % 365;
//					初始化limitYear之前的租金
					rentMoney = Double.parseDouble(new DecimalFormat("#.00")
							.format(Arith.mulVariableParam(rentPer / 30, staffHouse.getHouseBuildArea(), staffDays - leftDays)));
					for (int i = 0; i < leftYear; i++){
						rentMoney += Double.parseDouble(new DecimalFormat("#.00")
								.format(Arith.mulVariableParam(rentPer / 30, staffHouse.getHouseBuildArea(), 365))) * Math.pow(1.1, i + 1);
					}
					rentMoney += Double.parseDouble(new DecimalFormat("#.00")
							.format(Arith.mulVariableParam(rentPer / 30, staffHouse.getHouseBuildArea(), leftLeftDay))) * Math.pow(1.1, leftYear + 1);
				}else{
					long leftYear = leftDays / 365;
					long leftLeftDay = leftDays % 365;
					//总的租金
					for (int i = 0; i < leftYear; i++){
						rentMoney += Double.parseDouble(new DecimalFormat("#.00")
								.format(Arith.mulVariableParam(rentPer / 30, staffHouse.getHouseBuildArea(), 365))) * Math.pow(1.1, i + 1);
					}
					rentMoney += Double.parseDouble(new DecimalFormat("#.00")
							.format(Arith.mulVariableParam(rentPer / 30, staffHouse.getHouseBuildArea(), leftLeftDay))) * Math.pow(1.1, leftYear + 1);
					//空挡距离租金（空挡距离是指leftDays与staffDays的差） 查询租金 = 总租金 - 空挡距离租金
					long disDays = leftDays - staffDays;
					long disYear = disDays / 365;
					long disLeft = disDays % 365;
					for (int i = 0; i < disYear; i++){
						rentMoney -= Double.parseDouble(new DecimalFormat("#.00")
								.format(Arith.mulVariableParam(rentPer / 30, staffHouse.getHouseBuildArea(), 365))) * Math.pow(1.1, i + 1);
					}
					rentMoney -= Double.parseDouble(new DecimalFormat("#.00")
							.format(Arith.mulVariableParam(rentPer / 30, staffHouse.getHouseBuildArea(), disLeft))) * Math.pow(1.1, leftYear + 1);
				}
				
			}
			/*
			else{
				//判断员工个人是否满5年
				if(staffDays <= 365 * limitYear){
					rentMoney = Double.parseDouble(new DecimalFormat("#.00")
							.format(Arith.mulVariableParam(rentPer / 30, staffHouse.getHouseBuildArea(), staffDays)));
				}else{
					//多出来的天数
					long leftDays = staffDays - 365 * limitYear;
					
				}
			}
			*/
//		}
		System.out.println(staffHouse.getStaffName());
		System.out.println(rentPer / 30);
		System.out.println(staffHouse.getHouseBuildArea());
//		System.out.println(staffHouse.getStaffNo());
//		System.out.println(staffHouse.getBookTime());
		System.out.println("staffDays:" + staffDays);
		System.out.println();
		System.out.println("staffOldDays:" + staffOldDays);
		System.out.println("staffNowDays:" + staffNowDays);
		System.out.println(spouseDays);
		return rentMoney;
	}
	
	/**
	 * 租金查询
	 * 
	 * @param rentTimeRange
	 * @param page
	 * @param size
	 * @return
	 */
	// @ResponseBody
	// @RequestMapping(value = "queryRent", method = RequestMethod.POST)
	// public Msg queryRent(@RequestBody RentTimeRange rentTimeRange,
	// @RequestParam(value = "page", defaultValue = "1") Integer page,
	// @RequestParam(value = "size", defaultValue = "10") Integer size) {
	// if (rentTimeRange == null) {
	// return Msg.error("请选择查询的时间范围");
	// }
	// PageHelper.startPage(page, size);
	// List<RentVw> rentVws = rentGenerateService.queryRent(rentTimeRange);
	// List<RentVwShowModel> rentVwShowModels = new
	// ArrayList<RentVwShowModel>();
	// for (RentVw rentVw : rentVws) {
	// RentVwShowModel rentVwShowModel = new RentVwShowModel();
	// // 职工号
	// rentVwShowModel.setStaffNo(rentVw.getStaffNo());
	// // 姓名
	// rentVwShowModel.setStaffName(rentVw.getStaffName());
	// // 住房号
	// rentVwShowModel.setHouseNo(rentVw.getHouseNo());
	// // 地址
	// rentVwShowModel.setAddress(rentVw.getAddress());
	// // 开始时间
	// rentVwShowModel.setRentBeginTime(rentVw.getRentBeginTime());
	// // 结束时间
	// rentVwShowModel.setRentEndTime(rentVw.getRentEndTime());
	// // 缴费方式
	// rentVwShowModel.setRentType(rentVw.getRentType());
	// // 原始租金
	// rentVwShowModel.setRentInitMoney(rentVw.getRentInitMoney());
	// // 租金
	// // rentVwShowModel.setRentMoney(rentVw.getRentMoney());
	//
	// // 修改 2018.04.25，并且将显示RentMoney改为显示RentInitMoney
	// // 每平方米的价格（按月）
	// double rentPer =
	// houseParamService.getRentalByStruce(rentVw.getHouseStructId());
	//
	// // 判断查询时间一共有多少天
	// // 预定时间
	// Calendar c1 = Calendar.getInstance();
	// c1.setTime(rentVw.getBookTime());
	//
	// // 当前时间
	// Calendar c2 = Calendar.getInstance();
	// c2.setTime(new Date());
	//
	// long days = (c2.getTimeInMillis() - c1.getTimeInMillis()) / (1000 * 60 *
	// 60 * 24);
	//
	// // 每平方米的价格*面积
	// rentVwShowModel.setRentInitMoney(Double.parseDouble(new
	// DecimalFormat("#.00")
	// .format(Arith.mulVariableParam(rentPer / 30, rentVw.getHouseBuildArea(),
	// days))));
	// // 优惠比例
	// rentVwShowModel.setRentDiscountRate(rentVw.getRentDiscountRate());
	// // 是否结算
	// // 入住时间
	// rentVwShowModel.setBookTime(rentVw.getBookTime());
	// // 到期时间
	// rentVwShowModel.setExpireTime(rentVw.getExpireTime());
	// // 工作部门
	// rentVwShowModel.setStaffDeptName(rentVw.getStaffDeptName());
	// rentVwShowModels.add(rentVwShowModel);
	// }
	// PageInfo pageInfo = new PageInfo(rentVws);
	// pageInfo.setList(rentVwShowModels);
	// return Msg.success().add("data", pageInfo);
	// }

	/**
	 * 租金生成
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "rentGen", method = RequestMethod.POST)
	public Msg rentGenerate(@RequestBody String[] houseNos) {
		// 根据多条件查询获取
		// List<StaffHouse> staffHouses =
		// rentGenerateService.selectRentByMultiCondition(staffSelectModel);
		// 根据houseId数组获取
		List<StaffHouse> staffHouses = new ArrayList<StaffHouse>();
		for (String houseNo : houseNos) {
			StaffHouse staffHouse = rentGenerateService.getByHouseNo(houseNo);
			if (staffHouse != null) {
				staffHouses.add(staffHouse);
			}
		}

		// 获取所有租赁信息，使用contains判断是否重复插入
		List<Rent> rents = rentGenerateService.getAllRent();

		for (StaffHouse staffHouse : staffHouses) {
			Rent rent = new Rent();
			rent.setResidentId(staffHouse.getResidentId());
			rent.setRentType(staffHouse.getRentType());
			rent.setInitMoney(staffHouse.getHouseRental());
			if (staffHouse.getStaffDiscountRate() != null) {
				rent.setDiscountRate(staffHouse.getStaffDiscountRate().toString());
				rent.setRentMoney(rent.getInitMoney() * (staffHouse.getStaffDiscountRate() / 100));
			}
			rent.setIsGet((byte) 0);

			// rent.setBeginTime(staffHouse.getLastRentTime());
			// 修改为预定时间 2018.4.25
			rent.setBeginTime(staffHouse.getBookTime());
			// 计算并设置结束时间
			if (rent.getBeginTime() != null) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(rent.getBeginTime());
				calendar.add(Calendar.MONTH, 1);
				rent.setEndTime(calendar.getTime());
			}
			rent.setEmploymentDate(staffHouse.getStaffJoinTime());
			if (!rents.contains(rent)) {
				rentGenerateService.rentGenerate(rent);
			}
		}
		return Msg.success();
	}

	/**
	 * 多条件查询
	 * 
	 * @param staffSelectModel
	 * @param page
	 * @param size
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "selectRentByMultiCondition", method = RequestMethod.POST)
	public Msg selectRentByMultiCondition(@RequestBody StaffSelectModel staffSelectModel,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "5") Integer size) {
		PageHelper.startPage(page, size);
		List<StaffHouse> staffHouses = rentGenerateService.selectRentByMultiCondition(staffSelectModel);
		List<RentStaffShowModel> rentStaffShowModels = new ArrayList<RentStaffShowModel>();
		for (StaffHouse staffHouse : staffHouses) {
			RentStaffShowModel rentStaffShowModel = new RentStaffShowModel();
			rentStaffShowModel.setStaffNo(staffHouse.getStaffNo());
			rentStaffShowModel.setStaffName(staffHouse.getStaffName());
			rentStaffShowModel.setBookTime(staffHouse.getBookTime());
			rentStaffShowModel.setExpireTime(staffHouse.getExpireTime());
			rentStaffShowModel.setJoinTime(staffHouse.getStaffJoinTime());
			rentStaffShowModel.setSex(staffHouse.getStaffSex());
			rentStaffShowModel.setMarriageState(staffHouse.getStaffMarriageState());
			rentStaffShowModel.setTitleName(staffHouse.getStaffTitleName());
			rentStaffShowModel.setPostName(staffHouse.getStaffPostName());
			rentStaffShowModel.setTypeName(staffHouse.getStaffTypeName());
			rentStaffShowModel.setStatusName(staffHouse.getStaffStatusName());
			rentStaffShowModel.setDeptName(staffHouse.getStaffDeptName());
			rentStaffShowModel.setCode(staffHouse.getStaffCode());
			rentStaffShowModel.setFirstJobTime(staffHouse.getStaffFirstJobTime());
			rentStaffShowModel.setRetireTime(staffHouse.getStaffRetireTime());
			rentStaffShowModel.setTel(staffHouse.getStaffTel());
			rentStaffShowModel.setRemark(staffHouse.getStaffRemark());
			rentStaffShowModel.setSpouseName(staffHouse.getStaffSpouseName());
			rentStaffShowModel.setSpouseCode(staffHouse.getStaffSpouseCode());
			rentStaffShowModel.setSpouseTitleName(staffHouse.getStaffSpouseTitleName());
			rentStaffShowModel.setSpousePostName(staffHouse.getStaffSpousePostName());
			rentStaffShowModel.setSpouseDeptName(staffHouse.getStaffSpouseDept());
			rentStaffShowModel.setSpouseKindName(staffHouse.getStaffSpouseKindName());
			rentStaffShowModel.setHouseNo(staffHouse.getHouseNo());
			rentStaffShowModel.setHouseTypeName(staffHouse.getHouseTypeName());
			rentStaffShowModel.setHouseLayoutName(staffHouse.getHouseLayoutName());
			rentStaffShowModel.setHouseStructName(staffHouse.getHouseStructName());
			// 房屋状态
			// rentStaffShowModel.setHouseStatusName(staffHouse.getHouseStatusName());
			rentStaffShowModel.setHouseStatusName(staffHouse.getHouseRelName());
			rentStaffShowModel.setHouseBulidArea(staffHouse.getHouseBuildArea());
			rentStaffShowModel.setHouseUsedArea(staffHouse.getHouseUsedArea());
			rentStaffShowModel.setHouseBasementArea(staffHouse.getHouseBasementArea());
			rentStaffShowModel.setHouseAddress(staffHouse.getHouseAddress());
			rentStaffShowModel.setHouseFinishTime(staffHouse.getHouseFinishTime());
			rentStaffShowModel.setBuildingName(staffHouse.getBuildingName());
			rentStaffShowModels.add(rentStaffShowModel);
		}
		PageInfo pageInfo = new PageInfo(staffHouses);
		pageInfo.setList(rentStaffShowModels);
		return Msg.success().add("data", pageInfo);
	}

}

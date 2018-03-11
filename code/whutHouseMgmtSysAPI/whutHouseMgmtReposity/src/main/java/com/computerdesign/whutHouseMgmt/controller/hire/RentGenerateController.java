package com.computerdesign.whutHouseMgmt.controller.hire;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
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
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffHouse;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffSelectModel;
import com.computerdesign.whutHouseMgmt.service.hire.RentGenerateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping("/rentGenerate/")
@Controller
public class RentGenerateController {

	@Autowired
	private RentGenerateService rentGenerateService;

	/**
	 * 根据职工号或姓名模糊查询
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
			rentStaffShowModel.setGoUniversityTime(staffHouse.getStaffGoUniversityTime());
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
			//房屋状态
//			rentStaffShowModel.setHouseStatusName(staffHouse.getHouseStatusName());
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
	 * 租金查询
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
		if(rentTimeRange == null){
			return Msg.error("请选择查询的时间范围");
		}
		PageHelper.startPage(page, size);
		List<RentVw> rentVws = rentGenerateService.queryRent(rentTimeRange);
		List<RentVwShowModel> rentVwShowModels = new ArrayList<RentVwShowModel>();
		for(RentVw rentVw : rentVws){
			RentVwShowModel rentVwShowModel = new RentVwShowModel();
			//职工号
			rentVwShowModel.setStaffNo(rentVw.getStaffNo());
			//姓名
			rentVwShowModel.setStaffName(rentVw.getStaffName());
			//住房号
			rentVwShowModel.setHouseNo(rentVw.getHouseNo());
			//地址
			rentVwShowModel.setAddress(rentVw.getAddress());
			//开始时间
			rentVwShowModel.setRentBeginTime(rentVw.getRentBeginTime());
			//结束时间
			rentVwShowModel.setRentEndTime(rentVw.getRentEndTime());
			//缴费方式
			rentVwShowModel.setRentType(rentVw.getRentType());
			//原始租金
			rentVwShowModel.setRentInitMoney(rentVw.getRentInitMoney());
			//租金
			rentVwShowModel.setRentMoney(rentVw.getRentMoney());
			//优惠比例
			rentVwShowModel.setRentDiscountRate(rentVw.getRentDiscountRate());
			//是否结算
			//入住时间
			rentVwShowModel.setBookTime(rentVw.getBookTime());
			//到期时间
			rentVwShowModel.setExpireTime(rentVw.getExpireTime());
			rentVwShowModels.add(rentVwShowModel);
		}
		PageInfo pageInfo = new PageInfo(rentVws);
		return Msg.success().add("data", pageInfo);
	}

	/**
	 * 租金生成
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "rentGen", method = RequestMethod.POST)
	public Msg rentGenerate(@RequestBody int[] houseIds) {
		//根据多条件查询获取
//		List<StaffHouse> staffHouses = rentGenerateService.selectRentByMultiCondition(staffSelectModel);
		//根据houseId数组获取
		List<StaffHouse> staffHouses = new ArrayList<StaffHouse>();
		for (int houseId : houseIds){
			StaffHouse staffHouse = rentGenerateService.getByHouseId(houseId);
			staffHouses.add(staffHouse);
		}
		
		for (StaffHouse staffHouse : staffHouses) {
			Rent rent = new Rent();
			rent.setResidentId(staffHouse.getResidentId());
			rent.setRentType(staffHouse.getRentType());
			rent.setInitMoney(staffHouse.getHouseRental());
			if(staffHouse.getStaffDiscountRate() != null){				
				rent.setDiscountRate(staffHouse.getStaffDiscountRate().toString());
				rent.setRentMoney(rent.getInitMoney() * (staffHouse.getStaffDiscountRate() / 100));
			}
			rent.setIsGet((byte) 0);
			rent.setBeginTime(staffHouse.getLastRentTime());
			// 计算并设置结束时间
			if (rent.getBeginTime() != null) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(rent.getBeginTime());
				calendar.add(Calendar.MONTH, 1);
				rent.setEndTime(calendar.getTime());
			}
			rent.setEmploymentDate(staffHouse.getStaffJoinTime());
			rentGenerateService.rentGenerate(rent);
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
			rentStaffShowModel.setGoUniversityTime(staffHouse.getStaffGoUniversityTime());
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
			//房屋状态
//			rentStaffShowModel.setHouseStatusName(staffHouse.getHouseStatusName());
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

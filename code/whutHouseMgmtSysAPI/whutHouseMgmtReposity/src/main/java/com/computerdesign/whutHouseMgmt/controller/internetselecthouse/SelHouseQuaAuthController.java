package com.computerdesign.whutHouseMgmt.controller.internetselecthouse;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.poifs.filesystem.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.house.ViewHouse;
import com.computerdesign.whutHouseMgmt.bean.houseregister.HouseAllSelectModel;
import com.computerdesign.whutHouseMgmt.bean.houseregister.HouseSelectModel;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffHouse;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffSelectByNoAndNameModel;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffSelectHouse;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffSelectModel;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffShowModel;
import com.computerdesign.whutHouseMgmt.bean.rentparam.RentEvent;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.Staff;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffVw;
import com.computerdesign.whutHouseMgmt.service.internetselecthouse.HousingSetService;
import com.computerdesign.whutHouseMgmt.service.internetselecthouse.SelHouseQuaAuthService;
import com.computerdesign.whutHouseMgmt.service.internetselecthouse.StaffSelectHouseService;
import com.computerdesign.whutHouseMgmt.service.rentparam.RentEventService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.StaffService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping(value = "/selHouseQuaAuth/")
@Controller
public class SelHouseQuaAuthController {

	@Autowired
	private SelHouseQuaAuthService selHouseQuaAuthService;

	@Autowired
	private StaffService staffService;

	@Autowired
	private RentEventService rentEventService;

	@Autowired
	private StaffSelectHouseService staffSelectHouseService;

	/**
	 * 根据职工号或职工姓名模糊查找
	 * 
	 * @param staffSelectByNoAndNameModel
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "selectByNoOrName", method = RequestMethod.GET)
	public Msg selectByNoOrName(@RequestParam String conditionValue) {
		List<StaffHouse> staffHouses = new ArrayList<StaffHouse>();
		// String conditionName =
		// staffSelectByNoAndNameModel.getConditionName();
		// String conditionValue =
		// staffSelectByNoAndNameModel.getConditionValue();
		try {
			conditionValue = new String(conditionValue.getBytes("8859_1"), "utf8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (conditionValue != null) {
			staffHouses = selHouseQuaAuthService.selectByNoOrName(conditionValue);
		}
		List<StaffShowModel> staffShowModels = new ArrayList<StaffShowModel>();
		if (staffHouses != null) {
			// System.out.println(staffSelectModel.getDept());
			setShowModelField(staffHouses, staffShowModels);
		}
		return Msg.success().add("data", staffShowModels);
	}

	/**
	 * 撤销职工可点房
	 * 
	 * @param staffNos
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "cancelCanselect", method = RequestMethod.POST)
	public Msg cancelCanselect(@RequestBody String[] staffNos) {
		for (String staffNo : staffNos) {
			Staff staff = staffService.getByStaffNo(staffNo).get(0);
			staff.setRelation("active");
			staffService.update(staff);
			
			//设置StaffSelectHouse数据库中RecordStatus字段
			StaffSelectHouse staffSelectHouse = staffSelectHouseService.getByStaffId(staff.getId());
			staffSelectHouse.setRecordStatus("inactive");
			staffSelectHouseService.update(staffSelectHouse);
		}
		return Msg.success("撤销点房职工设置成功");
	}

	/**
	 * 将职工设为可点房
	 * 
	 * @param staffNos
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "setCanselect", method = RequestMethod.POST)
	public Msg setCanselect(@RequestBody String[] staffNos) {
		for (String staffNo : staffNos) {
			Staff staff = staffService.getByStaffNo(staffNo).get(0);
			staff.setRelation("canselect");
			staffService.update(staff);

			// StaffSelectHouse staffSelectHouse = new StaffSelectHouse();
			// staffSelectHouse.setStaffId(staff.getId());

			//获取设置的选房开始时间以及选房时间
			RentEvent rentEvent = rentEventService.get(1);
			Date rentTimeBegin = rentEvent.getRentTimeBegin();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(rentTimeBegin);


			// 给StaffSelectHouse设置数据并插入数据库
			StaffSelectHouse staffSelectHouse = new StaffSelectHouse();
			staffSelectHouse.setStaffId(staff.getId());
			staffSelectHouse.setRecordStatus("canselect");
			staffSelectHouse.setCreateDate(new Date());
			staffSelectHouseService.insert(staffSelectHouse);
			
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
	            //设置选房结束时间
	            calendar.add(Calendar.MINUTE, rentEvent.getRentTimeRanges());
	            staffSelectHouse3.setSelectEnd(calendar.getTime());
	            staffSelectHouseService.update(staffSelectHouse3);
	        }  

		}
		return Msg.success("设置点房职工成功");
	}

	/**
	 * 初始显示已设置选房职工
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "canselectShow", method = RequestMethod.GET)
	public Msg canselectShow(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {
		PageHelper.startPage(page, size);
		List<StaffHouse> staffHouses = selHouseQuaAuthService.canselectShow();
		List<StaffShowModel> staffShowModels = new ArrayList<StaffShowModel>();
		setShowModelField(staffHouses, staffShowModels);

		PageInfo pageInfo = new PageInfo(staffHouses);
		pageInfo.setList(staffShowModels);
		return Msg.success().add("data", pageInfo);
	}

	/**
	 * 初始显示未设置选房职工
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "activeShow", method = RequestMethod.GET)
	public Msg activeShow(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {
		PageHelper.startPage(page, size);
		List<StaffHouse> staffHouses = selHouseQuaAuthService.activeShow();
		List<StaffShowModel> staffShowModels = new ArrayList<StaffShowModel>();
		setShowModelField(staffHouses, staffShowModels);

		PageInfo pageInfo = new PageInfo(staffHouses);
		pageInfo.setList(staffShowModels);
		return Msg.success().add("data", pageInfo);
	}

	/**
	 * 多条件查询未设置选房资格的职工，用于选房资格认定
	 * 
	 * @param staffSelectModel
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "selectActiveStaffMultiCondition", method = RequestMethod.POST)
	public Msg selectActiveStaffMultiCondition(@RequestBody StaffSelectModel staffSelectModel,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {
		PageHelper.startPage(page, size);
		List<StaffHouse> staffHouses = selHouseQuaAuthService.selectActiveStaffMultiCondition(staffSelectModel);
		List<StaffShowModel> staffShowModels = new ArrayList<StaffShowModel>();
		if (staffSelectModel != null) {
			// System.out.println(staffSelectModel.getDept());
			setShowModelField(staffHouses, staffShowModels);
		}
		PageInfo pageInfo = new PageInfo(staffHouses);
		pageInfo.setList(staffShowModels);

		return Msg.success().add("data", pageInfo);
	}

	/**
	 * 多条件查询已设置选房资格的职工，用于选房资格认定
	 * 
	 * @param staffSelectModel
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "selectCanselectStaffMultiCondition", method = RequestMethod.POST)
	public Msg selectCanselectStaffMultiCondition(@RequestBody StaffSelectModel staffSelectModel,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {
		PageHelper.startPage(page, size);
		List<StaffHouse> staffHouses = selHouseQuaAuthService.selectCanselectStaffMultiCondition(staffSelectModel);
		List<StaffShowModel> staffShowModels = new ArrayList<StaffShowModel>();
		if (staffSelectModel != null) {
			// System.out.println(staffSelectModel.getDept());
			setShowModelField(staffHouses, staffShowModels);
		}
		PageInfo pageInfo = new PageInfo(staffHouses);
		pageInfo.setList(staffShowModels);

		return Msg.success().add("data", pageInfo);
	}

	/**
	 * 设置需要显示的类的字段
	 * 
	 * @param staffHouses
	 * @param staffShowModels
	 */
	public void setShowModelField(List<StaffHouse> staffHouses, List<StaffShowModel> staffShowModels) {
		for (StaffHouse staffHouse : staffHouses) {
			StaffShowModel staffShowModel = new StaffShowModel();
			staffShowModel.setStaffNo(staffHouse.getStaffNo());
			staffShowModel.setStaffName(staffHouse.getStaffName());
			staffShowModel.setStaffTitleVal(staffHouse.getStaffTitleVal());
			staffShowModel.setStaffSpouseTitleVal(staffHouse.getStaffSpouseTitleVal());
			staffShowModel.setTimeVal(staffHouse.getTimeVal());
			staffShowModel.setOtherVal(staffHouse.getOtherVal());
			staffShowModel.setTotalVal(staffHouse.getTotalVal());
			staffShowModel.setSex(staffHouse.getStaffSex());
			staffShowModel.setMarriageState(staffHouse.getStaffMarriageState());
			staffShowModel.setTitleName(staffHouse.getStaffTitleName());
			staffShowModel.setPostName(staffHouse.getStaffPostName());
			staffShowModel.setTypeName(staffHouse.getStaffTypeName());
			staffShowModel.setStatusName(staffHouse.getStaffStatusName());
			staffShowModel.setDeptName(staffHouse.getStaffDeptName());
			staffShowModel.setCode(staffHouse.getStaffCode());
			staffShowModel.setJoinTime(staffHouse.getStaffJoinTime());
			staffShowModel.setGoUniversityTime(staffHouse.getStaffGoUniversityTime());
			staffShowModel.setRetireTime(staffHouse.getStaffRetireTime());
			staffShowModel.setTel(staffHouse.getStaffTel());
			staffShowModel.setRemark(staffHouse.getStaffRemark());
			staffShowModel.setSpouseName(staffHouse.getStaffSpouseName());
			staffShowModel.setSpouseCode(staffHouse.getStaffSpouseCode());
			staffShowModel.setSpouseTitleName(staffHouse.getStaffSpouseTitleName());
			staffShowModel.setSpousePostName(staffHouse.getStaffSpousePostName());
			staffShowModel.setSpouseDeptName(staffHouse.getStaffSpouseDept());
			staffShowModel.setSpouseKindName(staffHouse.getStaffSpouseKindName());
			staffShowModel.setHouseNo(staffHouse.getHouseNo());
			staffShowModel.setHouseTypeName(staffHouse.getHouseTypeName());
			staffShowModel.setHouseLayoutName(staffHouse.getHouseLayoutName());
			staffShowModel.setHouseStructName(staffHouse.getHouseStructName());
			staffShowModel.setHouseStatusName(staffHouse.getHouseStatusName());
			staffShowModel.setHouseBulidArea(staffHouse.getHouseBuildArea());
			staffShowModel.setHouseUsedArea(staffHouse.getHouseUsedArea());
			staffShowModel.setHouseBasementArea(staffHouse.getHouseBasementArea());
			staffShowModel.setHouseAddress(staffHouse.getHouseAddress());
			staffShowModel.setHouseFinishTime(staffHouse.getHouseFinishTime());
			staffShowModel.setBuildingName(staffHouse.getBuildingName());
			staffShowModels.add(staffShowModel);
		}
	}

}

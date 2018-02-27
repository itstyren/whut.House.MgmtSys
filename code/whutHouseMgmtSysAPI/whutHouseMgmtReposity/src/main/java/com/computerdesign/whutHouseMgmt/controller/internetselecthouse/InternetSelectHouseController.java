package com.computerdesign.whutHouseMgmt.controller.internetselecthouse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffHouse;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffSelectModel;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffShowModel;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.Staff;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffVw;
import com.computerdesign.whutHouseMgmt.service.internetselecthouse.SelHouseQuaAuthService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.StaffService;

@RequestMapping(value = "/internetSelectHouse/")
@Controller
public class InternetSelectHouseController {

	@Autowired
	private SelHouseQuaAuthService selHouseQuaAuthService;
	
	@Autowired
	private StaffService staffService;
	
	/**
	 * 撤销职工可点房
	 * @param staffNos
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "cancelCanselect", method = RequestMethod.POST)
	public Msg cancelCanselect(@RequestBody String[] staffNos){
		for (String staffNo : staffNos){
			Staff staff = staffService.getByStaffNo(staffNo).get(0);
			staff.setRelation("active");
			staffService.update(staff);
		}
		return Msg.success("撤销点房职工设置成功");
	}
	
	/**
	 * 将职工设为可点房
	 * @param staffNos
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "setCanselect", method = RequestMethod.POST)
	public Msg setCanselect(@RequestBody String[] staffNos){
		for (String staffNo : staffNos){
			Staff staff = staffService.getByStaffNo(staffNo).get(0);
			staff.setRelation("canselect");
			staffService.update(staff);
		}
		return Msg.success("设置点房职工成功");
	}
	
	/**
	 * 初始显示已设置选房职工
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "canselectShow", method = RequestMethod.GET)
	public Msg canselectShow(){
		List<StaffHouse> staffHouses = selHouseQuaAuthService.canselectShow();
		List<StaffShowModel> staffShowModels = new ArrayList<StaffShowModel>();
		for (StaffHouse staffHouse : staffHouses){
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
		return Msg.success().add("data", staffShowModels);
	}
	
	/**
	 * 初始显示未设置选房职工
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "activeShow", method = RequestMethod.GET)
	public Msg activeShow(){
		List<StaffHouse> staffHouses = selHouseQuaAuthService.activeShow();
		List<StaffShowModel> staffShowModels = new ArrayList<StaffShowModel>();
		setShowModelField(staffHouses, staffShowModels);
		return Msg.success().add("data", staffShowModels);
	}
	
	/**
	 * 多条件查询职工，用于选房资格认定
	 * @param staffSelectModel
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "selectStaffMultiCondition", method = RequestMethod.POST)
	public Msg selectStaffMultiCondition(@RequestBody StaffSelectModel staffSelectModel) {
		List<StaffHouse> staffHouses = new ArrayList<StaffHouse>();
		staffHouses = selHouseQuaAuthService.selectStaffMultiCondition(staffSelectModel);
		List<StaffShowModel> staffShowModels = new ArrayList<StaffShowModel>();
		if (staffSelectModel != null) {
//			System.out.println(staffSelectModel.getDept());
			setShowModelField(staffHouses, staffShowModels);
		}
		return Msg.success().add("data", staffShowModels);
	}

	/**
	 * 设置需要显示的类的字段
	 * @param staffHouses
	 * @param staffShowModels
	 */
	public void setShowModelField(List<StaffHouse> staffHouses,List<StaffShowModel> staffShowModels){
		for (StaffHouse staffHouse : staffHouses){
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
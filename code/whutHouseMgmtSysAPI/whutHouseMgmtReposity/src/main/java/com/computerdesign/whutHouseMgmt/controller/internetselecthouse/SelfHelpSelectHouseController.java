package com.computerdesign.whutHouseMgmt.controller.internetselecthouse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.hire.Hire;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.SelfHelpSelectHouse;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.SelfHelpStaffCanselectShowModel;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.Staff;
import com.computerdesign.whutHouseMgmt.service.hire.HireService;
import com.computerdesign.whutHouseMgmt.service.internetselecthouse.SelfHelpSelectHouseService;
import com.computerdesign.whutHouseMgmt.service.internetselecthouse.StaffSelectHouseService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.StaffService;
import com.computerdesign.whutHouseMgmt.service.staffparam.StaffParameterService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping(value = "/selfHelpSelectHouse/")
@Controller
public class SelfHelpSelectHouseController {

	@Autowired
	private SelfHelpSelectHouseService selfHelpSelectHouseService;

	@Autowired
	private HireService hireService;
	
	@Autowired
	private StaffService staffService;
	
	@Autowired
	private StaffParameterService staffParameterService;
	
	@Autowired
	private StaffSelectHouseService staffSelectHouseService;
	
	/**
	 * 提交自助选房申请
	 * @param staffId
	 * @param houseId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "submitSelectHouseApplication", method = RequestMethod.GET)
	public Msg submitSelectHouseApplication(@RequestParam(value = "staffId") Integer staffId,
			@RequestParam(value = "houseId") Integer houseId){
		Date date = new Date();
		long currentTime = date.getTime();
		long selectStart = staffSelectHouseService.getByStaffId(staffId).getSelectStart().getTime();
		long selectEnd = staffSelectHouseService.getByStaffId(staffId).getSelectEnd().getTime();
//		System.out.println("currentTime" + currentTime);
//		System.out.println("selectStart" + selectStart);
//		System.out.println("selectEnd" + selectEnd);
		if(currentTime > selectStart && currentTime < selectEnd){
			Hire hire = new Hire();
			Staff staff = staffService.get(staffId);
			hire.setStaffId(staffId);
			hire.setHouseId(houseId);
			hire.setApplyTime(new Date());
			hire.setReason("自助点房");
			hire.setPhone(staff.getTel());
			hire.setHireState("待审批");
			hire.setStaffVal(staff.getTotalVal());
			hire.setJobLevelVal((double)staffParameterService.get(staff.getTitle()).getStaffParamVal());
			hire.setTimeVal(staff.getTimeVal());
			hire.setMultiVal(0.0);
			hire.setOtherVal(staff.getOtherVal());
			hire.setAcceptNote("自助点房自动受理");
			hire.setAcceptState("通过");
			hire.setAcceptTime(new Date());
			hire.setAgreeNote("自助点房自动审核");
			hire.setAgreeState("通过");
			hire.setAgreeTime(new Date());
			hire.setIsOver(false);
			hireService.add(hire);
			return Msg.success("提交成功").add("data", hire);
		}else{
			return Msg.error("您的点房时间已到");
		}
		
		
	}
	
	/**
	 * 显示所有未选房职工
	 * @param page
	 * @param size
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getAllCanselectHouse", method = RequestMethod.GET)
	public Msg getAllCanselectHouse(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {
		PageHelper.startPage(page, size);
		List<SelfHelpSelectHouse> selfHelpSelectHouses = selfHelpSelectHouseService.getAllCanselectHouse();
		List<SelfHelpStaffCanselectShowModel> selfHelpStaffCanselectShowModels = new ArrayList<SelfHelpStaffCanselectShowModel>();
		for (SelfHelpSelectHouse selfHelpSelectHouse : selfHelpSelectHouses) {
			SelfHelpStaffCanselectShowModel selfHelpStaffCanselectShowModel = new SelfHelpStaffCanselectShowModel();
			selfHelpStaffCanselectShowModel.setStaffName(selfHelpSelectHouse.getStaffName());
			selfHelpStaffCanselectShowModel.setStaffNo(selfHelpSelectHouse.getStaffNo());
			selfHelpStaffCanselectShowModel.setStaffTitleName(selfHelpSelectHouse.getStaffTitleName());
			selfHelpStaffCanselectShowModel.setStaffPostName(selfHelpSelectHouse.getStaffPostName());
			selfHelpStaffCanselectShowModel.setStaffTypeName(selfHelpSelectHouse.getStaffTypeName());
			selfHelpStaffCanselectShowModel.setStaffStatusName(selfHelpSelectHouse.getStaffStatusName());
			selfHelpStaffCanselectShowModel.setStaffDeptName(selfHelpSelectHouse.getStaffDeptName());
			selfHelpStaffCanselectShowModel.setStaffPostVal(selfHelpSelectHouse.getStaffPostVal());
			selfHelpStaffCanselectShowModel.setStaffTitleVal(selfHelpSelectHouse.getStaffTitleVal());
			selfHelpStaffCanselectShowModel.setStaffSpousePostVal(selfHelpSelectHouse.getStaffSpousePostVal());
			selfHelpStaffCanselectShowModel.setStaffSpouseTitleVal(selfHelpSelectHouse.getStaffSpouseTitleVal());
			selfHelpStaffCanselectShowModel.setStaffTimeVal(selfHelpSelectHouse.getStaffTimeVal());
			selfHelpStaffCanselectShowModel.setStaffOtherVal(selfHelpSelectHouse.getStaffOtherVal());
			selfHelpStaffCanselectShowModel.setStaffTotalVal(selfHelpSelectHouse.getStaffTotalVal());
			selfHelpStaffCanselectShowModel.setHouseSelectStart(selfHelpSelectHouse.getHouseSelectStart());
			selfHelpStaffCanselectShowModel.setHouseSelectEnd(selfHelpSelectHouse.getHouseSelectEnd());
			selfHelpStaffCanselectShowModels.add(selfHelpStaffCanselectShowModel);
		}
		PageInfo pageInfo = new PageInfo(selfHelpSelectHouses);
		pageInfo.setList(selfHelpStaffCanselectShowModels);
		return Msg.success("获取成功").add("data", pageInfo);
	}

}

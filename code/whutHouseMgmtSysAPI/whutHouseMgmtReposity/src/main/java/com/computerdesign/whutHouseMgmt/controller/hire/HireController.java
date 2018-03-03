package com.computerdesign.whutHouseMgmt.controller.hire;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.hire.Hire;
import com.computerdesign.whutHouseMgmt.bean.hire.HireAddApply;
import com.computerdesign.whutHouseMgmt.bean.hire.HireAddSignContract;
import com.computerdesign.whutHouseMgmt.bean.hire.HireApplyAlready;
import com.computerdesign.whutHouseMgmt.bean.hire.HireGetApply;
import com.computerdesign.whutHouseMgmt.bean.hire.HireGetSignContract;
import com.computerdesign.whutHouseMgmt.bean.hire.HireHouseGetApply;
import com.computerdesign.whutHouseMgmt.bean.hire.ViewHire;
import com.computerdesign.whutHouseMgmt.bean.houseregister.Resident;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffHouse;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.Staff;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffVw;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.ViewStaff;
import com.computerdesign.whutHouseMgmt.service.hire.HireService;
import com.computerdesign.whutHouseMgmt.service.hire.StaffHouseService;
import com.computerdesign.whutHouseMgmt.service.hire.ViewHireService;
import com.computerdesign.whutHouseMgmt.service.houseregister.RegisterService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.StaffService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.StaffVwService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.ViewStaffService;
import com.computerdesign.whutHouseMgmt.service.staffparam.StaffParameterService;

@RequestMapping(value = "/hire/")
@Controller
public class HireController {

	@Autowired
	private HireService hireService;

	@Autowired
	private ViewHireService viewHireService;

	@Autowired
	private StaffHouseService staffHouseService;

	@Autowired
	private ViewStaffService viewStaffService;
	
	@Autowired
	private RegisterService registerService;

	/**
	 * 获取住房申请页面
	 * 
	 * @param staffId
	 * @return
	 */
	@RequestMapping(value = "getApply/{staffId}", method = RequestMethod.GET)
	@ResponseBody
	public Msg getHireApply(@PathVariable("staffId") Integer staffId) {

		// 确认员工信息
		ViewStaff viewStaff = viewStaffService.getByStaffId(staffId).get(0);
		HireGetApply hireGetApply = new HireGetApply(viewStaff);

		// 用StaffHouse表
		List<StaffHouse> listStaffHouse = new ArrayList<StaffHouse>();
		// 根据staffId获取staffHouse的list
		listStaffHouse = staffHouseService.getStaffHouseByStaffId(staffId);
		if (!listStaffHouse.isEmpty()) {
			// 房屋集合
			List<HireHouseGetApply> listHouseGetApply = new ArrayList<HireHouseGetApply>();
			for (StaffHouse staffHouseD : listStaffHouse) {
				listHouseGetApply.add(new HireHouseGetApply(staffHouseD));
			}
			hireGetApply.setListHouseGetApply(listHouseGetApply);
		}
		

		// 已申请租赁信息集合
		if (!viewHireService.getByStaffId(staffId).isEmpty()) {
			ViewHire viewHirePre = viewHireService.getByStaffId(staffId).get(0);
			HireApplyAlready hireApplyAlready = new HireApplyAlready(viewHirePre);
			hireGetApply.setHireApplyAlready(hireApplyAlready);
		}
		

		return Msg.success("返回住房申请页面").add("data", hireGetApply);

	}

	/**
	 * 住房申请
	 * @param hire
	 * @return
	 */
	@RequestMapping(value = "addApply", method = RequestMethod.POST)
	@ResponseBody
	public Msg addHireApply(@RequestBody Hire hire) {

		if (!viewHireService.getByStaffId(hire.getStaffId()).isEmpty()) {
			ViewHire viewHirePre = viewHireService.getByStaffId(hire.getStaffId()).get(0);	
			if (viewHirePre.getAcceptState() != null) {
				return Msg.error("该员工正在申请房屋，无法再次申请");
			}
		}

		ViewStaff viewStaff = viewStaffService.getByStaffId(hire.getStaffId()).get(0);

		hire.setApplyTime(new Date());
		hire.setHireState("待受理");
		hire.setIsOver(false);

		hire.setTimeVal(viewStaff.getTimeVal());
		hire.setOtherVal(viewStaff.getOtherVal());
		hire.setSpouseVal(viewStaff.getSpouseTitleVal().doubleValue());

		hire.setTitleVal(viewStaff.getTitleVal().doubleValue());
		hire.setTotalVal(viewStaff.getTotalVal().doubleValue());

		hireService.add(hire);
		return Msg.success("提交申请成功");
	}
	
	/**
	 * 签订合同页面
	 * @return
	 */
	@RequestMapping(value = "getSignContract",method = RequestMethod.POST)
	@ResponseBody
	public Msg HireGetSignContract(){
		List<ViewHire> listViewHire = viewHireService.getSignContract();
		List<HireGetSignContract>  listHireGetSignContract = new ArrayList<HireGetSignContract>();
		for (ViewHire viewHire : listViewHire) {
			listHireGetSignContract.add(new HireGetSignContract(viewHire));
		}
		return Msg.success("全部已审批尚未签订合同的房屋申请信息").add("data", listHireGetSignContract);
	}
	
	@RequestMapping(value = "addSignContract",method = RequestMethod.POST)
	@ResponseBody
	public Msg HireAddSignContract(@RequestBody HireAddSignContract hireAddSignContract){
		Hire hire = hireService.getHireById(hireAddSignContract.getId());
		hire.setIsOver(true);
		hireService.update(hire);
		
		Resident resident = new Resident();
		resident.setBookTime(hireAddSignContract.getBookTime());
		resident.setStaffId(hire.getStaffId());
		resident.setHouseId(hire.getHouseId());
		//TODO 这里的HouseRel应该是租赁
		resident.setHouseRel(26);
	}
}

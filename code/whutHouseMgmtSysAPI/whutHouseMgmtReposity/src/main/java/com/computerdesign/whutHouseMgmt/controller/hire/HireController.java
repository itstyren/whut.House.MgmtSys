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
import com.computerdesign.whutHouseMgmt.bean.hire.HireApplyAlready;
import com.computerdesign.whutHouseMgmt.bean.hire.HireGetApply;
import com.computerdesign.whutHouseMgmt.bean.hire.HireHouseGetApply;
import com.computerdesign.whutHouseMgmt.bean.hire.ViewHire;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffHouse;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.Staff;
import com.computerdesign.whutHouseMgmt.service.hire.HireService;
import com.computerdesign.whutHouseMgmt.service.hire.StaffHouseService;
import com.computerdesign.whutHouseMgmt.service.hire.ViewHireService;

@RequestMapping(value = "/hire/")
@Controller
public class HireController {

	@Autowired
	private HireService hireService;
	
	@Autowired
	private ViewHireService viewHireService;
	
	@Autowired
	private StaffHouseService staffHouseService;
	
	/**
	 * 获取住房申请页面
	 * @param staffId
	 * @return
	 */
	@RequestMapping(value = "getApply/{staffId}",method = RequestMethod.GET)
	@ResponseBody
	public Msg getHireApply(@PathVariable("staffId")Integer staffId){
		//用StaffHouse表
		List<StaffHouse> listStaffHouse = new ArrayList<StaffHouse>();
		//根据staffId获取staffHouse的list
		listStaffHouse = staffHouseService.getStaffHouseByStaffId(staffId);
		if (listStaffHouse.isEmpty()) {
			return Msg.error("查找不到数据");
		}else{
			StaffHouse staffHouse = listStaffHouse.get(0);
			HireGetApply hireGetApply = new HireGetApply(staffHouse);
			
			//房屋集合
			List<HireHouseGetApply> listHouseGetApply = new ArrayList<HireHouseGetApply>();
			for (StaffHouse staffHouseD : listStaffHouse) {
				listHouseGetApply.add(new HireHouseGetApply(staffHouseD));
			}
			hireGetApply.setListHouseGetApply(listHouseGetApply);
			
			//已申请租赁信息集合
			List<HireApplyAlready> listHireApplyAlready = new ArrayList<HireApplyAlready>();
			List<ViewHire> listViewHirePre = viewHireService.getByStaffId(staffId);
			for (ViewHire viewHire : listViewHirePre) {
				listHireApplyAlready.add(new HireApplyAlready(viewHire));
			}
			hireGetApply.setListHireApplyAlready(listHireApplyAlready);
			
			return Msg.success("返回住房申请页面").add("data", hireGetApply);
		}
	}
	
	@RequestMapping(value = "addApply",method = RequestMethod.POST)
	@ResponseBody
	public Msg addHireApply(@RequestBody Hire hire){

		List<StaffHouse> listStaffHouse = staffHouseService.getStaffHouseByStaffId(hire.getStaffId());
		if (listStaffHouse.isEmpty()) {
			return Msg.error("请检查你的网络");
		}else{
			StaffHouse staffHouse = listStaffHouse.get(0);
			
			
		
			hire.setApplyTime(new Date());
			hire.setHireState("待受理");
			hire.setIsOver(false);
			
			hire.setTimeVal(staffHouse.getTimeVal());
			hire.setJobLevelVal(staffHouse.getStaffTitleVal().doubleValue());
			hire.setOtherVal(staffHouse.getOtherVal());
			hire.setStaffVal(staffHouse.getStaffPostVal().doubleValue());
			hire.setMultiVal(staffHouse.getTotalVal());
			
		}
		hireService.add(hire);
		return Msg.success("提交申请成功");
	}
}

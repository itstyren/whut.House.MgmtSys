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
import com.computerdesign.whutHouseMgmt.bean.hire.HireAddAgree;
import com.computerdesign.whutHouseMgmt.bean.hire.HireGetAgree;
import com.computerdesign.whutHouseMgmt.bean.hire.ViewHire;
import com.computerdesign.whutHouseMgmt.service.hire.HireService;
import com.computerdesign.whutHouseMgmt.service.hire.StaffHouseService;
import com.computerdesign.whutHouseMgmt.service.hire.ViewHireService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.ViewStaffService;

@Controller
@RequestMapping(value = "/hire/")
public class HireAgreeController {

	@Autowired
	private HireService hireService;

	@Autowired
	private ViewHireService viewHireService;

	@Autowired
	private StaffHouseService staffHouseService;

	@Autowired
	private ViewStaffService viewStaffService;

	
	@RequestMapping(value = "getAgree/{agreeState}",method = RequestMethod.GET)
	@ResponseBody
	public Msg getHireAgree(@PathVariable("agreeState")Integer agreeState){
		if (agreeState == null) {
			return Msg.error("请检查你的网络");
		} else if (agreeState == 0) {
			List<ViewHire> listViewHire = viewHireService.getAgreeUntil();
			List<HireGetAgree> listHireGetAgree = new ArrayList<HireGetAgree>();
			for (ViewHire viewHire : listViewHire) {
				listHireGetAgree.add(new HireGetAgree(viewHire));
			}
			return Msg.success("获取全部的未审核信息").add("data", listHireGetAgree);
		} else if (agreeState == 1) {
			List<ViewHire> listViewHire = viewHireService.getAgreeHasBeen();
			List<HireGetAgree> listHireGetAgree = new ArrayList<HireGetAgree>();
			for (ViewHire viewHire : listViewHire) {
				listHireGetAgree.add(new HireGetAgree(viewHire));
			}
			return Msg.success("获取全部的已进行审核操作的信息").add("data", listHireGetAgree);
		} else {
			return Msg.error("请检查你的网络");
		}

	}
	
	/**
	 * 房屋申请审核
	 * @param hireAddAgree
	 * @return
	 */
	@RequestMapping(value = "addAgree",method = RequestMethod.PUT)
	@ResponseBody
	public Msg addHireAgree(@RequestBody HireAddAgree hireAddAgree){
		ViewHire viewHire = viewHireService.getById(hireAddAgree.getId()).get(0);
		if (viewHire.getAcceptState() == null) {
			return Msg.error("该房屋申请尚未被受理，无法审核");
		}else if (viewHire.getAgreeState() !=null) {
			return Msg.error("该房屋已被审核");
		}
		Hire hire = hireService.getHireById(hireAddAgree.getId());
		if ("拒绝".equals(hireAddAgree.getAgreeState())) {
			hire.setAgreeMan(hireAddAgree.getAgreeMan());
			hire.setAgreeNote(hireAddAgree.getAgreeNote());
			hire.setAgreeState(hireAddAgree.getAgreeState());
			
			hire.setAgreeTime(new Date());
			
			hire.setHireState("审批拒绝");
			hire.setIsOver(true);
			hireService.update(hire);
			return Msg.success("审核拒绝").add("data", hire);
		}else if ("通过".equals(hireAddAgree.getAgreeState())) {
			hire.setAgreeMan(hireAddAgree.getAgreeMan());
			hire.setAgreeNote(hireAddAgree.getAgreeNote());
			hire.setAgreeState(hireAddAgree.getAgreeState());
			
			hire.setAgreeTime(new Date());
			
			hire.setHouseId(hireAddAgree.getHouseId());
			
			hire.setHireState("待审批");
			hireService.update(hire);
						
			return Msg.success("审核成功").add("data", hire);
		}else {
			return Msg.error("请检查你的网络");
		}
	}
	
	/**
	 * 房屋申请重新审核
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "reAgree/{id}",method = RequestMethod.GET)
	@ResponseBody
	public Msg hireReAgree(@PathVariable("id")Integer id){
		Hire hire = hireService.getHireById(id);
		if (hire.getAgreeState() == null) {
			return Msg.error("该房屋申请尚未被审核");
		}else if (hire.getApproveState() !=null) {
			return Msg.error("该房屋申请已被审批");	
		}
		
		hire.setAgreeMan(null);
		hire.setAgreeNote(null);
		hire.setAgreeState(null);
		hire.setAgreeTime(null);
		
		hire.setHireState("待审核");
		hire.setIsOver(false);
		
		hireService.updateStrict(hire);
		return Msg.success("重新审核成功").add("data", hire);
		//TODO 不需要data
		
	}
}

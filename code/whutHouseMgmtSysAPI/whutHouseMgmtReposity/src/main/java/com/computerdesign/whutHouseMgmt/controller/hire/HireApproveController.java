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
import com.computerdesign.whutHouseMgmt.bean.hire.approve.HireAddApprove;
import com.computerdesign.whutHouseMgmt.bean.hire.approve.HireGetApprove;
import com.computerdesign.whutHouseMgmt.bean.hire.common.Hire;
import com.computerdesign.whutHouseMgmt.bean.hire.common.ViewHire;
import com.computerdesign.whutHouseMgmt.service.hire.HireService;
import com.computerdesign.whutHouseMgmt.service.hire.StaffHouseService;
import com.computerdesign.whutHouseMgmt.service.hire.ViewHireService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.ViewStaffService;

@Controller
@RequestMapping(value = "/hire/")
public class HireApproveController {

	@Autowired
	private HireService hireService;

	@Autowired
	private ViewHireService viewHireService;

	@Autowired
	private StaffHouseService staffHouseService;

	@Autowired
	private ViewStaffService viewStaffService;
	
	@RequestMapping(value = "getApprove/{approveState}",method = RequestMethod.GET)
	@ResponseBody
	public Msg getHireApprove(@PathVariable("approveState")Integer approveState){
		if(approveState == 0){
			List<HireGetApprove> listHireGetApprove = new ArrayList<HireGetApprove>();
			List<ViewHire> listViewHire = viewHireService.getApproveUntil();
			for (ViewHire viewHire : listViewHire) {
				listHireGetApprove.add(new HireGetApprove(viewHire));
			}
			return Msg.success("返回所有的未审批的房屋请求信息").add("data", listHireGetApprove);
		}else if (approveState == 1) {
			List<HireGetApprove> listHireGetApprove = new ArrayList<HireGetApprove>();
			List<ViewHire> listViewHire = viewHireService.getApproveHasBeen();
			for (ViewHire viewHire : listViewHire) {
				listHireGetApprove.add(new HireGetApprove(viewHire));
			}
			return Msg.success("返回所有的已审批的房屋请求信息").add("data", listHireGetApprove);
		}else {
			return Msg.error("请检查您的网络");
		}
	}
	
	/**
	 * 房屋申请审批操作
	 * @param hireAddApprove
	 * @return
	 */
	@RequestMapping(value = "addApprove",method = RequestMethod.PUT)
	@ResponseBody
	public Msg addHireApprove(@RequestBody HireAddApprove hireAddApprove){
		Hire hire = hireService.getHireById(hireAddApprove.getId());
		if (hire.getAgreeState() == null) {
			return Msg.error("该房屋申请尚未被审核，无法审批");
		}else if (hire.getApproveState() != null) {
			return Msg.error("该房屋申请已被审批");
		}
		
		if ("通过".equals(hireAddApprove.getApproveState())) {
			hire.setApproveMan(hireAddApprove.getApproveMan());
			hire.setApproveNote(hireAddApprove.getApproveNote());
			hire.setApproveState(hireAddApprove.getApproveState());
			hire.setApproveTime(new Date());
			
			hire.setHireState("已审批");
			hireService.updateStrict(hire);
			return Msg.success("审批成功").add("data", hire);
		}else if ("拒绝".equals(hireAddApprove.getApproveState())) {
			hire.setApproveMan(hireAddApprove.getApproveMan());
			hire.setApproveNote(hireAddApprove.getApproveNote());
			hire.setApproveState(hireAddApprove.getApproveState());
			hire.setApproveTime(new Date());
			
			hire.setHireState("审批拒绝");
			hire.setIsOver(true);
			hireService.updateStrict(hire);
			return Msg.success("审批拒绝").add("data", hire);
		}else {
			return Msg.error("请检查你的网络");
		}
	}
	/**
	 * 重新审批
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "reApprove/{id}",method = RequestMethod.GET)
	@ResponseBody
	public Msg hireReApprove(@PathVariable("id")Integer id){
		Hire hire = hireService.getHireById(id);
		if (hire.getApproveState() == null) {
			return Msg.error("该房屋申请尚未被审批");
		}else if (hire.getIsOver() == true) {
			return Msg.error("该房屋申请操作已结束");	
		}
		
		hire.setApproveMan(null);
		hire.setApproveNote(null);
		hire.setApproveState(null);
		hire.setApproveTime(null);
		
		hire.setHireState("待审批");
		hire.setIsOver(false);
		
		hireService.updateStrict(hire);
		return Msg.success("重新审批成功").add("data", hire);
		//TODO 不需要data
	
	}
}
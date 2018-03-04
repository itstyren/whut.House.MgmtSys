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
import com.computerdesign.whutHouseMgmt.bean.hire.accept.HireAddAccept;
import com.computerdesign.whutHouseMgmt.bean.hire.accept.HireGetAccept;
import com.computerdesign.whutHouseMgmt.bean.hire.common.Hire;
import com.computerdesign.whutHouseMgmt.bean.hire.common.ViewHire;
import com.computerdesign.whutHouseMgmt.service.hire.HireService;
import com.computerdesign.whutHouseMgmt.service.hire.StaffHouseService;
import com.computerdesign.whutHouseMgmt.service.hire.ViewHireService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.ViewStaffService;

@RequestMapping(value = "/hire/")
@Controller
public class HireAcceptController {

	@Autowired
	private HireService hireService;

	@Autowired
	private ViewHireService viewHireService;

	@Autowired
	private StaffHouseService staffHouseService;

	@Autowired
	private ViewStaffService viewStaffService;

	/**
	 * 获取房屋申请受理页面
	 * 
	 * @param acceptState
	 * @return
	 */
	@RequestMapping(value = "getAccept/{acceptState}", method = RequestMethod.GET)
	@ResponseBody
	public Msg getAccept(@PathVariable("acceptState") Integer acceptState) {
		if (acceptState == null) {
			return Msg.error("请检查你的网络");
		} else if (acceptState == 0) {//获取全部未受理的信息
			List<ViewHire> listViewHire = viewHireService.getAcceptUntil();
			List<HireGetAccept> listHireGetAccept = new ArrayList<HireGetAccept>();
			for (ViewHire viewHire : listViewHire) {
				listHireGetAccept.add(new HireGetAccept(viewHire));
			}
			return Msg.success("获取全部的未受理信息").add("data", listHireGetAccept);
		} else if (acceptState == 1) {
			List<ViewHire> listViewHire = viewHireService.getAcceptHasBeen();
			List<HireGetAccept> listHireGetAccept = new ArrayList<HireGetAccept>();
			for (ViewHire viewHire : listViewHire) {
				listHireGetAccept.add(new HireGetAccept(viewHire));
			}
			return Msg.success("获取全部的已进行受理操作的信息").add("data", listHireGetAccept);
		} else {
			return Msg.error("请检查你的网络");
		}
	}

	/**
	 * 房屋申请受理操作
	 * @param hireAddAccept
	 * @return
	 */
	@RequestMapping(value = "addAccept", method = RequestMethod.PUT)
	@ResponseBody
	public Msg hireAddAccept(@RequestBody HireAddAccept hireAddAccept) {
		ViewHire viewHire = viewHireService.getById(hireAddAccept.getId()).get(0);
		if (viewHire.getIsOver()) {
			return Msg.error("该住房请求已经结束，无法操作");
		} else if (viewHire.getAcceptState() != null) {
			return Msg.error("该住房请求已经完成受理操作");
		}

		if ("拒绝".equals(hireAddAccept.getAcceptState())) {
			Hire hire = hireService.getHireById(hireAddAccept.getId());
			hire.setAcceptMan(hireAddAccept.getAcceptMan());
			hire.setAcceptNote(hireAddAccept.getAcceptNote());
			hire.setAcceptState(hireAddAccept.getAcceptState());
			// 设置分数
			hire.setTimeVal(hireAddAccept.getTitleVal());
			hire.setTotalVal(hireAddAccept.getTotalVal());
			hire.setTimeVal(hireAddAccept.getTimeVal());
			hire.setOtherVal(hireAddAccept.getOtherVal());
			hire.setSpouseVal(hireAddAccept.getSpouseVal());

			hire.setAcceptTime(new Date());
			hire.setHireState("未受理");
			hire.setIsOver(true);

			hireService.update(hire);
			return Msg.success("受理拒绝");
		} else if ("通过".equals(hireAddAccept.getAcceptState())) {
			Hire hire = hireService.getHireById(hireAddAccept.getId());
			hire.setAcceptMan(hireAddAccept.getAcceptMan());
			hire.setAcceptNote(hireAddAccept.getAcceptNote());
			hire.setAcceptState(hireAddAccept.getAcceptState());

			hire.setTimeVal(hireAddAccept.getTitleVal());
			hire.setTotalVal(hireAddAccept.getTotalVal());
			hire.setTimeVal(hireAddAccept.getTimeVal());
			hire.setOtherVal(hireAddAccept.getOtherVal());
			hire.setSpouseVal(hireAddAccept.getSpouseVal());

			hire.setAcceptTime(new Date());
			hire.setHireState("待审核");
			hireService.update(hire);
			return Msg.success("受理成功").add("data", hire);
		} else {
			return Msg.error("请输入正确的信息");
		}
	}
	
	/**
	 * 重新受理房屋申请
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "reAccept/{id}",method = RequestMethod.GET)
	@ResponseBody
	public Msg hireReAccept(@PathVariable("id")Integer id){
		Hire hire = hireService.getHireById(id);
		if (hire.getAcceptState() == null) {
			return Msg.error("该房屋申请尚未完成受理操作，无法重新受理");
		}else if (hire.getAgreeState()!=null) {
			return Msg.error("该房屋申请已经完成审核操作，如欲重新受理，请先完成重新审核操作");
		}
		hire.setAcceptMan(null);
		hire.setAcceptNote(null);
		hire.setAcceptState(null);
		hire.setAcceptTime(null);
		
		hire.setTimeVal(null);
		hire.setTotalVal(null);
		hire.setTimeVal(null);
		hire.setOtherVal(null);
		hire.setSpouseVal(null);
		
		hire.setHireState("待受理");
		hire.setIsOver(false);
		hireService.updateStrict(hire);
		return Msg.success("重新受理").add("data", hire);
	}
}

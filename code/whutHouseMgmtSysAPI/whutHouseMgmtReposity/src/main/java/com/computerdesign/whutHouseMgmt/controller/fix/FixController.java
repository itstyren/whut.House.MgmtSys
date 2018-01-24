package com.computerdesign.whutHouseMgmt.controller.fix;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.text.View;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.fix.Fix;
import com.computerdesign.whutHouseMgmt.bean.fix.FixAddAccept;
import com.computerdesign.whutHouseMgmt.bean.fix.FixAddAgree;
import com.computerdesign.whutHouseMgmt.bean.fix.FixAddCheck;
import com.computerdesign.whutHouseMgmt.bean.fix.FixAddPrice;
import com.computerdesign.whutHouseMgmt.bean.fix.FixGetAccept;
import com.computerdesign.whutHouseMgmt.bean.fix.FixGetAgree;
import com.computerdesign.whutHouseMgmt.bean.fix.FixGetApply;
import com.computerdesign.whutHouseMgmt.bean.fix.FixGetCheck;
import com.computerdesign.whutHouseMgmt.bean.fix.FixSetTime;
import com.computerdesign.whutHouseMgmt.bean.fix.HouseGetApply;
import com.computerdesign.whutHouseMgmt.bean.fix.ViewFix;
import com.computerdesign.whutHouseMgmt.bean.house.House;
import com.computerdesign.whutHouseMgmt.bean.house.ViewHouse;
import com.computerdesign.whutHouseMgmt.bean.houseregister.Resident;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffVw;
import com.computerdesign.whutHouseMgmt.service.fix.FixService;
import com.computerdesign.whutHouseMgmt.service.fix.ViewFixService;
import com.computerdesign.whutHouseMgmt.service.house.ViewHouseService;
import com.computerdesign.whutHouseMgmt.service.houseregister.RegisterService;
import com.computerdesign.whutHouseMgmt.service.houseregister.StaffHouseRelService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.StaffVwService;

@RequestMapping(value = "/fix/")
@Controller
public class FixController {

	@Autowired
	private FixService fixService;
	
	@Autowired
	private StaffVwService staffVwService;
	
	@Autowired
	private ViewHouseService  viewHouseService;
	
	@Autowired
	private StaffHouseRelService staffHouseRelService;
	
	@Autowired
	private ViewFixService viewFixService;
	
	@Autowired
	private RegisterService registerService;
	
//	@RequestMapping(value = "add",method = RequestMethod.POST)
//	@ResponseBody
//	public Msg addFix(@RequestBody Fix fix){
//		
//	}
	
	/**
	 * 返回申请页面得到的数据
	 * @param staffId
	 * @return
	 */
	@RequestMapping(value = "getApply/{staffId}" , method = RequestMethod.GET)
	@ResponseBody
	public Msg getFixApply(@PathVariable("staffId")Integer staffId){
		
		StaffVw staffVw = staffVwService.getByID(staffId);
		FixGetApply fixGetApply = new FixGetApply(staffVw);
		return null;
		
		//根据staffId获取该员工全部的resident信息
		List<Resident> listResident = registerService.getResidentsByStaffId(staffId);

		if (listResident.isEmpty()) {
			return Msg.success("没有房子").add("data", fixGetApply);
		}else {
			List<ViewHouse> listViewHouse = new ArrayList<ViewHouse>();
			//根据每一个房屋登记信息获取每一个house
			for (Resident resident : listResident) {
				listViewHouse.addAll(viewHouseService.get(resident.getHouseId()));				
			}
			List<HouseGetApply> listHouseGetApply = new ArrayList<HouseGetApply>();
			//增加house信息到新的model中
			for (ViewHouse viewHouse : listViewHouse) {
				listHouseGetApply.add(new HouseGetApply(viewHouse));
			}
			fixGetApply.setHousesList(listHouseGetApply);
			return Msg.success().add("data", fixGetApply);
		}
	}
	
	/**
	 * 维修申请
	 * @param fix
	 * @return
	 */
	@RequestMapping(value = "addApply" , method = RequestMethod.POST)
	@ResponseBody
	public Msg addFixApply(@RequestBody Fix fix){
		fix.setApplyTime(new Date());
		fix.setFixState("待受理");
		fix.setIsCheck(false);
		fix.setIsOver(false);
		fixService.add(fix);
		return Msg.success().add("data", fix);
	}
	
	/**
	 * 获取受理页面信息
	 * @return
	 */
	@RequestMapping(value = "getAccept/{acceptState}" , method = RequestMethod.GET)
	@ResponseBody
	public Msg getFixAccept(@PathVariable("acceptState")Integer acceptState){
		
		if(acceptState == null){
			return Msg.error("请检查你的网络");
		}else if(0 == acceptState){
			List<ViewFix> list = viewFixService.getAcceptUntil();
			List<FixGetAccept> listFixGetAccept = new ArrayList<FixGetAccept>();
			//将viewHouse中信息存入到list中
			for (ViewFix viewFix : list) {
				listFixGetAccept.add(new FixGetAccept(viewFix));
			}
			return Msg.success("获取全部的未受理信息").add("data", listFixGetAccept);
		}else if (1 == acceptState) {
			List<ViewFix> list = viewFixService.getAcceptHasBeen();
			List<FixGetAccept> listFixGetAccept = new ArrayList<FixGetAccept>();
			//将viewHouse中信息存入到list中
			for (ViewFix viewFix : list) {
				listFixGetAccept.add(new FixGetAccept(viewFix));
			}
			return Msg.success("获取全部的已受理信息").add("data", listFixGetAccept);
		}else{
			return Msg.error("请检查你的网络");
		}
		
	}
	
	/**
	 * 维修受理处理
	 * @param fixAddAccept
	 * @return
	 */
	@RequestMapping(value = "addAccept" , method = RequestMethod.PUT)
	@ResponseBody
	public Msg addFixAccept(@RequestBody FixAddAccept fixAddAccept){
		if ("拒绝".equals(fixAddAccept.getAcceptState())) {
			Fix fix = fixService.get(fixAddAccept.getId());
			fix.setAcceptMan(fixAddAccept.getAcceptMan());
			fix.setAcceptState(fixAddAccept.getAcceptState());
			fix.setAcceptNote(fixAddAccept.getAcceptNote());
			fix.setAcceptTime(new Date());
			//维修状态改变
			fix.setFixState("受理拒绝");
			fix.setIsOver(true);
			fixService.update(fix);
			return Msg.success().add("data", fix);
			
		}else if ("通过".equals(fixAddAccept.getAcceptState())) {
			//根据传递的id获取一个Fix对象
			Fix fix = fixService.get(fixAddAccept.getId());
			fix.setAcceptMan(fixAddAccept.getAcceptMan());
			fix.setAcceptState(fixAddAccept.getAcceptState());
			fix.setAcceptNote(fixAddAccept.getAcceptNote());
			fix.setAcceptTime(new Date());
			//维修状态改变
			fix.setFixState("待审核");
			fixService.update(fix);
			return Msg.success().add("data", fix);
		}else  {
			return Msg.error("请输入正确的信息");
		}
	}
	
	/**
	 * 获取维修审核页面的信息
	 * @param agreeState
	 * @return
	 */
	@RequestMapping(value = "getAgree/{agreeState}",method = RequestMethod.GET)
	@ResponseBody
	public Msg getFixAgree(@PathVariable("agreeState")Integer agreeState){
		if( agreeState == null){
			return Msg.error("请检查你的网络");
		}else if(0 == agreeState){
			List<ViewFix> list = viewFixService.getAcceptUntil();
			List<FixGetAgree> listFixGetAgree = new ArrayList<FixGetAgree>();
			for (ViewFix viewFix : list) {
				listFixGetAgree.add(new FixGetAgree(viewFix));
			}
			return Msg.success("获取全部的未审核信息").add("data", listFixGetAgree);
		}else if (1 == agreeState) {
			List<ViewFix> list = viewFixService.getAcceptHasBeen();
			List<FixGetAgree> listFixGetAgree = new ArrayList<FixGetAgree>();
			for (ViewFix viewFix : list) {
				listFixGetAgree.add(new FixGetAgree(viewFix));
			}
			return Msg.success("获取全部的已审核信息").add("data", listFixGetAgree);
		}else{
			return Msg.error("请检查你的网络");
		}
	}
	
	/**
	 * 维修审核
	 * @param fixAddAgree
	 * @return
	 */
	@RequestMapping(value = "addAgree",method = RequestMethod.PUT)
	@ResponseBody
	public Msg addFixAgree(@RequestBody FixAddAgree fixAddAgree){
		if ("拒绝".equals(fixAddAgree.getAgreeState())) {
			Fix fix = fixService.get(fixAddAgree.getId());
			fix.setAgreeMan(fixAddAgree.getAgreeMan());
			fix.setAgreeState(fixAddAgree.getAgreeState());
			fix.setAgreeNote(fixAddAgree.getAgreeNote());
			fix.setAgreeTime(new Date());
			//维修状态改变
			fix.setFixState("审核拒绝");
			fix.setIsOver(true);
			fixService.update(fix);
			return Msg.success().add("data", fix);
			
		}else if ("通过".equals(fixAddAgree.getAgreeState())) {
			//根据传递的id获取一个Fix对象
			Fix fix = fixService.get(fixAddAgree.getId());
			fix.setAgreeMan(fixAddAgree.getAgreeMan());
			fix.setAgreeState(fixAddAgree.getAgreeState());
			fix.setAgreeNote(fixAddAgree.getAgreeNote());
			fix.setIsOver(true);
			fix.setAgreeTime(new Date());
			//维修状态改变
			fix.setFixState("已审核");
			fixService.update(fix);
			return Msg.success().add("data", fix);
		}else  {
			return Msg.error("请输入正确的信息");
		}
	}
	
	
	/**
	 * 获取结算页面信息
	 * @return
	 */
	@RequestMapping(value = "getCheck",method = RequestMethod.GET)
	@ResponseBody
	public Msg getFixCheck() {
		List<ViewFix> list = viewFixService.getAll();
		return Msg.success().add("data", list);
	}
	
//	@RequestMapping(value = "getCheck",method = RequestMethod.GET)
//	@ResponseBody
//	public Msg getFixCheck(@PathVariable FixSetTime fixSetTime){
//		
//		Date startTime = fixSetTime.getStartTime();
//		Date endTime = fixSetTime.getEndTime();	
//		List<ViewFix> list =  viewFixService.getByTime(startTime, endTime);
//		return Msg.success().add("data", list);
//	}
	
	/**
	 * 结算页面按条件查询
	 * @param fixGetCheck
	 * @return
	 */
	@RequestMapping(value = "getCheckByAllMultiCondition",method = RequestMethod.POST)
	@ResponseBody
	public Msg getFixCheck(@RequestBody FixGetCheck fixGetCheck){
		List<ViewFix> list = viewFixService.getByMultiCondition(fixGetCheck);
		return Msg.success().add("data", list);
	}
	
	/**
	 * 维修定价
	 * @param fixAddPrice
	 * @return
	 */
	@RequestMapping(value = "addPrice",method = RequestMethod.PUT)
	@ResponseBody
	public Msg addFixPrice(@RequestBody FixAddPrice fixAddPrice){
		
			Fix fix = fixService.get(fixAddPrice.getId());
			fix.setPriceMan(fixAddPrice.getPriceMan());
			fix.setFixMoney(fixAddPrice.getPrice());
			fix.setPriceTime(new Date());
			//维修状态改变
			fixService.update(fix);
			return Msg.success().add("data", fix);
			
	}
	
	@RequestMapping(value = "addCheck",method = RequestMethod.PUT)
	@ResponseBody
	public Msg addFixCheck(@RequestBody FixAddCheck fixAddCheck){
		
		Fix fix = fixService.get(fixAddCheck.getId());
		fix.setCheckMan(fixAddCheck.getCheckMan());
		fix.setCheckTime(new Date());
		fix.setIsCheck(true);
		//维修状态改变
		fixService.update(fix);
		return Msg.success().add("data", fix);
	}
}

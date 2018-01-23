package com.computerdesign.whutHouseMgmt.controller.fix;

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
import com.computerdesign.whutHouseMgmt.bean.fix.Fix;
import com.computerdesign.whutHouseMgmt.bean.fix.FixAddAccept;
import com.computerdesign.whutHouseMgmt.bean.fix.FixGetAccept;
import com.computerdesign.whutHouseMgmt.bean.fix.FixGetApply;
import com.computerdesign.whutHouseMgmt.bean.fix.ViewFix;
import com.computerdesign.whutHouseMgmt.bean.house.House;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffVw;
import com.computerdesign.whutHouseMgmt.service.fix.FixService;
import com.computerdesign.whutHouseMgmt.service.fix.ViewFixService;
import com.computerdesign.whutHouseMgmt.service.house.ViewHouseService;
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
	 * 获取获取页面信息
	 * @return
	 */
	@RequestMapping(value = "getAccept/{acceptState}" , method = RequestMethod.GET)
	@ResponseBody
	public Msg getFixAccept(@PathVariable("acceptState")String acceptState){
		
		if(acceptState.isEmpty() || acceptState == null){
			return Msg.error("请检查你的网络");
		}else if("未受理" == acceptState){
			List<ViewFix> list = viewFixService.getAcceptUntil();
			
			return Msg.success("获取全部的未受理信息").add("data", list);
		}else if ("已受理" == acceptState) {
			List<ViewFix> list = viewFixService.getAcceptHasBeen();
			return Msg.success("获取全部的已受理信息").add("data", list);
		}else{
			return Msg.error("请检查你的网络");
		}
		
	}
	
	/**
	 * 维修受理处理
	 * @param fixAddAccept
	 * @return
	 */
	@RequestMapping(value = "addAccept" , method = RequestMethod.POST)
	@ResponseBody
	public Msg addFixAccept(@RequestBody FixAddAccept fixAddAccept){
		
		
		if ("拒绝" == fixAddAccept.getAcceptNote()) {
			Fix fix = fixService.get(fixAddAccept.getId());
			fix.setAcceptMan(fixAddAccept.getAcceptMan());
			fix.setAcceptNote(fixAddAccept.getAcceptNote());
			fix.setAcceptTime(new Date());
			//维修状态改变
			fix.setFixState("已审核");
		}else if ("同意" == fixAddAccept.getAcceptNote()) {
			//根据传递的id获取一个Fix对象
			Fix fix = fixService.get(fixAddAccept.getId());
			fix.setAcceptMan(fixAddAccept.getAcceptMan());
			fix.setAcceptNote(fixAddAccept.getAcceptNote());
			fix.setAcceptTime(new Date());
			//维修状态改变
			fix.setFixState("待受理");
		}

		return Msg.success();
	}
	
	@RequestMapping(value = "getAgree/{agreeState}",method = RequestMethod.GET)
	@ResponseBody
	public Msg getFixAgree(@PathVariable("agreeState")String agreeState){
		if(agreeState.isEmpty() || agreeState == null){
			return Msg.error("请检查你的网络");
		}else if("未审核" == agreeState){
			List<ViewFix> list = viewFixService.getAcceptUntil();
			
			return Msg.success("获取全部的未审核信息").add("data", list);
		}else if ("已审核" == agreeState) {
			List<ViewFix> list = viewFixService.getAcceptHasBeen();
			return Msg.success("获取全部的已审核信息").add("data", list);
		}else{
			return Msg.error("请检查你的网络");
		}
	}
	
}

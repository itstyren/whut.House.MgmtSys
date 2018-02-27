package com.computerdesign.whutHouseMgmt.controller.fix;

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
import com.computerdesign.whutHouseMgmt.bean.fix.Fix;
import com.computerdesign.whutHouseMgmt.bean.fix.FixAddAgree;
import com.computerdesign.whutHouseMgmt.bean.fix.FixGetAgree;
import com.computerdesign.whutHouseMgmt.bean.fix.ViewFix;
import com.computerdesign.whutHouseMgmt.service.fix.FixService;
import com.computerdesign.whutHouseMgmt.service.fix.ViewFixService;
import com.computerdesign.whutHouseMgmt.service.house.ViewHouseService;
import com.computerdesign.whutHouseMgmt.service.houseregister.RegisterService;
import com.computerdesign.whutHouseMgmt.service.houseregister.StaffHouseRelService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.StaffVwService;

@RequestMapping(value = "/fix/")
@Controller
public class FixAgreeController {

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
	
	/**
	 * 获取维修审核页面的信息，agreeState=1为获取全部的已经过审核操作的信息
	 * @param agreeState
	 * @return
	 */
	@RequestMapping(value = "getAgree/{agreeState}",method = RequestMethod.GET)
	@ResponseBody
	public Msg getFixAgree(@PathVariable("agreeState")Integer agreeState){
		if( agreeState == null){
			return Msg.error("请检查你的网络");
		}else if(0 == agreeState){
			List<ViewFix> list = viewFixService.getAgreeUntil();
			List<FixGetAgree> listFixGetAgree = new ArrayList<FixGetAgree>();
			for (ViewFix viewFix : list) {
				listFixGetAgree.add(new FixGetAgree(viewFix));
			}
			return Msg.success("获取全部的未审核信息").add("data", listFixGetAgree);
		}else if (1 == agreeState) {
			List<ViewFix> list = viewFixService.getAgreeHasBeen();
			List<FixGetAgree> listFixGetAgree = new ArrayList<FixGetAgree>();
			for (ViewFix viewFix : list) {
				listFixGetAgree.add(new FixGetAgree(viewFix));
			}
			return Msg.success("获取全部的已经过审核操作的信息").add("data", listFixGetAgree);
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
		ViewFix viewFix = viewFixService.getById(fixAddAgree.getId()).get(0);
		if (viewFix.getAcceptState()==null) {
			return Msg.error("该维修申请尚未受理，无法被审核");
		}else if (viewFix.getAgreeState()!=null) {
			return Msg.error("该维修申请已被审核");
		}
		
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
			return Msg.success("审核拒绝").add("data", fix);
			
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
			return Msg.success("审核成功").add("data", fix);
		}else  {
			return Msg.error("请输入正确的信息");
		}
	}
	
	/**
	 * 重新审核
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "reAgree/{id}",method = RequestMethod.GET)
	@ResponseBody
	public Msg reAgree(@PathVariable("id")Integer id){
		Fix fix = fixService.get(id);
		if (fix.getAgreeState()==null) {
			return Msg.error("该维修申请尚未完成审核操作，无法重新审核");
		}if (fix.getPriceMan()!=null) {
			return Msg.error("该维修已定价，无法重新审核");
		}
		fix.setAgreeMan(null);
		fix.setAgreeNote(null);
		fix.setAgreeState(null);
		fix.setAgreeTime(null);
		fix.setFixState("待审核");
		fix.setIsOver(false);
		
		fixService.updateStrict(fix);
		return Msg.success("重新审核成功"); 
	}
	
}
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
import com.computerdesign.whutHouseMgmt.bean.fix.accept.FixAddAccept;
import com.computerdesign.whutHouseMgmt.bean.fix.accept.FixGetAccept;
import com.computerdesign.whutHouseMgmt.bean.fix.common.Fix;
import com.computerdesign.whutHouseMgmt.bean.fix.common.ViewFix;
import com.computerdesign.whutHouseMgmt.service.fix.FixService;
import com.computerdesign.whutHouseMgmt.service.fix.ViewFixService;
import com.computerdesign.whutHouseMgmt.service.house.ViewHouseService;
import com.computerdesign.whutHouseMgmt.service.houseregister.RegisterService;
import com.computerdesign.whutHouseMgmt.service.houseregister.StaffHouseRelService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.StaffVwService;

@RequestMapping(value = "/fix/")
@Controller
public class FixAcceptController {

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
	 * 获取受理页面信息
	 * @return
	 */
	@RequestMapping(value = "getAccept/{acceptState}" , method = RequestMethod.GET)
	@ResponseBody
	public Msg getFixAccept(@PathVariable("acceptState")Integer acceptState){
		
		if(acceptState == null){
			return Msg.error("请检查你的网络");
			//acceptState=0表示待受理的
		}else if(0 == acceptState){
			List<ViewFix> list = viewFixService.getAcceptUntil();
			List<FixGetAccept> listFixGetAccept = new ArrayList<FixGetAccept>();
			//将viewHouse中信息存入到list中
			for (ViewFix viewFix : list) {
				listFixGetAccept.add(new FixGetAccept(viewFix));
			}
			return Msg.success("获取全部的待受理信息").add("data", listFixGetAccept);
		}else if (1 == acceptState) {
			List<ViewFix> list = viewFixService.getAcceptHasBeen();
			List<FixGetAccept> listFixGetAccept = new ArrayList<FixGetAccept>();
			//将viewHouse中信息存入到list中
			for (ViewFix viewFix : list) {
				listFixGetAccept.add(new FixGetAccept(viewFix));
			}
			return Msg.success("获取全部的已进行受理操作的信息").add("data", listFixGetAccept);
		}else{
			return Msg.error("请检查你的网络");
		}
		
	}
	
	/**
	 * 维修受理处理
	 * @param fixAddAccept
	 * 封装以下数据
	 * @param id
	 * @param acceptState
	 * @param acceptNote
	 * @param acceptMan
	 * @return
	 */
	@RequestMapping(value = "addAccept" , method = RequestMethod.PUT)
	@ResponseBody
	public Msg addFixAccept(@RequestBody FixAddAccept fixAddAccept){
		//如果不符合受理条件
		ViewFix viewFix = viewFixService.getById(fixAddAccept.getId()).get(0);
		if (viewFix.getIsOver()) {
			return Msg.error("该维修申请已经结束，无法进行受理操作");
		}else if(viewFix.getAcceptState()!=null){
			return Msg.error("该维修申请已经完成受理操作");
		}
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
			return Msg.success("受理拒绝").add("data", fix);
			//TODO 不需要add data
			
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
			return Msg.success("受理成功").add("data", fix);
		}else  {
			return Msg.error("请输入正确的信息");
		}
	}
	
	/**
	 * 重新受理
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "reAccept/{id}",method = RequestMethod.GET)
	@ResponseBody
	public Msg reAccept(@PathVariable("id")Integer id){
		Fix fix = fixService.get(id);
		if (fix.getAcceptState()==null) {
			return Msg.error("该维修申请尚未完成受理操作，无法重新受理");
		}else if (fix.getAgreeState()!=null) {
			return Msg.error("该维修申请已经完成审核操作，如欲重新受理，请先完成重新审核操作");
		}
		fix.setAcceptMan(null);
		fix.setAcceptNote(null);
		fix.setAcceptState(null);
		fix.setAcceptTime(null);
		fix.setFixState("待受理");
		fix.setIsOver(false);
		
		fixService.updateStrict(fix);
		return Msg.success("重新受理成功");
	}
}

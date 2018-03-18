package com.computerdesign.whutHouseMgmt.controller.hire;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.hire.agree.HireAddAgree;
import com.computerdesign.whutHouseMgmt.bean.hire.common.Hire;
import com.computerdesign.whutHouseMgmt.bean.hire.common.ViewHire;
import com.computerdesign.whutHouseMgmt.service.hire.HireService;
import com.computerdesign.whutHouseMgmt.service.hire.ViewHireService;
import com.computerdesign.whutHouseMgmt.utils.ResponseUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/hire/")
@Api(value = "/hire/",tags = "Hire接口")
public class HireAgreeController {

	@Autowired
	private HireService hireService;

	@Autowired
	private ViewHireService viewHireService;

	
	@RequestMapping(value = "getAgree/{agreeState}",method = RequestMethod.GET)
	@ApiOperation(value = "进入房屋申请审核页面 0代表未经审核流程的全部信息，1代表审核过程结束的全部信息",httpMethod="GET",response = com.computerdesign.whutHouseMgmt.bean.Msg.class)
	public Msg getHireAgree(@PathVariable("agreeState")Integer agreeState){
		if (agreeState == null) {
			return Msg.error("请检查你的网络");
		}
		if (agreeState == 0) {
			List<ViewHire> listViewHire = viewHireService.getAgreeUntil();
			
			String[] fileds = { "id", "name", "applyTime", "hireState", "reason", "phone", "titleName", "postName",
					"deptName", "houseNo","houseBuildArea","houseUserArea","houseAddress",
					"acceptNote", "acceptState","acceptMan", "acceptTime",
					"totalVal", "titleVal", "timeVal", "spouseVal", "otherVal" };
			List<Map<String, Object>> response = ResponseUtil.getResultMap(listViewHire, fileds);
			
			return Msg.success("获取全部的未审核信息").add("data", response);
		} 
		if (agreeState == 1) {
			List<ViewHire> listViewHire = viewHireService.getAgreeHasBeen();
			
			String[] fileds = { "id", "name", "applyTime", "hireState", "reason", "phone", "titleName", "postName",
					"deptName", "houseNo","houseBuildArea","houseUserArea","houseAddress",
					"acceptNote", "acceptState","acceptMan", "acceptTime",
					"agreeNote", "agreeState","agreeMan", "agreeTime",
					"totalVal", "titleVal", "timeVal", "spouseVal", "otherVal" };
			List<Map<String, Object>> response = ResponseUtil.getResultMap(listViewHire, fileds);
			
			return Msg.success("获取全部的已进行审核操作的信息").add("data", response);
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
	@ApiOperation(value = "审核 agreeMan为当前登录人的姓名，agreeState只能为'通过'或者'拒绝'",httpMethod="PUT",response = com.computerdesign.whutHouseMgmt.bean.Msg.class)
	public Msg addHireAgree(@RequestBody HireAddAgree hireAddAgree){
		ViewHire viewHire = viewHireService.getById(hireAddAgree.getId()).get(0);
		if (viewHire.getAcceptState() == null) {
			return Msg.error("该房屋申请尚未被受理，无法审核");
		}
		if (viewHire.getAgreeState() !=null) {
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
			return Msg.success("审核拒绝").add("data", hire).add("message", "您的租赁申请状态已更新");
		}else if ("通过".equals(hireAddAgree.getAgreeState())) {
			hire.setAgreeMan(hireAddAgree.getAgreeMan());
			hire.setAgreeNote(hireAddAgree.getAgreeNote());
			hire.setAgreeState(hireAddAgree.getAgreeState());
			
			hire.setAgreeTime(new Date());
			
			hire.setHouseId(hireAddAgree.getHouseId());
			
			hire.setHireState("待审批");
			hireService.update(hire);
						
			return Msg.success("审核成功").add("data", hire).add("message", "您的租赁申请状态已更新");
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
	@ApiOperation(value = "重新审核 传入参数为hire的id",httpMethod="GET",response = com.computerdesign.whutHouseMgmt.bean.Msg.class)
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
		
		hire.setHouseId(null);
		hire.setHireState("待审核");
		hire.setIsOver(false);
		
		hireService.updateStrict(hire);
		return Msg.success("重新审核成功").add("data", hire).add("message", "您的租赁申请状态已更新");
		//TODO 不需要data
		
	}
}

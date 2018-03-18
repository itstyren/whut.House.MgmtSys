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
import com.computerdesign.whutHouseMgmt.bean.hire.approve.HireAddApprove;
import com.computerdesign.whutHouseMgmt.bean.hire.common.Hire;
import com.computerdesign.whutHouseMgmt.bean.hire.common.ViewHire;
import com.computerdesign.whutHouseMgmt.service.hire.HireService;
import com.computerdesign.whutHouseMgmt.service.hire.ViewHireService;
import com.computerdesign.whutHouseMgmt.utils.ResponseUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/hire/")
public class HireApproveController {

	@Autowired
	private HireService hireService;

	@Autowired
	private ViewHireService viewHireService;


	
	@RequestMapping(value = "getApprove/{approveState}",method = RequestMethod.GET)
	@ApiOperation(value = "进入房屋申请审批页面 0代表未经审批流程的全部信息，1代表审批过程结束的全部信息",httpMethod="GET",response = com.computerdesign.whutHouseMgmt.bean.Msg.class)
	public Msg getHireApprove(@PathVariable("approveState")Integer approveState){
		if(approveState == 0){
			List<ViewHire> listViewHire = viewHireService.getApproveUntil();
			
			String[] fileds = { "id", "name", "applyTime", "hireState", "reason", "phone", "titleName", "postName",
					"deptName", "houseNo","houseBuildArea","houseUserArea","houseAddress",
					"acceptNote", "acceptState","acceptMan", "acceptTime",
					"agreeNote", "agreeState","agreeMan", "agreeTime",
					"totalVal", "titleVal", "timeVal", "spouseVal", "otherVal" };
			List<Map<String, Object>> response = ResponseUtil.getResultMap(listViewHire, fileds);
			
			return Msg.success("返回所有的待审批的房屋请求信息").add("data", response);
		}else if (approveState == 1) {
			List<ViewHire> listViewHire = viewHireService.getApproveHasBeen();
			
			String[] fileds = { "id", "name", "applyTime", "hireState", "reason", "phone", "titleName", "postName",
					"deptName", "houseNo","houseBuildArea","houseUserArea","houseAddress",
					"acceptNote", "acceptState","acceptMan", "acceptTime",
					"agreeNote", "agreeState","agreeMan", "agreeTime",
					"approveNote", "approveState","approveMan", "approveTime",
					"totalVal", "titleVal", "timeVal", "spouseVal", "otherVal" };
			List<Map<String, Object>> response = ResponseUtil.getResultMap(listViewHire, fileds);
			
			return Msg.success("返回所有的已审批的房屋请求信息").add("data", response);
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
	@ApiOperation(value = "审批 approveMan为当前登录人的姓名，approveState只能为'通过'或者'拒绝'",httpMethod="PUT",response = com.computerdesign.whutHouseMgmt.bean.Msg.class)
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
			return Msg.success("审批成功").add("data", hire).add("message", "您的租赁申请状态已更新");
		}else if ("拒绝".equals(hireAddApprove.getApproveState())) {
			hire.setApproveMan(hireAddApprove.getApproveMan());
			hire.setApproveNote(hireAddApprove.getApproveNote());
			hire.setApproveState(hireAddApprove.getApproveState());
			hire.setApproveTime(new Date());
			
			hire.setHireState("审批拒绝");
			hire.setIsOver(true);
			hireService.updateStrict(hire);
			return Msg.success("审批拒绝").add("data", hire).add("message", "您的租赁申请状态已更新");
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
	@ApiOperation(value = "重新审批 传入参数为hire的id",httpMethod="GET",response = com.computerdesign.whutHouseMgmt.bean.Msg.class)
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
		return Msg.success("重新审批成功").add("data", hire).add("message", "您的租赁申请状态已更新");
		//TODO 不需要data
	
	}
}

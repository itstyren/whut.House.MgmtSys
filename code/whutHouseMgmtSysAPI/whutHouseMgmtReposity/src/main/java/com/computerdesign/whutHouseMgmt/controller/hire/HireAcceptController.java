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
import com.computerdesign.whutHouseMgmt.bean.hire.accept.HireAddAccept;
import com.computerdesign.whutHouseMgmt.bean.hire.common.Hire;
import com.computerdesign.whutHouseMgmt.bean.hire.common.ViewHire;
import com.computerdesign.whutHouseMgmt.bean.staffhomepage.LastFixRecord;
import com.computerdesign.whutHouseMgmt.bean.staffhomepage.LastHireRecord;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.ViewStaff;
import com.computerdesign.whutHouseMgmt.service.hire.HireService;
import com.computerdesign.whutHouseMgmt.service.hire.ViewHireService;
import com.computerdesign.whutHouseMgmt.service.staffhomepage.LastHireRecordService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.ViewStaffService;
import com.computerdesign.whutHouseMgmt.service.staffparam.StaffParameterService;
import com.computerdesign.whutHouseMgmt.utils.ResponseUtil;
import com.computerdesign.whutHouseMgmt.utils.StaffHomePageUtils;
import com.wf.etp.authz.annotation.RequiresPermissions;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RequestMapping(value = "/hire/")
@RestController
@Api(value = "/hire/", tags = "Hire接口")
public class HireAcceptController {

	@Autowired
	private HireService hireService;

	@Autowired
	private ViewHireService viewHireService;

	@Autowired
	private ViewStaffService viewStaffService;

	@Autowired
	private StaffParameterService staffParameterService;

	@Autowired
	private LastHireRecordService lastHireRecordService;
	
	/**
	 * 获取房屋申请受理页面
	 * 
	 * @param acceptState
	 * @return
	 */
	@RequestMapping(value = "getAccept/{acceptState}", method = RequestMethod.GET)
	@ApiOperation(value = "获取全部的受理信息", notes = "进入房屋申请受理页面 0代表未经受理流程的全部信息，1代表受理过程结束的全部信息", httpMethod = "GET", response = com.computerdesign.whutHouseMgmt.bean.Msg.class)
	public Msg getAccept(@PathVariable("acceptState") Integer acceptState) {
		if (acceptState == null) {
			return Msg.error("请检查你的网络");
		}
		if (acceptState == 0) {// 获取全部待受理的信息
			List<ViewHire> listViewHire = viewHireService.getAcceptUntil();
			// 设置titleVal自动计算和totalVal自动计算
			for (ViewHire viewHire : listViewHire) {
				ViewStaff viewStaff = viewStaffService.getByStaffId(viewHire.getStaffId()).get(0);
//				System.out.println(viewStaff);
//				System.out.println(viewStaff.getName());
//				Double titleVal = (double) staffParameterService.getValByStaffParamId(viewStaff.getTitle());
				//2018.08.13 XieHao修改
				Double titleVal;
				if(viewStaff.getTitleVal() != null){
					titleVal = viewStaff.getTitleVal().doubleValue();
				}else{
					titleVal = 0.0;
				}
				Double totalVal = titleVal + viewStaff.getOtherVal() + viewStaff.getTimeVal();
				viewHire.setTitleVal(titleVal);
				viewHire.setTotalVal(totalVal);
			}
			// 需要传出的字段
			String[] fileds = { "id", "name", "applyTime", "hireState","deptName", "reason", "phone", "titleName", "postName",
					"totalVal", "titleVal", "timeVal", "spouseVal", "otherVal" };
			List<Map<String, Object>> response = ResponseUtil.getResultMap(listViewHire, fileds);

			return Msg.success("获取全部的待受理信息").add("data", response);
		} else if (acceptState == 1) {
			List<ViewHire> listViewHire = viewHireService.getAcceptHasBeen();
			for (ViewHire viewHire : listViewHire) {
				ViewStaff viewStaff = viewStaffService.getByStaffId(viewHire.getStaffId()).get(0);
//				Double titleVal = (double) staffParameterService.getValByStaffParamId(viewStaff.getTitle());
				//2018.08.13 XieHao修改
				Double titleVal;
				if(viewStaff.getTitleVal() != null){
					titleVal = viewStaff.getTitleVal().doubleValue();
				}else{
					titleVal = 0.0;
				}
				Double totalVal = titleVal + viewHire.getOtherVal() + viewHire.getTimeVal() + viewHire.getSpouseVal();
				viewHire.setTitleVal(titleVal);
				viewHire.setTotalVal(totalVal);
			}
			
			String[] fileds = { "id", "name", "applyTime", "hireState", "deptName","reason", "phone", "titleName", "postName",
					"totalVal", "titleVal", "timeVal", "spouseVal", "otherVal", "acceptNote", "acceptState",
					"acceptMan", "acceptTime" };
			List<Map<String, Object>> response = ResponseUtil.getResultMap(listViewHire, fileds);
			
			return Msg.success("获取全部的已进行受理操作的信息").add("data", response);
		} else {
			return Msg.error("请检查你的网络");
		}
	}

	/**
	 * 房屋申请受理操作
	 * 
	 * @param hireAddAccept
	 * @return
	 */
	@RequestMapping(value = "addAccept", method = RequestMethod.PUT)
	@ApiOperation(value = "房屋受理", notes = "维修受理 acceptMan为当前登录人的姓名，acceptState只能为通过或者拒绝", httpMethod = "PUT", response = com.computerdesign.whutHouseMgmt.bean.Msg.class)
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
			hire.setTotalVal(hireAddAccept.getTotalVal());
			hire.setTimeVal(hireAddAccept.getTimeVal());
			hire.setOtherVal(hireAddAccept.getOtherVal());
			hire.setSpouseVal(hireAddAccept.getSpouseVal());

			hire.setAcceptTime(new Date());
			
			//保存上一级租赁状态
			StaffHomePageUtils.saveLastHireRecord(lastHireRecordService,hire);
			
			hire.setHireState("受理拒绝");
			hire.setIsOver(true);

			hireService.update(hire);
			return Msg.success("受理拒绝");
		} else if ("通过".equals(hireAddAccept.getAcceptState())) {
			Hire hire = hireService.getHireById(hireAddAccept.getId());
			hire.setAcceptMan(hireAddAccept.getAcceptMan());
			hire.setAcceptNote(hireAddAccept.getAcceptNote());
			hire.setAcceptState(hireAddAccept.getAcceptState());

			hire.setTotalVal(hireAddAccept.getTotalVal());
			hire.setTimeVal(hireAddAccept.getTimeVal());
			hire.setOtherVal(hireAddAccept.getOtherVal());
			hire.setSpouseVal(hireAddAccept.getSpouseVal());

			hire.setAcceptTime(new Date());
			
			//保存上一级租赁状态
			StaffHomePageUtils.saveLastHireRecord(lastHireRecordService,hire);
			
			hire.setHireState("待审核");
			hireService.update(hire);
			return Msg.success("受理成功").add("data", hire);
		} else {
			return Msg.error("请输入正确的信息");
		}
	}

	
	
	/**
	 * 重新受理房屋申请
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "reAccept/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "重新受理", notes = "重新受理 传入参数为hire的id", httpMethod = "GET", response = com.computerdesign.whutHouseMgmt.bean.Msg.class)
	public Msg hireReAccept(@PathVariable("id") Integer id) {
		Hire hire = hireService.getHireById(id);
		if (hire.getAcceptState() == null) {
			return Msg.error("该房屋申请尚未完成受理操作，无法重新受理");
		} else if (hire.getAgreeState() != null) {
			return Msg.error("该房屋申请已经完成审核操作，如欲重新受理，请先完成重新审核操作");
		}
		hire.setAcceptMan(null);
		hire.setAcceptNote(null);
		hire.setAcceptState(null);
		hire.setAcceptTime(null);

//		hire.setTimeVal(null);
//		hire.setTotalVal(null);
//		hire.setTimeVal(null);
//		hire.setOtherVal(null);
//		hire.setSpouseVal(null);

		hire.setTimeVal(0.0);
		hire.setTotalVal(0.0);
		hire.setTimeVal(0.0);
		hire.setOtherVal(0.0);
		hire.setSpouseVal(0.0);
		//保存上一级租赁状态
		StaffHomePageUtils.saveLastHireRecord(lastHireRecordService,hire);
		
		hire.setHireState("待受理");
		hire.setIsOver(false);
		hireService.updateStrict(hire);
		return Msg.success("重新受理").add("data", hire);
	}
}

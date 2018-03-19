package com.computerdesign.whutHouseMgmt.controller.staffhomepage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.fix.common.Fix;
import com.computerdesign.whutHouseMgmt.bean.hire.common.Hire;
import com.computerdesign.whutHouseMgmt.bean.staffhomepage.LastFixRecord;
import com.computerdesign.whutHouseMgmt.bean.staffhomepage.LastHireRecord;
import com.computerdesign.whutHouseMgmt.service.fix.FixService;
import com.computerdesign.whutHouseMgmt.service.hire.HireService;
import com.computerdesign.whutHouseMgmt.service.staffhomepage.LastFixRecordService;
import com.computerdesign.whutHouseMgmt.service.staffhomepage.LastHireRecordService;
import com.computerdesign.whutHouseMgmt.utils.DateUtil;


@RequestMapping("/staffHomePage/")
@Controller
public class StaffHomePageController {

	@Autowired
	private FixService fixService;
	
	@Autowired
	private LastFixRecordService lastFixRecordService;
	
	@Autowired
	private HireService hireService;

	@Autowired
	private LastHireRecordService lastHireRecordService;

	/**
	 * 住房申请状态更新通知
	 * @param staffId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getHireProcessStateChangeInfo/{staffId}", method = RequestMethod.GET)
	public Msg getHireProcessStateChangeInfo(@PathVariable("staffId") Integer staffId) {
		List<Hire> hires = hireService.getByStaffId(staffId);
		Map<Integer,String> messages = new HashMap<Integer,String>();
		for (Hire hire : hires) {
			String staffHire = "" + staffId + "-" + hire.getId();
			System.out.println(staffHire);
			LastHireRecord lastHireRecord = lastHireRecordService.getLastHireRecordByStaffAndHire(staffHire);
			if (!lastHireRecord.getState().equals(hire.getHireState())) {
				String message = "您在" + DateUtil.getCurrentSimpleDate(hire.getApplyTime()) + "的住房申请状态已更新";
				messages.put(lastHireRecord.getId(),message);
			}

		}
		return Msg.success().add("data", messages);
	}

	/**
	 * 维修状态更新通知
	 * @param staffId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getFixProcessStateChangeInfo/{staffId}", method = RequestMethod.GET)
	public Msg getFixProcessStateChangeInfo(@PathVariable("staffId") Integer staffId) {
		List<Fix> fixs = fixService.getByStaffId(staffId);
		Map<Integer,String> messages = new HashMap<Integer,String>();
		for (Fix fix : fixs) {
			String staffFix = "" + staffId + "-" + fix.getId();
			System.out.println(staffFix);
			LastFixRecord lastFixRecord = lastFixRecordService.getLastFixRecordByStaffAndFix(staffFix);
			if (!lastFixRecord.getState().equals(fix.getFixState())) {
				String message = "您在" + DateUtil.getCurrentSimpleDate(fix.getApplyTime()) + "申请的维修单状态已更新";
				messages.put(lastFixRecord.getId(),message);
			}

		}
		return Msg.success().add("data", messages);
	}
	
}

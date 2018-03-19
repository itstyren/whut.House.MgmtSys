package com.computerdesign.whutHouseMgmt.utils;

import java.util.Date;

import com.computerdesign.whutHouseMgmt.bean.fix.common.Fix;
import com.computerdesign.whutHouseMgmt.bean.hire.common.Hire;
import com.computerdesign.whutHouseMgmt.bean.staffhomepage.LastFixRecord;
import com.computerdesign.whutHouseMgmt.bean.staffhomepage.LastHireRecord;
import com.computerdesign.whutHouseMgmt.service.staffhomepage.LastFixRecordService;
import com.computerdesign.whutHouseMgmt.service.staffhomepage.LastHireRecordService;

/**
 * 首页信息通知处理的工具类
 * @author Administrator
 *
 */

public class StaffHomePageUtils {
	
	/**
	 * 保存上一级维修状态
	 * @param lastFixRecordService
	 * @param fix
	 */
	public static void saveLastFixRecord(LastFixRecordService lastFixRecordService, Fix fix){
		String staffFix = fix.getStaffId() + "-" + fix.getId();
		LastFixRecord lastFixRecord = lastFixRecordService.getLastFixRecordByStaffAndFix(staffFix);
		if(lastFixRecord == null){
			lastFixRecord = new LastFixRecord();
			lastFixRecord.setStaffFix(staffFix);
			lastFixRecord.setState(fix.getFixState());
			lastFixRecord.setUpdateTime(new Date());
			lastFixRecordService.add(lastFixRecord);
		}else{
			lastFixRecord.setState(fix.getFixState());
			lastFixRecord.setUpdateTime(new Date());
			lastFixRecordService.update(lastFixRecord);
		}
	}
	
	/**
	 * 保存上一级住房申请状态
	 * @param hire
	 */
	public static void saveLastHireRecord(LastHireRecordService lastHireRecordService,Hire hire){
		String staffHire = hire.getStaffId() + "-" + hire.getId();
		LastHireRecord lastHireRecord = lastHireRecordService.getLastHireRecordByStaffAndHire(staffHire);
		if(lastHireRecord == null){
			lastHireRecord = new LastHireRecord();
			lastHireRecord.setStaffHire(staffHire);
			lastHireRecord.setState(hire.getHireState());
			lastHireRecord.setUpdateTime(new Date());
			lastHireRecordService.add(lastHireRecord);
		}else{
			lastHireRecord.setState(hire.getHireState());
			lastHireRecord.setUpdateTime(new Date());
			lastHireRecordService.update(lastHireRecord);
		}
	}
	
}

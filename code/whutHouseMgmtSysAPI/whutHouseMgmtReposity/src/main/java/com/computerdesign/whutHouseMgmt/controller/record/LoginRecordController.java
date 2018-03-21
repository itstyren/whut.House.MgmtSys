package com.computerdesign.whutHouseMgmt.controller.record;
/**
 *
 * @author wanhaoran
 * @date 2018年3月20日 下午5:04:37
 * 
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.login.LoginRecord;
import com.computerdesign.whutHouseMgmt.service.login.LoginRecordService;
import com.computerdesign.whutHouseMgmt.utils.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping(value = "/record/")
@RestController
public class LoginRecordController {

	@Autowired
	private LoginRecordService loginRecordService;

	/**
	 * 获取全部的登陆信息
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	@GetMapping(value = "loginAll")
	public Msg getAllLoginRecord(@RequestParam(value = "page") Integer page,
			@RequestParam(value = "size") Integer size) {
		PageHelper.startPage(page, size);
		List<LoginRecord> listLoginRecord = loginRecordService.getAllLoginRecord();

		PageInfo pageInfo = new PageInfo<>(listLoginRecord);
		return Msg.success("登陆信息").add("data", pageInfo);
	}
	


//	@GetMapping(value = "login")
//	public Msg getLoginRecord(@RequestParam(value = "day", defaultValue = "7") Integer day) {
//		Date startDate = DateUtil.getDelayAppointDate(new Date(), day);
//		Date endDate = new Date();
//		List<Long> list = new ArrayList<>();
//		for (int i = day; i < 31; i += day) {
//			list.add(loginRecordService.getLoginRecord(startDate, startDate));
//			startDate = DateUtil.getDelayAppointDate(startDate,day);
//		}
//	}
}

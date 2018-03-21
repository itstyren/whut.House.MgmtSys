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

import io.swagger.annotations.ApiOperation;

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

	/**
	 * 登录信息
	 * @param day
	 * @return
	 */
	@GetMapping(value = "visitCapacity")
	@ApiOperation(value="按周获取访问量",notes="获取5个周的访问量")
	public Msg getLoginRecord(@RequestParam(value = "week",defaultValue="0")Integer week) {
		
		if (week>1) {
			Date startDate = DateUtil.getFirstDayOfWeek();
			Date endDate = new Date();
			
			List<Long> list = new ArrayList<>();
			for (int i = 0; i < week; i ++) {
				list.add(loginRecordService.getLoginRecord(startDate, endDate));
				endDate = DateUtil.getDelayAppointDate(startDate,1);
				startDate = DateUtil.getDelayAppointDate(startDate,7);
				System.out.println(startDate+" "+endDate);
			}
			return Msg.success().add("data", list);
		}
		if (week==1) {
			Date startDate = DateUtil.getFirstDayOfWeek();
			Date endDate = new Date();
			double dis = DateUtil.getDistanceOfTwoDate(startDate, endDate);
			System.out.println(dis);
			List<Long> list = new ArrayList<>();
			for (int i = 0; i <= dis; i ++) {
				System.out.println(startDate);
				list.add(loginRecordService.getLoginRecord(startDate));
				startDate = DateUtil.getAppointDate(startDate,1);
			}
			return Msg.success().add("data", list);
		}
		return Msg.error();
		
	}
}

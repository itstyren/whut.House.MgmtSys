package com.computerdesign.whutHouseMgmt.controller.record;
/**
 *
 * @author wanhaoran
 * @date 2018年3月20日 下午5:04:37
 * 
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.login.LoginRecord;
import com.computerdesign.whutHouseMgmt.service.login.LoginRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping(value = "/record/")
@RestController
public class LoginRecordController {

	@Autowired
	private LoginRecordService loginRecordService;
	
	@GetMapping(value = "login")
	public Msg getLoginRecord(@RequestParam(value = "page")Integer page,@RequestParam(value = "size")Integer size) {
		PageHelper.startPage(page, size);
		List<LoginRecord> listLoginRecord = loginRecordService.getAllLoginRecord();
		
		PageInfo pageInfo = new PageInfo<>(listLoginRecord);
		return Msg.success("登陆信息").add("data", pageInfo);
	}
}

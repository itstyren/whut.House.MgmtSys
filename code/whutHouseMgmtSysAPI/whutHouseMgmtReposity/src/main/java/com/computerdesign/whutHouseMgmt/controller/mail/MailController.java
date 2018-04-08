package com.computerdesign.whutHouseMgmt.controller.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.fix.common.ViewFix;
import com.computerdesign.whutHouseMgmt.bean.hire.common.ViewHire;
import com.computerdesign.whutHouseMgmt.service.fix.ViewFixService;
import com.computerdesign.whutHouseMgmt.service.hire.ViewHireService;
import com.computerdesign.whutHouseMgmt.service.param.emailparam.EmailParameterService;
import com.computerdesign.whutHouseMgmt.utils.email.MailUtil;

/**
 *
 * @author wanhaoran
 * @date 2018年4月8日 上午9:25:12
 * 
 */
@RestController
@RequestMapping(value = "/mail/")
public class MailController {

	@Autowired
	private ViewFixService viewFixService;
	@Autowired
	private EmailParameterService emailParameterService;
	@Autowired 
	private	ViewHireService viewHireService;
	
	
	@PostMapping(value = "fix")
	public Msg sendFixEmail(@RequestParam("fixId")Integer fixId){
		
		ViewFix viewFix = viewFixService.getById(fixId).get(0);
		if (viewFix.getEmail() == null) {
			return Msg.error("该用户在填写维修申请信息时未填写邮箱");
		}
		if (MailUtil.sendHtmlMail("武汉理工大学房改办", "您的维修申请已经被处理，请进入系统查看", viewFix.getEmail(),emailParameterService.get())) {
			return Msg.success();			
		}else {
			return Msg.error("发送邮件错误，请检查该用户信息");
		}
		
	}
	
	@PostMapping(value = "hire")
	public Msg sendHireEmail(@RequestParam("hireId")Integer hireId){
		ViewHire viewHire = viewHireService.getById(hireId).get(0);
		if (viewHire.getEmail() == null) {
			return Msg.error("该用户在填写住房申请信息时未填写邮箱");
		}
		if (MailUtil.sendHtmlMail("武汉理工大学房改办", "您的住房申请已经被处理，请进入系统查看", viewHire.getEmail(),emailParameterService.get())) {
			return Msg.success();			
		}else {
			return Msg.error("发送邮件错误，请检查该用户信息");
		}
		
	}
}

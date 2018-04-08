package com.computerdesign.whutHouseMgmt.test;

import java.util.Calendar;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.computerdesign.whutHouseMgmt.utils.email.MailUtil;

/**
 *
 * @author wanhaoran
 * @date 2018年4月8日 上午9:34:18
 * 
 */
public class SendEmail {

	public static void main(String[] args) {
		MailUtil mailUtil = new MailUtil();

		mailUtil.sendHtmlMail("标题", "您的维修申请已被审核", "whr1314520@qq.com",null);

	}
}

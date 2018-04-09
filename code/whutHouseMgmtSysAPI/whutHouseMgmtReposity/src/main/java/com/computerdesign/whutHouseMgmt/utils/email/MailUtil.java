package com.computerdesign.whutHouseMgmt.utils.email;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.computerdesign.whutHouseMgmt.bean.param.emailParam.EmailParameter;
import com.computerdesign.whutHouseMgmt.service.param.emailparam.EmailParameterService;

/**
 *
 * @author wanhaoran
 * @date 2018年4月8日 上午9:25:38
 * 
 */
public class MailUtil {
	
	public static boolean sendTextMail(String subject, String content, String toAddress,EmailParameter emailParameter) {
		MailInfo mailInfo = new MailInfo();
		// 设置默认的email参数
		mailInfo.setMailServerHost(emailParameter.getHost());
		mailInfo.setMailServerPort(emailParameter.getPort());
		mailInfo.setValidate(true);
		mailInfo.setUserName(emailParameter.getUserName());
		mailInfo.setPassword(emailParameter.getPassword());
		mailInfo.setFromAddress(emailParameter.getFromAddress());

		mailInfo.setSubject(subject);
		mailInfo.setContent(content + emailParameter.getPertainContent());
		mailInfo.setToAddress(toAddress);

		// 判断是否需要身份认证
		MyAuthenticator authenticator = null;
		Properties pro = mailInfo.getProperties();
		if (mailInfo.isValidate()) {
			// 如果需要身份认证，则创建一个密码验证器
			authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
		}
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
		try {
			// 根据session创建一个邮件消息
			Message mailMessage = new MimeMessage(sendMailSession);
			// 创建邮件发送者地址
			Address from = new InternetAddress(mailInfo.getFromAddress());
			// 设置邮件消息的发送者
			mailMessage.setFrom(from);
			// 创建邮件的接收者地址，并设置到邮件消息中
			Address to = new InternetAddress(mailInfo.getToAddress());
			mailMessage.setRecipient(Message.RecipientType.TO, to);
			// 设置邮件消息的主题
			mailMessage.setSubject(mailInfo.getSubject());
			// 设置邮件消息发送的时间
			mailMessage.setSentDate(new Date());
			// 设置邮件消息的主要内容
			String mailContent = mailInfo.getContent();
			mailMessage.setText(mailContent);
			// 发送邮件
			Transport.send(mailMessage);
			return true;
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/**
	 * 以HTML格式发送邮件
	 * 
	 * @param mailInfo
	 *            待发送的邮件信息
	 */
	public static boolean sendHtmlMail(String subject, String content, String toAddress,EmailParameter emailParameter) {
		MailInfo mailInfo = new MailInfo();
		// 设置默认的email参数
		mailInfo.setMailServerHost(emailParameter.getHost());
		mailInfo.setMailServerPort(emailParameter.getPort());
		mailInfo.setValidate(true);
		mailInfo.setUserName(emailParameter.getUserName());
		mailInfo.setPassword(emailParameter.getPassword());
		mailInfo.setFromAddress(emailParameter.getFromAddress());

		mailInfo.setSubject(subject);
		mailInfo.setContent(content + emailParameter.getPertainContent());
		mailInfo.setToAddress(toAddress);
		// 判断是否需要身份认证
		MyAuthenticator authenticator = null;
		Properties pro = mailInfo.getProperties();
		// 如果需要身份认证，则创建一个密码验证器
		if (mailInfo.isValidate()) {
			authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
		}
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
		try {
			// 根据session创建一个邮件消息
			Message mailMessage = new MimeMessage(sendMailSession);
			
			mailMessage.addHeader("X-Priority", "3");
			mailMessage.addHeader("X-MSMail-Priority", "Normal");
			mailMessage.addHeader("X-Mailer", "Microsoft Outlook Express 6.00.2900.2869");//本文以outlook名义发送邮件，不会被当作垃圾邮件           
			mailMessage.addHeader("X-MimeOLE", "Produced By Microsoft MimeOLE V6.00.2900.2869");
			mailMessage.addHeader("ReturnReceipt", "1");
			 
			 
			// 创建邮件发送者地址
			Address from = new InternetAddress(mailInfo.getFromAddress());
			// 设置邮件消息的发送者
			mailMessage.setFrom(from);
			// 创建邮件的接收者地址，并设置到邮件消息中
			Address to = new InternetAddress(mailInfo.getToAddress());
			// Message.RecipientType.TO属性表示接收者的类型为TO
			mailMessage.setRecipient(Message.RecipientType.TO, to);
			//给自己抄送一遍
			Address self = new InternetAddress(mailInfo.getFromAddress());
			mailMessage.addRecipient(Message.RecipientType.CC, self);
			// 设置邮件消息的主题
			mailMessage.setSubject(mailInfo.getSubject());
			// 设置邮件消息发送的时间
			mailMessage.setSentDate(new Date());
			// MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
			Multipart mainPart = new MimeMultipart();
			// 创建一个包含HTML内容的MimeBodyPart
			BodyPart html = new MimeBodyPart();
			// 设置HTML内容
			html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");
			mainPart.addBodyPart(html);
			// 将MiniMultipart对象设置为邮件内容
			mailMessage.setContent(mainPart);
			// 发送邮件
			Transport.send(mailMessage);
//			Transport transport = sendMailSession.getTransport("smtp");
//			transport.connect(pro.getProperty("mail.stmp.host"),pro.getProperty("username"),pro.getProperty("password"));
//			transport.sendMessage(mailMessage,mailMessage.getAllRecipients());
//			transport.close();
			return true;
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
		return false;
	}
}

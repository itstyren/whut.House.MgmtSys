package com.computerdesign.whutHouseMgmt.controller.qiniu;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.authority.Qiniu;
import com.computerdesign.whutHouseMgmt.service.authority.QiniuService;
import com.qiniu.util.Auth;

/**
 *
 * @author wanhaoran
 * @date 2018年3月29日 下午10:41:52
 * 
 */
@RestController
@RequestMapping(value = "Qiniu")
public class QiniuController {

	@Autowired
	private QiniuService qiniuService;

//	@GetMapping(value = "fileUpload")
//	public Msg upload(@RequestParam("fileName")String fileName) {
//		Qiniu qiniu = qiniuService.get();
//		String accessKey = qiniu.getAccessKey();
//		String secretKey = qiniu.getSecretKey();
//		
//	    String bucket = "whuthousemgmtsys";
//	    Auth auth = Auth.create(accessKey, secretKey);
//	    String upToken = auth.uploadToken(bucket);
//	    System.out.println(upToken);
//	    return Msg.success(upToken);
//
//	}

	@GetMapping(value = "download")
	public Msg download(@RequestParam("fileName")String fileName) throws UnsupportedEncodingException {
		Qiniu qiniu = qiniuService.get();
		String accessKey = qiniu.getAccessKey();
		String secretKey = qiniu.getSecretKey();
		
		fileName = new String(fileName.getBytes("8859_1"), "utf8");
	    String domainOfBucket = "p1z72063k.bkt.clouddn.com";
	    String encodedFileName = URLEncoder.encode(fileName, "utf-8");
	    String publicUrl = String.format("%s/%s", domainOfBucket, encodedFileName);

	    Auth auth = Auth.create(accessKey, secretKey);
	    long expireInSeconds = 3600;//1小时，可以自定义链接过期时间
	    String finalUrl = auth.privateDownloadUrl(publicUrl, expireInSeconds);
	    System.out.println(finalUrl);
	    return Msg.success(finalUrl);
	}
}

package com.computerdesign.whutHouseMgmt.controller.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.computerdesign.whutHouseMgmt.bean.Msg;

@RequestMapping("/fileUpload/")
@Controller
public class FileUploadController {

	@ResponseBody
	@RequestMapping(value = "multiFileUpload", method = RequestMethod.POST)
	public Msg multiFileUpload(@RequestParam("file") MultipartFile[] multipartFiles) throws IllegalStateException, IOException{
//		保存存储路径
		List<String> storePath = new ArrayList<String>();
		for (MultipartFile multipartFile : multipartFiles){
			String fileName = multipartFile.getOriginalFilename();
			System.out.println(multipartFile);
			System.out.println(fileName);
			if(fileName != ""){
//				System.out.println("上传");
				String fileSuffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
				long time = new Date().getTime();
				String name = fileSuffix.substring(1) + time + fileSuffix;
				
				String filePath = "E:\\WhutHouseSysStore\\" + name;
				File loaclFile = new File(filePath);
//				System.out.println(multipartFile.getOriginalFilename());
//				System.out.println(multipartFile.getName());
				multipartFile.transferTo(loaclFile);
				
				String responsePath = "http://172.16.65.105:8080/images/" + name;
				storePath.add(responsePath);
			}
			
		}
//		System.out.println(multipartFiles.getOriginalFilename());
		return Msg.success("上传成功").add("data", storePath);
	}
	
	@ResponseBody
	@RequestMapping(value = "multiFileNamedUpload", method = RequestMethod.POST)
	public Msg multiFileNamedUpload(@RequestParam("file") MultipartFile[] multipartFiles) throws IllegalStateException, IOException{
//		保存存储路径
		List<String> storePath = new ArrayList<String>();
		for (MultipartFile multipartFile : multipartFiles){
			String fileName = multipartFile.getOriginalFilename();
			System.out.println(multipartFile);
			System.out.println(fileName);
			if(fileName != ""){
//				System.out.println("上传");
//				String fileSuffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
//				long time = new Date().getTime();
//				String name = fileSuffix.substring(1) + time + fileSuffix;
				
				String filePath = "E:\\WhutHouseSysStore\\" + fileName;
				File loaclFile = new File(filePath);
//				System.out.println(multipartFile.getOriginalFilename());
//				System.out.println(multipartFile.getName());
				multipartFile.transferTo(loaclFile);
				
				String responsePath = "http://172.16.65.105:8080/images/" + fileName;
				storePath.add(responsePath);
			}
			
		}
//		System.out.println(multipartFiles.getOriginalFilename());
		return Msg.success("上传成功").add("data", storePath);
	}
	
}

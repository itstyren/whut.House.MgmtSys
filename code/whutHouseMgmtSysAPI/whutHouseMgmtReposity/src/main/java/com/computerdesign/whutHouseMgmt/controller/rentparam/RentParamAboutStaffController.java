package com.computerdesign.whutHouseMgmt.controller.rentparam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.staffparam.StaffParameter;
import com.computerdesign.whutHouseMgmt.service.staffparam.StaffParameterService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping("/rentParamAboutStaff/")
@Controller
public class RentParamAboutStaffController {

	@Autowired
	private StaffParameterService staffParameterService;
	
	@ResponseBody
	@RequestMapping(value = "modify", method = RequestMethod.PUT)
	public Msg modifyStaffParameter(@RequestBody StaffParameter staffParameterModel) {
		// ����id��ȡ����Ҫ�޸ĵ�ְ������
		StaffParameter staffParameter = staffParameterService.get(staffParameterModel.getStaffParamId());
		if (staffParameter == null) {
			return Msg.error("数据库无此记录");
		} else {
			try {
				staffParameterService.update(staffParameterModel);
				return Msg.success().add("data", staffParameterModel);
			} catch (Exception e) {
				return Msg.error();
			}
		}
	}
	
	@ResponseBody
	@RequestMapping("get/{paramTypeId}")
	public Msg getRentParamAboutStaff(@PathVariable("paramTypeId") Integer paramTypeId,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size){
		//System.out.println(paramTypeId);
		//paramClass����ְ��ֺ�ְ�������id�ֱ�Ϊ11��13����staffType��
		
		PageHelper.startPage(page, size);
		
		if(paramTypeId == 11 || paramTypeId == 13){
			List<StaffParameter> result = staffParameterService.getAllByParamTypeId(6);
			PageInfo pageInfo = new PageInfo(result);
			if(result != null){
				return Msg.success().add("data", pageInfo);
			}else{
				return Msg.error("无记录");
			}
		}
		
		//paramClass����ְ�Ʒֺ�ְ�������id�ֱ�Ϊ12��14����staffType��
		if(paramTypeId == 12 || paramTypeId == 14){
			List<StaffParameter> result = staffParameterService.getAllByParamTypeId(7);
			PageInfo pageInfo = new PageInfo(result);
			if(result != null){
				return Msg.success().add("data", pageInfo);
			}else{
				return Msg.error("无记录");
			}
		}
		return Msg.error("paramTypeId有误");
	}
	
}

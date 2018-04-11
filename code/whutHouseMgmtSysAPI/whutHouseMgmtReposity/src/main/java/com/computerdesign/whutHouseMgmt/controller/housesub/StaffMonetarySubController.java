package com.computerdesign.whutHouseMgmt.controller.housesub;

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
import com.computerdesign.whutHouseMgmt.bean.housesub.StaffMonetarySub;
import com.computerdesign.whutHouseMgmt.bean.staffparam.MonetarySubParam;
import com.computerdesign.whutHouseMgmt.service.housesub.StaffMonetarySubService;
import com.computerdesign.whutHouseMgmt.service.staffparam.MonetarySubParamService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Controller
@RequestMapping("/staffMonetarySub/")
public class StaffMonetarySubController {

	@Autowired
	private StaffMonetarySubService staffMonetarySubService;
	
	@Autowired
	private MonetarySubParamService monetarySubParamService;

	/**
	 * 根据职工编号获取其所有补贴记录
	 * 
	 * @param staffNo
	 * @param page
	 * @param size
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getMonetarySubByStaffNo/{staffNo}", method = RequestMethod.GET)
	public Msg getMonetarySubByStaffNo(@PathVariable("staffNo") String staffNo,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {

		PageHelper.startPage(page, size);
		if (staffNo != null) {
			List<StaffMonetarySub> staffMonetarySubs = staffMonetarySubService.getMonetarySubByStaffNo(staffNo);
			PageInfo pageInfo = new PageInfo(staffMonetarySubs);
			return Msg.success().add("data", pageInfo);
		} else {
			return Msg.error();
		}
	}

	/**
	 * 根据id删除一条补贴记录
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deleteMonetarySub/{id}", method = RequestMethod.DELETE)
	public Msg deleteMonetarySub(@PathVariable("id") Integer id) {
		if(id != null){
			staffMonetarySubService.delete(id);
			return Msg.success("删除成功");
		}else{
			return Msg.error();
		}
	}
	
	/**
	 * 添加一条住房补贴记录
	 * @param staffMonetarySub
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addMonetarySub", method = RequestMethod.POST)
	public Msg addMonetarySub(@RequestBody StaffMonetarySub staffMonetarySub) {
		if(staffMonetarySub != null){
			//获取补贴比例
			MonetarySubParam monetarySubParam = monetarySubParamService.getIsUsing();
			double subsidies = staffMonetarySub.getAnnualSal() * monetarySubParam.getSubParam() / 100.0;
			staffMonetarySub.setSubsidies((long)subsidies);
			staffMonetarySubService.add(staffMonetarySub);
			return Msg.success("添加成功").add("data", staffMonetarySub);
		}else{
			return Msg.error();
		}
	}

}

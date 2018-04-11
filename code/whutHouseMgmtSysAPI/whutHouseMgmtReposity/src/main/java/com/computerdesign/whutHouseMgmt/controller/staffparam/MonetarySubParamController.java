package com.computerdesign.whutHouseMgmt.controller.staffparam;

import java.util.ArrayList;
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
import com.computerdesign.whutHouseMgmt.bean.staffparam.MonetarySubParam;
import com.computerdesign.whutHouseMgmt.service.staffparam.MonetarySubParamService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping("/monetarySubParam/")
@Controller
public class MonetarySubParamController {

	@Autowired
	private MonetarySubParamService monetarySubParamService;
	
	/**
	 * 获取所有补贴比例参数
	 * @param page
	 * @param size
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public Msg getAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size){
		PageHelper.startPage(page,size);
		List<MonetarySubParam> monetarySubParams = new ArrayList<MonetarySubParam>();
		PageInfo pageInfo = new PageInfo(monetarySubParams);
		return Msg.success().add("data", pageInfo);
	}
	
	/**
	 * 添加一条补贴比例参数
	 * @param monetarySubParam
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Msg add(@RequestBody MonetarySubParam monetarySubParam){
		if(monetarySubParam != null){
			monetarySubParamService.add(monetarySubParam);
			return Msg.success().add("data", monetarySubParam);
		}else{
			return Msg.error();
		}
	}
	
	/**
	 * 删除一条补贴比例记录
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public Msg delete(@PathVariable("id") Integer id){
		if(id != null){
			monetarySubParamService.delete(id);
			return Msg.success();
		}else{
			return Msg.error();
		}
	}
	
	/**
	 * 更新一条补贴比例记录
	 * @param monetarySubParam
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "update", method = RequestMethod.PUT)
	public Msg update(@RequestBody MonetarySubParam monetarySubParam){
		if(monetarySubParam != null){
			monetarySubParamService.update(monetarySubParam);
			return Msg.success().add("data", monetarySubParam);
		}else{
			return Msg.error();
		}
	}
	
}

package com.computerdesign.whutHouseMgmt.controller.fix;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.fix.common.ViewFix;
import com.computerdesign.whutHouseMgmt.service.fix.FixService;
import com.computerdesign.whutHouseMgmt.service.fix.ViewFixService;
import com.computerdesign.whutHouseMgmt.utils.DateUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 *
 * @author wanhaoran
 * @date 2018年3月21日 上午8:09:23
 * 
 */
@RestController
@RequestMapping(value="/fixRecord/")
@Api(value="/fixRecord",description="维修数据统计")
public class FixRecordController {

	@Autowired
	private ViewFixService viewFixService;
	
	/**
	 * 返回本周的维修类型
	 * @param day
	 * @return
	 */
	@GetMapping(value="Name")
	@ApiOperation(value="获取这一周的维修类型的名称",notes="获取这一周的维修类型的名称",httpMethod="GET")
	public Msg getFixRecordName(@RequestParam("day")Integer day) {
		
		Date startDate = DateUtil.getDelayAppointDate(new Date(), day);
		Date endDate = new Date();
		List<ViewFix> listViewFix = viewFixService.getByTime(startDate,endDate);
		List<String> listString = new ArrayList<String>();
		for (ViewFix viewFix : listViewFix) {
			if (!listString.contains(viewFix.getFixContentName())) {
				listString.add(viewFix.getFixContentName());				
			}
		}
		return Msg.success("返回最近"+day+"天全部的维修类型").add("data", listString);
	}
	
	/**
	 * 获取这一周的维修类型的名称与对应数量
	 * @param day
	 * @return
	 */
	@GetMapping(value="Content")
	@ApiOperation(value="获取这一周的维修类型的名称与对应数量",notes="获取这一周的维修类型的名称与对应数量",httpMethod="GET")
	public Msg getFixRecordContent(@RequestParam("day")Integer day) {
		Date startDate = DateUtil.getDelayAppointDate(new Date(), day);
		Date endDate = new Date();
		List<ViewFix> listViewFix = viewFixService.getByTime(startDate,endDate);
		
		Map<String, Integer> map =new HashMap<String, Integer>();
		for (ViewFix viewFix : listViewFix) {
			if (!map.containsKey(viewFix.getFixContentName())) {
				map.put(viewFix.getFixContentName(),0);
			}
			map.put(viewFix.getFixContentName(), map.get(viewFix.getFixContentName())+1);
		}
		
		List<Map<String, String>> listMap = new ArrayList<>();
		for(String key:map.keySet()){
			Map<String, String> mapAl =new HashMap<String, String>();
			mapAl.put("name", key);
			mapAl.put("value", map.get(key).toString());
			listMap.add(mapAl);
		}
		return Msg.success("返回最近"+day+"天全部的维修类型名称与数量").add("data", listMap);
	}
}

package com.computerdesign.whutHouseMgmt.controller.house;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.house.ViewHouse;
import com.computerdesign.whutHouseMgmt.bean.houseregister.HouseAllSelectModel;
import com.computerdesign.whutHouseMgmt.service.campus.CampusService;
import com.computerdesign.whutHouseMgmt.service.house.ViewHouseService;
import com.computerdesign.whutHouseMgmt.service.houseregister.HouseRegisterSelectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 *
 * @author wanhaoran
 * @date 2018年3月25日 上午8:49:01
 * 
 */
@RestController
@RequestMapping(value="/houseRecord/")
@Api(value = "房屋记录Controller",description ="房屋记录接口")
public class HouseRecordController {

	
	@Autowired
	private ViewHouseService viewhouseService;

	@Autowired
	private HouseRegisterSelectService houseRegisterSelectService;
	
	@Autowired
	private CampusService campusService;
	
		
	/**
	 * 按照查询条件获取房屋类型统计
	 * @param paramTypeId
	 * @param houseAllSelectModel
	 * @return
	 */
	@PostMapping(value="Content")
	@ApiOperation(notes="获取房屋类型", value = "获取房屋类型")
	public Msg getHouseRecordContent(@RequestParam("paramTypeId")Integer paramTypeId,
			@RequestBody HouseAllSelectModel houseAllSelectModel){
		List<ViewHouse> listViewHouse = houseRegisterSelectService.getByAllMultiConditionQuery(houseAllSelectModel);
		
		List<String> listString = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		if (paramTypeId == 1) {			
			for (ViewHouse viewHouse:listViewHouse) {
				if (!listString.contains(viewHouse.getTypeName())) {
					listString.add(viewHouse.getTypeName());
				}
				if (!map.containsKey(viewHouse.getTypeName())) {
					map.put(viewHouse.getTypeName(),0);
				}
				map.put(viewHouse.getTypeName(), map.get(viewHouse.getTypeName())+1);
			}
		}
		if (paramTypeId == 2) {
			for (ViewHouse viewHouse:listViewHouse) {
				if (!listString.contains(viewHouse.getLayoutName())) {
					listString.add(viewHouse.getLayoutName());
				}
				if (!map.containsKey(viewHouse.getLayoutName())) {
					map.put(viewHouse.getLayoutName(),0);
				}
				map.put(viewHouse.getLayoutName(),map.get(viewHouse.getLayoutName())+1);
			}
		}
		if (paramTypeId == 3) {
			for (ViewHouse viewHouse:listViewHouse) {
				if (!listString.contains(viewHouse.getStatusName())) {
					listString.add(viewHouse.getStatusName());
				}
				if (!map.containsKey(viewHouse.getStatusName())) {
					map.put(viewHouse.getStatusName(),0);
				}
				map.put(viewHouse.getStatusName(), map.get(viewHouse.getStatusName())+1);
			}
		}
		if (paramTypeId == 4) {
			for (ViewHouse viewHouse:listViewHouse) {
				if (!listString.contains(viewHouse.getStructName())) {
					listString.add(viewHouse.getStructName());
				}
				if (!map.containsKey(viewHouse.getStructName())) {
					map.put(viewHouse.getStructName(),0);
				}
				map.put(viewHouse.getStructName(), map.get(viewHouse.getStructName())+1);
			}
		}
		List<Map<String, String>> listMap =new ArrayList<Map<String,String>>();
		for (Entry<String, Integer> entry : map.entrySet()) {
			Map<String, String> mapAl =new HashMap<String, String>();
			mapAl.put("name", entry.getKey());
			mapAl.put("value", entry.getValue().toString());
			listMap.add(mapAl);
		}
		return Msg.success("获取房屋统计").add("name", listString).add("content", listMap);
	}
	
	/**
	 * 获取各校区已入住和空闲的房屋数量
	 * @param houseAllSelectModel
	 * @return
	 */
	@PostMapping(value = "houseCampus")
	public Msg getHouseCampus(@RequestBody HouseAllSelectModel houseAllSelectModel){
		List<ViewHouse> listViewHouse = houseRegisterSelectService.getByAllMultiConditionQuery(houseAllSelectModel);
		List<String> listString = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		for (ViewHouse viewHouse:listViewHouse) {
			if (!listString.contains(viewHouse.getCampusName())) {
				listString.add(viewHouse.getCampusName());
			}
			if (!map.containsKey(viewHouse.getCampusName())) {
				Map<String, Integer> mapForOne = new HashMap<>();
				mapForOne.put("已入住", 0);
				mapForOne.put("未入住", 0);
				map.put(viewHouse.getCampusName(),mapForOne);
			}
			if (viewHouse.getStatus() == 24) {
				@SuppressWarnings("unchecked")
				Map<String, Integer> mapForOne = (Map<String, Integer>) map.get(viewHouse.getCampusName());
				mapForOne.put("未入住", mapForOne.get("未入住")+1);
			}else{
				@SuppressWarnings("unchecked")
				Map<String, Integer> mapForOne = (Map<String, Integer>) map.get(viewHouse.getCampusName());
				mapForOne.put("已入住", mapForOne.get("已入住")+1);
			}
		}
		return Msg.success().add("name", listString).add("data", map);
	}
}

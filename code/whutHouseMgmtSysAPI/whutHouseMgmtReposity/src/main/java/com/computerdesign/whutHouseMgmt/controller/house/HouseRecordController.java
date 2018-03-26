package com.computerdesign.whutHouseMgmt.controller.house;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.house.ViewHouse;
import com.computerdesign.whutHouseMgmt.bean.houseregister.HouseAllSelectModel;
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
		for (String key : map.keySet()) {
			Map<String, String> mapAl =new HashMap<String, String>();
			mapAl.put("name", key);
			mapAl.put("value", map.get(key).toString());
			listMap.add(mapAl);
		}
		return Msg.success("获取房屋统计").add("name", listString).add("content", listMap);
	}
}

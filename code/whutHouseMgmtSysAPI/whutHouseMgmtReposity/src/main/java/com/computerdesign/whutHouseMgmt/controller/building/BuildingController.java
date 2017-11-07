package com.computerdesign.whutHouseMgmt.controller.building;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.building.Building;
import com.computerdesign.whutHouseMgmt.service.building.BuildingService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping(value = "/building/")
@Controller
public class BuildingController {

	@Autowired
	private BuildingService buildingService;

	@ResponseBody
	@RequestMapping(value="get/{buildingRegion}",method=RequestMethod.GET)
	public Msg getBuildings(@PathVariable("buildingRegion")Integer buildingRegion,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size){
		
		PageHelper.startPage(page, size);
		List<Building> buildings=buildingService.getAll(buildingRegion);
		
		PageInfo pageInfo=new PageInfo(buildings);
		
		if(buildings!=null){
			return Msg.success().add("date", pageInfo);
		}else{
			return Msg.error("无法获取数据");
		}
	}
}

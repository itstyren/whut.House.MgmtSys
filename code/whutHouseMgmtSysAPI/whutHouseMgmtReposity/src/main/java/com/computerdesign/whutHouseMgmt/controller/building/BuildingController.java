package com.computerdesign.whutHouseMgmt.controller.building;

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
import com.computerdesign.whutHouseMgmt.bean.building.Building;
import com.computerdesign.whutHouseMgmt.bean.region.Region;
import com.computerdesign.whutHouseMgmt.service.building.BuildingService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping(value = "/building/")
@Controller
public class BuildingController {

	@Autowired
	private BuildingService buildingService;

	
	
	@ResponseBody
	@RequestMapping(value="get/{regionId}",method=RequestMethod.GET)
	public Msg getBuildings(@PathVariable("regionId")Integer regionId,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size){
		
		PageHelper.startPage(page, size);
		List<Building> buildings=buildingService.getAll(regionId);
		
		PageInfo pageInfo=new PageInfo(buildings);
		
		if(buildings!=null){
			return Msg.success().add("date", pageInfo);
		}else{
			return Msg.error("无法获取数据");
		}
	}
	
	@ResponseBody
	@RequestMapping(value="add",method=RequestMethod.POST)
	public Msg addBuilding(@RequestBody Building building){
		//判断必填项是否为空
		if (building.getName()==null) {
			return Msg.error("楼栋名称不能为空");
		}else if (building.getFloorArea()==null) {
			return Msg.error("占地面积不能为空");
		}else if (building.getUsedArea()==null) {
			return Msg.error("使用面积不能为空");
		}else if (building.getFloorCount()==null) {
			return Msg.error("楼层数目不能为空");
		}else if (building.getRegionId()==null) {
			return Msg.error("地区不能为空");
		}
		
		buildingService.add(building);
		return Msg.success().add("data", building);
	}
	
	@ResponseBody
	@RequestMapping(value="delete/{id}",method = RequestMethod.DELETE)
	public Msg deleteBuilding(@PathVariable("id") Integer id){
		Building building=buildingService.getById(id);
		//不存在该id
		if (building==null) {
			return Msg.error("删除失败");
		}
		
		try {
			//删除失败可能是外键约束
			buildingService.delete(id);
			return Msg.success().add("data", building);
		} catch (Exception e) {
			// TODO: handle exception
			return Msg.error("删除失败");
		}
	}
	
	@ResponseBody
	@RequestMapping(value="modify" , method = RequestMethod.PUT)
	public Msg modifyBuilding(@RequestBody Building building){
		if(building.getId()==null){
			return Msg.error("不存在该项");
		}else if (building.getName()==null) {
			return Msg.error("楼栋名称不能为空");
		}else if (building.getFloorArea()==null) {
			return Msg.error("占地面积不能为空");
		}else if (building.getUsedArea()==null) {
			return Msg.error("使用面积不能为空");
		}else if (building.getFloorCount()==null) {
			return Msg.error("楼层数目不能为空");
		}else if (building.getRegionId()==null) {
			return Msg.error("地区不能为空");
		}
		
		buildingService.update(building);
		return Msg.success().add("data", building);
	}
		
}

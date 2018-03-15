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
import com.computerdesign.whutHouseMgmt.bean.building.ViewBuilding;
import com.computerdesign.whutHouseMgmt.bean.region.Region;
import com.computerdesign.whutHouseMgmt.service.building.BuildingService;
import com.computerdesign.whutHouseMgmt.service.building.ViewBuildingService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping(value = "/building/")
@Controller
public class BuildingController {

	@Autowired
	private BuildingService buildingService;
	@Autowired
	private ViewBuildingService viewBuildingService;

	@ResponseBody
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public Msg getBuilding(@PathVariable("id") Integer id) {
		ViewBuilding viewBuilding = viewBuildingService.getViewBuildingById(id);
		if (viewBuilding == null) {
			return Msg.error("差找不到");
		}
		return Msg.success().add("data", viewBuilding);

	}

	/**
	 * get无参代表选取全部的数据
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "get", method = RequestMethod.GET)
	public Msg getBuildings(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size) {

		PageHelper.startPage(page, size);
		List<ViewBuilding> viewBuildings = viewBuildingService.getAllViewBuilding();

		PageInfo pageInfo = new PageInfo(viewBuildings);

		if (viewBuildings != null) {
			return Msg.success().add("data", pageInfo);
		} else {
			return Msg.error("无法获取数据");
		}
	}

	/**
	 * 根据regionId获取一个地区的楼栋
	 * 
	 * @param regionId
	 * @param page
	 * @param size
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getAllByRegionId/{regionId}", method = RequestMethod.GET)
	public Msg getBuildings(@PathVariable("regionId") Integer regionId,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size) {

		PageHelper.startPage(page, size);
		List<ViewBuilding> viewBuildings = viewBuildingService.getAllViewBuildingByRegionId(regionId);

		PageInfo pageInfo = new PageInfo(viewBuildings);

		if (viewBuildings != null) {
			return Msg.success().add("data", pageInfo);
		} else {
			return Msg.error("无法获取数据");
		}
	}

	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Msg addBuilding(@RequestBody Building building) {
		// 判断必填项是否为空
		if (building.getName() == null) {
			return Msg.error("楼栋名称不能为空");
		} else if (building.getFloorArea() == null) {
			return Msg.error("占地面积不能为空");
		} else if (building.getUsedArea() == null) {
			return Msg.error("使用面积不能为空");
		} else if (building.getFloorCount() == null) {
			return Msg.error("楼层数目不能为空");
		} else if (building.getRegionId() == null) {
			return Msg.error("地区不能为空");
		}
		// 判断楼栋名称是否已经存在
		if (buildingService.getAllByName(building.getName()).size() != 0) {
			return Msg.error("楼栋名称已经存在");
		}
		buildingService.add(building);
		return Msg.success().add("data", building);
	}

	@ResponseBody
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public Msg deleteBuilding(@PathVariable("id") Integer id) {
		Building building = buildingService.getBuildingById(id);
		// 不存在该id
		if (building == null) {
			return Msg.error("删除失败,不存在该id");
		}

		try {
			// 删除失败可能是外键约束
			buildingService.delete(id);
			return Msg.success().add("data", building);
		} catch (Exception e) {
			// TODO: handle exception
			return Msg.error("删除失败");
		}
	}

	@ResponseBody
	@RequestMapping(value = "modify", method = RequestMethod.PUT)
	public Msg modifyBuilding(@RequestBody Building building) {
		if (building.getId() == null) {
			return Msg.error("不存在该项");
		} else if (building.getName() == null) {
			return Msg.error("楼栋名称不能为空");
		} else if (building.getFloorArea() == null) {
			return Msg.error("占地面积不能为空");
		} else if (building.getUsedArea() == null) {
			return Msg.error("使用面积不能为空");
		} else if (building.getFloorCount() == null) {
			return Msg.error("楼层数目不能为空");
		} else if (building.getRegionId() == null) {
			return Msg.error("地区不能为空");
		}
		// 根据楼栋名获取全部的buildings
		List<Building> buildings = buildingService.getAllByName(building.getName());
		// 根据id获取要修改的building
		Building buildingPre = buildingService.getBuildingById(building.getId());
		// 判断楼栋名称是否已经存在
		if (!buildings.isEmpty()) {
			// 新添加的和要修改的是否一致
			if (!buildings.get(0).equals(buildingPre)) {
				return Msg.error("楼栋名称已经存在").add("data", buildings);
			}
		}
		buildingService.update(building);
		return Msg.success().add("data", building);
	}

}

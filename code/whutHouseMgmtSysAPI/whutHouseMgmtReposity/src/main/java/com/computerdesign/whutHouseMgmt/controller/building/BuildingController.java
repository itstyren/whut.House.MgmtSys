package com.computerdesign.whutHouseMgmt.controller.building;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.building.Building;
import com.computerdesign.whutHouseMgmt.bean.building.ViewBuilding;
import com.computerdesign.whutHouseMgmt.bean.param.houseparam.HouseParameter;
import com.computerdesign.whutHouseMgmt.bean.region.Region;
import com.computerdesign.whutHouseMgmt.service.building.BuildingService;
import com.computerdesign.whutHouseMgmt.service.building.ViewBuildingService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiOperation;

@RequestMapping(value = "/building/")
@RestController
public class BuildingController {

	@Autowired
	private BuildingService buildingService;
	@Autowired
	private ViewBuildingService viewBuildingService;

	/**
	 * 根据buildingId获取一个building
	 * 
	 * @param id
	 * @return
	 */
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

	/**
	 * 增加一个楼栋
	 * 
	 * @param building
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ApiOperation(value = "增加", notes = "id不用输入")
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

	/**
	 * 删除一个building
	 * 
	 * @param id
	 * @return
	 */
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

	/**
	 * 更改一个楼栋信息
	 * 
	 * @param building
	 * @return
	 */
	@RequestMapping(value = "modify", method = RequestMethod.PUT)
	@ApiOperation(value = "更改一个楼栋信息", notes = "!!!!!!!!!!!!!!!!!!!!!!!!!!!!非常重要，更改楼栋时，所有的信息请《手动输入》，你需要更改哪一项就输入哪一项，不填的默认不更改，下面model里面的信息是固定的，不是你要更改的楼栋的原有信息", response = com.computerdesign.whutHouseMgmt.bean.Msg.class)
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
		List<Building> buildings = buildingService.getAll();
		// 遍历这些信息
		Iterator iterator = buildings.iterator();
		while (iterator.hasNext()) {
			Building buildingAlready = (Building) iterator.next();
			if (buildingAlready.getId() != building.getId()
					&& building.getName().equals(buildingAlready.getName())) {
				return Msg.error("该名称已存在，无法修改");
			}
		}

		buildingService.update(building);
		return Msg.success().add("data", building);
	}

}

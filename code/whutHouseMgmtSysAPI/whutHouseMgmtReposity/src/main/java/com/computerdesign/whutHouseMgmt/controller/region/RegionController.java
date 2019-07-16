package com.computerdesign.whutHouseMgmt.controller.region;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.building.Building;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.region.Region;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.region.RegionWithBuilding;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.region.ViewRegion;
import com.computerdesign.whutHouseMgmt.bean.param.houseparam.HouseParameter;
import com.computerdesign.whutHouseMgmt.service.authority.AuthListService;
import com.computerdesign.whutHouseMgmt.service.building.BuildingService;
import com.computerdesign.whutHouseMgmt.service.region.RegionService;
import com.computerdesign.whutHouseMgmt.service.region.ViewRegionService;
import com.computerdesign.whutHouseMgmt.utils.MyUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping(value = "/region/")
@RestController
public class RegionController {

	@Autowired
	private RegionService regionService;
	@Autowired
	private ViewRegionService viewRegionService;
	@Autowired
	private BuildingService buildingService;
	
	@Autowired
	private AuthListService authListService;

	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public Msg getRegions(@PathVariable("id") Integer id) {

		ViewRegion viewRegion = viewRegionService.get(id);
		if (viewRegion == null) {
			return Msg.error("查找不到数据");
		} else {
			return Msg.success().add("data", viewRegion);
		}
	}

	/**
	 * 不传入page和size 默认获取全部数据
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "get", method = RequestMethod.GET)
	public Msg getRegions(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size) {
		// 分页，下一条语句为查询语句
		PageHelper.startPage(page, size);
		List<ViewRegion> viewRegions = viewRegionService.getAll();

		PageInfo<ViewRegion> pageInfo = new PageInfo<ViewRegion>(viewRegions);
		if (viewRegions == null) {
			return Msg.error("查找不到数据");
		} else {
			return Msg.success().add("data", pageInfo);
		}
	}
	
	/**
	 * 不传入page和size 获取管理员权限内的全部数据
	 * 
	 * @param manageCampus
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "getRegionsWithMP/{roleId}", method = RequestMethod.GET)
	public Msg getRegionsWithMP(@PathVariable("roleId") Integer roleId, @RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size) {
		// 分页，下一条语句为查询语句
		PageHelper.startPage(page, size);
		
		String manageCampus = authListService.getOneAuth(roleId).getManageCampus();
//		System.out.println(manageCampus);
//		解析manageCampus字段，获取管理员权限内的校区
//		String[] campusStr = manageCampus.split("-");
//		List<Integer> campusList = new ArrayList<>();
//		for (String campus : campusStr){
//			campusList.add(Integer.valueOf(campus));
//		}
		List<Integer> campusList = MyUtils.roleIdToMP(manageCampus);
		System.out.println(campusList);
		
		List<ViewRegion> viewRegions = viewRegionService.getAllWithMP(campusList);

		PageInfo<ViewRegion> pageInfo = new PageInfo<ViewRegion>(viewRegions);
		if (viewRegions == null) {
			return Msg.error("查找不到数据");
		} else {
			return Msg.success().add("data", pageInfo);
		}
	}

	/**
	 * 根据id获取带有building内容的数据
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "getRegionWithBuildings/{id}", method = RequestMethod.GET)
	public Msg getRegionWithBuildings(@PathVariable("id") Integer id) {

		ViewRegion viewRegion = viewRegionService.get(id);
		List<Building> buildingList = buildingService.getAllByRegionId(id);

		RegionWithBuilding regionWithBuilding = new RegionWithBuilding(viewRegion, buildingList);

		if (viewRegion == null) {
			return Msg.error("查找不到数据");
		} else {
			return Msg.success().add("data", regionWithBuilding);
		}
	}

	/**
	 * 不传参默认获取全部数据且不分页
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "getRegionWithBuildings", method = RequestMethod.GET)
	public Msg getgetRegionWithBuildings(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size) {
		List<ViewRegion> viewRegions = viewRegionService.getAll();

		List<Building> buildings = buildingService.getAll();
		List<RegionWithBuilding> regionWithBuildings = new ArrayList<RegionWithBuilding>();

		for (ViewRegion viewRegion : viewRegions) {
			List<Building> buildingList = new ArrayList<Building>();
			for (Building building : buildings) {
				if (building.getRegionId() == viewRegion.getId()) {
					buildingList.add(building);
				}
			}
			regionWithBuildings.add(new RegionWithBuilding(viewRegion, buildingList));
		}
		// 分页，下一条语句为查询语句
		// PageInfo pageInfo = new PageInfo(regionWithBuildings);

		return Msg.success().add("data", regionWithBuildings);
	}

	/**
	 * 增加一个region
	 * 
	 * @param region
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Msg addRegion(@RequestBody Region region) {
		// 区域名不能为空
		if (region.getName() == null) {
			return Msg.error("区域名不能为空");
		}
		if (region.getCampusId() == null) {
			return Msg.error("校区id不能为空");
		}
		regionService.add(region);
		return Msg.success().add("data", region);

	}

	/**
	 * 修改一个region
	 * 
	 * @param region
	 * @return
	 */
	@RequestMapping(value = "modify", method = RequestMethod.PUT)
	public Msg modifyRegion(@RequestBody Region region) {
		if (region.getId() == null) {
			return Msg.error("不存在该项");
		}
		if (region.getName() == null) {// 区域名不能为空
			return Msg.error("区域名不能为空");
		}
		List<Region> regions = regionService.getAll();
		// 遍历这些信息
		Iterator<Region> iterator = regions.iterator();
		
		while (iterator.hasNext()) {
			Region regionAlready = (Region) iterator.next();
			if (regionAlready.getId() != region.getId() && region.getName().equals(regionAlready.getName())) {
				return Msg.error("该名称已存在，无法修改");
			}
		}
		regionService.update(region);
		return Msg.success().add("data", region);
	}

	/**
	 * 根据regionId删除一个region
	 * 
	 * @param Id
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "delete/{Id}", method = RequestMethod.DELETE)
	public Msg deleteRegion(@PathVariable("Id") Integer Id) {
		Region region = regionService.get(Id);

		if (region == null) {
			return Msg.error("找不到该Id");
		}
		try {
			// 外键约束
			regionService.delete(Id);
			return Msg.success();
		} catch (Exception e) {
			// TODO: handle exception
			return Msg.error("请先删除该地区的所有楼栋").add("data", region);
		}
	}
}

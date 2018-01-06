package com.computerdesign.whutHouseMgmt.controller.region;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

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
import com.computerdesign.whutHouseMgmt.bean.region.RegionWithBuilding;
import com.computerdesign.whutHouseMgmt.dao.region.RegionMapper;
import com.computerdesign.whutHouseMgmt.service.building.BuildingService;
import com.computerdesign.whutHouseMgmt.service.region.RegionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping(value = "/region/")
@Controller
public class RegionController {

	@Autowired
	private RegionService regionService;
	@Autowired
	private BuildingService buildingService;

	@ResponseBody
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public Msg getRegions(@PathVariable("id") Integer id) {

		Region region = regionService.get(id);
		if (region == null) {
			return Msg.error("查找不到数据");
		} else {
			return Msg.success().add("data", region);
		}
	}
	
	/**
	 * 不传入page和size 默认获取全部数据
	 * @param page
	 * @param size
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "get", method = RequestMethod.GET)
	public Msg getRegions(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size) {
		//分页，下一条语句为查询语句
		PageHelper.startPage(page,size);
		List<Region> regions = regionService.getAll();

		PageInfo pageInfo = new PageInfo(regions);
		if (regions == null) {
			return Msg.error("查找不到数据");
		} else {
			return Msg.success().add("data", pageInfo);
		}
	}
	
	/**
	 * 根据id获取带有building内容的数据
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getRegionWithBuildings/{id}", method = RequestMethod.GET)
	public Msg getRegionWithBuildings(@PathVariable("id") Integer id) {

		Region region = regionService.get(id);
		List<Building> buildingList = buildingService.getAllByRegionId(id);

		RegionWithBuilding regionWithBuilding = new RegionWithBuilding(region, buildingList);

		if (region == null) {
			return Msg.error("查找不到数据");
		} else {
			return Msg.success().add("data", regionWithBuilding);
		}
	}

	/**
	 * 不传参默认获取全部数据且不分页
	 * @param page
	 * @param size
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getRegionWithBuildings", method = RequestMethod.GET)
	public Msg getgetRegionWithBuildings(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size) {
		List<Region> regions = regionService.getAll();

		List<Building> buildings = buildingService.getAll();
		List<RegionWithBuilding> regionWithBuildings =new ArrayList<RegionWithBuilding>();
		
		for (Region region : regions) {	
			List<Building> buildingList = new ArrayList<Building>();
			for (Building building : buildings) {
				if (building.getRegionId()==region.getId()) {
					buildingList.add(building);
				}
			}
			regionWithBuildings.add(new RegionWithBuilding(region, buildingList));
		}
		//分页，下一条语句为查询语句
		//PageInfo pageInfo = new PageInfo(regionWithBuildings);

		if (regionWithBuildings == null) {
			return Msg.error("查找不到数据");
		} else {
			return Msg.success().add("data", regionWithBuildings);
		}
	}

	

	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Msg addRegion(@RequestBody Region region) {
		// 区域名不能为空
		if (region.getName() == null) {
			return Msg.error("区域名不能为空");
		} else {
			regionService.add(region);
			return Msg.success().add("data", region);
		}
	}

	/**
	 * 修改一个region
	 * @param region
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "modify", method = RequestMethod.PUT)
	public Msg modifyRegion(@RequestBody Region region) {
		if (region.getId() == null) {
			return Msg.error("不存在该项");
			// 区域名不能为空
		} else if (region.getName() == null) {
			return Msg.error("区域名不能为空");
		}
		List<Region> regions = regionService.getAllByName(region.getName());
		Region regionPre = regionService.get(region.getId());
		if(!regions.isEmpty()){
			if(regionPre.getId()!=regions.get(0).getId()){
				return Msg.error("该楼栋名称已存在");
			}
		}
		regionService.update(region);
		return Msg.success().add("data", region);
	}

	/**
	 * 根据regionId删除一个region
	 * @param Id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "delete/{Id}", method = RequestMethod.DELETE)
	public Msg deleteRegion(@PathVariable("Id") Integer Id) {
		Region region = regionService.get(Id);

		if (region != null) {
			try {
				// 外键约束
				regionService.delete(Id);
				return Msg.success();
			} catch (Exception e) {
				// TODO: handle exception
				return Msg.error("请先删除该地区的所有楼栋").add("data", region);
			}
		} else {
			return Msg.error("找不到该Id");
		}
	}
}

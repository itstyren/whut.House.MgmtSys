package com.computerdesign.whutHouseMgmt.controller.house;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Path;

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
import com.computerdesign.whutHouseMgmt.bean.house.House;
import com.computerdesign.whutHouseMgmt.bean.houseregister.HouseAllSelectModel;
import com.computerdesign.whutHouseMgmt.bean.houseregister.HouseAllShowModel;
import com.computerdesign.whutHouseMgmt.bean.houseregister.HouseSelectModel;
import com.computerdesign.whutHouseMgmt.bean.houseregister.HouseShowModel;
import com.computerdesign.whutHouseMgmt.bean.houseregister.StaffHouseRel;
import com.computerdesign.whutHouseMgmt.bean.param.houseparam.HouseParameter;
import com.computerdesign.whutHouseMgmt.bean.house.ViewHouse;
import com.computerdesign.whutHouseMgmt.service.building.BuildingService;
import com.computerdesign.whutHouseMgmt.service.house.HouseService;
import com.computerdesign.whutHouseMgmt.service.houseparam.HouseParamService;
import com.computerdesign.whutHouseMgmt.service.houseregister.StaffHouseRelService;
import com.computerdesign.whutHouseMgmt.service.house.ViewHouseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiOperation;

@RequestMapping(value = "/house/")
@Controller
public class HouseController {

	@Autowired
	private HouseService houseService;

	@Autowired
	private HouseParamService houseParamService;

	@Autowired
	private BuildingService buildingService;

	@Autowired
	private ViewHouseService viewHouseService;

	/**
	 * 根据id获取一个House
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Msg get(@PathVariable("id") Integer id) {
		if (viewHouseService.get(id).isEmpty()) {
			return Msg.error("查找不到数据");
		}
		ViewHouse viewHouse = viewHouseService.get(id).get(0);
		// 每平方米的价格
		double rentPer = houseParamService.getRentalByStruce(viewHouse.getStruct());
		// 每平方米的价格*面积
		viewHouse.setRental(rentPer * viewHouse.getBuildArea());
		return Msg.success().add("data", viewHouse);

	}

	/**
	 * 获取全部的house并且不分页
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "get", method = RequestMethod.GET)
	@ResponseBody
	public Msg get(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size) {

		PageHelper.startPage(page, size);
		List<ViewHouse> viewHouseList = viewHouseService.getAll();

		if (viewHouseList == null || viewHouseList.isEmpty()) {
			return Msg.success("没有房屋数据");
		}
		for (ViewHouse viewHouse : viewHouseList) {
			// 每平方米的价格
			double rentPer = houseParamService.getRentalByStruce(viewHouse.getStruct());
			// 每平方米的价格*面积
			viewHouse.setRental(rentPer * viewHouse.getBuildArea());
		}
		PageInfo pageInfo = new PageInfo(viewHouseList);

		return Msg.success().add("data", pageInfo);

	}

	/**
	 * 根据regionId查找属于某一栋的viewhouse
	 * 
	 * @param regionId
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "getViewHousesByRegionId/{regionId}", method = RequestMethod.GET)
	@ResponseBody
	public Msg getViewHouseByRegionId(@PathVariable("regionId") Integer regionId,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size) {

		List<Building> buildingsList = buildingService.getAllByRegionId(regionId);
		List<Integer> buildingIdList = new ArrayList<Integer>();
		for (Building building : buildingsList) {
			if (!buildingIdList.contains(building.getId())) {
				buildingIdList.add(building.getId());
			}
		}
		PageHelper.startPage(page, size);
		List<ViewHouse> viewHouseList = viewHouseService.getViewHousesByRegionId(buildingIdList);

		for (ViewHouse viewHouse : viewHouseList) {
			// 每平方米的价格
			double rentPer = houseParamService.getRentalByStruce(viewHouse.getStruct());
			// 每平方米的价格*面积
			viewHouse.setRental(rentPer * viewHouse.getBuildArea());
		}
		PageInfo pageInfo = new PageInfo(viewHouseList);

		if (viewHouseList == null) {
			return Msg.error("查找不到数据");
		} else {
			return Msg.success().add("data", pageInfo);
		}
	}

	/**
	 * 根据buildingId查找属于某一栋的viewhouse
	 * 
	 * @param buildingId
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "getViewHousesByBuildingId/{buildingId}", method = RequestMethod.GET)
	@ResponseBody
	public Msg getViewHousesByBuildingId(@PathVariable("buildingId") Integer buildingId,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size) {

		PageHelper.startPage(page, size);
		List<ViewHouse> viewHouseList = viewHouseService.getViewHousesByBuildingId(buildingId);

		for (ViewHouse viewHouse : viewHouseList) {
			// 每平方米的价格
			double rentPer = houseParamService.getRentalByStruce(viewHouse.getStruct());
			// 每平方米的价格*面积
			viewHouse.setRental(rentPer * viewHouse.getBuildArea());
		}
		PageInfo pageInfo = new PageInfo(viewHouseList);

		return Msg.success().add("data", pageInfo);
	}

	/**
	 * 添加一个house
	 * 
	 * @param house
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public Msg addHouse(@RequestBody House house) {

		if (house.getNo() == null) {
			return Msg.error("房屋编号不能为空");
		}
		if (house.getType() == null) {
			return Msg.error("房屋类型不能为空");
		}
		if (house.getLayout() == null) {
			return Msg.error("户型不能为空");
		}
		if (house.getStruct() == null) {
			return Msg.error("房屋结构不能为空");
		}
		if (house.getBuildingId() == null) {
			return Msg.error("房屋楼栋不能为空");
		}

		List<House> housePres = houseService.getHouseByNo(house.getNo());
		if (!housePres.isEmpty()) {
			return Msg.error("该房屋编号已经存在").add("error-data", housePres);
		}
		// 1.住房类型
		// 2.户型
		// 3.使用状态
		// 4.住房结构
		List<Integer> houseTypeParamIds = houseParamService.getHouseParamId(1);
		if (!houseTypeParamIds.contains(house.getType())) {
			return Msg.error("不存在的住房类型");
		}
		List<Integer> houseLayoutParamIds = houseParamService.getHouseParamId(2);
		if (!houseLayoutParamIds.contains(house.getLayout())) {
			return Msg.error("不存在的住房类型");
		}
		List<Integer> houseStructParamIds = houseParamService.getHouseParamId(4);
		if (!houseStructParamIds.contains(house.getStruct())) {
			return Msg.error("不存在的住房类型");
		}

		houseService.add(house);
		return Msg.success().add("data", house);
	}

	/**
	 * 根据id删除某一house
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Msg deleteHouse(@PathVariable("id") Integer id) {
		// 不存在该id
		if (houseService.get(id) == null) {
			return Msg.error("删除失败");
		}
		// 删除失败可能是外键约束
		try {
			houseService.delete(id);
			return Msg.success("删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			return Msg.error("删除失败");
		}
	}

	/**
	 * 修改
	 * 
	 * @param house
	 * @return
	 */
	@RequestMapping(value = "modify", method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value= "更改房屋信息",notes="!!!!!!!!!!!!!!!!!!!!!!!!!!!!非常重要，更改楼栋时，所有的信息请《手动输入》，你需要更改哪一项就输入哪一项，不填的默认不更改",response=com.computerdesign.whutHouseMgmt.bean.Msg.class)
	public Msg modifyHouse(@RequestBody House house) {
		// 基本不会出现这样的情况

		if (house.getNo() == null) {
			return Msg.error("房屋编号不能为空");
		} else if (house.getType() == null) {
			return Msg.error("房屋类型不能为空");
		} else if (house.getLayout() == null) {
			return Msg.error("户型不能为空");
		} else if (house.getStruct() == null) {
			return Msg.error("房屋结构不能为空");
		} else if (house.getBuildingId() == null) {
			return Msg.error("房屋楼栋不能为空");
		}

		// 根据传入的编号获取数据库中的该house
		List<House> housePres = houseService.getHouseByNo(house.getNo());
		// 根据传入的id获取数据库中的该house
		House housePre = houseService.get(house.getId());
		if (!housePres.isEmpty()) {
			// 根据id获取的house和根据编号获取的house不一样
			if (housePre.getId() != housePres.get(0).getId()) {
				return Msg.error("房屋已经存在");
			}
		}

		List<Integer> houseTypeParamIds = houseParamService.getHouseParamId(1);
		if (!houseTypeParamIds.contains(house.getType())) {
			return Msg.error("不存在的住房类型");
		}
		List<Integer> houseLayoutParamIds = houseParamService.getHouseParamId(2);
		if (!houseLayoutParamIds.contains(house.getLayout())) {
			return Msg.error("不存在的住房类型");
		}

		List<Integer> houseStructParamIds = houseParamService.getHouseParamId(4);
		if (!houseStructParamIds.contains(house.getStruct())) {
			return Msg.error("不存在的住房类型");
		}

		try {
			houseService.update(house);
			return Msg.success("修改成功");
		} catch (Exception e) {
			// TODO: handle exception
			return Msg.error("修改失败");
		}

	}
}

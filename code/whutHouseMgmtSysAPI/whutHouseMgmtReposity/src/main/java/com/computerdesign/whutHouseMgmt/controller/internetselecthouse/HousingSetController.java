package com.computerdesign.whutHouseMgmt.controller.internetselecthouse;

import java.util.ArrayList;
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
import com.computerdesign.whutHouseMgmt.bean.houseManagement.house.House;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.house.ViewHouse;
import com.computerdesign.whutHouseMgmt.bean.houseregister.HouseAllSelectModel;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.HousingInfo;
import com.computerdesign.whutHouseMgmt.service.house.HouseService;
import com.computerdesign.whutHouseMgmt.service.internetselecthouse.HousingSetService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping(value = "/housingSet/")
@Controller
public class HousingSetController {

	@Autowired
	private HousingSetService housingSetService;

	@Autowired
	private HouseService houseService;

	/**
	 * 撤销设置房源
	 * 
	 * @param houseId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "cancelSetHousing", method = RequestMethod.POST)
	public Msg cancelSetHousing(@RequestBody int[] houseIds) {
		if (houseIds != null) {
			for (int houseId : houseIds) {
				House house = houseService.get(houseId);
				house.setRecordStatus(2);
				housingSetService.setHousing(house);
			}
			return Msg.success("撤销设置房源成功");
		}
		return Msg.error();
	}

	/**
	 * 设置房源为可选
	 * 
	 * @param houseId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "setHousing", method = RequestMethod.POST)
	public Msg setHousing(@RequestBody int[] houseIds) {
		if (houseIds != null) {
			for (int houseId : houseIds) {
				House house = houseService.get(houseId);
				house.setRecordStatus(0);
				housingSetService.setHousing(house);
			}
			return Msg.success("设置房源成功");
		}
		return Msg.error();
	}

	/**
	 * 根据组合条件查找显示未设置房源
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "activeHouseShowByMultiCondition", method = RequestMethod.POST)
	public Msg activeHouseShowByMultiCondition(@RequestBody HouseAllSelectModel houseAllSelectModel,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "5") Integer size) {
		// System.out.println(houseAllSelectModel.getAreaParameter().getAreaParamName());
		PageHelper.startPage(page, size);
		List<ViewHouse> viewHouses = housingSetService.selectActiveHousingMultiCondition(houseAllSelectModel);
		List<HousingInfo> housingInfos = new ArrayList<HousingInfo>();
		for (ViewHouse viewHouse : viewHouses) {
			HousingInfo housingInfo = new HousingInfo();
			housingInfo.setNo(viewHouse.getNo());
			housingInfo.setLayout(viewHouse.getLayoutName());
			housingInfo.setUsedArea(viewHouse.getUsedArea());
			housingInfo.setRegionName(viewHouse.getRegionName());
			housingInfo.setBuildingName(viewHouse.getBuildingName());
			housingInfo.setAddress(viewHouse.getAddress());
			housingInfo.setRental(viewHouse.getRental());
			housingInfos.add(housingInfo);
		}
		PageInfo pageInfo = new PageInfo(viewHouses);
		pageInfo.setList(housingInfos);
		return Msg.success().add("data", pageInfo);
	}

	/**
	 * 根据组合条件查找显示已设置房源
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "canselectHouseShowByMultiCondition", method = RequestMethod.POST)
	public Msg canselectHouseShowByMultiCondition(@RequestBody HouseAllSelectModel houseAllSelectModel,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "5") Integer size) {
		PageHelper.startPage(page, size);
		List<ViewHouse> viewHouses = housingSetService.selectCanselectHousingMultiCondition(houseAllSelectModel);
		List<HousingInfo> housingInfos = new ArrayList<HousingInfo>();
		for (ViewHouse viewHouse : viewHouses) {
			HousingInfo housingInfo = new HousingInfo();
			housingInfo.setId(viewHouse.getId());
			housingInfo.setNo(viewHouse.getNo());
			housingInfo.setLayout(viewHouse.getLayoutName());
			housingInfo.setUsedArea(viewHouse.getUsedArea());
			housingInfo.setRegionName(viewHouse.getRegionName());
			housingInfo.setBuildingName(viewHouse.getBuildingName());
			housingInfo.setAddress(viewHouse.getAddress());
			housingInfo.setRental(viewHouse.getRental());
			housingInfos.add(housingInfo);
		}
		PageInfo pageInfo = new PageInfo(viewHouses);
		pageInfo.setList(housingInfos);

		return Msg.success().add("data", pageInfo);
	}

	/**
	 * 初始显示已设置房源(canselect)
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "canselectHouseShow", method = RequestMethod.GET)
	public Msg canselectHouseShow(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {
		PageHelper.startPage(page, size);
		List<ViewHouse> viewHouses = housingSetService.canselectHouseShow();
		List<HousingInfo> housingInfos = new ArrayList<HousingInfo>();
		for (ViewHouse viewHouse : viewHouses) {
			HousingInfo housingInfo = new HousingInfo();
			housingInfo.setNo(viewHouse.getNo());
			housingInfo.setLayout(viewHouse.getLayoutName());
			housingInfo.setUsedArea(viewHouse.getUsedArea());
			housingInfo.setRegionName(viewHouse.getRegionName());
			housingInfo.setBuildingName(viewHouse.getBuildingName());
			housingInfo.setAddress(viewHouse.getAddress());
			housingInfo.setRental(viewHouse.getRental());
			housingInfos.add(housingInfo);
		}
		PageInfo pageInfo = new PageInfo(viewHouses);
		pageInfo.setList(housingInfos);
		return Msg.success().add("data", pageInfo);
	}

	/**
	 * 初始显示未设置房源(active)
	 * 
	 * @param houseAllSelectModel
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "activeHouseShow", method = RequestMethod.GET)
	public Msg activeHouseShow(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {
		PageHelper.startPage(page, size);
		List<ViewHouse> viewHouses = housingSetService.activeHouseShow();
		List<HousingInfo> housingInfos = new ArrayList<HousingInfo>();
		for (ViewHouse viewHouse : viewHouses) {
			HousingInfo housingInfo = new HousingInfo();
			housingInfo.setNo(viewHouse.getNo());
			housingInfo.setLayout(viewHouse.getLayoutName());
			housingInfo.setUsedArea(viewHouse.getUsedArea());
			housingInfo.setRegionName(viewHouse.getRegionName());
			housingInfo.setBuildingName(viewHouse.getBuildingName());
			housingInfo.setAddress(viewHouse.getAddress());
			housingInfo.setRental(viewHouse.getRental());
			housingInfos.add(housingInfo);
		}
		PageInfo pageInfo = new PageInfo(viewHouses);
		pageInfo.setList(housingInfos);
		return Msg.success().add("data", pageInfo);
	}

}

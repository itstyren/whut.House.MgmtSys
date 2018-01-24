package com.computerdesign.whutHouseMgmt.controller.houseregister;

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
import com.computerdesign.whutHouseMgmt.bean.houseparam.HouseParameter;
import com.computerdesign.whutHouseMgmt.bean.houseregister.HouseAllSelectModel;
import com.computerdesign.whutHouseMgmt.bean.houseregister.HouseAllShowModel;
import com.computerdesign.whutHouseMgmt.bean.houseregister.HouseSelectModel;
import com.computerdesign.whutHouseMgmt.bean.houseregister.HouseShowModel;
import com.computerdesign.whutHouseMgmt.bean.houseregister.Resident;
import com.computerdesign.whutHouseMgmt.bean.houseregister.StaffHouseRel;
import com.computerdesign.whutHouseMgmt.bean.house.ViewHouse;
import com.computerdesign.whutHouseMgmt.service.building.BuildingService;
import com.computerdesign.whutHouseMgmt.service.house.HouseService;
import com.computerdesign.whutHouseMgmt.service.houseparam.HouseParamService;
import com.computerdesign.whutHouseMgmt.service.houseregister.HouseRegisterSelectService;
import com.computerdesign.whutHouseMgmt.service.houseregister.RegisterService;
import com.computerdesign.whutHouseMgmt.service.houseregister.StaffHouseRelService;
import com.computerdesign.whutHouseMgmt.service.house.ViewHouseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping(value = "/houseRegister/")
@Controller
public class HouseRegisterController {
	
	@Autowired
	private HouseRegisterSelectService houseRegisterSelectService;

	@Autowired
	private StaffHouseRelService staffHouseRelService;

	@Autowired
	private RegisterService registerService;
	
	/**
	 * 登记关系设置，提交修改的登记关系
	 * @return
	 */
	@RequestMapping(value = "updateRegisterRel", method = RequestMethod.POST)
	@ResponseBody
	public Msg updateRegisterRel(@RequestBody HouseParameter houseParameter){
		if(houseParameter == null){
			return Msg.error("数据封装错误");
		}
		if(houseParameter.getHouseParamId() == null){
			return Msg.error("需要传递id");
		}
		registerService.updateRegisterRel(houseParameter);
		//显示HouseParamName和修改后的HouseParamRel
		return Msg.success().add("name", houseParameter.getHouseParamName()).add("rel", houseParameter.getHouseParamRel());
	}

	/**
	 * 登记关系设置，获取所有登记关系，使用pm_housetype表，paramTypeId为1
	 * @return
	 */
	@RequestMapping(value = "getRegisterRel", method = RequestMethod.GET)
	@ResponseBody
	public Msg getRegisterRel(){
		List<HouseParameter> houseParameters = registerService.getRegisterRel();
		if(houseParameters == null){
			return Msg.error("数据库中无数据或被删除");
		}
		return Msg.success().add("data", houseParameters);
	}
	
	/**
	 * 住房登记
	 * @param resident
	 * @return
	 */
	@RequestMapping(value = "register", method = RequestMethod.PUT)
	@ResponseBody
	public Msg register(@RequestBody Resident resident){
		//System.out.println(resident.getStaffId());
		//System.out.println(registerService.getCount());
		//根据数据库中的记录数+1
		resident.setId(registerService.getCount()+1);
		if(resident.getStaffId() == null){
			return Msg.error("请选择一个员工");
		}
		if(resident.getHouseId() == null){
			return Msg.error("请选择住房");
		}
		//若没有选择住房关系，则默认为全部，返回0，错误提示
		if(resident.getHouseRel() == 0){
			return Msg.error("住房关系不能选择全部");
		}
		resident.setFamilyCode(resident.getStaffId().toString());
		//具体可能要见Rent表
		resident.setRentType("工资");
		registerService.register(resident);
		return Msg.success().add("data", resident);
	}
	
	/**
	 * 职工房屋关系查询
	 * 
	 * @param staffNo
	 * @return
	 */
	@RequestMapping(value = "getStaffHouseRel/{staffNo}", method = RequestMethod.GET)
	@ResponseBody
	public Msg getStaffHouseRel(@PathVariable("staffNo") String staffNo) {
		if (staffNo != null) {
			List<StaffHouseRel> staffHouseRels = staffHouseRelService.selectByStaffNo(staffNo);
			return Msg.success().add("data", staffHouseRels);
		}
		return Msg.error();
	}

	/**
	 * 全面多条件查询
	 * 
	 * @param houseSelectModel
	 * @return
	 */
	@RequestMapping(value = "getByAllMultiCondition", method = RequestMethod.POST)
	@ResponseBody
	public Msg getByAllMultiCondition(@RequestBody HouseAllSelectModel houseAllSelectModel) {
		// 查询出所有符合条件的视图所有数据
		List<ViewHouse> viewHouses = houseRegisterSelectService.getByAllMultiConditionQuery(houseAllSelectModel);

		// 声明一个list，用于封装需要的数据
		List<HouseAllShowModel> houseAllShowModels = new ArrayList<HouseAllShowModel>();

		// 给需要返回显示的数据赋值
		for (ViewHouse viewHouse : viewHouses) {
			HouseAllShowModel houseAllShowModel = new HouseAllShowModel();
			houseAllShowModel.setHouseNo(viewHouse.getNo());
			houseAllShowModel.setHouseSort(viewHouse.getTypeName());
			houseAllShowModel.setHouseType(viewHouse.getLayoutName());
			houseAllShowModel.setUseStatus(viewHouse.getStatusName());
			houseAllShowModel.setBuildArea(viewHouse.getBuildArea());
			houseAllShowModel.setUsedArea(viewHouse.getUsedArea());
			houseAllShowModel.setBasementArea(viewHouse.getBasementArea());
			houseAllShowModel.setAddress(viewHouse.getAddress());
			houseAllShowModel.setFinishTime(viewHouse.getFinishTime());
			houseAllShowModel.setBuildingName(viewHouse.getBuildingName());
			houseAllShowModels.add(houseAllShowModel);
		}

		System.out.println(houseAllShowModels);

		return Msg.success().add("data", houseAllShowModels);
	}

	/**
	 * 多条件查询
	 * 
	 * @param houseSelectModel
	 * @return
	 */
	@RequestMapping(value = "getByMultiCondition", method = RequestMethod.POST)
	@ResponseBody
	public Msg getByMultiCondition(@RequestBody HouseSelectModel houseSelectModel) {
		// 查询出所有符合条件的视图所有数据
		List<ViewHouse> viewHouses = houseRegisterSelectService.getByMultiConditionQuery(houseSelectModel);

		// 声明一个list，用于封装需要的数据
		List<HouseShowModel> houseShowModels = new ArrayList<HouseShowModel>();

		// 给需要返回显示的数据赋值
		for (ViewHouse viewHouse : viewHouses) {
			HouseShowModel houseShowModel = new HouseShowModel();
			houseShowModel.setHouseNo(viewHouse.getNo());
			houseShowModel.setHouseSort(viewHouse.getTypeName());
			houseShowModel.setHouseType(viewHouse.getLayoutName());
			houseShowModel.setUseStatus(viewHouse.getStatusName());
			houseShowModel.setUsedArea(viewHouse.getUsedArea());
			houseShowModel.setAddress(viewHouse.getAddress());
			houseShowModel.setZoneName(viewHouse.getRegionName());
			houseShowModel.setBuildingName(viewHouse.getBuildingName());
			houseShowModels.add(houseShowModel);
		}

		System.out.println(houseShowModels);

		return Msg.success().add("data", houseShowModels);
	}

}

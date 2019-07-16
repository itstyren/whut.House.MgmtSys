package com.computerdesign.whutHouseMgmt.controller.house;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.house.ViewHouse;
import com.computerdesign.whutHouseMgmt.bean.houseregister.HouseAllSelectModel;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.HouseStaff;
import com.computerdesign.whutHouseMgmt.service.authority.AuthListService;
import com.computerdesign.whutHouseMgmt.service.campus.CampusService;
import com.computerdesign.whutHouseMgmt.service.house.ViewHouseService;
import com.computerdesign.whutHouseMgmt.service.houseregister.HouseRegisterSelectService;
import com.computerdesign.whutHouseMgmt.service.internetselecthouse.HouseStaffService;
import com.computerdesign.whutHouseMgmt.utils.Arith;
import com.computerdesign.whutHouseMgmt.utils.MyUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 *
 * @author wanhaoran
 * @date 2018年3月25日 上午8:49:01
 * 
 */
@RestController
@RequestMapping(value = "/houseRecord/")
@Api(value = "房屋记录Controller", description = "房屋记录接口")
public class HouseRecordController {

	@Autowired
	private ViewHouseService viewhouseService;

	@Autowired
	private HouseRegisterSelectService houseRegisterSelectService;

	@Autowired
	private CampusService campusService;


	@Autowired
	private HouseStaffService houseStaffService;

	@Autowired
	private AuthListService authListService;
	
	/**
	 * 房屋总数据
	 * 
	 * @param houseAllSelectModel
	 * @return
	 */
	@PostMapping(value = "houseTotal")
	public Msg getHouseTotal(@RequestBody HouseAllSelectModel houseAllSelectModel) {
		List<ViewHouse> listViewHouse = houseRegisterSelectService.getByAllMultiConditionQuery(houseAllSelectModel);
		// List<Map<String, Object>> listMap = new ArrayList<>();
		double totalBuildArea = 0, totalUsedArea = 0, unoccupiedArea = 0, occupiedArea = 0;
		int unoccupiedNumber = 0, occupiedNumber = 0;
		for (ViewHouse viewhouse : listViewHouse) {
			totalBuildArea += viewhouse.getBuildArea();
			totalUsedArea += viewhouse.getUsedArea();

			if (viewhouse.getStatusName().equals("空闲")) {
				unoccupiedNumber++;
				unoccupiedArea += viewhouse.getBuildArea();
			} else {
				occupiedNumber++;
				occupiedArea += viewhouse.getBuildArea();
			}
		}
		Map<String, Object> map = new HashMap<>();
		map.put("totalBuildArea", Arith.round(totalBuildArea, 2));
		map.put("totalUsedArea", Arith.round(totalUsedArea, 2));
		map.put("unoccupiedNumber", unoccupiedNumber);
		map.put("unoccupiedArea", Arith.round(unoccupiedArea, 2));
		map.put("occupiedNumber", occupiedNumber);
		map.put("occupiedArea", Arith.round(occupiedArea, 2));

		return Msg.success().add("data", map);
	}

	/**
	 * 房屋总数据附带管理员权限（数据分析）
	 * @param roleId
	 * @param houseAllSelectModel
	 * @return
	 */
	@PostMapping(value = "houseTotal/{roleId}")
	public Msg getHouseTotalWithMP(@PathVariable("roleId") Integer roleId,@RequestBody HouseAllSelectModel houseAllSelectModel) {
//		获取管理员权限范围的校区
		String manageCampus = authListService.getOneAuth(roleId).getManageCampus();
		List<Integer> campusList = MyUtils.roleIdToMP(manageCampus);
		
		List<ViewHouse> listViewHouse = houseRegisterSelectService.getByAllMultiConditionQueryWithMP(houseAllSelectModel, campusList);
		// List<Map<String, Object>> listMap = new ArrayList<>();
		double totalBuildArea = 0, totalUsedArea = 0, unoccupiedArea = 0, occupiedArea = 0;
		int unoccupiedNumber = 0, occupiedNumber = 0;
		for (ViewHouse viewhouse : listViewHouse) {
			totalBuildArea += viewhouse.getBuildArea();
			totalUsedArea += viewhouse.getUsedArea();

			if (viewhouse.getStatusName().equals("空闲")) {
				unoccupiedNumber++;
				unoccupiedArea += viewhouse.getBuildArea();
			} else {
				occupiedNumber++;
				occupiedArea += viewhouse.getBuildArea();
			}
		}
		Map<String, Object> map = new HashMap<>();
		map.put("totalBuildArea", Arith.round(totalBuildArea, 2));
		map.put("totalUsedArea", Arith.round(totalUsedArea, 2));
		map.put("unoccupiedNumber", unoccupiedNumber);
		map.put("unoccupiedArea", Arith.round(unoccupiedArea, 2));
		map.put("occupiedNumber", occupiedNumber);
		map.put("occupiedArea", Arith.round(occupiedArea, 2));

		return Msg.success().add("data", map);
	}
	
	/**
	 * 按照查询条件获取房屋类型统计
	 * 
	 * @param paramTypeId
	 * @param houseAllSelectModel
	 * @return
	 */
	@PostMapping(value = "Content")
	@ApiOperation(notes = "获取房屋类型", value = "获取房屋类型")
	public Msg getHouseRecordContent(@RequestParam("paramTypeId") Integer paramTypeId,
			@RequestBody HouseAllSelectModel houseAllSelectModel) {
		List<ViewHouse> listViewHouse = houseRegisterSelectService.getByAllMultiConditionQuery(houseAllSelectModel);

		List<String> listString = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		if (paramTypeId == 1) {
			for (ViewHouse viewHouse : listViewHouse) {
				if (!listString.contains(viewHouse.getTypeName())) {
					listString.add(viewHouse.getTypeName());
				}
				if (!map.containsKey(viewHouse.getTypeName())) {
					map.put(viewHouse.getTypeName(), 0);
				}
				map.put(viewHouse.getTypeName(), map.get(viewHouse.getTypeName()) + 1);
			}
		}
		if (paramTypeId == 2) {
			for (ViewHouse viewHouse : listViewHouse) {
				if (!listString.contains(viewHouse.getLayoutName())) {
					listString.add(viewHouse.getLayoutName());
				}
				if (!map.containsKey(viewHouse.getLayoutName())) {
					map.put(viewHouse.getLayoutName(), 0);
				}
				map.put(viewHouse.getLayoutName(), map.get(viewHouse.getLayoutName()) + 1);
			}
		}
		if (paramTypeId == 3) {
			for (ViewHouse viewHouse : listViewHouse) {
				if (!listString.contains(viewHouse.getStatusName())) {
					listString.add(viewHouse.getStatusName());
				}
				if (!map.containsKey(viewHouse.getStatusName())) {
					map.put(viewHouse.getStatusName(), 0);
				}
				map.put(viewHouse.getStatusName(), map.get(viewHouse.getStatusName()) + 1);
			}
		}
		if (paramTypeId == 4) {
			for (ViewHouse viewHouse : listViewHouse) {
				if (!listString.contains(viewHouse.getStructName())) {
					listString.add(viewHouse.getStructName());
				}
				if (!map.containsKey(viewHouse.getStructName())) {
					map.put(viewHouse.getStructName(), 0);
				}
				map.put(viewHouse.getStructName(), map.get(viewHouse.getStructName()) + 1);
			}
		}
		List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
		for (Entry<String, Integer> entry : map.entrySet()) {
			Map<String, String> mapAl = new HashMap<String, String>();
			mapAl.put("name", entry.getKey());
			mapAl.put("value", entry.getValue().toString());
			listMap.add(mapAl);
		}
		return Msg.success("获取房屋统计").add("name", listString).add("content", listMap);
	}

	/**
	 * 按照查询条件获取房屋类型统计附带管理员权限
	 * @param roleId
	 * @param paramTypeId
	 * @param houseAllSelectModel
	 * @return
	 */
	@PostMapping(value = "Content/{roleId}")
	@ApiOperation(notes = "获取房屋类型", value = "获取房屋类型")
	public Msg getHouseRecordContentWithMP(@PathVariable("roleId") Integer roleId, @RequestParam("paramTypeId") Integer paramTypeId,
			@RequestBody HouseAllSelectModel houseAllSelectModel) {
//		获取管理员权限范围的校区
		String manageCampus = authListService.getOneAuth(roleId).getManageCampus();
		List<Integer> campusList = MyUtils.roleIdToMP(manageCampus);
		
		List<ViewHouse> listViewHouse = houseRegisterSelectService.getByAllMultiConditionQueryWithMP(houseAllSelectModel, campusList);
//		List<ViewHouse> listViewHouse = houseRegisterSelectService.getByAllMultiConditionQuery(houseAllSelectModel);

		List<String> listString = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		if (paramTypeId == 1) {
			for (ViewHouse viewHouse : listViewHouse) {
				if (!listString.contains(viewHouse.getTypeName())) {
					listString.add(viewHouse.getTypeName());
				}
				if (!map.containsKey(viewHouse.getTypeName())) {
					map.put(viewHouse.getTypeName(), 0);
				}
				map.put(viewHouse.getTypeName(), map.get(viewHouse.getTypeName()) + 1);
			}
		}
		if (paramTypeId == 2) {
			for (ViewHouse viewHouse : listViewHouse) {
				if (!listString.contains(viewHouse.getLayoutName())) {
					listString.add(viewHouse.getLayoutName());
				}
				if (!map.containsKey(viewHouse.getLayoutName())) {
					map.put(viewHouse.getLayoutName(), 0);
				}
				map.put(viewHouse.getLayoutName(), map.get(viewHouse.getLayoutName()) + 1);
			}
		}
		if (paramTypeId == 3) {
			for (ViewHouse viewHouse : listViewHouse) {
				if (!listString.contains(viewHouse.getStatusName())) {
					listString.add(viewHouse.getStatusName());
				}
				if (!map.containsKey(viewHouse.getStatusName())) {
					map.put(viewHouse.getStatusName(), 0);
				}
				map.put(viewHouse.getStatusName(), map.get(viewHouse.getStatusName()) + 1);
			}
		}
		if (paramTypeId == 4) {
			for (ViewHouse viewHouse : listViewHouse) {
				if (!listString.contains(viewHouse.getStructName())) {
					listString.add(viewHouse.getStructName());
				}
				if (!map.containsKey(viewHouse.getStructName())) {
					map.put(viewHouse.getStructName(), 0);
				}
				map.put(viewHouse.getStructName(), map.get(viewHouse.getStructName()) + 1);
			}
		}
		List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
		for (Entry<String, Integer> entry : map.entrySet()) {
			Map<String, String> mapAl = new HashMap<String, String>();
			mapAl.put("name", entry.getKey());
			mapAl.put("value", entry.getValue().toString());
			listMap.add(mapAl);
		}
		return Msg.success("获取房屋统计").add("name", listString).add("content", listMap);
	}
	
	/**
	 * 获取各校区已入住和空闲的房屋数量
	 * 
	 * @param houseAllSelectModel
	 * @return
	 */
	@PostMapping(value = "houseCampus")
	public Msg getHouseCampus(@RequestBody HouseAllSelectModel houseAllSelectModel) {
		List<ViewHouse> listViewHouse = houseRegisterSelectService.getByAllMultiConditionQuery(houseAllSelectModel);
		List<String> listString = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		// 遍历每一个房屋
		for (ViewHouse viewHouse : listViewHouse) {

			if (!map.containsKey(viewHouse.getCampusName())) {
				Map<String, Integer> mapForOne = new HashMap<>();
				mapForOne.put("已入住", 0);
				mapForOne.put("未入住", 0);
				map.put(viewHouse.getCampusName(), mapForOne);
			}
			if (viewHouse.getStatus() == 24) {
				@SuppressWarnings("unchecked")
				Map<String, Integer> mapForOne = (Map<String, Integer>) map.get(viewHouse.getCampusName());
				mapForOne.put("未入住", mapForOne.get("未入住") + 1);
			} else {
				@SuppressWarnings("unchecked")
				Map<String, Integer> mapForOne = (Map<String, Integer>) map.get(viewHouse.getCampusName());
				mapForOne.put("已入住", mapForOne.get("已入住") + 1);
			}
		}
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		for (Entry<String, Object> entry : map.entrySet()) {
			HashMap<String, Integer> mmm = (HashMap<String, Integer>) entry.getValue();
			List<Map<String, Object>> list2 = new ArrayList<>();

			Map<String, Object> mapAl1 = new HashMap<String, Object>();
			mapAl1.put("name", "已入住");
			mapAl1.put("value", mmm.get("已入住"));

			Map<String, Object> mapAl2 = new HashMap<String, Object>();
			mapAl2.put("name", "未入住");
			mapAl2.put("value", mmm.get("未入住"));
			list2.add(mapAl1);
			list2.add(mapAl2);
			Map<String, Object> mapFinal = new HashMap<>();
			mapFinal.put("name", entry.getKey());
			mapFinal.put("data", list2);
			listString.add(entry.getKey());
			listMap.add(mapFinal);
		}
		return Msg.success().add("name", listString).add("data", listMap);
	}
	
	/**
	 * 获取各校区已入住和空闲的房屋数量附带管理员权限
	 * @param roleId
	 * @param houseAllSelectModel
	 * @return
	 */
	@PostMapping(value = "houseCampus/{roleId}")
	public Msg getHouseCampusWithMP(@PathVariable("roleId") Integer roleId,@RequestBody HouseAllSelectModel houseAllSelectModel) {
//		获取管理员权限范围的校区
		String manageCampus = authListService.getOneAuth(roleId).getManageCampus();
		List<Integer> campusList = MyUtils.roleIdToMP(manageCampus);
		
		List<ViewHouse> listViewHouse = houseRegisterSelectService.getByAllMultiConditionQueryWithMP(houseAllSelectModel, campusList);
		
//		List<ViewHouse> listViewHouse = houseRegisterSelectService.getByAllMultiConditionQuery(houseAllSelectModel);
		List<String> listString = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		// 遍历每一个房屋
		for (ViewHouse viewHouse : listViewHouse) {

			if (!map.containsKey(viewHouse.getCampusName())) {
				Map<String, Integer> mapForOne = new HashMap<>();
				mapForOne.put("已入住", 0);
				mapForOne.put("未入住", 0);
				map.put(viewHouse.getCampusName(), mapForOne);
			}
			if (viewHouse.getStatus() == 24) {
				@SuppressWarnings("unchecked")
				Map<String, Integer> mapForOne = (Map<String, Integer>) map.get(viewHouse.getCampusName());
				mapForOne.put("未入住", mapForOne.get("未入住") + 1);
			} else {
				@SuppressWarnings("unchecked")
				Map<String, Integer> mapForOne = (Map<String, Integer>) map.get(viewHouse.getCampusName());
				mapForOne.put("已入住", mapForOne.get("已入住") + 1);
			}
		}
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		for (Entry<String, Object> entry : map.entrySet()) {
			HashMap<String, Integer> mmm = (HashMap<String, Integer>) entry.getValue();
			List<Map<String, Object>> list2 = new ArrayList<>();

			Map<String, Object> mapAl1 = new HashMap<String, Object>();
			mapAl1.put("name", "已入住");
			mapAl1.put("value", mmm.get("已入住"));

			Map<String, Object> mapAl2 = new HashMap<String, Object>();
			mapAl2.put("name", "未入住");
			mapAl2.put("value", mmm.get("未入住"));
			list2.add(mapAl1);
			list2.add(mapAl2);
			Map<String, Object> mapFinal = new HashMap<>();
			mapFinal.put("name", entry.getKey());
			mapFinal.put("data", list2);
			listString.add(entry.getKey());
			listMap.add(mapFinal);
		}
		return Msg.success().add("name", listString).add("data", listMap);
	}

	/**
	 * 获取房屋户型相关统计
	 * 
	 * @param houseAllSelectModel
	 * @return
	 */
	@PostMapping(value = "houseLayout")
	public Msg getHouseLayout(@RequestBody HouseAllSelectModel houseAllSelectModel) {
		List<ViewHouse> listViewHouse = houseRegisterSelectService.getByAllMultiConditionQuery(houseAllSelectModel);
		List<String> listString = new ArrayList<>();
		List<Integer> listInteger = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();
		for (ViewHouse viewHouse : listViewHouse) {
			if (!listString.contains(viewHouse.getLayoutName())) {
				listString.add(viewHouse.getLayoutName());
			}
			if (!map.containsKey(viewHouse.getLayoutName())) {
				map.put(viewHouse.getLayoutName(), 0);
			}
			map.put(viewHouse.getLayoutName(), map.get(viewHouse.getLayoutName()) + 1);
		}
		int sum = 0;
		for (Entry<String, Integer> entry : map.entrySet()) {
			listInteger.add(entry.getValue());
			sum += entry.getValue();
		}
		List<Double> floatList = new ArrayList<>();
		for (Integer number : listInteger) {
			floatList.add(Arith.div(number * 100, sum, 2));
		}
		return Msg.success().add("name", listString).add("number", listInteger).add("proportion", floatList);
	}

	/**
	 * 获取房屋户型相关统计，附带管理员权限
	 * @param roleId
	 * @param houseAllSelectModel
	 * @return
	 */
	@PostMapping(value = "houseLayout/{roleId}")
	public Msg getHouseLayoutWithMP(@PathVariable("roleId") Integer roleId,@RequestBody HouseAllSelectModel houseAllSelectModel) {
//		获取管理员权限范围的校区
		String manageCampus = authListService.getOneAuth(roleId).getManageCampus();
		List<Integer> campusList = MyUtils.roleIdToMP(manageCampus);
		
		List<ViewHouse> listViewHouse = houseRegisterSelectService.getByAllMultiConditionQueryWithMP(houseAllSelectModel, campusList);
		
//		List<ViewHouse> listViewHouse = houseRegisterSelectService.getByAllMultiConditionQuery(houseAllSelectModel);
		List<String> listString = new ArrayList<>();
		List<Integer> listInteger = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();
		for (ViewHouse viewHouse : listViewHouse) {
			if (!listString.contains(viewHouse.getLayoutName())) {
				listString.add(viewHouse.getLayoutName());
			}
			if (!map.containsKey(viewHouse.getLayoutName())) {
				map.put(viewHouse.getLayoutName(), 0);
			}
			map.put(viewHouse.getLayoutName(), map.get(viewHouse.getLayoutName()) + 1);
		}
		int sum = 0;
		for (Entry<String, Integer> entry : map.entrySet()) {
			listInteger.add(entry.getValue());
			sum += entry.getValue();
		}
		List<Double> floatList = new ArrayList<>();
		for (Integer number : listInteger) {
			floatList.add(Arith.div(number * 100, sum, 2));
		}
		return Msg.success().add("name", listString).add("number", listInteger).add("proportion", floatList);
	}
	
	
	/**
	 * 获取全部的staffHouse
	 * 
	 * @param houseId
	 * @param page
	 * @param size
	 * @return
	 */
	@PostMapping(value = "relationByHouse")
	public Msg getRelationByHouse(@RequestBody HouseAllSelectModel houseAllSelectModel,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size) {

		List<ViewHouse> listViewHouse = houseRegisterSelectService.getByAllMultiConditionQuery(houseAllSelectModel);

		PageHelper.startPage(page, size);
		List<HouseStaff> viewHouseStaffs = houseStaffService.getAll(listViewHouse);
		PageInfo pageInfo = new PageInfo(viewHouseStaffs);
		return Msg.success().add("data", pageInfo);
	}
	
	/**
	 * 获取全部的staffHouse，附带管理员权限
	 * @param roleId
	 * @param houseAllSelectModel
	 * @param page
	 * @param size
	 * @return
	 */
	@PostMapping(value = "relationByHouse/{roleId}")
	public Msg getRelationByHouseWithMP(@PathVariable("roleId") Integer roleId,@RequestBody HouseAllSelectModel houseAllSelectModel,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size) {
//		获取管理员权限范围的校区
		String manageCampus = authListService.getOneAuth(roleId).getManageCampus();
		List<Integer> campusList = MyUtils.roleIdToMP(manageCampus);
		
		List<ViewHouse> listViewHouse = houseRegisterSelectService.getByAllMultiConditionQueryWithMP(houseAllSelectModel, campusList);
		
//		List<ViewHouse> listViewHouse = houseRegisterSelectService.getByAllMultiConditionQuery(houseAllSelectModel);

		PageHelper.startPage(page, size);
		List<HouseStaff> viewHouseStaffs = houseStaffService.getAll(listViewHouse);
		PageInfo pageInfo = new PageInfo(viewHouseStaffs);
		return Msg.success().add("data", pageInfo);
	}
}

package com.computerdesign.whutHouseMgmt.controller.fix;

import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.authority.AuthList;
import com.computerdesign.whutHouseMgmt.bean.fix.common.ViewFix;
import com.computerdesign.whutHouseMgmt.bean.fix.record.FixAllSelectModel;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.campus.Campus;
import com.computerdesign.whutHouseMgmt.service.authority.AuthListService;
import com.computerdesign.whutHouseMgmt.service.campus.CampusService;
import com.computerdesign.whutHouseMgmt.service.fix.FixService;
import com.computerdesign.whutHouseMgmt.service.fix.ViewFixService;
import com.computerdesign.whutHouseMgmt.utils.Arith;
import com.computerdesign.whutHouseMgmt.utils.DateUtil;
import com.computerdesign.whutHouseMgmt.utils.MyUtils;
import com.computerdesign.whutHouseMgmt.utils.ResponseUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 *
 * @author wanhaoran
 * @date 2018年3月21日 上午8:09:23
 * 
 */
@RestController
@RequestMapping(value = "/fixRecord/")
@Api(value = "/fixRecord", description = "维修数据统计")
public class FixRecordController {

	@Autowired
	private ViewFixService viewFixService;
	@Autowired
	private FixService fixService;
	
	@Autowired
	private CampusService campusService;
	
	@Autowired
	private AuthListService authListService;
	
	@ResponseBody
	@RequestMapping(value = "getCampusData/{roleId}", method = RequestMethod.GET)
	public Msg getCampusData(@PathVariable("roleId") Integer roleId){
		AuthList authList = authListService.getOneAuth(roleId);
		String manageCampus = authList.getManageCampus();
		List<Campus> campusList = new ArrayList<Campus>();
		if(manageCampus != null){			
			String[] campusIds = manageCampus.split("-");
			for (String campusId : campusIds){				
				Campus campus = campusService.getById(Integer.valueOf(campusId));
				campusList.add(campus);
			}
			return Msg.success().add("data", campusList);
		}else{
			return Msg.error("该角色ManageCampus字段为空");
		}
		
	}
	
	/**
	 * 返回一周内每天的维修申请量，拒绝量，通过量
	 * 
	 * @return
	 */
	@GetMapping(value = "contentCount")
	public Msg getCountAll() {
		Date time = new Date();
		// 用于存放每日拒绝量
		List<Long> listRefused = new ArrayList<>();
		// 用于存放每日的通过审核量
		List<Long> listHasBeenApproved = new ArrayList<>();
		// 用于存放每日的申请量
		List<Long> listApply = new ArrayList<>();
		// 用于存放每日的日期
		List<String> listDate = new ArrayList<>();

		// 初始日期为8天前
		time = DateUtil.getDelayAppointDate(time, 8);
		for (int i = 0; i < 7; i++) {
			time = DateUtil.getAppointDate(time, 1);
			listDate.add(DateUtil.getCurrentSimpleRecordDate(time));
			listRefused.add(fixService.getTotalCountRefused(time));
			listHasBeenApproved.add(fixService.getCountAgreeted(time));
			listApply.add(fixService.getCountTodayApply(time));
		}

		List<HashMap<String, Object>> listReturn = new ArrayList<>();
		HashMap<String, Object> mapRefuse = new HashMap<>();
		mapRefuse.put("name", "已拒绝");
		mapRefuse.put("data", listRefused);
		listReturn.add(mapRefuse);

		HashMap<String, Object> mapHasBeenApproved = new HashMap<>();
		mapHasBeenApproved.put("name", "已审核");
		mapHasBeenApproved.put("data", listHasBeenApproved);
		listReturn.add(mapHasBeenApproved);

		HashMap<String, Object> mapApply = new HashMap<>();
		mapApply.put("name", "申请量");
		mapApply.put("data", listApply);
		listReturn.add(mapApply);

		HashMap<String, Object> mapDate = new HashMap<>();
		mapDate.put("name", "日期");
		mapDate.put("data", listDate);
		listReturn.add(mapDate);
		return Msg.success().add("data", listReturn);
	}
	
	/**
	 * 返回一周内每天的维修申请量，拒绝量，通过量-附带管理员权限
	 * @param roleId
	 * @return
	 */
	@GetMapping(value = "contentCount/{roleId}")
	public Msg getCountAllWithMP(@PathVariable("roleId") Integer roleId) {
		Date time = new Date();
		// 用于存放每日拒绝量
		List<Long> listRefused = new ArrayList<>();
		// 用于存放每日的通过审核量
		List<Long> listHasBeenApproved = new ArrayList<>();
		// 用于存放每日的申请量
		List<Long> listApply = new ArrayList<>();
		// 用于存放每日的日期
		List<String> listDate = new ArrayList<>();

//		获取管理员权限范围的校区
		String manageCampus = authListService.getOneAuth(roleId).getManageCampus();
		List<Integer> campusList = MyUtils.roleIdToMP(manageCampus);
		
		// 初始日期为8天前
		time = DateUtil.getDelayAppointDate(time, 8);
		for (int i = 0; i < 7; i++) {
			time = DateUtil.getAppointDate(time, 1);
			listDate.add(DateUtil.getCurrentSimpleRecordDate(time));
			listRefused.add(fixService.getTotalCountRefusedWithMP(time, campusList));
			listHasBeenApproved.add(fixService.getCountAgreetedWithMP(time, campusList));
			listApply.add(fixService.getCountTodayApplyWithMP(time, campusList));
		}

		List<HashMap<String, Object>> listReturn = new ArrayList<>();
		HashMap<String, Object> mapRefuse = new HashMap<>();
		mapRefuse.put("name", "已拒绝");
		mapRefuse.put("data", listRefused);
		listReturn.add(mapRefuse);

		HashMap<String, Object> mapHasBeenApproved = new HashMap<>();
		mapHasBeenApproved.put("name", "已审核");
		mapHasBeenApproved.put("data", listHasBeenApproved);
		listReturn.add(mapHasBeenApproved);

		HashMap<String, Object> mapApply = new HashMap<>();
		mapApply.put("name", "申请量");
		mapApply.put("data", listApply);
		listReturn.add(mapApply);

		HashMap<String, Object> mapDate = new HashMap<>();
		mapDate.put("name", "日期");
		mapDate.put("data", listDate);
		listReturn.add(mapDate);
		return Msg.success().add("data", listReturn);
	}
	

	/**
	 * 一段时间内每天各种类型分别有多少
	 * 
	 * @param fixAllSelectModel
	 * @return
	 */
	@PostMapping(value = "contentCount")
	public Msg getFixTypeAWeek(@RequestBody FixAllSelectModel fixAllSelectModel) {
		Date endDate = fixAllSelectModel.getEndTime();
		if (endDate == null) {
			endDate = new Date();
		}
		Date comTime = DateUtil.getDelayAppointDate(endDate, 10);
		// 设置起始时间是endDate的10天前
		fixAllSelectModel.setStartTime(comTime);
		// 全部的数据
		List<ViewFix> viewFixs = viewFixService.multiConditionQuery(fixAllSelectModel, false);
		// 用于存放日期
		List<String> listDate = new ArrayList<>();
		// 用于存放维修类型
		List<String> listContentName = new ArrayList<>();

		List<HashMap<String, Object>> listMap = new ArrayList<>();
		// 获取全部的维修类型
		for (ViewFix viewFix : viewFixs) {
			if (!listContentName.contains(viewFix.getFixContentName())) {
				listContentName.add(viewFix.getFixContentName());
			}
		}
		for (int i = 0; i < 10; i++) {
			listDate.add(DateUtil.getCurrentSimpleRecordDate(DateUtil.getAppointDate(comTime, i)));
		}
		System.out.println(listContentName);
		for (String fixContentName : listContentName) {
			HashMap<String, Object> finalMap = new HashMap<>();

			// 根据维修类型获取全部viewFix
			List<ViewFix> viewFixsForContent = viewFixService.getFixDateByType(viewFixs, fixContentName);
			int[] dateCount = new int[10];
			for (ViewFix viewFix : viewFixsForContent) {
				if (DateUtil.compareToDate(viewFix.getApplyTime(), comTime) > 0&&DateUtil.compareToDate(viewFix.getApplyTime(), endDate)<=0) {
					int i = DateUtil.getIntDistanceOfTwoDate(viewFix.getApplyTime(), endDate);
					if(i==0) continue;
					dateCount[10 - i]++;
				}
			}
			finalMap.put("name", fixContentName);
			finalMap.put("data", dateCount);
			// mapForContent.put(fixContentName, dateCount);
			listMap.add(finalMap);
		}
		return Msg.success().add("data", listMap).add("dataString", listDate).add("ContentName", listContentName);
	}

	/**
	 * 一段时间内每天各种类型分别有多少，附带管理员权限
	 * 
	 * @param fixAllSelectModel
	 * @return
	 */
	@PostMapping(value = "contentCount/{roleId}")
	public Msg getFixTypeAWeekWithMP(@PathVariable("roleId") Integer roleId,@RequestBody FixAllSelectModel fixAllSelectModel) {
//		获取管理员权限范围的校区
		String manageCampus = authListService.getOneAuth(roleId).getManageCampus();
		List<Integer> campusList = MyUtils.roleIdToMP(manageCampus);
		
		Date endDate = fixAllSelectModel.getEndTime();
		if (endDate == null) {
			endDate = new Date();
		}
		Date comTime = DateUtil.getDelayAppointDate(endDate, 10);
		// 设置起始时间是endDate的10天前
		fixAllSelectModel.setStartTime(comTime);
		// 全部的数据
		List<ViewFix> viewFixs = viewFixService.multiConditionQueryWithMP(fixAllSelectModel, false, campusList);
		// 用于存放日期
		List<String> listDate = new ArrayList<>();
		// 用于存放维修类型
		List<String> listContentName = new ArrayList<>();

		List<HashMap<String, Object>> listMap = new ArrayList<>();
		// 获取全部的维修类型
		for (ViewFix viewFix : viewFixs) {
			if (!listContentName.contains(viewFix.getFixContentName())) {
				listContentName.add(viewFix.getFixContentName());
			}
		}
		for (int i = 0; i < 10; i++) {
			listDate.add(DateUtil.getCurrentSimpleRecordDate(DateUtil.getAppointDate(comTime, i)));
		}
		System.out.println(listContentName);
		for (String fixContentName : listContentName) {
			HashMap<String, Object> finalMap = new HashMap<>();

			// 根据维修类型获取全部viewFix
			List<ViewFix> viewFixsForContent = viewFixService.getFixDateByType(viewFixs, fixContentName);
			int[] dateCount = new int[10];
			for (ViewFix viewFix : viewFixsForContent) {
				if (DateUtil.compareToDate(viewFix.getApplyTime(), comTime) > 0&&DateUtil.compareToDate(viewFix.getApplyTime(), endDate)<=0) {
					int i = DateUtil.getIntDistanceOfTwoDate(viewFix.getApplyTime(), endDate);
					if(i==0) continue;
					dateCount[10 - i]++;
				}
			}
			finalMap.put("name", fixContentName);
			finalMap.put("data", dateCount);
			// mapForContent.put(fixContentName, dateCount);
			listMap.add(finalMap);
		}
		return Msg.success().add("data", listMap).add("dataString", listDate).add("ContentName", listContentName);
	}
	
	/**
	 * 获取这一周的维修类型的名称与对应数量
	 * 
	 * @param day
	 * @return
	 */
	@GetMapping(value = "Content")
	@ApiOperation(value = "获取这一周的维修类型的名称与对应数量", notes = "获取这一周的维修类型的名称与对应数量", httpMethod = "GET")
	public Msg getFixRecordContent(@RequestParam("day") Integer day) {
		Date startDate = DateUtil.getDelayAppointDate(new Date(), day);
		Date endDate = new Date();
		List<ViewFix> listViewFix = viewFixService.getByTime(startDate, endDate);
		List<String> listString = new ArrayList<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (ViewFix viewFix : listViewFix) {
			if (!listString.contains(viewFix.getFixContentName())) {
				listString.add(viewFix.getFixContentName());
			}
			if (!map.containsKey(viewFix.getFixContentName())) {
				map.put(viewFix.getFixContentName(), 0);
			}
			map.put(viewFix.getFixContentName(), map.get(viewFix.getFixContentName()) + 1);
		}

		List<Map<String, String>> listMap = new ArrayList<>();
		for (Entry<String, Integer> entry : map.entrySet()) {
			Map<String, String> mapAl = new HashMap<String, String>();
			mapAl.put("name", entry.getKey());
			mapAl.put("value", entry.getValue().toString());
			listMap.add(mapAl);
		}
		return Msg.success("返回最近" + day + "天全部的维修类型名称与数量").add("name", listString).add("count", listMap);
	}
	
	/**
	 * 获取这一周的维修类型的名称与对应数量，附带管理员权限
	 * @param roleId
	 * @param day
	 * @return
	 */
	@GetMapping(value = "Content/{roleId}")
	@ApiOperation(value = "获取这一周的维修类型的名称与对应数量", notes = "获取这一周的维修类型的名称与对应数量", httpMethod = "GET")
	public Msg getFixRecordContentWithMP(@PathVariable("roleId") Integer roleId,@RequestParam("day") Integer day) {
//		获取管理员权限范围的校区
		String manageCampus = authListService.getOneAuth(roleId).getManageCampus();
		List<Integer> campusList = MyUtils.roleIdToMP(manageCampus);
		
		Date startDate = DateUtil.getDelayAppointDate(new Date(), day);
		Date endDate = new Date();
		List<ViewFix> listViewFix = viewFixService.getByTimeWithMP(startDate, endDate, campusList);
		List<String> listString = new ArrayList<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (ViewFix viewFix : listViewFix) {
			if (!listString.contains(viewFix.getFixContentName())) {
				listString.add(viewFix.getFixContentName());
			}
			if (!map.containsKey(viewFix.getFixContentName())) {
				map.put(viewFix.getFixContentName(), 0);
			}
			map.put(viewFix.getFixContentName(), map.get(viewFix.getFixContentName()) + 1);
		}

		List<Map<String, String>> listMap = new ArrayList<>();
		for (Entry<String, Integer> entry : map.entrySet()) {
			Map<String, String> mapAl = new HashMap<String, String>();
			mapAl.put("name", entry.getKey());
			mapAl.put("value", entry.getValue().toString());
			listMap.add(mapAl);
		}
		return Msg.success("返回最近" + day + "天全部的维修类型名称与数量").add("name", listString).add("count", listMap);
	}

	/**
	 * 多条件筛选返回表单
	 * 
	 * @param fixAllSelectModel
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "multilQueryContent")
	public Msg fixMultiConditionQuery(@RequestBody FixAllSelectModel fixAllSelectModel,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size) {
		PageHelper.startPage(page, size);
		List<ViewFix> listViewFix = viewFixService.multiConditionQuery(fixAllSelectModel, true);
		String[] fileds = { "id", "applyTime", "fixContentId", "fixContentName", "staffNo", "staffName", "address",
				"buildingName", "regionName", "campusName", "ratings", "ratingDescription", "fixMoney" };
		List<Map<String, Object>> response = ResponseUtil.getResultMap(listViewFix, fileds);
		PageInfo pageInfo = new PageInfo(listViewFix);
		pageInfo.setList(response);
		return Msg.success().add("data", pageInfo);
	}
	
	/**
	 * 多条件筛选返回表单，附带管理员权限
	 * @param roleId
	 * @param fixAllSelectModel
	 * @param page
	 * @param size
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "multilQueryContent/{roleId}")
	public Msg fixMultiConditionQueryWithMP(@PathVariable("roleId") Integer roleId,@RequestBody FixAllSelectModel fixAllSelectModel,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size) {
//		获取管理员权限范围的校区
		String manageCampus = authListService.getOneAuth(roleId).getManageCampus();
		List<Integer> campusList = MyUtils.roleIdToMP(manageCampus);
		
		PageHelper.startPage(page, size);
		List<ViewFix> listViewFix = viewFixService.multiConditionQueryWithMP(fixAllSelectModel, true, campusList);
		String[] fileds = { "id", "applyTime", "fixContentId", "fixContentName", "staffNo", "staffName", "address",
				"buildingName", "regionName", "campusName", "ratings", "ratingDescription", "fixMoney" };
		List<Map<String, Object>> response = ResponseUtil.getResultMap(listViewFix, fileds);
		PageInfo pageInfo = new PageInfo(listViewFix);
		pageInfo.setList(response);
		return Msg.success().add("data", pageInfo);
	}

	/**
	 * total总体数据
	 * 
	 * @param fixAllSelectModel
	 * @return
	 */
	@PostMapping(value = "total")
	public Msg getFixTotal(@RequestBody FixAllSelectModel fixAllSelectModel) {

		List<ViewFix> list = viewFixService.multiConditionQuery(fixAllSelectModel, false);
		long totalFixApply = 0, totalFixHandle = 0, totalFixRefuse = 0;
		double handleRate, totalFixMoney = 0, aveFixRatings = 0;

		int ratingsCount = 0;
		int ratingsSum = 0;
		totalFixRefuse = viewFixService.getTotalCountRefused(list);
		totalFixApply = list.size();
		totalFixHandle = viewFixService.getTotalCountHandle(list);
		handleRate = Arith.div(totalFixHandle * 100, totalFixApply, 0);
		for (ViewFix viewFix : list) {
			if (viewFix.getFixMoney() != null) {
				totalFixMoney += Double.valueOf(viewFix.getFixMoney());
			}
			if (viewFix.getRatings() != null) {
				ratingsSum += Integer.valueOf(viewFix.getRatings());
				ratingsCount++;
			}
		}
		if (ratingsCount == 0) {
			aveFixRatings = 0;
		} else {
			aveFixRatings = Arith.div(ratingsSum, ratingsCount, 2);
		}

		return Msg.success().add("totalFixApply", totalFixApply).add("totalFixHandle", totalFixHandle)
				.add("totalFixRefuse", totalFixRefuse).add("handleRate", handleRate).add("totalFixMoney", totalFixMoney)
				.add("aveFixRatings", aveFixRatings);
	}
	
	/**
	 * total总体数据，附带管理员权限
	 * @param roleId
	 * @param fixAllSelectModel
	 * @return
	 */
	@PostMapping(value = "total/{roleId}")
	public Msg getFixTotalWithMP(@PathVariable("roleId") Integer roleId,@RequestBody FixAllSelectModel fixAllSelectModel) {
//		获取管理员权限范围的校区
		String manageCampus = authListService.getOneAuth(roleId).getManageCampus();
		List<Integer> campusList = MyUtils.roleIdToMP(manageCampus);
		
		List<ViewFix> list = viewFixService.multiConditionQueryWithMP(fixAllSelectModel, false, campusList);
		long totalFixApply = 0, totalFixHandle = 0, totalFixRefuse = 0;
		double handleRate, totalFixMoney = 0, aveFixRatings = 0;

		int ratingsCount = 0;
		int ratingsSum = 0;
		totalFixRefuse = viewFixService.getTotalCountRefused(list);
		totalFixApply = list.size();
		totalFixHandle = viewFixService.getTotalCountHandle(list);
		if(totalFixApply != 0){			
			handleRate = Arith.div(totalFixHandle * 100, totalFixApply, 0);
		}else{
			handleRate = 0;
		}
		for (ViewFix viewFix : list) {
			if (viewFix.getFixMoney() != null) {
				totalFixMoney += Double.valueOf(viewFix.getFixMoney());
			}
			if (viewFix.getRatings() != null) {
				ratingsSum += Integer.valueOf(viewFix.getRatings());
				ratingsCount++;
			}
		}
		if (ratingsCount == 0) {
			aveFixRatings = 0;
		} else {
			if(ratingsCount != 0){				
				aveFixRatings = Arith.div(ratingsSum, ratingsCount, 2);
			}else{
				aveFixRatings = 0;
			}
		}

		return Msg.success().add("totalFixApply", totalFixApply).add("totalFixHandle", totalFixHandle)
				.add("totalFixRefuse", totalFixRefuse).add("handleRate", handleRate).add("totalFixMoney", totalFixMoney)
				.add("aveFixRatings", aveFixRatings);
	}

	/**
	 * 根据条件筛选，维修类型与数量
	 * 
	 * @param fixAllSelectModel
	 * @return
	 */
	@PostMapping(value = "getFixType")
	public Msg getFixType(@RequestBody FixAllSelectModel fixAllSelectModel) {
		List<ViewFix> viewFixs = viewFixService.multiConditionQuery(fixAllSelectModel, false);
		List<String> listString = new ArrayList<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (ViewFix viewFix : viewFixs) {
			if (!listString.contains(viewFix.getFixContentName())) {
				listString.add(viewFix.getFixContentName());
			}
			if (!map.containsKey(viewFix.getFixContentName())) {
				map.put(viewFix.getFixContentName(), 0);
			}
			map.put(viewFix.getFixContentName(), map.get(viewFix.getFixContentName()) + 1);
		}

		List<Map<String, String>> listMap = new ArrayList<>();
		for (Entry<String, Integer> entry : map.entrySet()) {
			Map<String, String> mapAl = new HashMap<String, String>();
			mapAl.put("name", entry.getKey());
			mapAl.put("value", entry.getValue().toString());
			listMap.add(mapAl);
		}
		return Msg.success().add("name", listString).add("data", listMap);
	}

	/**
	 * 根据条件筛选，维修类型与数量，附带管理员权限
	 * @param roleId
	 * @param fixAllSelectModel
	 * @return
	 */
	@PostMapping(value = "getFixType/{roleId}")
	public Msg getFixTypeWithMP(@PathVariable("roleId") Integer roleId,@RequestBody FixAllSelectModel fixAllSelectModel) {
//		获取管理员权限范围的校区
		String manageCampus = authListService.getOneAuth(roleId).getManageCampus();
		List<Integer> campusList = MyUtils.roleIdToMP(manageCampus);
		
		List<ViewFix> viewFixs = viewFixService.multiConditionQueryWithMP(fixAllSelectModel, false, campusList);
		
		List<String> listString = new ArrayList<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (ViewFix viewFix : viewFixs) {
			if (!listString.contains(viewFix.getFixContentName())) {
				listString.add(viewFix.getFixContentName());
			}
			if (!map.containsKey(viewFix.getFixContentName())) {
				map.put(viewFix.getFixContentName(), 0);
			}
			map.put(viewFix.getFixContentName(), map.get(viewFix.getFixContentName()) + 1);
		}

		List<Map<String, String>> listMap = new ArrayList<>();
		for (Entry<String, Integer> entry : map.entrySet()) {
			Map<String, String> mapAl = new HashMap<String, String>();
			mapAl.put("name", entry.getKey());
			mapAl.put("value", entry.getValue().toString());
			listMap.add(mapAl);
		}
		return Msg.success().add("name", listString).add("data", listMap);
	}
	
	/**
	 * 
	 * 维修评价雷达图
	 * @param fixAllSelectModel
	 * @return
	 */
	@PostMapping(value = "getFixRatingsRecord")
	public Msg getFixRatingsRecord(@RequestBody FixAllSelectModel fixAllSelectModel) {
		List<ViewFix> list = viewFixService.multiConditionQuery(fixAllSelectModel, true);
		int[] listInt = new int[5];
		for (ViewFix viewFix : list) {
			int ratingsCount = Integer.valueOf(viewFix.getRatings());
			if (ratingsCount <= 5 && ratingsCount >= 1) {
				listInt[Integer.valueOf(viewFix.getRatings()) - 1]++;
			}
		}
		int max =0;
		int maxCount =0;
		int sum =0;
		for (int i = 0; i < listInt.length; i++) {
			if (listInt[i]>maxCount) {
				maxCount = listInt[i];
			}
		}

		for (int i = 0; i < listInt.length; i++) {
			sum+=listInt[i];
		}
		max = maxCount+sum/5;
		return Msg.success().add("data", listInt).add("max", max);
	}
	
	/**
	 * 维修评价雷达图，附带管理员权限
	 * @param roleId
	 * @param fixAllSelectModel
	 * @return
	 */
	@PostMapping(value = "getFixRatingsRecord/{roleId}")
	public Msg getFixRatingsRecordWithMP(@PathVariable("roleId") Integer roleId,@RequestBody FixAllSelectModel fixAllSelectModel) {
//		获取管理员权限范围的校区
		String manageCampus = authListService.getOneAuth(roleId).getManageCampus();
		List<Integer> campusList = MyUtils.roleIdToMP(manageCampus);
		
		List<ViewFix> list = viewFixService.multiConditionQueryWithMP(fixAllSelectModel, true, campusList);
		
		int[] listInt = new int[5];
		for (ViewFix viewFix : list) {
			int ratingsCount = Integer.valueOf(viewFix.getRatings());
			if (ratingsCount <= 5 && ratingsCount >= 1) {
				listInt[Integer.valueOf(viewFix.getRatings()) - 1]++;
			}
		}
		int max =0;
		int maxCount =0;
		int sum =0;
		for (int i = 0; i < listInt.length; i++) {
			if (listInt[i]>maxCount) {
				maxCount = listInt[i];
			}
		}

		for (int i = 0; i < listInt.length; i++) {
			sum+=listInt[i];
		}
		max = maxCount+sum/5;
		return Msg.success().add("data", listInt).add("max", max);
	}
}

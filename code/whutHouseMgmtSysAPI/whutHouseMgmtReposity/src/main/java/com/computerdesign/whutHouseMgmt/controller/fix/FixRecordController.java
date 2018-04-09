package com.computerdesign.whutHouseMgmt.controller.fix;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.fix.common.Fix;
import com.computerdesign.whutHouseMgmt.bean.fix.common.ViewFix;
import com.computerdesign.whutHouseMgmt.bean.fix.record.FixAllSelectModel;
import com.computerdesign.whutHouseMgmt.service.fix.FixService;
import com.computerdesign.whutHouseMgmt.service.fix.ViewFixService;
import com.computerdesign.whutHouseMgmt.utils.DateUtil;
import com.computerdesign.whutHouseMgmt.utils.ResponseUtil;

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

	/**
	 * 返回本周的维修类型
	 * 
	 * @param day
	 * @return
	 */
	// @GetMapping(value="Name")
	// @ApiOperation(value="获取这一周的维修类型的名称",notes="获取这一周的维修类型的名称",httpMethod="GET")
	// public Msg getFixRecordName(@RequestParam("day")Integer day) {
	//
	// Date startDate = DateUtil.getDelayAppointDate(new Date(), day);
	// Date endDate = new Date();
	// List<ViewFix> listViewFix = viewFixService.getByTime(startDate,endDate);
	// List<String> listString = new ArrayList<String>();
	// for (ViewFix viewFix : listViewFix) {
	// if (!listString.contains(viewFix.getFixContentName())) {
	// listString.add(viewFix.getFixContentName());
	// }
	// }
	// return Msg.success("返回最近"+day+"天全部的维修类型").add("data", listString);
	// }

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

	@PostMapping(value = "multilQueryContent")
	public Msg fixMultiConditionQuery(@RequestBody FixAllSelectModel fixAllSelectModel) {
		List<ViewFix> listViewFix = viewFixService.multiConditionQuery(fixAllSelectModel,true);
		String[] fileds = { "id", "applyTime", "fixContentId", "fixContentName", "staffNo", "staffName", "address",
				"buildingName", "regionName", "campusName", "ratings", "ratingDescription", "fixMoney" };
		List<Map<String, Object>> response = ResponseUtil.getResultMap(listViewFix, fileds);
		return Msg.success().add("data", response);
	}

}

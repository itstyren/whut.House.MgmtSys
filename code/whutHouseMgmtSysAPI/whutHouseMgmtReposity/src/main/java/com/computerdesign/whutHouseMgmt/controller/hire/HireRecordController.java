package com.computerdesign.whutHouseMgmt.controller.hire;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.service.hire.HireService;
import com.computerdesign.whutHouseMgmt.utils.DateUtil;

import io.swagger.annotations.Api;

/**
 *
 * @author wanhaoran
 * @date 2018年3月27日 下午5:04:50
 * 
 */
@RestController
@RequestMapping(value = "/hireRecord/")
@Api(value = "hireRecord",description="租赁统计接口")
public class HireRecordController {


	@Autowired
	private HireService hireService;

	@GetMapping(value="content")
	public Msg getHireRecordContent() {
 
		Date time = new Date();
		// 用于存放每日拒绝量
		List<Long> listRefused = new ArrayList<>();
		// 用于存放每日的通过审核量
		List<Long> listHasBeenApproved = new ArrayList<>();
		// 用于存放每日的申请量
		List<Long> listApply = new ArrayList<>();
		// 用于存放每日的日期
		List<String> listDate = new ArrayList<>();
		//初始日期为8天前
		time = DateUtil.getDelayAppointDate(time, 8);
		for (int i = 0; i < 7; i++) {
			time = DateUtil.getAppointDate(time, 1);
			listDate.add(DateUtil.getCurrentSimpleRecordDate(time));
			listRefused.add(hireService.getCountHasAcceptRefused(time) + hireService.getCountHasAgreeRefused(time)
					+ hireService.getCountHasApproveRefused(time));
			listHasBeenApproved.add(hireService.getCountHasBeenApprove(time));
			listApply.add(hireService.getCountApply(time));
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
}

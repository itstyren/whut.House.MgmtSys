package com.computerdesign.whutHouseMgmt.controller.log;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.log.SysLogCondition;
import com.computerdesign.whutHouseMgmt.bean.log.ViewSysLog;
import com.computerdesign.whutHouseMgmt.service.log.SysLogService;
import com.computerdesign.whutHouseMgmt.service.log.SysLogViewService;
import com.computerdesign.whutHouseMgmt.utils.ResponseUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping("/syslog/")
@Controller
public class SysLogController {

	@Autowired
	private SysLogViewService sysLogViewService;

	@Autowired
	private SysLogService sysLogService;
	
	@ResponseBody
	@RequestMapping(value = "getAllByCondition", method = RequestMethod.POST)
	public Msg getAll(@RequestBody SysLogCondition sysLogCondition,@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size) {
		PageHelper.startPage(page, size);
		List<ViewSysLog> viewSysLogs = sysLogViewService.getByMultiCondition(sysLogCondition);
		
//		String[] fileds = {};
//		List<Map<String, Object>> response = ResponseUtil.getResultMap(viewSysLogs, fileds);
		PageInfo pageInfo = new PageInfo(viewSysLogs);
		
		return Msg.success().add("data", pageInfo);
	}
	
	@ResponseBody
	@RequestMapping(value="delete", method = RequestMethod.DELETE)
	public Msg delete(@RequestBody List<Integer> ids){
		if(ids != null && ids.size() > 0){
			sysLogService.deleteBitch(ids);
			return Msg.success("删除成功");
		}else{
			return Msg.error("请选择要删除的项目");
		}
	}

}

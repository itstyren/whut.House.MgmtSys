package com.computerdesign.whutHouseMgmt.controller.dataimport;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.ViewStaff;
import com.computerdesign.whutHouseMgmt.core.DocumentHandler;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.ViewStaffService;
import com.computerdesign.whutHouseMgmt.utils.ResponseUtil;

/**
 *
 * @author wanhaoran
 * @date 2018年3月18日 下午2:31:22
 * 
 */
@RestController
@RequestMapping("/exportToWord/")
public class ExportToWord {

	@Autowired
	private ViewStaffService viewStaffService;
	
	@RequestMapping(value= "hire/{staffId}")
	public Msg downloadHireApply(@PathVariable("staffId")Integer staffId) throws Exception {
		
		if (viewStaffService.getByStaffId(staffId).isEmpty()) {
			//TODO
			return Msg.error();
		}
		ViewStaff viewStaff = viewStaffService.getByStaffId(staffId).get(0);
		String[] fileds = { "Id", "No", "MarriageState","Name", "Sex","TitleName", "DeptName", "Tel", 
				"SpouseName","SpouseKindName","SpouseDept","SpouseTitleName"};
		Map<String, Object> response = ResponseUtil.getResultMap(viewStaff, fileds);
		
		DocumentHandler documentHandler = new DocumentHandler();

		String outFilePath = "C:/Users/wanhaoran/Desktop/test.doc";
		String fileName = "申请租赁住房表格.ftl";
		
		documentHandler.createDocArea(response, outFilePath, fileName);
		return Msg.success();

	}

}

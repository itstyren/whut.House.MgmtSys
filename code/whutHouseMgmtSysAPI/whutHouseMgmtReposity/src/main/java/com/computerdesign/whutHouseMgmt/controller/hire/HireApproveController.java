package com.computerdesign.whutHouseMgmt.controller.hire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.computerdesign.whutHouseMgmt.service.hire.HireService;
import com.computerdesign.whutHouseMgmt.service.hire.StaffHouseService;
import com.computerdesign.whutHouseMgmt.service.hire.ViewHireService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.ViewStaffService;

@Controller
@RequestMapping(value = "/hire/")
public class HireApproveController {

	@Autowired
	private HireService hireService;

	@Autowired
	private ViewHireService viewHireService;

	@Autowired
	private StaffHouseService staffHouseService;

	@Autowired
	private ViewStaffService viewStaffService;
	
	@RequestMapping(value = "getApprove/{approveState}",method = RequestMethod.GET)
	@Controller
	
}

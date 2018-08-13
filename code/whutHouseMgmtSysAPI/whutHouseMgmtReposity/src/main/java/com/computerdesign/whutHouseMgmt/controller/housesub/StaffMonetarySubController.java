package com.computerdesign.whutHouseMgmt.controller.housesub;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.housesub.FormulaParameterShow;
import com.computerdesign.whutHouseMgmt.bean.housesub.MonetarySubSelectModel;
import com.computerdesign.whutHouseMgmt.bean.housesub.MonetarySubVw;
import com.computerdesign.whutHouseMgmt.bean.housesub.OneTimeMonetarySub;
import com.computerdesign.whutHouseMgmt.bean.housesub.OneTimeMonetarySubVw;
import com.computerdesign.whutHouseMgmt.bean.housesub.StaffForMonSub;
import com.computerdesign.whutHouseMgmt.bean.housesub.StaffMonetarySub;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffHouse;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.Staff;
import com.computerdesign.whutHouseMgmt.bean.staffparam.MonetarySubParam;
import com.computerdesign.whutHouseMgmt.service.hire.StaffHouseService;
import com.computerdesign.whutHouseMgmt.service.housesub.MonetarySubVwService;
import com.computerdesign.whutHouseMgmt.service.housesub.OneTimeMonetarySubService;
import com.computerdesign.whutHouseMgmt.service.housesub.StaffForMonSubService;
import com.computerdesign.whutHouseMgmt.service.housesub.StaffMonetarySubService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.StaffService;
import com.computerdesign.whutHouseMgmt.service.staffparam.MonetarySubParamService;
import com.computerdesign.whutHouseMgmt.service.staffparam.StaffParameterService;
import com.computerdesign.whutHouseMgmt.utils.ResponseUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/staffMonetarySub/")
public class StaffMonetarySubController {

	@Autowired
	private StaffMonetarySubService staffMonetarySubService;

	@Autowired
	private MonetarySubParamService monetarySubParamService;

	@Autowired
	private StaffService staffService;

	@Autowired
	private MonetarySubVwService monetarySubVwService;

	@Autowired
	private StaffForMonSubService staffForMonSubService;
	
	@Autowired
	private StaffHouseService staffHouseService;

	@Autowired
	private StaffParameterService staffParameterService;
	
	@Autowired
	private OneTimeMonetarySubService oneTimeMonetarySubService;
	
	//获取年度补贴公式计算参数，便于员工查询补贴如何计算得来
	@ResponseBody
	@RequestMapping(value = "getFormulaParameter/{staffId}", method = RequestMethod.GET)
	public Msg getFormulaParameter(@PathVariable Integer staffId){
		FormulaParameterShow formulaParameterShow = new FormulaParameterShow();
		Staff staff = staffService.get(staffId);
		Calendar calendar = Calendar.getInstance();
		calendar.set(1998, 11, 31, 0, 0, 0);
		//老职工
		if(staff.getJoinTime().getTime() < calendar.getTime().getTime()){
//			List<StaffHouse> staffHouses = staffHouseService.getStaffHouseByStaffId(staffId);
//			if(staffHouses != null && staffHouses.size() > 1){
//				for (StaffHouse staffHouse : staffHouses){
//					if(staffHouse.getHouseRelName().equals("购买")){
//						formulaParameterShow.setUsedArea(staffHouse.getHouseUsedArea());
//					}
//				}
//			}else if(staffHouses != null && staffHouses.size() == 1){
//				if(staffHouses.get(0).getHouseRelName().equals("购买")){
//					formulaParameterShow.setUsedArea(staffHouses.get(0).getHouseUsedArea());
//				}
//			}
			formulaParameterShow.setOldStaff(true);
			//借用逐月补贴视图计算住房补贴标准
			MonetarySubVw monetarySubVw = monetarySubVwService.getByStaffId(staffId);
			if(monetarySubVw != null){
				double enjoyHouseArea = 0.0;
				// 职务职称享受面积取最大值，获取职工住房补贴标准
				if (monetarySubVw.getTitleHouseArea() != null && monetarySubVw.getPostHouseArea() != null) {
					enjoyHouseArea = Math.max(monetarySubVw.getTitleHouseArea(), monetarySubVw.getPostHouseArea());
				} else if (monetarySubVw.getTitleHouseArea() == null && monetarySubVw.getPostHouseArea() != null) {
					enjoyHouseArea = monetarySubVw.getPostHouseArea();
				} else {
					enjoyHouseArea = monetarySubVw.getTitleHouseArea();
				}
				
				formulaParameterShow.setStaffParamHouseArea(enjoyHouseArea);
				
				// 获取职工家庭已购住房
				// double buyHouseArea = monetarySubVw.getHouseBuildArea();
				double buyHouseArea = 0.0;
				if(monetarySubVw.getHouseUsedArea() != null){
					buyHouseArea = monetarySubVw.getHouseUsedArea();
				}
				formulaParameterShow.setUsedArea(buyHouseArea);
				
				if(enjoyHouseArea - buyHouseArea > 0){
					DecimalFormat df = new DecimalFormat("#.00");
					formulaParameterShow.setAreaNotUpToStandard(Double.parseDouble(df.format(enjoyHouseArea - buyHouseArea)));
				}else{
					formulaParameterShow.setAreaNotUpToStandard(0.0);
				}
				
				formulaParameterShow.setAnnualSal(monetarySubVw.getAnnualSal());
				formulaParameterShow.setSubsidies(monetarySubVw.getSubsidies());
				
				List<OneTimeMonetarySubVw> oneTimeMonetarySubVws = oneTimeMonetarySubService.getOneTimeMonetarySubByStaffId(staffId);
				Calendar calendar2 = Calendar.getInstance();
				calendar.setTime(new Date());
				BigDecimal promoteSub = new BigDecimal(0);
				
				if(oneTimeMonetarySubVws != null){
					
					for (OneTimeMonetarySubVw oneTimeMonetarySubVw : oneTimeMonetarySubVws){
						if(Integer.parseInt(oneTimeMonetarySubVw.getOneTimeSubYear()) == calendar.get(Calendar.YEAR)){
							promoteSub = promoteSub.add(oneTimeMonetarySubVw.getOneTimeSubsidy());
						}
						
					}
					formulaParameterShow.setPromoteSub(promoteSub.doubleValue());
				}
				
				return Msg.success().add("data", formulaParameterShow);
			}else{
				return Msg.error("该员工暂未获得年度补贴");
			}
			
		}else{
			formulaParameterShow.setOldStaff(false);
			//借用逐月补贴视图计算住房补贴标准
			MonetarySubVw monetarySubVw = monetarySubVwService.getByStaffId(staffId);
			if(monetarySubVw != null){
				formulaParameterShow.setAnnualSal(monetarySubVw.getAnnualSal());
				formulaParameterShow.setSubsidies(monetarySubVw.getSubsidies());
				return Msg.success().add("data", formulaParameterShow);
			}else{
				return Msg.error("该员工暂未获得年度补贴");
			}
		}
		
	}
	
	/**
	 * 根据条件获取补贴记录
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getAllMonetarySubByCondition", method = RequestMethod.POST)
	public Msg getAllMonetarySubByCondition(@RequestBody MonetarySubSelectModel monetarySubSelectModel, @RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {

		PageHelper.startPage(page, size);
		List<MonetarySubVw> staffMonetarySubs = staffMonetarySubService.getAllMonetarySubByCondition(monetarySubSelectModel);
		String[] fileds = { "id", "staffId", "staffNo", "staffName", "year", "deptName", "titleName", "postName",
				"postName", "annualSal", "subsidies", "remark" };
		List<Map<String, Object>> response = ResponseUtil.getResultMap(staffMonetarySubs, fileds);
		PageInfo pageInfo = new PageInfo(response);
		return Msg.success().add("data", pageInfo);
	}
	
	/**
	 * 获取所有补贴记录
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getAllMonetarySub", method = RequestMethod.GET)
	public Msg getAllMonetarySub(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {

		PageHelper.startPage(page, size);
		List<MonetarySubVw> staffMonetarySubs = staffMonetarySubService.getAllMonetarySub();
		String[] fileds = { "id", "staffId", "staffNo", "staffName", "year", "deptName", "titleName", "postName",
				"postName", "annualSal", "subsidies", "remark" };
		List<Map<String, Object>> response = ResponseUtil.getResultMap(staffMonetarySubs, fileds);
		PageInfo pageInfo = new PageInfo(response);
		return Msg.success().add("data", pageInfo);
	}

	/**
	 * 根据职工编号获取其所有补贴记录
	 * 
	 * @param staffNo
	 * @param page
	 * @param size
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getMonetarySubByStaffNo/{staffNo}", method = RequestMethod.GET)
	public Msg getMonetarySubByStaffNo(@PathVariable("staffNo") String staffNo,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {

		PageHelper.startPage(page, size);
		if (staffNo != null) {
			List<MonetarySubVw> staffMonetarySubs = staffMonetarySubService.getMonetarySubByStaffNo(staffNo);
			Collections.sort(staffMonetarySubs, new Comparator<MonetarySubVw>() {  
				  
	            @Override  
	            public int compare(MonetarySubVw o1, MonetarySubVw o2) {  
	                // 按照补贴年度进行降序排列  
	                if (o1.getYear().compareTo(o2.getYear()) < 0) {  
	                    return 1;  
	                }  
	                if (o1.getYear().compareTo(o2.getYear()) == 0) {  
	                    return 0;  
	                }  
	                return -1;  
	            }  
	        });  
			
			String[] fileds = { "id", "staffId", "staffNo", "staffName", "year", "deptName", "titleName", "postName",
					"postName", "annualSal", "subsidies", "remark" };
			List<Map<String, Object>> response = ResponseUtil.getResultMap(staffMonetarySubs, fileds);
			PageInfo pageInfo = new PageInfo(response);
			
			List<OneTimeMonetarySubVw> oneTimeMonetarySubVws = oneTimeMonetarySubService.getOneTimeMonetarySubByStaffNo(staffNo);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			BigDecimal totalSubNumber;
			if(staffMonetarySubs.size() > 0){
				totalSubNumber = new BigDecimal(staffMonetarySubs.get(0).getSubsidies());
			}else{
				totalSubNumber = new BigDecimal(0);
			}
//			if(Integer.parseInt(staffMonetarySubs.get(0).getYear()) == calendar.get(Calendar.YEAR)){
//				totalSubNumber = new BigDecimal(staffMonetarySubs.get(0).getSubsidies());
//			}else{
//				totalSubNumber = new BigDecimal(0);
//			}
			
			if(oneTimeMonetarySubVws != null){
				
				for (OneTimeMonetarySubVw oneTimeMonetarySubVw : oneTimeMonetarySubVws){
					if(Integer.parseInt(oneTimeMonetarySubVw.getOneTimeSubYear()) == calendar.get(Calendar.YEAR)){
						totalSubNumber = totalSubNumber.add(oneTimeMonetarySubVw.getOneTimeSubsidy());
					}
					
				}
			}
			
			return Msg.success().add("data", pageInfo).add("totalSubNumber", totalSubNumber);
		} else {
			return Msg.error();
		}
	}

	/**
	 * 根据id删除一条补贴记录
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deleteMonetarySub/{id}", method = RequestMethod.DELETE)
	public Msg deleteMonetarySub(@PathVariable("id") Integer id) {
		if (id != null) {
			staffMonetarySubService.delete(id);
			return Msg.success("删除成功");
		} else {
			return Msg.error();
		}
	}

	/**
	 * 添加一条住房补贴记录
	 * 
	 * @param staffMonetarySub
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addMonetarySub", method = RequestMethod.POST)
	public Msg addMonetarySub(@RequestBody StaffMonetarySub staffMonetarySub) {
		if (staffMonetarySub != null) {
			// 获取补贴比例
			MonetarySubParam monetarySubParam = monetarySubParamService.getIsUsing();
			// 根据职工编号获取职工ID
			Integer staffId = staffService.getStaffIdByStaffNo(staffMonetarySub.getStaffNo());
			Staff staff = staffService.get(staffId);
			Calendar calendar = Calendar.getInstance();
			calendar.set(1998, 11, 31, 0, 0, 0);

			StaffForMonSub staffForMonSub = staffForMonSubService.getByStaffId(staffId);
			double enjoyHouseArea = 80.0;
			// 职务职称享受面积取最大值，获取职工住房补贴标准
			if (staffForMonSub.getMaxEnjoyArea() != null) {
				enjoyHouseArea = staffForMonSub.getMaxEnjoyArea();
			}

			// 获取职工家庭已购住房
			// double buyHouseArea = staffForMonSub.getHouseBuildArea();
			double buyHouseArea = staffForMonSub.getHouseUsedArea();

			if (staffMonetarySubService.isOwnHouse(staffId)
					&& (staff.getJoinTime().getTime() < calendar.getTime().getTime())
					&& enjoyHouseArea > buyHouseArea) {
				// 有房且是老职工且未达标
				double subsidies = (staffMonetarySub.getAnnualSal() + staffMonetarySub.getAnnualSal() * 0.2806)
						* monetarySubParam.getSubParam() / 100.0 / enjoyHouseArea * (enjoyHouseArea - buyHouseArea);
				// 没有四舍五入
				staffMonetarySub.setSubsidies((long) subsidies);
			} else if ((!staffMonetarySubService.isOwnHouse(staffId)
					&& (staff.getJoinTime().getTime() < calendar.getTime().getTime()))
					|| (staff.getJoinTime().getTime() >= calendar.getTime().getTime())) {
				// 无房老职工和新职工的补贴标准
				double subsidies = (staffMonetarySub.getAnnualSal() + staffMonetarySub.getAnnualSal() * 0.2806)
						* monetarySubParam.getSubParam() / 100.0;
				staffMonetarySub.setSubsidies((long) subsidies);
			} else {
				return Msg.error("该职工有房且达标");
			}

			staffMonetarySubService.add(staffMonetarySub);
			return Msg.success("添加成功").add("data", staffMonetarySub);
		} else {
			return Msg.error();
		}
	}

}

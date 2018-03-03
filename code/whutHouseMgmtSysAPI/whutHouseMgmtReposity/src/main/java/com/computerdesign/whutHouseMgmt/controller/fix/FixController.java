package com.computerdesign.whutHouseMgmt.controller.fix;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.text.View;
import javax.ws.rs.Path;
import javax.ws.rs.core.Request;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.fix.Fix;
import com.computerdesign.whutHouseMgmt.bean.fix.FixAddAccept;
import com.computerdesign.whutHouseMgmt.bean.fix.FixAddAgree;
import com.computerdesign.whutHouseMgmt.bean.fix.FixAddCheck;
import com.computerdesign.whutHouseMgmt.bean.fix.FixAddDirectApply;
import com.computerdesign.whutHouseMgmt.bean.fix.FixAddPrice;
import com.computerdesign.whutHouseMgmt.bean.fix.FixGetAccept;
import com.computerdesign.whutHouseMgmt.bean.fix.FixGetAgree;
import com.computerdesign.whutHouseMgmt.bean.fix.FixGetApply;
import com.computerdesign.whutHouseMgmt.bean.fix.FixGetCheck;
import com.computerdesign.whutHouseMgmt.bean.fix.FixGetDirectApply;
import com.computerdesign.whutHouseMgmt.bean.fix.FixGetName;
import com.computerdesign.whutHouseMgmt.bean.fix.FixSetTime;
import com.computerdesign.whutHouseMgmt.bean.fix.HouseGetApply;
import com.computerdesign.whutHouseMgmt.bean.fix.HouseGetDirectApply;
import com.computerdesign.whutHouseMgmt.bean.fix.ViewFix;
import com.computerdesign.whutHouseMgmt.bean.house.House;
import com.computerdesign.whutHouseMgmt.bean.house.ViewHouse;
import com.computerdesign.whutHouseMgmt.bean.houseregister.Resident;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentVw;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffVw;
import com.computerdesign.whutHouseMgmt.service.fix.FixService;
import com.computerdesign.whutHouseMgmt.service.fix.ViewFixService;
import com.computerdesign.whutHouseMgmt.service.house.ViewHouseService;
import com.computerdesign.whutHouseMgmt.service.houseregister.HouseRegisterSelectService;
import com.computerdesign.whutHouseMgmt.service.houseregister.RegisterService;
import com.computerdesign.whutHouseMgmt.service.houseregister.StaffHouseRelService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.StaffVwService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageRowBounds;

@RequestMapping(value = "/fix/")
@Controller
public class FixController {

	@Autowired
	private FixService fixService;
	
	@Autowired
	private StaffVwService staffVwService;
	
	@Autowired
	private ViewHouseService  viewHouseService;
	
	@Autowired
	private StaffHouseRelService staffHouseRelService;
	
	@Autowired
	private ViewFixService viewFixService;
	
	@Autowired
	private RegisterService registerService;
	
	/**
	 * 返回申请页面得到的数据
	 * @param staffId
	 * @return
	 */
	@RequestMapping(value = "getApply/{staffId}" , method = RequestMethod.GET)
	@ResponseBody
	public Msg getFixApply(@PathVariable("staffId")Integer staffId){
		
		StaffVw staffVw = staffVwService.getByID(staffId);
		FixGetApply fixGetApply = new FixGetApply(staffVw);
		
		//根据staffId获取该员工全部的resident信息 
		List<Resident> listResident = registerService.getResidentsByStaffId(staffId);

		if (listResident.isEmpty()) {
			return Msg.success("没有房子").add("data", fixGetApply);
		}else {
			List<ViewHouse> listViewHouse = new ArrayList<ViewHouse>();
			//根据每一个房屋登记信息获取每一个house
			for (Resident resident : listResident) {
				listViewHouse.addAll(viewHouseService.get(resident.getHouseId()));				
			}
			List<HouseGetApply> listHouseGetApply = new ArrayList<HouseGetApply>();
			//增加house信息到新的model中
			for (ViewHouse viewHouse : listViewHouse) {
				listHouseGetApply.add(new HouseGetApply(viewHouse));
			}
			fixGetApply.setHousesList(listHouseGetApply);
			return Msg.success("维修申请页面").add("data", fixGetApply);
		}
	}
	
	/**
	 * 维修申请,获取的参数包括
	 * @param fix
	 * 封装以下数据
	 * @param fixContentId
	 * @param description
	 * @param staffId
	 * @param houseId
	 * @param phone
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "addApply" , method = RequestMethod.POST)
	@ResponseBody
	public Msg addFixApply(@RequestBody Fix fix){
		
		fix.setApplyTime(new Date());
		fix.setFixState("待受理");
		fix.setIsCheck(false);
		fix.setIsOver(false);
		fixService.add(fix);
		return Msg.success("维修申请成功").add("data", fix);
	}
	
	
	
	
	
	/**
	 * 根据员工姓名获取维修直批页面
	 * @param staffName
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "getDirectApplyByStaffName",method = RequestMethod.GET)
	@ResponseBody
	public Msg getDirectApplyByName(@RequestParam(value = "staffName")String staffName)  {
		//TODO 按照姓名获取页面
		try {
			staffName = URLDecoder.decode(staffName,"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(staffName);
		//根据姓名获取全部的StaffVw
		List<StaffVw> listStaffVw = staffVwService.getByStaffName(staffName);
		//无该姓名的员工
		if (listStaffVw.isEmpty()) {
			return Msg.error("无该员工");
		}
		//该姓名员工不止一个
		else {
			//返回FixGetDirectApply数组
			List<FixGetDirectApply> listFixGetDirectApply = new ArrayList<FixGetDirectApply>();

			//将员工信息绑入到model中，其中有FixGetDitectApply(StaffVw)构造器的使用
			for (StaffVw staffVw : listStaffVw) {
				FixGetDirectApply fixGetDirectApply = new FixGetDirectApply(staffVw);
				
				//根据staffId获取该员工全部的residentVw信息 
				List<ResidentVw> listResidentVw = registerService.getResidentVwByStaffId(staffVw.getId());
				
				//房屋数组信息
				List<HouseGetDirectApply> listHouseGetDirectApply = new ArrayList<HouseGetDirectApply>();
				
				
				if (listResidentVw.isEmpty()) {
//					return Msg.success("没有房子").add("data", fixGetDirectApply);
					fixGetDirectApply.setHouseList(null);
				} else {
					// 根据每一个房屋登记信息获取每一个house
					for (ResidentVw residentVw : listResidentVw) {
						if (viewHouseService.get(residentVw.getHouseId()).isEmpty()) {
							// return Msg.error("没有房子");
						} else {
							ViewHouse viewHouse = viewHouseService.get(residentVw.getHouseId()).get(0);
							HouseGetDirectApply houseGetDirectApply = new HouseGetDirectApply();

							houseGetDirectApply.setBookTime(residentVw.getBookTime());
							houseGetDirectApply.setHouseRel(residentVw.getHouseRel());

							houseGetDirectApply.setAddress(viewHouse.getAddress());
							houseGetDirectApply.setHouseId(viewHouse.getId());
							houseGetDirectApply.setLayoutName(viewHouse.getLayoutName());
							houseGetDirectApply.setUsedArea(viewHouse.getUsedArea());

							listHouseGetDirectApply.add(houseGetDirectApply);
						}
					}
					fixGetDirectApply.setHouseList(listHouseGetDirectApply);
				}
				listFixGetDirectApply.add(fixGetDirectApply);
			}
			return Msg.success("根据员工姓名获取维修直批页面").add("data", listFixGetDirectApply);
//		}else{
//			//只有一个员工
//			StaffVw staffVw = listStaffVw.get(0);
//		
//			//将员工信息绑入到model中，其中有FixGetDitectApply(StaffVw)构造器的使用
//			FixGetDirectApply fixGetDirectApply = new FixGetDirectApply(staffVw);
//			
//			//根据staffId获取该员工全部的residentVw信息 
//			List<ResidentVw> listResidentVw = registerService.getResidentVwByStaffId(staffVw.getId());
//			
//			//房屋数组信息
//			List<HouseGetDirectApply> listHouseGetDirectApply = new ArrayList<HouseGetDirectApply>();
//			
//			
//			if (listResidentVw.isEmpty()) {
//				return Msg.success("没有房子").add("data", fixGetDirectApply);
//			} else {
//				// 根据每一个房屋登记信息获取每一个house
//				for (ResidentVw residentVw : listResidentVw) {
//					if (viewHouseService.get(residentVw.getHouseId()).isEmpty()) {
//						return Msg.error("没有房子");
//					}
//					ViewHouse viewHouse = viewHouseService.get(residentVw.getHouseId()).get(0);
//					HouseGetDirectApply houseGetDirectApply = new HouseGetDirectApply();
//					
//					houseGetDirectApply.setBookTime(residentVw.getBookTime());
//					houseGetDirectApply.setHouseRel(residentVw.getHouseRel());
//
//					houseGetDirectApply.setAddress(viewHouse.getAddress());
//					houseGetDirectApply.setHouseId(viewHouse.getId());
//					houseGetDirectApply.setLayoutName(viewHouse.getLayoutName());
//					houseGetDirectApply.setUsedArea(viewHouse.getUsedArea());
//					
//					listHouseGetDirectApply.add(houseGetDirectApply);
//				}
//				fixGetDirectApply.setHouseList(listHouseGetDirectApply);
//				
//				return Msg.success("根据员工姓名获取维修直批页面").add("data", fixGetDirectApply);
//			}
		}
	}
	
	/**
	 * 根据员工Id获取维修直批页面
	 * @param staffId
	 * @return
	 */
	@RequestMapping(value = "getDirectApplyByStaffId/{staffId}",method = RequestMethod.GET)
	@ResponseBody
	public Msg getDirectApplyByStaffId(@PathVariable("staffId")Integer staffId){
		StaffVw staffVw = staffVwService.getByID(staffId);
		//将员工信息绑入到model中，其中有FixGetDitectApply(StaffVw)构造器的使用
		FixGetDirectApply fixGetDirectApply = new FixGetDirectApply(staffVw);
		
		//根据staffId获取该员工全部的residentVw信息 
		List<ResidentVw> listResidentVw = registerService.getResidentVwByStaffId(staffId);
		//TODO 未设置IsDelete导致筛选过多
		
		//房屋数组信息
		List<HouseGetDirectApply> listHouseGetDirectApply = new ArrayList<HouseGetDirectApply>();
		
		
		if (listResidentVw.isEmpty()) {
			return Msg.success("没有房子").add("data", fixGetDirectApply);
		} else {
			// 根据每一个房屋登记信息获取每一个house
			for (ResidentVw residentVw : listResidentVw) {
				if (viewHouseService.get(residentVw.getHouseId()).isEmpty()) {
					return Msg.error("没有房子");
				}
				ViewHouse viewHouse = viewHouseService.get(residentVw.getHouseId()).get(0);
				HouseGetDirectApply houseGetDirectApply = new HouseGetDirectApply();
				
				houseGetDirectApply.setBookTime(residentVw.getBookTime());
				houseGetDirectApply.setHouseRel(residentVw.getHouseRel());

				houseGetDirectApply.setAddress(viewHouse.getAddress());
				houseGetDirectApply.setHouseId(viewHouse.getId());
				houseGetDirectApply.setLayoutName(viewHouse.getLayoutName());
				houseGetDirectApply.setUsedArea(viewHouse.getUsedArea());
				
				listHouseGetDirectApply.add(houseGetDirectApply);
			}
			fixGetDirectApply.setHouseList(listHouseGetDirectApply);
			
			return Msg.success("根据员工id获取维修直批页面").add("data", fixGetDirectApply);
		}
	}
	
	/**
	 * 维修直批
	 * @param fixAddDirectApply
	 * @return
	 */
	@RequestMapping(value = "addDirectApply",method = RequestMethod.POST)
	@ResponseBody
	public Msg addDirectApply(@RequestBody FixAddDirectApply fixAddDirectApply){
		Fix fix = new Fix();
		fix.setFixContentId(fixAddDirectApply.getFixContentId());
		fix.setApplyTime(new Date());
		fix.setFixState("已审核");
		fix.setAcceptState("通过");
		fix.setAcceptNote("直批");
		fix.setAcceptMan(fixAddDirectApply.getDirectApplyMan());
		fix.setAcceptTime(new Date());
		fix.setAgreeState("通过");
		fix.setAgreeNote("直批");
		fix.setAgreeMan(fixAddDirectApply.getDirectApplyMan());
		fix.setAgreeTime(new Date());
		fix.setStaffId(fixAddDirectApply.getStaffId());
		fix.setHouseId(fixAddDirectApply.getHouseId());
		fix.setMessage("直批");
		fix.setIsOver(true);
		
		fixService.add(fix);
		return Msg.success("直批成功");
	}
	
	/**
	 * 获取全部尚未定价的维修信息
	 * @return
	 */
	@RequestMapping(value = "getFixManagement",method = RequestMethod.GET)
	@ResponseBody
	public Msg getFixManagement(@RequestParam(value = "page",defaultValue = "0")Integer page,
			@RequestParam(value = "size",defaultValue = "0")Integer size){
		
		List<FixGetAgree> listFixGetAgree = new ArrayList<FixGetAgree>();
		
		PageHelper.startPage(page, size);
		List<ViewFix> listViewFix = viewFixService.getManagement();
		
		for (ViewFix viewFix : listViewFix) {
			listFixGetAgree.add(new FixGetAgree(viewFix));
		}
		//让listViewFix设置好pageInfo中的各项属性，再替换pageInfo中的list
		PageInfo pageInfo = new PageInfo(listViewFix);
		pageInfo.setList(listFixGetAgree);
		
		return Msg.success("获取全部尚未定价的维修信息").add("data", pageInfo);
//		PageInfo pageInfo = new PageInfo(listViewFix);
//		return Msg.success("获取全部尚未定价的维修信息").add("data", pageInfo);
	}
	/**
	 * 获取结算页面信息
	 * @return
	 */
	@RequestMapping(value = "getCheck",method = RequestMethod.GET)
	@ResponseBody
	public Msg getFixCheck(@RequestParam(value = "page",defaultValue = "0")Integer page,
			@RequestParam(value = "size",defaultValue = "0")Integer size) {
		
		PageHelper.startPage(page, size);
		List<ViewFix> list = viewFixService.getAll();
		
		PageInfo pageInfo = new PageInfo(list);
		return Msg.success("获取维修结算页面").add("data", pageInfo);
	}
	
//	@RequestMapping(value = "getCheck",method = RequestMethod.GET)
//	@ResponseBody
//	public Msg getFixCheck(@PathVariable FixSetTime fixSetTime){
//		
//		Date startTime = fixSetTime.getStartTime();
//		Date endTime = fixSetTime.getEndTime();	
//		List<ViewFix> list =  viewFixService.getByTime(startTime, endTime);
//		return Msg.success().add("data", list);
//	}
	
	/**
	 * 结算页面按条件查询
	 * @param fixGetCheck
	 * @return
	 */
	@RequestMapping(value = "getCheckByAllMultiCondition",method = RequestMethod.POST)
	@ResponseBody
	public Msg getFixCheck(@RequestBody FixGetCheck fixGetCheck,
			@RequestParam(value = "page",defaultValue = "0")Integer page,
			@RequestParam(value = "size", defaultValue = "0")Integer size){
		
		PageHelper.startPage(page, size);
		List<ViewFix> list = viewFixService.getByMultiCondition(fixGetCheck);
		
		
		PageInfo pageInfo = new PageInfo(list);
		return Msg.success().add("data", pageInfo);
	}
	
	/**
	 * 维修定价
	 * @param fixAddPrice
	 * @return
	 */
	@RequestMapping(value = "addPrice",method = RequestMethod.PUT)
	@ResponseBody
	public Msg addFixPrice(@RequestBody FixAddPrice fixAddPrice){
		
			Fix fix = fixService.get(fixAddPrice.getId());
			fix.setPriceMan(fixAddPrice.getPriceMan());
			fix.setFixMoney(fixAddPrice.getPrice());
			fix.setPriceTime(new Date());
			//维修状态改变
			fixService.update(fix);
			return Msg.success().add("data", fix);
			
	}
	
	/**
	 * 维修结算
	 * @param fixAddCheck
	 * @return
	 */
	@RequestMapping(value = "addCheck",method = RequestMethod.PUT)
	@ResponseBody
	public Msg addFixCheck(@RequestBody FixAddCheck fixAddCheck){
		
		Fix fix = fixService.get(fixAddCheck.getId());
		fix.setCheckMan(fixAddCheck.getCheckMan());
		fix.setCheckTime(new Date());
		fix.setIsCheck(true);
		//维修状态改变
		fixService.update(fix);
		return Msg.success().add("data", fix);
	}
}

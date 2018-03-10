package com.computerdesign.whutHouseMgmt.controller.hire;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.hire.apply.HireAddApply;
import com.computerdesign.whutHouseMgmt.bean.hire.apply.HireApplyAlready;
import com.computerdesign.whutHouseMgmt.bean.hire.apply.HireGetApply;
import com.computerdesign.whutHouseMgmt.bean.hire.apply.HireHouseGetApply;
import com.computerdesign.whutHouseMgmt.bean.hire.common.Hire;
import com.computerdesign.whutHouseMgmt.bean.hire.common.ViewHire;
import com.computerdesign.whutHouseMgmt.bean.hire.directapply.HireAddDirectApply;
import com.computerdesign.whutHouseMgmt.bean.hire.directapply.HireGetDirectApply;
import com.computerdesign.whutHouseMgmt.bean.hire.directapply.HireHouseGetDirectApply;
import com.computerdesign.whutHouseMgmt.bean.hire.signcontract.HireAddSignContract;
import com.computerdesign.whutHouseMgmt.bean.hire.signcontract.HireGetSignContract;
import com.computerdesign.whutHouseMgmt.bean.house.ViewHouse;
import com.computerdesign.whutHouseMgmt.bean.houseregister.Resident;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentVw;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffHouse;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.Staff;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffVw;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.ViewStaff;
import com.computerdesign.whutHouseMgmt.service.hire.HireService;
import com.computerdesign.whutHouseMgmt.service.hire.StaffHouseService;
import com.computerdesign.whutHouseMgmt.service.hire.ViewHireService;
import com.computerdesign.whutHouseMgmt.service.house.ViewHouseService;
import com.computerdesign.whutHouseMgmt.service.houseregister.RegisterService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.StaffService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.StaffVwService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.ViewStaffService;
import com.computerdesign.whutHouseMgmt.service.staffparam.StaffParameterService;
import com.computerdesign.whutHouseMgmt.utils.JSONUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author wanhaoran
 *
 */
@RequestMapping(value = "/hire/")
@Controller
public class HireController {

	@Autowired
	private HireService hireService;

	@Autowired
	private ViewHireService viewHireService;

	@Autowired
	private StaffHouseService staffHouseService;

	@Autowired
	private ViewStaffService viewStaffService;

	@Autowired
	private RegisterService registerService;

	@Autowired
	private ViewHouseService viewHouseService;

	/**
	 * 获取住房申请页面
	 * 
	 * @param staffId
	 * @return
	 */
	@RequestMapping(value = "getApply/{staffId}", method = RequestMethod.GET)
	@ResponseBody
	public Msg getHireApply(@PathVariable("staffId") Integer staffId) {

		// 获取员工信息
		ViewStaff viewStaff = viewStaffService.getByStaffId(staffId).get(0);
		// 将员工信息封装
		HireGetApply hireGetApply = new HireGetApply(viewStaff);

		// 用StaffHouse表，来判断该员工的房屋信息
		List<StaffHouse> listStaffHouse = new ArrayList<StaffHouse>();
		// 根据staffId获取staffHouse的list
		listStaffHouse = staffHouseService.getStaffHouseByStaffId(staffId);

		// 该员工的房屋不为空
		if (!listStaffHouse.isEmpty()) {
			// 该员工的房屋集合
			List<HireHouseGetApply> listHouseGetApply = new ArrayList<HireHouseGetApply>();
			for (StaffHouse staffHouseD : listStaffHouse) {
				// 封装房屋信息
				listHouseGetApply.add(new HireHouseGetApply(staffHouseD));
			}
			hireGetApply.setListHouseGetApply(listHouseGetApply);
		}

		// 已申请租赁信息集合
		if (!viewHireService.getByStaffId(staffId).isEmpty()) {
			ViewHire viewHirePre = viewHireService.getByStaffId(staffId).get(0);
			HireApplyAlready hireApplyAlready = new HireApplyAlready(viewHirePre);
			hireGetApply.setHireApplyAlready(hireApplyAlready);
		}

		
		return Msg.success("返回住房申请页面").add("data", hireGetApply);

	}

	/**
	 * 住房申请
	 * 
	 * @param hire
	 * @return
	 */
	@RequestMapping(value = "addApply", method = RequestMethod.POST)
	@ResponseBody
	public Msg addHireApply(@RequestBody Hire hire) {

		// 判断该员工是否已经申请房屋
		if (!viewHireService.getByStaffId(hire.getStaffId()).isEmpty()) {
			ViewHire viewHirePre = viewHireService.getByStaffId(hire.getStaffId()).get(0);
			if (viewHirePre.getAcceptState() != null) {
				return Msg.error("该员工正在申请房屋，无法再次申请");
			}
		}

		// 获取员工信息
		ViewStaff viewStaff = viewStaffService.getByStaffId(hire.getStaffId()).get(0);

		hire.setApplyTime(new Date());
		hire.setHireState("待受理");
		hire.setIsOver(false);

		hire.setTimeVal(viewStaff.getTimeVal());
		hire.setOtherVal(viewStaff.getOtherVal());
		hire.setSpouseVal(viewStaff.getSpouseTitleVal().doubleValue());

		if(viewStaff.getTitleVal()!=null){
			hire.setTitleVal(viewStaff.getTitleVal().doubleValue());			
		}
		if (viewStaff.getTotalVal()!=null) {
			hire.setTotalVal(viewStaff.getTotalVal().doubleValue());			
		}

		hireService.add(hire);
		return Msg.success("提交申请成功");
	}

	/**
	 * 签订合同页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "getSignContract", method = RequestMethod.GET)
	@ResponseBody
	public Msg HireGetSignContract() {
		// 获取全部等待签订合同的信息
		List<ViewHire> listViewHire = viewHireService.getSignContract();
		List<HireGetSignContract> listHireGetSignContract = new ArrayList<HireGetSignContract>();
		// 遍历每一个房屋申请信息
		for (ViewHire viewHire : listViewHire) {
			// 封装房屋信息
			listHireGetSignContract.add(new HireGetSignContract(viewHire));
		}
		return Msg.success("全部已审批尚未签订合同的房屋申请信息").add("data", listHireGetSignContract);
	}

	/**
	 * 签订合同
	 * 
	 * @param hireAddSignContract
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "addSignContract", method = RequestMethod.POST)
	@ResponseBody
	public Msg HireAddSignContract(@RequestBody HireAddSignContract hireAddSignContract) {
		// 获取该房屋申请信息
		Hire hire = hireService.getHireById(hireAddSignContract.getId());
		if (hire.getIsOver()) {
			return Msg.error("该房屋申请已经签订过合同");
		}
		// 设置该申请已结束
		hire.setIsOver(true);

		// 住房登记信息
		Resident resident = new Resident();
		resident.setBookTime(hireAddSignContract.getBookTime());
		resident.setStaffId(hire.getStaffId());
		resident.setHouseId(hire.getHouseId());
		resident.setIsDelete(false);

		// 设置ExpireTime时间为两年后
		Calendar bookTime = Calendar.getInstance();
		bookTime.setTime(hireAddSignContract.getBookTime());
		bookTime.add(Calendar.YEAR, +2);
		Date expireTime = bookTime.getTime();
		resident.setExpireTime(expireTime);

		resident.setRentType("工资");
		// TODO 这里的HouseRel应该是租赁，修改数据库后注意审查
		resident.setHouseRel(78);

		
		hireService.update(hire);
		registerService.register(resident);
		return Msg.success("成功签订合同").add("data", resident);
	}

	/**
	 * 获取房屋直批页面
	 * 
	 * @param staffId
	 * @return
	 */
	@RequestMapping(value = "getDirectApply/{staffId}", method = RequestMethod.GET)
	@ResponseBody
	public Msg HireGetDirectApply(@PathVariable("staffId") Integer staffId) {
		// 获取员工信息，并将信息封装
		ViewStaff viewStaff = viewStaffService.getByStaffId(staffId).get(0);
		HireGetDirectApply hireGetDirectApply = new HireGetDirectApply(viewStaff);

		// 根据员工信息获取该员工所有的房屋信息
		List<ResidentVw> listResidentVw = registerService.getResidentVwByStaffId(staffId);
		// 用来存放该员工所有房屋信息的封装集合
		List<HireHouseGetDirectApply> listHouseGetDirectApply = new ArrayList<HireHouseGetDirectApply>();

		// 该员工有房屋
		if (!listResidentVw.isEmpty()) {
			// 遍历每一个房屋
			for (ResidentVw residentVw : listResidentVw) {

				HireHouseGetDirectApply houseGetDirectApply = new HireHouseGetDirectApply();
				if (viewHouseService.get(residentVw.getHouseId()).isEmpty()) {
					// TODO 不可能的错误
				} else {
					// 获取房屋信息
					ViewHouse viewHouse = viewHouseService.get(residentVw.getHouseId()).get(0);

					houseGetDirectApply.setBookTime(residentVw.getBookTime());
					houseGetDirectApply.setHouseRel(residentVw.getHouseRel());

					houseGetDirectApply.setAddress(residentVw.getAddress());
					houseGetDirectApply.setHouseId(residentVw.getHouseId());
					houseGetDirectApply.setLayoutName(viewHouse.getLayoutName());
					houseGetDirectApply.setTypeName(viewHouse.getTypeName());
					houseGetDirectApply.setUsedArea(viewHouse.getUsedArea());
					// 将封装好的房屋信息加入集合中
					listHouseGetDirectApply.add(houseGetDirectApply);
				}
			}
			hireGetDirectApply.setListHouseGetDirectApply(listHouseGetDirectApply);
		} else {
			hireGetDirectApply.setListHouseGetDirectApply(null);
		}

		return Msg.success("房屋直批页面").add("data", hireGetDirectApply);
	}

	/**
	 * 房屋直批
	 * 
	 * @param hireAddDirectApply
	 * @return
	 */
	@RequestMapping(value = "addDirectApply", method = RequestMethod.POST)
	@ResponseBody
	public Msg HireAddDirectApply(@RequestBody HireAddDirectApply hireAddDirectApply) {
		Hire hire = new Hire();

		hire.setStaffId(hireAddDirectApply.getId());
		hire.setHouseId(hireAddDirectApply.getHouseId());

		// 通过reason来判断是否为直批
		hire.setReason("直批");

		hire.setApplyTime(new Date());
		hire.setHireState("已审批");

		hire.setAcceptMan(hireAddDirectApply.getDirectApplyMan());
		hire.setAcceptNote(hireAddDirectApply.getDirectApplyNote());
		hire.setAcceptState("通过");
		hire.setAcceptTime(new Date());

		hire.setAgreeMan(hireAddDirectApply.getDirectApplyMan());
		hire.setAgreeNote(hireAddDirectApply.getDirectApplyNote());
		hire.setAgreeState("通过");
		hire.setAgreeTime(new Date());

		hire.setApproveMan(hireAddDirectApply.getDirectApplyMan());
		hire.setApproveNote(hireAddDirectApply.getDirectApplyNote());
		hire.setApproveState("通过");
		hire.setApproveTime(new Date());

		hire.setIsOver(false);

		hireService.add(hire);

		return Msg.success("房屋直批");
	}
	
	/**
	 * 房屋申请书管理页面
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "getManagement",method = RequestMethod.GET)
	@ResponseBody
	public Msg getManagement(@RequestParam(value = "page", defaultValue = "0")Integer page,
			@RequestParam(value = "size", defaultValue = "0")Integer size){
		PageHelper.startPage(page, size);
		List<ViewHire> listViewHire = viewHireService.getAllViewHire();
		PageInfo pageInfo = new PageInfo<>(listViewHire);
		return Msg.success().add("data", pageInfo);
	}
	
	/**
	 * 根据hireId删除一条hire
	 * @param hireId
	 * @return
	 */
	@RequestMapping(value = "delete/{hireId}",method = RequestMethod.DELETE)
	@ResponseBody
	public Msg hireDelete(@PathVariable(value = "hireId")Integer hireId){
		Hire hire = hireService.getHireById(hireId);
		if (hire==null) {
			return Msg.error("错误的请求");
		}
		hireService.delete(hireId);
		return Msg.success("删除该条记录");
	}
}

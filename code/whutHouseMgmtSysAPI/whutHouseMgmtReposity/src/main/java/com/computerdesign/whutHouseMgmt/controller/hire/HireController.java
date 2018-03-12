package com.computerdesign.whutHouseMgmt.controller.hire;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.hire.apply.HireApplyAlready;
import com.computerdesign.whutHouseMgmt.bean.hire.apply.HireGetApply;
import com.computerdesign.whutHouseMgmt.bean.hire.apply.HireHouseGetApply;
import com.computerdesign.whutHouseMgmt.bean.hire.common.Hire;
import com.computerdesign.whutHouseMgmt.bean.hire.common.ViewHire;
import com.computerdesign.whutHouseMgmt.bean.hire.signcontract.HireAddSignContract;
import com.computerdesign.whutHouseMgmt.bean.hire.signcontract.HireGetSignContract;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffHouse;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.ViewStaff;
import com.computerdesign.whutHouseMgmt.service.hire.HireService;
import com.computerdesign.whutHouseMgmt.service.hire.StaffHouseService;
import com.computerdesign.whutHouseMgmt.service.hire.ViewHireService;
import com.computerdesign.whutHouseMgmt.service.house.HouseService;
import com.computerdesign.whutHouseMgmt.service.houseregister.RegisterService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.ViewStaffService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author wanhaoran
 *
 */
@RequestMapping(value = "/hire/")
@RestController
@Api(value = "/hire/",tags = "Hire接口")
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
	private HouseService houseService;

	/**
	 * 获取住房申请页面
	 * 
	 * @param staffId
	 * @return
	 */
	@RequestMapping(value = "getApply/{staffId}", method = RequestMethod.GET)
	@ApiOperation(value = "住房申请页面",notes="住房申请页面",httpMethod="GET",response = com.computerdesign.whutHouseMgmt.bean.Msg.class)
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
	@ApiOperation(value = "住房申请",notes="住房申请",httpMethod="POST",response = com.computerdesign.whutHouseMgmt.bean.Msg.class)
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
	@ApiOperation(value = "签订合同页面",notes="签订合同页面",httpMethod="GET",response = com.computerdesign.whutHouseMgmt.bean.Msg.class)
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
	@ApiOperation(value = "签订合同",notes="签订合同",httpMethod="POST",response = com.computerdesign.whutHouseMgmt.bean.Msg.class)
	public Msg HireAddSignContract(@RequestBody HireAddSignContract hireAddSignContract) {
		// 获取该房屋申请信息
		Hire hire = hireService.getHireById(hireAddSignContract.getId());
		if (hire.getIsOver()) {
			return Msg.error("该房屋申请已经签订过合同");
		}
		// 设置该申请已结束
		hire.setIsOver(true);
		hireService.update(hire);
		//TODO 78为当前数据库租赁对于的id
		houseService.updateHouseStatus(hire.getHouseId(), 78);
		registerService.registerByHire(hire);
		return Msg.success("成功签订合同");
	}

	
	
	/**
	 * 房屋申请书管理页面
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "getManagement",method = RequestMethod.GET)
	@ApiOperation(value = "住房申请书页面",notes="住房申请书页面",httpMethod="GET",response = com.computerdesign.whutHouseMgmt.bean.Msg.class)
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
	@ApiOperation(value = "删除",notes="删除",httpMethod="DELETE",response = com.computerdesign.whutHouseMgmt.bean.Msg.class)
	public Msg hireDelete(@PathVariable(value = "hireId")Integer hireId){
		Hire hire = hireService.getHireById(hireId);
		if (hire==null) {
			return Msg.error("错误的请求");
		}
		hireService.delete(hireId);
		return Msg.success("删除该条记录");
	}
}

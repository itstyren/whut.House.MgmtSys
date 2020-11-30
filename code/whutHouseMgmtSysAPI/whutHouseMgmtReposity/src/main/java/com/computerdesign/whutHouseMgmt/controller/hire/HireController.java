package com.computerdesign.whutHouseMgmt.controller.hire;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
import com.computerdesign.whutHouseMgmt.bean.hire.PersonalHireRecord;
import com.computerdesign.whutHouseMgmt.bean.hire.common.Hire;
import com.computerdesign.whutHouseMgmt.bean.hire.common.ViewHire;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.house.ViewHouse;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffHouse;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.ViewStaff;
import com.computerdesign.whutHouseMgmt.service.hire.HireService;
import com.computerdesign.whutHouseMgmt.service.hire.StaffHouseService;
import com.computerdesign.whutHouseMgmt.service.hire.ViewHireService;
import com.computerdesign.whutHouseMgmt.service.house.HouseService;
import com.computerdesign.whutHouseMgmt.service.house.ViewHouseService;
import com.computerdesign.whutHouseMgmt.service.houseregister.RegisterService;
import com.computerdesign.whutHouseMgmt.service.staffhomepage.LastHireRecordService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.ViewStaffService;
import com.computerdesign.whutHouseMgmt.utils.ResponseUtil;
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
@Api(value = "/hire/", description = "Hire接口")
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

	@Autowired
	private ViewHouseService viewHouseService;
	@Autowired
	private LastHireRecordService lastHireRecordService;

	/**
	 * 根据职工id获取其所有租赁信息
	 * 
	 * @param staffId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getAllByStaffId/{staffId}", method = RequestMethod.GET)
	public Msg getAllByStaffId(@PathVariable("staffId") Integer staffId) {
		List<Hire> hires = hireService.getByStaffId(staffId);
		List<PersonalHireRecord> personalHireRecords = new ArrayList<PersonalHireRecord>();
		for (Hire hire : hires) {
			PersonalHireRecord personalHireRecord = new PersonalHireRecord();
			personalHireRecord.setReason(hire.getReason());
			// 获取地址
			if(houseService.get(hire.getHouseId()) != null){
				String address = houseService.get(hire.getHouseId()).getAddress();
				personalHireRecord.setAddress(address);
			}else{
				personalHireRecord.setAddress("在申请中...");
			}
			String processReason = null;
			// 判断审核流程进行到了哪一步
			if (hire.getAgreeNote() != null) {
				processReason = hire.getAgreeNote();
			} else if (hire.getAcceptNote() != null) {
				processReason = hire.getAgreeNote();
			} else {
				processReason = "无意见";
			}
			personalHireRecord.setHireState(hire.getHireState());
			personalHireRecord.setApplyTime(hire.getApplyTime());
			personalHireRecords.add(personalHireRecord);
		}
		return Msg.success().add("data", personalHireRecords);
	}

	/**
	 * 获取住房申请页面
	 * 
	 * @param staffId
	 * @return
	 */
	@RequestMapping(value = "getApply/{staffId}", method = RequestMethod.GET)
	@ApiOperation(value = "住房申请页面", notes = "住房申请页面", httpMethod = "GET", response = com.computerdesign.whutHouseMgmt.bean.Msg.class)
	public Msg getHireApply(@PathVariable("staffId") Integer staffId) {

		// 获取员工信息
		ViewStaff viewStaff = viewStaffService.getByStaffId(staffId).get(0);
		// 用StaffHouse表，来判断该员工的房屋信息
		List<StaffHouse> listStaffHouse = staffHouseService.getStaffHouseByStaffId(staffId);

		for (StaffHouse staffHouse : listStaffHouse) {
			if (staffHouse.getHouseRelName().equals("租赁")) {
				return Msg.error("该员工已申请过住房，无法再次申请");
			}
		}

		String[] fileds = { "Id", "No", "Name", "Sex", "TitleName", "PostName", 
				"TypeName", "PostVal", "SpousePostVal", "DeptName", 
				"Code", "Tel" };

		Map<String, Object> response = ResponseUtil.getResultMap(viewStaff, fileds);
		// 该员工的房屋不为空
		if (!listStaffHouse.isEmpty()) {
			String[] houseListFileds = { "houseId", "houseNo", "houseTypeName", "houseAddress", "houseBuildArea",
					"houseUsedArea", "houseRelName" };
			List<Map<String, Object>> listHouse = ResponseUtil.getResultMap(listStaffHouse, houseListFileds);
			response.put("listHouseGetApply", listHouse);
		}

		// 已申请租赁信息集合
		if (!viewHireService.getByStaffId(staffId).isEmpty()) {
			ViewHire viewHirePre = viewHireService.getByStaffId(staffId).get(0);
			String[] hirePrefileds = { "id", "staffNo", "totalVal", "hireState" };
			Map<String, Object> listHirePre = ResponseUtil.getResultMap(viewHirePre, hirePrefileds);
			response.put("hireApplyAlready", listHirePre);
		} else {
		}
		return Msg.success("返回住房申请页面").add("data", response);

	}

	/**
	 * 住房申请
	 * 
	 * @param hire
	 * @return
	 */

	@RequestMapping(value = "addApply", method = RequestMethod.POST)
	@ApiOperation(value = "住房申请", notes = "住房申请", httpMethod = "POST", response = com.computerdesign.whutHouseMgmt.bean.Msg.class)
	public Msg addHireApply(@RequestBody Hire hire) {

		// 判断该员工是否已经申请房屋
		if (!viewHireService.getByStaffId(hire.getStaffId()).isEmpty()) {
			ViewHire viewHirePre = viewHireService.getByStaffId(hire.getStaffId()).get(0);
			if (viewHirePre.getHireState() != null) {
				return Msg.error("该员工正在申请房屋，无法再次申请");
			}
		}

		// 获取员工信息
		ViewStaff viewStaff = viewStaffService.getByStaffId(hire.getStaffId()).get(0);

		hire.setApplyTime(new Date());
		hire.setHireState("待受理");
		hire.setIsOver(false);

		//2018.08.13 XieHao增加并更改空值判断，若为空，则设置为0
		if(viewStaff.getTimeVal()!= null){
			hire.setTimeVal(viewStaff.getTimeVal());
		}else{
			hire.setTimeVal(0.0);
		}
		if(viewStaff.getOtherVal() != null){
			hire.setOtherVal(viewStaff.getOtherVal());
		}else{
			hire.setOtherVal(0.0);
		}
		if(viewStaff.getSpouseTitleVal() != null){
			hire.setSpouseVal(viewStaff.getSpouseTitleVal().doubleValue());
		}else{
			hire.setSpouseVal(0.0);
		}

		if (viewStaff.getTitleVal() != null) {
			hire.setTitleVal(viewStaff.getTitleVal().doubleValue());
		}else{
			hire.setTitleVal(0.0);
		}
		
//		if (viewStaff.getTotalVal() != null) {
//			hire.setTotalVal(viewStaff.getTotalVal().doubleValue());
//		}else{
//			hire.setTotalVal(0.0);
//		}
		
		hire.setTotalVal(hire.getOtherVal() + hire.getSpouseVal() + hire.getTitleVal() + hire.getTimeVal());

		hireService.add(hire);
		return Msg.success("提交申请成功");
	}

	/**
	 * 签订合同页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "getSignContract", method = RequestMethod.GET)
	@ApiOperation(value = "签订合同页面", notes = "签订合同页面", httpMethod = "GET", response = com.computerdesign.whutHouseMgmt.bean.Msg.class)
	public Msg HireGetSignContract() {
		// 获取全部等待签订合同的信息
		List<ViewHire> listViewHire = viewHireService.getSignContract();

		String[] fileds = { "id", "name", "applyTime", "hireState", "reason", "phone", "titleName", "postName",
				"deptName", "houseNo", "houseBuildArea", "houseUserArea", "houseAddress", "acceptNote", "acceptState",
				"acceptMan", "acceptTime", "agreeNote", "agreeState", "agreeMan", "agreeTime", "approveNote",
				"approveState", "approveMan", "approveTime", "totalVal", "titleVal", "timeVal", "spouseVal",
				"otherVal" };
		List<Map<String, Object>> response = ResponseUtil.getResultMap(listViewHire, fileds);
		return Msg.success("全部已审批尚未签订合同的房屋申请信息").add("data", response);
	}

	/**
	 * 签订合同
	 * 
	 * @param hireAddSignContract
	 * @return
	 */
	@Transactional
	@PostMapping(value = "addSignContract")
	@ApiOperation(value = "签订合同",notes="签订合同",httpMethod="GET",response = com.computerdesign.whutHouseMgmt.bean.Msg.class)
	public Msg hireAddSignContract(@RequestBody HashMap<String, Object> hashMap) {

		Integer id = (Integer)hashMap.get("id");

		// 获取该房屋申请信息
		Hire hire = hireService.getHireById(id);
		if (hire.getIsOver()) {
			return Msg.error("该房屋申请已经签订过合同");
		}
		if (!"已审批".equals(hire.getHireState())) {
			return Msg.error("该房屋无法签订合同");
		}
		ViewHouse viewHouse = viewHouseService.get(hire.getHouseId()).get(0);
		if (!viewHouse.getStatusName().equals("空闲")) {
			return Msg.error("该房屋已被他人租赁或购买，无法操作");
		}
		// 设置该申请已结束
		hire.setIsOver(true);

		hireService.addSignContract(hire);

		return Msg.success("成功签订合同");
	}

	/**
	 * 房屋申请书管理页面
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "getManagement", method = RequestMethod.GET)
	@ApiOperation(value = "住房申请书页面", notes = "住房申请书页面", httpMethod = "GET", response = com.computerdesign.whutHouseMgmt.bean.Msg.class)
	public Msg getManagement(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size) {
		PageHelper.startPage(page, size);
		List<ViewHire> listViewHire = viewHireService.getAllViewHire();
		PageInfo pageInfo = new PageInfo<>(listViewHire);
		return Msg.success().add("data", pageInfo);
	}

	/**
	 * 根据hireId删除一条hire
	 * 
	 * @param hireId
	 * @return
	 */
	@RequestMapping(value = "delete/{hireId}", method = RequestMethod.DELETE)
	@ApiOperation(value = "删除", notes = "删除", httpMethod = "DELETE", response = com.computerdesign.whutHouseMgmt.bean.Msg.class)
	public Msg hireDelete(@PathVariable(value = "hireId") Integer hireId) {
		Hire hire = hireService.getHireById(hireId);
		if (hire == null) {
			return Msg.error("错误的请求");
		}
		hireService.delete(hireId);
		return Msg.success("删除该条记录");
	}
}

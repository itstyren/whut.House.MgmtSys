package com.computerdesign.whutHouseMgmt.controller.staffmanagement;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.FormParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.housesub.BeforePromoteData;
import com.computerdesign.whutHouseMgmt.bean.housesub.MonetarySubVw;
import com.computerdesign.whutHouseMgmt.bean.housesub.StaffForMonSub;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.Staff;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffIcon;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffModel;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffValue;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffVw;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.UpdateStaffRoleModel;
import com.computerdesign.whutHouseMgmt.bean.staffparam.StaffParameter;
import com.computerdesign.whutHouseMgmt.bean.staffparam.StaffParameterModel;
import com.computerdesign.whutHouseMgmt.controller.BaseController;
import com.computerdesign.whutHouseMgmt.service.housesub.BeforePromoteDataService;
import com.computerdesign.whutHouseMgmt.service.housesub.MonetarySubVwService;
import com.computerdesign.whutHouseMgmt.service.housesub.StaffForMonSubService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.StaffService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.StaffVwService;
import com.computerdesign.whutHouseMgmt.service.staffparam.StaffParameterService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping("/staff/")
@Controller
public class StaffController extends BaseController {

	@Autowired
	private StaffParameterService staffParameterSerivce;

	@Autowired
	private StaffVwService staffVwService;

	@Autowired
	private StaffService staffService;

	@Autowired
	private BeforePromoteDataService beforePromoteDataService;
	
	@Autowired
	private MonetarySubVwService monetarySubVwService;
	
	@Autowired
	private StaffForMonSubService staffForMonSubService;
	
	/**
	 * 该员工设置角色
	 * @param staffId
	 * @param roleId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateStaffRole", method = RequestMethod.POST)
	public Msg updateStaffRole(@RequestBody UpdateStaffRoleModel updateStaffRoleModel){
		if(updateStaffRoleModel != null){
			Staff staff = staffService.get(updateStaffRoleModel.getStaffId());
			if(staff != null){
				staff.setRoleId(updateStaffRoleModel.getRoleId());
				staffService.update(staff);
				return Msg.success("设置成功");
			}else{
				return Msg.error("员工不存在");
			}
		}else{
			return Msg.error("传递参数错误");
		}
		
	}
	
	/**
	 * 解除绑定
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "unbind/{id}", method = RequestMethod.GET)
	public Msg unbind(@PathVariable("id") Integer id) {
		Staff staff = staffService.get(id);
		if(staff != null){
			staff.setUnionId("");
			staffService.update(staff);
		}else{
			return Msg.error("没有此员工");
		}
		return Msg.success("解绑成功");
//		if (staff.getIcon() != null) {
//			return Msg.success().add("data", staff.getIcon());
//		} else {
//			return Msg.error("无头像信息");
//		}
	}
	
	/**
	 * 获取头像
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getIcon/{id}", method = RequestMethod.GET)
	public Msg getIcon(@PathVariable("id") Integer id) {
		Staff staff = staffService.get(id);
		if (staff.getIcon() != null) {
			return Msg.success().add("data", staff.getIcon());
		} else {
			return Msg.error("无头像信息");
		}
	}

	/**
	 * 上传，保存头像
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "saveIcon", method = RequestMethod.POST)
	public Msg saveIcon(@RequestBody StaffIcon staffIcon) {
		if (staffIcon != null) {
			Staff staff = staffService.get(staffIcon.getId());
			staff.setIcon(staffIcon.getIcon());
			staffService.update(staff);
			return Msg.success().add("data", staff);
		} else {
			return Msg.error();
		}
	}

	/**
	 * 计算单个职工的总分，主要用于新增员工时计算
	 * 
	 * @param staffNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "calculateStaffValueByStaffNo/{staffNo}", method = RequestMethod.POST)
	public Msg calculateStaffValueByStaffNo(@PathVariable("staffNo") String staffNo) {
		System.out.println(staffNo);
		StaffValue staffValue = staffService.getStaffValueByStaffNo(staffNo);
		if (staffValue != null) {
			int titleValue = 0;
			if (staffValue.getStaffTitleValue() != null) {
				titleValue = staffValue.getStaffTitleValue();
			}
			int postValue = 0;
			if (staffValue.getStaffPostValue() != null) {
				postValue = staffValue.getStaffPostValue();
			}
			int spouseTitleValue = 0;
			if (staffValue.getSpouseTitleValue() != null) {
				spouseTitleValue = staffValue.getSpouseTitleValue();
			}
			int spousePostValue = 0;
			if (staffValue.getSpousePostValue() != null) {
				spousePostValue = staffValue.getSpousePostValue();
			}
			double otherValue = staffValue.getOtherValue();
			double timeValue = staffValue.getTimeValue();
			double totalValue = titleValue + postValue + spouseTitleValue + spousePostValue + otherValue + timeValue;

			// 更新计算的总分
			Staff staff = staffService.get(staffValue.getId());
			staff.setTotalVal(totalValue);
			staffService.update(staff);
			return Msg.success();
		} else {
			return Msg.error("无该编号的职工");
		}
	}

	/**
	 * 计算所有职工总分
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "calculateAllStaffValue", method = RequestMethod.POST)
	public Msg calculateAllStaffValue() {
		List<StaffValue> staffValues = staffService.getAllStaffValues();
		if (staffValues != null) {
			for (StaffValue staffValue : staffValues) {
				int titleValue = 0;
				if (staffValue.getStaffTitleValue() != null) {
					titleValue = staffValue.getStaffTitleValue();
				}
				int postValue = 0;
				if (staffValue.getStaffPostValue() != null) {
					postValue = staffValue.getStaffPostValue();
				}
				int spouseTitleValue = 0;
				if (staffValue.getSpouseTitleValue() != null) {
					spouseTitleValue = staffValue.getSpouseTitleValue();
				}
				int spousePostValue = 0;
				if (staffValue.getSpousePostValue() != null) {
					spousePostValue = staffValue.getSpousePostValue();
				}
				double otherValue = staffValue.getOtherValue();
				double timeValue = staffValue.getTimeValue();
				double totalValue = titleValue + postValue + spouseTitleValue + spousePostValue + otherValue
						+ timeValue;

				// 更新计算的总分
				Staff staff = staffService.get(staffValue.getId());
				staff.setTotalVal(totalValue);
				staffService.update(staff);
			}
			return Msg.success();
		} else {
			return Msg.error("无数据可处理");
		}
	}

	/**
	 * 根据id重置该员工密码
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "resetPassword/{id}", method = RequestMethod.PUT)
	public Msg resetPassword(@PathVariable Integer id) {
		Staff staff = staffService.get(id);
		if (staff != null) {
			staff.setStaffPassword("123456");
			staffService.resetPassword(staff);
			return Msg.success("重置密码为123456");
		} else {
			return Msg.error("该员工不存在");
		}

	}

	/**
	 * 修改密码
	 * 
	 * @param request
	 * @param newPsw
	 * @param oldPsw
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updatePassword", method = RequestMethod.PUT)
	public Msg updatePassword(HttpServletRequest request, @FormParam("newPsw") String newPsw,
			@FormParam("oldPsw") String oldPsw) {
		String userId = getUserId(request);
		Integer staffId = Integer.parseInt(userId);
		Staff staff = staffService.get(staffId);
		if (staff == null) {
			return Msg.error("该员工不存在");
		}
		if (!oldPsw.equals(staff.getStaffPassword())) {
			return Msg.error("密码错误");
		}
		staff.setStaffPassword(newPsw);
		staffService.resetPassword(staff);
		return Msg.success("修改成功");
	}

	/**
	 * 根据id获取单个员工信息
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getByID/{id}", method = RequestMethod.GET)
	public Msg getByID(@PathVariable("id") Integer id) {
		StaffVw staffVw = staffVwService.getByID(id);

		if (staffVw != null) {
			return Msg.success().add("data", staffVw);
		} else {
			return Msg.error("无信息");
		}

	}

	/**
	 * 修改员工信息
	 * 
	 * @param staff
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "modify", method = RequestMethod.PUT)
	public Msg modifyStaff(@RequestBody @Valid Staff staff, BindingResult result) {
		System.out.println(staff.getCode() == null);

		// System.out.println(staff.getCode().equals(""));
		if (staff.getNo() != null) {
			if (staff.getNo().trim().equals("")) {
				return Msg.error("职工编号不能为空");
			}
		}

		if (staff.getName() != null) {
			if (staff.getName().trim().equals("")) {
				return Msg.error("职工姓名不能为空");
			}
		}

		if (staff.getCode() != null) {
			if (staff.getCode().trim().equals("")) {
				return Msg.error("职工身份证号不能为空");
			}
		}

		if (staff.getTel() != null) {
			if (staff.getTel().trim().equals("")) {
				return Msg.error("职工电话号码不能为空");
			}
		}

		if (result.getErrorCount() > 0) {
			// 根据JSR303验证获取错误信息，并返回前端
			String message = result.getFieldError().getDefaultMessage();
			return Msg.error(message);
		}

		Staff staffBeforeUpdate = null;

		// 通过ID获取该职工
		if (staff.getId() != null) {
			staffBeforeUpdate = staffService.get(staff.getId());
		}

		//当职称或职务改变时，记之为晋升，并将晋升前的数据保存在hs_beforepromotedata表中
		if(staffBeforeUpdate != null){
			//记晋升
			if(staffBeforeUpdate.getTitle() != staff.getTitle() || staffBeforeUpdate.getPost() != staff.getPost()){
				staff.setPromoteFlag(true);
			}
			//保存晋升前的数据
				//1.查询补贴视图view_hs_monetarysub
//			MonetarySubVw monetarySubVw = monetarySubVwService.getByStaffId(staff.getId());
				//修改： 1. 查询view_hs_staffformonsub
			StaffForMonSub staffForMonSub = staffForMonSubService.getByStaffId(staff.getId());
				//2.保存
			BeforePromoteData beforePromoteData = new BeforePromoteData();
			beforePromoteData.setStaffId(staffForMonSub.getStaffId());
			beforePromoteData.setTitleId(staffForMonSub.getTitleId());
			beforePromoteData.setTitleName(staffForMonSub.getTitleName());
			beforePromoteData.setPostId(staffForMonSub.getPostId());
			beforePromoteData.setPostName(staffForMonSub.getPostName());
			if(staffForMonSub.getMaxEnjoyArea() != null){
				beforePromoteData.setMaxEnjoyArea(staffForMonSub.getMaxEnjoyArea().floatValue());
			}else{
				beforePromoteData.setMaxEnjoyArea((float) 0.0);
			}
			
			//判断该职工的记录是否存在（是否之前晋升过），若存在，则更新记录；若不存在，则插入记录
			BeforePromoteData example = beforePromoteDataService.selectByStaffId(beforePromoteData.getStaffId());
			if(example != null){
				beforePromoteData.setId(example.getId());
				beforePromoteDataService.update(beforePromoteData);
			}else{
				beforePromoteDataService.add(beforePromoteData);
			}
			
		}
		
		// staff = staffService.get(staff.getId());
		// System.out.println(staff.getPost());
		// if (staff.getNo() == null) {
		// return Msg.error("职工编号不能为空");
		// } else if (staff.getName() == null) {
		// return Msg.error("职工姓名不能为空");
		// } else if (staff.getSex() == null) {
		// return Msg.error("职工性别不能为空");
		// } else if (staff.getMarriageState() == null) {
		// return Msg.error("职工婚姻状况不能为空");
		// } else if (staff.getTitle() == null) {
		// return Msg.error("职工职称不能为空");
		// } else if (staff.getPost() == null) {
		// return Msg.error("职工职务不能为空");
		// } else if (staff.getDept() == null) {
		// return Msg.error("职工部门不能为空");
		// } else if (staff.getCode() == null) {
		// return Msg.error("职工身份证号不能为空");
		// } else {
		// staffService.update(staff);
		// return Msg.success("修改成功").add("data", staff);
		// }
		// if (result.getErrorCount() > 0) {
		// // 根据JSR303验证获取错误信息，并返回前端
		// String message = result.getFieldError().getDefaultMessage();
		// return Msg.error(message).add("data", staff);
		// }else{
		// staffService.update(staff);
		// return Msg.success("修改成功").add("data", staff);
		// }
		staffService.update(staff);
		return Msg.success("修改成功").add("data", staff);
	}

	/**
	 * 新增一个员工
	 * 
	 * @param staff
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Msg addStaff(@RequestBody @Valid Staff staff, BindingResult result) {
		// System.out.println(result.getErrorCount());
		// System.out.println(result.getFieldError().getDefaultMessage());

		// //获取所有错误信息
		// for (FieldError error : result.getFieldErrors()){
		// System.out.println(error.getDefaultMessage());
		// }
		// 验证员工no是否重复
		List<Staff> staffs = staffService.getByStaffNo(staff.getNo());
		if (staffs.size() == 0) {
			if (result.getErrorCount() > 0) {
				// 根据JSR303验证获取错误信息，并返回前端
				String message = result.getFieldError().getDefaultMessage();
				return Msg.error(message).add("data", staff);
			}

			// if (staff.getName() != null && staff.getCode() != null) {
			// staffService.add(staff);
			// return Msg.success("添加成功").add("data", staff);
			// } else {
			// return Msg.error("必要信息不完整").add("data", staff);
			// }
			if (staff.getNo() == null) {
				return Msg.error("职工编号不能为空");
			} else if (staff.getName() == null) {
				return Msg.error("职工姓名不能为空");
			} else if (staff.getSex() == null) {
				return Msg.error("职工性别不能为空");
			} else if (staff.getMarriageState() == null) {
				return Msg.error("职工婚姻状况不能为空");
			} else if (staff.getTitle() == null) {
				return Msg.error("职工职称不能为空");
			} else if (staff.getPost() == null) {
				return Msg.error("职工职务不能为空");
			} else if (staff.getDept() == null) {
				return Msg.error("职工部门不能为空");
			} else if (staff.getCode() == null) {
				return Msg.error("职工身份证号不能为空");
			} else {
				staffService.add(staff);
				return Msg.success("添加成功").add("data", staff);
			}
		} else {
			return Msg.error("员工编号No重复").add("data", staff);
		}
	}

	/**
	 * 根据id删除一个员工
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public Msg deleteStaff(@PathVariable("id") Integer id) {
		Staff staff = staffService.get(id);

		if (staff != null) {
			staffService.delete(id);
			return Msg.success("删除成功").add("data", staff);
		} else {
			return Msg.error("该员工不存在");
		}

	}

	/**
	 * 获取所有部门
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getDepts")
	public Msg getDepts() {
		List<StaffParameter> depts = staffParameterSerivce.getAllByParamTypeId(5);
		List<StaffParameterModel> deptModels = new ArrayList<StaffParameterModel>();
		for (StaffParameter dept : depts) {

			List<Staff> staffers = staffService.getByStaffDept(dept.getStaffParamId());
			List<StaffModel> staffModels = new ArrayList<StaffModel>();
			for (Staff staff : staffers) {
				StaffModel staffModel = new StaffModel();
				staffModel.setId(staff.getId());
				staffModel.setNo(staff.getNo());
				staffModel.setName(staff.getName());
				staffModels.add(staffModel);
			}

			StaffParameterModel deptModel = new StaffParameterModel();
			deptModel.setStaffParamId(dept.getStaffParamId());
			deptModel.setStaffParamName(dept.getStaffParamName());
			deptModel.setStaffModels(staffModels);
			deptModels.add(deptModel);
		}
		return Msg.success().add("deptData", deptModels);
	}

	/**
	 * 输入框模糊查询员工
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getStaffByInput", method = RequestMethod.GET)
	public Msg getStaffByInput(@RequestParam(value = "input") String input) {
		try {
			input = new String(input.getBytes("iso8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// System.out.println(input);

		// 模糊查询到员工信息
		List<Staff> staffers = staffService.getStaffByInput(input);
		// 用于封装查询出来的员工所在部门ID
		Set<Integer> deptID = new HashSet<Integer>();
		for (Staff staff : staffers) {
			Integer id = staff.getDept();
			deptID.add(id);
		}
		// System.out.println(deptID);
		// 用于封装部门id、部门名称、部门人员
		List<StaffParameterModel> staffParameterModels = new ArrayList<StaffParameterModel>();

		for (Integer id : deptID) {
			StaffParameter staffParameter = staffParameterSerivce.get(id);
			StaffParameterModel staffParameterModel = new StaffParameterModel();
			staffParameterModel.setStaffParamId(staffParameter.getStaffParamId());
			staffParameterModel.setStaffParamName(staffParameter.getStaffParamName());

			// 用于封装需要返回的人员信息
			List<StaffModel> staffModels = new ArrayList<StaffModel>();

			for (Staff staff : staffers) {
				if (staff.getDept() == id) {
					StaffModel staffModel = new StaffModel();
					staffModel.setId(staff.getId());
					staffModel.setNo(staff.getNo());
					staffModel.setName(staff.getName());
					staffModels.add(staffModel);
				}
			}
			staffParameterModel.setStaffModels(staffModels);

			staffParameterModels.add(staffParameterModel);
		}

		return Msg.success().add("data", staffParameterModels);
	}

	/**
	 * 根据部门ID获取所有员工
	 * 
	 * @param staffParamId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "get/{staffParamId}", method = RequestMethod.GET)
	public Msg getStaff(@PathVariable("staffParamId") Integer staffParamId,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {

		// 根据staffParamId获取StaffParameter对象
		StaffParameter staffParameter = staffParameterSerivce.get(staffParamId);
		// 获取deptName对象
		String deptName = staffParameter.getStaffParamName();
		PageHelper.startPage(page, size);
		List<StaffVw> staffs = staffVwService.getAllByStaffDept(deptName);
		PageInfo pageInfo = new PageInfo(staffs);
		if (staffs != null) {
			return Msg.success().add("data", pageInfo);
		} else {
			return Msg.error("无记录");
		}

	}

}
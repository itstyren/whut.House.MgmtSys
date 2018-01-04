package com.computerdesign.whutHouseMgmt.controller.staffmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.paramclass.ParamClass;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.Staff;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffModel;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffVw;
import com.computerdesign.whutHouseMgmt.bean.staffparam.StaffParameter;
import com.computerdesign.whutHouseMgmt.bean.staffparam.StaffParameterModel;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.StaffService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.StaffVwService;
import com.computerdesign.whutHouseMgmt.service.staffparam.StaffParameterService;

@RequestMapping("/staff/")
@Controller
public class StaffController {

	@Autowired
	private StaffParameterService staffParameterSerivce;

	@Autowired
	private StaffVwService staffVwService;

	@Autowired
	private StaffService staffService;

	@ResponseBody
	@RequestMapping(value = "modify", method = RequestMethod.PUT)
	public Msg modifyStaff(@RequestBody @Valid Staff staff) {
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
				//根据JSR303验证获取错误信息，并返回前端
				String message = result.getFieldError().getDefaultMessage();
				return Msg.error(message).add("data", staff);
			}

			if (staff.getName() != null && staff.getCode() != null) {
				staffService.add(staff);
				return Msg.success("添加成功").add("data", staff);
			} else {
				return Msg.error("必要信息不完整").add("data", staff);
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
			for (Staff staff : staffers){
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
	 * 根据部门ID获取所有员工
	 * 
	 * @param staffParamId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("get/{staffParamId}")
	public Msg getStaff(@PathVariable("staffParamId") Integer staffParamId) {
		// 根据staffParamId获取StaffParameter对象
		StaffParameter staffParameter = staffParameterSerivce.get(staffParamId);
		// 获取deptName对象
		String deptName = staffParameter.getStaffParamName();
		List<StaffVw> staffs = staffVwService.getAllByStaffDept(deptName);
		if (staffs != null) {
			return Msg.success().add("data", staffs);
		} else {
			return Msg.error("无记录");
		}

	}

}

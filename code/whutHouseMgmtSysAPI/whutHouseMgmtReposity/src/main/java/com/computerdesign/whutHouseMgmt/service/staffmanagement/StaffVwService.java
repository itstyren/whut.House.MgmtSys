package com.computerdesign.whutHouseMgmt.service.staffmanagement;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffVwExample.Criteria;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffSelectModel;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffVw;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffVwExample;
import com.computerdesign.whutHouseMgmt.dao.staffmanagement.StaffVwMapper;
import com.computerdesign.whutHouseMgmt.service.base.BaseService;

@Service
public class StaffVwService implements BaseService<StaffVw> {

	@Autowired
	private StaffVwMapper staffVwMapper;
	
	/**
	 * 根据职工号或姓名查找
	 * @param conditionValue
	 * @return
	 */
	public List<StaffVw> getByNoAndName(String conditionValue){
		StaffVwExample example = new StaffVwExample();
		Criteria criteria = example.createCriteria();
		try {
			int test = Integer.parseInt(conditionValue);
			criteria.andNoEqualTo(conditionValue);
//			System.out.println("aaa");
		} catch (NumberFormatException e) {
//			System.out.println("ca:" + conditionValue);
			criteria.andNameEqualTo(conditionValue);
//			criteria.andNameLike(conditionValue);
//			System.out.println("bbb");
		}
		return staffVwMapper.selectByExample(example);
	}
	
	/**
	 * 多条件查询员工
	 * @param staffSelectModel
	 * @return
	 */
	public List<StaffVw> getByMultiCondition(StaffSelectModel staffSelectModel){
		StaffVwExample example = new StaffVwExample();
		Criteria criteria = example.createCriteria();
		if (staffSelectModel.getDept() != null) {
			criteria.andDeptNameEqualTo(staffSelectModel.getDept());
		}

		if (staffSelectModel.getPost() != null) {
			criteria.andPostNameEqualTo(staffSelectModel.getPost());
		}

		if (staffSelectModel.getTitle() != null) {
			criteria.andTitleNameEqualTo(staffSelectModel.getTitle());
		}

		if (staffSelectModel.getType() != null) {
			criteria.andTypeNameEqualTo(staffSelectModel.getType());
		}

		if (staffSelectModel.getStatus() != null) {
			criteria.andStatusNameEqualTo(staffSelectModel.getStatus());
		}

		if (staffSelectModel.getMarriageState() != null) {
			criteria.andMarriageStateEqualTo(staffSelectModel.getMarriageState());
		}

		if (staffSelectModel.getJoinTime() != null) {
			Date startTime = staffSelectModel.getJoinTime().getStartTime();
			Date endTime = staffSelectModel.getJoinTime().getEndTime();
			criteria.andJoinTimeBetween(startTime, endTime);
		}

		if (staffSelectModel.getSex() != null) {
			criteria.andSexEqualTo(staffSelectModel.getSex());
		}
		return staffVwMapper.selectByExample(example);
	}
	
	/**
	 * R新增
	 * 根据姓名获取全部的员工信息，获取一个数组
	 * @param StaffName
	 * @return
	 */
	public List<StaffVw> getByStaffName(String StaffName) {
		StaffVwExample staffVwExample = new StaffVwExample();
		Criteria criteria = staffVwExample.createCriteria();
		criteria.andNameEqualTo(StaffName);
		return staffVwMapper.selectByExample(staffVwExample);
	}
	
	/**
	 * 根据id获取单个员工信息
	 * @param id
	 * @return
	 */
	public StaffVw getByID(Integer id){
		StaffVwExample staffVwExample = new StaffVwExample();
		Criteria criteria = staffVwExample.createCriteria();
		criteria.andIdEqualTo(id);
		return staffVwMapper.selectByExample(staffVwExample).get(0);
	}
	
	/**
	 * 根据deptName获取对应的所有员工
	 * @param deptName
	 * @return
	 */
	public List<StaffVw> getAllByStaffDept(String deptName){
		StaffVwExample staffVwExample = new StaffVwExample();
		Criteria criteria = staffVwExample.createCriteria();
		criteria.andDeptNameEqualTo(deptName);
		return staffVwMapper.selectByExample(staffVwExample);
	}
	
	@Override
	public List<StaffVw> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		
	}

	@Override
	public void add(StaffVw entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(StaffVw entities) {
		// TODO Auto-generated method stub
		
	}

}

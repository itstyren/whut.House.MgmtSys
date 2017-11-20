package com.computerdesign.whutHouseMgmt.service.staffmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffVwExample.Criteria;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffVw;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffVwExample;
import com.computerdesign.whutHouseMgmt.dao.staffmanagement.StaffVwMapper;
import com.computerdesign.whutHouseMgmt.service.base.BaseService;

@Service
public class StaffVwService implements BaseService<StaffVw> {

	@Autowired
	private StaffVwMapper staffVwMapper;
	
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

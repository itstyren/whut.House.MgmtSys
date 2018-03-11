package com.computerdesign.whutHouseMgmt.service.staffmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.staffmanagement.Staff;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffExample;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.staffmanagement.StaffMapper;
import com.computerdesign.whutHouseMgmt.service.base.BaseService;

@Service
public class StaffService implements BaseService<Staff> {

	@Autowired
	private StaffMapper staffMapper;
	
	/**
	 * 根据id重置该员工密码
	 * @param id
	 */
	public void resetPassword(Staff staff){
//		staffMapper.updateByPrimaryKey(staff);
		staffMapper.updateByPrimaryKeySelective(staff);
	}
	
	/**
	 * 根据id获取一个staff对象
	 * @param id
	 * @return
	 */
	public Staff get(Integer id){
		return staffMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 根据员工编号获取员工，用于验证员工编号是否重复
	 * @param no
	 * @return
	 */
	public List<Staff> getByStaffNo(String no){
		StaffExample staffExample = new StaffExample();
		Criteria criteria = staffExample.createCriteria();
		criteria.andNoEqualTo(no);
		return staffMapper.selectByExample(staffExample);
		
	}
	
	/**
	 * 根据员工部门ID获取员工
	 * @param no
	 * @return
	 */
	public List<Staff> getByStaffDept(Integer dept){
		StaffExample staffExample = new StaffExample();
		Criteria criteria = staffExample.createCriteria();
		criteria.andDeptEqualTo(dept);
		return staffMapper.selectByExample(staffExample);
		
	}
	
	/**
	 * 输入框模糊查询员工
	 * @param input
	 * @return
	 */
	public List<Staff> getStaffByInput(String input){
		StaffExample staffExample = new StaffExample();
		Criteria criteria = staffExample.createCriteria();
		criteria.andNameLike("%" + input + "%");
		return staffMapper.selectByExample(staffExample);
		
	}
	
	/**
	 * 获取员工的roleId
	 * @param staffId
	 * @return
	 */
	public Integer getRoleByStaffId(Integer staffId) {
		return staffMapper.selectByPrimaryKey(staffId).getRoleId();
	}
	
	@Override
	public List<Staff> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		staffMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void add(Staff entities) {
		staffMapper.insertSelective(entities);
		
	}

	@Override
	public void update(Staff entities) {
		staffMapper.updateByPrimaryKeySelective(entities);		
	}

}

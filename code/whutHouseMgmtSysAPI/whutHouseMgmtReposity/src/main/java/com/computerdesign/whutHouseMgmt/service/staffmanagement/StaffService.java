package com.computerdesign.whutHouseMgmt.service.staffmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.staffmanagement.Staff;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffExample;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffExample.Criteria;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffValue;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffValueExample;
import com.computerdesign.whutHouseMgmt.dao.staffmanagement.StaffMapper;
import com.computerdesign.whutHouseMgmt.dao.staffmanagement.StaffValueMapper;
import com.computerdesign.whutHouseMgmt.service.base.BaseService;

@Service
public class StaffService implements BaseService<Staff> {

	@Autowired
	private StaffMapper staffMapper;
	
	@Autowired
	private StaffValueMapper staffValueMapper;
	
	/**
	 * 根据职工编号获取职工ID
	 * @param staffNo
	 * @return
	 */
	public Integer getStaffIdByStaffNo(String staffNo){
		StaffExample example = new StaffExample();
		Criteria criteria = example.createCriteria();
		criteria.andNoEqualTo(staffNo);
		return staffMapper.selectByExample(example).get(0).getId();
	}
	
	/**
	 * 根据职工编号和职工姓名获取职工ID，用于Resident数据导入
	 * @param staffNo
	 * @param staffName
	 * @return
	 */
	public Integer getStaffIdByStaffNoAndStaffName(String staffNo, String staffName){
		StaffExample example = new StaffExample();
		Criteria criteria = example.createCriteria();
		criteria.andNoEqualTo(staffNo);
		criteria.andNameEqualTo(staffName);
		if(staffMapper.selectByExample(example).get(0) != null){
			return staffMapper.selectByExample(example).get(0).getId();
		}else{
			return null;
		}
	}
	
	/**
	 * 根据staffId获取单个StaffValue记录
	 * @param staffId
	 * @return
	 */
	public StaffValue getStaffValueByStaffId(Integer staffId){
		StaffValueExample example = new StaffValueExample();
		com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffValueExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(staffId);
		if(staffValueMapper.selectByExample(example) != null){
			return staffValueMapper.selectByExample(example).get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 根据staffNo获取单个StaffValue记录
	 * @param staffNo
	 * @return
	 */
	public StaffValue getStaffValueByStaffNo(String staffNo){
		StaffValueExample example = new StaffValueExample();
		com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffValueExample.Criteria criteria = example.createCriteria();
		criteria.andNoEqualTo(staffNo);
		if(staffValueMapper.selectByExample(example) != null){
			return staffValueMapper.selectByExample(example).get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 获取所有职工的分数记录
	 * @return
	 */
	public List<StaffValue> getAllStaffValues(){
		StaffValueExample example = new StaffValueExample();
		com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffValueExample.Criteria criteria = example.createCriteria();
		return staffValueMapper.selectByExample(example);
	}
	
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
	 * 根据员工id获取员工
	 * @param no
	 * @return
	 */
	public Staff getByStaffId(Integer id){
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
		//若部门ID传入为0，则查询所有
		if(dept != 0){			
			criteria.andDeptEqualTo(dept);
		}
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
		StaffExample example = new StaffExample();
		Criteria criteria = example.createCriteria();
		return staffMapper.selectByExample(example);
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

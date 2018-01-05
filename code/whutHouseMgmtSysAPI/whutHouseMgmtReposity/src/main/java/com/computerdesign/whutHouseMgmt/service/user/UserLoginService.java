package com.computerdesign.whutHouseMgmt.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.staffmanagement.Staff;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffExample;
import com.computerdesign.whutHouseMgmt.bean.user.User;
import com.computerdesign.whutHouseMgmt.bean.user.UserExample;
import com.computerdesign.whutHouseMgmt.bean.user.UserExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.staffmanagement.StaffMapper;
import com.computerdesign.whutHouseMgmt.dao.user.UserMapper;

@Service
public class UserLoginService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired StaffMapper staffMapper;
	
	/**
	 * 管理员登陆
	 * @param no
	 * @param password
	 * @return
	 */
	public List<User> getUser(String no,String password) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNoEqualTo(no);
		criteria.andPasswordEqualTo(password);
		return userMapper.selectByExample(example);
	}


	/**
	 * 员工登陆
	 * @param no
	 * @param password
	 * @return
	 */
	public List<Staff>  getStaff(String no,String password) {
		StaffExample example = new StaffExample();
		com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffExample.Criteria criteria = example.createCriteria();
		criteria.andNoEqualTo(no);
		criteria.andStaffPasswordEqualTo(password);
		return staffMapper.selectByExample(example);
	}
}

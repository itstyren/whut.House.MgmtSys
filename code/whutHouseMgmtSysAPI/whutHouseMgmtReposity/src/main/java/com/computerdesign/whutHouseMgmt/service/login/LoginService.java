package com.computerdesign.whutHouseMgmt.service.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.staffmanagement.Staff;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffExample;
import com.computerdesign.whutHouseMgmt.bean.user.User;
import com.computerdesign.whutHouseMgmt.bean.user.UserExample;
import com.computerdesign.whutHouseMgmt.bean.user.UserLoginReturn;
import com.computerdesign.whutHouseMgmt.bean.user.UserLoginReturnExample;
import com.computerdesign.whutHouseMgmt.bean.user.UserLoginReturnExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.staffmanagement.StaffMapper;
import com.computerdesign.whutHouseMgmt.dao.user.UserLoginReturnMapper;
import com.computerdesign.whutHouseMgmt.dao.user.UserMapper;

@Service
public class LoginService {

	@Autowired
	private UserLoginReturnMapper userLoginReturnMapper;
	
	/**
	 * 根据账号密码获取用户登陆信息
	 * @param no
	 * @param password
	 * @param roleId
	 * @return List<UserLoginReturn>
	 */
	public List<UserLoginReturn> getLogin(String no,String password,Long roleId) {
		UserLoginReturnExample example = new UserLoginReturnExample();
		Criteria criteria = example.createCriteria();
		criteria.andNoEqualTo(no);
		criteria.andPasswordEqualTo(password);
		criteria.andRoleIdEqualTo(roleId);
		return userLoginReturnMapper.selectByExample(example);
	}
}

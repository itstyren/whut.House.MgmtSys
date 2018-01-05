package com.computerdesign.whutHouseMgmt.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.user.UserLoginReturn;
import com.computerdesign.whutHouseMgmt.bean.user.UserLoginReturnExample;
import com.computerdesign.whutHouseMgmt.bean.user.UserLoginReturnExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.user.UserLoginReturnMapper;

@Service
public class UserReturnService {

	@Autowired
	private UserLoginReturnMapper userLoginReturnMapper;
	
	public UserLoginReturn getByNo(String no) {
		UserLoginReturnExample example = new UserLoginReturnExample();
		Criteria criteria = example.createCriteria();
		criteria.andNoEqualTo(no);
		return userLoginReturnMapper.selectByExample(example).get(0);
	}
}

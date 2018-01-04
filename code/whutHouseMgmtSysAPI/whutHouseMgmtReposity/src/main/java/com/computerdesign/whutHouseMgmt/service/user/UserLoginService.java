package com.computerdesign.whutHouseMgmt.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.user.User;
import com.computerdesign.whutHouseMgmt.bean.user.UserExample;
import com.computerdesign.whutHouseMgmt.bean.user.UserExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.user.UserMapper;

@Service
public class UserLoginService {

	@Autowired
	private UserMapper userMapper;
	
	public List<User> getUser(Integer no,String password) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNoEqualTo(no);
		criteria.andPasswordEqualTo(password);
		return userMapper.selectByExample(example);
	}
}

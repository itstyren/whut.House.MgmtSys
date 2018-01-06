package com.computerdesign.whutHouseMgmt.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.user.User;
import com.computerdesign.whutHouseMgmt.bean.user.UserExample;
import com.computerdesign.whutHouseMgmt.bean.user.UserExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.user.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	
	public List<User> getAll() {
		return userMapper.selectByExample(null);
	}
	
	public List<User> getUserByNo(String No) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNoEqualTo(No);
		return userMapper.selectByExample(example);
	}
	
	public void delete(Integer Id) {
		userMapper.deleteByPrimaryKey(Id);
	}
	
	public void add(User user) {
		userMapper.insertSelective(user);
	}
	
	public void update(User user) {
		userMapper.updateByPrimaryKeySelective(user);
	}
}

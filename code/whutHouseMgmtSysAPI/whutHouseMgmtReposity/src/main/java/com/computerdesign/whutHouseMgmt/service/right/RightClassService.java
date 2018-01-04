package com.computerdesign.whutHouseMgmt.service.right;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.right.RightClass;
import com.computerdesign.whutHouseMgmt.dao.right.RightClassMapper;

@Service
public class RightClassService {

	@Autowired
	private RightClassMapper rightClassMapper;
	
	public RightClass get(Integer id) {
		return rightClassMapper.selectByPrimaryKey(id);
	}
	/**
	 * 获取全部的RightClass
	 * @return
	 */
	public List<RightClass> get() {
		return rightClassMapper.selectByExample(null);
	}
}

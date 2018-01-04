package com.computerdesign.whutHouseMgmt.service.right;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.right.Right;
import com.computerdesign.whutHouseMgmt.bean.right.RightExample;
import com.computerdesign.whutHouseMgmt.bean.right.RightExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.right.RightMapper;

@Service
public class RightService {

	@Autowired
	private RightMapper rightMapper;
	
	/**
	 * 获取一个right
	 * @param id
	 * @return
	 */
	public Right get(Integer id) {
		return rightMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 根据classId获取rights
	 * @param classId
	 * @return
	 */
	public List<Right> getRightsByClassId(Integer classId) {
		RightExample rightExample = new RightExample();
		Criteria criteria = rightExample.createCriteria();
		criteria.andClassIdEqualTo(classId);
		return rightMapper.selectByExample(rightExample);
	}
}

package com.computerdesign.whutHouseMgmt.service.fix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.fix.Fix;
import com.computerdesign.whutHouseMgmt.bean.fix.FixExample;
import com.computerdesign.whutHouseMgmt.bean.fix.FixExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.fix.FixMapper;

@Service
public class FixService {

	@Autowired
	private FixMapper fixMapper;
	
	/**
	 * 增加一个fix
	 * @param fix
	 */
	public void add(Fix fix) {
		fixMapper.insertSelective(fix);
	}
	
	/**
	 * 通过PrimaryKey修改
	 * @param fix
	 */
	public void update(Fix fix){
		fixMapper.updateByPrimaryKeySelective(fix);
	}
}

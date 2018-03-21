package com.computerdesign.whutHouseMgmt.service.fixratings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.fixratings.FixRatings;
import com.computerdesign.whutHouseMgmt.bean.fixratings.FixRatingsExample;
import com.computerdesign.whutHouseMgmt.bean.fixratings.FixRatingsExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.fixratings.FixRatingsMapper;

@Service
public class FixRatingsService {

	@Autowired
	private FixRatingsMapper fixRatingsMapper;
	
	/**
	 * 增加评分记录
	 * @param fixRatings
	 */
	public void insert(FixRatings fixRatings){
		fixRatingsMapper.insertSelective(fixRatings);
	}
	
	/**
	 * 根据维修ID获取评分记录
	 * @param fixId
	 * @return
	 */
	public FixRatings getByFixId(Integer fixId){
		FixRatingsExample example = new FixRatingsExample();
		Criteria criteria = example.createCriteria();
		criteria.andFixIdEqualTo(fixId);
		if(!fixRatingsMapper.selectByExample(example).isEmpty()){
			return fixRatingsMapper.selectByExample(example).get(0);
		}else{
			return null;
		}
	}
	
}

package com.computerdesign.whutHouseMgmt.service.housesub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.housesub.MonetarySubVw;
import com.computerdesign.whutHouseMgmt.bean.housesub.MonetarySubVwExample;
import com.computerdesign.whutHouseMgmt.bean.housesub.MonetarySubVwExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.housesub.MonetarySubVwMapper;

@Service
public class MonetarySubVwService {
	
	@Autowired
	private MonetarySubVwMapper monetarySubVwMapper;
	
	/**
	 * 通过staffId获取一条住房化补贴记录，包括该员工的住房面积，用于判断是否达标
	 * @param staffId
	 * @return
	 */
	public MonetarySubVw getByStaffId(Integer staffId){
		MonetarySubVwExample example = new MonetarySubVwExample();
		Criteria criteria = example.createCriteria();
		criteria.andStaffIdEqualTo(staffId);
		if(monetarySubVwMapper.selectByExample(example).size() > 0){
			return monetarySubVwMapper.selectByExample(example).get(0);
		}else{
			return null;
		}
		
	}
	
}

package com.computerdesign.whutHouseMgmt.service.internetselecthouse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.SelfHelpSelectHouse;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.SelfHelpSelectHouseExample;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.SelfHelpSelectHouseExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.internetselecthouse.SelfHelpSelectHouseMapper;

@Service
public class SelfHelpSelectHouseService {

	@Autowired
	private SelfHelpSelectHouseMapper selfHelpSelectHouseMapper;
	
	
	/**
	 * 显示所有未选房职工
	 * @return
	 */
	public List<SelfHelpSelectHouse> getAllCanselectHouse(){
		SelfHelpSelectHouseExample example = new SelfHelpSelectHouseExample();
		Criteria criteria = example.createCriteria();
		criteria.andRecordStatusEqualTo("canselect");
		return selfHelpSelectHouseMapper.selectByExample(example);
	}
	
}

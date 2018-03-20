package com.computerdesign.whutHouseMgmt.service.staffhomepage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.staffhomepage.LastFixRecord;
import com.computerdesign.whutHouseMgmt.bean.staffhomepage.LastFixRecordExample;
import com.computerdesign.whutHouseMgmt.bean.staffhomepage.LastFixRecordExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.staffhomepage.LastFixRecordMapper;

@Service
public class LastFixRecordService {

	@Autowired
	private LastFixRecordMapper lastFixRecordMapper;
	
	/**
	 * 根据staffFix字段获取记录数
	 * @param staffFix
	 * @return
	 */
	public long getRecordNum(String staffFix){
		LastFixRecordExample example = new LastFixRecordExample();
		Criteria criteria = example.createCriteria();
		criteria.andStaffFixEqualTo(staffFix);
		return	lastFixRecordMapper.countByExample(example);
	}
	
	/**
	 * 根据staffFix字段获取上一次维修状态
	 * @param staffFix
	 * @return
	 */
	public LastFixRecord getLastFixRecordByStaffAndFix(String staffFix){
		LastFixRecordExample example = new LastFixRecordExample();
		Criteria criteria = example.createCriteria();
		criteria.andStaffFixEqualTo(staffFix);
		if(lastFixRecordMapper.countByExample(example) > 0){
			return	lastFixRecordMapper.selectByExample(example).get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 增添一条数据
	 * @param lastFixRecord
	 */
	public void add (LastFixRecord lastFixRecord){
		lastFixRecordMapper.insert(lastFixRecord);
	}
	
	
	public void update(LastFixRecord lastFixRecord){
		lastFixRecordMapper.updateByPrimaryKey(lastFixRecord);
	}
}

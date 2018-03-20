package com.computerdesign.whutHouseMgmt.service.staffhomepage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.staffhomepage.LastHireRecord;
import com.computerdesign.whutHouseMgmt.bean.staffhomepage.LastHireRecordExample;
import com.computerdesign.whutHouseMgmt.bean.staffhomepage.LastHireRecordExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.staffhomepage.LastHireRecordMapper;


@Service
public class LastHireRecordService {

	@Autowired
	private LastHireRecordMapper lastHireRecordMapper;
	
	/**
	 * 根据staffHire字段获取记录数
	 * @param staffHire
	 * @return
	 */
	public long getRecordNum(String staffHire){
		LastHireRecordExample example = new LastHireRecordExample();
		Criteria criteria = example.createCriteria();
		criteria.andStaffHireEqualTo(staffHire);
		return	lastHireRecordMapper.countByExample(example);
	}
	
	/**
	 * 根据staffHire字段获取上一次维修状态
	 * @param staffHire
	 * @return
	 */
	public LastHireRecord getLastHireRecordByStaffAndHire(String staffHire){
		LastHireRecordExample example = new LastHireRecordExample();
		Criteria criteria = example.createCriteria();
		criteria.andStaffHireEqualTo(staffHire);
		if(lastHireRecordMapper.countByExample(example) > 0){
			return	lastHireRecordMapper.selectByExample(example).get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 增添一条数据
	 * @param lastHireRecord
	 */
	public void add (LastHireRecord lastHireRecord){
		lastHireRecordMapper.insert(lastHireRecord);
	}
	
	
	public void update(LastHireRecord lastHireRecord){
		lastHireRecordMapper.updateByPrimaryKey(lastHireRecord);
	}
}

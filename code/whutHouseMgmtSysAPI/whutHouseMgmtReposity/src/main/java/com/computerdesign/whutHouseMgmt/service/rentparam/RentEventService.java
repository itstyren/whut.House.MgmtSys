package com.computerdesign.whutHouseMgmt.service.rentparam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.rentparam.RentEvent;
import com.computerdesign.whutHouseMgmt.bean.rentparam.RentEventExample;
import com.computerdesign.whutHouseMgmt.bean.rentparam.RentEventExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.rentparam.RentEventMapper;
import com.computerdesign.whutHouseMgmt.service.base.BaseService;

@Service
public class RentEventService implements BaseService<RentEvent>{

	@Autowired
	private RentEventMapper rentEventMapper;
	
	public RentEvent get(Integer rentEventId) {
		return rentEventMapper.selectByPrimaryKey(rentEventId);
	}
	
	public RentEvent getNowRule(){
		RentEventExample example = new RentEventExample();
		Criteria criteria = example.createCriteria();
		criteria.andRentIsOpenSelEqualTo(true);
		criteria.andIsDeleteEqualTo(false);
		if(rentEventMapper.selectByExample(example).size() > 0){
			return rentEventMapper.selectByExample(example).get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 获取开放的选房规则数量，用于判断能否添加新的选房规则
	 * @return
	 */
	public long getOpenRuleCount(){
		RentEventExample example = new RentEventExample();
		Criteria criteria = example.createCriteria();
		criteria.andRentIsOpenSelEqualTo(true);
		criteria.andIsDeleteEqualTo(false);
		return rentEventMapper.countByExample(example);
	}
	
	public long getCount(){
		RentEventExample example = new RentEventExample();
		Criteria criteria = example.createCriteria();
		return rentEventMapper.countByExample(example);
	}
	
	@Override
	public List<RentEvent> getAll() {
		RentEventExample rentEventExample = new RentEventExample();
		//根据RentEventId排序
		rentEventExample.setOrderByClause("RentEventId DESC");
		Criteria criteria = rentEventExample.createCriteria();
		criteria.andIsDeleteEqualTo(false);
		return rentEventMapper.selectByExample(rentEventExample);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(RentEvent entities) {
		rentEventMapper.insertSelective(entities);
	}

	@Override
	public void update(RentEvent entities) {
		rentEventMapper.updateByPrimaryKey(entities);
	}

	
	
}

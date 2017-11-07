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
	
	@Override
	public List<RentEvent> getAll() {
		RentEventExample rentEventExample = new RentEventExample();
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

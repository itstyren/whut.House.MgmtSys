package com.computerdesign.whutHouseMgmt.service.rentparam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.rentparam.RentParameter;
import com.computerdesign.whutHouseMgmt.bean.rentparam.RentParameterExample;
import com.computerdesign.whutHouseMgmt.bean.rentparam.RentParameterExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.rentparam.RentParameterMapper;
import com.computerdesign.whutHouseMgmt.service.base.BaseService;

@Service
public class RentParameterService implements BaseService<RentParameter> {

	@Autowired
	private RentParameterMapper rentParamMapper;
	
	public RentParameter get(Integer rentParamId){
		return rentParamMapper.selectByPrimaryKey(rentParamId);
	}
	
	public List<RentParameter> getAllByParamTypeId(Integer paramTypeId){
		RentParameterExample example = new RentParameterExample();
		Criteria criteria= example.createCriteria();
		criteria.andParamTypeIdEqualTo(paramTypeId);
		return rentParamMapper.selectByExample(example);
	}
	
	@Override
	public List<RentParameter> getAll() {
		return rentParamMapper.selectByExample(null);
	}

	@Override
	public void delete(Integer id) {
		rentParamMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void add(RentParameter entities) {
		rentParamMapper.insertSelective(entities);
	}

	@Override
	public void update(RentParameter entities) {
		rentParamMapper.updateByPrimaryKeySelective(entities);	
	}

}

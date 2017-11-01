package com.computerdesign.whutHouseMgmt.service.rentalparam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.rentalparam.RentalParameter;
import com.computerdesign.whutHouseMgmt.bean.rentalparam.RentalParameterExample;
import com.computerdesign.whutHouseMgmt.bean.rentalparam.RentalParameterExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.rentalparam.RentalParameterMapper;
import com.computerdesign.whutHouseMgmt.service.base.BaseService;

@Service
public class RentalParamService implements BaseService<RentalParameter>{

	@Autowired
	RentalParameterMapper rentalParameterMapper;
	
	public RentalParameter get(Integer rentalParamId){
		return rentalParameterMapper.selectByPrimaryKey(rentalParamId);
	}
	
	public List<RentalParameter> getAll(Integer paramTypeId) {
		RentalParameterExample example=new RentalParameterExample();
		Criteria criteria=example.createCriteria();
		criteria.andParamTypeIdEqualTo(paramTypeId);
		return rentalParameterMapper.selectByExample(example);
	}
	@Override
	public List<RentalParameter> getAll(){
		return rentalParameterMapper.selectByExample(null);
	}
	
	@Override
	public void add(RentalParameter rentalParameter){
		rentalParameterMapper.insertSelective(rentalParameter);		
	}
	
	@Override
	public void delete(Integer rentalParamId){
		rentalParameterMapper.deleteByPrimaryKey(rentalParamId);
	}
	
	@Override
	public void update(RentalParameter rentalParameter){
		rentalParameterMapper.updateByPrimaryKeySelective(rentalParameter);
	}
}

package com.computerdesign.whutHouseMgmt.service.houseparam;

import java.lang.reflect.Parameter;
import java.util.List;

import javax.ws.rs.DELETE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.houseparam.HouseParameter;
import com.computerdesign.whutHouseMgmt.bean.houseparam.HouseParameterExample;
import com.computerdesign.whutHouseMgmt.bean.houseparam.HouseParameterExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.houseparam.HouseParameterMapper;
import com.computerdesign.whutHouseMgmt.service.base.BaseService;

@Service
public class HouseParamService implements BaseService<HouseParameter>{

	@Autowired
	HouseParameterMapper houseParameterMapper;
	
	public List<Integer> getHouseParamId(Integer paramTypeId) {
		return houseParameterMapper.selectHouseParamId(paramTypeId);
	}
	
	/**
	 * 获取一个houseParameter对象
	 * @return
	 */
	public HouseParameter get(Integer houseParamId){
		return houseParameterMapper.selectByPrimaryKey(houseParamId);
	}
	
	@Override
	public List<HouseParameter> getAll(){
		List<HouseParameter> houseParameters=houseParameterMapper.selectByExample(null);
		return houseParameters;
	}
	
	/**
	 * 根据paramTypeId进行选择
	 * @param paramTypeId
	 * @return
	 */
	public List<HouseParameter> getAll(Integer paramTypeId){
		HouseParameterExample example=new HouseParameterExample();
		Criteria criteria=example.createCriteria();
		criteria.andParamTypeIdEqualTo(paramTypeId);
		List<HouseParameter> houseParameters=houseParameterMapper.selectByExample(example);
		return houseParameters;
	}
	
	@Override
	public void add(HouseParameter houseParameter){
		houseParameterMapper.insertSelective(houseParameter);
	}
	
	public void delete(HouseParameter houseParameter){
		houseParameterMapper.updateByPrimaryKeySelective(houseParameter);
	}
	
	@Override
	public void delete(Integer houseParamId){
		houseParameterMapper.deleteByPrimaryKey(houseParamId);
	}
	
	@Override
	public void update(HouseParameter houseParameter){
		houseParameterMapper.updateByPrimaryKeySelective(houseParameter);
	}
}

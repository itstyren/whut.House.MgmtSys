package com.computerdesign.whutHouseMgmt.service.fixparam;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.ws.rs.DELETE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.fixparam.FixParameter;
import com.computerdesign.whutHouseMgmt.bean.fixparam.FixParameterExample;
import com.computerdesign.whutHouseMgmt.bean.fixparam.FixParameterExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.fixparam.FixParameterMapper;
import com.computerdesign.whutHouseMgmt.service.base.BaseService;

@Service
public class FixParamService implements BaseService<FixParameter>{

	@Autowired
	FixParameterMapper fixParameterMapper;
	
	public FixParameter get(Integer fixParamId){
		return fixParameterMapper.selectByPrimaryKey(fixParamId);
	}
	
	public List<FixParameter> getAll(Integer paramTypeId) {
		FixParameterExample example=new FixParameterExample();
		Criteria criteria=example.createCriteria();
		criteria.andParamTypeIdEqualTo(paramTypeId);
		criteria.andIsDeleteEqualTo(false);
		List<FixParameter> fixParameters=fixParameterMapper.selectByExample(example);
		return fixParameters;
	}
	/**
	 * 获取该name的维修参数的数量
	 * @param fixParamName
	 * @return
	 */
	public long getCountByParamName(String fixParamName) {
		FixParameterExample example=new FixParameterExample();
		Criteria criteria=example.createCriteria();
		criteria.andFixParamNameEqualTo(fixParamName);
		criteria.andIsDeleteEqualTo(false);
		return fixParameterMapper.countByExample(example);
	}
	
	public List<FixParameter> getByParamName(String fixParamName) {
		FixParameterExample example=new FixParameterExample();
		Criteria criteria=example.createCriteria();
		criteria.andFixParamNameEqualTo(fixParamName);
		criteria.andIsDeleteEqualTo(false);
		return fixParameterMapper.selectByExample(example);
	}
	@Override
	public List<FixParameter> getAll(){
		List<FixParameter> fixParameters=fixParameterMapper.selectByExample(null);
		return fixParameters;
	}
	
	@Override
	public void add(FixParameter fixParameter){
		fixParameterMapper.insertSelective(fixParameter);
	}
	
	/**
	 * 更新操作，将IsDelete设置为1起到删除效果
	 * @param fixParameter
	 */
	public void delete(FixParameter fixParameter){
		fixParameterMapper.updateByPrimaryKeySelective(fixParameter);
	}
	
	@Override
	public void delete(Integer fixParamId){
		fixParameterMapper.deleteByPrimaryKey(fixParamId);
	}
	
	@Override
	public void update(FixParameter fixParameter){
		fixParameterMapper.updateByPrimaryKeySelective(fixParameter);
	}
}

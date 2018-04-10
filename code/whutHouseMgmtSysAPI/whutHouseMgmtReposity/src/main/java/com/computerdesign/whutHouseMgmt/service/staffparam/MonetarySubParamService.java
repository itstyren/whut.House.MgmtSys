package com.computerdesign.whutHouseMgmt.service.staffparam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.staffparam.MonetarySubParam;
import com.computerdesign.whutHouseMgmt.bean.staffparam.MonetarySubParamExample;
import com.computerdesign.whutHouseMgmt.bean.staffparam.MonetarySubParamExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.staffparam.MonetarySubParamMapper;

@Service
public class MonetarySubParamService {

	@Autowired
	private MonetarySubParamMapper monetarySubParamMapper;
	
	/**
	 * 获取当前使用的补贴比例参数
	 * @return
	 */
	public MonetarySubParam getIsUsing(){
		MonetarySubParamExample example = new MonetarySubParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsUsedEqualTo(true);
		if(monetarySubParamMapper.selectByExample(example).size() > 0){
			return monetarySubParamMapper.selectByExample(example).get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 获取所有补贴比例参数
	 * @return
	 */
	public List<MonetarySubParam> getAll(){
		MonetarySubParamExample example = new MonetarySubParamExample();
		Criteria criteria = example.createCriteria();
		return monetarySubParamMapper.selectByExample(example);
	}
	
	/**
	 * 添加补贴比例参数
	 * @param monetarySubParam
	 */
	public void add(MonetarySubParam monetarySubParam){
		monetarySubParamMapper.insertSelective(monetarySubParam);
	}
	
	/**
	 * 删除一条补贴比例参数记录
	 * @param id
	 */
	public void delete(Integer id){
		monetarySubParamMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 更新一条补贴比例参数记录
	 * @param monetarySubParam
	 */
	public void update(MonetarySubParam monetarySubParam){
		monetarySubParamMapper.updateByPrimaryKeySelective(monetarySubParam);
	}
	
}

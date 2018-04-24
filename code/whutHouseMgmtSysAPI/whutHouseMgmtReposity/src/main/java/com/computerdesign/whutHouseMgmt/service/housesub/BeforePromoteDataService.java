package com.computerdesign.whutHouseMgmt.service.housesub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.housesub.BeforePromoteData;
import com.computerdesign.whutHouseMgmt.bean.housesub.BeforePromoteDataExample;
import com.computerdesign.whutHouseMgmt.bean.housesub.BeforePromoteDataExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.housesub.BeforePromoteDataMapper;

/**
 * 晋升前的数据保存Service
 * @author Administrator
 *
 */
@Service
public class BeforePromoteDataService {

	@Autowired
	private BeforePromoteDataMapper beforePromoteDataMapper;
	
	/**
	 * 添加一条数据
	 * @param beforePromoteData
	 */
	public void add(BeforePromoteData beforePromoteData){
		beforePromoteDataMapper.insertSelective(beforePromoteData);
	}
	
	/**
	 * 更新一条数据
	 * @param beforePromoteData
	 */
	public void update(BeforePromoteData beforePromoteData){
		beforePromoteDataMapper.updateByPrimaryKey(beforePromoteData);
	}
	
	/**
	 * 根据staffId查询一条数据
	 * @param staffId
	 * @return
	 */
	public BeforePromoteData selectByStaffId(Integer staffId){
		BeforePromoteDataExample example = new BeforePromoteDataExample();
		Criteria criteria = example.createCriteria();
		criteria.andStaffIdEqualTo(staffId);
		if(beforePromoteDataMapper.selectByExample(example).size() > 0){
			return beforePromoteDataMapper.selectByExample(example).get(0);
		}else{
			return null;
		}
	}
	
}

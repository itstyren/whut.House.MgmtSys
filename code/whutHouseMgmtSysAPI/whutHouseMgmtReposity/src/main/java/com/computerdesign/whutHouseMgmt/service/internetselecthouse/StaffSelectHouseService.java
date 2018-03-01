package com.computerdesign.whutHouseMgmt.service.internetselecthouse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffSelectHouse;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffSelectHouseExample;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffSelectHouseExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.internetselecthouse.StaffSelectHouseMapper;

@Service
public class StaffSelectHouseService {

	@Autowired
	private StaffSelectHouseMapper staffSelectHouseMapper;
	
	public void update(StaffSelectHouse staffSelectHouse){
		staffSelectHouseMapper.updateByPrimaryKeySelective(staffSelectHouse);
	}
	
	/**
	 * 根据staffId获取一个StaffSelectHouse对象
	 * @param staffId
	 * @return
	 */
	public StaffSelectHouse getByStaffId(Integer staffId){
		StaffSelectHouseExample example = new StaffSelectHouseExample();
		Criteria criteria = example.createCriteria();
		criteria.andStaffIdEqualTo(staffId);
		return staffSelectHouseMapper.selectByExample(example).get(0);
	}
	
	/**
	 * 获取StaffSelectHouse数据库中所有可以选房的数据
	 * @return
	 */
	public List<StaffSelectHouse> getAll(){
		StaffSelectHouseExample example = new StaffSelectHouseExample();
		Criteria criteria = example.createCriteria();
		criteria.andRecordStatusEqualTo("canselect");
		return staffSelectHouseMapper.selectByExample(example);
	}
	
	public void insert(StaffSelectHouse staffSelectHouse){
		staffSelectHouseMapper.insertSelective(staffSelectHouse);
	}
	
}

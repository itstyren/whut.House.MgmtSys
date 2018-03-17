package com.computerdesign.whutHouseMgmt.service.hire;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffHouse;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffHouseExample;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffHouseExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.internetselecthouse.StaffHouseMapper;

@Service
public class StaffHouseService {

	@Autowired
	private StaffHouseMapper staffHouseMapper;
	
	/**
	 * 
	 * @param residentId
	 * @return
	 */
	public List<StaffHouse> getStaffHouseByResidentId(Integer residentId) {
		StaffHouseExample example = new StaffHouseExample();
		Criteria criteria = example.createCriteria();
		criteria.andResidentIdEqualTo(residentId);
		return staffHouseMapper.selectByExample(example);
	}
	
	/**
	 * 根据staffId获取StaffHouse的list
	 * @param staffId
	 * @return
	 */
	public List<StaffHouse> getStaffHouseByStaffId(Integer staffId) {
		StaffHouseExample example = new StaffHouseExample();
		Criteria criteria = example.createCriteria();
		criteria.andStaffIdEqualTo(staffId);
		return staffHouseMapper.selectByExample(example);
	}
	
	
}

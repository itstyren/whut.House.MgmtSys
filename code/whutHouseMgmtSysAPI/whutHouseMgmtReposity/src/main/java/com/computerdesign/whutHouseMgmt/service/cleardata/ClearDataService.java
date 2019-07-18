package com.computerdesign.whutHouseMgmt.service.cleardata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.house.HouseExample;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentExample;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffExample;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.house.HouseMapper;
import com.computerdesign.whutHouseMgmt.dao.houseregister.ResidentMapper;
import com.computerdesign.whutHouseMgmt.dao.staffmanagement.StaffMapper;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.StaffService;

@Service
public class ClearDataService {

	@Autowired
	private StaffMapper staffMapper;
	
	@Autowired
	private ResidentMapper residentMapper;
	
	@Autowired
	private HouseMapper houseMapper;
	
	/**
	 * 清除职工数据
	 */
	public void clearStaffData(){
		StaffExample example = new StaffExample();
		Criteria criteria = example.createCriteria();
		staffMapper.deleteByExample(example);
	}
	
	/**
	 * 清除住房关系数据
	 */
	public void clearResidentData(){
		ResidentExample example = new ResidentExample();
		com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentExample.Criteria criteria = example.createCriteria();
		residentMapper.deleteByExample(example);
	}
	
	/**
	 * 清除住房数据
	 */
	public void clearHouseData(){
		HouseExample example = new HouseExample();
		com.computerdesign.whutHouseMgmt.bean.houseManagement.house.HouseExample.Criteria criteria = example.createCriteria();
		houseMapper.deleteByExample(example);
	}
	
}

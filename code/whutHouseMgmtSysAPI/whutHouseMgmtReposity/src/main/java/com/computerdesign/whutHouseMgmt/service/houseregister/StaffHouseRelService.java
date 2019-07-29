package com.computerdesign.whutHouseMgmt.service.houseregister;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.houseregister.StaffHouseRel;
import com.computerdesign.whutHouseMgmt.bean.houseregister.StaffHouseRelExample;
import com.computerdesign.whutHouseMgmt.bean.houseregister.StaffHouseRelExample.Criteria;
import com.computerdesign.whutHouseMgmt.bean.staffhomepage.houseinfo.ResidentHouse;
import com.computerdesign.whutHouseMgmt.bean.staffhomepage.houseinfo.ResidentHouseExample;
import com.computerdesign.whutHouseMgmt.dao.houseregister.StaffHouseRelMapper;
import com.computerdesign.whutHouseMgmt.dao.staffhomepage.houseinfo.ResidentHouseMapper;

@Service
public class StaffHouseRelService {

	@Autowired
	private StaffHouseRelMapper staffHouseRelMapper;
	
	@Autowired
	private ResidentHouseMapper residentHouseMapper;
	
	/**
	 * 使用view_hs_ResidentHouse表，获取房屋的全部住房关系数据
	 * @param houseId
	 * @return
	 */
	public List<ResidentHouse> getAllResidentByHouseId(Integer houseId){
		ResidentHouseExample example = new ResidentHouseExample();
		com.computerdesign.whutHouseMgmt.bean.staffhomepage.houseinfo.ResidentHouseExample.Criteria criteria = example.createCriteria();
		criteria.andHouseIdEqualTo(houseId);
		return residentHouseMapper.selectByExample(example);
	}
	
	/**
	 * 使用view_hs_ResidentHouse表，获取职工的全部住房关系数据
	 * @param staffId
	 * @return
	 */
	public List<ResidentHouse> getAllResidentByStaffId(Integer staffId){
		ResidentHouseExample example = new ResidentHouseExample();
		com.computerdesign.whutHouseMgmt.bean.staffhomepage.houseinfo.ResidentHouseExample.Criteria criteria = example.createCriteria();
		criteria.andStaffIdEqualTo(staffId);
		return residentHouseMapper.selectByExample(example);
	}
	
	/**
	 * 通过员工ID查询员工与房屋的关系记录
	 * @param staffId
	 * @return
	 */
	public List<StaffHouseRel> selectByStaffId(Integer staffId){
		StaffHouseRelExample example = new StaffHouseRelExample();
		Criteria criteria = example.createCriteria();
		criteria.andStaffIdEqualTo(staffId);
		criteria.andIsDeleteEqualTo(false);
		return staffHouseRelMapper.selectByExample(example);
	}
	
}

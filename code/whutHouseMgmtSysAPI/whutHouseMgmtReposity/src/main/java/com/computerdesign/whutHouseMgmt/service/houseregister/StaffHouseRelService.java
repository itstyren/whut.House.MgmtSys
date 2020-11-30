package com.computerdesign.whutHouseMgmt.service.houseregister;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.houseregister.StaffHouseRel;
import com.computerdesign.whutHouseMgmt.bean.houseregister.StaffHouseRelExample;
import com.computerdesign.whutHouseMgmt.bean.houseregister.StaffHouseRelExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.houseregister.StaffHouseRelMapper;

@Service
public class StaffHouseRelService {

	@Autowired
	private StaffHouseRelMapper staffHouseRelMapper;
	
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

package com.computerdesign.whutHouseMgmt.service.housesub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.housesub.StaffForMonSub;
import com.computerdesign.whutHouseMgmt.bean.housesub.StaffForMonSubExample;
import com.computerdesign.whutHouseMgmt.bean.housesub.StaffForMonSubExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.housesub.StaffForMonSubMapper;

@Service
public class StaffForMonSubService {
	
	@Autowired
	private StaffForMonSubMapper staffForMonSubMapper;
	
	/**
	 * 根据staffId获取相应的享受面积数据
	 * @param staffId
	 * @return
	 */
	public StaffForMonSub getByStaffId(Integer staffId){
		StaffForMonSubExample example = new StaffForMonSubExample();
		Criteria criteria = example.createCriteria();
		criteria.andStaffIdEqualTo(staffId);
		return staffForMonSubMapper.selectByExample(example).get(0);
	}
	
}

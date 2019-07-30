package com.computerdesign.whutHouseMgmt.service.houseregister;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentVw;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentVwExample;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentVwExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.houseregister.ResidentVwMapper;

@Service
public class ResidentVwService {

	@Autowired
	private ResidentVwMapper residentVwMapper;
	
//	根据员工编号获取租房的员工所有租房记录
	public List<ResidentVw> getRentHouseByStaffNo(String staffNo){
		ResidentVwExample example = new ResidentVwExample();
		Criteria criteria = example.createCriteria();
		criteria.andStaffNoEqualTo(staffNo);
//		criteria.andIsDeleteEqualTo(false);
		criteria.andHouseRelEqualTo("租赁");
		
		return residentVwMapper.selectByExample(example);
	}
	
}

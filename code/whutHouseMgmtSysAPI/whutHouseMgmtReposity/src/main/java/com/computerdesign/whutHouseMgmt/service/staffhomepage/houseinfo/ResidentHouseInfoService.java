package com.computerdesign.whutHouseMgmt.service.staffhomepage.houseinfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.staffhomepage.houseinfo.ResidentHouse;
import com.computerdesign.whutHouseMgmt.bean.staffhomepage.houseinfo.ResidentHouseExample;
import com.computerdesign.whutHouseMgmt.bean.staffhomepage.houseinfo.ResidentHouseExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.staffhomepage.houseinfo.ResidentHouseMapper;

@Service
public class ResidentHouseInfoService {

	@Autowired
	private ResidentHouseMapper residentHouseMapper;
	
	/**
	 * 通过staffId获取其所有房屋信息
	 * @param staffId
	 * @return
	 */
	public List<ResidentHouse> getHouseInfo(Integer staffId){
		ResidentHouseExample example = new ResidentHouseExample();
		Criteria criteria = example.createCriteria();
		criteria.andStaffIdEqualTo(staffId);
		return residentHouseMapper.selectByExample(example);
	}
	
}

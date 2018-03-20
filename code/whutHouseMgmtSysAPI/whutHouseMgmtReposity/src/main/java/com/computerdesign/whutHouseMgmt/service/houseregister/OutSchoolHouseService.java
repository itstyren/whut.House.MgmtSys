package com.computerdesign.whutHouseMgmt.service.houseregister;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.houseregister.OutSchoolHouse;
import com.computerdesign.whutHouseMgmt.bean.houseregister.OutSchoolHouseVw;
import com.computerdesign.whutHouseMgmt.bean.houseregister.OutSchoolHouseVwExample;
import com.computerdesign.whutHouseMgmt.bean.houseregister.OutSchoolHouseVwExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.houseregister.OutSchoolHouseMapper;
import com.computerdesign.whutHouseMgmt.dao.houseregister.OutSchoolHouseVwMapper;

@Service
public class OutSchoolHouseService {

	@Autowired
	private OutSchoolHouseMapper outSchoolHouseMapper;
	
	@Autowired
	private OutSchoolHouseVwMapper outSchoolHouseVwMapper;
	
	/**
	 * 校外房登记
	 * @param outSchoolHouse
	 */
	public void outSchoolHouseRegister(OutSchoolHouse outSchoolHouse){
		outSchoolHouseMapper.insertSelective(outSchoolHouse);
	}
	
	/**
	 * 根据职工ID获取校外房登记关系
	 * @param staffId
	 * @return
	 */
	public List<OutSchoolHouseVw> getOutSchoolHouseVwByStaffId(Integer staffId){
		OutSchoolHouseVwExample example = new OutSchoolHouseVwExample();
		Criteria criteria = example.createCriteria();
		criteria.andStaffIdEqualTo(staffId);
		return outSchoolHouseVwMapper.selectByExample(example);
	}
	
}

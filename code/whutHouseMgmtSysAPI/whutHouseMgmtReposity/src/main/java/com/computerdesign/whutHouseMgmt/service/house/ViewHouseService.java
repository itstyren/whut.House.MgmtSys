package com.computerdesign.whutHouseMgmt.service.house;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.house.ViewHouse;
import com.computerdesign.whutHouseMgmt.bean.house.ViewHouseExample;
import com.computerdesign.whutHouseMgmt.bean.house.ViewHouseExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.house.ViewHouseMapper;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@Service
public class ViewHouseService {

	@Autowired
	private ViewHouseMapper viewHouseMapper;
	
	public ViewHouse get(Integer id) {
		ViewHouseExample example = new ViewHouseExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		return viewHouseMapper.selectByExample(example).get(0);
	}
	/**
	 * 根据楼栋id返回一个楼栋的房屋
	 * @param buildingId
	 * @return
	 */
	public List<ViewHouse> getViewHousesByBuildingId(Integer buildingId) {
		ViewHouseExample example =new ViewHouseExample();
		Criteria criteria = example.createCriteria();
		criteria.andBuildingIdEqualTo(buildingId);
		return viewHouseMapper.selectByExample(example);
	}
	
	/**
	 * 根据地区id返回一个地区的house
	 * @param regionId
	 * @return
	 */
	public List<ViewHouse> getViewHousesByRegionId(List<Integer> buildingIdList) {
		ViewHouseExample example =new ViewHouseExample();
		Criteria criteria = example.createCriteria();
		criteria.andBuildingIdIn(buildingIdList);
		return viewHouseMapper.selectByExample(example);
		
	}
	
	public List<ViewHouse> getAll(){
		return viewHouseMapper.selectByExample(null);
	}
}

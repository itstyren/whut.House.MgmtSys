package com.computerdesign.whutHouseMgmt.service.building;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.building.Building;
import com.computerdesign.whutHouseMgmt.bean.building.BuildingExample;
import com.computerdesign.whutHouseMgmt.bean.building.BuildingExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.building.BuildingMapper;
import com.computerdesign.whutHouseMgmt.service.base.BaseService;

@Service
public class BuildingService implements BaseService<Building>{

	@Autowired
	private BuildingMapper buildingMapper;
	
	@Override
	public List<Building> getAll(){
		return buildingMapper.selectByExample(null);
	}
	
	/**
	 * 根据不同的buildingRegion选出不同Region的Building
	 * @param buildingRegion
	 * @return
	 */
	public List<Building> getAll(Integer buildingRegion) {
		BuildingExample example=new BuildingExample();
		Criteria criteria=example.createCriteria();
		criteria.andBuildingRegionEqualTo(buildingRegion);
		return buildingMapper.selectByExample(example);
	}
	
	@Override
	public void add(Building building){
		buildingMapper.insertSelective(building);
	}
	
	@Override
	public void delete(Integer buildingId){
		buildingMapper.deleteByPrimaryKey(buildingId);
	}
	
	@Override
	public void update(Building building){
		buildingMapper.updateByPrimaryKeySelective(building);
	}
}

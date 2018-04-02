package com.computerdesign.whutHouseMgmt.service.building;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.computerdesign.whutHouseMgmt.bean.houseManagement.building.Building;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.building.BuildingExample;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.building.BuildingExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.building.BuildingMapper;
import com.computerdesign.whutHouseMgmt.service.base.BaseService;

@Transactional
@Service
public class BuildingService implements BaseService<Building>{

	@Autowired
	private BuildingMapper buildingMapper;
	
	public Building getBuildingById(Integer id) {
		return buildingMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 获取全部的building
	 */
	@Override
	public List<Building> getAll(){
		return buildingMapper.selectByExample(null);
	}
	
	/**
	 * 根据name获取building
	 * @param name
	 * @return
	 */
	public List<Building> getAllByName(String name) {
		BuildingExample example=new BuildingExample();
		Criteria criteria=example.createCriteria();
		criteria.andNameEqualTo(name);
		return buildingMapper.selectByExample(example);
	}
	/**
	 * 根据不同的regionId选出不同Region的Building
	 * @param buildingRegion
	 * @return
	 */
	public List<Building> getAllByRegionId(Integer regionId) {
		BuildingExample example=new BuildingExample();
		Criteria criteria=example.createCriteria();
		criteria.andRegionIdEqualTo(regionId);
		return buildingMapper.selectByExample(example);
	}
	
	@Override
	public void add(Building building){
		buildingMapper.insertSelective(building);
	}
	
	@Override
	public void delete(Integer id){
		buildingMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public void update(Building building){
		buildingMapper.updateByPrimaryKeySelective(building);
	}
}

package com.computerdesign.whutHouseMgmt.service.building;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.computerdesign.whutHouseMgmt.bean.building.ViewBuilding;
import com.computerdesign.whutHouseMgmt.bean.building.ViewBuildingExample;
import com.computerdesign.whutHouseMgmt.bean.building.ViewBuildingExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.building.ViewBuildingMapper;

@Transactional
@Service
public class ViewBuildingService {

	@Autowired
	private ViewBuildingMapper viewBuildingMapper;
	
	public ViewBuilding getViewBuildingById(Integer id) {
		ViewBuildingExample example = new ViewBuildingExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		return viewBuildingMapper.selectByExample(example).get(0);
	}
	
	public List<ViewBuilding> getAllViewBuilding(){
		return viewBuildingMapper.selectByExample(null);
	}
	
	public List<ViewBuilding> getAllViewBuildintByName(String name) {
		ViewBuildingExample example=new ViewBuildingExample();
		Criteria criteria=example.createCriteria();
		criteria.andNameEqualTo(name);
		return viewBuildingMapper.selectByExample(example);
	}
	/**
	 * 根据不同的regionId选出不同Region的Building
	 * @param buildingRegion
	 * @return
	 */
	public List<ViewBuilding> getAllViewBuildingByRegionId(Integer regionId) {
		ViewBuildingExample example=new ViewBuildingExample();
		Criteria criteria=example.createCriteria();
		criteria.andRegionIdEqualTo(regionId);
		return viewBuildingMapper.selectByExample(example);
	}
	

}

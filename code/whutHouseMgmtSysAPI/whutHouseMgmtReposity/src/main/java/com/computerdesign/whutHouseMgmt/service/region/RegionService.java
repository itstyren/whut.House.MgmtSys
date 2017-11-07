package com.computerdesign.whutHouseMgmt.service.region;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.fixparam.FixParameter;
import com.computerdesign.whutHouseMgmt.bean.region.Region;
import com.computerdesign.whutHouseMgmt.dao.region.RegionMapper;
import com.computerdesign.whutHouseMgmt.service.base.BaseService;

@Service
public class RegionService implements BaseService<Region>{
	
	@Autowired
	private RegionMapper regionMapper;

	/**
	 * 根据regionId获得Region
	 * @param regionId
	 * @return
	 */
	public Region get(Integer regionId) {
		return regionMapper.selectByPrimaryKey(regionId);
	}
	
	@Override
	public List<Region> getAll(){
		return regionMapper.selectByExample(null);
	}
	
	@Override
	public void add(Region region){
		regionMapper.insertSelective(region);
	}
	

	@Override
	public void delete(Integer regionId){
		regionMapper.deleteByPrimaryKey(regionId);
	}
	
	@Override
	public void update(Region region){
		regionMapper.updateByPrimaryKeySelective(region);
	}
}

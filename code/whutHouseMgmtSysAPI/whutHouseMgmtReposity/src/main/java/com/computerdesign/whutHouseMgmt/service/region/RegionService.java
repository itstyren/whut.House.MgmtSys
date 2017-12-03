package com.computerdesign.whutHouseMgmt.service.region;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.fixparam.FixParameter;
import com.computerdesign.whutHouseMgmt.bean.region.Region;
import com.computerdesign.whutHouseMgmt.bean.region.RegionExample;
import com.computerdesign.whutHouseMgmt.bean.region.RegionExample.Criteria;
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
	public Region get(Integer Id) {
		return regionMapper.selectByPrimaryKey(Id);
	}
	
	public List<Region> getAllByName(String name) {
		RegionExample example = new RegionExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		return regionMapper.selectByExample(example);
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
	public void delete(Integer Id){
		regionMapper.deleteByPrimaryKey(Id);
	}
	
	@Override
	public void update(Region region){
		regionMapper.updateByPrimaryKeySelective(region);
	}
}

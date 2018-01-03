package com.computerdesign.whutHouseMgmt.service.house;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.computerdesign.whutHouseMgmt.bean.house.House;
import com.computerdesign.whutHouseMgmt.bean.house.HouseExample;
import com.computerdesign.whutHouseMgmt.bean.house.HouseExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.house.HouseMapper;
import com.computerdesign.whutHouseMgmt.service.base.BaseService;

import net.sf.jsqlparser.util.AddAliasesVisitor;

@Transactional
@Service
public class HouseService implements BaseService<House>{
	
	@Autowired
	private HouseMapper houseMapper;
	
	/**
	 * 根据id选择house
	 * @param id
	 * @return
	 */
	public House get(Integer id) {
		return houseMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 根据buildingId选择某一栋的house
	 * @param buildingId
	 * @return
	 */
	public List<House> getHousesByBuildingId(Integer buildingId){
		HouseExample example=new HouseExample();
		Criteria criteria=example.createCriteria();
		criteria.andBuildingIdEqualTo(buildingId);
		return houseMapper.selectByExample(example);
	}
	
	public List<House> getHouseByNo(Integer No) {
		HouseExample example = new HouseExample();
		Criteria criteria = example.createCriteria();
		criteria.andNoEqualTo(No);
		return houseMapper.selectByExample(example);
	}
	@Override
	public List<House> getAll() {
		return houseMapper.selectByExample(null);		
	}
	
	@Override
	public void add(House house){
		houseMapper.insertSelective(house);
	}
	
	@Override
	public void delete(Integer id){
		houseMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public void update(House house){
		houseMapper.updateByPrimaryKeySelective(house);
	}
}
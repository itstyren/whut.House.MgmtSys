package com.computerdesign.whutHouseMgmt.service.internetselecthouse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.house.House;
import com.computerdesign.whutHouseMgmt.bean.house.ViewHouse;
import com.computerdesign.whutHouseMgmt.bean.house.ViewHouseExample;
import com.computerdesign.whutHouseMgmt.bean.house.ViewHouseExample.Criteria;
import com.computerdesign.whutHouseMgmt.bean.houseregister.HouseAllSelectModel;
import com.computerdesign.whutHouseMgmt.dao.house.HouseMapper;
import com.computerdesign.whutHouseMgmt.dao.house.ViewHouseMapper;

@Service
public class HousingSetService {

	@Autowired
	private ViewHouseMapper viewHouseMapper;
	
	@Autowired
	private HouseMapper houseMapper;
	
	/**
	 * 设置房源
	 * @param house
	 */
	public void setHousing(House house){
		houseMapper.updateByPrimaryKeySelective(house);
	}
	
	/**
	 * 初始显示已设置房源(canselect)
	 * @return
	 */
	public List<ViewHouse> canselectHouseShow(){
		ViewHouseExample example = new ViewHouseExample();
		Criteria criteria = example.createCriteria();
		criteria.andRecordStatusEqualTo(0);
		return viewHouseMapper.selectByExample(example);
	}
	
	/**
	 * 初始显示未设置房源(active)
	 * @return
	 */
	public List<ViewHouse> activeHouseShow(){
		ViewHouseExample example = new ViewHouseExample();
		Criteria criteria = example.createCriteria();
		criteria.andRecordStatusEqualTo(2);
		return viewHouseMapper.selectByExample(example);
	}
	
	/**
	 * 根据组合条件查询房源
	 * @param houseAllSelectModel
	 * @return
	 */
	public List<ViewHouse> selectHousingMultiCondition(HouseAllSelectModel houseAllSelectModel){
		ViewHouseExample example = new ViewHouseExample();
		Criteria criteria = example.createCriteria();
		if(houseAllSelectModel.getHouseType() != null){			
			criteria.andTypeNameEqualTo(houseAllSelectModel.getHouseType());
		}
		if(houseAllSelectModel.getUseStatus() != null){			
			criteria.andStatusNameEqualTo(houseAllSelectModel.getUseStatus());
		}
		if(houseAllSelectModel.getHouseZone() != null){			
			criteria.andRegionNameEqualTo(houseAllSelectModel.getHouseZone());
			if(houseAllSelectModel.getBuilding() !=null){				
				criteria.andBuildingNameEqualTo(houseAllSelectModel.getBuilding());
			}
		}
		if(houseAllSelectModel.getStructName() != null){			
			criteria.andStructNameEqualTo(houseAllSelectModel.getStructName());
		}
		if(houseAllSelectModel.getLayoutName() != null){			
			criteria.andLayoutNameEqualTo(houseAllSelectModel.getLayoutName());
		}
		//面积
		if(houseAllSelectModel.getAreaParameter() != null){
			String areaParamName = houseAllSelectModel.getAreaParameter().getAreaParamName();
			if(areaParamName != null){
				double minArea = houseAllSelectModel.getAreaParameter().getMinArea();
				double maxArea = houseAllSelectModel.getAreaParameter().getMaxArea();
				if(areaParamName.equals("建筑面积")){
					criteria.andBuildAreaBetween(minArea, maxArea);
				}else if(areaParamName.equals("使用面积")){
					criteria.andUsedAreaBetween(minArea, maxArea);
				}else if(areaParamName.equals("地下室面积")){
					criteria.andBasementAreaBetween(minArea, maxArea);
				}
			}
		}
		//租金
		if(houseAllSelectModel.getRentalScope() != null){
			double minRental = houseAllSelectModel.getRentalScope().getMinRental();
			double maxRental = houseAllSelectModel.getRentalScope().getMaxRental();
			criteria.andRentalBetween(minRental, maxRental);
		}
		return viewHouseMapper.selectByExample(example);
	}
	
}

package com.computerdesign.whutHouseMgmt.service.houseregister;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.house.ViewHouse;
import com.computerdesign.whutHouseMgmt.bean.house.ViewHouseExample;
import com.computerdesign.whutHouseMgmt.bean.house.ViewHouseExample.Criteria;
import com.computerdesign.whutHouseMgmt.bean.houseregister.FinishTime;
import com.computerdesign.whutHouseMgmt.bean.houseregister.HouseAllSelectModel;
import com.computerdesign.whutHouseMgmt.bean.houseregister.HouseSelectModel;
import com.computerdesign.whutHouseMgmt.bean.houseregister.HouseShowModel;
import com.computerdesign.whutHouseMgmt.dao.house.ViewHouseMapper;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * 使用ViewHouse视图
 * @author Administrator
 *
 */
@Service
public class HouseRegisterSelectService {
	@Autowired
	private ViewHouseMapper viewHouseMapper;
	
	/**
	 * 多条件查询
	 * @param houseSelectModel
	 * @return
	 */
	public List<ViewHouse> getByMultiConditionQuery(HouseSelectModel houseSelectModel){
		ViewHouseExample example = new ViewHouseExample();
		Criteria criteria = example.createCriteria();
		if(houseSelectModel.getHouseType() != null){			
			criteria.andTypeNameEqualTo(houseSelectModel.getHouseType());
		}
		if(houseSelectModel.getUseStatus() != null){			
			criteria.andStatusNameEqualTo(houseSelectModel.getUseStatus());
		}
		if(houseSelectModel.getHouseZone() != null){			
			criteria.andRegionNameEqualTo(houseSelectModel.getHouseZone());
			if(houseSelectModel.getBuilding() !=null){				
				criteria.andBuildingNameEqualTo(houseSelectModel.getBuilding());
			}
		}
		
		return viewHouseMapper.selectByExample(example);
	}
	
	/**
	 * 全面多条件查询
	 * @param houseAllSelectModel
	 * @return
	 */
	public List<ViewHouse> getByAllMultiConditionQuery(HouseAllSelectModel houseAllSelectModel){
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
		
		
		//建设时间
		FinishTime finishTime = houseAllSelectModel.getFinishTime();
		if(finishTime != null){
			//System.out.println(finishTime.getStartTime().getTime());
			//System.out.println(finishTime.getEndTime());
		//	long startTime = finishTime.getStartTime().getTime();
		//	long endTime = finishTime.getEndTime().getTime();
		//	System.out.println(startTime);
			criteria.andFinishTimeBetween(finishTime.getStartTime(), finishTime.getEndTime());
		}
		
		return viewHouseMapper.selectByExample(example);
	}
	
}

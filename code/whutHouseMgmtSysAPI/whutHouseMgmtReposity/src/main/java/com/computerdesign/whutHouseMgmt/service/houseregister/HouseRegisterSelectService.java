package com.computerdesign.whutHouseMgmt.service.houseregister;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.houseManagement.house.ViewHouse;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.house.ViewHouseExample;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.house.ViewHouseExample.Criteria;
import com.computerdesign.whutHouseMgmt.bean.houseregister.FinishTime;
import com.computerdesign.whutHouseMgmt.bean.houseregister.HouseAllSelectModel;
import com.computerdesign.whutHouseMgmt.bean.houseregister.HouseSelectModel;
import com.computerdesign.whutHouseMgmt.bean.houseregister.HouseShowModel;
import com.computerdesign.whutHouseMgmt.dao.house.ViewHouseMapper;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * 使用ViewHouse视图
 * 
 * @author Administrator
 *
 */
@Service
public class HouseRegisterSelectService {
	@Autowired
	private ViewHouseMapper viewHouseMapper;

	/**
	 * 多条件查询
	 * 
	 * @param houseSelectModel
	 * @return
	 */
	public List<ViewHouse> getByMultiConditionQuery(HouseSelectModel houseSelectModel) {
		ViewHouseExample example = new ViewHouseExample();
		Criteria criteria = example.createCriteria();
		if (houseSelectModel != null) {
			if (houseSelectModel.getHouseTypeId() != null) {
				criteria.andTypeEqualTo(houseSelectModel.getHouseTypeId());
			}
			if (houseSelectModel.getUseStatusId() != null) {
				criteria.andStatusEqualTo(houseSelectModel.getUseStatusId());
			}
			if(houseSelectModel.getCampusId() != null){
				if (houseSelectModel.getRegionId() != null) {
					criteria.andRegionIdEqualTo(houseSelectModel.getRegionId());
					if (houseSelectModel.getBuildingId() != null) {
						criteria.andBuildingIdEqualTo(houseSelectModel.getBuildingId());
					}
				}
			}
			
		}
		return viewHouseMapper.selectByExample(example);
	}

	/**
	 * 全面多条件查询
	 * 
	 * @param houseAllSelectModel
	 * @return
	 */
	public List<ViewHouse> getByAllMultiConditionQuery(HouseAllSelectModel houseAllSelectModel) {
		ViewHouseExample example = new ViewHouseExample();
		Criteria criteria = example.createCriteria();
		// 住房类型
		if (houseAllSelectModel.getHouseTypeId() != null) {
			criteria.andTypeEqualTo(houseAllSelectModel.getHouseTypeId());
		}
		// 住房状态
		if (houseAllSelectModel.getUseStatusId() != null) {
			criteria.andStatusEqualTo(houseAllSelectModel.getUseStatusId());
		}
		// 住房结构
		if (houseAllSelectModel.getStructId() != null) {
			criteria.andStructEqualTo(houseAllSelectModel.getStructId());
		}
		// 户型
		if (houseAllSelectModel.getLayoutId() != null) {
			criteria.andLayoutEqualTo(houseAllSelectModel.getLayoutId());
		}
		// 面积
		if (houseAllSelectModel.getAreaParameter() != null) {
			String areaParamName = houseAllSelectModel.getAreaParameter().getAreaParamName();
			if (areaParamName != null) {
				double minArea = houseAllSelectModel.getAreaParameter().getMinArea();
				double maxArea = houseAllSelectModel.getAreaParameter().getMaxArea();
				if (areaParamName.equals("建筑面积")) {
					criteria.andBuildAreaBetween(minArea, maxArea);
				} else if (areaParamName.equals("使用面积")) {
					criteria.andUsedAreaBetween(minArea, maxArea);
				} else if (areaParamName.equals("地下室面积")) {
					criteria.andBasementAreaBetween(minArea, maxArea);
				}
			}
		}

		// 建设时间
		FinishTime finishTime = houseAllSelectModel.getFinishTime();
		if (finishTime != null) {
			// System.out.println(finishTime.getStartTime().getTime());
			// System.out.println(finishTime.getEndTime());
			// long startTime = finishTime.getStartTime().getTime();
			// long endTime = finishTime.getEndTime().getTime();
			// System.out.println(startTime);
			criteria.andFinishTimeBetween(finishTime.getStartTime(), finishTime.getEndTime());
		}
		// 住房校区、区域、楼栋
		if (houseAllSelectModel.getCampusId() != null) {
			criteria.andCampusIdEqualTo(houseAllSelectModel.getCampusId());
			if (houseAllSelectModel.getRegionId() != null) {
				criteria.andRegionIdEqualTo(houseAllSelectModel.getRegionId());
				if (houseAllSelectModel.getBuildingId() != null) {
					criteria.andBuildingIdEqualTo(houseAllSelectModel.getBuildingId());
				}
			}
		}

		return viewHouseMapper.selectByExample(example);
	}

}

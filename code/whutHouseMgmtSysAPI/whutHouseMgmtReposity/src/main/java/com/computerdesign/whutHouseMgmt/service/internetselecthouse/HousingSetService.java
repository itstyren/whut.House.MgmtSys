package com.computerdesign.whutHouseMgmt.service.internetselecthouse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.houseManagement.house.House;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.house.ViewHouse;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.house.ViewHouseExample;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.house.ViewHouseExample.Criteria;
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
	 * 
	 * @param house
	 */
	public void setHousing(House house) {
		houseMapper.updateByPrimaryKeySelective(house);
	}

	/**
	 * 初始显示已设置房源(canselect)
	 * 
	 * @return
	 */
	public List<ViewHouse> canselectHouseShow() {
		ViewHouseExample example = new ViewHouseExample();
		Criteria criteria = example.createCriteria();
		criteria.andRecordStatusEqualTo(0);
		return viewHouseMapper.selectByExample(example);
	}

	/**
	 * 初始显示未设置房源(active)
	 * 
	 * @return
	 */
	public List<ViewHouse> activeHouseShow() {
		ViewHouseExample example = new ViewHouseExample();
		Criteria criteria = example.createCriteria();
		criteria.andRecordStatusEqualTo(2);
		return viewHouseMapper.selectByExample(example);
	}

	/**
	 * 根据组合条件查询未设置的房源
	 * 
	 * @param houseAllSelectModel
	 * @return
	 */
	public List<ViewHouse> selectActiveHousingMultiCondition(HouseAllSelectModel houseAllSelectModel) {
		ViewHouseExample example = new ViewHouseExample();
		Criteria criteria = example.createCriteria();
		// 住房类型
		if (houseAllSelectModel.getHouseTypeId() != null) {
			criteria.andTypeEqualTo(houseAllSelectModel.getHouseTypeId());
		}
		// 使用状态
		if (houseAllSelectModel.getUseStatusId() != null) {
			criteria.andStatusEqualTo(houseAllSelectModel.getUseStatusId());
		}
		// 住房结构
		if (houseAllSelectModel.getStructId() != null) {
			criteria.andStructEqualTo(houseAllSelectModel.getStructId());
		}
		// 住房户型
		if (houseAllSelectModel.getLayoutId() != null) {
			criteria.andLayoutEqualTo(houseAllSelectModel.getLayoutId());
		}
		// 租金
		if (houseAllSelectModel.getRentalScope() != null) {
			double minRental = houseAllSelectModel.getRentalScope().getMinRental();
			double maxRental = houseAllSelectModel.getRentalScope().getMaxRental();
			criteria.andRentalBetween(minRental, maxRental);
		}
		// 住房校区、区域、楼栋
		if (houseAllSelectModel.getCampusId() != null) {
			if (houseAllSelectModel.getRegionId() != null) {
				criteria.andRegionIdEqualTo(houseAllSelectModel.getRegionId());
				if (houseAllSelectModel.getBuildingId() != null) {
					criteria.andBuildingIdEqualTo(houseAllSelectModel.getBuildingId());
				}
			}
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

		criteria.andRecordStatusEqualTo(2);
		return viewHouseMapper.selectByExample(example);
	}

	/**
	 * 根据组合条件查询已设置的房源
	 * 
	 * @param houseAllSelectModel
	 * @return
	 */
	public List<ViewHouse> selectCanselectHousingMultiCondition(HouseAllSelectModel houseAllSelectModel) {
		ViewHouseExample example = new ViewHouseExample();
		Criteria criteria = example.createCriteria();
		// 住房类型
		if (houseAllSelectModel.getHouseTypeId() != null) {
			criteria.andTypeEqualTo(houseAllSelectModel.getHouseTypeId());
		}
		// 使用状态
		if (houseAllSelectModel.getUseStatusId() != null) {
			criteria.andStatusEqualTo(houseAllSelectModel.getUseStatusId());
		}
		// 住房结构
		if (houseAllSelectModel.getStructId() != null) {
			criteria.andStructEqualTo(houseAllSelectModel.getStructId());
		}
		// 住房户型
		if (houseAllSelectModel.getLayoutId() != null) {
			criteria.andLayoutEqualTo(houseAllSelectModel.getLayoutId());
		}
		// 租金
		if (houseAllSelectModel.getRentalScope() != null) {
			double minRental = houseAllSelectModel.getRentalScope().getMinRental();
			double maxRental = houseAllSelectModel.getRentalScope().getMaxRental();
			criteria.andRentalBetween(minRental, maxRental);
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

		criteria.andRecordStatusEqualTo(0);
		return viewHouseMapper.selectByExample(example);
	}

}

package com.computerdesign.whutHouseMgmt.service.querystatistics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentVw;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentVwExample;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentVwExample.Criteria;
import com.computerdesign.whutHouseMgmt.bean.querystatistics.MoreHouseQueryModel;
import com.computerdesign.whutHouseMgmt.dao.houseregister.ResidentVwMapper;

/**
 * 多套住房查询
 * 
 * @author Administrator
 *
 */
@Service
public class MoreHouseStaService {

	@Autowired
	private ResidentVwMapper residentVwMapper;

	// public List<ResidentVw> getAll(){
	// ResidentVwExample example = new ResidentVwExample();
	// Criteria criteria = example.createCriteria();
	// criteria.andIsDeleteEqualTo(false);
	// return residentVwMapper.selectByExample(example);
	// }

	/**
	 * 通过staffId获取多套住房详细信息
	 * 
	 * @param staffId
	 * @return
	 */
	public List<ResidentVw> getMoreHouseByStaffId(Integer staffId, MoreHouseQueryModel moreHouseQueryModel) {
		ResidentVwExample example = new ResidentVwExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(false);
		criteria.andStaffIdEqualTo(staffId);
		// 住房类型
		if (moreHouseQueryModel.getHouseTypeId() != null) {
			criteria.andHouseTypeEqualTo(moreHouseQueryModel.getHouseTypeId());
		}
		// 职工类型
		if (moreHouseQueryModel.getStaffTypeId() != null) {
			criteria.andStaffTypeEqualTo(moreHouseQueryModel.getStaffTypeId());
		}
		return residentVwMapper.selectByExample(example);
	}

	/**
	 * 获取拥有多套住房的职工staffId的List
	 * 
	 * @return
	 */
	public List<Integer> getMoreHouseStaffId() {
		return residentVwMapper.selectMoreHouseStaffId();
	}

	/**
	 * 职工多套房查询
	 * 
	 * @param moreHouseQueryModel
	 * @return
	 */
	public List<ResidentVw> staffMoreHouseQuery(List<Integer> staffIds, MoreHouseQueryModel moreHouseQueryModel) {
		ResidentVwExample example = new ResidentVwExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(false);
		criteria.andStaffIdIn(staffIds);
		// 住房类型
		if (moreHouseQueryModel.getHouseTypeId() != null) {
			criteria.andHouseTypeEqualTo(moreHouseQueryModel.getHouseTypeId());
		}
		// 职工类型
		if (moreHouseQueryModel.getStaffTypeId() != null) {
			criteria.andStaffTypeEqualTo(moreHouseQueryModel.getStaffTypeId());
		}
		return residentVwMapper.selectByExample(example);
	}

}

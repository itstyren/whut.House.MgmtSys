package com.computerdesign.whutHouseMgmt.service.region;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.houseManagement.region.ViewRegion;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.region.ViewRegionExample;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.region.ViewRegionExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.region.ViewRegionMapper;

/**
 *
 * @author wanhaoran
 * @date 2018年3月31日 下午10:58:07
 * 
 */
@Service
public class ViewRegionService {

	@Autowired
	private ViewRegionMapper viewRegionMapper;

	/**
	 * 根据id获取ViewRegion，若无该id，则返回空
	 * 
	 * @param id
	 * @return
	 */
	public ViewRegion get(Integer id) {
		ViewRegionExample example = new ViewRegionExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);

		if (viewRegionMapper.selectByExample(example).isEmpty()) {
			return null;
		}
		return viewRegionMapper.selectByExample(example).get(0);
	}

	public List<ViewRegion> getByCampusId(Integer campusId) {
		ViewRegionExample example = new ViewRegionExample();
		Criteria criteria = example.createCriteria();
		criteria.andCampusIdEqualTo(campusId);
		return viewRegionMapper.selectByExample(example);

	}

	/**
	 * 返回全部的ViewRegion
	 * 
	 * @return
	 */
	public List<ViewRegion> getAll() {
		return viewRegionMapper.selectByExample(null);
	}
	
	/**
	 * 返回管理员权限内的ViewRegion
	 * 
	 * @return
	 */
	public List<ViewRegion> getAllWithMP(List<Integer> campusList) {
		ViewRegionExample example = new ViewRegionExample();
		Criteria criteria = example.createCriteria();
		criteria.andCampusIdIn(campusList);
		return viewRegionMapper.selectByExample(example);
	}
}

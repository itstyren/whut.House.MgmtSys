package com.computerdesign.whutHouseMgmt.service.internetselecthouse;
/**
 *
 * @author wanhaoran
 * @date 2018年4月13日 上午9:56:26
 * 
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.houseManagement.house.ViewHouse;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.HouseStaff;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.HouseStaffExample;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.HouseStaffExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.internetselecthouse.HouseStaffMapper;

@Service
public class HouseStaffService {

	@Autowired
	private HouseStaffMapper houseStaffMapper;
	
	/**
	 * 按条件获取全部的HouseStaff
	 * @param viewHouses
	 * @return
	 */
	public List<HouseStaff> getAll(List<ViewHouse> viewHouses) {
		List<Integer> houseIdList = new ArrayList<>();
		for (ViewHouse viewHouse : viewHouses) {
			houseIdList.add(viewHouse.getId());
		}
		HouseStaffExample houseStaffExample = new HouseStaffExample();
		houseStaffExample.setOrderByClause("StaffId Desc");
		Criteria criteria = houseStaffExample.createCriteria();
		criteria.andHouseIdIn(houseIdList);
		return houseStaffMapper.selectByExample(houseStaffExample);
	}

}

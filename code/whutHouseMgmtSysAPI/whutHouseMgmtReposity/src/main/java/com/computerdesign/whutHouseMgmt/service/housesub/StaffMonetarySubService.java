package com.computerdesign.whutHouseMgmt.service.housesub;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.housesub.StaffMonetarySub;
import com.computerdesign.whutHouseMgmt.bean.housesub.StaffMonetarySubExample;
import com.computerdesign.whutHouseMgmt.bean.housesub.StaffMonetarySubExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.housesub.StaffMonetarySubMapper;

/**
 * 货币化补贴Service
 * @author Administrator
 *
 */
@Service
public class StaffMonetarySubService {
	
	@Autowired
	private StaffMonetarySubMapper staffMonetarySubMapper;
	
	/**
	 * 根据职工编号获取其所有补贴记录
	 * @param staffNo
	 * @return
	 */
	public List<StaffMonetarySub> getMonetarySubByStaffNo(String staffNo){
		StaffMonetarySubExample example = new StaffMonetarySubExample();
		Criteria criteria = example.createCriteria();
		criteria.andStaffNoEqualTo(staffNo);
		return staffMonetarySubMapper.selectByExample(example);
	}
	
	/**
	 * 根据ID删除一条补贴记录
	 * @param id
	 */
	public void delete(Integer id){
		staffMonetarySubMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 添加一条补贴记录
	 * @param staffMonetarySub
	 */
	public void add(StaffMonetarySub staffMonetarySub){
		staffMonetarySubMapper.insertSelective(staffMonetarySub);
	}
	
}

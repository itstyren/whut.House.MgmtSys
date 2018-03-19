package com.computerdesign.whutHouseMgmt.service.staffmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 新建表ViewStaff，与StaffVw不同
 * @author wanhaoran
 *
 */

import com.computerdesign.whutHouseMgmt.bean.staffmanagement.ViewStaff;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.ViewStaffExample;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.ViewStaffExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.staffmanagement.ViewStaffMapper;
@Service
public class ViewStaffService {

	@Autowired
	private ViewStaffMapper viewStaffMapper ;
	
	/**
	 * 根据staffId获取ViewStaff
	 * @param staffId
	 * @return
	 */
	public List<ViewStaff> getByStaffId(Integer staffId) {
		ViewStaffExample example = new ViewStaffExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(staffId);
		return viewStaffMapper.selectByExample(example);
	}
	
	/**
	 * 根据staffNo获取ViewStaff
	 * @param staffNo
	 * @return
	 */
	public List<ViewStaff> getByStaffNo(String staffNo) {
		ViewStaffExample example = new ViewStaffExample();
		Criteria criteria = example.createCriteria();
		criteria.andNoEqualTo(staffNo);
		return viewStaffMapper.selectByExample(example);
	}
	
	/**
	 * 根据姓名获取员工列表
	 * @param staffName
	 * @return
	 */
	public List<ViewStaff> getViewStaffsByName(String staffName) {
		ViewStaffExample example = new ViewStaffExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(staffName);
		return viewStaffMapper.selectByExample(example);
	}
	
}

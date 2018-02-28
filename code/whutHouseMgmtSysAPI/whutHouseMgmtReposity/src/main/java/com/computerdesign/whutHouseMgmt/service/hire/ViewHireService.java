package com.computerdesign.whutHouseMgmt.service.hire;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.hire.ViewHire;
import com.computerdesign.whutHouseMgmt.bean.hire.ViewHireExample;
import com.computerdesign.whutHouseMgmt.bean.hire.ViewHireExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.hire.ViewHireMapper;

@Service
public class ViewHireService {

	@Autowired
	private ViewHireMapper viewHireMapper ;
	
	/**
	 * 使用ViewHire表
	 * 根据staffId获取ViewHire
	 * @param staffId
	 * @return
	 */
	public List<ViewHire> getByStaffId(Integer staffId) {
		ViewHireExample example = new ViewHireExample();
		Criteria criteria = example.createCriteria();
		criteria.andStaffIdEqualTo(staffId);
		criteria.andIsOverEqualTo(false);
		return viewHireMapper.selectByExample(example);
		
	}
}

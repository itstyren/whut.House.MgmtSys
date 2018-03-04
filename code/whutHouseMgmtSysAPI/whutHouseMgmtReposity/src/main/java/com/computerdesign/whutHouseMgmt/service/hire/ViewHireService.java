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
	 * 根据id获取一个ViewHire
	 * @param id
	 * @return
	 */
	public List<ViewHire> getById(Integer id){
		ViewHireExample example = new ViewHireExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		return viewHireMapper.selectByExample(example);
	}
	
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
	
	/**
	 * 获取全部待受理的房屋申请信息
	 * @return
	 */
	public List<ViewHire> getAcceptUntil() {
		ViewHireExample example = new ViewHireExample();
		Criteria criteria = example.createCriteria();
		criteria.andHireStateEqualTo("待受理");
		criteria.andIsOverEqualTo(false);
		return viewHireMapper.selectByExample(example);
	}
	
	/**
	 * 获取全部的已受理的房屋信息
	 * @return
	 */
	public List<ViewHire> getAcceptHasBeen() {
		ViewHireExample example = new ViewHireExample();
		Criteria criteria = example.createCriteria();
		criteria.andAcceptStateIsNotNull();
		return viewHireMapper.selectByExample(example);
	}
}
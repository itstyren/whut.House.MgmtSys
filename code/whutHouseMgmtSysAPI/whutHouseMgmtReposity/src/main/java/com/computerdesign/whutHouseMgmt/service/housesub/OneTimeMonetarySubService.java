package com.computerdesign.whutHouseMgmt.service.housesub;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.housesub.OneTimeMonetarySub;
import com.computerdesign.whutHouseMgmt.bean.housesub.OneTimeMonetarySubExample;
import com.computerdesign.whutHouseMgmt.bean.housesub.OneTimeMonetarySubExample.Criteria;
import com.computerdesign.whutHouseMgmt.bean.housesub.OneTimeMonetarySubVw;
import com.computerdesign.whutHouseMgmt.bean.housesub.OneTimeMonetarySubVwExample;
import com.computerdesign.whutHouseMgmt.dao.housesub.OneTimeMonetarySubMapper;
import com.computerdesign.whutHouseMgmt.dao.housesub.OneTimeMonetarySubVwMapper;

@Service
public class OneTimeMonetarySubService {

	@Autowired
	private OneTimeMonetarySubMapper oneTimeMonetarySubMapper;
	
	@Autowired
	private OneTimeMonetarySubVwMapper oneTimeMonetarySubVwMapper;
	
	/**
	 * 获取所有一次性补贴记录
	 * @param staffNo
	 * @return
	 */
	public List<OneTimeMonetarySubVw> getAllOneTimeMonetarySub(){
//		OneTimeMonetarySubExample example = new OneTimeMonetarySubExample();
//		Criteria criteria = example.createCriteria();
//		return oneTimeMonetarySubMapper.selectByExample(example);
		OneTimeMonetarySubVwExample example = new OneTimeMonetarySubVwExample();
		com.computerdesign.whutHouseMgmt.bean.housesub.OneTimeMonetarySubVwExample.Criteria criteria = example.createCriteria();
		return oneTimeMonetarySubVwMapper.selectByExample(example);
	}
	
	/**
	 * 根据职工编号获取其所有一次性补贴记录
	 * @param staffNo
	 * @return
	 */
	public List<OneTimeMonetarySubVw> getOneTimeMonetarySubByStaffNo(String staffNo){
//		OneTimeMonetarySubExample example = new OneTimeMonetarySubExample();
//		Criteria criteria = example.createCriteria();
//		criteria.andStaffNoEqualTo(staffNo);
//		return oneTimeMonetarySubMapper.selectByExample(example);
		OneTimeMonetarySubVwExample example = new OneTimeMonetarySubVwExample();
		com.computerdesign.whutHouseMgmt.bean.housesub.OneTimeMonetarySubVwExample.Criteria criteria = example.createCriteria();
		criteria.andStaffNoEqualTo(staffNo);
		return oneTimeMonetarySubVwMapper.selectByExample(example);
	}
	
	/**
	 * 根据ID删除一条一次性补贴记录
	 * @param id
	 */
	public void delete(Integer id){
		oneTimeMonetarySubMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 添加一条一次性补贴记录
	 * @param staffMonetarySub
	 */
	public void add(OneTimeMonetarySub oneTimeMonetarySub){
		oneTimeMonetarySubMapper.insertSelective(oneTimeMonetarySub);
	}
	
	
	
}

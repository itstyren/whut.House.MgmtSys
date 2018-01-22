package com.computerdesign.whutHouseMgmt.service.fix;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.fix.ViewFix;
import com.computerdesign.whutHouseMgmt.bean.fix.ViewFixExample;
import com.computerdesign.whutHouseMgmt.bean.fix.ViewFixExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.fix.ViewFixMapper;

@Service
public class ViewFixService {
	
	@Autowired
	private ViewFixMapper viewFixMapper;
	
	/**
	 * 获取待受理的全部信息
	 * @return
	 */
	public List<ViewFix> getAllApply() {
		ViewFixExample example = new ViewFixExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsOverEqualTo(false);
		criteria.andFixStateEqualTo("待受理");
		return viewFixMapper.selectByExample(example);
	}
	
	/**
	 * 获取全部待受理的维修信息
	 * @return
	 */
	public List<ViewFix> getAcceptUntil() {
		ViewFixExample example = new ViewFixExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsOverEqualTo(false);
		criteria.andFixStateEqualTo("待受理");
		return viewFixMapper.selectByExample(example);
	}
	
	/**
	 * 获取全部的已经受理的维修信息
	 * @return
	 */
	public List<ViewFix> getAcceptHasBeen() {
		ViewFixExample example = new ViewFixExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsOverEqualTo(false);
		//已经受理的信息在AcceptState不为空
		criteria.andAcceptStateIsNotNull();
		return viewFixMapper.selectByExample(example);
	}
	
	/**
	 * 获取全部待审核的维修信息
	 * @return
	 */
	public List<ViewFix> getAgreeUntil() {
		ViewFixExample example = new ViewFixExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsOverEqualTo(false);
		criteria.andFixStateEqualTo("待审核");
		return viewFixMapper.selectByExample(example);
	}
	
	/**
	 * 获取全部的已经受理的维修信息
	 * @return
	 */
	public List<ViewFix> getAgreeHasBeen() {
		ViewFixExample example = new ViewFixExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsOverEqualTo(false);
		//已经审核的信息在AgreeState不为空
		criteria.andAgreeStateIsNotNull();
		return viewFixMapper.selectByExample(example);
	}
}

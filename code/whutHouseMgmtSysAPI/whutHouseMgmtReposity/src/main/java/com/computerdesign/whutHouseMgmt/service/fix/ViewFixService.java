package com.computerdesign.whutHouseMgmt.service.fix;

import java.util.Date;
import java.util.List;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.fix.FixGetCheck;
import com.computerdesign.whutHouseMgmt.bean.fix.common.ViewFix;
import com.computerdesign.whutHouseMgmt.bean.fix.common.ViewFixExample;
import com.computerdesign.whutHouseMgmt.bean.fix.common.ViewFixExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.fix.ViewFixMapper;

@Service
public class ViewFixService {
	
	@Autowired
	private ViewFixMapper viewFixMapper;
	
	/**
	 * 根据职工id获取所有维修信息
	 * @param staffId
	 * @return
	 */
	public List<ViewFix> getByStaffId(Integer staffId){
		ViewFixExample example = new ViewFixExample();
		Criteria criteria = example.createCriteria();
		criteria.andStaffIdEqualTo(staffId);
		return viewFixMapper.selectByExample(example);
	}
	
	public List<ViewFix> getAll() {
		return viewFixMapper.selectByExample(null);
	}
	
	/**
	 * 根据id获取ViewFix
	 * @param id
	 * @return
	 */
	public List<ViewFix> getById(Integer id){
		ViewFixExample example = new ViewFixExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		return viewFixMapper.selectByExample(example);
	}
	/**
	 * 根据起始时间和结束时间获取全部的维修信息
	 * 使用的ViewFix表
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<ViewFix> getByTime(Date startTime,Date endTime) {
		ViewFixExample example = new ViewFixExample();
		Criteria criteria = example.createCriteria();
		criteria.andApplyTimeBetween(startTime, endTime);
		return viewFixMapper.selectByExample(example);
	}
	
	/**
	 * 根据条件查询
	 * FixGetCheck中包括申请时间的起始和终止时间，维修内容属于哪一项
	 * @param fixGetCheck
	 * @return
	 */
	public List<ViewFix> getByMultiCondition(FixGetCheck fixGetCheck) {
		ViewFixExample example = new ViewFixExample();
		Criteria criteria = example.createCriteria();
		Date startTime = fixGetCheck.getStartTime();
		Date endTime = fixGetCheck.getEndTime();
		Integer conditionId = fixGetCheck.getConditionId();
		String conditionContent = fixGetCheck.getConditionContent();
 		//时间参数
		if (startTime!=null && endTime!= null) {
			//时间在中间
			criteria.andApplyTimeBetween(startTime, endTime);
		}else if (startTime!=null && endTime== null) {
			//时间大于设置的起始时间
			criteria.andApplyTimeGreaterThanOrEqualTo(startTime);
		}else if (startTime==null && endTime!= null){
			//时间小于设置的终止时间
			criteria.andApplyTimeLessThanOrEqualTo(endTime);
		}
 		
		//强制参数
		if (conditionContent !=null) {
			if (conditionId == 1) {
				criteria.andIdEqualTo(Integer.parseInt(conditionContent));
			}else if (conditionId == 2) {
				criteria.andStaffNoEqualTo(conditionContent);
			}else if (conditionId == 3) {
				criteria.andHouseNoEqualTo(conditionContent);
			}else if (conditionId == 4) {
				criteria.andStaffNameEqualTo(conditionContent);
			}
		}
		return viewFixMapper.selectByExample(example);
		
		
	}
	
	/**
	 * 获取全部待受理的维修信息
	 * 获取条件为IsOver为0，FixState为"待受理"
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
	 * 获取条件为AcceptState不为空
	 * @return
	 */
	public List<ViewFix> getAcceptHasBeen() {
		ViewFixExample example = new ViewFixExample();
		Criteria criteria = example.createCriteria();
		//已经受理的信息在AcceptState不为空
		criteria.andAcceptStateIsNotNull();
		return viewFixMapper.selectByExample(example);
	}
	
	/**
	 * 获取全部待审核的维修信息
	 * 获取条件IsOver为0，FixState为“待审核”，AcceptState为“通过”
	 * @return
	 */
	public List<ViewFix> getAgreeUntil() {
		ViewFixExample example = new ViewFixExample();
		Criteria criteria = example.createCriteria();
		criteria.andFixStateEqualTo("待审核");
		criteria.andAcceptStateEqualTo("通过");
		return viewFixMapper.selectByExample(example);
	}
	
	
	/**
	 * 获取全部的已审核的维修信息
	 * @return
	 */
	public List<ViewFix> getAgreeHasBeen() {
		ViewFixExample example = new ViewFixExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsOverEqualTo(true);
		//已经审核的信息在AgreeState不为空
		criteria.andAgreeStateIsNotNull();
		return viewFixMapper.selectByExample(example);
	}
	
	/**
	 * 获取全部未定价，未结算的维修信息
	 * @return
	 */
	public List<ViewFix> getManagement() {
		ViewFixExample example = new ViewFixExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsCheckEqualTo(false);
		criteria.andPriceTimeIsNull();
		return viewFixMapper.selectByExample(example);
	}
}

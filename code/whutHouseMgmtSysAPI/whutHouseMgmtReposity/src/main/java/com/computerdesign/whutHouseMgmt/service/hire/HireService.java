package com.computerdesign.whutHouseMgmt.service.hire;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.hire.common.Hire;
import com.computerdesign.whutHouseMgmt.bean.hire.common.HireExample;
import com.computerdesign.whutHouseMgmt.bean.hire.common.HireExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.hire.HireMapper;

@Service
public class HireService {

	@Autowired
	private HireMapper hireMapper;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Hire getHireById(Integer id) {
		return hireMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 根据staffId获取hire信息
	 * @param staffId
	 * @return
	 */
	public List<Hire> getByStaffId(Integer staffId) {
		HireExample example = new HireExample();
		Criteria criteria = example.createCriteria();
		criteria.andStaffIdEqualTo(staffId);
		criteria.andIsOverEqualTo(false);
		return hireMapper.selectByExample(example);
	}
	
	/**
	 * 增加一个Hire
	 * @param hire
	 */
	public void add(Hire hire) {
		hireMapper.insertSelective(hire);
	}
	
	/**
	 * 修改一个Hire
	 * @param hire
	 */
	public void update(Hire hire){
		hireMapper.updateByPrimaryKeySelective(hire);
	}
	
	/**
	 * 严格的修改一个hire
	 * @param hire
	 */
	public void updateStrict(Hire hire) {
		hireMapper.updateByPrimaryKey(hire);
	}
}

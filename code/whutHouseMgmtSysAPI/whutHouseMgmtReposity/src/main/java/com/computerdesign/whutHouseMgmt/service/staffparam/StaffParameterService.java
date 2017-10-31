package com.computerdesign.whutHouseMgmt.service.staffparam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.staffparam.StaffParameter;
import com.computerdesign.whutHouseMgmt.dao.staffparam.StaffParameterMapper;
import com.computerdesign.whutHouseMgmt.service.base.BaseService;

@Service
public class StaffParameterService implements BaseService<StaffParameter> {
	
	@Autowired
	StaffParameterMapper staffParameterMapper;
	
	/**
	 * 获取一个staffParameter对象
	 * @return
	 */
	public StaffParameter get(Integer staffParamId){
		return staffParameterMapper.selectByPrimaryKey(staffParamId);
	}

	@Override
	public List<StaffParameter> getAll() {
		List<StaffParameter> empParams = staffParameterMapper.selectByExample(null);
	
		return empParams;
	}

	@Override
	public void delete(Integer staffParamId) {
		staffParameterMapper.deleteByPrimaryKey(staffParamId);
	}

	@Override
	public void add(StaffParameter staffParameter) {
		staffParameterMapper.insertSelective(staffParameter);
	}

	@Override
	public void update(StaffParameter staffParameter) {
		staffParameterMapper.updateByPrimaryKeySelective(staffParameter);
		
	}
	


}

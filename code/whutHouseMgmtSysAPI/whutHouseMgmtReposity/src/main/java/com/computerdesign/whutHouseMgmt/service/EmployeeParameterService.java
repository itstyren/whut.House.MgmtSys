package com.computerdesign.whutHouseMgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.EmployeeParameter;
import com.computerdesign.whutHouseMgmt.dao.EmployeeParameterMapper;
import com.computerdesign.whutHouseMgmt.service.impl.BaseService;

@Service
public class EmployeeParameterService implements BaseService<EmployeeParameter> {
	
	@Autowired
	EmployeeParameterMapper employeeParameterMapper;
	
	/**
	 * 获取一个EmployeeParameter对象
	 * @return
	 */
	public EmployeeParameter get(Integer employeeParamId){
		return employeeParameterMapper.selectByPrimaryKey(employeeParamId);
	}

	@Override
	public List<EmployeeParameter> getAll() {
		List<EmployeeParameter> empParams = employeeParameterMapper.selectByExample(null);
	
		return empParams;
	}

	@Override
	public void delete(Integer employeeParamId) {
		employeeParameterMapper.deleteByPrimaryKey(employeeParamId);
	}

	@Override
	public void add(EmployeeParameter employeeParameter) {
		employeeParameterMapper.insertSelective(employeeParameter);
	}

	@Override
	public void update(EmployeeParameter employeeParameter) {
		employeeParameterMapper.updateByPrimaryKeySelective(employeeParameter);
		
	}
	


}

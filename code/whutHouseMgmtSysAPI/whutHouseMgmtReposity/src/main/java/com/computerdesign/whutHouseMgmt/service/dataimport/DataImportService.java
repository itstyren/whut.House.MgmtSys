package com.computerdesign.whutHouseMgmt.service.dataimport;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.staffmanagement.Staff;
import com.computerdesign.whutHouseMgmt.bean.staffparam.StaffParameter;
import com.computerdesign.whutHouseMgmt.bean.staffparam.StaffParameterExample;
import com.computerdesign.whutHouseMgmt.bean.staffparam.StaffParameterExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.staffmanagement.StaffMapper;
import com.computerdesign.whutHouseMgmt.dao.staffparam.StaffParameterMapper;

@Service
public class DataImportService {

	@Autowired
	private StaffMapper staffMapper;
	
	@Autowired
	private StaffParameterMapper staffParameterMapper;
	
	/**
	 * 根据职工参数名称获取职工参数id(Excel表中传入名称，数据库存入id)
	 * @param staffParamName
	 * @return
	 */
	public Integer getStaffParamId(String staffParamName){
		StaffParameterExample example = new StaffParameterExample();
		Criteria criteria= example.createCriteria();
		criteria.andStaffParamNameEqualTo(staffParamName);
		criteria.andIsDeleteEqualTo(false);
		StaffParameter staffParameter = staffParameterMapper.selectByExample(example).get(0);
		return staffParameter.getStaffParamId();
	}
	
//	//批量插入
//	public void batchInsertStaff(List<Staff> list){
//		staffMapper.batchInsertSelective(list);
//	}
	
	public void insertStaff(Staff staff){
		staffMapper.insertSelective(staff);
	}
	
}

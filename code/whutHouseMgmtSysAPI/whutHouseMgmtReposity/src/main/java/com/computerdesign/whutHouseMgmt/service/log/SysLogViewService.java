package com.computerdesign.whutHouseMgmt.service.log;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.log.SysLogCondition;
import com.computerdesign.whutHouseMgmt.bean.log.ViewSysLog;
import com.computerdesign.whutHouseMgmt.bean.log.ViewSysLogExample;
import com.computerdesign.whutHouseMgmt.bean.log.ViewSysLogExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.log.ViewSysLogMapper;

@Service
public class SysLogViewService {

	@Autowired
	private ViewSysLogMapper viewSysLogMapper;
	
	//获取所有的日志记录
	public List<ViewSysLog> getAll(){
		ViewSysLogExample example = new ViewSysLogExample();
		Criteria criteria = example.createCriteria();
		return viewSysLogMapper.selectByExample(example);
	}
	
	//多条件查询日志记录
	public List<ViewSysLog> getByMultiCondition(SysLogCondition sysLogCondition){
		ViewSysLogExample example = new ViewSysLogExample();
		Criteria criteria = example.createCriteria();
		example.setOrderByClause("OperateTime DESC");
		if(sysLogCondition.getStaffNo() != null){
			criteria.andStaffNoEqualTo(sysLogCondition.getStaffNo());
		}
		if(sysLogCondition.getStaffName() != null){
			criteria.andStaffNameEqualTo(sysLogCondition.getStaffName());
		}
		if(sysLogCondition.getRole() != null){
			criteria.andRoleEqualTo(sysLogCondition.getRole());
		}
		if(sysLogCondition.getStartTime() != null){
			criteria.andOperateTimeGreaterThanOrEqualTo(sysLogCondition.getStartTime());
		}
		if(sysLogCondition.getEndTime() != null){
			criteria.andOperateTimeLessThanOrEqualTo(sysLogCondition.getEndTime());
		}
		if(sysLogCondition.getOperateType() != null){
			criteria.andOperateTypeEqualTo(sysLogCondition.getOperateType());
		}
		return viewSysLogMapper.selectByExample(example);
	}
	
}

package com.computerdesign.whutHouseMgmt.service.log;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.log.SysLog;
import com.computerdesign.whutHouseMgmt.bean.log.SysLogExample;
import com.computerdesign.whutHouseMgmt.bean.log.SysLogExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.log.SysLogMapper;

@Service
public class SysLogService {

	@Autowired
	private SysLogMapper sysLogMapper;
	
//	获取所有日志记录
	public List<SysLog> getAll(){
		SysLogExample example = new SysLogExample();
		Criteria criteria = example.createCriteria();
		return sysLogMapper.selectByExample(example);
	}
	
//	删除一条日志
	public void delete(Integer id){
		sysLogMapper.deleteByPrimaryKey(id);
	}
	
	//更新记录
	public void update(SysLog sysLog){
		sysLogMapper.updateByPrimaryKeySelective(sysLog);
	}
	
	//添加一条记录
	public void insert(SysLog sysLog){
		sysLogMapper.insertSelective(sysLog);
	}
	
//	批量删除
	public void deleteBitch(List<Integer> ids){
		SysLogExample example = new SysLogExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIn(ids);
		sysLogMapper.deleteByExample(example);
	}
}
